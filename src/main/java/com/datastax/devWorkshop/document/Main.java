package com.datastax.devWorkshop.document;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws URISyntaxException, JsonProcessingException, ExecutionException, InterruptedException {
        Client c = new Client();
        c.insert("{\"SuperGroupName\":\"Travelling Wilbury\",\"members\":\"Bob, George, Tom\",\"id\":1}", "myCollection", 1).get();
        c.insert("{\"GuitarGod\":\"Slash\",\"id\":2}", "myCollection", 2).get();
        c.insert("{\"GuitarGodName\":\"Jeff\",\"Surname\":\"Beck\",\"id\":3}", "myCollection", 3).get();
        System.out.println(c.get("myCollection", 1).get());
        System.out.println(c.get("myCollection", 2).get());
        System.out.println(c.get("myCollection", 3).get());
    }
}