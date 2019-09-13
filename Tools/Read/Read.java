import java.util.*;
import java.io.*;

public class Read {

    public static void readFile(String p){
        var path = p;
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){

            var content = new StringBuffer();
            String line;
            while((line = reader.readLine()) != null)
                content.append(line);

            System.out.println(content.toString());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String args[]){
        readFile(args[0]);
    }
}
