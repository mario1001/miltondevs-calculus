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

While running, you can access to the following endpoints (calculator API):

* /arithmetic/addition. Require at least two query parameters with tag param. Examples:
    * http://localhost:8080/arithmetic/addition?param=1&param=2&param=5 => returning: 8
    * http://localhost:8080/arithmetic/addition?param=1&param=2 => returning: 3
    * http://localhost:8080/arithmetic/addition?param=50 => returning: bad request - 400
    * http://localhost:8080/arithmetic/addition?param=50&a=test&param=67 => returning: 117
* /arithmetic/subtract. Require at least two query parameters with tag param. Examples:
    * http://localhost:8080/arithmetic/subtract?param=10&param=4 => returning: 6
    * http://localhost:8080/arithmetic/subtract?param=2&param=20 => returning: -18
    * http://localhost:8080/arithmetic/subtract?param=10 => returning: bad request - 400
    * http://localhost:8080/arithmetic/subtract?param=10&param=20&param=ab => returning: bad request - 400

## Running the unit tests

The same as execution, you can run them with IDE option with JUnit project build.

A more manually way is by using this in the root project:

```shell
mvn test
```
