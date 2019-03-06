# rabbitmq-nxt-service
This is a POC project for Rabbit MQ(RMQ) using Spring-boot 2.1.2.RELEASE


Scope
=====
1. Publish the message to RMQ
2. Listen the message from RMQ


Capabilities
============
1. Docker image for rabbitmq creation
2. More on the way.........


One time setup
==============
  1. Make sure Docker Desktop running...
  2. docker-compose run rabbitmq
  	
	Note : 
		a.) This will create a image in your docker container
		b.) Make sure you got below trace
			Server startup complete; 3 plugins started.
			rabbitmq_management
			rabbitmq_management_agent
			rabbitmq_web_dispatch
			
  3. Kill the run process (Ctrl + C). 
  4. docker-compose up
  
	Make sure we got below trace at end
		Server startup complete; 3 plugins started.
		rabbitmq_1  |  * rabbitmq_management
		rabbitmq_1  |  * rabbitmq_management_agent
		rabbitmq_1  |  * rabbitmq_web_dispatch
		
  5. Make sure RMQ host is up, http://localhost:15672 
  
  	Note: RMQ mapped to port 15672 , UN : guest and PW : guest
		
  6. Kill the running rabbitmq service 
  7. Check the image are available. docker-compose images
  
	Container       Repository       Tag          Image Id      Size 
	---------------------------------------------------------------------
	docker_rabbitmq_1   rabbitmq     3-management   a7f2574d507f   201 MB


Application running
===================
1. docker-compose up
2. Make sure RMQ host is up, http://localhost:15672 
	

Notes
=====

1. Adde the run_rabbitmq.sh file to perfrom the all one time setup commands
2. Docker hub view in laptop
3. Paths

		home dir       : /var/lib/rabbitmq
		config file(s) : /etc/rabbitmq/rabbitmq.conf
		cookie hash    : TUOW07tdtfLrYCUJxPsL9Q==
		log(s)         : <stdout>
		database dir   : /var/lib/rabbitmq/mnesia/rabbit@5f42ec273861
