# Utiliser l'image de base officielle de Spring Boot
FROM openjdk:11-jre-slim

# Ajouter un volume pour stocker les logs
VOLUME /tmp

# Ajouter l'application JAR au conteneur
COPY target/AtlasVoteGate-0.0.1-SNAPSHOT.jar app.jar

# Exposer le port 8080
EXPOSE 8080

# Définir la commande pour exécuter l'application
ENTRYPOINT ["java","-jar","/app.jar"]
