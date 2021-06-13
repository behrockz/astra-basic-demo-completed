package com.datastax.devWorkshop.rest;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws URISyntaxException, ExecutionException, InterruptedException, JsonProcessingException {
        Client c = new Client();
        c.insert("{\"name\":\"Jim\",\"surname\":\"Morrison\",\"id\":2}", "rockstar").get();
        System.out.println(c.get("rockstar", 1).get());
        System.out.println(c.get("rockstar", 2).get());
    }
}