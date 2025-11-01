// HelloClient.java
// This file contains the client application that connects to the RMI registry,
// looks up the remote object, and calls the remote method.

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 * Client application to access the remote HelloService.
 */
public class HelloClient {
    // The main method to execute the client logic.
    public static void main(String[] args) {
        // Line 1: Standard try-catch block for RMI communication errors and I/O.
        try {
            // Line 2: Gets a reference to the RMI registry running on the default host (localhost) and port (1099).
            Registry registry = LocateRegistry.getRegistry(null);

            // Line 3: Looks up the remote object using the name bound by the server ("HelloService").
            // Line 4: The result is cast to the remote interface type (HelloRemote).
            HelloRemote remoteObj = (HelloRemote) registry.lookup("HelloService");

            // Line 5: Initializes a Scanner object to read user input from the console.
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your name to receive a greeting: ");
            // Line 6: Reads the entire line of input from the user.
            String name = scanner.nextLine();
            scanner.close();

            // Line 7: Calls the remote method 'sayHello' on the server object.
            // Line 8: The network communication happens here, and the result is returned as 'response'.
            String response = remoteObj.sayHello(name);

            // Line 9: Prints the response received from the remote server.
            System.out.println("Server Response: " + response);

        // Line 10: Catches specific RMI exceptions, such as NameNotFoundException if the service is not found.
        } catch (Exception e) {
            // Line 11: Prints the error details if the remote call or lookup fails.
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
