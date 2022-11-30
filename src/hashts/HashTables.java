package hashts;

import java.util.LinkedList;

public class HashTables {
    protected static int sizeofSubStrings;
    protected LinkedList<Object>[] hashTable;

    public void setHashTable() {
        for (int index = 0; index <= sizeofSubStrings; index++) {
            this.hashTable[index] = new LinkedList<>();
        }
    }

    public void printKMerDistribution() {
        for (int index = 0; index <= sizeofSubStrings; index++) {
            System.out.println(hashTable[index]);
        }
    }
}
