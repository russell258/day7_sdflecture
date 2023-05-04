package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;  

public class App {
    public static void main( String[] args ) throws NumberFormatException, IOException{
        String csvFile = "";
        if (args.length>0){
            csvFile = args[0];
        }

        //parsing a CSV file into Scanner class constructor  
        Scanner scan = new Scanner(new File(csvFile));
        scan.useDelimiter(",");

        String lines = "";

        File file = new File(csvFile);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        double d = 0.0;

        List<Store> stores = new ArrayList<>(); 


        //use readLine once first to remove first row
        lines = br.readLine();
        while ((lines=br.readLine())!=null){
            String line[] = lines.split(",");
  
            d = Double.parseDouble(line[2]);
            
            if (!Double.isNaN(d) && d <= 5.0){
                Store store = new Store(line[0],line[1],d);
                stores.add(store);
            }
        }
        // check all are the same size
        System.out.println(stores.size());

        // System.out.println(rating);
        br.close();

        int i = 1;
        HashMap<Integer, Store> map = new HashMap<Integer, Store>();
        for (Store num: stores){
            map.put(i, num);
            i++;
        }
        
        for (Map.Entry<Integer,Store> m:map.entrySet()){
            System.out.println(m.getKey()+" "+ m.getValue());
        }

    }
}
