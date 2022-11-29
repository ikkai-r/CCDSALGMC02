package dstructs;

import hashts.HashTableMurm;
import hashts.HashTableCityH;

public class DNASequence {
    private String dnaString;
    private int sizeOfSubstrings;
    private String[] dnaSubstrings;
    HashTableCityH htHC;
    HashTableMurm htHF;

    public DNASequence(String dnaString, int sizeOfSubstrings) {
        this.dnaString = dnaString;
        this.sizeOfSubstrings = sizeOfSubstrings;
        this.htHC = new HashTableCityH(sizeOfSubstrings);
        this.htHF = new HashTableMurm(sizeOfSubstrings);
    }

    //TODO: Make function to separate string into k-length substrings

    public void separateDNASequence() {

        String dnaStringHT = dnaString;
        String dnaStringBST = dnaString;

        int length = dnaString.length();
        String substring;
        boolean found;

        while (length >= sizeOfSubstrings) {

            substring = dnaStringHT.substring(0, sizeOfSubstrings);
            found = htHC.searchElement(substring);

            if (found) {
                //update hashtable
                htHC.updateElement(substring);
            } else {
                //add element
                htHC.addElement(substring, 1);
            }

            dnaStringHT = dnaStringHT.substring(1);
            length--;
        }

        htHC.printKMerDistribution();

        //TODO: Call BST and store

    }

    public void printComputedKMerDist() {

        BinarySearchTree bst = new BinarySearchTree();

        //for hashtable
        //print first implementation
        htHC.printKMerDistribution();
        //print second implementation
        htHF.printKMerDistribution();

        //print bst
        bst.printKMerDistribution();

    }

}
