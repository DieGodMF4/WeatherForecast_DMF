# Weather Forecast - REST API
This code was originally made for the subject of DACD (*Applications Development for Data Science*); taught in the Degree
of Data Science and Engineering, at University of Las Palmas de Gran Canaria (ULPGC), Spain.

### Main purpose & functionality
Java program made for extracting weather information from a REST Api through the page **OpenWeather**. \
[*Link to page*](https://openweathermap.org)


## Execution

For the execution of the code, you will first need to be in the **Main.java** class: (```src/main/java/marrero_ferrera_gcid_ulpgc/test/control/Main.java```). \
After that, you can freely start debugging and run de code, and it will ask for an **API Key** and the **database name and path**.


In the following line, you will have an example suitable API Key for making the call to the REST Api, and a simple path to create the database: \
\
Suitable free API Key: ```3c3aea5ce433b076c2f83b0c608896d8``` \
Example of the database name: ```weatherDataBase``` 


**Disclaimers:**
- You can select your database name and path; however, **table name** and **table attributes** are fixed in code and can not be changed. _(Table called weatherDataBase with 11 attributes)._
- The provided **API Key** is just an example free one created to ease the process of execution. By now, the [terms of the free plan](https://home.openweathermap.org/subscriptions) admit up to 1,000 calls per day to the same API (which is difficult to exceed).

# Resources
1. This project was fully made on **[IntelliJ IDEA](https://www.jetbrains.com/es-es/idea/)**, by JetBrains 
