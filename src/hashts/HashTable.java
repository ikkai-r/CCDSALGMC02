package hashts;

public interface HashTable {

    public void addElement(String keySubstring);
    public boolean searchElement(String keySubString);
    public boolean needCollisionResolution(String keySubstring);
    public void collisionResolution(String keySubstring);
    public void updateElement(String keySubString);
    public void printKMerDistribution();



}
