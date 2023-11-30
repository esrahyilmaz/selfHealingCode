package helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.fail;

public class WebElementHelper extends DriverHelper {
    // Declare Objects

    public static final Logger log = Logger.getLogger(WebElementHelper.class.getName());
    public static WebDriver seleniumDriver;
    public static String projectFolder = System.getProperty("user.dir") + System.getProperty("file.separator");
    private static ThreadLocal<Map<String, Map<String, String>>> mapping = new ThreadLocal<Map<String, Map<String, String>>>() {
        @Override
        protected Map<String, Map<String, String>> initialValue() {
            return new HashMap<>();
        }
    };
    private static ThreadLocal<File> file = new ThreadLocal<>();
    static By by = By.xpath("/html/body/div[4]/label");
    static String size = "";
    static String className = "";
    static String location = "";
    static String textContent = "";
    static String id = "";
    static String tagName = "";
    static String randomKey = "";
    static String src = "";
    static String name = "";
    static String href = "";
    static String alt = "";
    static String type = "";
    static String style = "";
    static String value = "";
    static String width = "";
    static String height = "";
    static String title = "";
    static String onclick = "";
    static String _for = "";
    static String rows = "";
    static String cols = "";
    static String action = "";
    static String oninput = "";
    static String maxlength = "";
    static String max = "";
    static String min = "";
    static String pattern = "";
    static String placeholder = "";
    static String step = "";
    static String autocomplete = "";
    static String formaction = "";
    static String formenctype = "";
    static String method = "";
    static String formmethod = "";
    static String formtarget = "";
    static String target = "";
    static String wrap = "";
    static String usemap = "";
    static boolean recordMode;
    static final String pageFolder = "pageElements/";

    public static ThreadLocal<String> pages = new ThreadLocal<>();  // This will be updated using script.  Default Page to Load.
    public static String targetURL = "file:///" + projectFolder + "src/test/resources/WebPages/myPage.html";
    static String outputFilePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "src/test/resources";

    /**
     * Open URL in browser
     */
    public static void loadUrl(EventFiringWebDriver eventFiringWebDriver) {
        try {

            if (!getRecordMode()) {
                targetURL = "file:///" + projectFolder + "src/test/resources/WebPages/myPagePlayback.html";
            }
            eventFiringWebDriver.get(targetURL);
            waitForPageToLoad(eventFiringWebDriver);
        } catch (Exception e) {
            log.error("Failed - Error in function loadUrl(): " + e.getMessage());
        }
    }

    public static void waitForPageToLoad(EventFiringWebDriver eventFiringWebDriver) {
        JavascriptExecutor js = eventFiringWebDriver;
        try {
            js.executeScript("return (window.jQuery != null) && (window.jQuery.active === 0)");
        } catch (Exception e) {
            log.info("No jQuery");
        }

        js.executeScript("return document.readyState").toString().equals("complete");
        log.info("Page loaded");
    }

    /**
     * This method writes the pageProperties Map to a file
     * If the file is later deemed to be good it should be manually moved to 'resources' folder.
     *
     * @throws IOException
     */
    public static void writeMap() throws IOException {
        if (!recordMode) {
            log.debug("Not in Record Mode for method: {}" + Thread.currentThread().getStackTrace()[1].getMethodName());
            return;
        }
        File pageDir = new File(outputFilePath + "\\" + pageFolder);
        if (!pageDir.exists()) {
            if (!pageDir.mkdirs()) {
                ReportHelper.customLogError("Unable to create " + pageFolder + " directory");
            }
        }
        Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
        Map<String, Map<String, String>> threadMap = mapping.get();
        ThreadLocal<String> json = new ThreadLocal<>();
        json.set(gson.toJson(threadMap));
        file.set(new File(getOutputFilePath() + "\\" + getPage()));
        try (FileWriter writer = new FileWriter(file.get())) {
            writer.write(json.get());
            writer.close();
            log.debug("File written: {}" + file.get().getAbsolutePath());
            ReportHelper.customLogInfo("Mapping saved in " + getPage() + "<br>" + json.get());
        } catch (IOException e) {
            log.error("Error writing to file: {}" + file.get().getAbsolutePath(), e);
            throw e;
        }
    }

