package org.nsu.oop.task1.version1;

public class Main {
    public static void main(String args[]) {
        MyFileReader fileReader= new MyFileReader(args[0]);
        Parser parser = new Parser();
        DataStatistic data = new DataStatistic();
        while (fileReader.isOpen()) {
            String currLine = fileReader.getLine();
            if (currLine.isEmpty()) {
                continue;
            }
            parser.setString(currLine);
            for (String str: parser.getWordsVector()) {
                data.addData(str);
            }
        }
        ConverterCSV csv = new ConverterCSV("out.csv", data);
        csv.createCSVFile();
    }
}
