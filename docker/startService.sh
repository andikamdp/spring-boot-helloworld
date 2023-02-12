docker stop helloworld;
docker rm helloworld;
docker rmi helloworld;
docker build -t helloworld .;
docker run --network bridge -d -p 5051:8080 --name ranmuh-practice-helloworld --restart=on-failure helloworld