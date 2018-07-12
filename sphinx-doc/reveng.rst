Reverse Engineering a database
==============================

pom
---

.. literalinclude:: reveng-pom.xml

hibernate.properties
--------------------
src/main/resources/hibernate.properties

invocation
----------

mvn -f reveng-pom.xml clean hibernate3:hbm2java compile

This will

* remove the target directory and everything underneath it
* generate the java code for the classes
* compile everything

This will generate the java code in the directory *./target/hibernate3/generated-sources/*
