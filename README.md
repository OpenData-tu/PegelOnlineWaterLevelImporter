# PegelOnlineWaterLevelImporter
- Importer for internal and coastal levels of waterways of Germany
- No need for url (imports the latest measurements automatically)

## Use the docker
#### Pulling the image:
```sh
$ docker pull ahmadjawidjami/pegel_online_importer
```
#### Running with sample environment variables:
```sh
$  docker run \
--env "KAFKA_BOOTSTRAP_SERVERS=localhost:9092" \
--env "KAFKA_BROKER_LIST=localhost:9092" \
--env "KAFKA_TOPIC=waterLevel" \
ahmadjawidjami/pegel_online_importer
```
#### Mandatory enviroment variables:
- KAFKA_BOOTSTRAP_SERVERS
- KAFKA_BROKER_LIST

#### Optional environment variable
- KAFKA_TOPIC &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; //Default is 'waterLevel'

