# Implement pokemon API 


## Development Environment

### Required Tools

- OpenJDK 11 
- Gradle

### Testing

    ./gradlew test

### Coverage Reports

    ./gradlew test jacocoTestReport

The reports can be found on `build/reports/jacoco/test/html/index.html`

### Checking for outdated dependencies

    ./gradlew checkDependencyUpdates

### Production enviroment 
- you can get a list pokemon url: http://ec2-3-140-250-207.us-east-2.compute.amazonaws.com:8080/api/v1/pokemon/offset/1/limmit/10
 the endpoint is design to receive two parameters offset and limit for integration paginazable front-end
- you can get a specific pokemon url: http://ec2-3-140-250-207.us-east-2.compute.amazonaws.com:8080/api/v1/pokemon/1/specific