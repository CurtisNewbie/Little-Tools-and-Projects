import java.io.*;
import java.util.*;

/**
 * This progra sorts the given strings alphabetically, and it can output the
 * sorted strings to the console or a local file.
 */
public class SortStr {

	public static void main(String[] args) {

		// takes string
		List<String> list = new LinkedList<>();

		// get input
		System.out.println("\n-----------------------------------\n"
				+ "This progra sorts the given strings alphabetically\nPlease enter the strings that you want to sort. Enter \"/q\" when you finish (with a space before \"/q\")"
				+ "\n-----------------------------------\n");

		Scanner sc = new Scanner(System.in);
		String next;
		while (sc.hasNext() && !(next = sc.next()).equals("/q")) {
			list.add(next);
		}

		// ascending or descending orders
		if (!list.isEmpty()) {
			System.out.println("\nAscending order or Descending order [A/D].");
			String resp = sc.next();

			if (resp.equalsIgnoreCase("D")) {
				Collections.sort(list, Collections.reverseOrder());
			} else {
				Collections.sort(list);
			}

			// output the sorted list of strings in console
			System.out.println("\nList of strings has been sorted:");
			StringBuilder result = new StringBuilder();
			for (String s : list) {
				result.append(s + " ");
			}
			System.out.println(result.toString());

			// write the sorted list of strings in a file
			System.out.println("\nDo you want to output the sorted strings to a file?[y/n]");
			resp = sc.next();
			if (resp.equalsIgnoreCase("y")) {
				System.out.println("\nPlease enter the path of the output file:");
				sc.nextLine();
				String path = sc.nextLine();

				try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path)));) {
					bw.write(result.toString());
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
