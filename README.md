# CampusCareWithAIMatcher

Lost & Found Management System with AI-based Auto Matching and 3 Role-Based Dashboards.

### Architecture Overview

This project follows a standard Java Mini Project layered architecture:

**FRONTEND**
- JavaFX for UI

**BACKEND**
- Core Java
    - OOP - Entity classes (User, Item, Claim)
    - Collections - List management for lost/found items
- Data Structures - For searching and filtering
- Artificial Intelligence - For auto matching logic

**APPLICATION LOGIC**
- Combines OOP, Collections, and AI to process user actions
- Handles 3 Dashboards: Admin, Student, Staff

**ALGORITHMS -> JDBC -> DATABASE**
- Algorithms: Cosine Similarity for text matching, Image hashing for image matching
- JDBC: Database connectivity
- MySQL / MS Access: Persistent storage

**Flow:**
JavaFX (UI) -> Core Java (OOP + Collections) + AI -> Application Logic -> Algorithms -> JDBC -> MySQL

### Modules

**1. Admin Dashboard**
- View stats, manage users, approve claims

**2. Student Dashboard**
- Report lost items, browse found items, get AI suggestions

**3. Staff Dashboard**
- Add found items, verify claims, manage inventory

**4. AI Matcher Module**
- Matches lost item description with found items
- Notifies on >80% match

### Tech Stack
- Java 17, JavaFX, FXML
- Core Java, OOP, Collections, Data Structures
- Artificial Intelligence, Algorithms
- JDBC, MySQL, Maven

### How to Run
1. Clone the repo
2. Open `campuscure-with-ai-matcher` in IntelliJ
3. Setup MySQL database with database.sql
4. Update DB credentials in DatabaseConfig.java
5. Run Main.java
