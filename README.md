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

4. logback
    Logback has already been included as part of springboot starter project. If you want to override default springboot logback configuration then there are two ways:
    a) If you think your overriden settings are simple then you can add them in application.properties
    b) If setting changes are complex then you need to create an xml file(logback.xml or logback-spring.xml) in root of the classpath or grovy file.
    https://dzone.com/articles/configuring-logback-with-spring-boot

5. Prometheus Configuration
    https://www.digitalocean.com/community/tutorials/how-to-install-prometheus-on-ubuntu-16-04

6. Grafana Installation
7. Spring Cloud Sleuth
