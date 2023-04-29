Price Retrieval Restful API

This project is a simple Restful API that retrieves the price mentioned on a specific website. The API is built using spring, and uses a web scraper to extract the price from the target website.
Installation

    Clone this repository to your local machine.
    Navigate to the project directory in your terminal.
    Install the required dependencies by running npm install.

Usage

    Start the server by running npm start.
    Make a GET request to the API endpoint http://localhost:9095/price.
    The API will return the price value extracted from the target website in JSON format.

Configuration

You can configure the target website URL and the CSS selector used to extract the price value .

Dependencies

This project relies on the following dependencies:

    jsoup
    lombok
    spring-boot-devtools
    spring-boot-starter-web
    commons-lang3
    spring-boot-starter-test


