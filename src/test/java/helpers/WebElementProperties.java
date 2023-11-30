package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebElementProperties {

    String tagName;
    String textContent;
    String id;
    String className;
    Point location;
    Dimension size;
    private By by;

    private Map<By, List<WebElementProperties>> elementPropertiesMap;

    public WebElementProperties(By by, String tagName, String textContent, String id, String className, Point location, Dimension size) {
        this.by = by;
        this.tagName = tagName;
        this.textContent = textContent;
        this.id = id;
        this.className = className;
        this.location = location;
        this.size = size;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("by", by.toString());
        map.put("tagName", tagName);
        map.put("textContent", textContent);
        map.put("id", id);
        map.put("className", className);
        map.put("location", location);
        map.put("size", size);
        return map;
    }

    public void addElementProperties(WebElementProperties elementProperties) {
        List<WebElementProperties> elementPropertiesList = elementPropertiesMap.get(by);
        if (elementPropertiesList == null) {
            elementPropertiesList = new ArrayList<>();
            elementPropertiesMap.put(by, elementPropertiesList);
        }
        elementPropertiesList.add(elementProperties);
    }
}
