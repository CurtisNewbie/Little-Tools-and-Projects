import java.io.File;

public class CheckDirectorySize {

    public static void main(String[] args) {

        System.out.println(
                "\n-------------------------------\n\nCheckDirectorySize\n\n-------------------------------\n");

        if (args.length != 2) {
            System.out.println("You should provide two arguments.");
            System.exit(0);
        } else {
            var start = System.currentTimeMillis();
            var dirPath = args[0];
            var dirSize = size(new File(dirPath));
            switch (args[1]) {

            case "-kb":
                System.out.printf("Folder Size: %.3f kb", dirSize / 1024);
                break;

            case "-mb":
                System.out.printf("Folder Size: %.3f mb", dirSize / Math.pow(1024, 2));
                break;

            case "-gb":
                System.out.printf("Folder Size: %.3f gb", dirSize / Math.pow(1024, 3));
                break;

            case "-tb":
                System.out.printf("Folder Size: %.3f tb", dirSize / Math.pow(1024, 4));
                break;

            }
            var end = System.currentTimeMillis();
            System.out.println("\nUsed time: " + (end - start) / 1000 + "s");
        }
    }

    /**
     * Calculate the size of the directory through recursion
     * 
     * @param f file
     * @return size in bytes
     */
    public static double size(File f) {
        double size = 0.0;

        if (f.isDirectory()) {
            File[] subdir = f.listFiles();

            if (subdir == null) {
                System.out.println("May Not Have Permission To:\"" + f.getAbsolutePath() + "\"");
            } else {
                for (File fi : subdir)
                    size += size(fi);
            }
        } else {
            size += f.length();
        }
        return size;
    }
}
