package org.nsu.oop.task1.version1;

import java.util.*;

public class DataStatistic {
    private int wordCounter = 0;
    public class CustomPair {
        String str;
        Integer counter;
        CustomPair(String str) {
            this.str = str;
            counter = 1;
        }
    }

    TreeMap<String, CustomPair> mapData = new TreeMap<>();
    void addData(String str) {
        wordCounter++;
        if (mapData.containsKey(str)) {
            mapData.get(str).counter += 1;
        } else {
            CustomPair pair = new CustomPair(str);
            mapData.put(str, pair);
        }
    }

    public class CustomComparator implements Comparator<CustomPair> {
        public int compare(CustomPair p1, CustomPair p2) {
            return p1.counter.compareTo(p2.counter);
        }
    }

    public Vector<CustomPair> getVecData() {
        Vector<CustomPair> vecData = new Vector<>(mapData.values());
        vecData.sort(new CustomComparator());
        Collections.reverse(vecData);
        return vecData;
    }

    int numberOfWords() {
        return wordCounter;
    }

}
