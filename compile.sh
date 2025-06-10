#!/bin/bash
mkdir -p classfiles
javac -d out $(find src/main/java -name "*.java")
