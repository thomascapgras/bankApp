#!/bin/bash

# Démarrer l'application Java en arrière-plan
java -cp app:app/lib/* com.myBank.accountService.AccountServiceApplication &

# Attendre quelques secondes pour laisser l'application démarrer
sleep 10

# Boucle de vérification de l'état de santé
while ! curl -s $HEALTH_URL | grep '"status":"UP"' > /dev/null; do
  echo "Waiting for the service to be healthy at $HEALTH_URL..."
  sleep 5
done

echo "Service is healthy!"

# Attendre que le processus Java se termine
wait
