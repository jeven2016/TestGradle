
### contract test tasks
```gradle
gradle build
gradle install   -- install stubs jar locally
gradle verifierStubsJar  -- generate a stubs jar locally
gradle generateClientStubs 
gradle copyContracts  
gradle copyContracts 

gradle generateContractTests test
```

### For rest service 
in rest-server project, execute the following command to publish a stubs jar to remote nexus repository
```groovy
  gradle publish
```
Then execute contract test in rest-client project, and the stubs jar will be downloaded at runtime by contract test plugin.
```groovy
  gradle build
```

##3 For rest-client-stubs-dep
the application.yml configured the stubrunner to specify where to download the stubs jar 