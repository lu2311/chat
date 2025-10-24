package com.semana11.chat.model;

public class OutputMessage {
    private String from;
    private String text;
    private String time;

    public OutputMessage(String from, String text) {
        this.from = from;
        this.text = text;
        this.time = java.time.LocalTime.now().toString();
    }

    public String getFrom() {
        return from;
    }

    public String getText() {
        return text;
    }

    public String getTime() {
        return time;
    }

    
}
