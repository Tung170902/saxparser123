package com.example.sax_parser;

import jdk.internal.org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

public class ArticleHandle {
    private String content;
    private Article article;
    private List<Article> articleList = new ArrayList<>();
    private Boolean articleExist = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("item")) {
            article = new Article();
            articleExist = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("item".equals(qName)) {
            articleList.add(article);
        }

        if (articleExist) {
            switch (qName) {
                case "title":
                    article.setTitle(content);
                    break;
                case "pubDate":
                    article.setPubDate(content);
                    break;
                case "link":
                    article.setLink(content);
                    break;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        content = String.copyValueOf(ch, start, length).trim();
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }
}