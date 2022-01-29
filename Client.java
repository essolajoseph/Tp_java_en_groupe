
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

 
public class Client extends javax.swing.JFrame {
    static  String ms;
    static Socket socket;
    static int  num;
    public Client() {
        initComponents();
    }
    public Client(Socket socket,int num){
          initComponents();
        this.socket=socket;
        this.num=num;
        new ClientMT(socket).start();
    }

public static class ClientMT extends Thread{
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
                JOptionPane.showMessageDialog(null, m);
                id.setText(m);
                new read().start(); 
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
                br.readLine();
                while(true){
                msgbox.setText(msgbox.getText().trim()+"\n"+br.readLine());   
                }
        }
        catch(Exception ex){     
        }
    }
}   

} 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        msg = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        msgbox = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        id = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Id = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        msg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msgActionPerformed(evt);
            }
        });

        msgbox.setColumns(20);
        msgbox.setRows(5);
        jScrollPane1.setViewportView(msgbox);

        jButton1.setText("Envoyer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        id.setText("....................................");

        jLabel1.setText("Message");

        jLabel2.setText("Envoyer  à :");

        Id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(msg, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(74, 74, 74))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(id)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(msg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void msgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_msgActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if(!msg.getText().equals("")){ 
           if(!Id.getText().equals("")){
        ms=msg.getText()+"-"+Id.getText();
         try{
                InputStream is=socket.getInputStream();
                InputStreamReader isr= new InputStreamReader(is);
                OutputStream os= socket.getOutputStream();
                BufferedReader br= new BufferedReader(isr);
                PrintWriter pw= new PrintWriter(os,true);
                pw.println(ms);
        }
        catch(Exception ex){     
        }
   
        msg.setText("");
       }
           else{
                JOptionPane.showMessageDialog(null,"Veillez choisir le(s) destinataire(s)!");
           }
       }
       else if(msg.getText().equals(" ")){
           
       }
       else{
           JOptionPane.showMessageDialog(null,"Veillez saisir Un Message!");
       }
    }//GEN-LAST:event_jButton1ActionPerformed
    /*
    private void msgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_msgActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if(!msg.getText().equals("")){ 
           if(!Id.getText().equals("")){
        ms=msg.getText()+"-"+Id.getText();
         try{
                InputStream is=socket.getInputStream();
                InputStreamReader isr= new InputStreamReader(is);
                OutputStream os= socket.getOutputStream();
                BufferedReader br= new BufferedReader(isr);
                PrintWriter pw= new PrintWriter(os,true);
                pw.println(ms);
        }
        catch(Exception ex){     
        }
   
        msg.setText("");
       }
           else{
                JOptionPane.showMessageDialog(null,"Veillez envoyer le msg au(x) destinataire(s)!");
           }
       }
       else if(msg.getText().equals(" ")){
           
       }
       else{
           JOptionPane.showMessageDialog(null,"Veillez saisir Un Message!");*/

    private void IdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client().setVisible(true);
            }
        });
       /* java.awt.EventQueue.invokelater(new Runnable()) {
            private void run() {
                new Client(). setVisible(true);
            }};*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextField Id;
    private static javax.swing.JLabel id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextField msg;
    private static javax.swing.JTextArea msgbox;
    // End of variables declaration//GEN-END:variables
}

