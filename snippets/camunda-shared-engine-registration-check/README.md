# Have a quick look at the internal ProcessApplication registry

camunda BPM provides the shared engine running with multiple processes in different process applications. This small deployments provides a Servlet at:

 http://localhost:8080/camunda-shared-engine-registration-check/registrations
 
and prints the registry in the browser in order to do diagnossis in case of any problems.

It shows
 deploymentId -> Process Application Name

![Screenshot][1]

[1]: https://raw.github.com/camunda/camunda-consulting/master/snippets/camunda-shared-engine-registration-check/screenshot.png

# Getting Started

* Clone this repo and build the projects using Maven
* Deploy the  WARs on the container (*tested with JBoss AS 7*)

# The Alternative: JMX / JConsole

Please note that you can retrieve the information via JMX as well - so e.g. on Tomcat this can be done by using jconsole which displays the same information - here I have multiple engines running:

![JConsole][2]

[2]: https://raw.github.com/camunda/camunda-consulting/master/snippets/camunda-shared-engine-registration-check/jconsole.png