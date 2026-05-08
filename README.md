# AutoQA Pro – E-Commerce Test Automation Framework

## Project Description

AutoQA Pro is a Selenium automation framework developed for automating major functionalities of an E-Commerce web application.  
This project was created as part of the HCL Tech Model Hackathon to demonstrate practical implementation of Selenium WebDriver, Java, TestNG, and Page Object Model (POM).

The framework is designed in a simple and reusable way so that new test cases and pages can be added easily in future.

The automation covers:
- Login and Registration
- Product Search
- Cart Functionality
- Checkout Process
- Form Validation

---

# Application Under Test

Website:  
https://automationexercise.com



# Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Maven
- WebDriverManager
- ExtentReports



# Flowchart

<img width="1123" height="1390" alt="My First Board" src="https://github.com/user-attachments/assets/db6e2025-2551-4336-a6ee-a44511eb37c6" />


# Test Scenarios Automated

## User Authentication
- Valid Login
- Invalid Login
- Logout Functionality
- New User Registration

---

## Product Module
- Search Product
- Verify Product Details
- Browse Products by Category



## Cart Module
- Add Product to Cart
- Remove Product from Cart
- Verify Cart Count



## Checkout Module
- Complete Checkout Process
- Checkout Without Login



## Form Validation
- Empty Field Validation
- Invalid Email Validation



# TestNG Usage

The framework uses:
- @BeforeMethod
- @AfterMethod
- @DataProvider
- testng.xml

DataProvider is used for login testing with multiple credentials.





# How to Run the Project

## Using Maven


mvn test



## Using TestNG

Run the `testng.xml` file directly.


# Reports and Screenshots

After execution:
- Reports are generated inside `reports` folder
- Screenshots are saved inside `screenshots` folder

