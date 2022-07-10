# NVDA Controller Client for Java
Tiny Java bindings for the [NVDA](https://www.nvaccess.org) Controller Client.

## Using

### Gradle
You can add a Gradle dependency for this library using the following Maven repository and dependency:

```gradle
repositories {
  maven { url = 'https://maven.gegy.dev' }
}

dependencies {
  implementation 'dev.gegy:nvda-controller-client-java:1.0.0'
}
```

### Calling the controller
Access to the NVDA controller needs to go through an instance of `NvdaControllerClient`, which can be created by calling `NvdaControllerClient.create()`.

For example, to narrate `Hello world!`:
```java
final NvdaControllerClient nvda = NvdaControllerClient.create();

if (nvda.isRunning()) {
    nvda.speak("Hello world!");
}
```
