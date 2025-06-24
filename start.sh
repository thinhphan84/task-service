#!/bin/sh

# Watch for code changes and rebuild bootJar continuously (required for DevTools to trigger restarts)
gradle -t :bootstrap:bootJar &

# Run the main application from the 'bootstrap' module
# The 'skipDownload' flag avoids re-downloading dependencies
gradle :bootstrap:bootRun -PskipDownload=true