    /**
     * This method writes creates a random alphanumeric string to be used as a key
     *
     * @param size
     * @return String
     */
    public static String generateRandomString(int size) {
        return RandomStringUtils.randomAlphanumeric(size);
    }

    /**
     * This method initializes the Driver Instance
     *
     * @return WebDriver
     */
    public static WebDriver createDriverInstance() {

        seleniumDriver = DriverHelper.getDriver();
        log.info("WebDriver started");
        return seleniumDriver;
    }

    /**
     * Returns Current Method Name
     *
     * @return String
     */
    private static String getCurrentMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    /**
     * Adds Properties to Mapping; if in record mode.
     *
     * @param _driver
     * @param _by
     */
    public static void addByPropertiesToMap(WebDriver _driver, By _by) {
        if (!recordMode) {
            log.debug("Not in Record Mode for method: " + getCurrentMethodName());
            return;
        }
        System.out.println("By Variable: " + _by.toString());
        WebElement element = _driver.findElement(_by);
        if (element == null) {
            log.debug("Element is null for method: " + getCurrentMethodName());
            return;
        }
        addToMap(mapping.get(), _by.toString(), "keyValue", generateRandomString(12), "id", element.getAttribute("id"), "tagName", element.getAttribute("tagName"), "className", element.getAttribute("className"), "textContent", element.getAttribute("textContent"), "location", element.getLocation().toString(), "size", element.getAttribute("size"), "src", element.getAttribute("src"), "alt", element.getAttribute("alt"), "name", element.getAttribute("name"), "type", element.getAttribute("type"), "href", element.getAttribute("href"), "style", element.getAttribute("style"), "value", element.getAttribute("value"), "width", element.getAttribute("width"), "height", element.getAttribute("height"), "title", element.getAttribute("title"), "onclick", element.getAttribute("onclick"), "for", element.getAttribute("for"), "rows", element.getAttribute("rows"), "cols", element.getAttribute("cols"), "action", element.getAttribute("action"), "oninput", element.getAttribute("oninput"), "maxlength", element.getAttribute("maxlength"), "max", element.getAttribute("max"), "min", element.getAttribute("min"), "pattern", element.getAttribute("pattern"), "placeholder", element.getAttribute("placeholder"), "step", element.getAttribute("step"), "autocomplete", element.getAttribute("autocomplete"), "formaction", element.getAttribute("formaction"), "formenctype", element.getAttribute("formenctype"), "method", element.getAttribute("method"), "formmethod", element.getAttribute("formmethod"), "formtarget", element.getAttribute("formtarget"), "target", element.getAttribute("target"), "wrap", element.getAttribute("wrap"), "usemap", element.getAttribute("usemap"));
    }

    /**
     * This method adds a mapping to the existing map for the referenced propertiesPage
     *
     * @param mapping
     */
    public static void addToMap(Map<String, Map<String, String>> mapping, String key, String... values) {
        if (!recordMode) {
            log.debug("Not in Record Mode for method: {}" + Thread.currentThread().getStackTrace()[1].getMethodName());
            return;
        }
        Map<String, String> valueMap = new HashMap<>();
        boolean asterisksFound = false;
        for (int i = 0; i < values.length; i += 2) {
            if (values[i + 1] != null && values[i + 1].contains("*")) {
                asterisksFound = true;
                log.debug("Asterisks found in value {}" + values[i + 1]);
                break;
            }
            valueMap.put(values[i], values[i + 1]);
        }
        if (!asterisksFound) {
            mapping.put(key, valueMap);
            log.debug("Value Map added for key {}" + key);
        }
    }

