
# SmartSpend Android Application

SmartSpend is a Kotlin-based Android budgeting app that allows users to sign up, log in, and track their personal finances through a dashboard. It uses Firebase for authentication and real-time database storage.

---

## 📱 Features

- Firebase Email/Password Authentication
- User registration and login
- Save user profile information to Firebase Realtime Database
- Dashboard with account balances
- Expense & income entry
- Category autocomplete with dynamic suggestions

---

## 🔧 Technologies Used

- Kotlin
- Firebase Authentication
- Firebase Realtime Database
- XML Layouts
- AndroidX Libraries

---

## 🚀 Firebase Setup Instructions

### 1. **Create Firebase Project**
- Go to [Firebase Console](https://console.firebase.google.com/)
- Click **"Add project"**
- Follow the prompts and create the project

### 2. **Register your app**
- Add your Android app with its **package name**:  
  Example: `com.example.smartspend`
- Download the `google-services.json` file
- Place it in your Android Studio project under:  
  `app/google-services.json`

### 3. **Enable Authentication**
- Go to **Build → Authentication**
- Enable **Email/Password** sign-in method

### 4. **Enable Realtime Database**
- Go to **Build → Realtime Database**
- Create a new database and choose "Start in test mode"

---

## ⚙️ Gradle Configuration

### Project-level `build.gradle.kts`
```kotlin
plugins {
    id("com.android.application") version "8.1.0" apply false
    id("com.google.gms.google-services") version "4.3.15" apply false
}
```

### App-level `build.gradle.kts`
```kotlin
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

android {
    // your usual android config
}

dependencies {
    implementation(platform("com.google.firebase:firebase-bom:32.7.0"))
    implementation("com.google.firebase:firebase-auth-ktx")
    implementation("com.google.firebase:firebase-database-ktx")
}
```

---

## 🔑 User Data Structure in Firebase

When a user signs up, the app stores data in this format:

```json
"Users": {
  "userId12345": {
    "userId": "userId12345",
    "username": "Shaun",
    "email": "shaun@email.com"
  }
}
```

---

## 🧪 Testing

- Run the app on an emulator or device
- Try signing up with a new account
- Check Firebase to confirm data is stored under **Realtime Database → Users**

---

## 📬 Support

For help or suggestions, please contact **shaunmakhobo@gmail.com** or raise an issue on this repo.

---
