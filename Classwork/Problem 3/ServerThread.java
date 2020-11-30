/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shovon
 */
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class ServerThread extends Thread{
    Socket socket;
    
    ServerThread(Socket socket){
        socket = socket;
    }
    public void run(){
        
        try {
            while(true){
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                PrintWriter writer = new PrintWriter(output, true);
                
                InputStreamReader input = new InputStreamReader(new DataInputStream(socket.getInputStream()));
                BufferedReader reader = new BufferedReader(input);
                
                
                
                
                while(true){
                    String client_response = reader.readLine();
                    if(client_response.equalsIgnoreCase("end game")){
                        writer.println("goodbye");
                        break;
                    }
                    writer.println(client_response);
                    
                }
            }          
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

