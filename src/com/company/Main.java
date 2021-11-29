package com.company;


import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


import org.json.*;



public class Main {


    public static void main(String[] args) throws IOException, InterruptedException {
        // write your code here
        try{
        Scanner s = new Scanner(System.in);
        System.out.println("\n" +
                "███████╗███╗░░██╗████████╗███████╗██████╗░  ░█████╗░    ░██╗░░░░░░░██╗░█████╗░██████╗░██████╗░\n" +
                "██╔════╝████╗░██║╚══██╔══╝██╔════╝██╔══██╗  ██╔══██╗    ░██║░░██╗░░██║██╔══██╗██╔══██╗██╔══██╗\n" +
                "█████╗░░██╔██╗██║░░░██║░░░█████╗░░██████╔╝  ███████║    ░╚██╗████╗██╔╝██║░░██║██████╔╝██║░░██║\n" +
                "██╔══╝░░██║╚████║░░░██║░░░██╔══╝░░██╔══██╗  ██╔══██║    ░░████╔═████║░██║░░██║██╔══██╗██║░░██║\n" +
                "███████╗██║░╚███║░░░██║░░░███████╗██║░░██║  ██║░░██║    ░░╚██╔╝░╚██╔╝░╚█████╔╝██║░░██║██████╔╝\n" +
                "╚══════╝╚═╝░░╚══╝░░░╚═╝░░░╚══════╝╚═╝░░╚═╝  ╚═╝░░╚═╝    ░░░╚═╝░░░╚═╝░░░╚════╝░╚═╝░░╚═╝╚═════╝░");
        String word = s.nextLine();
        String rawUrl = "https://api.dictionaryapi.dev/api/v2/entries/en/"+word;
        s.close();
        var url = rawUrl;
        var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
        var client = HttpClient.newBuilder().build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String result = response.body().toString();
        /* * * JSONArray  Created  * * */
        JSONArray jsonArray = new JSONArray(result);

        /* * * Object Created * * */
        JSONObject jsonObject1 = jsonArray.getJSONObject(0);
            System.out.println("\n");
            System.out.println("=====Word=====\n" + jsonObject1.get("word"));
            System.out.println("\n");
            System.out.println("=====Origin=====\n" + jsonObject1.get("origin"));
            System.out.println("\n");
            System.out.println("=====Part Of Speech=====\n" + jsonObject1.getJSONArray("meanings").getJSONObject(0).get("partOfSpeech"));
            System.out.println("\n");
            System.out.println("=====Definition=====\n"+jsonObject1.getJSONArray("meanings").getJSONObject(0).getJSONArray("definitions").getJSONObject(0).get("definition"));
            System.out.println("\n");
            System.out.println("=====Definition=====\n"+jsonObject1.getJSONArray("meanings").getJSONObject(0).getJSONArray("definitions").getJSONObject(1).get("definition"));

        }catch (JSONException e){
            System.out.println("Please Enter Correct Keyword");
            System.out.println("Abort.....");
        }catch (ConnectException e){
                System.out.println("Check Your Internet Connection");
                System.out.println("Abort.....");
            }
        }
    }

