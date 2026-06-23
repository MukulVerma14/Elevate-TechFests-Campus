# Knowledge Services Engagement Platform (KSEP)

A B2B matchmaking platform by **Millionminds** that connects campuses offering knowledge programmes (seminars, hackathons, workshops, symposiums) with corporates (startups & SMBs) looking to associate with them.

---

## 🧱 Tech Stack

| Layer | Technology |
|---|---|
| Backend | Java 17, Spring Boot 3, Spring Security, Spring Data JPA |
| Frontend | React 18, Vite, Tailwind CSS, Axios |
| Database | MySQL 8 |
| Auth | JWT (jjwt 0.11.5) |
| Email | Spring Boot Starter Mail (Gmail SMTP) |

---

## 🗂️ Project Structure

```
Knowledge-Service-Engagement-Platform/
├── src/                          # Spring Boot backend
│   └── main/
│       ├── java/com/example/ksep/
│       │   ├── configurations/   # Security, JWT, CORS config
│       │   ├── controllers/      # REST API controllers
│       │   ├── dto/              # Request/Response DTOs
│       │   ├── models/           # JPA entities
│       │   ├── repository/       # Spring Data JPA repositories
│       │   └── services/         # Business logic
│       └── resources/
│           └── application.properties
├── frontend/                     # React frontend
│   └── src/
│       ├── components/           # Navbar, Modal, Toast, ProtectedRoute
│       ├── context/              # AuthContext
│       ├── pages/                # Landing, Login, Register, Dashboards
│       └── services/             # Axios API service
└── build.gradle
```

---

## 👥 User Roles

| Role | Description |
|---|---|
| `CAMPUS` | Lists knowledge programmes, views corporate interest |
| `CORPORATE` | Browses programme pool, expresses interest, closes deals |
| `SUPER_ADMIN` | Views platform-wide stats, all programmes, deals, corporates |

---

## 🔌 API Overview

### Auth
```
POST /api/auth/register
POST /api/auth/login
```

### Campus
```
POST   /api/campus/programmes
GET    /api/campus/programmes
PUT    /api/campus/programmes/{id}
PATCH  /api/campus/programmes/{id}/status?status=CLOSED
GET    /api/campus/interests/{progId}
```

### Corporate
```
GET    /api/corporate/programmes?domain=&location=&type=
POST   /api/corporate/interest/{progId}
GET    /api/corporate/interests
```

### Matchmaking
```
GET    /api/match/results
POST   /api/match/close/{eoiId}
```

### Admin
```
GET    /api/admin/stats
GET    /api/admin/programmes
GET    /api/admin/deals
GET    /api/admin/corporates
```

---

## ⚙️ Local Setup

### Prerequisites
- Java 17+
- Node.js 18+
- MySQL 8
- Gradle

### 1. Database
Create a MySQL database:
```sql
CREATE DATABASE Ksep_db_local;
```

### 2. Backend — `application.properties`
Create `src/main/resources/application.properties` with:
```properties
spring.application.name=KSEP

spring.datasource.url=jdbc:mysql://localhost:3306/Ksep_db_local
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

jwt.secret=YOUR_JWT_SECRET_KEY
jwt.expiration=86400000

spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=YOUR_GMAIL_ADDRESS
spring.mail.password=YOUR_GMAIL_APP_PASSWORD
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

> For Gmail App Password: Google Account → Security → 2-Step Verification → App Passwords

### 3. Run Backend
```bash
./gradlew bootRun
```
Backend runs at `http://localhost:8080`

### 4. Run Frontend
```bash
cd frontend
npm install
npm run dev
```
Frontend runs at `http://localhost:5173`

---

## 🚀 Deployment

- Backend → [Render](https://render.com) (free tier, Spring Boot)
- Frontend → [Vercel](https://vercel.com) or [Netlify](https://netlify.com)
- Database → [Railway](https://railway.app) or [PlanetScale](https://planetscale.com) (MySQL)

Before deploying, update `baseURL` in `frontend/src/services/api.js` to your Render backend URL.

Also update the CORS config in `SecurityConfig.java` to allow your Vercel frontend domain.

---

## 👨‍💻 Developer

**Mukul Verma**  
B.Tech Data Science & AI — IIIT Naya Raipur  
Built as part of internship at Millionminds  
GitHub: [@MukulVerma14](https://github.com/MukulVerma14)