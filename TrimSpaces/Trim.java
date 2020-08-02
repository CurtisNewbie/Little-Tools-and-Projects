import java.util.*;
import java.io.*;

/**
 * Simple program that removes all the spaces in a sentense or file
 * <p>
 * Author Yongjie Zhuang
 */
public class Trim{
    private static final String FILE_FLAG = "-f";
    private static final String CLI_INPUT_FLAG = "-i";

    public static void main(String[] args){
        if(args.length == 0){
            System.out.println("\tSimple program to remove all the spaces\n");
            System.out.println("\tPlease provides following arguments:\n");
            System.out.printf("\t\t%s\tFor File Path\n", FILE_FLAG);
            System.out.printf("\t\t%s\tFor Terminal Input\n", CLI_INPUT_FLAG);
            System.out.printf("\n\tE.g.,\n\n\t\tjava Trim -i \"I don't like spaces !\"\n\n\t\tjava Trim -f \"abcd.txt\"\n");
        }
        Map<String, String> argMap = parseArgs(args);
        if(argMap.containsKey(CLI_INPUT_FLAG)){
            // process CLI argument directly
            System.out.println(argMap.get(CLI_INPUT_FLAG).replaceAll("\\s", ""));
        }else if(argMap.containsKey(FILE_FLAG)){
            // file operation
            try{
                Scanner sc = new Scanner(new FileInputStream(new File(argMap.get(FILE_FLAG))));
                StringBuilder sb = new StringBuilder();
                while(sc.hasNextLine()){
                    sb.append(sc.nextLine().replaceAll("\\s", ""));
                }
                //overwrites file content
                FileWriter fw = new FileWriter(argMap.get(FILE_FLAG), false);
                fw.write(sb.toString());
                fw.close();
            }catch(IOException e){
                System.out.println("IOException occurred, make sure your file path is correct");
            }
        }
    }

    private static Map<String, String> parseArgs(String[] args){
        Map<String, String> argMap = new HashMap<>();
        int len = args.length;
        for(int i = 0; i < len; i++){
            if(args[i].equals(FILE_FLAG) && i+1 < len){
                argMap.put(FILE_FLAG, args[i+1]);
            }else if (args[i].equals(CLI_INPUT_FLAG) && i+1 < len){
                argMap.put(CLI_INPUT_FLAG, args[i+1]);
            }
        }
        return argMap;
    }
}
