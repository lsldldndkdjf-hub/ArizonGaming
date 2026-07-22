#!/bin/bash
# Build APK
echo "Building APK for Arizon Gaming..."
./gradlew clean build
echo "Building Release APK..."
./gradlew assembleRelease
echo "Build completed! Check app/build/outputs/apk/