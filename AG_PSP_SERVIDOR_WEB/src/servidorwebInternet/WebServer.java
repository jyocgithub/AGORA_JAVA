package servidorwebInternet;

import java.net.*;
public final class WebServer{
	private static final  int PORT =6789;
    public static void main(String argv[])
        throws Exception
    {
       
        System.out.println("arrancando el servidor web , escuchando en el puerto "+PORT);

        // Establish the listen socket
        ServerSocket socketEscucha = new ServerSocket(PORT);

        // Process HTTP service requests in an infinite loop
        while (true)
        {
            // Listen for a TCP connection request
            Socket connectionSocket = socketEscucha.accept();

            // Construct an object to process the HTTP request message.
            HttpCliente cliente = new HttpCliente(connectionSocket);

            // Create a new thread to process the request.
            Thread thread = new Thread(cliente);

            // Start the thread.
            thread.start();
        }
    }
}