# Employee Management System

## Table of Contents
- [Introduction](#introduction)
- [Project Features](#project-features)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Usage](#usage)
- [API Documentation](#api-documentation)
- [Database Schema](#database-schema)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)
- [Contact Information](#contact-information)

## Introduction
The **Employee Management System** is a comprehensive solution designed to streamline and automate various HR processes. This system is built to manage employee records, track performance, and simplify administrative tasks.

## Project Features
- **Employee Records Management**: Add, update, and remove employee details.
- **Attendance Tracking**: Monitor employee attendance and leave records.
- **Performance Evaluation**: Conduct performance reviews and manage feedback.
- **Payroll Management**: Automate salary calculations and generate pay slips.
- **Reporting**: Generate detailed reports on various HR metrics.

## Technologies Used
- **Frontend**: HTML, CSS, JavaScript, React
- **Backend**: SpringBoot, JPA
- **Database**: Postgres
- **Authentication**: Password
- **Version Control**: Git

## Installation
### Prerequisites
- SpringBoot
- Postgres
- Git

### Steps
1. **Clone the repository**
    ```bash
    git clone https://github.com/DarkLord-13/Employee_Management_System.git
    ```
2. **Navigate to the project directory**
    ```bash
    cd Employee_Management_System
    ```
3. **Install dependencies**
    ```bash
    npm install
    ```
4. **Run the application**
    ```bash
    npm start
    ```

## Usage
### Running the Application
- To start the server, use the following command:
    ```bash
    npm start
    ```
- Open your browser and navigate to `http://localhost:your_port`

### API Endpoints
- **GET /api/employees**: Fetch all employee records.
- **POST /api/employees**: Add a new employee.
- **PUT /api/employees/:id**: Update an existing employee.
- **DELETE /api/employees/:id**: Delete an employee.


## API Documentation
### Employees
- **GET /api/employees**
    - Description: Fetch all employee records.
    - Response: Array of employee objects.

- **POST /api/employees**
    - Description: Add a new employee.
    - Request Body: JSON object containing employee details.
    - Response: The created employee object.

- **PUT /api/employees/:id**
    - Description: Update an existing employee.
    - Request Body: JSON object containing updated employee details.
    - Response: The updated employee object.

- **DELETE /api/employees/:id**
    - Description: Delete an employee.
    - Response: Success message.

## Database Schema
### Employee Collection
```json
{
    "_id": "Integer",
    "name": "string",
    "email": "string",
    "position": "string",
    "department": "string",
    "dateOfHire": "Date",
    "salary": "number"
}
