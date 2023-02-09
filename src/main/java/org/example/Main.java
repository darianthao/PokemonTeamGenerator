package org.example;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        RandomIntegerGenerator random = new RandomIntegerGenerator();
        String[] myPokemonTeam = new String[6];

        for (int i = 0; i < 6; i++) {

        int pokemonId = random.getRandomNumberUsingInts();


        try {
            //Public API:
            //https://www.metaweather.com/api/location/search/?query=<CITY>
            //https://www.metaweather.com/api/location/44418/

            URL url = new URL("https://pokeapi.co/api/v2/pokemon/" + pokemonId);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Check if connect is made
            int responseCode = conn.getResponseCode();

            // 200 OK
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {


                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                //Close the scanner
                scanner.close();

                //      System.out.println(informationString);

                // Parse through pokemonObject and convert it into a JSONObject
                JSONParser parse = new JSONParser();
                JSONObject pokemonObject = (JSONObject) parse.parse(String.valueOf(informationString));

                String pokemonName = pokemonObject.get("name").toString();

                myPokemonTeam[i] = pokemonName;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        System.out.println(Arrays.toString(myPokemonTeam));
    }

    }
