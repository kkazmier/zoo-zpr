# zoo-zpr spring boot application
## technology stack
- spring boot
- H2 database
- gradle
## run

```shell
git clone https://github.com/kkazmier/zoo-zpr
cd zoo-zpr
gradle bootRun
```

## endpoints
- animals
  - get all animals ```GET``` ```/animal/getAll``` 
  - get all animals by name ```GET``` ```/animal/getAllByName/{name}```
  - add animal to zone ```POST``` ```/animal/addNewAnimalToZone/{zoneId}```
  - return full info about animal (id, name, zone name, type,... etc) ```GET``` ```/getAnimalFullInfo/{id}```
- zone
  - get all zones ```GET``` ```/zone/allZones```
  - create new zone ```POST``` ```/zone/new```
  - get all animals from given zone ```GET``` ```getAnimalsFromZone/{zoneId}```
- report
  - return zone with least animal quantity ```GET``` ```/report/leastPopulatedZone```
  - return zone with greatest feed consumption ```GET``` ```/report/zoneOfGreatestConsumption```
