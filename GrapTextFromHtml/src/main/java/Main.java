import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final Scanner sc = new Scanner(System.in);
        System.out.println("Enter URL");
        String urlPath = sc.nextLine();
        System.out.println("Enter Output Directory");
        String outputDir = sc.nextLine();
        sc.close();

        // this is hardcoded for extract tags that meet this requirement
        String specificSyntax = "/html/32/32657";

        try {
            // using Jsoup
            Document doc = Jsoup.connect(urlPath).timeout(30000).userAgent("Opera").get();
            // tags
            Elements links = doc.select("a[href]");

            System.out.println("\n" + links.size() + " Found:::");

            ArrayList<UrlTag> urlTags = new ArrayList<>();
            for (Element link : links) {

                String ref = link.attr("abs:href");
                String name = "(" + link.text().trim() + ")";

                if (name.contains("http")) {
                    name = name.substring(0, name.indexOf("http"));
                }

                if (ref.contains(specificSyntax)) {
                    System.out.println(ref + " ::: " + name);
                    urlTags.add(new UrlTag(ref, name));
                }
            }

            // load text (article tag) of individual link
            for (UrlTag t : urlTags) {
                try {
                    Elements arti =
                            Jsoup.connect(t.getUrl()).timeout(5000).userAgent("Opera").get().
                                    select("article");
                    t.setText(arti.text());
                    System.out.println("Loaded the Element: " + t.getName());
                } catch (IOException e) {
                    e.printStackTrace();
                    t.setText(null);
                }
            }

            // load again
            for (UrlTag t : urlTags) {
                if (t.getText() == null) {
                    try {
                        Elements arti =
                                Jsoup.connect(t.getUrl()).timeout(5000).userAgent("Opera").get().
                                        select("article");
                        t.setText(arti.text());
                        System.out.println("Loaded the Element: " + t.getName());
                    } catch (IOException e) {
                        e.printStackTrace();
                        t.setText(null);
                    }
                }
            }

            // output these text to local dir
            BufferedWriter writer = null;
            for (UrlTag t : urlTags) {
                if (t.getText() != null) {
                    try {
                        writer =
                                new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputDir +
                                        "/" + t.getName() + ".txt"), StandardCharsets.UTF_8));
                        writer.write(t.getText());
                        writer.close();
                    } catch (IOException e) {
                        System.out.println("Failed to write:" + t.getUrl());
                        e.printStackTrace();
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("TimedOut: Fail to connect to the url at the first place");
            System.exit(0);
        }
    }
}
