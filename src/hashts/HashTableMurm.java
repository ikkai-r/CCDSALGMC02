package hashts;

import hashfuncs.MurmurHash2;

import java.util.LinkedList;

public class HashTableMurm extends HashTables implements HashTable {
    private int collFreq = 0;

    public HashTableMurm(int sizeofSubStrings) {
        HashTables.sizeofSubStrings = sizeofSubStrings;
        super.hashTable = new LinkedList[sizeofSubStrings+1];
        super.setHashTable();
    }

    public static int getHashIndex(String substring) {
        return Math.floorMod(MurmurHash2.hash32(substring), HashTables.sizeofSubStrings);
    }

    public void collisionResolution(String keySubstring) {
        addElement(keySubstring);
        collFreq++;
    }

    public boolean needCollisionResolution(String keySubstring) {
        boolean needCR = true;

        for (int index = 0; index < super.hashTable[getHashIndex(keySubstring)].size(); index++) {
            if (super.hashTable[getHashIndex(keySubstring)].get(index).equals(keySubstring)) {
                needCR = false;
            }
        }

        return needCR;
    }

    public void addElement(String keySubstring) {
        super.hashTable[getHashIndex(keySubstring)].add(keySubstring);
        super.hashTable[getHashIndex(keySubstring)].add(1);
    }

    public boolean searchElement(String keySubstring) {
        return !super.hashTable[getHashIndex(keySubstring)].isEmpty();
    }

    public void updateElement(String keySubstring) {
        int newInt;

        for (int index = 0; index < super.hashTable[getHashIndex(keySubstring)].size(); index+=2) {
            if (super.hashTable[getHashIndex(keySubstring)].get(index).equals(keySubstring)) {
                newInt = (int) super.hashTable[getHashIndex(keySubstring)].get(index+1);
                super.hashTable[getHashIndex(keySubstring)].set(index+1, newInt + 1);
            }
        }
    }

    public void printKMerDistribution(int kNum) {
        System.out.println(kNum + "-mer\t no. of occurrences");
        for (int index = 0; index <= HashTables.sizeofSubStrings; index++) {
            System.out.println(super.hashTable[index]);
        }
        System.out.println("Collision frequency for MurmurHash2: " + collFreq);
    }

}
