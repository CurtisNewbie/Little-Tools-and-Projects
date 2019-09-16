import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Files are created in the folder called "pdfOutput" in the given directory.
 */
public class Main {

    final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        /**
         * path to pdf
         */
        String pathToPdf;

        /**
         * directory path of output files
         */
        String outDirPath;

        /**
         * output file name
         */
        String outFileName;

        System.out.println("Enter file path of the pdf file:");
        pathToPdf = sc.nextLine();

        File pdfFile = new File(pathToPdf);
        if (pdfFile.exists()) {

            System.out.println("Enter directory/folder of the output files:");
            outDirPath = sc.nextLine() + "/pdfOutput/";
            outFileName = outDirPath + pdfFile.getName();

            // create repository
            File outputDir = new File(outDirPath);
            if (outputDir.exists() || outputDir.mkdirs()) {

                // read pdf doc
                PDDocument document = null;
                try {
                    document = PDDocument.load(pdfFile);

                    // render to bufferedImage
                    PDFRenderer pdfRenderer = new PDFRenderer(document);
                    for (int page = 0; page < document.getNumberOfPages(); ++page) {
                        BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 300, ImageType.RGB);

                        // suffix in filename will be used as the file format, 300 dpi
                        ImageIOUtil.writeImage(bim, outFileName + "-" + (page + 1) + ".png", 300);
                    }
                    document.close();

                    System.out.println("\nFinished. Files are created in \"" + outDirPath + "\"\n");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Error: The given ouput path is not a directory or folder.");
                System.exit(0);
            }
        } else {
            System.out.println("Error: File of the given path not exists");
            System.exit(0);

        }
    }
}
