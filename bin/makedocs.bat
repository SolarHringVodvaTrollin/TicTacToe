xcopy /Y "README.md" src\markdown\

call gradlew.bat markdownToHtml
call gradlew.bat javadoc