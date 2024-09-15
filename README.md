# 🔫 Weapon Detection System - Data Analytics Project using YOLOv4

## 📝 Objective

The objective of this project is to develop a **real-time weapon detection system** using the **YOLOv4 deep learning algorithm**. The system is designed to detect weapons in live video feeds and images, enhancing security by providing real-time alerts to security personnel. The project involves data preprocessing, model training, evaluation, and deployment to ensure accuracy and efficiency in weapon detection.

## 🚀 Project Overview

- **Data Collection**: Collected image datasets of weapons from various sources, including public datasets and custom data collection using **web scraping**.
- **Data Preprocessing**: Performed using **OpenCV** and **Pandas** to clean, annotate, and preprocess the image data.
- **Model Training**: Trained the **YOLOv4 model** using annotated datasets.
- **Evaluation & Testing**: Evaluated the model using test images and video streams to ensure accuracy.
- **Deployment**: Deployed the system on both local servers and cloud platforms like **AWS** for real-time weapon detection.

## 📁 Project Structure

├── Android/ # Mobile application integration files
├── virus/ # YOLOv4 model and utilities
├── static/ # Static files for the web app │
├── templates/ # HTML templates for the web app │
├── api.py # Flask API for handling requests │
├── cv.py # Core script for weapon detection using computer vision │
├── database.py # Manages database operations
├── training_data.pkl # Preprocessed training data in pickle format |
├── yolov4_testing.cfg # YOLOv4 model testing configuration |
├── yolov4_training.cfg # YOLOv4 model training configuration |
├── data.csv # Dataset used for training and testing |


## 📊 Data Overview
The dataset contains images of various weapons, annotated for training the YOLOv4 model. The annotations include bounding boxes that mark the position of weapons in the images.

### Sample Data
```csv
"Image ID","Weapon Type","Bounding Box Coordinates","Width","Height"
"image_001.jpg","Handgun","[100, 200, 150, 250]",50,50
"image_002.jpg","Knife","[120, 220, 180, 300]",60,80
```

## 🔨 Workflow & Key Steps

### 1. **Data Collection**

- Gathered weapon images from public datasets and custom data collected using web scraping techniques.

### 2. **Data Cleaning & Transformation**

- Annotated images with bounding boxes to identify weapons.
- Cleaned and resized images using OpenCV for consistency and to meet model requirements.

### 3. **Model Training (YOLOv4)**

- Trained the YOLOv4 model using annotated weapon images.
- Fine-tuned hyperparameters such as learning rate, batch size, and confidence thresholds for optimal performance.

### 4. **Evaluation & Testing**

- Tested the model on live video feeds and a test set of images to evaluate its accuracy and speed.
- Measured key metrics such as Precision, Recall, and F1-score to assess the model's performance.

### 5. **Deployment**

- Deployed the weapon detection system on local servers for testing and cloud platforms like AWS for real-time monitoring.
- Integrated the system with a Flask API to handle video feed input and display detection results.

## 🛠 Technologies & Tools

- ** YOLOv4**: Deep learning algorithm for real-time weapon detection.
- **Python**: Core programming language for development.
- **OpenCV**: For image preprocessing and video feed handling.
- **Flask: **: For web app and API integration.
- **AWS**: Cloud platform for deployment and real-time monitoring.

## 🎯 Key Results

- Successfully trained the YOLOv4 model for accurate and fast detection of weapons in real-time.
- Deployed the system on cloud platforms like AWS to monitor live video feeds for weapon detection.

## 🤝 Contributing

Contributions are welcome! Please feel free to submit issues or pull requests.

## 📄 License

This project is licensed under the MIT License.
