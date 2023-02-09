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

        GeneratePokemonTeam generatePokemonTeam = new GeneratePokemonTeam();
        JSONObject[] myPokemonTeam = new JSONObject[6];
        Scanner s = new Scanner (System.in);

        String decision;

        boolean promptUser = true;
        while(promptUser)
        {
            System.out.println("Generating your team...");
            generatePokemonTeam.generatePokemonTeam(myPokemonTeam);
            for(int i=0; i<6; i++){
                System.out.println("Pokemon #" + (i+1) + ": " + myPokemonTeam[i].get("pokemonName"));
            }
            System.out.println("Would you like to generate a new team? (y/n)\n");
            decision = s.nextLine();


            switch(decision)
            {
                case "y":
                    promptUser = true;
                    break;

                case "n":
                    promptUser = false;
                    System.out.println("Goodluck on your adventure!");
                    break;

                default:
                        System.out.println("Rerun the program enter in a valid input\n");
                    promptUser = false;
                    break;

            }
        }
    }

    }
