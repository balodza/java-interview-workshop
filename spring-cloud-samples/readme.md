spring-cloud-server
takes data from git repo located at :
{user-home}/config-repo

and shared as config service config.

spring-cloud-client

takes config from config-service server
and returns some values of it to
http://localhost:8887/app/info