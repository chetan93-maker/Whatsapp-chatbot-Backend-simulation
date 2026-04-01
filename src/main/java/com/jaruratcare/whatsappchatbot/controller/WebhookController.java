package com.jaruratcare.whatsappchatbot.controller;

import com.jaruratcare.whatsappchatbot.dto.MessageRequest;
import com.jaruratcare.whatsappchatbot.dto.MessageResponse;
import com.jaruratcare.whatsappchatbot.service.ChatbotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;

@RestController
@RequestMapping("/webhook")
public class WebhookController {
    
    private static final Logger logger = LoggerFactory.getLogger(WebhookController.class);
    
    private final ChatbotService chatbotService;
    
    public WebhookController(ChatbotService chatbotService) {
        this.chatbotService = chatbotService;
    }
    
    @PostMapping
    public ResponseEntity<MessageResponse> handleMessage(@RequestBody MessageRequest request) {
        try {
            logger.info("Received webhook request: {}", request);
            
            String incomingMessage = request.getMessage();
            String from = request.getFrom();
            Long timestamp = request.getTimestamp();
            
            chatbotService.logIncomingMessage(incomingMessage, from, timestamp);
            
            String replyMessage = chatbotService.generateReply(incomingMessage);
            
            MessageResponse response = new MessageResponse(
                replyMessage,
                "success",
                Instant.now().toEpochMilli()
            );
            
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            logger.error("Error processing webhook request", e);
            
            MessageResponse errorResponse = new MessageResponse(
                "An error occurred while processing your request. Please try again.",
                "error",
                Instant.now().toEpochMilli()
            );
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(errorResponse);
        }
    }
    
    @GetMapping
    public ResponseEntity<String> verifyWebhook() {
        logger.info("Webhook verification endpoint accessed");
        return ResponseEntity.ok("WhatsApp Chatbot is running successfully!");
    }
    
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Service is healthy and running");
    }
}