package sg.edu.nus.iss;

import java.io.Console;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception{

        int port = 3000;
        Socket sock = new Socket("127.0.0.1",port);
        System.out.println("Please enter fileName and fileSize");

        OutputStream os = sock.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);

        // InputStream is = sock.getInputStream();
        // ObjectInputStream ois = new ObjectInputStream(is);

        String msg = "";

        Console con = System.console();

        msg = con.readLine("> ");
        oos.writeBytes(msg);
        oos.flush();

        oos.close();
        os.close();
        sock.close();
    }
}
