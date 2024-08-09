Pour lancer la base de donnée pgadmin
docker build -t mypostgres-doranco . 
docker run -d --name mypostgres-doranco -p 5432:5432 mypostgres-doranco

Puis simplement run l'application MvcdorancoApplication
Application disponible sur http://localhost:8080