package org.nsu.oop.task1.version1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;


public class MyFileReader {
    private Reader reader = null;
    private boolean isOpen = false;
    MyFileReader(String fileName) {
        try {
            reader = new InputStreamReader(new FileInputStream(fileName));
        }
        catch (IOException e) {
            System.err.println("Error while reading file: " + e.getLocalizedMessage());
        }
        isOpen = true;
    }
    
    String getLine() {
        try {
            int ch = reader.read();
            StringBuilder str = new StringBuilder();
            while (ch != -1 && ch != 10) {
                str.append((char)ch);
                ch = reader.read();
            }
            if (ch == -1) {
                isOpen = false;
                reader.close();
            }
            return str.toString();
        } catch(IOException e) {
            System.err.println("Error while reading file: " + e.getLocalizedMessage());
        }
        return "";
    }

    boolean isOpen() {
        return isOpen;
    }
}
