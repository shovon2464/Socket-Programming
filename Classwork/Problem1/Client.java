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

public class Client {
    public static void main(String[] args){
        try{
            Socket socketC = new Socket("localhost", 7777);
            InputStreamReader input = new InputStreamReader(new DataInputStream(socketC.getInputStream()));
            BufferedReader reader = new BufferedReader(input);
            
            System.out.println("Response- "+reader.readLine());
            
            socketC.close();
            
        }catch(Exception e){System.out.println(e);}
    }
}