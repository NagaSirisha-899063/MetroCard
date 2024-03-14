# ** This is for reference purpose **

# Pre-requisites
* Java 1.8 or above
* Maven

# How to run the code
We have provided scripts to execute the code. 

Use `run.sh` if you are using Linux/Unix/macOS Operating system and `run.bat` if you are on Windows.Both the files run commands and print the corresponding output based on the input file `sample_input/input1.txt`.

Internally both the scripts run the following commands 
 * `mvn clean install` - This will create a jar file `geektrust.jar` in the `target` folder.
 * `java -jar target/geektrust.jar sample_input/input1.txt` - This will execute the jar file passing in the sample input file as the command line argument


# Running the code for multiple test cases

 Please fill `input1.txt` and `input2.txt` with the input commands and use those files in `run.bat` or `run.sh`. Replace `java -jar target/geektrust.jar sample_input/input1.txt` with `java -jar target/geektrust.jar sample_input/input2.txt` to run the test cases from the second input file. 


# How to execute the unit tests
 `mvn clean test` will execute the unit test cases.
