#### STEP 1: DOWNLOAD AND INSTALL KAFKA  
https://dlcdn.apache.org/kafka/3.2.0/

####  STEP 2: START THE KAFKA ENVIRONMENT  
Start the ZooKeeper service
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

Start the Kafka service
.\bin\windows\kafka-server-start.sh .\config\server.properties

#### STEP 3: CREATE A TOPIC TO STORE YOUR EVENTS  
.\bin\windows\kafka-topics.bat --create --topic javaguides --bootstrap-server localhost:9092

#### STEP 4: WRITE SOME EVENTS INTO THE TOPIC  
.\bin\windows\kafka-console-producer.bat --topic javaguides --bootstrap-server localhost:9092

#### STEP 5:  READ THE EVENTS
.\bin\windows\kafka-console-consumer.bat --topic javaguides --from-beginning --bootstrap-server localhost:9092
