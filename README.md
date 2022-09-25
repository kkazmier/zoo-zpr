# zoo-zpr spring boot application
## run

```shell
git clone https://github.com/kkazmier/zoo-zpr
cd zoo-zpr
gradle bootRun
```


## endpoints
- animals
  - get all animals ```/animal/getAll``` 
  - get all animals by name ```/animal/getAllByName/{name}```
  - add animal to zone ```/animal/addNewAnimalToZone/{zoneId}```
  - return full info about animal (id, name, zone name, type,... etc) ```/getAnimalFullInfo/{id}```
- zone
  - get all zones ```/zone/allZones```
  - create new zone ```/zone/new```
  - get all animals from given zone ```getAnimalsFromZone/{zoneId}```
- report
  - return zone with least animal quantity ```/report/leastPopulatedZone```
  - return zone with greatest feed consumption ```/report/zoneOfGreatestConsumption```
