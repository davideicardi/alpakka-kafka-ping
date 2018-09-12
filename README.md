# alpakka-kafka-ping

Scala app written in Alpakka to test Kafka connectivity


## Generate package

    sbt clean universal:packageBin

## Run

Create an `application.conf` to override any settings.

Create a `log4j2.xml` to override log4j settings.

Run:

    unzip alpakka-kafka-ping-0.1.zip
    ./alpakka-kafka-ping-0.1/bin/alpakka-kafka-ping \
        -Dconfig.file=./application.conf \
        -Dlog4j.configurationFile=./log4j2.xml


## Kerberos
        
To enable kerberos authentication add 

    -Djava.security.auth.login.config=./jaas.conf
    
TODO