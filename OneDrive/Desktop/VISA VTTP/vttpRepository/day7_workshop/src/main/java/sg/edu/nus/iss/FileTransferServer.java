package sg.edu.nus.iss;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class FileTransferServer {
    
    public static void main (String[] args) throws Exception{

        ServerSocket server = new ServerSocket(8000);

        System.out.println("Starting file transfer server on port 8000");

        Socket client = server.accept();

        try{
            InputStream is = client.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);

            //receive file metadata
            String fileName = dis.readUTF();
            long fileSize = dis.readLong();

            System.out.println("fileName: "+fileName + " fileSize: "+fileSize);
            
            byte[] buff = new byte[4*1024];
            long totalReceived = 0;
            int size = 0; 
            OutputStream os = new FileOutputStream(fileName + (new Date().toString()));
            BufferedOutputStream bos = new BufferedOutputStream(os);
            
            while((size=dis.read(buff))>0){
                bos.write(buff,0,size);
                totalReceived += size;
                System.out.println("total bytes received: "+ totalReceived);
            }

            System.out.println("Final total bytes received: "+ totalReceived);
            bos.flush();
            bos.close();


        }finally{
            client.close();
        }
        
        server.close();

    }

}
