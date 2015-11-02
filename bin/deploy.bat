@echo off
set APP=TicTacToe
set LOCATION=C:\temp

call bin\clean.bat
call bin\package.bat

if exist %LOCATION%\\%APP% rmdir /S /Q %LOCATION%\\%APP%

if not exist "%LOCATION%" mkdir %LOCATION%

xcopy /E build\install %LOCATION%

%LOCATION%\\%APP%\\bin\\%APP%
