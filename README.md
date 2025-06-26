# Task Service Instructions

## **How to run this project**

1. **Copy application.example.yml in `bootstrap/src/main/resources/application.example.yml` then rename it to application.yml in the same path**

2. **Run the command**

   ```bash
   docker compose down && docker compose up --build
   ```

## **Support commands**

1. **Remove cached maven (like Node Modules) dependencies**

   ```bash
   rm -rf ~/.gradle
   ```

2. **Clean and compile the project**

   ```bash
   ./gradlew clean build
   ./gradlew compileJava
   ```

3. **Install dependencies**

   ```bash
   ./gradlew build --refresh-dependencies
   ```

4. **Package the application**

   ```bash
   ./gradlew :bootstrap:bootJar
   ```

5. **Reset Docker**

   ```bash
   docker stop $(docker ps -aq)
   docker rm $(docker ps -aq)
   docker rmi -f $(docker images -aq)
   docker volume rm $(docker volume ls -q)
   docker network rm $(docker network ls -q)
   docker compose down && docker compose up --build
   ```

6. **Run spring**

   ```bash
   ./gradlew :bootstrap:bootRun
   ```
7. See env
```bash
   docker exec -it _task_-service env
   ```


## Additional Resources



- [Maven Repository](https://mvnrepository.com/) for dependency lookup.
