/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.banco;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialPalenightIJTheme;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class frmBilletera extends javax.swing.JFrame {

    /**
     * Creates new form frmBilletera
     */
    String[] headboard = {"ID", "Type", "Date", "Amount"};

    DefaultTableModel model = new DefaultTableModel(headboard, 0);

    double startingAmount = 100;

    public frmBilletera() {
        initComponents();
        FlatMaterialPalenightIJTheme.setup();
        this.setTitle("WELCOME TO THE SYSTEM");

        tblData.setModel(model);
        txtAccumulated.setText("$/." + startingAmount + "");
        txtFixedAmount.setText("$/." + 100 + "");
        hideColumns();
    }

    public boolean validateAmount() {
        return txtFixedAmount.getText().trim().isEmpty() || Integer.parseInt(txtFixedAmount.getText()) <= 0;
    }

    public void registerExpense(String type) {
        double amount;
        if (validateAmount()) {
            JOptionPane.showMessageDialog(rootPane, "Please enter the amount");
        } else {
            amount = Integer.parseInt(txtFixedAmount.getText());
            if (type.equalsIgnoreCase("Buys")) {
                if (amount > startingAmount) {
                    JOptionPane.showMessageDialog(rootPane, "The amount must be less than $/." + startingAmount);
                    return;
                } else {
                    startingAmount -= amount;
                    int id = randomid();
                    String buys = type;
                    String date = getDate();

                    //We create an object of the expense class
                    Banco myExpense = new Banco(id, buys, date, amount);

                    //We create an array with the attributes of the gasro class
                    String[] attributes = {"ID", "TYPE", "DATE", "AMOUNT"};
                    Object[] row = new Object[attributes.length];

                    for (int i = 0; i < attributes.length; i++) {
                        //a break statement for each attribute
                        switch (attributes[i]) {
                            case "ID":
                                row[i] = myExpense.getId();
                                break;
                            case "TYPE":
                                row[i] = myExpense.getType();
                                break;
                            case "DATE":
                                row[i] = myExpense.getDate();
                                break;
                            case "AMOUNT":
                                row[i] = myExpense.getAmount();
                                break;
                        }
                    }

                    //we add the row to the model
                    model.addRow(row);
                    //we clear the text field of the amount entry  txtMonto.setText("");
                    txtFixedAmount.requestFocus();
                }
            } else {
                startingAmount += amount;
                int id = randomid();
                String buys = type;
                String date = getDate();

                //We create an object of the expense class
                Banco myExpense = new Banco(id, buys, date, amount);

                //We create an array with the attributes of the expense class
                String[] attributes = {"ID", "TYPE", "DATE", "AMOUNT"};
                Object[] row = new Object[attributes.length];

                for (int i = 0; i < attributes.length; i++) {
                    //a break statement for each attribute
                    switch (attributes[i]) {
                        case "ID":
                            row[i] = myExpense.getId();
                            break;
                        case "TYPE":
                            row[i] = myExpense.getType();
                            break;
                        case "DATE":
                            row[i] = myExpense.getDate();
                            break;
                        case "AMOUNT":
                            row[i] = myExpense.getAmount();
                            break;
                    }
                }

                model.addRow(row);

                txtFixedAmount.setText("");
                txtFixedAmount.requestFocus();
            }
        }
        txtAccumulated.setText("$/." + startingAmount + "");
    }

    //method to generate the random id
    public int randomid() {
        int valarGiven = (int) Math.floor(Math.random() * 1000 + 1);
        return valarGiven;
    }

    //method to obtain the date
    public String getDate() {
        Date date = new Date();

        //let's format the date
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS a");

        return formatDate.format(date);
    }

    //The column to hide is the one that contains the Id
    private void hideColumns() {
        tblData.getColumnModel().getColumn(0).setMaxWidth(40);
        tblData.getColumnModel().getColumn(0).setMinWidth(40);
        tblData.getColumnModel().getColumn(0).setPreferredWidth(40);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Purchase = new javax.swing.JButton();
        Sale = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtAccumulated = new javax.swing.JTextField();
        txtFixedAmount = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Mi billetera");

        Purchase.setText("Purchase ");
        Purchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PurchaseActionPerformed(evt);
            }
        });

        Sale.setText("Sale ");
        Sale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaleActionPerformed(evt);
            }
        });

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Type", "Date", "Amount"
            }
        ));
        jScrollPane1.setViewportView(tblData);

        jLabel2.setText("Monto total");

        txtFixedAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFixedAmountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Purchase)
                .addGap(86, 86, 86)
                .addComponent(Sale)
                .addGap(205, 205, 205))
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFixedAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(95, 95, 95)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAccumulated, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAccumulated, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(txtFixedAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Sale)
                    .addComponent(Purchase))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PurchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PurchaseActionPerformed
        registerExpense("Buys");
    }//GEN-LAST:event_PurchaseActionPerformed

    private void SaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaleActionPerformed
        registerExpense("Sale");
    }//GEN-LAST:event_SaleActionPerformed

    private void txtFixedAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFixedAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFixedAmountActionPerformed

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
            java.util.logging.Logger.getLogger(frmBilletera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmBilletera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmBilletera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmBilletera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmBilletera().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Purchase;
    private javax.swing.JButton Sale;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtAccumulated;
    private javax.swing.JTextField txtFixedAmount;
    // End of variables declaration//GEN-END:variables
}
