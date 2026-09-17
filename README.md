# Library Management System 

## Project Overview
The Library Management System is a Java application developed to manage basic library operations efficiently. The system allows users to create an account and perform various operations such as adding books, viewing available books, removing books, borrowing books, and returning books.
The project uses Java arrays to store book information such as Book ID, Book Name, Author Name, and Book Status. The Scanner class is used to accept input from the user. A menu-driven interface is provided so that users can easily select and perform different library operations.

## Features
- Create user account
- Add new books
- Display available books
- Remove books
- Borrow books
- Return books
- Automatic Book ID generation
- Track book availability
- Simple menu-driven interface
- Basic error handling

## Technologies / Tools Used
- Java – Programming language
- JDK – For compiling and running the program
- Notepad++ – For writing and editing the Java code
- Command Prompt (CMD) – For compiling and executing the program
- Scanner Class – For user input
- Arrays – For storing book details

## Steps to Install & Run the Project
- Install JDK on your computer.
- Install Notepad++ for writing the Java code.
- Open Notepad++ and paste the Library Management System code.
- Save the file as LibraryManagement.java.
- Open Command Prompt (CMD) and go to the folder containing the file.
- Compile the program:
  - javac LibraryManagement.java
- Run the program:
  - java LibraryManagement
- Use the menu options to perform library operations.

## Instructions for Testing
- Run the program using CMD.
- Create an account by entering your Name and User ID.
- Test Add Book by entering a book name and author.
- Test Show Available Books to verify the new book.
- Test Borrow Book and check that its status changes to Borrowed.
- Test Return Book and verify that its status changes to Available.
- Test Remove Book and verify that the book is removed.
- Enter an invalid book name and verify the “BOOK NOT FOUND!” message.
- Select an invalid menu option and verify the “INVALID CHOICE!” message.
- Select Exit to close the program.
