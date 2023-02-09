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

        System.out.println(generatePokemonTeam.generatePokemonTeam());
    }

    }
