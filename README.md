# Little-Tools-and-Projects

<h1>Small Projects:</h1>

<h3><a href="https://github.com/CurtisNewbie/Little-Tools-and-Projects/tree/master/Email%20Administration%20App">Email Administration App</a></h3>

Simple Email Administration App that allows the user to create new account, generate company email, setup alternative email, generate random password and change password. It doesn't really work as an administration system, it's just a way to practice some of techiniques such as data validation (using regex) and so on.

<h3><a href="https://github.com/CurtisNewbie/Little-Tools-and-Projects/tree/master/FileTransfer">FileTransfer App</a></h3>

This is a project for transferring files with Java. It only allows two terminal to communicate and share files at the same time (sender and receiver). It's working perfectly fine on my laptop (using localhost), however, as I am living in a student accommodation, it is rather difficult for me to connect between two devices as usual.

<h1>Simple Tools:</h1>

A list of simple tools and simple apps.

<h3>Tool - QRGenerator</h3>

A simple program that encodes the given text into a QR Code image and output that image to a speicified file path. This is a maven project. More details are provided in the Readme.txt in the project folder.

<h3>Tool - BreakLine</h3>

It reads file from the given input path, removes all the linebreaks("\n"), creates new linebreaks based on the given configuration(number of characters per line), and then output the new content to the give output path.
<br>
It takes three or two params:<br>

- 1)Output to a specified file: "Java BreakLine [number of char per line][from_path] [to_path]"
- 2)Overwrite the file: "Java BreakLine [number of char per line][from_path]"

<h3>Tool - SortStr</h3>

It compares a list of strings alphabetically (ascending or descending). It can get input from and write output to console or a local file.
<br>

<h3>Tool - PlusCal</h3>

It calculates the sum of the given double/integers and it takes no parameters in initialisation.

<h3>Tool - Read</h3>

It reads the textual file from the give path, and shows the content in the terminal.
It takes one param:

java Read [file_path]

<h3>Tool - Shutdown</h3>

This is a timer that allows you to shutdown the Windows OS after a defined period of time. <br>
It takes two parameters: ( h - hours, m - minute, s - seconds) <br>

Java Shutdown [h/m/s][values]

(For example, shutdown in 2 hours: Java Shutdown h 2)
