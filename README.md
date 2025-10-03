# Mobile Automation Framework

A comprehensive Maven-based mobile automation framework using Appium, Java, and TestNG that supports parallel execution on both Android and iOS devices.

## 🚀 Features

- **Cross-Platform**: Supports both Android and iOS automation
- **Parallel Execution**: Run tests simultaneously on multiple devices
- **Maven Based**: Easy dependency management and build process
- **TestNG**: Powerful testing framework with comprehensive reporting
- **JSON Configuration**: Flexible device and Appium server configuration

## 📋 Prerequisites

Before setting up the project, ensure you have the following installed:

### Required Software
1. **Java JDK 8 or higher**
    - Download from [Oracle](https://www.oracle.com/java/technologies/javase-downloads.html)
    - Set `JAVA_HOME` environment variable

2. **Maven 3.6.0 or higher**
    - Download from [Maven Apache](https://maven.apache.org/download.cgi)
    - Add Maven to your system PATH

3. **Node.js and NPM**
    - Download from [Node.js](https://nodejs.org/)
    - Required for Appium server

4. **Appium Server**
   ```bash
   npm install -g appium
   # Or use Appium Desktop from https://github.com/appium/appium-desktop
   
5. Appium Doctor (Optional but recommended)
   
   npm install -g appium-doctor
   appium-doctor
   
   6. Platform-Specific Requirements
         For Android:
         Android SDK
          Set ANDROID_HOME environment variable
          Ensure platform-tools and tools are in your PATH
          Install required platform versions
        For iOS (macOS only):
          Xcode (from Mac App Store)
          Xcode Command Line Tools
          Carthage (if required by Appium)
       ```bash
       brew install carthage
