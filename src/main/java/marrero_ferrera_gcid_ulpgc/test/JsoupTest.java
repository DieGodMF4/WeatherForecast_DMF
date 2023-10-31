package marrero_ferrera_gcid_ulpgc.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsoupTest {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://en.wikipedia.org/").get();
        /*Elements newsHeadLines = doc.select("#mp-itn b a");
        for (Element headLine : newsHeadLines) {
            String title = headLine.attr("title");
            // String text = headLine.text();
            String href = headLine.absUrl("href");
            System.out.println(String.format("%s\n\t%s", title, href));
        }

         */
        Document document = Jsoup.connect("https://en.wikipedia.org/wiki/2023_Ecuadorian_general_election").get();
        Elements elements = document.select("div.mw-body-content mw-content-ltr");
        elements.select("table.infobox vevent");
        //elements.select("tbody").first();
        System.out.println(elements.select("tbody").size());
        System.out.println("\n\n" + elements);
        /*
        if (newsHeadLines.get(0) != null) {
            for (Element headLine : newsHeadLines) {
                String title = headLine.attr("title");
                String text = headLine.text();
                String href = headLine.absUrl("href");
                System.out.println(String.format("%s\n\t%s\n\t%s", title, text, href));
            }


        if (newsHeadLines != null) {
            String price = newsHeadLines.text();
            System.out.println("Price: " + price);


        } else {
            System.out.println("Price not found on the page.");
        }
*/
    }
}
