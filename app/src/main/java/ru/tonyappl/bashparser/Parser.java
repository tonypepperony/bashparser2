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
        Document doc = Jsoup.connect("http://bash.im").get();

        Elements elements = doc.body().getElementsByAttributeValue("class", "text");

        for (Element element : elements) {
            quoteList.add(new Quote(element.text()));
        }

        System.out.println(quoteList.get(0));

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
