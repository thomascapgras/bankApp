cd D:\bank-app\accountService
docker build --build-arg JAR_FILE=target/accountService-0.0.1-SNAPSHOT.jar -t myBank/accountservice-image .

cd D:\bank-app\customerService
docker build --build-arg JAR_FILE=target/customerService-0.0.1-SNAPSHOT.jar -t myBank/customerservice-image  .

cd D:\bank-app\transactionService
docker build --build-arg JAR_FILE=target/transactionService-0.0.1-SNAPSHOT.jar -t myBank/transactionservice-image .

cd D:\bank-app\configServer
docker build --build-arg JAR_FILE=target/configServer-0.0.1-SNAPSHOT.jar -t myBank/configserver-image .

cd D:\bank-app\EurekaServer
docker build --build-arg JAR_FILE=target/EurekaServer-0.0.1-SNAPSHOT.jar -t myBank/eurekaserver-image .

cd D:\bank-app\gatewayServer
docker build --build-arg JAR_FILE=target/gatewayServer-0.0.1-SNAPSHOT.jar -t myBank/gatewayserver-image .

cd D:\bank-app\docker