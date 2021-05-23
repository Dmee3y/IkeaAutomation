package search;

import base.BaseTest;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import pages.SearchResultsPage;

public class SearchResultsTests extends BaseTest {

//    @Test
//    public void testSearchResultsQuantityPerPage() {
//
//        SearchResultsPage searchResultsPage = homePage.searchProduct("диван");
//
//        assertEquals(searchResultsPage.getActualItemsQuantity(), searchResultsPage.getProvidedItemsQuantity(),"Search results per page discrepancy");
//
//    }

    @Test
    public void testSearchSurvey() {
        SearchResultsPage searchResultsPage = homePage.searchProduct("диван");

        assertTrue(searchResultsPage.surveyTextCheck().contains("диван"));
    }
}
