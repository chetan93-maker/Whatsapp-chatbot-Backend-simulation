package com.jaruratcare.whatsappchatbot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ChatbotService {
    
    private static final Logger logger = LoggerFactory.getLogger(ChatbotService.class);
    
    private static final Map<String, String> PREDEFINED_RESPONSES = new ConcurrentHashMap<>();
    
    static {
        PREDEFINED_RESPONSES.put("hi", "Hello! How can I help you?");
        PREDEFINED_RESPONSES.put("hello", "Hi there! Welcome to Jarurat Care.");
        PREDEFINED_RESPONSES.put("bye", "Goodbye! Have a great day!");
        PREDEFINED_RESPONSES.put("goodbye", "Thank you for reaching out. Goodbye!");
        PREDEFINED_RESPONSES.put("help", "I can assist you with basic queries. Try saying 'Hi' or 'Bye'.");
        PREDEFINED_RESPONSES.put("thanks", "You're welcome! Let me know if you need anything else.");
        PREDEFINED_RESPONSES.put("thank you", "You're welcome! Happy to help.");
    }
    
    public String generateReply(String incomingMessage) {
        if (incomingMessage == null || incomingMessage.trim().isEmpty()) {
            logger.warn("Received empty or null message");
            return "I didn't receive any message. Please try again.";
        }
        
        String normalizedMessage = incomingMessage.trim().toLowerCase();
        logger.info("Processing message: {}", normalizedMessage);
        
        String reply = PREDEFINED_RESPONSES.getOrDefault(
            normalizedMessage, 
            "I'm sorry, I didn't understand that. Please try saying 'Hi' or 'Help' for assistance."
        );
        
        logger.info("Generated reply: {}", reply);
        return reply;
    }
    
    public void logIncomingMessage(String message, String from, Long timestamp) {
        logger.info("=== Incoming Message ===");
        logger.info("From: {}", from != null ? from : "Unknown");
        logger.info("Message: {}", message);
        logger.info("Timestamp: {}", timestamp != null ? Instant.ofEpochMilli(timestamp) : Instant.now());
        logger.info("========================");
    }
}