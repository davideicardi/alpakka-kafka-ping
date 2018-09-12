# alpakka-kafka-ping

Scala app written in Alpakka to test Kafka connectivity


## Generate package

    sbt clean universal:packageBin

## Run

Run:

    curl -O https://davideshare.blob.core.windows.net/public/alpakka-kafka-ping/application.conf
    curl -O https://davideshare.blob.core.windows.net/public/alpakka-kafka-ping/log4j2.xml
    # Modify configuration files according to your needs
    curl -O https://davideshare.blob.core.windows.net/public/alpakka-kafka-ping-0.1.zip

    unzip alpakka-kafka-ping-0.1.zip

    ./alpakka-kafka-ping-0.1/bin/alpakka-kafka-ping \
        -Dconfig.file=./application.conf \
        -Dlog4j.configurationFile=./log4j2.xml


## Kerberos
        
To enable kerberos authentication use

    ./alpakka-kafka-ping-0.1/bin/alpakka-kafka-ping \
        -Dconfig.file=./application.conf \
        -Dlog4j.configurationFile=./log4j2.xml \
        -Djava.security.auth.login.config=./jaas.conf    
TODO
