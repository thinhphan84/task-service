#!/bin/sh

trap "echo '🛑 Shutting down...'; kill 0" SIGINT SIGTERM

# 1. Watch và compile tất cả modules
echo "👀 Watching for code changes..."
./gradlew -t \
  :application:classes \
  :infrastructure:classes \
  :domain:classes \
  :bootstrap:classes &

WATCH_PID=$!

# 2. Run app từ sourceSets (không cần jar)
echo "🚀 Starting Spring Boot app..."
./gradlew :bootstrap:bootRun -PskipDownload=true

wait $WATCH_PID
