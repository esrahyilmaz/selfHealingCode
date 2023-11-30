package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class EventListener implements WebDriverEventListener {
    WebElementHelper helper = new WebElementHelper();
    FindClosestMatchingElement findClosestMatchingElement = new FindClosestMatchingElement();
    By by;
    EventFiringWebDriver eventFiringWebDriver = DriverHelper.getEventDriver();
    public static String altXpath = "";

    @Override
    public void beforeAlertAccept(WebDriver driver) {

    }

    @Override
    public void afterAlertAccept(WebDriver driver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {

    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        // Code to execute before navigating to a URL goes here
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        // Code to execute after navigating to a URL goes here
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {

    }

    @Override
    public void afterNavigateBack(WebDriver driver) {

    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {

    }

    @Override
    public void afterNavigateForward(WebDriver driver) {

    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {

    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        this.by = by;
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        this.by = by;
        System.out.println("Reviewing the following 'findBy' element: " + by);
        helper.addByPropertiesToMap(driver, by);
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {

    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {

    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    @Override
    public void beforeScript(String script, WebDriver driver) {

    }

    @Override
    public void afterScript(String script, WebDriver driver) {

    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {

    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {

    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
//        findAndReturnElement(eventFiringWebDriver, by);
//        altXpath = FindClosestMatchingElement.findClosestElement(eventFiringWebDriver, findAndReturnElement(eventFiringWebDriver, by));
//        String inputString = throwable.getLocalizedMessage();
//        String findByContext = "";
//        String findByType = null;
//        String element = null;
//        System.out.println("Error Message: " + inputString);
//        String pattern = "findElement \\{using=(.*?), value=[a-z]+\\}";
//        Pattern p = Pattern.compile(pattern);
//        Matcher m = p.matcher(inputString);
//        if (m.find()) {
//            String input = m.group();
//            customLogError(input);
//            String[] parts = input.split(",");
//
//            findByType = parts[0].split("=")[1];
//            element = parts[1].split("=")[1].replace("}", "");
//
//            //Hate to do it this way but good for now, in a hurry
//            if (findByType.contains("tag name")) {
//                findByType = "tagName";
//            }
//            System.out.println("id: " + findByType);
//            System.out.println("heading: " + element);
//            findByContext = "By." + findByType + ": " + element;
//        }
//        if (findByContext.isEmpty()) {
//            // Extract the XPath expression
//            pattern = "(//li\\[contains\\(text\\(\\),')(.*?)('\\)\\])";
//            p = Pattern.compile(pattern);
//            m = p.matcher(inputString);
//
//            String xpath = "";
//            String text = "";
//
//            if (m.find()) {
//                String input = m.group();
//                System.out.println("Input:" + input);
//                findByType = m.group(1) + m.group(2) + m.group(3);
//                element = m.group(2);
//                findByContext = "By.xpath: " + input;
//
//            }
//        }
//        if (!findByContext.isEmpty()) {
//            helper.retrieveMapValuesByKey(findByContext);
//            System.out.println("Element Not Found:");
//            System.out.println(findByContext + ": {");
//            System.out.println("    \"" + "className\": \"" + helper.getClassName() + "\",");
//            System.out.println("    \"" + "textContent\": \"" + helper.getTextContent() + "\",");
//            System.out.println("    \"" + "location\": \"" + helper.getLocation() + "\",");
//            System.out.println("    \"" + "id\": \"" + helper.getId() + "\",");
//            System.out.println("    \"" + "tagName\": \"" + helper.getTagName() + "\"");
//            System.out.println("    \"" + "alt\": \"" + helper.getAlt() + "\"");
//            System.out.println("    \"" + "src\": \"" + helper.getSrc() + "\"");
//            System.out.println("    \"" + "href\": \"" + helper.getHref() + "\"");
//            System.out.println("    \"" + "name\": \"" + helper.getName() + "\"");
//            System.out.println("    \"" + "keyValue\": \"" + helper.getRandomKey() + "\"");
//            System.out.println("}\n");
//            //Need a method to read from stored map and retrieve key value prperties
//
//            // System.out.println("Location:"+helper.getLocation());
//            objectSearch.FindClosestMatch(findByContext, getClassName(), getTextContent(), getId(), getTagName(), getLocation(), getSrc(), getAlt(), getHref(), getName(), getType());
//        } else {
//            System.out.println(">>> Previous mapping not found in myPageElements.json file. <<<");
//        }
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {

    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {

    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {

    }

    // Other methods go here
    public static WebElement findAndReturnElement(EventFiringWebDriver eventFiringWebDriver, By element) {
        WebElementHelper.size = "";
        WebElementHelper.className = "";
        WebElementHelper.textContent = "";
        WebElementHelper.id = "";
        WebElementHelper.tagName = "";
        WebElementHelper.location = "";
        WebElementHelper.randomKey = "";
        WebElementHelper.src = "";
        WebElementHelper.alt = "";
        WebElementHelper.href = "";
        WebElementHelper.name = "";
        WebElementHelper.type = "";
        WebElement ele = null;

        String locator = element.toString();

        ReportHelper.customLogInfo("Trying to find previously stored element in " + WebElementHelper.pages.get());
        WebElementHelper.retrieveMapValuesByKey(locator);
        System.out.println("Element Not Found:");
        System.out.println(locator + ": {");
        System.out.println("    \"" + "className\": \"" + WebElementHelper.getClassName() + "\",");
        System.out.println("    \"" + "textContent\": \"" + WebElementHelper.getTextContent() + "\",");
        System.out.println("    \"" + "location\": \"" + WebElementHelper.getLocation() + "\",");
        System.out.println("    \"" + "id\": \"" + WebElementHelper.getId() + "\",");
        System.out.println("    \"" + "tagName\": \"" + WebElementHelper.getTagName() + "\"");
        System.out.println("    \"" + "alt\": \"" + WebElementHelper.getAlt() + "\"");
        System.out.println("    \"" + "src\": \"" + WebElementHelper.getSrc() + "\"");
        System.out.println("    \"" + "href\": \"" + WebElementHelper.getHref() + "\"");
        System.out.println("    \"" + "name\": \"" + WebElementHelper.getName() + "\"");
        System.out.println("    \"" + "keyValue\": \"" + WebElementHelper.getRandomKey() + "\"");
        System.out.println("}\n");
        //Need a method to read from stored map and retrieve key value properties
        ReportHelper.customLogSuccess("Stored element key for " + locator + " -> " + WebElementHelper.getRandomKey());
        // System.out.println("Location:"+helper.getLocation());
        ReportHelper.customLogInfo("Trying to find the closest possible match");

        // This routine will setup attribute value if no json file
        getAttributeFromLocator(locator);

        ele = FindClosestMatchingElement.getClosestElement(eventFiringWebDriver, locator, WebElementHelper.className,
                WebElementHelper.textContent, WebElementHelper.id, WebElementHelper.tagName,
                WebElementHelper.location, WebElementHelper.src, WebElementHelper.alt, WebElementHelper.href,
                WebElementHelper.name, WebElementHelper.type);

        return ele;
    }

    private static void getAttributeFromLocator(String locator) {
        if ((WebElementHelper.className == null || WebElementHelper.className.isEmpty()) && locator.contains("By.className")) {
            WebElementHelper.className = locator.substring(locator.indexOf(":") + 2);
        }
        if ((WebElementHelper.name == null || WebElementHelper.name.isEmpty()) && locator.contains("By.name")) {
            WebElementHelper.name = locator.substring(locator.indexOf(":") + 2);
        }
        if ((WebElementHelper.id == null || WebElementHelper.id.isEmpty()) && locator.contains("By.id")) {
            WebElementHelper.id = locator.substring(locator.indexOf(":") + 2);
        }
        if ((WebElementHelper.tagName == null || WebElementHelper.tagName.isEmpty()) && locator.contains("By.tagName")) {
            WebElementHelper.tagName = locator.substring(locator.indexOf(":") + 2);
        }
        if ((WebElementHelper.href == null || WebElementHelper.href.isEmpty()) && locator.contains("By.linkText")) {
            WebElementHelper.href = locator.substring(locator.indexOf(":") + 2);
        }
        if (locator.contains("xpath")) {
            if (locator.contains("@name"))
                WebElementHelper.name = locator.substring(locator.indexOf("'") + 1, locator.indexOf("']"));
            else if (locator.contains("@id"))
                WebElementHelper.id = locator.substring(locator.indexOf("'") + 1, locator.indexOf("']"));
            else if (locator.contains("@href"))
                WebElementHelper.href = locator.substring(locator.indexOf("'") + 1, locator.indexOf("']"));
            else if (locator.contains("(.,") || locator.contains("text()"))
                WebElementHelper.textContent = locator.substring(locator.indexOf("'") + 1, locator.indexOf("']"));
            else if (locator.contains("@type"))
                WebElementHelper.type = locator.substring(locator.indexOf("'") + 1, locator.indexOf("']"));

            WebElementHelper.tagName = locator.substring(locator.indexOf("//") + 2, locator.indexOf("["));
        }
    }
}