    /**
     * This method retrieves the existing map from the referenced propertiesPage
     */
    public static void retrieveExistingMapFromFile() {
        mapping.get().clear();
        ClassLoader classLoader = WebElementHelper.class.getClassLoader();
        URL url = WebElementHelper.class.getClassLoader().getResource(getPage());
        if (url != null) {
            File file = new File(classLoader.getResource(getPage()).getFile());
            try (FileReader reader = new FileReader(file)) {
                Gson gson = new Gson();
                Map<String, Map<String, String>> values = gson.fromJson(reader, Map.class);
                mapping.get().putAll(values);
            } catch (IOException e) {
                log.error("Error reading from file", e);
            }
        } else {
            log.error("File does NOT EXIST in Project->Resources folder: {}" + getPage());
        }
    }

    /**
     * This method retrieves the values for a given record of the mapping where the key is a string identifier for the array list.
     * Such as the By. object.
     *
     * @param findByKey
     */
    public static void getAlternativeLocatorsByKey(String findByKey) {
        Map<String, String> valueMap = mapping.get().getOrDefault(findByKey, Collections.emptyMap());
        size = valueMap.getOrDefault("size", "");
        className = valueMap.getOrDefault("className", "");
        textContent = valueMap.getOrDefault("textContent", "");
        id = valueMap.getOrDefault("id", "");
        tagName = valueMap.getOrDefault("tagName", "");
        location = valueMap.getOrDefault("location", "");
        randomKey = valueMap.getOrDefault("keyValue", "");
        src = valueMap.getOrDefault("src", "");
        alt = valueMap.getOrDefault("alt", "");
        href = valueMap.getOrDefault("href", "");
        name = valueMap.getOrDefault("name", "");
        type = valueMap.getOrDefault("type", "");
        style = valueMap.getOrDefault("style", "");
        value = valueMap.getOrDefault("value", "");
        width = valueMap.getOrDefault("width", "");
        height = valueMap.getOrDefault("height", "");
        title = valueMap.getOrDefault("title", "");
        onclick = valueMap.getOrDefault("onclick", "");
        _for = valueMap.getOrDefault("for", "");
        rows = valueMap.getOrDefault("rows", "");
        cols = valueMap.getOrDefault("cols", "");
        action = valueMap.getOrDefault("action", "");
        oninput = valueMap.getOrDefault("oninput", "");
        maxlength = valueMap.getOrDefault("maxlength", "");
        max = valueMap.getOrDefault("max", "");
        min = valueMap.getOrDefault("min", "");
        pattern = valueMap.getOrDefault("pattern", "");
        placeholder = valueMap.getOrDefault("placeholder", "");
        step = valueMap.getOrDefault("step", "");
        autocomplete = valueMap.getOrDefault("autocomplete", "");
        formaction = valueMap.getOrDefault("formaction", "");
        formenctype = valueMap.getOrDefault("formenctype", "");
        method = valueMap.getOrDefault("method", "");
        formmethod = valueMap.getOrDefault("formmethod", "");
        formtarget = valueMap.getOrDefault("formtarget", "");
        target = valueMap.getOrDefault("target", "");
        wrap = valueMap.getOrDefault("wrap", "");
        usemap = valueMap.getOrDefault("usemap", "");
    }

    /**
     * This method stores the values for a given record for the mapping where the key is a string identifier for the array list.
     * Such as the By. object.
     *
     * @param findByKey
     */
    public static void setWebElementPropertiesByKey(String findByKey) {
        Map<String, String> valueMap = mapping.get().getOrDefault(findByKey, Collections.emptyMap());
        setSize(valueMap.getOrDefault("size", ""));
        setClassName(valueMap.getOrDefault("className", ""));
        setTextContent(valueMap.getOrDefault("textContent", ""));
        setId(valueMap.getOrDefault("id", ""));
        setTagName(valueMap.getOrDefault("tagName", ""));
        setLocation(valueMap.getOrDefault("location", ""));
        setRandomKey(valueMap.getOrDefault("keyValue", ""));
        setSrc(valueMap.getOrDefault("src", ""));
        setAlt(valueMap.getOrDefault("alt", ""));
        setHref(valueMap.getOrDefault("href", ""));
        setName(valueMap.getOrDefault("name", ""));
        setType(valueMap.getOrDefault("type", ""));
    }

