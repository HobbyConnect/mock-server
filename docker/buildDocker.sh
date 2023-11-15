echo "Build Project"

cd ..

./gradlew clean build -x test

echo "Build Docker-Image"
docker build -t hobby-connect-mock-server .
docker image tag hobby-connect-mock-server:latest ghcr.io/hobbyconnect/hobby-connect-mock-server:latest
docker image push ghcr.io/hobbyconnect/hobby-connect-mock-server:latest