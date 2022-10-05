# Microsservice with Micronaut Framework

**TL;DR;** This project is based on a containerized application with docker and docker-compose using the Micronaut framework, simple CRUD in an instance (also containerized) in MongoDB and a simple integration with the VIACEP API.

## Stacks in project
* Java - 11
* Maven - 3.8.1
* Micronaut - 3.7.1
* OpenApi - 3.0.1
* MongoDB - 6.0
* Docker - 20.20.12
* Docker Compose - 2.2.3


## Simple Structure
![image](https://user-images.githubusercontent.com/48265863/194179228-b0797f58-1fec-4196-b0b5-c6c59fe89706.png)

*As a mapper of Entities and DTO's, MapStruct was used

## A OpenAPI Specification

![image](https://user-images.githubusercontent.com/48265863/194180214-64d49764-96f3-45ed-b57d-23c0103a0363.png)

## How To

Minimum requirements
* Java 11
* Maven
* Docker
* Docker Compose

1 - Clone this repository
```

git clone <this repository>

```
2 - In root path run command:
```

mvn clean install

```
3 - After run this command:
```

docker-compose up -d

```

Tip: to view all the endpoints of this application, access its documentation via swagger at: http://localhost:8080/swagger-ui/index.html
