package com.jaruratcare.whatsappchatbot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageResponse {
    
    @JsonProperty("reply")
    private String reply;
    
    @JsonProperty("status")
    private String status;
    
    @JsonProperty("timestamp")
    private Long timestamp;
    
    public MessageResponse() {
    }
    
    public MessageResponse(String reply, String status, Long timestamp) {
        this.reply = reply;
        this.status = status;
        this.timestamp = timestamp;
    }
    
    public String getReply() {
        return reply;
    }
    
    public void setReply(String reply) {
        this.reply = reply;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public Long getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
    
    @Override
    public String toString() {
        return "MessageResponse{" +
                "reply='" + reply + '\'' +
                ", status='" + status + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}