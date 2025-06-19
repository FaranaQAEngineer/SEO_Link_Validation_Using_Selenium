# SEO_Link_Validation_Using_Selenium
This project automates SEO link validation for websites using Java, Selenium WebDriver, and HttpURLConnection. It tests whether the anchor (&lt; a>) tags on a web page point to valid or broken links 
and ensures all URLs belong to the correct domain.
💡 Project Objective:
To identify:
Missing anchor tags (<a> without href)

Invalid domain URLs (outside your site)

Broken links (HTTP status code 400+)

🔧 Technologies Used:

Java
Selenium WebDriver
ChromeDriver
HttpURLConnection (Java’s networking API)

🛠 How It Works:
Launches the BiodataKing website.

Extracts all links using <a> tags.

For each link:

Checks if href exists.

Checks if it's within the same domain.

Opens an HTTP connection and fetches response code.

Prints whether each link is:

✅ Valid

❌ Broken

⚠️ Outside domain

⚠️ Missing href

🚀 How to Run the Project:
1. Prerequisites:
Java JDK installed

Eclipse/IntelliJ or any Java IDE

ChromeDriver is installed and configured

Selenium WebDriver JAR files added to your project
