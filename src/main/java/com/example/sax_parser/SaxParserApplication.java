package com.example.sax_parser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SaxParserApplication {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            ArticleHandle articleHandle = new ArticleHandle();

            saxParser.parse("https://vnexpress.net/rss/giai-tri.rss", articleHandle);

            for (Article article :
                    articleHandle.getArticleList()) {
                System.out.println(article.toString());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