    /**
     * This method prints all the stored values for the mapping
     */
    public static void printMap() {
        for (Map.Entry<String, Map<String, String>> entry : mapping.get().entrySet()) {
            String key = entry.getKey();
            Map<String, String> values = entry.getValue();
            System.out.println(key + ": " + values);
        }
    }

    /**
     * This method prints the stored values for the mapping for the given key; where the key is a string identifier for the array list.
     *
     * @param findByKey
     */
    public static void printMapValuesByKey(String findByKey) {
        if (mapping.get().containsKey(findByKey)) {
            Map<String, String> values = mapping.get().get(findByKey);
            System.out.println(findByKey + ": " + values);  // Outputs: {tag4=value4, tag5=value5, tag6=value6}
        }
    }

    /**
     * This method the stored values for the mapping prior to be written to the map.
     */
    public static void printOutTmpKeyValues() {
        log.debug("Last known values [Begin]");
        log.debug(by + ": {" + "id=" + id + ", tagName=" + tagName + ", className=" + className + ", textContent=" + textContent + ", location=" + location + ", size=" + size + ", keyValue=" + getRandomKey() + ", src=" + getSrc() + ", alt=" + getAlt() + ", name=" + getName() + ", type=" + getType() + ", href=" + getHref() + "}");
        log.debug("Last known values [End]");
    }

