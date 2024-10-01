# IIITD Course Registration System

## Overview
This assignment is a terminal-based IIITD Course Registration System developed as part of the. The application allows three types of users—**Students**, **Professors**, and **Administrators**—to perform specific functions related to course registration, management, and student records.

## How to Run the Application
1. **Download the Project:**
    - Download and unzip the project directory.

2. **Compile the Project:**
    - Navigate to the directory containing the `Main.java` file and run the following command:
      ```bash
      javac Main.java
      ```

3. **Run the Application:**
    - Once compiled, run the application using the command:
      ```bash
      java Main
      ```

4. **User Login:**
    -After entering the application, it presents users with a login screen where users can log in as a **Student**, **Professor**, or **Administrator**.

## Features
### Student Functionalities:
- **View Available Courses:** Students can view courses offered for the current semester, including course details such as the course code, title, instructor, credits, prerequisites, and timings.
- **Register for Courses:** Students can register for courses if prerequisites are met and within the 20-credit limit.
- **View Schedule:** View a weekly schedule of registered courses.
- **Track Academic Progress:** View grades and compute GPA after completing semesters.
- **Drop Courses:** Drop courses during the ongoing semester.
- **Submit Complaints:** Submit complaints about issues such as schedule clashes.

### Professor Functionalities:
- **Manage Courses:** View and manage course details such as syllabus, timings, and prerequisites.
- **View Enrolled Students:** View the list of enrolled students and their academic standing.

### Administrator Functionalities:
- **Manage Course Catalog:** Add or delete courses from the catalog.
- **Manage Student Records:** Update student records, grades, and personal information.
- **Assign Professors to Courses:** Assign professors to courses based on their expertise and availability.
- **Handle Complaints:** View and resolve student complaints and filter by status.

## Object-Oriented Design
### Classes and Interfaces:
- **User (Base Class also implements the User Interface):** Common properties and methods for all user types.
    - Subclasses: **Student**, **Professor**, and **Administrator**.
- **Course:** Represents a course with attributes like code, title, credits, etc.
  - Subclasses: **FinishedCourse** and **ProfessorCourse**.
- **Complaint:** Handles complaints submitted by students.

### Key OOP Concepts:
1. **Inheritance:** Student, Professor, and Administrator inherit from the base `User` class.
2. **Polymorphism:** The `User` reference type is used to handle different user types (i.e, Students/Professors/Admin).
3. **Encapsulation:** Class properties are private, with access provided through getter and setter methods.
4. **Abstraction:** The User class is modelled on how a user might behave. And, abstract methods in the `User` class are implemented by its subclasses.

## Assumptions
- Admin Cannot Be Created Using this system as that would enable students and professors as well to get admin privileges so admins are prepopulated.
- The system is prepopulated with 3 students which have completed a few courses but not enrolled in any. Also preopulated with 11 courses , 2 professors and an admin,
- The system does not handle elective/mandatory course categorization.
- No deadlines for dropping a course.
- User inputs data of the correct type for example if an integer is asked as input the user is not entering a string for example.
- After assigning grades to all the courses of a student, only admin can change the student's semester.

## Credits
Developed by Sanchay Singh [2023478].

