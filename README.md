# 🤖 WhatsApp Chatbot Backend Simulation

A REST API built with Java and Spring Boot that simulates a WhatsApp chatbot backend. Accepts incoming messages via webhook, responds with predefined replies, and logs all messages.

---

## 🚀 Live Deployment

The application is successfully deployed and live at:

**Base URL:** [https://whatsapp-chatbot-backend-simulation-jzk1.onrender.com](https://whatsapp-chatbot-backend-simulation-jzk1.onrender.com)

### Test Endpoints

| Endpoint | URL |
|----------|-----|
| Health Check | [https://whatsapp-chatbot-backend-simulation-jzk1.onrender.com/webhook/health](https://whatsapp-chatbot-backend-simulation-jzk1.onrender.com/webhook/health) |
| Webhook Verification | [https://whatsapp-chatbot-backend-simulation-jzk1.onrender.com/webhook](https://whatsapp-chatbot-backend-simulation-jzk1.onrender.com/webhook) |

---

## 📋 Table of Contents

- [Features](#features)
- [Technology Stack](#technology-stack)
- [Live Deployment](#live-deployment)
- [API Endpoints](#api-endpoints)
- [Request Format](#request-format)
- [Response Format](#response-format)
- [Predefined Responses](#predefined-responses)
- [How to Run Locally](#how-to-run-locally)
- [Testing with cURL](#testing-with-curl)
- [Deployment on Render](#deployment-on-render)
- [Project Structure](#project-structure)
- [Author](#author)

---

## ✨ Features

| Feature | Description |
|---------|-------------|
| REST API | Exposes /webhook endpoint to receive POST requests |
| JSON Handling | Accepts JSON payloads simulating WhatsApp messages |
| Smart Replies | Responds with appropriate messages based on input |
| Message Logging | Logs all incoming messages with timestamps |
| Health Check | Provides health check endpoint for monitoring |
| Error Handling | Gracefully handles invalid or empty messages |
| Docker Deployment | Containerized and deployed on Render |

---

## 🛠️ Technology Stack

| Technology | Version | Purpose |
|------------|---------|---------|
| Java | 17 | Programming language |
| Spring Boot | 3.2.4 | Application framework |
| Maven | 3.x | Build automation |
| Docker | Latest | Containerization |
| Render | - | Cloud deployment |

---

## 🔗 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /webhook | Process incoming message and return reply |
| GET | /webhook | Verify webhook is accessible |
| GET | /webhook/health | Health check endpoint |

---

## 📥 Request Format

```json
{
  "message": "Hi",
  "from": "+919876543210",
  "timestamp": 1743500000000
}
Field	Type	Required	Description
message	String	Yes	The incoming message text
from	String	No	Sender's phone number
timestamp	Long	No	Message timestamp in milliseconds
📤 Response Format
Success Response (200 OK)

json
{
  "reply": "Hello! How can I help you?",
  "status": "success",
  "timestamp": 1743500000000
}
Error Response (500 Internal Server Error)

json
{
  "reply": "An error occurred while processing your request.",
  "status": "error",
  "timestamp": 1743500000000
}
💬 Predefined Responses
Incoming Message	Bot Response
Hi	Hello! How can I help you?
Hello	Hi there! Welcome to Jarurat Care.
Bye	Goodbye! Have a great day!
Goodbye	Thank you for reaching out. Goodbye!
Help	I can assist you with basic queries. Try saying Hi or Bye.
Thanks	You're welcome! Let me know if you need anything else.
Thank you	You're welcome! Happy to help.
any other message	I'm sorry, I didn't understand that. Please try saying Hi or Help.
🚀 How to Run Locally
Prerequisites
Java JDK 17 or higher

Maven 3.x

Git (optional)

Steps
bash
# Clone the repository
git clone https://github.com/your-username/whatsapp-chatbot.git

# Navigate to project directory
cd whatsapp-chatbot

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
Verify
Open your browser and navigate to:

text
http://localhost:8080/webhook/health
You should see: Service is healthy and running

🧪 Testing with cURL
Health Check
bash
curl https://whatsapp-chatbot-backend-simulation-jzk1.onrender.com/webhook/health
Webhook Verification
bash
curl https://whatsapp-chatbot-backend-simulation-jzk1.onrender.com/webhook
Send Hi Message
bash
curl -X POST https://whatsapp-chatbot-backend-simulation-jzk1.onrender.com/webhook \
  -H "Content-Type: application/json" \
  -d '{"message": "Hi"}'
Send Bye Message
bash
curl -X POST https://whatsapp-chatbot-backend-simulation-jzk1.onrender.com/webhook \
  -H "Content-Type: application/json" \
  -d '{"message": "Bye"}'
Send Help Message
bash
curl -X POST https://whatsapp-chatbot-backend-simulation-jzk1.onrender.com/webhook \
  -H "Content-Type: application/json" \
  -d '{"message": "Help"}'
🚢 Deployment on Render
Dockerfile Used
dockerfile
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
Deployment Steps
Push code to GitHub repository

Create account on render.com

Click New Web Service

Connect GitHub repository

Select Docker as language

Choose Free plan

Click Create Web Service

Deployment Status
Item	Status
Build	✅ Successful
Deployment	✅ Live
URL	https://whatsapp-chatbot-backend-simulation-jzk1.onrender.com
📁 Project Structure
text
whatsapp-chatbot/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── jaruracare/
│   │   │           └── whatsappchatbot/
│   │   │               ├── WhatsappChatbotApplication.java
│   │   │               ├── controller/
│   │   │               │   └── WebhookController.java
│   │   │               ├── dto/
│   │   │               │   ├── MessageRequest.java
│   │   │               │   └── MessageResponse.java
│   │   │               └── service/
│   │   │                   └── ChatbotService.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── Dockerfile
├── pom.xml
└── README.md
📝 Sample Log Output
text
2026-04-01 10:05:53 - Starting WhatsappChatbotApplication v1.0.0 using Java 17.0.18
2026-04-01 10:06:12 - Tomcat initialized with port 8080
2026-04-01 10:06:15 - Root WebApplicationContext: initialization completed
2026-04-01 10:06:30 - Your service is live
👨‍💻 Author
Name	Your Name
Assignment	Java Developer Internship - Jarurat Care
Date	April 2026
GitHub	your-username
🙏 Acknowledgments
Jarurat Care for providing this internship opportunity

Spring Boot documentation and community

Render for free hosting

