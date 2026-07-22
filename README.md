<div align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" alt="Java"/>
  <img src="https://img.shields.io/badge/Swing-007396?style=for-the-badge&logo=java&logoColor=white" alt="Swing"/>
  <img src="https://img.shields.io/badge/NetBeans-1B6AC6?style=for-the-badge&logo=apache-netbeans-ide&logoColor=white" alt="NetBeans"/>
  <img src="https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge" alt="License"/>
</div>

<br/>

<div align="center">
  <h1>📚 Attendance Management System</h1>
  <p><strong>A comprehensive Java Swing-based ERP module for managing student attendance, assignments, and sessional marks across multiple courses and programs.</strong></p>
  
  <p>
    <a href="#-features">Features</a> •
    <a href="#-screenshots">Screenshots</a> •
    <a href="#-tech-stack">Tech Stack</a> •
    <a href="#-getting-started">Getting Started</a> •
    <a href="#-project-structure">Structure</a> •
    <a href="#-courses-supported">Courses</a> •
    <a href="#-contributing">Contributing</a>
  </p>
</div>

---

## ✨ Features

<table>
  <tr>
    <td align="center">🔐</td>
    <td><b>Secure Login</b> — Role-based authentication with multiple user credentials</td>
  </tr>
  <tr>
    <td align="center">📊</td>
    <td><b>Dashboard</b> — Centralized home screen with quick-action module cards & statistics</td>
  </tr>
  <tr>
    <td align="center">✅</td>
    <td><b>Mark Attendance</b> — Daily attendance with Present/Absent toggle per student. Supports lectures & practicals.</td>
  </tr>
  <tr>
    <td align="center">📝</td>
    <td><b>Assignments</b> — Upload marks, manage max marks, update records with subject-wise sections</td>
  </tr>
  <tr>
    <td align="center">📋</td>
    <td><b>Sessionals</b> — Enter Sessional-1, 2, 3 marks with auto-calculated totals and Pass/Fail status</td>
  </tr>
  <tr>
    <td align="center">🔑</td>
    <td><b>Change Password</b> — Secure password update with validation checks</td>
  </tr>
  <tr>
    <td align="center">📱</td>
    <td><b>Responsive UI</b> — Single-window scrollable interface with CardLayout navigation</td>
  </tr>
  <tr>
    <td align="center">🎓</td>
    <td><b>Multi-Course Support</b> — BCA, MCA, B.Tech CSE/IT, B.Sc CS, M.Sc CS with semester-wise subjects</td>
  </tr>
</table>

---

## 🖼️ Screenshots

> _Screenshots will be available once the UI is captured. The application features a modern flat design with:_
> - **Primary Color**: Dark Slate Blue `#2C3E50`
> - **Accent Color**: Bright Blue `#3498DB`
> - **Light Background**: Soft Gray `#ECF0F1`

### 🔐 Login Screen
```
┌─────────────────────────────────────────────┐
│                                             │
│          [   BANNER IMAGE   ]               │
│                                             │
│           Username                          │
│        ┌──────────────────┐                 │
│        │  Enter Username   │                │
│        └──────────────────┘                 │
│           Password                          │
│        ┌──────────────────┐                 │
│        │  •••••••••••••••  │                │
│        └──────────────────┘                 │
│                                             │
│           ╔══════════════╗                  │
│           ║   Sign In    ║                  │
│           ╚══════════════╝                  │
│                                             │
│   Don't have an account? Request from Admin │
└─────────────────────────────────────────────┘
```

### 🏠 Dashboard
- Statistics cards showing total courses, subjects, students, faculty
- Course & Semester dropdown selectors  
- Module access cards: Mark Attendance, View Attendance, Assignments, Sessionals, Change Password

---

## 🛠️ Tech Stack

| Technology | Purpose |
|------------|---------|
| **Java 26** | Core programming language |
| **Java Swing** | GUI framework (JFrame, JPanel, CardLayout) |
| **NetBeans** | IDE & build tool (Ant-based build) |
| **JDT Language Server** | VSCode Java extension support |

### Key Libraries & APIs
- `javax.swing.*` — UI components
- `java.awt.*` — Layout & color management  
- `CardLayout` — Single-window multi-panel navigation
- `JScrollPane` — Scrollable content areas

