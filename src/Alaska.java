import java.io.*;

/**
 * @author Arjun Harbhajanka and Shivam Bairoliya
 * @version 11/28/30
 */
public class Alaska implements Airline {

    final private static Gate GATE = new Gate("Alaska");
    final public static int MAX = 100;

    public static int getNoOfPassengers() {
        FileWriter fw = null;
        try {
            FileReader fr = new FileReader("reservations.txt");
            BufferedReader br = new BufferedReader(fr);
            StringBuffer inputBuffer = new StringBuffer();
            String line;

            while ((line = br.readLine()) != null) {
                inputBuffer.append(line);
                inputBuffer.append('\n');
            }
            String textInFile = inputBuffer.toString();
            int index = textInFile.indexOf("ALASKA");
            index += 7;
            String numberOfPassengers = textInFile.substring(index, index + 3);
            if (numberOfPassengers.charAt(1) == '/')
                numberOfPassengers = numberOfPassengers.substring(0, 1);
            else if (numberOfPassengers.charAt(2) == '/')
                numberOfPassengers = numberOfPassengers.substring(0, 2);
            int nOP = Integer.parseInt(numberOfPassengers);
            return nOP;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static Gate getGate() {
        return GATE;
    }

    public static void addPassenger(Passenger passenger) {
        FileWriter fw = null;
        try {
            FileReader fr = new FileReader("reservations.txt");
            BufferedReader br = new BufferedReader(fr);
            StringBuffer inputBuffer = new StringBuffer();
            String line;

            while ((line = br.readLine()) != null) {
                inputBuffer.append(line);
                inputBuffer.append('\n');
            }
            String textInFile = inputBuffer.toString();
            int index = textInFile.indexOf("ALASKA");
            index += 7;
            String numberOfPassengers = textInFile.substring(index, index + 3);
            if (numberOfPassengers.charAt(1) == '/')
                numberOfPassengers = numberOfPassengers.substring(0, 1);
            else if (numberOfPassengers.charAt(2) == '/')
                numberOfPassengers = numberOfPassengers.substring(0, 2);
            int nOP = Integer.parseInt(numberOfPassengers);
            nOP++;

            String toEdit = textInFile.substring(index);
            toEdit = toEdit.replaceFirst(numberOfPassengers, Integer.toString(nOP));
            int index1 = toEdit.indexOf("DELTA");
            index1 -= 1;
            toEdit = toEdit.substring(0, index1) + passenger.toString() + "\n---------------------ALASKA\n" +
                    toEdit.substring(index1);
            textInFile = textInFile.substring(0, index) + toEdit;
            FileOutputStream fileOut = new FileOutputStream("reservations.txt");
            fileOut.write(textInFile.getBytes());
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String displayPassengers() {
        FileWriter fw = null;
        try {
            FileReader fr = new FileReader("reservations.txt");
            BufferedReader br = new BufferedReader(fr);
            StringBuffer inputBuffer = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                inputBuffer.append(line);
                inputBuffer.append('\n');
            }
            String textInFile = inputBuffer.toString();
            String textFlight = textInFile.substring(0, textInFile.indexOf("DELTA") - 2);
            textFlight = textFlight.substring(textFlight.indexOf("\n") + 1);
            textFlight = textFlight.substring(textFlight.indexOf("\n") + 1);
            textFlight = textFlight.substring(textFlight.indexOf("\n") + 1);
            textFlight = textFlight.substring(textFlight.indexOf("\n") + 1);
            System.out.println(textFlight);
            String toReturn = "";
            int index;
            while (textFlight.contains("\n")) {
                toReturn = toReturn + "\n" + textFlight.substring(0, textFlight.indexOf("\n"));
                textFlight = textFlight.substring(textFlight.indexOf("\n") + 1);
                textFlight = textFlight.substring(textFlight.indexOf("\n") + 1);
            }
            return toReturn;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

//    public static void main(String[] args) {
//        System.out.println(displayPassengers());
//    }
}

