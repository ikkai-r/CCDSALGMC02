package dstructs;

public class HashTableHF extends HashTable {

    //TODO: Override hashCode and equals

    @Override
    public int hashCode() {
        return 0;
    }

    public void addElement(String keySubstring, int value) {
        super.kMerDistrib.put(keySubstring, value);
    }

    public boolean searchElement(String keySubString) {
        return super.kMerDistrib.containsKey(keySubString);
    }

    public void updateElement(String keySubString) {
        super.kMerDistrib.replace(keySubString, super.kMerDistrib.get(keySubString) + 1);
    }

    public void printKMerDistribution() {

    }

}
