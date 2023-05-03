package sg.edu.nus.iss;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server 
{
    public static void main( String[] args )throws Exception{
       // set port number
        int port = 3000;

        //if specified other port number in argument
        if (args.length >0){
            port = Integer.parseInt(args[0]); 
       }

       System.out.println("Starting server on port number "+ port);

       //Create server to listen on port
       ServerSocket server = new ServerSocket(port);
       
       boolean exit = false;

       while (!exit){
        Socket sock = server.accept();
        System.out.println("\nGot a connection: "+sock);
        
        InputStream is = sock.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(is);
        byte[] buffer =bis.readAllBytes();
        String fileInfo = new String (buffer);
        System.out.println(">>> From client: " + fileInfo);


        System.out.println("Closing connection and exit");
        sock.close();
        server.close();
        System.exit(0);
        }
    }
}
