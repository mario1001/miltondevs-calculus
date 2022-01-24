# miltondevs-calculus

[Spring Boot](http://projects.spring.io/spring-boot/) Maven project representing a microservice for calculus operations. For now contains an arithmetic controller as REST API operations (summary and subtraction) for different parameters, this one is viewed and designed as a "calculator". Could perfectly contain another components for other issues referring always to this scope.

## Requirements

For building and running the application you will require:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) You can also use an upper version of JDK/JRE for running the project (minimum is Java 8 because of the use of streams).
- [Maven 3](https://maven.apache.org) A wrapper with version 3.8.4 is provided within this project.

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `org.miltondevs.maven.miltondevscalculus.CalculusApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
