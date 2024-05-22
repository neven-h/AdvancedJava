
public class Person implements Comparable<Person> {

    // attributes
    private String id; // id of person
    private String lastName; // last name of person
    private String firstName; // first name of person
    private int yearOfBirth; // year of person's birth

    // variables declaration
    private final int IS_BIGGER = 1;
    private final int IS_SMALLER = -1;
    private final int IS_EQUAL = 0;

    // four arguments constructor initializes person attributes
    public Person(String id, String lastName, String firstName, int yearOfBirth) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public int compareTo(Person person) {

        // checks lexicographic order of last name of persons first
        if (this.lastName.compareTo(person.lastName) > 0)
            return IS_BIGGER;
        else if (this.lastName.compareTo(person.lastName) < 0)
            return IS_SMALLER;

        // last names of both persons are equal
        // checks lexicographic order of first name of persons
        else if (this.firstName.compareTo(person.firstName) > 0)
            return IS_BIGGER;
        else if (this.firstName.compareTo(person.firstName) < 0)
            return IS_SMALLER;

        // full names of both persons are equal lexicographically
        // checks lexicographic order of id of persons
        else {
            if (this.id.compareTo(person.id) > 0)
                return IS_BIGGER;
            else if (this.id.compareTo(person.id) < 0)
                return IS_SMALLER;
        }
        // both full names and ids are equal lexicographically
        return IS_EQUAL;
    }

    public String toString() {
        return "\nID: " + this.id + " Full Name: " + this.firstName + " " + this.lastName + " Year Of Birth: " + this.yearOfBirth;
    }
}
