package org.example;

import Pages.*;
import SetUp.OpenClose;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Users.TestListener;

@Listeners({TestListener.class})
public class Test1 extends OpenClose {
    @Test
    public void test1() {
        GenrePage genrePage = new GenrePage(driver, webDriverWait);
        genrePage.clickShowMore();
        genrePage.clickEmbroidPaintings();
        genrePage.clickUrbanLandscape();
        genrePage.clickApply();
        genrePage.checkNamePainting();
    }
    @Test
    public void test2() {
        GenrePage genrePage = new GenrePage(driver, webDriverWait);
        StylePage stylePage = new StylePage(driver, webDriverWait);
        genrePage.clickShowMore();
        genrePage.clickEmbroidPaintings();
        genrePage.clickUrbanLandscape();
        genrePage.clickApply();
        genrePage.clickPainting();
        stylePage.checkStyle();
    }

    @Test
    public void test3() {
        GenrePage genrePage = new GenrePage(driver, webDriverWait);
        StylePage stylePage = new StylePage(driver, webDriverWait);
        FavouritesPage favouritesPage = new FavouritesPage(driver, webDriverWait);
        genrePage.clickShowMore();
        genrePage.clickBatic();
        genrePage.clickLike();
        genrePage.clickFavourite();
        String Name  = genrePage.getNameOfFirstPicture();
        favouritesPage.checkNameOfFirstPicture(Name);
    }

    @Test
    public void test4() {
        GenrePage genrePage = new GenrePage(driver, webDriverWait);
        StylePage stylePage = new StylePage(driver, webDriverWait);
        HomePage homePage = new HomePage(driver, webDriverWait);
        FavouritesPage favouritesPage = new FavouritesPage(driver, webDriverWait);
        homePage.inputSearchField();
        homePage.checkFirstPainting();
    }

    @Test
    public void test5() {
        GenrePage genrePage = new GenrePage(driver, webDriverWait);
        StylePage stylePage = new StylePage(driver, webDriverWait);
        HomePage homePage = new HomePage(driver, webDriverWait);
        CartPage cartPage = new CartPage(driver, webDriverWait);
        FavouritesPage favouritesPage = new FavouritesPage(driver, webDriverWait);
        genrePage.clickShowMore();
        genrePage.clickJewelryArt();
        genrePage.clickCartBtn();
        genrePage.clickGoToCart();
        String Price = genrePage.getCostOfFirstPicture();
        cartPage.checkCostOfFirstPicture(Price);


    }

}
