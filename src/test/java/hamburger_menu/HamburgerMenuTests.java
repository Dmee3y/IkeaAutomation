package hamburger_menu;

import base.BaseTest;
import menu.HamburgerMenu;
import static org.testng.Assert.*;
import org.testng.annotations.Test;


public class HamburgerMenuTests extends BaseTest {

    @Test
    public void testHamburgerMainLinksQty() {
        HamburgerMenu hamburgerMenu = homePage.clickHamburgerMenuLink();

        assertEquals(hamburgerMenu.getHamburgerMainLinksQuantity(),4, "Wrong hamburger menu " +
                "main links quantity");
    }

    @Test
    public void testHamburgerAuxLinksQty() {
        HamburgerMenu hamburgerMenu = homePage.clickHamburgerMenuLink();

        assertEquals(hamburgerMenu.getHamburgerAuxLinksQuantity(),12, "Wrong hamburger menu " +
                "aux links quantity");
    }
}
