import java.io.*;

/**
 * Create a Readme.txt file with the specified content in the specified
 * directory.
 */
public class CreateReadme {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("There should only be one argument, which is the path to the folder");
            System.exit(0);
        } else {
            File dir = new File(args[0]);
            if (!dir.isDirectory()) {
                System.out.println("The given path is not pointing to a directory/folder");
                System.exit(0);
            } else {
                try {
                    createReadme(dir);
                    System.out.println("Done");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(0);
                }
            }
        }
    }

    /**
     * Create the Readme.txt file in the specified directory
     * 
     * @param dir a directory
     */
    public static void createReadme(File dir) throws IOException {
        String path = dir.getAbsolutePath() + "\\\\Readme.txt";
        try (var br = new BufferedWriter((new FileWriter(path)))) {
            br.newLine();
            br.write("\" \"");
            br.newLine();
            br.newLine();
            br.write("-----------------------------------------------------------");
            br.newLine();
            br.write("Descriptions:");
            br.newLine();
            br.newLine();
            br.newLine();
            br.newLine();
            br.write("-----------------------------------------------------------");
            br.newLine();
            br.write("How to use it:");
            br.newLine();
            br.newLine();
            br.newLine();
            br.newLine();
            br.write("-----------------------------------------------------------");
            br.newLine();
            br.write("Authur: ");
            br.newLine();
            br.newLine();
            br.write("Yongjie Zhuang (Curtis)");
            br.newLine();
            br.newLine();
            br.write("Github: https://github.com/CurtisNewbie");
            br.newLine();
            br.write("-----------------------------------------------------------");
        }
    }
}