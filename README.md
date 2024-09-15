Verivox Test Scenarios
Automated test scenarios for the Verivox website (https://www.verivox.de/) using Java and Selenium WebDriver. This project covers common user interactions like accepting GDPR cookie consent, verifying navigation, and testing form submissions.

Prerequisites
Java 11+ installed: Install JDK
Maven for dependency management: Install Maven
Chrome and ChromeDriver matching your Chrome version: Download ChromeDriver
Setup
Clone the repository:


Copy code
git clone https://github.com/git-vaibhav/VerivoxTest.git
cd verivoxTest


Install dependencies:

bash
Copy code
mvn clean install
Running Tests
To run all tests:

bash
Copy code
mvn test
To run a specific test class (e.g., GDPRTest):

bash
Copy code
mvn -Dtest=GDPRTest test
Test Scenarios
GDPR Cookie Consent: Automatically accepts GDPR cookie consent on the homepage.
Navigation: Verifies main navigation links (e.g., Strom, Gas, Versicherungen).
Form Submission: Tests various form submission scenarios with valid and invalid data.
