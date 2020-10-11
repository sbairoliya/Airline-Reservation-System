import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Arjun Harbhajanka and Shivam Bairoliya
 * @version 11/28/30
 */

public class ReservationServer {

    private ServerSocket serverSocket;

    public ReservationServer() {
        try {
            this.serverSocket = new ServerSocket(0);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static void main(String[] args) throws IOException {
        ReservationServer server = new ReservationServer();
        server.serveClients();

    }

    public void serveClients() throws IOException {
        Socket clientSocket;
        Thread handlerThread;
        int clientCount = 0;
        System.out.printf("<Now serving clients on port %d...>%n", this.serverSocket.getLocalPort());

        while (true) {
            try {
                clientSocket = this.serverSocket.accept();

                handlerThread = new Thread(new ClientHandler(clientSocket));
                handlerThread.start();
            } catch (IOException e) {
                e.getMessage();
                return;
            }

        }
    }

    /**
     * @author Arjun Harbhajanka and Shivam Bairoliya
     * @version 11/28/30
     */

    class ClientHandler implements Runnable {
        private Socket socket;
        private boolean[] canBeAdded;
        Thread responseThread;

        public ClientHandler(Socket clientSocket) {
            this.socket = clientSocket;
            canBeAdded = new boolean[3];
        }

        @Override
        public void run() {
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                oos.flush();
                while (true) {
                    if (!(Alaska.getNoOfPassengers() == 100))
                        canBeAdded[0] = true;
                    if (!(Delta.getNoOfPassengers() == 200))
                        canBeAdded[1] = true;
                    if (!(Southwest.getNoOfPassengers() == 100))
                        canBeAdded[2] = true;
                    oos.writeObject(canBeAdded);
                    oos.flush();
                    Passenger passenger = null;
                    String airline = null;
                    while (passenger == null || airline == null) {
                        Object object = ois.readObject();
                        if (object instanceof Passenger)
                            passenger = (Passenger) object;
                        else if (object instanceof String)
                            airline = (String) object;
                        responseThread = new Thread(new ReservationClient.ResponseListener(passenger, airline));
                        responseThread.start();
                        responseThread.join();


                    }

                }

            } catch (IOException | ClassNotFoundException | InterruptedException e) {
                e.getMessage();
            }


        }
    }
}


