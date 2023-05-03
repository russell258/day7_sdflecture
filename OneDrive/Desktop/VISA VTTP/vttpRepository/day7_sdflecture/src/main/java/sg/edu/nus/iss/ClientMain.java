package sg.edu.nus.iss;

import java.io.OutputStream;
import java.net.Socket;

public class ClientMain {
    
    public static void main(String[] args) throws Exception{

        int port = 3000;
        if (args.length>0){
            port = Integer.parseInt(args[0]);
        }

        Socket sock = new Socket("127.0.0.1",port);

        OutputStream os = sock.getOutputStream();
        os.write("hello, world\n".getBytes());
        os.flush();

        os.close();
        sock.close();
    }


}
