# ljc-lightning-multi-release-jars

Repo containing the sample used for my London Java Community lightning talk
about MultiRelease jars.

The code in the `src/main/java` folder compiles and runs on Java 8. The code in the `src/main/java9` folder overrides the `PidUtil` class when run on Java 9 or later, and needs to be compiled with Java 9 or later.

If you build with Java 8 nothing special happens, you just get the normal Java 8 stuff from the `src/main/java` folder.

If you build with Java 9 or higher, the `java9-mr-build` profile kicks in which compiles the Java 9 classes from the `src/main/java9` folder. Then when you run `java -jar target/ljc-lightning-multi-release-jars-1.0.0-SNAPSHOT.jar`, the version of `PidUtil` that gets loaded depends on the Java version used to run it. If you run with Java 9 or higher you get the one from the `src/main/java9` folder. If you run with Java 8 you get the one from the `src/main/java` folder.


Slides: https://docs.google.com/presentation/d/1p-qKbWt795JmlhbD6WTBJcO4em6K2w4tTb6nqLkLbho/edit?usp=sharing

Some blogs which are useful background info:
* http://word-bits.flurg.com/multrelease-jars/ (dmlloyd)
* https://in.relation.to/2017/02/13/building-multi-release-jars-with-maven/

Also the [Multi-Release](https://maven.apache.org/plugins/maven-compiler-plugin/multirelease.html) page of the Maven compiler plugin gives a good introduction about challenges with supporting several Java versions using this and other legacy approaches.

The pom in this repository essentially:
* Uses the latest Maven Compile plugin at the time of writing
* Compiles the code from `src/main/java/` using whatever JDK you are using, and uses Java 8 as the target.
* Activates a profile if Java 9 or later is used, which:
    * Sets the `Multi-Release: true` entry in the jar
    * Compiles the code from `src/main/java9/` using Java 9 as the target, and outputs it to the `classes/META-INF/versions/9/` directory.
* Skips the complexities of supporting Java 10 and later in addition to Java 9 :)
* Skips the complexities of testing across several versions.

Both JBoss and SmallRye have parent poms which support Multi-Release Jars and all the things I left out of my demo. Each parent pom project has an extensive readme, and of course look in the pom itself.
The links are to the current latest tag of each, you should of course look for the latest tag.
* JBoss [[parent]](https://github.com/jboss/jboss-parent-pom/blob/jboss-parent-37/README.adoc#multi-release-jars) [[pom]](https://github.com/jboss/jboss-parent-pom/blob/jboss-parent-37/pom.xml#L874-L1446)
* SmallRye [[parent]](https://github.com/smallrye/smallrye-parent/tree/23) [[pom]](https://github.com/smallrye/smallrye-parent/blob/23/pom.xml#L559-L1336)

Some example usage of each of these parents can be found at:
* https://github.com/smallrye/smallrye-common/tree/1.4.0/cpu (uses the SmallRye one)
* https://github.com/wildfly/wildfly/tree/21.0.0.Final/clustering/ee/cache (uses the JBoss one, although you have to go through a few levels of parent poms to get there!)
