
package Interface;

import javax.swing.ButtonGroup;
import Classes.*;

public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        ButtonGroup grupoBotoes = new ButtonGroup();
        grupoBotoes.add(gestorRadioButton);
        grupoBotoes.add(professorRadioButton);
        grupoBotoes.add(alunoRadioButton);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        gestorRadioButton = new javax.swing.JRadioButton();
        professorRadioButton = new javax.swing.JRadioButton();
        alunoRadioButton = new javax.swing.JRadioButton();
        EntrarTP = new javax.swing.JButton();
        sairButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal");

        jPanel1.setBackground(new java.awt.Color(50, 50, 50));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Entrar como:");

        gestorRadioButton.setBackground(new java.awt.Color(50, 50, 50));
        gestorRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        gestorRadioButton.setText("Gestor");
        gestorRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestorRadioButtonActionPerformed(evt);
            }
        });

        professorRadioButton.setBackground(new java.awt.Color(50, 50, 50));
        professorRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        professorRadioButton.setText("Professor");
        professorRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                professorRadioButtonActionPerformed(evt);
            }
        });

        alunoRadioButton.setBackground(new java.awt.Color(50, 50, 50));
        alunoRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        alunoRadioButton.setText("Aluno");
        alunoRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alunoRadioButtonActionPerformed(evt);
            }
        });

        EntrarTP.setText("Entrar");
        EntrarTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntrarTPActionPerformed(evt);
            }
        });

        sairButton.setText("Sair");
        sairButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("BEM VINDO!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(sairButton)
                        .addGap(31, 31, 31)
                        .addComponent(EntrarTP))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(gestorRadioButton)
                                .addGap(18, 18, 18)
                                .addComponent(professorRadioButton)))
                        .addGap(18, 18, 18)
                        .addComponent(alunoRadioButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel2)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gestorRadioButton)
                    .addComponent(professorRadioButton)
                    .addComponent(alunoRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sairButton)
                    .addComponent(EntrarTP))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void gestorRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestorRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gestorRadioButtonActionPerformed

    private void professorRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_professorRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_professorRadioButtonActionPerformed

    private void alunoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alunoRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alunoRadioButtonActionPerformed

    private void EntrarTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntrarTPActionPerformed
        if (gestorRadioButton.isSelected()) {
            new TelaLogin().setVisible(true);
            dispose();
        } else if (professorRadioButton.isSelected()) {
            new ConsultarProfessor().setVisible(true);
            dispose();
        } else if (alunoRadioButton.isSelected()) {
             new ConsultarAlunos().setVisible(true);
            dispose();           
        } else {
            
        }    
    }//GEN-LAST:event_EntrarTPActionPerformed

    private void sairButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairButtonActionPerformed
        if(sairButton.isEnabled()){
            System.out.println("Saiu do programa");
            System.exit(0);
        }                                     
    }//GEN-LAST:event_sairButtonActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EntrarTP;
    private javax.swing.JRadioButton alunoRadioButton;
    private javax.swing.JRadioButton gestorRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton professorRadioButton;
    private javax.swing.JButton sairButton;
    // End of variables declaration//GEN-END:variables
}
