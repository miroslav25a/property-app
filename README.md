# Property Application
Property application answers the following questions based on the data provided
1. Find the mean price in the postcode outward ‘W1F’?
2. Find the difference in average property prices between detached houses and flats?
3. Find the top 10% most expensive properties?

## Motivation
Rightmove coding exercise

## Installation
For local development:

mvn clean install
## Tests

For unit tests:

    mvn test

* Note I: In Eclipse you can run all the tests by right-clicking on the project and selecting Run As->JUnit Test. 
* Note II: run single test in the terminal:  mvn -Dtest=TestName test

## Usage
1. open terminal
2. cd to property-app project direcotry
3. mvn clean install
4. java -jar -Dapple.awt.UIElement="true" target/property-app-0.0.1.jar <<full path to property-data.csv>> -h 

* Note I: example property-data.csv location: /property-app/src/main/resources/property-data.csv
* Note II: example of java command with file paths : java -jar -Dapple.awt.UIElement="true" target/property-app-0.0.1.jar C:\workspace\property-app\src\main\resources\property-data.csv -h

## User Guide
* To Find the mean price in the postcode outward ‘W1F’, enter the following command:
enter command: 1 W1F

* To Find the difference in average property prices between detached houses and flats, enter the following:
enter command: 2 Detached Flat

* To Find the top 10% most expensive properties, enter the following:
enter command: 3 10

*To Quit, enter the following:
enter command: Q
