import java.io.Serializable;

/**
 * @author Arjun Harbhajanka and Shivam Bairoliya
 * @version 11/28/30
 */

public class Passenger implements Serializable {
    private String firstName;
    private String lastName;
    private int age;

    public Passenger(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        String s = Character.toUpperCase(firstName.charAt(0)) + ". " + lastName.toUpperCase() + ", " + age;
        return s;
    }


}

