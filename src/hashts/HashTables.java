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

    public void printKMerDistribution(int kNum) {

        int countOcc = 1;

        System.out.println(kNum + "-mer\t no. of occurrences");

        for (int index = 0; index <= HashTables.sizeofSubStrings; index++) {
            if (!this.hashTable[index].isEmpty()) {

                for (int counter = 0; counter < this.hashTable[index].size(); counter+=2) {

                    System.out.print(this.hashTable[index].get(counter));

                    if (this.hashTable[index].size() > 3) {
                        System.out.println("\t\t\t" + this.hashTable[index].get(countOcc));
                        if (countOcc < this.hashTable[index].size()) {
                            countOcc+=2;
                        }
                    } else {
                        System.out.println("\t\t\t" + this.hashTable[index].get(1));
                    }
                }

            }
            countOcc = 1;
        }
    }
}
