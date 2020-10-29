package application;

import model.entities.Client;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args){

        String in = "src/in-client.csv";
        String out= "src/out-client.csv";
        List<Client> clients = new ArrayList<Client>();

        try(BufferedReader br = new BufferedReader(new FileReader(in))){
            String line = br.readLine();
            while(line != null){
                String[] fields = line.split(",");
                clients.add(new Client(fields[0], fields[1]));
                line = br.readLine();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(out))) {

            for (int i = 0; i < (clients.size() - 1) ; i++){
                for(int j = i+1; j < clients.size(); j++ ){
                    String line = String.format("%s, Hashcode: %d, %s, Hashcode: %d, Equals: %s",
                            clients.get(i),
                            clients.get(i).hashCode(),
                            clients.get(j),
                            clients.get(j).hashCode(),
                            clients.get(i).equals(clients.get(j))
                    );
                    bw.write(line);
                    bw.newLine();
                }
            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
