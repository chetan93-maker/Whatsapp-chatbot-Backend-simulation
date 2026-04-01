package com.jaruratcare.whatsappchatbot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageRequest {
    
    @JsonProperty("message")
    private String message;
    
    @JsonProperty("from")
    private String from;
    
    @JsonProperty("timestamp")
    private Long timestamp;
    
    public MessageRequest() {
    }
    
    public MessageRequest(String message, String from, Long timestamp) {
        this.message = message;
        this.from = from;
        this.timestamp = timestamp;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getFrom() {
        return from;
    }
    
    public void setFrom(String from) {
        this.from = from;
    }
    
    public Long getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
    
    @Override
    public String toString() {
        return "MessageRequest{" +
                "message='" + message + '\'' +
                ", from='" + from + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}