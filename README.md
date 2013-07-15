dbs-example-jpa-complex
-------------------
Example of complex Spring Data JPA application.  Hibernate is used as JPA implementation.

App is deployed to [dbs-example-jpa-complex][CloudFoundry url].

Documentation:
-------------------
 * [wiki][wiki]
 * Database diagrams:  [Overview ERD][Overview ERD], [MySQL ERD][MySQL ERD]

References:
-------------------
 * [public site for dbs-example-jpa-complex][public site]
 * [JPA annotation documentation][My JPA annotation documentation]
 * [Cloud Foundry deployment][CloudFoundry]
 * [Using Spring Java/Annotation Config instead of XML][Spring Config XML to Java]
 * [GitHub-cheat-sheet][GitHub configuration and settings cheat sheet]

To get the code:
-------------------
Clone the repository:

    $ git clone git:/github.com/Daugherty/dbs-example-jpa-complex

If this is your first time using Github, review http://help.github.com to learn the basics.

To run the application unit-tests:
-------------------	
From the command line with Maven:

    $ cd dbs-example-jpa-complex
    $ mvn test

To install the application:
-------------------	
From the command line with Maven:

    $ cd dbs-example-jpa-complex
    $ mvn install

or

In your preferred IDE such as SpringSource Tool Suite (STS):

* Import "dbs-example-jpa-complex" as a Maven Project
* Drag-n-drop the project onto the "SpringSource tc Server Developer Edition" or another Servlet 2.5 or > Server to run, such as Tomcat.

Access the deployed web application at: http://localhost:8080/dbs-example-jpa-complex/

[My JPA annotation documentation]: http://www.evernote.com/shard/s8/sh/147ea1ec-d9d2-46fd-a0d9-3d2b819703fb/8e476ca6950c7d6c9551dbcc54d8c7f3
[Overview ERD]: https://github.com/johntday/dbs-example-jpa-complex/blob/master/src/main/resources/img/erd.png
[MySQL ERD]: https://github.com/johntday/dbs-example-jpa-complex/blob/master/src/main/resources/img/erd-detail.png
[public site]:  http://johntday.github.io/dbs-example-jpa-complex
[wiki]:  https://github.com/johntday/dbs-example-jpa-complex/wiki
[CloudFoundry]:  http://docs.cloudfoundry.com/docs/dotcom/getting-started.html
[CloudFoundry url]:  http://dbs-example-jpa-complex.cfapps.io
[Spring Config XML to Java]:  http://www.evernote.com/shard/s8/sh/4748cf18-2c5b-4d48-b415-925182c6f15f/0a2883985b1682367bb09612c002fa8c
[GitHub-cheat-sheet]:  http://johntday.github.io/GitHub/