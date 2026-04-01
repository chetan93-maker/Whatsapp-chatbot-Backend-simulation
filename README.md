# 🤖 WhatsApp Chatbot Backend Simulation

> A REST API built with Java and Spring Boot that simulates a WhatsApp chatbot backend. Accepts incoming messages via webhook, responds with predefined replies, and logs all messages.

---

## 📋 Table of Contents

- ##Features
- 🛠️ Technology Stack](#-technology-stack)
- 📁 Project Structure](#-project-structure)
- 🔗 API Endpoints](#-api-endpoints)
- 📥 Request Format](#-request-format)
- 📤 Response Format](#-response-format)
- 💬 Predefined Responses](#-predefined-responses)
- 🚀 How to Run Locally](#-how-to-run-locally)
- 🧪 Testing with cURL](#-testing-with-curl)
- 📸 Screenshots](#-screenshots)
- 👨‍💻 Author](#-author)

---

## ✨ Features

| Feature | Description |
|---------|-------------|
| 🔌 REST API | Exposes `/webhook` endpoint to receive POST requests |
| 📨 JSON Handling | Accepts JSON payloads simulating WhatsApp messages |
| 💬 Smart Replies | Responds with appropriate messages based on input |
| 📝 Message Logging | Logs all incoming messages with timestamps |
| ❤️ Health Check | Provides health check endpoint for monitoring |
| 🛡️ Error Handling | Gracefully handles invalid or empty messages |

---

## 🛠️ Technology Stack

| Technology | Version | Purpose |
|------------|---------|---------|
| ☕ Java | 17 | Programming language |
| 🍃 Spring Boot | 3.2.4 | Application framework |
| 📦 Maven | 3.x | Build automation |
| 📝 SLF4J | - | Logging framework |

---

## 📁 Project Structure
whatsapp-chatbot/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/
│ │ │ └── jaruracare/
│ │ │ └── whatsappchatbot/
│ │ │ ├── 📄 WhatsappChatbotApplication.java
│ │ │ ├── 🎮 controller/
│ │ │ │ └── WebhookController.java
│ │ │ ├── 📦 dto/
│ │ │ │ ├── MessageRequest.java
│ │ │ │ └── MessageResponse.java
│ │ │ └── ⚙️ service/
│ │ │ └── ChatbotService.java
│ │ └── resources/
│ │ └── ⚙️ application.properties
│ └── test/
├── 📄 pom.xml
└── 📖 README.md

text

---

## 🔗 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| 📨 POST | `/webhook` | Process incoming message and return reply |
| 🔍 GET | `/webhook` | Verify webhook is accessible |
| ❤️ GET | `/webhook/health` | Health check endpoint |

---

## 📥 Request Format

```json
{
  "message": "Hi",
  "from": "+919876543210",
  "timestamp": 1743500000000
}
Field	Type	Required	Description
message	String	✅ Yes	The incoming message text
from	String	❌ No	Sender's phone number
timestamp	Long	❌ No	Message timestamp in milliseconds
📤 Response Format
✅ Success Response (200 OK)

json
{
  "reply": "Hello! How can I help you?",
  "status": "success",
  "timestamp": 1743500000000
}
❌ Error Response (500 Internal Server Error)

json
{
  "reply": "An error occurred while processing your request.",
  "status": "error",
  "timestamp": 1743500000000
}
💬 Predefined Responses
👤 Incoming Message	🤖 Bot Response
Hi	Hello! How can I help you?
Hello	Hi there! Welcome to Jarurat Care.
Bye	Goodbye! Have a great day!
Goodbye	Thank you for reaching out. Goodbye!
Help	I can assist you with basic queries. Try saying 'Hi' or 'Bye'.
Thanks	You're welcome! Let me know if you need anything else.
Thank you	You're welcome! Happy to help.
*any other message*	I'm sorry, I didn't understand that. Please try saying 'Hi' or 'Help'.
🚀 How to Run Locally
Prerequisites
☕ Java JDK 17 or higher

📦 Maven 3.x

🖥️ Git (optional)

Step-by-Step Setup
bash
# 1️⃣ Clone the repository
git clone https://github.com/your-username/whatsapp-chatbot.git

# 2️⃣ Navigate to project directory
cd whatsapp-chatbot

# 3️⃣ Build the project
mvn clean install

# 4️⃣ Run the application
mvn spring-boot:run
✅ Verify Application is Running
Open your browser and navigate to:

text
http://localhost:8080/webhook/health
You should see: Service is healthy and running

🧪 Testing with cURL
bash
# 📨 Send Hi message
curl -X POST http://localhost:8080/webhook \
  -H "Content-Type: application/json" \
  -d '{"message": "Hi"}'

# 💬 Send Bye message
curl -X POST http://localhost:8080/webhook \
  -H "Content-Type: application/json" \
  -d '{"message": "Bye"}'

# 🆘 Send Help message
curl -X POST http://localhost:8080/webhook \
  -H "Content-Type: application/json" \
  -d '{"message": "Help"}'

# ❤️ Health check
curl http://localhost:8080/webhook/health

# 🔍 Verify webhook
curl http://localhost:8080/webhook
📸 Screenshots
Postman Testing
Test Case	Screenshot
POST - Hi Message	📷 Add screenshot here
POST - Bye Message	📷 Add screenshot here
GET - Health Check	📷 Add screenshot here
Console Logs
Description	Screenshot
Application Startup	📷 Add screenshot here
Incoming Message Logs	📷 Add screenshot here
📝 Sample Log Output
text
2026-04-01 10:30:15 - Received webhook request: MessageRequest{message='Hi', from='null', timestamp=null}
2026-04-01 10:30:15 - === Incoming Message ===
2026-04-01 10:30:15 - From: Unknown
2026-04-01 10:30:15 - Message: Hi
2026-04-01 10:30:15 - Timestamp: 2026-04-01T05:00:15.123Z
2026-04-01 10:30:15 - ========================
2026-04-01 10:30:15 - Processing message: hi
2026-04-01 10:30:15 - Generated reply: Hello! How can I help you?
🚢 Deployment
Local Deployment
bash
java -jar target/whatsapp-chatbot-1.0.0.jar
Cloud Deployment (Render)
Push code to GitHub repository

Create a new Web Service on Render

Connect your GitHub repository

Configure build settings:

Build Command: ./mvnw package

Start Command: java -jar target/*.jar

Click Deploy

🔮 Future Enhancements
Integrate with WhatsApp Business API

Add database persistence for message history

Implement natural language processing

Add user session management

Support for multimedia messages

Admin dashboard for monitoring

👨‍💻 Author
Name	[Your Name]
Assignment	Java Developer Internship – Jarurat Care
Date	April 2026
GitHub	your-username
🙏 Acknowledgments
Jarurat Care for providing this internship opportunity

Spring Boot documentation and community

Open source contributors

📄 License
This project is developed for educational and assignment purposes.

