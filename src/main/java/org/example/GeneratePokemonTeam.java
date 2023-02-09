package org.example;

import org.json.simple.parser.JSONParser;
import org.json.simple.*;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class GeneratePokemonTeam {

    public GeneratePokemonTeam() {
    }

    public JSONArray generatePokemonTeam(){
        RandomIntegerGenerator random = new RandomIntegerGenerator();
        JSONArray myActualPokemonTeam = new JSONArray();

        for (int i = 0; i < 6; i++) {
            JSONObject myPokemonData = new JSONObject();
            int pokemonId = random.getRandomNumberUsingInts();

            try {
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

                    // Parse through pokemonObject and convert it into a JSONObject
                    JSONParser parse = new JSONParser();
                    JSONObject pokemonObject = (JSONObject) parse.parse(String.valueOf(informationString));

                    // Stores only the Data I want for my Pokemon
                    myPokemonData.put("pokemonName", pokemonObject.get("name"));
                    myPokemonData.put("pokedexId", pokemonObject.get("id"));
                    myActualPokemonTeam.add(myPokemonData.get("pokemonName"));
                    myActualPokemonTeam.add(myPokemonData.get("pokedexId"));


                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        return myActualPokemonTeam;
    }
}
