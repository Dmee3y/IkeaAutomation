package utils;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowManager {

    private static WebDriver driver;
    private static WebDriver.Navigation navigate;

    public WindowManager(WebDriver driver) {
        this.driver = driver;
        navigate = driver.navigate();
    }

    public static void goBack() {

        navigate.back();
    }

    public static void goForward() {
        navigate.forward();
    }

    public static void refresh() {
        navigate.refresh();
    }

    public static void goTo(String url) {
        navigate.to(url);
    }

    public static void switchToTab(String tabTitle) {
        Set<String> windows = driver.getWindowHandles();

        System.out.println("Number of tabs: " + windows.size());
        System.out.println("Tabs titles:");
        windows.forEach(System.out::println);

        for (String window : windows) {
            System.out.println("Switch to tab " + window);
            driver.switchTo().window(window);

            System.out.println("Tab title is " + driver.getTitle());

            if (tabTitle.equals(driver.getTitle())) {
                break;
            }
        }
    }
}