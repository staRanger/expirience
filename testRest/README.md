# Test REST service for appliance

Service stores a state of a appliance and returns it to the request from appliance.

## Getting Started

To start the service you need to run Spring Boot application.
API will be available on 8080 port

You can store a state for example:

```

curl -X POST \
  http://localhost:8080/appliance/ \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -d '{"itemid":"APL10001", "type":"WM", "state":"INIT"}'
```
or get the last saved state of appliance

```
curl -X GET \
  http://localhost:8080/appliance/{id} \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json'
```

### Prerequisites

You need to install java 8 and gradle 3.1 or later version


### Installing

Download and extract the project from github or clone this.

Start the Spring boot application from root directory of the project there is build.gradle file.

```
gradle bootRun
```

## Running the tests

To run the test you must build a project

```
gradle clean build
```


## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - The web framework used
* [Gradle](https://gradle.org/) - Dependency Management
* [H2](http://www.h2database.com/html/main.html) - Lightweight inmemory database
* [Lombok](https://projectlombok.org/) - The code cleaner library
* [JUnit](https://junit.org/junit5/) - Test library

