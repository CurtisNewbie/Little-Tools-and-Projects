import java.io.File;
import java.util.*;

public class FfmpegConvert {

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

        List<String> inFiles = new ArrayList<>();
        for (File f : inDir.listFiles())
            inFiles.add(f.getAbsolutePath());
        convert(inFiles, args[1], args[2]);
    }

    static void convert(List<String> inFiles, String outDir, String format) throws Exception {
        Runtime runtime = Runtime.getRuntime();
        List<String> log = new ArrayList<String>();
        for (String f : inFiles) {
            String cmd = "ffmpeg -nostats -loglevel 0 -y -i " + f + " -vcodec copy -acodec copy " + outDir + "/"
                    + fileName(f) + "." + format;
            Process p = runtime.exec(new String[] { "bash", "-c", cmd });
            if (p.waitFor() == 0) {
                System.out.println("Convertion Sucess - " + f);
            } else {
                log.add("Failed to convert" + f);
            }
        }
        displayLog(log);
        System.out.println("Finished at " + new Date() + "\nOutput Directory: " + outDir);
    }

    static String fileName(String path) {
        int start = -1;
        int end = -1;
        for (int i = path.length() - 1; i > 0; i--) {
            if (path.charAt(i) == '.' && end < 0) {
                end = i;
            } else if (path.charAt(i) == '/') {
                start = i + 1;
                break;
            }
        }
        if (start < 0 || end < 0)
            throw new IllegalArgumentException("File name cannot be parsed");

        return path.substring(start, end);
    }

    static void displayLog(List<String> log) {
        for (String s : log) {
            System.out.println(s);
        }
    }
}