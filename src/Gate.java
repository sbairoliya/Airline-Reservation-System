import java.io.Serializable;
import java.util.Random;

/**
 * @author Arjun Harbhajanka and Shivam Bairolia
 * @version 11/28/30
 */
public class Gate implements Serializable {
    String terminal;
    int number;

    public Gate(String airline) {
        Random random = new Random();
        if (airline.equals("Delta")) {
            terminal = "A";
            number = random.nextInt(18) + 1;
        } else if (airline.equals("Southwest")) {
            terminal = "B";
            number = random.nextInt(18) + 1;
        } else if (airline.equals("Alaska")) {
            terminal = "C";
            number = random.nextInt(18) + 1;
        }
    }

    public String toString() {
        return (terminal + number);
    }

}
