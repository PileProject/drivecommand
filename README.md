DriveCommand
=====
master: [![Build Status](https://travis-ci.org/PileProject/drivecommand.svg?branch=master)](https://travis-ci.org/PileProject/drivecommand)

develop: [![Build Status](https://travis-ci.org/PileProject/drivecommand.svg?branch=develop)](https://travis-ci.org/PileProject/drivecommand)

A general library written in Java which enables robots and devices
to communicate with each other through the same interface.

### Available robots
We currently support 3 robots:
- [LEGO MINDSTORMS NXT](https://shop.lego.com/en-US/LEGO-MINDSTORMS-NXT-2-0-8547)
- [LEGO MINDSTORMS EV3](https://shop.lego.com/en-US/LEGO-MINDSTORMS-EV3-31313)
- [PILE Original Robot](http://pileproject.com/en.html)

They can communicate with any device (PC, Android, etc.) with this library.

## Installation
### From gradle
Please write the following codes in your `build.gradle`.

```
repositories {
    maven { url 'http://pileproject.github.io/drivecommand/' }
}

dependencies {
    compile 'com.pileproject:drivecommand:VERSION'
}
```

[v2.3.0](https://github.com/PileProject/drivecommand/releases/tag/v2.3.0) is the latest version.

### From jar file
After building sources (See [Build](#build)),
you can find `drive-command.jar` in `build/libs`.

## Build
Linux & OS X:

```sh
./gradlew build
```

Windows:

```sh
./gradlew.bat build
```


## Run Test and Generate Javadoc
Linux & OS X:

```sh
./gradlew test
./gradlew javadoc
```

Windows:
```sh
./gradlew.bat test
./gradlew.bat javadoc
```

Test reports will be generated in build/reports/tests (See index.html).
Javadocs will be generated in build/docs/javadoc (See index.html).


## Usage example
To use this library, you should prepare an implementation of
[`ICommunicator`][ICommunicator] to specify the master device (PC, Android, etc.).

As an example, we are developing [drive][drive],
an Android application that controls EV3/NXT/Pile Robot
and it uses [`BluetoothCommunicator`][BluetoothCommunicator],
which is an implementation of `ICommunicator`,
to control robots
with an Android device via Blutooth.
<!--
In `BluetooothCommunicator`,
we open Input/Output streams to communicate robots in `open()`
and close them in `close()`.
-->

After preparing an implementation of `ICommunicator`,
you can make an object of an implementation of [`MachineBase`][MachineBase]
and access to a robot.
In [drive][drive],
we create a machine like the following (using [`NxtMachine`][NxtMachine]):

```java
// preparation (create an BluetoothDevice with MAC address)
BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
BluetoothDevice device = adapter.getRemoteDevice(address);

NxtMachine machine = new NxtMachine(new BluetoothCommunicator(device));
```

## Development setup
Please fork this repository, modify it and send Pull Request.

If you want to make more machines available like Drone,
you can follow the below steps.

1. Make a folder in [`model`][model] folder
The new folder should be named after your device like `drone`.

2. Implement an implementation of `MachineBase` and related classes
There are 3 examples ([ev3][ev3], [nxt][nxt], [pile][pile]).
They contain implementations of `MachineBase` and Input/Output port classes, etc.


## Release History
* 2.3.0
    * CHANGE: Rename `LineSensor` to `LightSensor`
* 2.2.0
    * CHANGE: Clean up JavaDocs
* 2.1.1
    * CHANGE: Remove `timeout` from write/read
    * ADD: Add more tests
* 2.1.0
    * CHANGE: Update test libraries
* 2.0.1
    * CHANGE: Remove `applyStatus()`
* 2.0.0
    * CHANGE: Refactor codes roughly
    * Release: The first proper release
* 1.0.0
    * First: Import our old library from bitbucket

## Meta
PILE Project – [@pileproject](https://twitter.com/pileproject) - dev@pileproject.com

Distributed under the Apache License, Version 2.0. See ``LICENSE`` for more information.

Let's discuss anything on our [Mailing List](https://groups.google.com/forum/#!forum/pile-dev)!

[drive]: https://github.com/PileProject/drive
[ICommunicator]: https://github.com/PileProject/drivecommand/blob/develop/src/main/java/com/pileproject/drivecommand/model/com/ICommunicator.java
[BluetoothCommunicator]: https://github.com/PileProject/drive/blob/develop/app/src/main/java/com/pileproject/drive/comm/BluetoothCommunicator.java
[MachineBase]: https://github.com/PileProject/drivecommand/blob/develop/src/main/java/com/pileproject/drivecommand/machine/MachineBase.java
[NewMachine]: https://github.com/PileProject/drive/blob/develop/app/src/nxt/java/com/pileproject/drive/execution/NxtExecutionActivity.java#L38
[NxtMachine]: https://github.com/PileProject/drivecommand/blob/develop/src/main/java/com/pileproject/drivecommand/model/nxt/NxtMachine.java
[model]: https://github.com/PileProject/drivecommand/tree/develop/src/main/java/com/pileproject/drivecommand/model
[ev3]: https://github.com/PileProject/drivecommand/tree/develop/src/main/java/com/pileproject/drivecommand/model/ev3
[nxt]: https://github.com/PileProject/drivecommand/tree/develop/src/main/java/com/pileproject/drivecommand/model/nxt
[pile]: https://github.com/PileProject/drivecommand/tree/develop/src/main/java/com/pileproject/drivecommand/model/pile
