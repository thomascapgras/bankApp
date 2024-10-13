#!/bin/bash
set -e

# Restaurer la base de données à partir du dump
pg_restore -U postgres -d $POSTGRES_DB /docker-entrypoint-initdb.d/travel-booking-dev.dump

# Démarrer le service PostgreSQL
exec postgres
