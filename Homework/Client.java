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
import java.util.Scanner;

public class Client {
    
    public static void main(String[] args){
        try{
            Socket socketC = new Socket("localhost", 7777);
            
            DataOutputStream output = new DataOutputStream(socketC.getOutputStream());
            PrintWriter writer = new PrintWriter(output, true);
            
            InputStreamReader input = new InputStreamReader (new DataInputStream(socketC.getInputStream()));
            BufferedReader reader = new BufferedReader(input);
            
            Scanner scan = new Scanner(System.in);
            
            while(true){
                System.out.println("Say something to the server");
                String input1 = scan.nextLine();
                
                writer.println(input1);
                String response = reader.readLine();
                System.out.println("Form Server the uppercase: "+ response);
                
                if(response.equalsIgnoreCase("goodbye")){
                    break;
                }
            }
            socketC.close();
                
        
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
