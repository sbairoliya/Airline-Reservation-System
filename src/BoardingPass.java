/**
 * @author Arjun Harbhajanka and Shivam Bairolia
 * @version 11/28/30
 */
public class BoardingPass {
    Passenger passenger;
    String airline;
    Gate gate;

    public BoardingPass(Passenger passenger, String airline, Gate gate) {
        this.passenger = passenger;
        this.airline = airline;
        this.gate = gate;
    }

    public String toString() {
        String x = "<html>------------------------" +
                "-------------<br/>Boarding pass for flight 18000 WITH " +
                "" + airline +
                " Airlines.<br/>PASSENGER FIRST NAME : " +
                passenger.getFirstName() + "<br/>PASSENGER LAST NAME : " +
                passenger.getLastName() + "<br/>PASSENGER AGE : " +
                passenger.getAge() + "<br/>You can now begin boarding " +
                "at gate " + gate.toString() + "<br/>---------------------" +
                "----------------<br/></html>";
        return x;
    }

}
