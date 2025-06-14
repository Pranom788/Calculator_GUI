@echo off
REM Set directories
set SRC_DIR=src
set OUT_DIR=out
set JAR_NAME=calapp.jar
set MAIN_CLASS=app.main

REM Clean old output
if exist %OUT_DIR% rmdir /s /q %OUT_DIR%
mkdir %OUT_DIR%

REM Compile all .java files
echo Compiling Java files...
for /R %SRC_DIR% %%f in (*.java) do (
    javac -d %OUT_DIR% "%%f"
)

REM Create manifest
echo Main-Class: %MAIN_CLASS% > manifest.txt

REM Create JAR
echo Creating JAR file...
jar cfm %JAR_NAME% manifest.txt -C %OUT_DIR% .

REM Run JAR
echo Running JAR...
java -jar %JAR_NAME%

pause
