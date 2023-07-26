package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Main{
    public static void main(String[] args) {
        try {
            URL url = new URL("https://api.zippopotam.us/us/33162");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            System.out.println(response.toString());
//            int i;
//            for( i=0; i<s.length(); i++) {
//                if (s.charAt(i)=='v' && s.charAt(i+1)=='a' && s.charAt(i+2)=='l' && s.charAt(i+3)=='u' && s.charAt(i+4)=='e')
//                {
//                    i=i+8;
//                    break;
//                }
//            }
//            System.out.println();
//            for(int j=i; j<s.length()-2; j++)
//            {
//                System.out.print(s.charAt(j));
//            }


            connection.disconnect();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}