# histoGrades
Application that generates an histogram of students' grades.

## Getting Started
The application was developed in [Eclipse IDE](https://www.eclipse.org/downloads/packages/release/oxygen/3a/eclipse-ide-java-developers) using **Java** as a programming language and **Maven** as a building tool.

### Install
1. Make sure you've installed [JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html) and [Eclipse IDE](https://www.eclipse.org/downloads/packages/release/oxygen/3a/eclipse-ide-java-developers).
2. Clone this GitHub repository.
3. Make sure that the charting Java library [JFreeChart](https://mvnrepository.com/artifact/org.jfree/jfreechart/1.5.0) is included in the POM file as a **dependency**.
4. Add (if missing) the appropriate plugin to create the fat jar executable Java file.
5. Create a simple `.txt` file or use a sample of the [grades](https://drive.google.com/file/d/1I1zGwuwf8KgQyWnoz0358WczAZvtSuHT/view) of the students.

### Run
*The file which contains the grades of the students is passed as an argument in the class HistogramGenerator that contains the main method.*

* Command Line: `$ java -jar histoGrades-0.0.1-SNAPSHOT-jar-with-dependencies.jar ../grades.txt`

## Authors
* Nikolaos Fragkomanolis - *Initial Work*
