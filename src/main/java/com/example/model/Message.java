package com.example.model;

public class Message {

    private final long id;
    private final String body;

    public Message(long id, String body) {
        this.id = id;
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public String getBody() {
        return body;
    }
}
