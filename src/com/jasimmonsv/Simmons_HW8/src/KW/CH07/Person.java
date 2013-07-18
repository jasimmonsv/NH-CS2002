package KW.CH07;

public class Person {

    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    /*<exercise chapter="7" section="5" type="programming" number="2">*/
    /**
     * Return true if the this Person is equal to other
     * @param other The other object
     * @return true if other is a Person and the names are the same
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (this.getClass() == other.getClass()) {
            Person otherPerson = (Person) other;
            return (firstName.equals(otherPerson.getFirstName())
                    && lastName.equals(otherPerson.getLastName()));
        } else {
            return false;
        }
    }

    /**
     * Return a hash code for this object
     * @returns a hash code for this object
     */
    @Override
    public int hashCode() {
        return lastName.hashCode() + 513 * firstName.hashCode();
    }
    /*</exercise>*/
}
