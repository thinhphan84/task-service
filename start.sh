#!/bin/sh

# Gracefully handle shutdown signals (Ctrl+C or kill - UNIX/LINUX)
trap "echo '🛑 Shutting down...'; kill 0" SIGINT SIGTERM

# 1. Watch and compile all modules continuously on code changes
echo "👀 Watching for code changes..."
./gradlew -t \
  :application:classes \
  :infrastructure:classes \
  :domain:classes \
  :bootstrap:classes &

# Store the process ID of the background Gradle watcher
WATCH_PID=$!

# 2. Run the Spring Boot application directly from sourceSets (without building a JAR)
echo "🚀 Starting Spring Boot app..."
./gradlew :bootstrap:bootRun -PskipDownload=true

# Wait for the Gradle watcher process to finish (keeps script running)
wait $WATCH_PID
