

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.*;

public class PlusCal{

    public static void main(String[] args) {
        
        System.out.println("Entere How Many Numbers You Want To Calculate:");
        
        final Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        
        Pattern pattern = Pattern.compile("[a-zA-Z_/]");
        Matcher matcher = pattern.matcher(n);

        if(matcher.find()){
            System.out.println("Illegal argument");
        }else{
            int num = Integer.parseInt(n);

            double result = 0.0;

            for(int x=0; x<num; x++){
                String line = sc.nextLine();
                result += Double.parseDouble(line);
            }
            System.out.println("= " + result);
        }
    }
}