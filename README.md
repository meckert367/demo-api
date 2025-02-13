# Project

This is a demo project, a programming assignment, with the goal to create a little Spring Boot application, that provides simple REST endpoints via a OpenAPI configuration and persists some data into a Hibernate Database using JPA.
In extensions to that, it is supposed to be a maven project that includes a jenkins pipeline which builds and tests the project, as well as doing some code quality checks.

Because it was not clearly defined, what the quality checks were supposed to look like, I decided to use SonarQube. This as well as a Jenkins instance can be found in the docker-compose file that is part of this project. I used those to verify my results.

# The Code

The code consists of a very basic spring boot application that uses the spring functionality, provided via springdoc, that allows to generate code based of a OpenAPI configuration.
The OpenAPI file defines a minimal REST API with a GET and a POST endpoint for the `/users` route, to list all existing users as well as adding new users. The user object simply consists of an id and a name.

When one of the endpoints is called, the `UserRepository` is called to interact with the hibernate database, as it is defined via the `application.properties`.

# Tests

There are also a few generic tests for the `UserController` and `UserRepository`, so that the pipeline to have some actual tests to execute.

# CI/CD

The `docker-compose.yml` provides a local Jenkins and SonarQube instance. After initial setup of both services, a new User was created for SonarQube including a token. This token is then added as "secret text" with the name 'sonar-token' to the Jenkins credentials.
After that is done, the project is added as a Pipeline. In the Pipeline configuration it is defined as "Pipeline script from SCM" with this git repository as project.

When the Pipeline is run now, it will build, test and check the projects code quality.