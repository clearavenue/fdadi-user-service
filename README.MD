docker build -t clearavenue/fdadi-user-service .
docker run --rm -it --name fdadi-user-service --net fdadi-bridge -p 8082:8082 clearavenue/fdadi-user-service

