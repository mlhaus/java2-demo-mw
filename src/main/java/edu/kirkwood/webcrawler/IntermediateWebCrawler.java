package edu.kirkwood.webcrawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class IntermediateWebCrawler {
    public static void main(String[] args) {
        String urlString = "https://www.espn.com/sportsnation/story/_/id/14734617/ranking-every-air-jordan-sneaker-1-xx9";
        String pageContent = getPageContent(urlString);
//        System.out.println(pageContent);
        List<Shoe> shoes = getShoes(pageContent);
        shoes.forEach(System.out::println);
    }

    public static List<Shoe> getShoes(String pageContent) {
        List<Shoe> shoes = new ArrayList();
        int indexStartH2 = pageContent.indexOf("<h2>");
        while(indexStartH2 >= 0) {
            Shoe shoe = new Shoe();

            // Get Ranking
            int indexStartRanking = indexStartH2 + 4;
            int indexEndRanking = pageContent.indexOf(".", indexStartRanking);
            int ranking = Integer.parseInt(pageContent.substring(indexStartRanking, indexEndRanking));
//            System.out.println(ranking);
            shoe.setRanking(ranking);

            // Get Title
            int indexStartTitle = indexEndRanking + 2;
            int indexEndTitle = pageContent.indexOf("</h2>", indexStartTitle);
            String title = pageContent.substring(indexStartTitle, indexEndTitle);
//            System.out.println(title);
            shoe.setTitle(title);

            // Get Image
            int indexStartImage = pageContent.indexOf("https", indexEndTitle);
            int indexEndImage = pageContent.indexOf(".jpg", indexEndTitle) + 4;
            String image = pageContent.substring(indexStartImage, indexEndImage);
//            System.out.println(image);
            shoe.setImage(image);
            
            shoes.add(shoe);

            indexStartH2 = pageContent.indexOf("<h2>", indexStartH2 + 1);
        }
        return shoes;
    }

    public static String getPageContent(String urlString) {
        String pageContent = "";
        try {
            URL url = new URL(urlString);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while((line = br.readLine()) != null) {
                pageContent += line;
            }
        } catch(MalformedURLException e) {
            System.out.println("Invalid URL");
        } catch(IOException e) {

        }
        return pageContent;
    }
}

class Shoe {
    private int ranking;
    private String title;
    private String image;

    public Shoe() {
    }

    public Shoe(int ranking, String title, String image) {
        this.ranking = ranking;
        this.title = title;
        this.image = image;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Shoe{" +
                "ranking=" + ranking +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}











