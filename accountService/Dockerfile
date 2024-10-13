# Étape de construction
FROM openjdk:11-slim as build

ARG JAR_FILE
COPY ${JAR_FILE} app.jar
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf /app.jar)

# Étape de finalisation
FROM openjdk:11-slim

# Installer curl pour les health checks
RUN apt-get update && apt-get install -y curl && apt-get clean

VOLUME /tmp

# Définir la variable DEPENDENCY et copier les fichiers nécessaires
ARG DEPENDENCY=/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

# Copier le script wait-for-it.sh
COPY scripts/wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

# Copier le script entrypoint.sh
COPY scripts/entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh

# Définir l'URL de santé de l'application
ENV HEALTH_URL="http://localhost:8072/actuator/health"

# Utiliser le script entrypoint.sh comme point d'entrée
ENTRYPOINT ["/entrypoint.sh"]
