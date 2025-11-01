// HelloServer.java
// This file contains the implementation of the remote interface methods
// and the main method to start the RMI server and bind the remote object
// to the RMI registry.

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Implements the HelloRemote interface and exports the remote object.
 */
public class HelloServer extends UnicastRemoteObject implements HelloRemote {
    // Line 1: Constructor for the remote object implementation.
    // Line 2: It must declare or throw RemoteException because the superclass constructor
    // Line 3: (UnicastRemoteObject) exports the object for remote calls.
    public HelloServer() throws RemoteException {
        // Line 4: Call to the superclass (UnicastRemoteObject) constructor.
        super();
    }

    /**
     * The actual implementation of the remote method.
     * @param name The name sent from the client.
     * @return The formatted greeting.
     */
    @Override
    public String sayHello(String name) throws RemoteException {
        // Line 1: Implementation of the sayHello method defined in the HelloRemote interface.
        // Line 2: It takes the 'name' from the client and returns the formatted greeting.
        return "Hello " + name + "!";
    }

    // The main method to start the RMI server.
    public static void main(String[] args) {
        // Line 1: Standard try-catch block for error handling (especially RemoteException).
        try {
            // Line 2: Creates an instance of the remote object implementation (the server).
            HelloServer obj = new HelloServer();

            // Line 3: Gets a reference to the RMI registry running on the local host and default port (1099).
            Registry registry = LocateRegistry.getRegistry();

            // Line 4: Binds the remote object instance to the registry with a unique name ("HelloService").
            // Line 5: Clients will use this name to look up the object.
            registry.bind("HelloService", obj);

            // Line 6: Prints a confirmation message to the console.
            System.out.println("Hello Server is ready and bound to the registry.");

        // Line 7: Catches any exceptions that occur during the server setup (e.g., binding, network issues).
        } catch (Exception e) {
            // Line 8: Prints the stack trace for debugging RMI errors.
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}



// 1. compile all three Java files (HelloRemote.java, HelloServer.java, and HelloClient.java).

//                     javac HelloRemote.java HelloServer.java HelloClient.java

// 2. Start the RMI Registry
//     The registry is essential for the client to look up the remote object. You must run this command in Terminal 1 and keep it running.

//                     rmiregistry

// 3. Start the RMI Server
//     Open Terminal 2, navigate to the directory where your compiled classes are located, and run the server.

//                     java HelloServer

// 4. Start the RMI Client
//     Open Terminal 3, navigate to the same directory, and run the client.

//                     java HelloClient