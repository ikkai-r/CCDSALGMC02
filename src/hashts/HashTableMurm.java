package hashts;

import hashfuncs.MurmurHash2;

public class HashTableMurm implements HashTable {
    private static int sizeOfSubStrings;
    private int[] hashTableHM;
    private int collFreq = 0;

    public HashTableMurm(int sizeofSubStrings) {
        HashTableMurm.sizeOfSubStrings = sizeofSubStrings;
        this.hashTableHM = new int[sizeofSubStrings];
        setHashtableHM();
    }

    public void setHashtableHM() {
        for (int index = 0; index < sizeOfSubStrings; index++) {
            this.hashTableHM[index] = -1;
        }
    }

    public static int getHashIndex(String substring) {
        return Math.floorMod(MurmurHash2.hash32(substring), sizeOfSubStrings);
    }

    public void addElement(String keySubstring) {
        hashTableHM[getHashIndex(keySubstring)] = 1;
    }

    public boolean searchElement(String keySubstring) {
        return hashTableHM[getHashIndex(keySubstring)] > -1;
    }

    public void updateElement(String keySubstring) {
        hashTableHM[getHashIndex(keySubstring)]++;
    }

    public void printKMerDistribution() {
        //print array
    }

}
