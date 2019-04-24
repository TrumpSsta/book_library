# Book Library

Cognifide Java Intern Project

## Getting Started

This is a book library managment platform. Application enable libraries to share informations about their book collections with customers. I created 2 endpoints which serve the relevant informaton based on data read from JSON file.  

## Run Project
#### Clone Repository

At first clone repository

```
$ git clone https://github.com/TrumpSsta/book_library.git
```

### Build Project
To build the project use following command:
```
./gradlew build
```
### Running
After building the application run following command to start it:
```
./gradlew run
```
## How to use
First when you turn on application, write path to your command line 
e.g.
```
C:\Program Files\books.json
```
After that you can use application in your browser.
To get book with isbn number, put this address into browser:

```
http://localhost:8080/isbn/"here put book isbn13 number, or book id when doesn't have isbn13"  
```
To get book with isbn number, put this address into browser:

```
http://localhost:8080/category/"here put book category name"  
```

## Running the tests
I used Junit 4 for tests.

### Break down into end to end tests

To run the automated tests:
```
./gradlew test
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Spring](https://spring.io/) - The web framework used
* [Gradle](https://gradle.org/) - Dependency Management

## Author

* **Jędrzej Magdans** - [TrumpSsta](https://github.com/TrumpSsta)

