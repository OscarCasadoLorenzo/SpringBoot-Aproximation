## POSTGRESQL SETUP
### STEP 1: Create Docker container
docker run --name virtualtravelDB -p 5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=passwd -e POSTGRES_DB=virtualtravel postgres

### STEP 2: See if it is running
docker container ls

### STEP 3: PostgreSQL login
psql -U postgres

### STEP 4: Access to DB
\c virtualtravel

### STEP 5: Show tables 
\dt+

### STEP 6: Query for data
SELECT * FROM person;

## KAFKA SETUP 
#### STEP 1: DOWNLOAD AND INSTALL KAFKA
https://dlcdn.apache.org/kafka/3.2.0/

####  STEP 2: START THE KAFKA ENVIRONMENT
Start the ZooKeeper service
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

Start the Kafka service
.\bin\windows\kafka-server-start.bat .\config\server.properties

#### STEP 3: CREATE A TOPIC TO STORE YOUR EVENTS
.\bin\windows\kafka-topics.bat --create --topic checkTickets --bootstrap-server localhost:9092
.\bin\windows\kafka-topics.bat --create --topic confirmTickets --bootstrap-server localhost:9092

#### STEP 4: WRITE SOME EVENTS INTO THE TOPIC
.\bin\windows\kafka-console-producer.bat --topic checkTickets --bootstrap-server localhost:9092

#### STEP 5: READ THE EVENTS
.\bin\windows\kafka-console-consumer.bat --topic checkTickets --from-beginning --bootstrap-server localhost:9092