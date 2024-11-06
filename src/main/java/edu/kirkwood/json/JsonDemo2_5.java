package edu.kirkwood.json;
import com.google.gson.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.lang.reflect.Type;
import java.time.Instant;
import java.util.Arrays;

public class JsonDemo2_5 {
    private static final String API_URL = "https://randomuser.me/api/?format=json&seed=abc&results=5&nat=us";

    public static void main(String[] args) throws Exception {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(API_URL)
                .build();

        Response response = client.newCall(request).execute();
        String responseBody = response.body().string();
//        System.out.println(responseBody);
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Instant.class, new InstantDeserializer())
                .create();
        APIResponse apiResponse = null;
        try {
            apiResponse = gson.fromJson(responseBody, APIResponse.class);
        } catch(JsonSyntaxException e) {
            System.out.println("ERROR: " + e.getMessage());
            System.exit(0);
        }
        Person[] people = apiResponse.results;
        Arrays.sort(people);
        for(Person person: people) {
            System.out.println(person.name.first + " " + person.name.last);
            System.out.printf("%d %s\n", person.location.street.number, person.location.street.name);
            System.out.printf("%s, %s %s\n", person.location.city, person.location.state, person.location.postcode);
            System.out.printf("Latitude: %.4f, Longitude: %.4f\n", person.location.coordinates.latitude, person.location.coordinates.longitude);
            System.out.println(person.email);
            System.out.printf("Born %s\n", person.dob.date);
            System.out.println();
        }
    }

    private static class InstantDeserializer implements JsonDeserializer<Instant> {
        @Override
        public Instant deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
            return Instant.parse(json.getAsString());
        }
    }

    private static class APIResponse {
        private Person[] results;
    }

    private static class Person implements Comparable<Person> {
        private Name name;
        private Location location;
        private String email;
        private DateOfBirth dob;

        @Override
        public int compareTo(Person o) {
            int result = this.name.last.compareTo(o.name.last);
            if (result == 0) {
                result = this.name.first.compareTo(o.name.first);
            }
            return result;
        }
    }

    private static class Name {
        private String first;
        private String last;
    }

    private static class Location {
        private Street street;
        private String city;
        private String state;
        private int postcode;
        private Coordinates coordinates;
    }

    private static class Street {
        private int number;
        private String name;
    }

    private static class Coordinates {
        private double latitude;
        private double longitude;
    }

    private static class DateOfBirth {
        private Instant date;
    }
}
