/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package calculator;

/**
 *
 * @author Admin
 */
public class calculatorForm extends javax.swing.JFrame {

    String operadl = "";
    String operator = " ";
    Boolean isEqualPress = false;

    /**
     * Creates new form calculatorForm
     */
    public calculatorForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnNumber1 = new javax.swing.JButton();
        btnNumber2 = new javax.swing.JButton();
        btnNumber3 = new javax.swing.JButton();
        btnChia = new javax.swing.JButton();
        btnSqrt = new javax.swing.JButton();
        btnNumber4 = new javax.swing.JButton();
        btnNumber5 = new javax.swing.JButton();
        btnNumber6 = new javax.swing.JButton();
        btnNhan = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        btnNumber7 = new javax.swing.JButton();
        btnNumber8 = new javax.swing.JButton();
        btnNumber9 = new javax.swing.JButton();
        btnCong = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        btnNumber0 = new javax.swing.JButton();
        btnPlus = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnTru = new javax.swing.JButton();
        btnEqual = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtResult = new javax.swing.JTextField();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("CASIO");

        jPanel1.setLayout(new java.awt.GridLayout(4, 5, 5, 5));

        btnNumber1.setText("1");
        btnNumber1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumber1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnNumber1);

        btnNumber2.setText("2");
        btnNumber2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumber2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnNumber2);

        btnNumber3.setText("3");
        btnNumber3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumber3ActionPerformed(evt);
            }
        });
        jPanel1.add(btnNumber3);

        btnChia.setText("/");
        btnChia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCongActionPerformed(evt);
            }
        });
        jPanel1.add(btnChia);

        btnSqrt.setText("sqrt");
        btnSqrt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSqrtActionPerformed(evt);
            }
        });
        jPanel1.add(btnSqrt);

        btnNumber4.setText("4");
        btnNumber4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumber4ActionPerformed(evt);
            }
        });
        jPanel1.add(btnNumber4);

        btnNumber5.setText("5");
        btnNumber5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumber5ActionPerformed(evt);
            }
        });
        jPanel1.add(btnNumber5);

        btnNumber6.setText("6");
        btnNumber6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumber6ActionPerformed(evt);
            }
        });
        jPanel1.add(btnNumber6);

        btnNhan.setText("*");
        btnNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCongActionPerformed(evt);
            }
        });
        jPanel1.add(btnNhan);

        jButton20.setText("%");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSqrtActionPerformed(evt);
            }
        });
        jPanel1.add(jButton20);

        btnNumber7.setText("7");
        btnNumber7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumber7ActionPerformed(evt);
            }
        });
        jPanel1.add(btnNumber7);

        btnNumber8.setText("8");
        btnNumber8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumber8ActionPerformed(evt);
            }
        });
        jPanel1.add(btnNumber8);

        btnNumber9.setText("9");
        btnNumber9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumber9ActionPerformed(evt);
            }
        });
        jPanel1.add(btnNumber9);

        btnCong.setText("+");
        btnCong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCongActionPerformed(evt);
            }
        });
        jPanel1.add(btnCong);

        jButton7.setText("1/X");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSqrtActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);

        btnNumber0.setText("0");
        btnNumber0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumber4ActionPerformed(evt);
            }
        });
        jPanel1.add(btnNumber0);

        btnPlus.setText("+/-");
        btnPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlusActionPerformed(evt);
            }
        });
        jPanel1.add(btnPlus);

        btnClear.setText("C");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel1.add(btnClear);

        btnTru.setText("-");
        btnTru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCongActionPerformed(evt);
            }
        });
        jPanel1.add(btnTru);

        btnEqual.setText("=");
        btnEqual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEqualActionPerformed(evt);
            }
        });
        jPanel1.add(btnEqual);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtResult.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtResult.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtResult, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtResult, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNumber1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNumber1ActionPerformed
        if (isEqualPress) {
            isEqualPress = false;
            txtResult.setText("");
        }
        String cmd = evt.getActionCommand();
        txtResult.setText(txtResult.getText() + cmd);
    }//GEN-LAST:event_btnNumber1ActionPerformed

    private void btnNumber2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNumber2ActionPerformed
        if (isEqualPress) {
            isEqualPress = false;
            txtResult.setText("");
        }
        String cmd = evt.getActionCommand();
        txtResult.setText(txtResult.getText() + cmd);
    }//GEN-LAST:event_btnNumber2ActionPerformed

    private void btnNumber3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNumber3ActionPerformed
        if (isEqualPress) {
            isEqualPress = false;
            txtResult.setText("");
        }
        String cmd = evt.getActionCommand();
        txtResult.setText(txtResult.getText() + cmd);
    }//GEN-LAST:event_btnNumber3ActionPerformed

    private void btnNumber4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNumber4ActionPerformed
        if (isEqualPress) {
            isEqualPress = false;
            txtResult.setText("");
        }
        String cmd = evt.getActionCommand();
        txtResult.setText(txtResult.getText() + cmd);
    }//GEN-LAST:event_btnNumber4ActionPerformed

    private void btnNumber5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNumber5ActionPerformed
        if (isEqualPress) {
            isEqualPress = false;
            txtResult.setText("");
        }
        String cmd = evt.getActionCommand();
        txtResult.setText(txtResult.getText() + cmd);
    }//GEN-LAST:event_btnNumber5ActionPerformed

    private void btnNumber6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNumber6ActionPerformed
        if (isEqualPress) {
            isEqualPress = false;
            txtResult.setText("");
        }
        String cmd = evt.getActionCommand();
        txtResult.setText(txtResult.getText() + cmd);
    }//GEN-LAST:event_btnNumber6ActionPerformed

    private void btnNumber7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNumber7ActionPerformed
        if (isEqualPress) {
            isEqualPress = false;
            txtResult.setText("");
        }
        String cmd = evt.getActionCommand();
        txtResult.setText(txtResult.getText() + cmd);
    }//GEN-LAST:event_btnNumber7ActionPerformed

    private void btnNumber8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNumber8ActionPerformed
        if (isEqualPress) {
            isEqualPress = false;
            txtResult.setText("");
        }
        String cmd = evt.getActionCommand();
        txtResult.setText(txtResult.getText() + cmd);
    }//GEN-LAST:event_btnNumber8ActionPerformed

    private void btnNumber9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNumber9ActionPerformed
        if (isEqualPress) {
            isEqualPress = false;
            txtResult.setText("");
        }
        String cmd = evt.getActionCommand();
        txtResult.setText(txtResult.getText() + cmd);
    }//GEN-LAST:event_btnNumber9ActionPerformed

    private void btnPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlusActionPerformed

        try {
            double value = Double.parseDouble(txtResult.getText());
            txtResult.setText("" + value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnPlusActionPerformed

    private void btnCongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCongActionPerformed
        String cmd = evt.getActionCommand();
        operator = cmd;
        operadl = txtResult.getText();
        txtResult.setText("");
    }//GEN-LAST:event_btnCongActionPerformed

    private void btnEqualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEqualActionPerformed
        if (txtResult.getText().equals("") || operadl.equals("")) {
            return;
        }
        try {
            double value1 = Double.parseDouble(operadl);
            double value2 = Double.parseDouble(txtResult.getText());
            double result = 0;

            if (operator.equals("+")) {
                result = value1 + value2;
            } else if (operator.equals("-")) {
                result = value1 - value2;
            } else if (operator.equals("*")) {
                result = value1 * value2;
            } else if (operator.equals("/")) {
                result = value1 / value2;
            }

            txtResult.setText("" + result);
            isEqualPress = true;
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnEqualActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtResult.setText("");
        operadl = "";
        operator = "";
        isEqualPress = false;
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSqrtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSqrtActionPerformed
        String cmd = evt.getActionCommand();
        if (txtResult.getText() == "") {
            return;
        }
        try {
            double value3 = Double.parseDouble(txtResult.getText());
            if (cmd.equals("sqrt")) {
                value3 = Math.sqrt(value3);
            } else if (cmd.equals("%")) {
                value3 = value3 * 100;
            }

            if (cmd.equals("1/X")) {
                value3 = 1/value3;
            }
            txtResult.setText(""+value3);
            isEqualPress=true;
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnSqrtActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(calculatorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(calculatorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(calculatorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(calculatorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new calculatorForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChia;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnCong;
    private javax.swing.JButton btnEqual;
    private javax.swing.JButton btnNhan;
    private javax.swing.JButton btnNumber0;
    private javax.swing.JButton btnNumber1;
    private javax.swing.JButton btnNumber2;
    private javax.swing.JButton btnNumber3;
    private javax.swing.JButton btnNumber4;
    private javax.swing.JButton btnNumber5;
    private javax.swing.JButton btnNumber6;
    private javax.swing.JButton btnNumber7;
    private javax.swing.JButton btnNumber8;
    private javax.swing.JButton btnNumber9;
    private javax.swing.JButton btnPlus;
    private javax.swing.JButton btnSqrt;
    private javax.swing.JButton btnTru;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField txtResult;
    // End of variables declaration//GEN-END:variables
}
