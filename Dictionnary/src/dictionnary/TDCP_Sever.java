
package dictionnary;


public class TDCP_Sever extends javax.swing.JFrame {

    /**
     * Creates new form TDCP_Sever
     */
    public TDCP_Sever() {
        initComponents();
    }
 boolean mTurmOn=false;
 tcp_SeverThread threadServer;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnOnOff = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaLog = new javax.swing.JTextArea();
        btnOff = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnOnOff.setText("Bật  Server");
        btnOnOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOnOffActionPerformed(evt);
            }
        });

        txaLog.setColumns(20);
        txaLog.setRows(5);
        jScrollPane1.setViewportView(txaLog);

        btnOff.setText("Tắt Server");
        btnOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOffActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnOnOff)
                .addGap(72, 72, 72)
                .addComponent(btnOff)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOnOff, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOff, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOnOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOnOffActionPerformed
        // TODO add your handling code here:
        
       
        threadServer=new tcp_SeverThread(txaLog);
        threadServer.start();
        mTurmOn=true;
      
        
        
    }//GEN-LAST:event_btnOnOffActionPerformed

    private void btnOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOffActionPerformed
         threadServer.StopServer();
            mTurmOn=false;
            btnOnOff.setText("Tắt Server");
            txaLog.append("\n Đã tắt Server");
    }//GEN-LAST:event_btnOffActionPerformed

  
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TDCP_Sever().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOff;
    private javax.swing.JButton btnOnOff;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txaLog;
    // End of variables declaration//GEN-END:variables
}
