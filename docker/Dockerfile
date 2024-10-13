FROM postgres:latest

ENV POSTGRES_DB=bank-dev
ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=root

# Copier le fichier de dump dans le conteneur
COPY travel-booking-dev.dump /docker-entrypoint-initdb.d/

# Script de restauration qui sera exécuté au démarrage du conteneur
COPY restore.sh /docker-entrypoint-initdb.d/restore.sh

RUN chmod +x /docker-entrypoint-initdb.d/restore.sh
