@echo off
set APP=TicTacToe
set LOCATION=C:\Games

call bin\clean.bat
call bin\package.bat
call bin\makedocs.bat

if exist %LOCATION%\\%APP% rmdir /S /Q %LOCATION%\\%APP%

if not exist "%LOCATION%" mkdir %LOCATION%

xcopy /E build\install %LOCATION%
xcopy /E build\Docs %LOCATION%\\%APP%\Docs\

%LOCATION%\\%APP%\\bin\\%APP%
