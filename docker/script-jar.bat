cd D:\bank-app\accountService
call mvn clean package -DskipTests

cd D:\bank-app\customerService
call mvn clean package -DskipTests

cd D:\bank-app\transactionService
call mvn clean package -DskipTests

cd D:\bank-app\configServer
call mvn clean package -DskipTests

cd D:\bank-app\EurekaServer
call mvn clean package -DskipTests

cd D:\bank-app\gatewayServer
call mvn clean package -DskipTests

cd D:\bank-app\docker
