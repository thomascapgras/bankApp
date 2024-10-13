#!/bin/bash

# Attendre que l'application soit démarrée (par exemple, attendre quelques secondes avant de tester la santé)
sleep 15

# Boucle de vérification de l'état de santé
while ! curl -s $HEALTH_URL | grep '"status":"UP"' > /dev/null; do
  echo "Waiting for the service to be healthy at $HEALTH_URL..."
  curl -s $HEALTH_URL  # Afficher la réponse pour le débogage
  sleep 5
done

echo "Service is healthy!"
