# Digital Library Management System

## Overview

The **Digital Library Management System** is a web-based application that allows users to manage books efficiently. The application provides CRUD (Create, Read, Update, Delete) functionalities for book records, making it easy to add, update, search, and remove books from the system.

- **Frontend**: React.js
- **Backend**: Spring Boot
- **Database**: MySQL
- **Deployment**:
  - **Frontend**: Netlify
  - **Backend**: Render (Free Service)

## Features

- Add new books with details such as title, author, and genre.
- View a list of all books in the system.
- Search books by **ID** or **Title**.
- Update book details.
- Delete books from the system.

## Live Deployment

- **Frontend URL**: [https://cool-kataifi-1ff576.netlify.app/](https://cool-kataifi-1ff576.netlify.app/)
- **Backend API URL**: [https://demo-deployment-latest-eh7o.onrender.com](https://demo-deployment-latest-eh7o.onrender.com)

### Important Note:

This project is deployed using **free hosting services**. The backend (hosted on Render) will automatically **shut down if there is no activity for 15 minutes**. If you want to test the application, please inform me in advance so that I can ensure the backend is active.

## Setup Instructions

### Prerequisites

Make sure you have the following installed:

- Node.js and npm
- Java 17+
- MySQL
- Spring Boot

### Backend Setup

1. Clone the repository:
   ```sh
   git clone https://github.com/PURNA1224/DLMS.git
   cd DLMS
   ```
2. Configure the **application.properties** file with your MySQL database details.
3. Build and run the backend:
   ```sh
   mvn spring-boot:run
   ```
4. The backend will be available at `http://localhost:8081`.

### Frontend Setup

1. Navigate to the frontend directory:
   ```sh
   cd frontend
   ```
2. Install dependencies:
   ```sh
   npm install
   ```
3. Start the React app:
   ```sh
   npm run dev
   ```
4. Open `http://localhost:5173` in your browser.

## API Endpoints

### Base URL: `/books`

- `GET /getBooks` - Fetch all books
- `POST /addBook` - Add a new book
- `POST /updateBook` - Update a book
- `DELETE /deleteBook?bookId={id}` - Delete a book
- `GET /searchById?bookId={id}` - Search book by ID
- `GET /searchByTitle?title={title}` - Search book by title

## Contact

If you have any issues, feel free to reach out!

Email: [purnashekar777@gmail.com](mailto\:purnashekar777@gmail.com)
