# FFMPEG Convert

**Simple tool that converts all files in a directory to specified format using FFMPEG CLI. The converted files are of their orginal names.**

Essentially, it is doing following command for every file in the directory, except that it changes the filename for you:

    ffmpeg -i applejuice.mov -c copy applejuice.mp4

**This tool works on both Linux and Windows OS**

## How to use it

- Install FFMPEG library
- Compile this tool using javac

e.g.,

    javac FfmpegConvert.java

- Run it, and provides three arguments:
  - [0] input directory, which contains all the files that you want to convert
  - [1] output directory, where the files are created
  - [2] format, e.g., "mp4"

e.g.,

    java FfmpegConvert /home/yongjie/in /home/yongjie/tempOut mp4

Then all the files in _/home/yongjie/in_ are converted to mp4 format and generated in _/home/yongjie/tempOut_.
