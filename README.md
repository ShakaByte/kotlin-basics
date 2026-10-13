# 🧪 Kotlin-Basics

Console-based Kotlin programs built while learning the fundamentals of the language. Both run in the terminal.

## 📌 Overview

Two tutorial-style projects that apply core Kotlin concepts through small, working apps.

## 📂 Projects

| Project | Description | Concepts Covered |
|---------|-------------|------------------|
| [**Tutorial Part 1**](./TutorialP1.kt) | Eligibility check and voting flow | Variables, control flow, exception handling |
| [**Tutorial Part 2**](./TutorialP2.kt) | Student details manager with CRUD operations | Null safety, data classes, lambdas, extension functions, collections |

## ✨ Features

**Part 1: Eligibility and Voting**
- Takes name and age, validates input (digits only, age 1-99)
- Checks voting eligibility (18+) and shows years remaining if under 18
- Voting menu with four options (AJP, FJP, GJP, NOTA) and invalid-choice handling

**Part 2: Student Manager**
- Add, search, delete, and display students
- Calculate a student's average marks
- Filter students whose average is above or below a threshold
- Sort students by name
- List vacant (missing) student IDs
- Formatted table output and input validation

## 🛠️ Tech Stack

| Layer | Technology |
|-------|------------|
| Language | Kotlin |
| Run Mode | Terminal / console |
| IDE | [IntelliJ IDEA / Android Studio] |

## 🚀 How to Run

```bash
# Compile and run with the Kotlin compiler
kotlinc TutorialP1.kt -include-runtime -d p1.jar
java -jar p1.jar

kotlinc TutorialP2.kt -include-runtime -d p2.jar
java -jar p2.jar
```

Or open the folder in IntelliJ IDEA and run the `main` function in each file.

## 👤 Author

**Vedant Pokale** ([ShakaByte](https://github.com/ShakaByte))
