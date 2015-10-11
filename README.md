# DriveCommand
A general library which enables robots and devices to communicate each other through same interface.

## Available Communication
* Android <-> LEGO MINDSTORMS NXT
* Android <-> LEGO MINDSTORMS EV3
* Android <-> Pile Original Robot

## How to use
### From gradle

in your `build.gradle`
```
repositories {
    maven { url 'http://pileproject.github.io/drivecommand/' }
}

dependencies {
    compile 'com.pileproject:drivecommand:VERSION'
}
```

### From jar file
See below

## Build

```
# Linux/Mac
./gradlew build
# Windows
./gradlew.bat build
```

## Run Test and Generate Javadoc

```
# Linux/Mac
./gradlew test
./gradlew javadoc

# Windows
./gradlew.bat test
./gradlew.bat javadoc
```

Test reports are generated in build/reports/tests (See index.html)

Javadocs are generated in build/docs/javadoc (See index.html)

