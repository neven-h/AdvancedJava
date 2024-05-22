import java.util.ArrayList;
import java.util.Iterator;

public class Set<E> {

    // attributes
    private ArrayList<E> setArray; // array that stores set elements

    // variables declaration
    int arrayLength, setSize, givenSetSize;
    boolean isMemberOfSet, isMemberOfGivenSet;
    E currentElementOfArray, currentElementOfSet, currentElementOfGivenSet;
    ArrayList<E> thisSetArray, givenSetArray;

    // no-argument constructor initializes an empty set
    public Set() {
        this.setArray = new ArrayList<>();
    }

    // one argument constructor initializes a set by using an array with objects from same type
    public Set(E[] arrayOfElements) {
        this.setArray = new ArrayList<E>();

        arrayLength = arrayOfElements.length;

        for (int i = 0; i < arrayLength; i++) {
            currentElementOfArray = arrayOfElements[i];
            this.insert(currentElementOfArray);
        }
    }

    protected void union(Set<E> set) {
        givenSetArray = set.setArray;
        givenSetSize = givenSetArray.size();

        for (int i = 0; i < givenSetSize; i++) {
            currentElementOfGivenSet = givenSetArray.get(i);
            this.insert(currentElementOfGivenSet);
        }
    }

    protected void intersect(Set<E> set) {
        thisSetArray = this.setArray;
        setSize = thisSetArray.size();

        for (int i = 0; i < setSize; i++) {
            currentElementOfSet = thisSetArray.get(i);
            isMemberOfGivenSet = set.isMember(currentElementOfSet);

            if (!isMemberOfGivenSet) {
                this.delete(currentElementOfSet);
                setSize = thisSetArray.size(); // updating current size of set after element deletion
                i--; // after deletion, making sure next element of set will not be skipped
            }
        }
    }

    protected boolean isSubset(Set<E> set) {
        givenSetArray = set.setArray;
        givenSetSize = givenSetArray.size();

        for (int i = 0; i < givenSetSize; i++) {
            currentElementOfGivenSet = givenSetArray.get(i);
            isMemberOfSet = this.isMember(currentElementOfGivenSet);

            if (!isMemberOfSet)
                return false;
        }

        return true;
    }

    protected boolean isMember(E element) {
        return this.setArray.contains(element);
    }

    protected void insert(E element){
        if(!this.isMember(element))
            this.setArray.add(element);
    }

    protected void delete(E element) {
        if (this.isMember(element))
            this.setArray.remove(element);
    }

    protected Iterator<E> iterator() {
        return this.setArray.iterator();
    }

    public String toString() {
        return this.setArray.toString();
    }

}
