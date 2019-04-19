            *********Problem Statement*********
	Build a RESTful service that generates the round robin schedule for the PRO-Kabaddi event that conforms to the following constraints
	Accept N number of teams
	Each team must play against every other team once home and away
	Maximum 2 matches per day are allowed
	No team should play on consecutive days
             **********Solution***********
	Step1
	Clone GIT Repository in local using URL : https://github.com/ysevak1992/Pro-Kabaddi.git
	Step2:
	Start application over embedded tomcat server for spring boot
	Step3: Generate match schedule
	Open browser or postman and try below url
	curl -H "Content-Type: application/json" -X GET http://localhost:8080/prokabaddi/contoller/matchscheduler?ids=1,2&date=20190419