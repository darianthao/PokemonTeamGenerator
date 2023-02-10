package org.example;

import org.json.simple.JSONObject;

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
                System.out.println("Pokedex #" + myPokemonTeam[i].get("pokedexId"));
                System.out.println("Weight: " + myPokemonTeam[i].get("weight") + " lbs");

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
                    System.out.println("Goodluck on your Pokemon adventure!");
                    break;

                default:
                        System.out.println("Rerun the program enter in a valid input\n");
                    promptUser = false;
                    break;

            }
        }
    }

    }
