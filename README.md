# WorldwideWindsurfersWeatherProject

Application gets forecast for locations in database, calculates best conditions for
windsurfing and returns location with best conditions due to date provided in request argument.

Endpoints:

GET
/bestconditions/{date}  

where date is a date in format yyyy-mm-dd

database used is postgres
insertion file with sample locations is in source directory

table 'locations' creating script is in source directory

you can use docker-compose.yml file in docker direcktory to set up database
just install docker, go to docker directory in terminal and type "docker-compose up -d"

to built and run your application, just clone repository, go to project directory
in terminal and type "mvn install"

have fun!
