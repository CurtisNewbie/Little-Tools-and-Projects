
Yongjie Zhuang Curtis

----------------------- Description of this program ------------

This is a project for transferring files with Java. It only allows two
terminal to communicate and share files at the same time (sender and receiver). 
It's working perfectly fine on my laptop (using localhost), however, as I am 
living in a student accommodation, it is rather difficult for me to connect 
between two devices as usual.

-----------------------------------------------------------------

How to use it:

Sender will need to use the files in the package called "sender", 
and the receiver of the file will need to use the files in the
package called "receiver". Both thesender and the receiver of the file
will need to setup the config.txt file (in src/main/java/[receiver or sender]).
To setup the configuration, simply adding your ip or port or file path
within the parentheses (the '[' and ']').

-----------------------------------------------------------------

Example is provided as follows:

=> For the sender:

IP:[123.123.232.1]
PORT:[6666]
FILE_PATH:[c:/users/curtis/sentFile.txt]

=> For the receiver:

PORT:[6666]
FILE_PATH:[c:/users/curtis/newFile.txt]

