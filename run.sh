#!/bin/bash

# Load environment variables from .env file
set -a
source .env
set +a

# Run your Spring Boot app
java -jar target/Drive.api.java-0.0.1-SNAPSHOT.jar
