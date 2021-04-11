#  [Catalog Service](https://fameoflight.atlassian.net/wiki/spaces/CS/pages/65542/Assignment+-+Landing+Page)

This service is responsible for service catalog queries.

## Getting Started ##
https://fameoflight.atlassian.net/wiki/spaces/CS/pages/65542/Assignment+-+Landing+Page

### Prerequisites ####
* Java 11
* Maven
* Spring Boot
* MongoDB 
* InfluxDB
* Chronograf

### Building and Running
You can now bring up the service by following steps mentioned. 
* mvn clean install
* java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5006 -jar ${JAR_PATH}/catalog-service.jar 

## Environments   ##
### Dev - Environments   ###
* Service Host IP: ```127.0.0.1``` , Port : ```8081```
* Influx Database   : Host IP: ```127.0.0.1``` , Port : ```8086```

## Dashboards

* Chronograf : [Grafana Link](http://localhost:8888/sources/1/dashboards/9?refresh=10s&lower=now%28%29%20-%2015m#)

##Run on local
In order to run this application we need following stack :-
[Mandatory] MongoDB, From where application will fetch/push data.
[Optional] InfluxDB, Time series database where this application will push metrics for monitoring
[Optional] Chronograf, To visualize our monitoring data and easily create alerting and automation rules.