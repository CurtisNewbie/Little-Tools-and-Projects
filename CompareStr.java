import java.util.*;

public class CompareStr {

	public static void main(String[] args) {

		if(args.length != 2)
			System.out.println("Only takes two parameters <String>. \n");
		else{
			String paraOne = args[0];
			String paraTwo = args[1];

			Comparator<String> compareString = (a , b) -> {return a.compareTo(b);};
 			int result = compareString.compare(paraOne, paraTwo);

			if(result == 0 )
				System.out.println(paraOne + " = " + paraTwo);
			else if(result > 0)
				System.out.println(paraOne + " > " + paraTwo);
			else
				System.out.println(paraOne + " < " + paraTwo);
		}
	}
}
