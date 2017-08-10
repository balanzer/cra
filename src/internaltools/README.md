### Contents ###
[Top](#top)

GT Digital Marketing Share Point <a href="https://ihg.sharepoint.com/sites/gtdigitalmarketing/SitePages/Home.aspx">Here</a>

1. [Build](#build)
1. [Testing](#testing)
1. [Sonar](#sonar)
1. [Code Coverage](#coverage)
1. [JSON Validation](#json-validation)
1. [CRA REST Service](#cra-rest-service)
1. [CRA Setup](#cra-setup)
1. [CRA Setup Angular](#cra-setup-angular)
1. [Eclipse Setup](#eclipse-setup)
1. [Tomcat Setup](#tomcat-setup)
1. [Postman Setup](#postman-setup)
1. [Installation](#installation)
1. [Useful Links](#useful-links)
### Build ###

Maven: Builds REST Service & Angular Project 
```xml
	<modules>
		<module>domain</module>
		<module>email-service</module>
		<module>dao-jpa-impl</module>
		<module>services</module>
		<module>service-impl</module>
		<module>api</module>
		<module>apps</module>
	</modules>
```

Maven Build: Commands
```xml
mvn clean install  - for complete build (will not run integration tests)

mvn install -Dmaven.test.skip=true (to skip unit tests)

```

[Top](#top)

### Testing ###

Integration Tests: To run integration tests from command line
```xml
mvn integration-test -P integration

mvn integration-test -P integration -Dserver.port=8081 -Dserver.host=http://localhost   - this command you can use if the host or port number is different from default.
```

[Top](#top)

### Sonar ###

Sonar report: 
```xml
mvn clean install 

mvn sonar:sonar 

or 

mvn clean verify sonar:sonar	
```
[Sonar Installation](#sonar-installation)  [Sonar Report](#sonar-report)

[Top](#top)

### Sonar Report ###

Sonarqube: 
1. Start Sonarqube 
1. Run [Sonar](#sonar)
1. Open <a href='http://localhost:9000/'>Sonar Report</a> 

[Top](#top)

### Code Coverage ###

Eclemma:
1. install Eclemma for eclipse - <a href ="http://www.eclemma.org/installation.html">setup & run</a>
2. Jacoco report - Right Click Project->Run as ->Maven test. Jacoco output report will be generated in target directory under jacoco-ut folder
3. Clicking on each method in above figure gives detailed report

[Top](#top)

### JSON Validation ###
Json Schema: 

1. Create Schema(For validation) <a href="https://jsonschema.net/#/editor">jsonschema</a>

[Top](#top)


### CRA REST Service ###
Service: Change host name and port based on your application configuration

1. GET All - (local - from eclipse) http://localhost:8081/cra/ (Tomcat or QAP) http://localhost:8080/api/cra/
1. GET - (local - from eclipse) http://localhost:8081/cra/1 (Tomcat or QAP) http://localhost:8080/api/cra/1 
1. POST - (local - from eclipse) http://localhost:8081/cra/ (Tomcat or QAP) http://localhost:8080/api/cra/   
1. PUT  - (local - from eclipse) http://localhost:8081/cra/1 (Tomcat or QAP) http://localhost:8080/api/cra/1 
1. DELTE - (local - from eclipse) http://localhost:8081/cra/1 (Tomcat or QAP) http://localhost:8080/api/cra/1 

[Top](#top)

### CRA Setup ###
Service Setup:
1. Fork skunkworks-insider repo - with your network ID
1. Download CRA project from your GIT Repo - http://sdlcscm.hiw.com/users/<network-id>/repos/skunkworks-insider/browse
1. git clone ssh://git@sdlcscm.hiw.com:7999/<network-id>/skunkworks-insider.git cra
1. Nagivate to /cra/skunkworks-insider/src/internaltools
1. build - [Build](#build)
1. tomcat - [Tomcat Setup](#tomcat-setup)
1. Validate Service - [CRA REST Service](#cra-rest-service) or using postman [Postman Setup](#postman-setup) 
1. Validate UI - [CRA Setup Angular](#cra-setup-angular)

[Top](#top)

### CRA Setup Angular ###
UI Setup

1. install node js [Installation](#installation)
1. verify node js installation - open terminal and execute version (`node -v`)
1. Install Angular CLI - open terminal and execute (`npm install -g @angular/cli`)  More help and documents - [Useful Links](#useful-links)
1. verfiy cli installation - open terminal and execute version (`ng -v`)
1. open cra app in terminal (/skunkworks-insider/src/internaltools/apps/cra-app)
1. start application - in terminal execute (`ng serve`)
1. validate - open in browser http://localhost:4200/
1. Change Port if reqd - (`ng serve --host 0.0.0.0 --port 4201`)
1. use when you have backend running locally (`npm start`) or (`ng serve --proxy-config proxy.conf.json`)  to start with proxy config 


[Top](#top)


### Eclipse Setup ###
Format & Save Actions for Java/Java Script/Type Script: 

1. Format & Cleanups - import confiurations from skunkworks-insider\eclipse_format
1. Save Actions - Refer Murali eclipse setup for now(To be added asap)
1. Import project (Dont not import UI project)
1. Create new workspace for Angular Project 

[Top](#top)

### Tomcat Setup ###

1. Install tomcat - [Installation](#installation)
1. Copy api.war and cra.war to webapps folder 
1. http://localhost:8080/api/cra/  for service
1. http://localhost:8080/cra/ for UI

[Top](#top)


### Postman Setup ###
1. install postman - [Installation](#installation)
1. All operation requires SM_USER header param - Add key SM_USER and Value <NETWORK ID>

[Top](#top)


### Installation ###

Softwares:

1. Java 8 <a href="https://java.com/en/download/manual.jsp">here<a>
1. Eclipse Neon <a href="https://www.eclipse.org/downloads/packages/release/neon/3">here</a>
1. Tomcat 9 <a href="https://tomcat.apache.org/">here</a>
1. Postman <a href="https://www.getpostman.com/apps">here</a>
1. NodeJS <a href="https://nodejs.org/en/">here</a> v6.11.* or higher
1. Angular CLI <a href="https://cli.angular.io/">here</a>


[Top](#top)


### Sonar Installation ###

1. Download Sonar <a href="https://www.sonarqube.org/downloads/">Latest version</a>
1. Extract or Install to local (let's say in "C:\sonarqube" or "/etc/sonarqube")
1. Start the SonarQube server
```xml
On Windows, execute:
C:\sonarqube\bin\windows-x86-xx\StartSonar.bat
 
On other operating system, execute:
/etc/sonarqube/bin/[OS]/sonar.sh console
```
Browse the results at http://localhost:9000 (default System administrator credentials are admin/admin)

*We dont need sonar scanner

[Top](#top)

### Useful Links ###

1.angular-cli Installation & Additional Commands <a href="https://github.com/angular/angular-cli/wiki">here</a> and <a href="https://github.com/angular/angular-cli"> here</a>

[Top](#top)