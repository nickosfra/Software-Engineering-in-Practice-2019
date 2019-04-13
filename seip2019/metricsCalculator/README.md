# metricsCalculator
Application that analyzes a java code file into 3 types of metrics (lines of code, number of classes, number of methods) with two different ways; using regular expressions or string comparison.

## Getting Started
The application was developed in [Eclipse IDE](https://www.eclipse.org/downloads/packages/release/oxygen/3a/eclipse-ide-java-developers) using **Java** as a programming language and **Maven** as a building tool.

### Install
1. Make sure you've installed [JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html) and [Eclipse IDE](https://www.eclipse.org/downloads/packages/release/oxygen/3a/eclipse-ide-java-developers).
2. Clone this GitHub repository.
3. Build it with Maven.
4. Create a java code file (if you don't have any), which will be given as a command-line argument to be analyzed.

### Run
*Two elements are given as an argument on the command line; the path of the java code file and the word string or regex (regular expressions) in order to choose in which way you want to have your file analyzed.*

* Command Line: `$ java -jar metricsCalculator.jar [sourceFile] [string or regex]`

## Authors
* Nikolaos Fragkomanolis - *Initial Work*
