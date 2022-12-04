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

    // hashing function
    public static int getHashIndex(String substring) {
        return Math.floorMod(MurmurHash2.hash64(substring), HashTables.sizeofSubStrings);
    }

    /**
     * Implements the chaining technique, adding the element at the end of the linked list.
     * @param keySubstring      substring to be added.
     */
    public void collisionResolution(String keySubstring) {
        addElement(keySubstring);
        collFreq++;
    }

    /**
     * Checks if string collides or not.
     * @param keySubstring      substring to be checked.
     * @return                  true, if it is a new substring.
     *                          false, if it is an existing substring
     */
    public boolean needCollisionResolution(String keySubstring) {
        boolean needCR = true;

        for (int index = 0; index < super.hashTable[getHashIndex(keySubstring)].size(); index++) {
            if (super.hashTable[getHashIndex(keySubstring)].get(index).equals(keySubstring)) {
                needCR = false;
            }
        }

        return needCR;
    }

    /**
     * Inserts the substring and its value in the list at the corresponding hashed index.
     * @param keySubstring      substring to be added.
     */
    public void addElement(String keySubstring) {
        super.hashTable[getHashIndex(keySubstring)].add(keySubstring);
        super.hashTable[getHashIndex(keySubstring)].add(1);
    }

    /**
     * Returns if there is no elements present in the list at the corresponding hashed index.
     * @param keySubstring      substring to be searched
     * @return                  returns false if substring is not present in the hash table.
     */
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

    /**
     * Prints KMer Distribution along as its collision frequency.
     * @param kNum      KNumber
     */
    public void printKMerDistribution(int kNum) {
        super.printKMerDistribution(kNum);
        System.out.println("\nCollision frequency for MurmurHash2: " + collFreq);
    }

}
