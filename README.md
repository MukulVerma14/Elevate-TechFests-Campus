# Knowledge Services Engagement Platform (KSEP)

A B2B matchmaking platform by **Millionminds** that connects campuses offering knowledge programmes (seminars, hackathons, workshops, symposiums) with corporates (startups & SMBs) looking to associate with them.

---

## 🧱 Tech Stack

| Layer | Technology |
|---|---|
| Backend | Java 21, Spring Boot 4, Spring Security, Spring Data JPA, Flyway |
| Frontend | React 18, Vite, Tailwind CSS, Axios |
| Database | MySQL 8, Flyway Migrations |
| Auth | JWT (jjwt 0.13.0) |
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
- Java 21
- Node.js 18+
- MySQL 8
- Gradle

### 1. Database & Migrations
Create a MySQL database:
```sql
CREATE DATABASE ksep_db_local;
```
> [!NOTE]
> Flyway database migrations are enabled. When you run the backend, Flyway will automatically execute the schema migration script located in `src/main/resources/db/migration/V1__initial.sql` to initialize the database tables.

### 2. Backend Config — `application.properties`
Ensure `src/main/resources/application.properties` is configured correctly. You can use the following template for local development:
```properties
spring.application.name=KSEP

spring.datasource.url=jdbc:mysql://localhost:3306/ksep_db_local
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=validate
spring.jpa.open-in-view=false
spring.jpa.show-sql=false

spring.flyway.enabled=true
spring.flyway.fail-on-missing-locations=true

jwt.secret=YOUR_JWT_SECRET_KEY
jwt.expiration=86400000

spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=YOUR_GMAIL_ADDRESS
spring.mail.password=YOUR_GMAIL_APP_PASSWORD
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

spring.datasource.hikari.maximum-pool-size=10
spring.datasource.hikari.minimum-idle=5
spring.datasource.hikari.connection-timeout=30000
spring.datasource.hikari.idle-timeout=600000

logging.level.com.example.ailmc=INFO
logging.level.org.springframework.security=WARN
logging.level.org.flywaydb=INFO
```

> For Gmail App Password: Google Account → Security → 2-Step Verification → App Passwords

### 3. Run Backend
Run the backend in development mode:
```bash
./gradlew bootRun
```
The backend will run at `http://localhost:8080`.

#### Running with Production Profile (Alternative)
To run the backend with the production profile (`prod`), which reads credentials from environment variables or a `.env` file:
```bash
# Run using Gradle wrapper
./gradlew bootRun --args='--spring.profiles.active=prod'

# Or run using built JAR
java -jar build/libs/ksep-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod
```

#### Running with Docker (Alternative)
You can also package and run the backend using Docker:
1. Build the Docker image:
   ```bash
   docker build -t ksep-backend .
   ```
2. Run the Docker container with an environment file:
   ```bash
   docker run -p 8080:8080 --env-file .env ksep-backend
   ```

### 4. Run Frontend
```bash
cd frontend
npm install
npm run dev
```
Frontend runs at `http://localhost:5173` (requests to `/api` are automatically proxied to `http://localhost:8080`).

### 5. Default Super Admin Credentials
On startup, a default super admin user is automatically initialized in the database via `DataInitializer.java`:
- **Email:** `admin@ailmc.com`
- **Password:** `Admin@123`

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