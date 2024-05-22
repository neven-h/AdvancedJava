import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        System.out.println("\nBeginning of Section B of Question 1\n");
        IntegerSetsProgram();
        System.out.println("\nEnd of Section B of Question 1");

        System.out.println("\nBeginning of Section C of Question 1\n");
        PersonSetsProgram();
        System.out.println("\nEnd of Section C of Question 1");
    }

    // preforms instructions of section C of question 1
    public static void IntegerSetsProgram() {

        Scanner scanner = new Scanner(System.in);
        int number;
        // creates three arrays with 10 objects each in order to construct new sets
        Integer[] firstArray = new Integer[10];
        Integer[] secondArray = new Integer[10];
        Integer[] thirdArray = new Integer[10];
        Integer[] fourthArray = new Integer[2];

        // initialize arrays with 10 random values in the range of 0 to 100
        fillArrayRandomly(firstArray);
        fillArrayRandomly(secondArray);
        fillArrayRandomly(thirdArray);

        // constructs three sets from Integer types, each containing 10 random values in the range of 0 to 100
        Set<Integer> firstSet = new Set<Integer>(firstArray);
        Set<Integer> secondSet = new Set<Integer>(secondArray);
        Set<Integer> thirdSet = new Set<Integer>(thirdArray);

        // presenting content of created sets
        System.out.println("Set A: " + firstSet);
        System.out.println("Set B: " + secondSet);
        System.out.println("Set C: " + thirdSet);

        // presenting result of union of first and second sets
        firstSet.union(secondSet);
        System.out.println("\nThe union of two sets A and B (AUB): " + firstSet);

        // presenting result of intersection of first and second union set and third set (AUB)∩C
        firstSet.intersect(thirdSet);
        System.out.println("\nThe intersection of two sets A and C (A∩C): " + firstSet);

        getSetFromUser(fourthArray); // gets two numbers from user and inserts them to the fourth array
        Set<Integer> fourthSet = new Set<Integer>(fourthArray); // constructs set from array of integers

        // presenting content of set from input
        System.out.println("\nSet D: " + fourthSet);

        // presenting result of check if set from input (fourth set) is a subset of each set A,B,C
        System.out.println("Set D is a subset of set A: " + firstSet.isSubset(fourthSet));
        System.out.println("Set D is a subset of set B: " + secondSet.isSubset(fourthSet));
        System.out.println("Set D is a subset of set C: " + thirdSet.isSubset(fourthSet));

        // asks for a number from user
        System.out.println("\nPlease enter a number");
        number = scanner.nextInt();

        // presenting check if received number from input is in set A
        System.out.println("\nSet A contains the element " + number + " : " + firstSet.isMember(number));

        // inserts number to set B
        secondSet.insert(number);
        System.out.println("Set B after insertion of element " + number + " : " + secondSet);

        // deletes number from set C
        thirdSet.delete(number);
        System.out.println("Set C after deletion of element " + number + " : " + thirdSet);
    }

    // fills array of integers with 10 distinct random numbers in the range of 0 to 100
    private static void fillArrayRandomly(Integer[] array) {

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int randomNumber;
        int counter = 0;

        while (counter < 10) {
            randomNumber = (int) (Math.random() * 100); // fills Integer array with random values in the range of 0 to 100
            // checks that each new number inserted to arraylist is a unique number
            while (arrayList.contains(randomNumber)) {
                randomNumber = (int) (Math.random() * 100);
            }
            arrayList.add(randomNumber);
            counter++;
        }

        // converts the following arraylist to an array
        array = arrayList.toArray(array);
    }

    // gets two numbers from user and insert them to an array of Integers. Notifies if an error has occurred in the process
    private static void getSetFromUser(Integer[] array) {
        Scanner input = new Scanner(System.in);
        System.out.println("\nPlease enter two integers in order to create set");
        for (int i = 0 ; i < 2 ; i++) {
            if (input.hasNextInt())
                array[i] = input.nextInt();
            else
                System.out.println("Error: You did not insert two integers");
        }
    }

    // preforms instructions of section C of question 1
    public static void PersonSetsProgram() {

        // creates seven new Persons, last two are for testing the code
        Person firstPerson = new Person("012", "Tariff", "Matan", 1990);
        Person secondPerson = new Person("555", "Zino", "Itzik", 1998);
        Person thirdPerson = new Person("666", "Malka", "Zion", 1999);
        Person fourthPerson = new Person("888", "Suissa", "Kobi", 1982);
        Person fifthPerson = new Person("001", "Hetsroni", "Amir", 1968);

        // additional persons for tests
        Person sixthPerson = new Person("100", "Hetsroni", "Amir", 1968); // tests id comparison for different persons with identical full names
        Person seventhPerson = new Person("100", "Hetsroni", "Amir", 1968); // tests object duplication in set for identical persons

        // creates an array with 7 objects in order to construct new set
        Person[] persons = {firstPerson, secondPerson, thirdPerson, fourthPerson, fifthPerson, sixthPerson, seventhPerson};
        checkForEqualPersons(persons); // checks for duplications in Array of persons

        Set<Person> setOfPersons = new Set<Person>(persons); // constructs new set of persons from elements of array
        Minimum minimalPerson = new Minimum();

        // presenting content of created set
        System.out.println("Persons Set:\n" + setOfPersons);

        // presenting result of check for minimal person in set
        System.out.println("\nThe minimal member in the set of persons is: " + minimalPerson.Minimum(setOfPersons));
    }

    // checks for duplication in given array of Persons. Indicates as equal if identical persons have been found.
    private static void checkForEqualPersons(Person[] persons) {
        Person newPerson, currentPerson;
        for (int i = 0; i < persons.length; i++) {
            newPerson = persons[i];
            // checks for identical person in previous elements of array
            for (int j = 0; j < i; j++) {
                currentPerson = persons[j];
                if (newPerson.compareTo(currentPerson) == 0)
                    persons[i] = persons[j];
            }
        }
    }
}


