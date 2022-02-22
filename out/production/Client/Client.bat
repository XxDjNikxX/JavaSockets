@echo off
:loop
java -cp ..\Phone\ServerClient.jar;. Client
goto loop