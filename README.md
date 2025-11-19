# Xmeme - A Meme Sharing Platform

Xmeme is a simple and intuitive web application that allows users to share and browse memes. Users can post a meme by providing their name, a caption for the meme, and the URL of the meme image. The platform displays a stream of the latest 100 memes posted by users.

This project is built using Java with the Spring Boot framework for the backend and is designed to be a RESTful service.

## Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [API Endpoints](#api-endpoints)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation & Setup](#installation--setup)
- [How to Run](#how-to-run)
  - [Running the Application](#running-the-application)
  - [Running Tests](#running-tests)
- [Project Structure](#project-structure)
- [Code Quality](#code-quality)

## Features

*   **Post a Meme**: Users can submit a new meme with their name, a caption, and an image URL.
*   **View Memes**: Users can view a list of the 100 most recently posted memes.
*   **RESTful API**: A clean and simple API for interacting with the meme service.
*   **Swagger UI**: Interactive API documentation for easy testing of endpoints.

## Tech Stack

*   **Backend**: Java, Spring Boot
*   **Build Tool**: Gradle
*   **Database**: MongoDB
*   **Code Quality**: Checkstyle with Google Java Style Guide

## API Endpoints

The base URL for the API is `/memes`.

| Method | Endpoint      | Description                               | Request Body (example)                                     | Success Response (200 OK)                               | Error Response (400/404/409)                                                              |
|--------|---------------|-------------------------------------------|------------------------------------------------------------|---------------------------------------------------------|-------------------------------------------------------------------------------------------|
| `POST` | `/memes`      | Submits a new meme.                       | `{"name": "John Doe", "url": "image.jpg", "caption": "LOL"}` | `{"id": "1"}`                                           | `400 Bad Request` (invalid payload), `409 Conflict` (duplicate meme)                      |
| `GET`  | `/memes`      | Retrieves the latest 100 memes.           | N/A                                                        | `[{"id":"1", "name":"John", "url":"img.jpg", "caption":"Funny"}]` | N/A                                                                                       |
| `GET`  | `/memes/{id}` | Retrieves a specific meme by its ID.      | N/A                                                        | `{"id":"1", "name":"John", "url":"img.jpg", "caption":"Funny"}`   | `404 Not Found` (if meme with ID doesn't exist)                                           |
| `GET`  | `/swagger-ui` | Opens the interactive Swagger API documentation. | N/A                                                        | HTML Page                                               | N/A                                                                                       |


## Getting Started

Follow these instructions to get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

*   **Java Development Kit (JDK)**: Version 8 or higher.
*   **Gradle**: Version 6.x or higher (or use the included Gradle Wrapper).

Make sure your `JAVA_HOME` environment variable is set correctly.

### Installation & Setup

1.  **Clone the repository:**
    ```sh
    git clone https://github.com/your-username/Xmeme.git
    cd Xmeme
    ```

2.  **Install dependencies:**
    The project uses the Gradle wrapper, which will automatically download the required Gradle version and dependencies when you run a build command.

## How to Run

### Running the Application

You can run the application using the Gradle wrapper:

*   On Windows:
    ```bash
    ./gradlew.bat bootRun
    ```
*   On macOS/Linux:
    ```bash
    ./gradlew bootRun
    ```

The server will start on `http://localhost:8081`.

### Running Tests

To execute the unit and integration tests for the application, run:

*   On Windows:
    ```bash
    ./gradlew.bat test
    ```
*   On macOS/Linux:
    ```bash
    ./gradlew test
    ```

## Code Quality

This project uses **Checkstyle** to enforce the Google Java Style Guide, ensuring code consistency and readability. To run the Checkstyle analysis:

```bash
./gradlew check
```

The report will be generated in the `build/reports/checkstyle` directory.
