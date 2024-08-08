# Utiliser l'image officielle de PostgreSQL comme image de base
FROM postgres:latest

# Définir les variables d'environnement pour l'utilisateur, le mot de passe et la base de données PostgreSQL
ENV POSTGRES_USER=Doranco
ENV POSTGRES_PASSWORD=Tigre
ENV POSTGRES_DB=mypostgres_doranco

# Exposer le port 5432 pour PostgreSQL
EXPOSE 5432

# Lancer PostgreSQL en utilisant l'entrée de commande par défaut
CMD ["postgres"]
