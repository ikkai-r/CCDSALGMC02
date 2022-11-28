package dstructs;

public class HashTableHF {

    //TODO: Override hashCode and equals

    private int sizeofSubStrings;
    private String[] hashTableHF;

    public HashTableHF(int sizeofSubStrings) {
        this.sizeofSubStrings = sizeofSubStrings;
    }

    public void setHashTable() {
        this.hashTableHF = new String[sizeofSubStrings*sizeofSubStrings];
    }

    //make own hashing function
    //make array with a fixed n
    @Override
    public int hashCode() {
        return 0;
        //make hashing function
    }

    public void addElement(String keySubstring, int value) {
        //array add
    }

    public boolean searchElement(String keySubString) {
        //array search
        return true;
    }

    public void updateElement(String keySubString) {
        //array update element
    }

    public void printKMerDistribution() {
        //print array
    }

}
