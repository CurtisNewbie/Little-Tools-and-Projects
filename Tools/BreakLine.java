import java.util.*;
import java.io.*;
import java.nio.charset.*;

/**
 * Little tools that remove the previous linebreaks, and reformat the files based on the give configuration.
 * 
 * It takes three params
 * [0] --- from path
 * [1] --- to path
 * [2] --- number of characters per line
 */
public class BreakLine {

    public static void main(String[] args) {
        
        if(args.length != 3)
            System.exit(0);

        // config: num of char per line
        int numOfChar = Integer.parseInt(args[2]);

        // content
        String content;
        
        // paths
        String from = args[0];
        String to = args[1];

        try{
            content = readFile(from);
            String brkContent = breakLines(content, numOfChar);
            writeFile(to, brkContent);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static String readFile(String path) throws IOException, FileNotFoundException{
        try(BufferedReader br = new BufferedReader(new FileReader(path))){

        StringBuffer content = new StringBuffer();

        String line;
        while((line = br.readLine())!= null)
            content.append(line);
        
        br.close();
        return content.toString();
        }    
    }

    public static String breakLines(String content, int numOfChar){
        // replace multiple spaces or line breaks with one space
        StringBuilder newCont = new StringBuilder(content.replaceAll("( {2,})|(\n)", " "));

        int len = newCont.length();
        
        int num = 0;
        // break lines if necessary.
        for(int x = 0; x<len; x++){
            
            if(num >= numOfChar && newCont.charAt(x) == ' '){
                newCont.setCharAt(x, '\n');
                num = 0;
            }else{
                num ++;
            }
        }
        return newCont.toString();
    }

    public static void writeFile(String path, String content) throws IOException{
        Charset charset = Charset.forName("UTF-8");
    
       try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
           bw.write(content, 0, content.length());
       }
    }
}