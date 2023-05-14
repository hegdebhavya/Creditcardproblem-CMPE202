# individual-project-hegdebhavya
individual-project-hegdebhavya created by GitHub Classroom

Student Name: Bhavya Hegde <br>
Student ID: 016656029 <br>
Course: Software Systems Engineering <br>

## Instruction to run the app :
Download the jar file from using this [link](https://github.com/gopinathsjsu/individual-project-hegdebhavya/blob/main/out/artifacts/creditcard_classgen_prj_jar/creditcard_classgen_prj.jar) and run below command from the command line

```
java -jar creditcard_classgen_prj.jar <inputfile csv/json/xml> <output file csv/json/xml>
```
Sample screenshot to run the app: <br>

![image](https://user-images.githubusercontent.com/85700971/236744347-78343618-88b3-47ba-a7bf-ca59e315117e.png)

Sample screenshot of output for the above format : <br>

![image](https://user-images.githubusercontent.com/85700971/236744729-55521a4f-b46a-434a-9fe4-355371b365b3.png)


## Part 1

 #### Describe what is the primary problem you try to solve
 
 I am trying to build a program which will take input in .csv/.json/.xml format which contains credit card details and check if each of those cards are valid Visa/MasterCard/AmericanExpress/Discover credit card numbers. The details of this analysis are logged into an output file which is in .csv/.json/.xml format.

 
  #### Describe what are the secondary problems you try to solve (if there are any).
  The designed system must be modular to accommodate any future credit card types. To do this I would need to determine a design pattern which would help me generate different types of credit card objects based on the type of credit card number provided.
 
 #### Describe what design pattern(s) you use how (use plain text and diagrams).
 
 To check the validity of different types of card I am using validators and these validators have their own handlers. The next handler is registered in the main class. Once control is given to VisaValidator class if there is no match, the control goes to MaterCard, then American Express card and then to Discover card validators. If none of them match the control goes back to main.

To generate credit cards I have used Factory design pattern where the factory gets the type of card and details. The CreditCardFactory class will generate AmexCC, MasterCC, VisaCC and DiscoverCC credit card objects depending on the card type it is provided.

 
####  Describe the consequences of using this/these pattern(s).

Consequence of using Chain of responsibility design pattern.
The chain of responsibility design patterns requires the handlers to be configured correctly. If they are not configured correctly the request may go unhandled and the results will be wrong. 
It increases complexity of validator handling

Consequences of using Factory design patterns.
Factory design pattern encapsulates the object creation logic and it increases the complexity of implementation.

## Part 2 (Design only)

The design implements ParserFactory and OutputWriter Factory to accommodate different types of input file and out file formats. Current supported formats are .json, .csv and .xml. The parser factory returns objects corresponding file type parsers and output writer objects. To accommodate future file formats we have to add corresponding parser and output writer class and add it to the factory class.

<img width="929" alt="image" src="https://user-images.githubusercontent.com/85700971/236738313-f1d5e211-5cd6-4b7a-8c38-b8053d1670fb.png">

## Part 3:
The application is implemented using  Java and tested using JUint. It accepts input file name and output file name based on which it will generate the output.

Application java code can be found [here](https://github.com/hegdebhavya/Creditcardproblem-CMPE202/tree/main/src/main/java) <br>
Application output screenshots are uploaded [here](https://github.com/hegdebhavya/Creditcardproblem-CMPE202/tree/main/screenshots/output_screenshots) <br>

JUnit test cases can be found [here](https://github.com/hegdebhavya/Creditcardproblem-CMPE202/tree/main/src/test/java) <br>
JUnit screenshots are uploaded [here](https://github.com/hegdebhavya/Creditcardproblem-CMPE202/tree/main/screenshots/tests_screenshots) <br>



