package hashts;

import hashfuncs.CityHash;

public class HashTableCityH implements HashTable {
    private static int sizeofSubStrings;

    //TODO: Make linked list
    private int[] hashtableCH;
    private int collFreq = 0;

    public HashTableCityH(int sizeofSubStrings) {
        HashTableCityH.sizeofSubStrings = sizeofSubStrings;
        this.hashtableCH = new int[sizeofSubStrings];
        setHashtableCH();
    }

    public void setHashtableCH() {
        for (int index = 0; index < sizeofSubStrings; index++) {
            hashtableCH[index] = 0;
        }
    }

    public static byte[] getSBytes(String s) {
        return s.getBytes();
    }

    //hashing function
    public static int getHashIndex(String substring) {
        return Math.floorMod(CityHash.cityHash64(getSBytes(substring), 0,substring.length()), sizeofSubStrings);
    }

    //TODO: Fix collisionResolution. meron atang smth wrong with the add element and update element
    //dapat macheck din if tama iuupdate
    public void addElement(String keySubstring) {
        System.out.println(searchElement(keySubstring));
        if(searchElement(keySubstring)) {
            collisionResolution(keySubstring);
        } else {
            hashtableCH[getHashIndex(keySubstring)] = 1;
            System.out.println(keySubstring);
        }
    }

    public boolean searchElement(String keySubstring) {
        return hashtableCH[getHashIndex(keySubstring)] > 0;
    }

    public void updateElement(String keySubstring) {
        hashtableCH[getHashIndex(keySubstring)]++;
    }

    public void collisionResolution(String keySubstring) {
        int newIndex;
        int hashIndex = getHashIndex(keySubstring);

        for (int index = 0; index < sizeofSubStrings; index++) {
            newIndex = (hashIndex+((int)Math.pow(index, 2)))%sizeofSubStrings;
            if (!searchElement(keySubstring)) {
                hashtableCH[newIndex] = 1;
                System.out.println("h " + keySubstring);
                break;
            } else {
                collFreq++;
            }
        }
    }

    public void printKMerDistribution() {
        for (int c: hashtableCH) {
            System.out.println(c);
        }
        System.out.println("coll freq: " + collFreq);
    }

}
