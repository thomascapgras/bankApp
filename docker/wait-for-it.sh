#!/bin/bash

# Script to check the health endpoint before starting the service
until curl -s $HEALTH_URL | grep '"status":"UP"' > /dev/null; do
  echo "Waiting for the service to be healthy at $HEALTH_URL..."
  sleep 5
done

# If healthy, start the service
echo "Service is healthy, starting application..."
exec "$@"
