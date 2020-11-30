/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

/**
 *
 * @author shovon
 */

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String [] args){
        try{
            while(true){
                ServerSocket ss = new ServerSocket(7777);
                System.out.println("Server is running at port 7777");
                Socket socket1 = ss.accept();
                System.out.println("Client Connected");
                
                
                DataOutputStream output = new DataOutputStream(socket1.getOutputStream());
                PrintWriter writer = new PrintWriter(output, true);
                
                InputStreamReader input = new InputStreamReader (new DataInputStream(socket1.getInputStream()));
                BufferedReader reader = new BufferedReader(input);
                
                
                
                while(true){
                    writer.println("For add press 1, For subtract press 2, For multiply press 3 then give the operands separated by the space");
                    String client_response = reader.readLine();
                    
                    String [] operands = client_response.split(" ");
                    
                    String operation = operands[0];
                    int operand1 = Integer.parseInt(operands[1]);
                    int operand2 = Integer.parseInt(operands[2]);
                    
                    int client_responseI;
                    
                    if(operation.equalsIgnoreCase("1")){
                        client_responseI = operand1+operand2;
                        client_response =String.valueOf(client_responseI);
                    }
                    else if(operation.equalsIgnoreCase("2")){
                        client_responseI = operand1-operand2;
                        client_response =String.valueOf(client_responseI);
                    }
                    else if(operation.equalsIgnoreCase("3")){
                        client_responseI = operand1*operand2;
                        client_response =String.valueOf(client_responseI);
                    }
                    else if(operation.equalsIgnoreCase("end game")){
                        writer.println("goodbye");
                        break;
                    }
                    writer.println(client_response);
                }
                ss.close();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}

