# Demonstration of a maven native image with GraalVM

This project is a very simple exemple of using graalVM with maven.
It aims at testing the visualvm monitoring on windows and linux.

The main build option tested is `--enable-monitoring=all` as described in : https://www.graalvm.org/latest/reference-manual/native-image/overview/Options/

The java algorithm is a simple Prime number calculation that runs directly on start-up from the cli.
It runs approximatively 40s on my desktop (a core i7) so that we have the time to start visualvm and attach to the running program (java or native image).

It has been tested and runs smoothly on windows 10 and for linux on Ubuntu 22.04.

The conclusion is that the `--enable-monitoring=all` option works fine on linux and we can attach with visualvm to the native image easily.

:warning: **Warning:** But on wiwdows, it does not work : the native processus does never appair in visualvm :(



## building it

The tested build environment is with the following versions : 

* Java 22.0.2, distribution Temurin 64 bits, windows and linux versions : https://adoptium.net/temurin/releases/
* GraalVM 22.0.2, community edition https://github.com/graalvm/graalvm-ce-builds/releases
* maven 3.8.8

For native image generation on windows, use visual studio 2022 community edition as described here : https://www.graalvm.org/latest/docs/getting-started/windows/
For linux native image generation on Ubuntu, use gcc as described here : https://www.graalvm.org/latest/reference-manual/native-image/

For visualvm, simply unzip the visualvm 2.1.9 version from : https://visualvm.github.io/download.html

Simply set the correct environnement variable JAVA_HOME, MVN_HOME, GRAALVM_HOME and PATH to installed versions and build is done by : 

`mvn clean package`
