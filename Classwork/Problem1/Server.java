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
import java.util.Date;

public class Server {

    public static void main(String[] args) {
        try {
            while(true){
                ServerSocket ss = new ServerSocket(7777);
                System.out.println("Server running at port 7777");
                Socket socket1 = ss.accept();
                System.out.println("Client Connected");

                String today = new Date().toString();

                DataOutputStream output = new DataOutputStream(socket1.getOutputStream());
                PrintWriter writer = new PrintWriter(output, true);

                writer.println(today);

                ss.close();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
