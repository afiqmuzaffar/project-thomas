# project-thomas
Welcome to project-thomas! This is a chatbot written in 100% pure Java. It relies on Apache's OpenNLP and MongoDB to provide its core functionality. project-thomas was designed from the ground up to be library making it easy to deploy as a desktop app *(See [thomas-client](https://github.com/mxtt-mmxix/thomas-client))*, web app, command-line utility, or whatever suits your needs.

## How it works
Essentially, project-thomas takes in a sentence. It analyzes that sentence and catogorizes it. It will respond to the user with the appropriate data, or update its database based on the context of the sentence.

## How to use it
1. Install [Apache Maven](https://maven.apache.org/download.cgi).
2. Clone this repository.
3. Navigate to folder where you cloned it.
4. Run `mvn clean install` to install project-thomas to your local repository
5. Add the following to your pom.xml in your project. (If you want a live demo instead see [thomas-client](https://github.com/mxtt-mmxix/thomas-client))
```xml
<dependency>
    <groupId>app.mccall</groupId>
    <artifactId>project-thomas</artifactId>
    <version>1.0-SNAPSHOT</version>
    <scope>compile</scope>
</dependency>
```
