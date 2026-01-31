# AirLine Management System ✈️

**AirLine Management System** is a Java Swing desktop application for managing basic airline operations: user login, customer records, flight info, reservations, cancellations, payments and boarding pass generation.

---

## 🔧 Project Structure

- `src/airlinemanagementsystem/` — Java source files (UI and logic)
  - Entry point: `Main.java`
  - Key classes: `AddCustomer`, `BookFlight`, `Cancel`, `FlightInfo`, `Home`, `Payment`, `BoardingPassGenerator`, `Conn`, etc.
- `Database.sql` — SQL schema to create the database and tables
- `build.xml` / `nbproject/` — Ant / NetBeans project files

---

## ✅ Features

- User authentication (login)
- Add / manage customers
- Add / view flights
- Book reservations (PNR / ticket)
- Cancel reservations
- Payment and boarding-pass generation

---

## 📋 Prerequisites

- Java JDK 8 or newer
- MySQL server
- MySQL Connector/J (JDBC driver) must be available on the project classpath
- Optional: NetBeans IDE (project is NetBeans-friendly) or Apache Ant

---

## 🛠️ Database Setup

1. Create the database and tables by running the `Database.sql` file:

```sh
mysql -u root -p < Database.sql
```

2. Default connection values are in `src/airlinemanagementsystem/Conn.java`:

```java
// Default in the project
jdbc:mysql://localhost:3306/airlinemanagementsystem
user: root
password: redhat
```

- **Change** these values in `Conn.java` to match your MySQL credentials and host.

3. Insert an initial login user (example):

```sql
INSERT INTO login(username,password) VALUES('admin','admin');
```

---

## ▶️ Build & Run

Using NetBeans (recommended):
1. Open the project in NetBeans.
2. Make sure MySQL Connector/J is added under Project > Libraries.
3. Run the project (NetBeans will call the `Main` class).

Using Ant / Command line:

```sh
# from project root
ant
ant run     # runs the project using the Ant run target
```

Or compile/run manually (for advanced users):

```sh
# compile
javac -cp "path/to/mysql-connector-java.jar" -d build/classes src/airlinemanagementsystem/*.java
# run
java -cp build/classes;path/to/mysql-connector-java.jar airlinemanagementsystem.Main
```

---

## ⚠️ Troubleshooting

- If login always fails, ensure `login` table has a record (see SQL above).
- If you get a Driver class not found error, add MySQL Connector/J to the classpath.
- If connection refused, confirm MySQL is running and the JDBC URL/credentials in `Conn.java` are correct.

---

## 🧾 Notes & Contribution

- This repository was scaffolded with NetBeans and uses Ant build files.
- Feel free to open issues or submit pull requests to improve features, fix bugs, or add tests.

---

**Author:** anjeet

License: (Add a license if you want to open-source this project)
