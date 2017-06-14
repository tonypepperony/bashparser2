package ru.tonyappl.bashparser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ruslan on 29.05.2017.
 */

public class Parser {
    public static void main(String[] args) throws IOException {
        List<Quote> quoteList = new ArrayList<>();
        String error;

        try{
            Document doc = Jsoup.connect("http://bash.im").get();
            Elements elements = doc.body().getElementsByAttributeValue("class", "text");

            for (Element element : elements) {
            String text = element.html().replaceAll("<br>","");
            //quoteList.add(new Quote(element.text().replaceAll("<br>","\n")));
            quoteList.add(new Quote(text));
        }

        System.out.println(quoteList.get(0));

        }catch (Throwable t){
            error = t.toString();
            System.out.println(error);
        }
    }
}

class Quote {
    private String text;

    public Quote(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
