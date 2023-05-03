package sg.edu.nus.iss;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    
    public static void main(String[] args) throws Exception{

        int port = 3000;
        if (args.length>0){
            port = Integer.parseInt(args[0]);
        }

        System.out.println("Starting server on port " + port);

        //create a server to listen on port
        ServerSocket server = new ServerSocket(port);
        
        Socket sock = server.accept();

        System.out.println("Got a connection: "+ sock);

        InputStream is = sock.getInputStream();
        int size = 0;
        byte[] buffer = new byte[1024];

        while ((size = is.read(buffer))>0){
            String msg = new String(buffer);
            System.out.println(">>> from client: " + msg);
        }

        Thread.sleep(30*1000);

        System.out.println("Closing connection and exit");
        sock.close();
        server.close();
    }

}
