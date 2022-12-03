package dnaseq;

import bst.BinarySearchTree;
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

    public void separateDNASequence() {

        String dnaStringHT = dnaString;
        String dnaStringBST = dnaString;

        int length = dnaString.length();
        String substring;

        bst.create();

        while (length >= sizeOfSubstrings) {
            substring = dnaStringBST.substring(0, sizeOfSubstrings);
            substring = dnaStringHT.substring(0, sizeOfSubstrings);

            hashTableDist(substring);

            dnaStringHT = dnaStringHT.substring(1);

            bstDist(substring);

            dnaStringBST = dnaStringBST.substring(1);
            length--;
        }


        printComputedKMerDist();
        bst.destroy();



    }

    public void hashTableDist(String substring) {
        boolean found;
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

    }

    public void bstDist(String substring) {
        if (bst.searchCall(substring)) {
            //update value
            bst.update(substring);
        } else {
            //insert
            bst.insertCall(substring);
        }
    }

    public void printComputedKMerDist() {

        //for hashtable
        //print first implementation
        System.out.println("=======================================");
        System.out.println("HASHTABLE: USING CITYHASH");
        System.out.println("=======================================");
        htHC.printKMerDistribution(sizeOfSubstrings);

        //print second implementation
        System.out.println();
        System.out.println("=======================================");
        System.out.println("HASHTABLE: USING MURMURHASH2");
        System.out.println("=======================================");
        htHF.printKMerDistribution(sizeOfSubstrings);

        //print bst
        System.out.println();
        System.out.println("=======================================");
        System.out.println("BINARY SEARCH TREE");
        System.out.println("=======================================");
        bst.printKMerDistribution(sizeOfSubstrings);

    }

}
