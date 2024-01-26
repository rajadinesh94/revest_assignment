# revest_assignment
This repository contains a Selenium-Java script that automates the login process for the "Form Authentication" section of the "The Internet" web application.

Getting Started
To get started, make sure you have the following installed on your system:

Java Development Kit (JDK) 20.
Selenium WebDriver.
An IDE like IntelliJ IDEA or Eclipse.
To run the script, follow these steps:

Open the terminal/command prompt.
Navigate to the directory containing the script.
Run the following command:
bash
Copy code
mvn test -Dtest=LoginTest
What the Script Does
Navigates to https://the-internet.herokuapp.com/.
Clicks on "Form Authentication".
Enters provided username and password, and logs in.
Asserts the successful login message.
Logs out from the application.
Prerequisites
Selenium WebDriver installed.
An IDE like IntelliJ IDEA or Eclipse.
The sample web application, "The Internet".
License
This project is licensed under the MIT License - see the LICENSE.md file for details.

Acknowledgments
Sauce Labs for hosting the sample web application, "The Internet".
Selenium documentation and examples.
