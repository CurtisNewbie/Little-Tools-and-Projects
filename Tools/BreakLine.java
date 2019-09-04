import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Little tools that remove the previous linebreaks, and reformat the files
 * based on the give configuration.
 * 
 * It takes three or two params:<br>
 * 1)Output to a specified file: [number of char per line] [from_path] [to_path]
 * 2)Overwrite the file: [number of char per line] [from_path]
 */
public class BreakLine {

    public static void main(String[] args) {

        int params = args.length;
        if (params < 2 || params > 3) {
            System.out.println(
                    "Parameters: \"[num of char per line] [from] [to]\"  or \"[num of char per line] [from]\"");
            System.exit(0);
        }

        // config: num of char per line
        int numOfChar = Integer.parseInt(args[0]);

        // content
        String content;

        // paths
        String from, to;

        if (params == 3) {
            from = args[1];
            to = args[2];
        } else { // overwrite
            from = args[1];
            to = args[1];
        }

        try {
            content = readFile(from);
            String brkContent = breakLines(content, numOfChar);
            writeFile(to, brkContent);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String readFile(String path) throws IOException, FileNotFoundException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            StringBuffer content = new StringBuffer();

            String line;
            while ((line = br.readLine()) != null)
                content.append(line);

            br.close();
            return content.toString();
        }
    }

    public static String breakLines(String content, int numOfChar) {
        // replace multiple spaces or line breaks with one space
        StringBuilder newCont = new StringBuilder(content.replaceAll("( {2,})|(\n)", " "));

        int len = newCont.length();

        int num = 0;
        // break lines if necessary.
        for (int x = 0; x < len; x++) {

            if (num >= numOfChar && newCont.charAt(x) == ' ') {
                newCont.setCharAt(x, '\n');
                num = 0;
            } else {
                num++;
            }
        }
        return newCont.toString();
    }

    public static void writeFile(String path, String content) throws IOException {
        Charset charset = Charset.forName("UTF-8");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write(content, 0, content.length());
        }
    }
}