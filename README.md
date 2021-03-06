# autosledz
> Manage your instance of Traccar using you own webpage
> Project created during <a href="http://kodilla.com">Kodilla's</a> course.

## What is it for?
> It's backend mechanics (REST API) allowing you to deal with Traccar's API.
> Traccar API is available at https://www.traccar.org/api-reference/
> Main purpose is to allow your employees to have only limited access to Traccar,
> without logging to Traccar itself.

## Requirements
You need:
* JVM (Java Virtual Machine)
* MySQL database
* free port 8080

## Running the project
Projects builds using Gradle (gradlew build). You need working MySQL server: create user and database.
Write MySQL credentials into application.properties, as well as other settings. Especially:
1) link to working instance of Traccar API (traccar.api.endpoint.prod), eg. http://my.traccar.server.pl:8082/api
2) traccar.authorization token, e.g. Basic dkf34r23i4j232ho4==

## How can I use it?
It's a result of my work during Kodilla's course. You can use it on Creative Commons license.

## Troubleshooting
I do not know any.

## links
* Backend: https://github.com/BarcaLS/autosledz
* Frontend: https://github.com/BarcaLS/autosledz-frontend/
* Traccar API documentation: https://www.traccar.org/api-reference/
* Traccar demo servers: https://www.traccar.org/demo-server/