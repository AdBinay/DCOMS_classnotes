// HelloRemote.java
// This file defines the remote interface, which specifies the methods
// that can be called remotely by a client.

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * The remote interface for the Hello service.
 * Any method intended to be called remotely must be declared here
 * and must throw RemoteException.
 */
public interface HelloRemote extends Remote {
    // Line 1: Package import for the Remote interface, which is the base for all remote objects.
    // Line 2: Package import for RemoteException, which must be declared for all remote methods.

    /**
     * Declares the method that will be executed remotely.
     *
     * @param name The name provided by the client.
     * @return A greeting string.
     * @throws RemoteException If the RMI call fails (e.g., network error).
     */
    public String sayHello(String name) throws RemoteException;
    // Line 1: Declares a public method named sayHello that accepts a String argument (the name).
    // Line 2: The method must throw RemoteException to handle remote communication failures.
}