---

## 🚀 Getting Started

### Prerequisites
- **JDK 26+** (Java Development Kit)
- Any Java IDE (VS Code with Java extension, NetBeans, IntelliJ, Eclipse)

### Installation

```bash
# 1. Clone the repository
git clone https://github.com/ashudubeyvns/attendance-management-system.git
cd attendance-management-system

# 2. Compile the project
cd /path/to/AttendanceMgt_1
javac -d build/classes src/attendancemgt/*.java src/login_frame.java

# 3. Run the application
java -cp build/classes attendancemgt.AttendanceMgt
```

### 🔑 Test Credentials

| Username | Password |
|----------|----------|
| `24SCSE1180456` | `Gu@12345` |
| `24SCSE1180381` | `Gu@12345` |
| `24SCSE2030222` | `Gu@12345` |
| `123` | `012` |

---

## 📁 Project Structure

```
AttendanceMgt_1/
├── src/
│   ├── attendancemgt/
│   │   ├── AttendanceMgt.java          # Main entry point
│   │   ├── login_frame.java            # Login screen (package version)
│   │   ├── HomeScreen.java             # Dashboard with CardLayout
│   │   ├── MarkAttendance.java         # Attendance marking module
│   │   ├── AssignmentModule.java       # Assignment marks management
│   │   ├── SessionalsModule.java       # Sessional marks management
│   │   ├── Change_Password.java        # Password change form
│   │   ├── SubjectData.java            # Course & subject data repository
│   │   └── resources/
│   │       └── images.png              # Banner image
│   └── login_frame.java                # Standalone login (alternate)
├── build/
│   └── classes/                         # Compiled .class files
├── nbproject/                           # NetBeans project config
├── build.xml                            # Ant build script
├── manifest.mf                          # JAR manifest
├── .gitignore
└── README.md
```

---

## 🎓 Courses Supported

| # | Course | Semesters | Department |
|---|--------|-----------|------------|
| 1 | **BCA** — Bachelor of Computer Applications | 6 Semesters | CSA |
| 2 | **MCA** — Master of Computer Applications | 4 Semesters | MCA |
| 3 | **B.Tech CSE** — Computer Science & Engineering | 8 Semesters | CSE |
| 4 | **B.Tech IT** — Information Technology | 8 Semesters | IT |
| 5 | **B.Sc CS** — Computer Science | 6 Semesters | CS |
| 6 | **M.Sc CS** — Computer Science | 4 Semesters | CS |

Each course includes a comprehensive curriculum with theory and lab subjects per semester.

---

## 🔧 Development

### Building with NetBeans (Recommended)
1. Open project in Apache NetBeans IDE
2. Clean & Build (`Shift+F11`)
3. Run (`F6`)

### Building manually with Ant
```bash
ant clean
ant build
ant run
```

### Building with VS Code
1. Install "Extension Pack for Java" by Microsoft
2. Open the `AttendanceMgt_1` folder
3. Press `F5` or go to **Run → Start Debugging**

---

## 🤝 Contributing

Contributions are welcome! Here's how you can help:

1. **Fork** the repository
2. **Create** a feature branch (`git checkout -b feature/AmazingFeature`)
3. **Commit** your changes (`git commit -m 'Add some AmazingFeature'`)
4. **Push** to the branch (`git push origin feature/AmazingFeature`)
5. **Open** a Pull Request

---

## 📌 Roadmap

- [ ] Database integration (MySQL/PostgreSQL)
- [ ] View Attendance report module
- [ ] Export data to PDF/Excel
- [ ] Student & faculty management CRUD
- [ ] Timetable scheduling module
- [ ] REST API backend integration

---

## 📄 License

This project is licensed under the **MIT License** — see the [LICENSE](LICENSE) file for details.

---

<div align="center">
  <p>Made with ❤️ by <a href="https://github.com/ashudubeyvns">Ashutosh Dubey</a></p>
  <p>
    <img src="https://img.shields.io/github/stars/ashudubeyvns/attendance-management-system?style=social" alt="Stars"/>
    <img src="https://img.shields.io/github/forks/ashudubeyvns/attendance-management-system?style=social" alt="Forks"/>
  </p>
</div>

