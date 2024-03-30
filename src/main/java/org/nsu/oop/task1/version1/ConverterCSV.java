package org.nsu.oop.task1.version1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class ConverterCSV {
    private String name = "out.csv";
    private DataStatistic data;
    private FileWriter file;
    ConverterCSV(String str, DataStatistic data) {
        name = str;
        this.data = data;
    }

    ConverterCSV(DataStatistic data) {
        this.data = data;
    }

    void createCSVFile() {
        try {
            file = new FileWriter(name);
            Vector<DataStatistic.CustomPair> vecData = data.getVecData();
            for (DataStatistic.CustomPair it : vecData) {
                file.write(it.str + ';' + it.counter + ';' + (int)(it.counter / (double) data.numberOfWords() * 100) + '%' + '\n');
            }
            file.flush();
            file.close();
        } catch (IOException e) {
            System.err.println("Error while creating file: " + e.getLocalizedMessage());
        }
    }
}
