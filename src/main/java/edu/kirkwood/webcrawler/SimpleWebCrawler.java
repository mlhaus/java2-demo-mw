package edu.kirkwood.webcrawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class SimpleWebCrawler {
    public static void main(String[] args) {
//        String urlString = "https://www.kirkwood.edu";

         String urlString = String.format("https://graphical.weather.gov/"
                 + "xml/sample_products/browser_interface/ndfdXMLclient.php?"
                 + "lat=41.911150&lon=-91.652149&product=time-series&"
                 + "begin=%s&end=%s&maxt=maxt&mint=mint", LocalDateTime.now().with(LocalTime.MIN), LocalDateTime.now().with(LocalTime.MAX));
        try {
            URL url = new URL(urlString);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch(MalformedURLException e) {
            System.out.println("Invalid URL");
        } catch(IOException e) {

        }
    }
}
