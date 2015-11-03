# Development manual #

For development of this game you need to follow through the steps below and make sure you have all required tools.

Go to bottom page for list of all tools and requirements that were used for developing this project. 

----------
1. The code is written in Java (v.1.8) so in order to run the application you need to have java jdk installed. If haven't got it already you follow the links below:


  -  [Download Java JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
  -  [Instructions for installing Java JDK](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html#CJAGAACB)
  	
2. We decided to use the text editor Sublime Text but any other editor that supports Java will do. If you don't have an editor, you can download [Sublime Text here.](http://www.sublimetext.com/) 

3. TicTacToe is hosted on [GitHub](http://www.github.com) so we encourage developers to continue using it, as it is associated with the Continuos Integration System [Travis](https://travis-ci.org/).
	- [Instructions to install Git](http://https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
	- [Getting started with GitHub](https://help.github.com/articles/set-up-git/)
	- [Getting started with Travis](http://docs.travis-ci.com/user/getting-started/)

4. Now you should have all tools required so far, and you can clone from GitHub using Git Bash: 

   		 $ git clone https://github.com/SolarHringVodvaTrollin/TicTacToe.git 

5. Gradle is a build system that took care of the build process, fetching dependencies, creating Java Documentation and converting other documentation to HTML. 
Gradle wrapper is included so installation is not required. 

## Useful commands ##
	
**Building**
	  	
`.\bin\build` for Unix 

`.\bin\build.bat` for Windows 

**Deploying**

`.\bin\install` for Unix 

`.\bin\install.bat` for Windows

These commands are sufficient to run the program as it is, but it might come useful to use Gradle later on. 

**Building**
	  	
`.\gradlew build` for Unix 

`.\gradlew.bat build` for Windows 

**Deploying**

`.\gradlew install` for Unix 

`.\gradlew.bat install` for Windows

**View all tasks runnable from root project**
	  	
`.\gradlew tasks`

## List of tools used for developing ##

- Trello
- Java Development Kit 8*
- GitHub*
- Sublime Text
- Gradle
- Travis 
- MarkdownPad 2

**Required*