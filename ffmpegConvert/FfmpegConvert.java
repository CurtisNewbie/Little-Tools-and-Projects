import java.io.File;
import java.util.*;

public class FfmpegConvert {

    static char slash = isWinOS() ? '\\' : '/';
    static String cli_name = isWinOS() ? "cmd.exe" : "bash";
    static String parseAsString = isWinOS() ? "/c" : "-c";

    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.out.println("Three arguments: [0]input dir [1]output dir [2]target format");
            System.exit(0);
        }

        File inDir = new File(args[0]);
        if (!inDir.isDirectory()) {
            System.out.println("Input Dir is not a directory");
        }

        File outDir = new File(args[1]);
        if (!outDir.isDirectory()) {
            System.out.println("Output Dir is not a directory");
        }

        List<File> inFiles = new ArrayList<>();
        for (File f : inDir.listFiles())
            if (f.isFile())
                inFiles.add(f);

        convert(inFiles, args[1], args[2]);
    }

    static void convert(List<File> files, String outDir, String format) throws Exception {
        System.out.println("Started at " + new Date().toString());
        Runtime runtime = Runtime.getRuntime();
        List<String> log = new ArrayList<String>();
        for (File f : files) {
            String outputFilename = outDir + slash + fileName(f.getName()) + "." + format;
            String cmd = String.format("ffmpeg -y -i '%s' -c copy '%s'", f.getAbsolutePath(), outputFilename);
            Process p = runtime.exec(new String[] { cli_name, parseAsString, cmd });

            if (p.waitFor() == 0) {
                System.out.println("[Success]: " + outputFilename);
            } else {
                // try again without codec copy
                System.out.println("[Failed]: " + outputFilename);
                System.out.println("[Try again without codec copy]: " + outputFilename);
                cmd = String.format("ffmpeg -y -i '%s' '%s'", f, outputFilename);
                if (runtime.exec(new String[] { cli_name, parseAsString, cmd }).waitFor() == 0)
                    System.out.println("[Success]: " + outputFilename);
                else
                    log.add("Failed to convert" + f);
            }
        }
        displayLog(log);
        System.out.println("Finished at " + new Date() + "\nOutput Directory: " + outDir);
    }

    static String fileName(String path) {
        int start = 0;
        int end = path.length();
        for (int i = path.length() - 1; i >= 0; i--) {
            if (path.charAt(i) == '.' && end == path.length()) {
                end = i;
            } else if (path.charAt(i) == slash) {
                start = i + 1;
                break;
            }
        }
        return path.substring(start, end);
    }

    static void displayLog(List<String> log) {
        for (String s : log) {
            System.out.println(s);
        }
    }

    private static boolean isWinOS() {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }
}