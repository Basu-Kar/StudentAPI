# StudentAPI


--Technologies & Tools
1. Spring Boot 2.1.4
2. Gradle Wrapper 4.8
3. Postgres using JPA configured
4. Java 1.8
5. Selma Model Mapper (http://www.selma-java.org/). There is another option for the same is : MapStruct
6. Lombok


Spring Configuration

1. SNAKE CASE

spring:
    jackson:
      property-naming-strategy: SNAKE_CASE

2. @ControllerAdvice for ExceptionHandler

3. How to configure Lombok annotation processor in IntelliJ

    Step-1: Install IntelliJ Plugin
    Step-2: Enable IntelliJ Annotation Processor : File -> Settings -> Build, Execution & Deployment -> Compiler -> Annotation Processor