    /**
     * This method the stored values for the mapping prior to be written to the map.
     *
     * @param findByKey
     */
    public static boolean retrieveMapValuesByKey(String findByKey) {
        System.out.println("Key Search:" + findByKey);
        if (mapping.get().containsKey(findByKey)) {
            Map<String, String> valueMap = mapping.get().get(findByKey);
            setProperties(valueMap);
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method the stored values from the mapping into the stored values for each.
     *
     * @param valueMap
     */
    private static void setProperties(Map<String, String> valueMap) {
        setSize(valueMap.getOrDefault("size", ""));
        setClassName(valueMap.getOrDefault("className", ""));
        setTextContent(valueMap.getOrDefault("textContent", ""));
        setId(valueMap.getOrDefault("id", ""));
        setTagName(valueMap.getOrDefault("tagName", ""));
        setLocation(valueMap.getOrDefault("location", ""));
        setRandomKey(valueMap.getOrDefault("keyValue", ""));
        setSrc(valueMap.getOrDefault("src", ""));
        setAlt(valueMap.getOrDefault("alt", ""));
        setHref(valueMap.getOrDefault("href", ""));
        setName(valueMap.getOrDefault("name", ""));
        setType(valueMap.getOrDefault("type", ""));
    }

    // Getters and Setters below this line

    public static WebDriver getDriverInstance() {
        return seleniumDriver;
    }

    public static Map<String, Map<String, String>> getMapping() {
        return mapping.get();
    }

    public static void setMapping(Map<String, Map<String, String>> mapping) {
        //WebElementHelper.mapping = mapping;
    }

    public static By getBy() {
        return by;
    }

    public static void setBy(By by) {
        WebElementHelper.by = by;
    }

    public static String getSize() {
        return size;
    }

    public static void setSize(String size) {
        WebElementHelper.size = size;
    }

    public static String getClassName() {
        return className;
    }

    public static void setClassName(String className) {
        WebElementHelper.className = className;
    }

    public static String getLocation() {
        return location;
    }

    public static void setLocation(String location) {
        WebElementHelper.location = location;
    }

    public static String getTextContent() {
        return textContent;
    }

    public static void setTextContent(String textContent) {
        WebElementHelper.textContent = textContent;
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        WebElementHelper.id = id;
    }

    public static String getTagName() {
        return tagName;
    }

    public static void setTagName(String tagName) {
        WebElementHelper.tagName = tagName;
    }

    public static String getRandomKey() {
        return randomKey;
    }

    public static void setRandomKey(String randomKey) {
        WebElementHelper.randomKey = randomKey;
    }

    public static boolean getRecordMode() {
        return recordMode;
    }

    public static void setRecordMode() {
        if (System.getProperty("recordMode") != null) {
            WebElementHelper.recordMode = Boolean.parseBoolean(System.getProperty("recordMode"));
            log.info("Record mode " + WebElementHelper.recordMode + " selected from command line");
        } else {
            WebElementHelper.recordMode = Boolean.parseBoolean(PropertyHelper.getProperty("recordMode"));
            log.info("Record mode " + WebElementHelper.recordMode + " selected from property file");
        }
    }

    public static String getPage() {
        return pageFolder + pages.get();
    }

    public static void setPage(String page) {
        if (!page.endsWith(".json")) {
            page = page + ".json";
        }
//        if (getRecordMode()) {
//            try {
//                writeMap();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        pages.set(page);
//        retrieveExistingMapFromFile();
    }

    public static String getSrc() {
        return src;
    }

    public static void setSrc(String src) {
        WebElementHelper.src = src;
    }

    public static String getHref() {
        return href;
    }

    public static void setHref(String href) {
        href = href.endsWith("/") ? href.substring(0, href.length() - 1) : href;
        WebElementHelper.href = href;
    }

    public static String getAlt() {
        return alt;
    }

    public static void setAlt(String alt) {
        WebElementHelper.alt = alt;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        WebElementHelper.name = name;
    }

    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        WebElementHelper.type = type;
    }

    public static String getOutputFilePath() {
        return outputFilePath;
    }

    public static void setOutputFilePath(String outputFilePath) {
        WebElementHelper.outputFilePath = outputFilePath;
    }

    public static void clickElement(EventFiringWebDriver eventFiringWebDriver, By element) {
        try {
            WebElement ele = findAndReturnElement(eventFiringWebDriver, element);
            ele.click();
            log.info("Clicked on " + ele);
            ReportHelper.customLogSuccess("Clicked on Element " + ele);
        } catch (Exception e) {
            log.error("Click failed on " + element);
            fail("Unable to click on element");
        }
    }

    public static void enterText(EventFiringWebDriver eventFiringWebDriver, By element, String value) {
        try {
            WebElement ele = findAndReturnElement(eventFiringWebDriver, element);
            ele.clear();
            ele.sendKeys(value);
            log.info("Entered text in " + ele);
            ReportHelper.customLogSuccess("Entered text " + value + " in " + ele);
        } catch (Exception e) {
            log.error("Failed to enter text " + value + " in " + element);
            fail("Unable to enter text to element:" + by + " cause of error: " + e);
        }
    }

    public static boolean existsAndDisplayed(EventFiringWebDriver eventFiringWebDriver, By element) {
        return findAndReturnElement(eventFiringWebDriver, element).isDisplayed();
    }

    public static WebElement findAndReturnElement(EventFiringWebDriver eventFiringWebDriver, By element) {
        size = "";
        className = "";
        textContent = "";
        id = "";
        tagName = "";
        location = "";
        randomKey = "";
        src = "";
        alt = "";
        href = "";
        name = "";
        type = "";
        WebElement ele = null;

        try {
            ele = eventFiringWebDriver.findElement(element);
        } catch (NoSuchElementException e) {
            String locator = element.toString();

            ReportHelper.customLogInfo("Trying to find previously stored element in " + pages.get());
            retrieveMapValuesByKey(locator);
            System.out.println("Element Not Found:");
            System.out.println(locator + ": {");
            System.out.println("    \"" + "className\": \"" + getClassName() + "\",");
            System.out.println("    \"" + "textContent\": \"" + getTextContent() + "\",");
            System.out.println("    \"" + "location\": \"" + getLocation() + "\",");
            System.out.println("    \"" + "id\": \"" + getId() + "\",");
            System.out.println("    \"" + "tagName\": \"" + getTagName() + "\"");
            System.out.println("    \"" + "alt\": \"" + getAlt() + "\"");
            System.out.println("    \"" + "src\": \"" + getSrc() + "\"");
            System.out.println("    \"" + "href\": \"" + getHref() + "\"");
            System.out.println("    \"" + "name\": \"" + getName() + "\"");
            System.out.println("    \"" + "keyValue\": \"" + getRandomKey() + "\"");
            System.out.println("}\n");
//            //Need a method to read from stored map and retrieve key value properties
            ReportHelper.customLogSuccess("Stored element key for " + locator + " -> " + getRandomKey());
//            // System.out.println("Location:"+helper.getLocation());
            ReportHelper.customLogInfo("Trying to find the closest possible match");
//
            // This routine will setup attribute value if no json file
            getAttributeFromLocator(locator);

            ele = FindClosestMatchingElement.getClosestElement(eventFiringWebDriver, locator, className,
                    textContent, id, tagName, location, src, alt, href, name, type);
        }
        return ele;
    }

    private static void getAttributeFromLocator(String locator) {
        if ((className == null || className.isEmpty()) && locator.contains("By.className")) {
            className = locator.substring(locator.indexOf(":") + 2);
        }
        if ((name == null || name.isEmpty()) && locator.contains("By.name")) {
            name = locator.substring(locator.indexOf(":") + 2);
        }
        if ((id == null || id.isEmpty()) && locator.contains("By.id")) {
            id = locator.substring(locator.indexOf(":") + 2);
        }
        if ((tagName == null || tagName.isEmpty()) && locator.contains("By.tagName")) {
            tagName = locator.substring(locator.indexOf(":") + 2);
        }
        if ((href == null || href.isEmpty()) && locator.contains("By.linkText")) {
            href = locator.substring(locator.indexOf(":") + 2);
        }
        if (locator.contains("xpath")) {
            if (locator.contains("@name"))
                name = locator.substring(locator.indexOf("'") + 1, locator.indexOf("']"));
            else if (locator.contains("@id"))
                id = locator.substring(locator.indexOf("'") + 1, locator.indexOf("']"));
            else if (locator.contains("@href"))
                href = locator.substring(locator.indexOf("'") + 1, locator.indexOf("']"));
            else if (locator.contains("(.,") || locator.contains("text()"))
                textContent = locator.substring(locator.indexOf("'") + 1, locator.indexOf("']"));
            else if (locator.contains("@type"))
                type = locator.substring(locator.indexOf("'") + 1, locator.indexOf("']"));

            tagName = locator.substring(locator.indexOf("//") + 2, locator.indexOf("["));
        }
    }

    public static void takeScreenshot(EventFiringWebDriver eventFiringWebDriver) {
        try {
            TakesScreenshot ts = eventFiringWebDriver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            ReportHelper.getScenario().attach(screenshot, "image/png", "Screenshot");
            log.info("Screenshot attached to report ");
        } catch (Exception e) {
            log.error("Unable to attach screenshot: " + e);
        }
    }

    public static void loadCustomUrl(EventFiringWebDriver eventFiringWebDriver, String url) {
        targetURL = "file:///" + projectFolder + "src/test/resources/WebPages/" + url;
        eventFiringWebDriver.get(targetURL);
        waitForPageToLoad(eventFiringWebDriver);
    }

    public static By getAlternativeLocators(EventFiringWebDriver eventDriver, By by) {
        findAndReturnElement(eventDriver, by);
        return By.xpath(FindClosestMatchingElement.getAltXpath());
    }
}