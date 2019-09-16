
"GrapTextFromHtml"

-----------------------------------------------------------
Descriptions:

This is a program that I coded for grabing the a novel from websites. My gf loves reading novels, some are available online for free, however they cannot be downloaded as normal zip or txt files for offline reading. So this program is used for this purpose.

This program uses JSoup library to parse the html file. First it extracts all the links from the given website, and then goes to all these links to extract the textual data. This is because I was extracting a noval which consists of many chapters (in different pages). You may not find this program useful without modification, as it is customised for the speicif website.

-----------------------------------------------------------
Limitation:

First of all, as different websites have different structure. Some uses tags like paragraph or article to present the textual data (e.g., novel), and some uses javascript to create the content. So, this program is designed solely for the website that I was trying to extract data from.

-----------------------------------------------------------
How to use it:

This is a Maven project, so Maven should be installed. Type in following command in CMD to run the program:

"mvn clean compile exec:java"

-----------------------------------------------------------
Authur: 

Yongjie Zhuang (Curtis)

Github: https://github.com/CurtisNewbie
-----------------------------------------------------------