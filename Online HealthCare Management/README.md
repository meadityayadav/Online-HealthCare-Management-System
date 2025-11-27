# Healthcare Management (Java Web Project)

**What this contains:** A ready-to-upload project structure for a Java web-based Healthcare Management System (Servlets + JSP + JDBC + MySQL). It follows the requirements from the provided PPT/PDF. Key features:
- Role-based dashboards (ADMIN / DOCTOR / PATIENT)
- Online appointment booking and management
- Basic patient medical records
- JDBC DAOs, PreparedStatements, transaction handling
- OOP: inheritance (User -> Patient/Doctor), interfaces, exception handling
- Collections & Generics use in DAOs and services
- A scheduled reminder service (uses multithreading)

## Setup
1. Install JDK 8+ and Maven.
2. Create a MySQL database and run `sql/schema.sql` to create tables.
3. Update DB credentials in `src/main/java/com/healthcare/utils/DBConnection.java`.
4. Build with `mvn clean package` -> produces a WAR in `target/`.
5. Deploy the WAR on Apache Tomcat (9+).

## Files included
- `src/main/java/com/healthcare/...` : Java sources (models, DAO, servlets, utils)
- `src/main/webapp/` : JSP pages, static assets
- `sql/schema.sql` : Database schema and sample data
- `pom.xml` : Maven build file
- `README.md`, `.gitignore`

## Notes
- This is a scaffolding and functional skeleton — the core CRUD flows, DAO patterns and JDBC usage are implemented. You may extend validation, security, and UI styling as needed.
- Follow the rubric in the uploaded evaluation PDF to expand features (collections, threads, etc.). See comments in code.

