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
                String response = reader.readLine();
                System.out.println(response);
                
                
                String input1 = scan.nextLine();               
                writer.println(input1);
                response = reader.readLine();
                if(response.equalsIgnoreCase("goodbye")){
                    break;
                }
                System.out.println("The result is: "+response);
            }
            socketC.close();
                
        
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}

