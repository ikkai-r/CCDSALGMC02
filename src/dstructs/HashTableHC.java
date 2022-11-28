package dstructs;

import java.util.Hashtable;

public class HashTableHC {

    private Hashtable<String, Integer> kMerDistrib = new Hashtable<String, Integer>();

    public void addElement(String keySubstring, int value) {
        this.kMerDistrib.put(keySubstring, value);
    }

    public boolean searchElement(String keySubString) {
        return this.kMerDistrib.containsKey(keySubString);
    }

    public void updateElement(String keySubString) {
        this.kMerDistrib.replace(keySubString, this.kMerDistrib.get(keySubString) + 1);
    }

    public void printKMerDistribution() {

    }
}
