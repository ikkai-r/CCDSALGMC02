package hashts;

import hashfuncs.CityHash;

public class HashTableCityH implements HashTable {
    private static int sizeofSubStrings;
    private int[] hashtableCH;
    private int collFreq = 0;

    public HashTableCityH(int sizeofSubStrings) {
        HashTableCityH.sizeofSubStrings = sizeofSubStrings;
        this.hashtableCH = new int[sizeofSubStrings];
        setHashtableCH();
    }

    public void setHashtableCH() {
        for (int index = 0; index < sizeofSubStrings; index++) {
            hashtableCH[index] = -1;
        }
    }

    public static byte[] getSBytes(String s) {
        return s.getBytes();
    }

    //hashing function
    public static int getHashIndex(String substring) {
        return Math.floorMod(CityHash.cityHash64(getSBytes(substring), 0,substring.length()), sizeofSubStrings);
    }

    public void addElement(String keySubstring, int value) {
        hashtableCH[getHashIndex(keySubstring)] = value;
    }

    public boolean searchElement(String keySubstring) {
        return hashtableCH[getHashIndex(keySubstring)] > -1;
    }

    public void updateElement(String keySubstring) {
        hashtableCH[getHashIndex(keySubstring)]++;
    }

    public void printKMerDistribution() {
        for (int c: hashtableCH) {
            System.out.println(c);
        }
    }

}
