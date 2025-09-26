# Dev International College App

A **final year Android project** (Apr 2025 – Jul 2025) designed to streamline academic workflows for **Dev International College**.  
This app provides syllabus access, secure login, image gallery, and a dedicated student data management module for the BCA Final Year.  

---

## 🚀 Features

- **Platform:** Android (Java, Android Studio)  
- **UI/UX:**  
  - Custom user interface designed with XML  
  - Clean, intuitive layouts for smooth navigation  

- **Syllabus Viewer:**  
  - In-app PDF viewer to display syllabus documents  
  - Organized by course, year, and subject  
  - PDFs stored and retrieved from local `assets/` folder  

- **Authentication:**  
  - Firebase Authentication (email/password)  
  - Secure login for both students and staff  

- **Image Gallery:**  
  - Interactive gallery showcasing college images  

- **BCA Final Year Module:**  
  1. Student data management (insert, delete, fetch)  
  2. PHP APIs (POST/GET) powering backend operations  
  3. Database hosted on WAMP Server with MySQL (`phpMyAdmin`)  

- **Backend Integration:**  
  - Smooth communication between Android client and PHP-MySQL backend  
  - HTTP requests used for CRUD operations  

---

## 🛠️ Tech Stack

**Frontend (Mobile App):**  
- Java (Android)  
- Android Studio  
- XML (UI design)  

**Backend (Server):**  
- PHP (APIs)  
- MySQL (Database)  
- WAMP Server (`phpMyAdmin`)  

**Other Tools / Services:**  
- Firebase Authentication  
- HTTP / REST APIs  

---

## 📂 Project Structure

Dev_International_College_app/
│
├── app/ # Android app source code
│ ├── src/main/java/ # Java classes (activities, adapters, API handlers)
│ ├── src/main/res/ # XML layouts, drawables, values
│ └── assets/ # PDF syllabus documents
│
├── backend/ # PHP API files (insert, delete, fetch)
├── database/ # MySQL schema and export files
├── build.gradle # Gradle build configuration
└── README.md # Project documentation


---

## 🔧 Setup & Installation

1. **Clone the Repository**
   ```bash
   git clone https://github.com/sandeepmehra28/Dev_International_College_app.git
   cd Dev_International_College_app

2. Frontend (Android App)

-Open project in Android Studio

-Sync Gradle dependencies

-Configure Firebase Authentication in google-services.json

-Build and run on emulator or device

3. Backend (PHP + MySQL)

-Install WAMP/XAMPP Server

-Place backend/ folder inside www/ or htdocs/

-Import MySQL schema using phpMyAdmin

-Update API URLs in Android app (e.g., ApiClient.java)

▶️ Usage

Students / Staff log in using their registered credentials (Firebase Auth).

Navigate to syllabus viewer → select course/year/subject → open PDF.

Image Gallery allows users to browse college photos interactively.

Admin / Faculty can manage student data through APIs:

Insert new student records

Delete outdated records

Fetch details dynamically

🐞 Known Issues

-Limited to local assets for PDFs (no online sync yet)

-Backend APIs currently hosted on WAMP server (not deployed publicly)

-UI not fully optimized for all screen sizes

🔮 Future Enhancements

-Deploy backend on a live cloud server (e.g., AWS, Firebase Hosting)

-Add push notifications for announcements

-Implement role-based access control (student vs staff)

-Enable offline caching for PDFs and images

-Multi-language support

📌 Links

GitHub Repo: Dev International College App

APK : https://tinyurl.com/5x5n7rt8

👨‍💻 Author

Sandeep Mehra

-Computer Science Student

-Interested in Android Development, Backend APIs, and Technical Projects

**short version**
Dev International College App (Apr 2025 – Jul 2025)

Built an Android app (Java, Android Studio) with Firebase Authentication for secure login.

Designed custom XML-based UI and integrated a syllabus PDF viewer (organized by course/year/subject).

Developed an interactive image gallery to showcase college photos.

Implemented student data management for BCA Final Year module using PHP APIs and MySQL (WAMP Server).

Ensured smooth Android–backend communication via HTTP requests.

Delivered a scalable project combining mobile UI/UX, backend APIs, and database management.
