
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ESSOLA JULIEN
 */
public class ClientMT extends Thread{
   static Socket s;
   public ClientMT (Socket s){
       this.s=s;
       
   }
    public void run(){
        
        try{
                InputStream is=s.getInputStream();
                InputStreamReader isr= new InputStreamReader(is);
                OutputStream os= s.getOutputStream();
                BufferedReader br= new BufferedReader(isr);
                PrintWriter pw= new PrintWriter(os,true);
                String m;
                Scanner sc=new Scanner(System.in);
                String chaine;
                m=br.readLine();
                System.out.println(m);
                while(true){
                     System.out.println("votre message :");
                     chaine= sc.nextLine();
                     pw.println(chaine);
                     new read().start();              
                }
        }
        catch(Exception ex){     
        }
    }

 public static class read extends Thread{
    public void run(){
         try{
                InputStream is=s.getInputStream();
                InputStreamReader isr= new InputStreamReader(is);
                OutputStream os= s.getOutputStream();
                BufferedReader br= new BufferedReader(isr);
                PrintWriter pw= new PrintWriter(os,true);
                while(true){
                  System.out.println(br.readLine());
                }
        }
        catch(Exception ex){     
        }
    }
}    
        public static void main(String[] args) throws IOException {
        Socket s= new Socket("localhost",1234);
        new ClientMT(s).start();  
        
    }
}
