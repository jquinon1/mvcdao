Change the values of password and database on src/MysqlEstudiante.java to the rigth parameters in your case


To run the app:
1) Create the container where the databases is going to be located

	docker run -d --name db -e MYSQL_ROOT_PASSWORD={root_password} -e MYSQL_DATABASE={database} -e MYSQL_PASSWORD={password}  mysql
2) Copy the database script to the container
	
	docker cp src/database.sql db:/
3) Now create the tables needed by the app
	
	docker exec db /bin/sh -c 'mysql -h 127.0.0.1 -P 3306 -u root -p{root_password} {database} </database.sql'
4) After this, move to src folder and create the java app container
	
	cd src && docker build -t javadbapp .
5) Run the java container
	
	docker run javadbapp

	NOTE: At this point the app are going to fail, don't worry!!
5) Create the link between the containers
	
	docker run --name linkcontainers --link db javadbapp
