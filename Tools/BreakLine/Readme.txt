Yongjie Zhuang (Curtis)

-----------------------------------------------------------------

Description of this program:

It reads file from the given input path, removes all the linebreaks("\n"), 
creates new linebreaks based on the given configuration (number of characters 
per line), and then output the new content to the give output path.

-----------------------------------------------------------------

How to use it:

It takes three or two arguments based on following situations:

1) Output to a specified file: "java BreakLine [number of char per line][from_path] [to_path]"

2) Overwrite the file: "java BreakLine [number of char per line][from_path]"
