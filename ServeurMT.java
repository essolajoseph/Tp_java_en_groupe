
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServeurMT extends Thread{
    int nbClients;
    private List<Socket>clientsConnectes=new ArrayList<>();
    public void run() {
        try {
            try ( ServerSocket ss = new ServerSocket(1234)) {
                while (true) {
                    Socket s = ss.accept();
                    clientsConnectes.add(s);
                    ++nbClients;
                    new Conversation(s, nbClients).start();
                }
            }
        } catch (Exception e)    {
            e.printStackTrace();
        }
    }
    public void broadCast(String Message) throws IOException{
        for(Socket s:clientsConnectes){
            PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
            pw.println(Message);
        }
    }
    class  Conversation extends  Thread{
        private Socket s;
        private int numClients;
        public  Conversation(Socket s, int numClients){
            super();
            this.s= s;
            this.numClients=numClients;
        }
        public void run(){
            try {
                InputStream is=s.getInputStream();
                InputStreamReader isr= new InputStreamReader(is);
                OutputStream os= s.getOutputStream();
                BufferedReader br= new BufferedReader(isr);
                PrintWriter pw= new PrintWriter(os,true);
                String Ip= s.getRemoteSocketAddress().toString();
                System.out.println("connexion du client numero "+numClients+" iP"+Ip);
                pw.println(" vous etes le client numero "+numClients);
                while (true){
                    String req;
                    while((req=br.readLine())!=null) {
                      System.out.println(Ip+"  a envoyé "+req);
                      broadCast(req);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new ServeurMT().start();
        
    }
}
