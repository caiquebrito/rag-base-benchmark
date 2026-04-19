#!/bin/sh
APP_NAME="Gradle"
APP_BASE_NAME=$(basename "$0")
CLASSPATH=""
JAVA_EXE="${JAVA_HOME}/bin/java"
if command -v gradle &> /dev/null; then
  gradle "$@"
else
  echo "Gradle not found. Please install Gradle 8.5+"
  exit 1
fi
