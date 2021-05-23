package favorites;

import base.BaseTest;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import pages.ProductPage;
import pages.SearchResultsPage;
import utils.WindowManager;

public class FavoriteProductTest extends BaseTest {


    @Test
    public void testAddToFavList () {
        SearchResultsPage searchResultsPage = homePage.searchProduct("диван");
        ProductPage productPage = searchResultsPage.goToFirstResultPage();

        productPage.addToFavoriteList();

        assertEquals(productPage.isAddedToFavList(), true, "The product was not added to favorite list");
    }
}
