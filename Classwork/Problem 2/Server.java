/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shovon
 */
import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) {
        try {
            while(true){
                ServerSocket ss = new ServerSocket(7777);
                System.out.println("Server running at port 7777");
                Socket socket1 = ss.accept();
                System.out.println("Client Connected");

                DataOutputStream output = new DataOutputStream(socket1.getOutputStream());
                PrintWriter writer = new PrintWriter(output, true);
                
                InputStreamReader input = new InputStreamReader(new DataInputStream(socket1.getInputStream()));
                BufferedReader reader = new BufferedReader(input);
                
                while(true){
                    String client_response = reader.readLine();
                    if(client_response.equalsIgnoreCase("end game")){
                        writer.println("goodbye");
                        break;
                    }
                    writer.println(client_response);
                    
                }

                ss.close();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
