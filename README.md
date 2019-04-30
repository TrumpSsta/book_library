# Book Library

### Cognifide Java Intern Project
This is a book library managment platform. Application enable libraries to share informations about their book collections with customers. I created 3 endpoints which serve the relevant informaton based on data read from JSON file. 
## Getting Started
Spring Boot application, works on localhost, port 8080. There are 3 points, which returns:
* book identified by the given ISBN number, or id if field isbn13 doesnt exist,
* list of all books that are assigned to the requested category,
* Lists all authors and their rating, sorted descending.

Project was written in Intellij Idea using JAVA 8. 
To generate Plain Old Java Object (POJO) from json i used [jsonschema2pojo](https://github.com/joelittlejohn/jsonschema2pojo/), so there are some additional classes i wasn't working with.<br />
Main methods are placed in the classes described below:
* LibraryClient.java- rest controller,
* GetJson.java- reading .json files,
* VolumeInfo.java- contains most object, that are serialized,
* ControllerMethods.java- contains methods used by rest controller. <br />
Other classes were generated by jsonschema2pojo and they have not been changed.<br />
To Serialize/Deserialize json i chose [GSON](https://github.com/google/gson) library. For better code quality i used SonarLint plugin to Intellij Idea.

## Run Project
#### Clone Repository

At first clone repository

```
git clone https://github.com/TrumpSsta/book_library.git
```

### Build Project
To build the project open project directory,then use following command:
```
gradle build
```

### Running
After building the application run following command to start it:
```
gradle run
```
## How to use
There was possibility to select dataset file, but worked only when i run project in IDE, so i had to remove part of code which allowed changinf json file. The only option to change file is to replace books.json, with file with the same name.<br />

After running you can use application in your browser.
To get book with isbn number, put this address into browser:

```
http://localhost:8080/isbn/9780080568782
```
The "9780080568782" number can be replacew with book isbn13 number, or book id when doesn't have isbn13. 

To get book with isbn number, put this address into browser:

```
http://localhost:8080/category/Computers  
```
Category "Computers" you can replace with another category name.

To get author rating, put this address into browser:

```
http://localhost:8080/rating 
```
## Running the tests
I used Junit 4 for tests.

To run the automated tests:
```
gradle test
```

## Built With

* [Spring](https://spring.io/) - The web framework used
* [Gradle](https://gradle.org/) - Dependency Management

## Author

* **Jędrzej Magdans** - [TrumpSsta](https://github.com/TrumpSsta)

