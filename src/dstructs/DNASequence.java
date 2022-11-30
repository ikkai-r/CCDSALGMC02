package dstructs;

import hashts.HashTableMurm;
import hashts.HashTableCityH;

public class DNASequence {
    private String dnaString;
    private int sizeOfSubstrings;
    HashTableCityH htHC;
    HashTableMurm htHF;
    BinarySearchTree bst;

    public DNASequence(String dnaString, int sizeOfSubstrings) {
        this.dnaString = dnaString;
        this.sizeOfSubstrings = sizeOfSubstrings;
        this.htHC = new HashTableCityH(sizeOfSubstrings);
        this.htHF = new HashTableMurm(sizeOfSubstrings);
        this.bst = new BinarySearchTree();
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

            //using hashtable cityhash
            found = htHC.searchElement(substring);
            if (found) {
                //update hashtable
                if (htHC.needCollisionResolution(substring)) {
                    htHC.collisionResolution(substring);
                } else {
                    htHC.updateElement(substring);
                }
            } else {
                //add element
                    htHC.addElement(substring);
            }

            //using hashtable murmurhash2
            found = htHF.searchElement(substring);
            if (found) {
                //update hashtable
                if (htHF.needCollisionResolution(substring)) {
                    htHF.collisionResolution(substring);
                } else {
                    htHF.updateElement(substring);
                }
            } else {
                //add element
                htHF.addElement(substring);
            }

            dnaStringHT = dnaStringHT.substring(1);
            length--;
        }

        System.out.println("=======================================");
        System.out.println("HASHTABLE: USING CITYHASH");
        System.out.println("=======================================");
        htHC.printKMerDistribution();
        System.out.println();
        System.out.println("=======================================");
        System.out.println("HASHTABLE: USING MURMURHASH2");
        System.out.println("=======================================");
        htHF.printKMerDistribution();

        //TODO: Binary Search Tree

    }

    public void printComputedKMerDist() {

        //for hashtable
        //print first implementation
        htHC.printKMerDistribution();
        //print second implementation
        htHF.printKMerDistribution();

        //print bst
        bst.printKMerDistribution();

    }

}
