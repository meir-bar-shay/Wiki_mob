package com.meir.wiki.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchArticleTest extends  TestBase {
    @Test
    public void testSearchArticle(){
        app.skipWelcomePage();
        app.getArticle().initSearchArticle();
        app.getArticle().typeRequest("Appium");


        Assert.assertTrue(app.getArticle().isThereResult(20));

        app.getArticle().swipeArticlesUp();

        // app.getArticle().getList();


    }
}
