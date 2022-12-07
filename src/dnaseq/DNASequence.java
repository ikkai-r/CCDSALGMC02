package dnaseq;

import bst.BinarySearchTree;
import hashts.HashTableMurm;
import hashts.HashTableCityH;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

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

    /**
     * Does the whole KMer process by firstly separating the substrings,
     * finding their frequencies,
     * and finding their collision frequencies
     */
    public void separateDNASequence() throws FileNotFoundException {

        String dnaStringHT = dnaString;
        String dnaStringBST = dnaString;

        int length = dnaString.length();
        String substring;

        bst.create(); // produces an empty BST

        // allocates each substring in a Hash Table and BST
        while (length >= sizeOfSubstrings) {
            substring = dnaStringBST.substring(0, sizeOfSubstrings);
            substring = dnaStringHT.substring(0, sizeOfSubstrings);

            hashTableDist(substring);

            dnaStringHT = dnaStringHT.substring(1);

            bstDist(substring);

            dnaStringBST = dnaStringBST.substring(1);
            length--;
        }


        printComputedKMerDist(); // prints the KMer Distribution of the Hash Table and BST
        bst.destroy();



    }

    /**
     * Adds the substring into the hashtable.
     * @param substring     substring to be added.
     */
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

    /**
     * Adds the substring in the BST.
     * @param substring     substring to be added.
     */
    public void bstDist(String substring) {
        if (bst.searchCall(substring)) {
            //update value
            bst.update(substring);
        } else {
            //insert
            bst.insertCall(substring);
        }
    }

    /**
     * Prints the KMer Distribution of the Hash tables (using CityHash and MurMurHash2) and BST
     */
    public void printComputedKMerDist() throws FileNotFoundException {
        double timeStart = 0.0;
        double timeFinish = 0.0;
        //for hashtable
        //print first implementation
        PrintStream output = new PrintStream("CITYHASH.txt");
        System.setOut(output);
        System.out.println("=======================================");
        System.out.println("HASHTABLE: USING CITYHASH");
        System.out.println("=======================================");
        timeStart = System.currentTimeMillis();
        htHC.printKMerDistribution(sizeOfSubstrings);
        timeFinish = System.currentTimeMillis();
        System.out.printf("RUNNING TIME OF CITYHASH: %.2f ms", timeFinish-timeStart);
        //print second implementation
        System.out.println();
        output = new PrintStream("MURMURHASH2.txt");
        System.setOut(output);
        System.out.println("=======================================");
        System.out.println("HASHTABLE: USING MURMURHASH2");
        System.out.println("=======================================");
        timeStart = System.currentTimeMillis();
        htHF.printKMerDistribution(sizeOfSubstrings);
        timeFinish = System.currentTimeMillis();
        System.out.printf("RUNNING TIME OF MURMURHASH2: %.2f ms", timeFinish-timeStart);
        //print bst
        System.out.println();
        output = new PrintStream("BST.txt");
        System.setOut(output);
        System.out.println("=======================================");
        System.out.println("BINARY SEARCH TREE");
        System.out.println("=======================================");
        timeStart = System.currentTimeMillis();
        bst.printKMerDistribution(sizeOfSubstrings);
        timeFinish = System.currentTimeMillis();
        System.out.printf("RUNNING TIME OF BST: %.2f ms", timeFinish-timeStart);

    }

}
