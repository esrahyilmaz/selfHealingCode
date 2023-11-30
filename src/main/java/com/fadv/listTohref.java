package com.fadv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class listTohref {
    public static void main(String[] args) {
        String filePath = "C:\\tmp\\list.txt";

        try {
            BufferedReader lineReader = new BufferedReader(new FileReader(filePath));
            String lineText = null;

            while ((lineText = lineReader.readLine()) != null) {
                if (lineText.length() > 2) {
                    System.out.println("<a href=\"https://dev.azure.com/fadv-devops/ProdDev/_workitems/edit/" + lineText + "\">" + lineText + "</a>");
                } else {
                    System.out.println(lineText);
                }
            }

            lineReader.close();
        } catch (
                IOException ex) {
            System.err.println(ex);
        }
    }
}
