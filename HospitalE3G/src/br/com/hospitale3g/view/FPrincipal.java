package br.com.hospitale3g.view;

import java.awt.Dialog;

public class FPrincipal extends javax.swing.JFrame {

    public FPrincipal() {
        this.initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(FPrincipal.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPrincipal = new javax.swing.JPanel();
        jbtPessoa = new javax.swing.JButton();
        jbtUsuario = new javax.swing.JButton();
        jbtMedico = new javax.swing.JButton();
        jbtEnfermeiro = new javax.swing.JButton();
        jbtSecretario = new javax.swing.JButton();
        jbtPaciente = new javax.swing.JButton();
        jbtSair = new javax.swing.JButton();
        jbtAtendimento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hospital E3G");

        jpPrincipal.setBackground(new java.awt.Color(204, 204, 255));

        jbtPessoa.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jbtPessoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hospitale3g/icons/pessoa.png"))); // NOI18N
        jbtPessoa.setText("Pessoas");
        jbtPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtPessoaActionPerformed(evt);
            }
        });

        jbtUsuario.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jbtUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hospitale3g/icons/usuario.png"))); // NOI18N
        jbtUsuario.setText("Usuários");
        jbtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtUsuarioActionPerformed(evt);
            }
        });

        jbtMedico.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jbtMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hospitale3g/icons/medico.png"))); // NOI18N
        jbtMedico.setText("Médicos");
        jbtMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtMedicoActionPerformed(evt);
            }
        });

        jbtEnfermeiro.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jbtEnfermeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hospitale3g/icons/enfermeiro.png"))); // NOI18N
        jbtEnfermeiro.setText("Enfermeiros");
        jbtEnfermeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtEnfermeiroActionPerformed(evt);
            }
        });

        jbtSecretario.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jbtSecretario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hospitale3g/icons/secretario.png"))); // NOI18N
        jbtSecretario.setText("Secretários");
        jbtSecretario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSecretarioActionPerformed(evt);
            }
        });

        jbtPaciente.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jbtPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hospitale3g/icons/paciente.png"))); // NOI18N
        jbtPaciente.setText("Pacientes");
        jbtPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtPacienteActionPerformed(evt);
            }
        });

        jbtSair.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jbtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hospitale3g/icons/sair.png"))); // NOI18N
        jbtSair.setText("Sair");
        jbtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSairActionPerformed(evt);
            }
        });

        jbtAtendimento.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jbtAtendimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hospitale3g/icons/atendimento.png"))); // NOI18N
        jbtAtendimento.setText("Atendimentos");
        jbtAtendimento.setEnabled(false);
        jbtAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAtendimentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtMedico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtPessoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtEnfermeiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtSecretario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtSair)
                    .addComponent(jbtAtendimento))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtPessoa)
                    .addComponent(jbtEnfermeiro)
                    .addComponent(jbtAtendimento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtUsuario)
                    .addComponent(jbtSecretario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtMedico)
                    .addComponent(jbtPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtPessoaActionPerformed
        DCPessoa cPessoa = new DCPessoa(this, true);
        cPessoa.setVisible(true);
    }//GEN-LAST:event_jbtPessoaActionPerformed

    private void jbtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtUsuarioActionPerformed
        DCUsuario cUsuario = new DCUsuario(this, true);
        cUsuario.setVisible(true);
    }//GEN-LAST:event_jbtUsuarioActionPerformed

    private void jbtMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtMedicoActionPerformed
        DCMedico cMedico = new DCMedico(this, true);
        cMedico.setVisible(true);
    }//GEN-LAST:event_jbtMedicoActionPerformed

    private void jbtEnfermeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtEnfermeiroActionPerformed
        DCEnfermeiro cEnfermeiro = new DCEnfermeiro(this, true);
        cEnfermeiro.setVisible(true);
    }//GEN-LAST:event_jbtEnfermeiroActionPerformed

    private void jbtSecretarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSecretarioActionPerformed
        DCSecretario cSecretario = new DCSecretario(this, true);
        cSecretario.setVisible(true);
    }//GEN-LAST:event_jbtSecretarioActionPerformed

    private void jbtPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtPacienteActionPerformed
        DCPaciente cPaciente = new DCPaciente(this, true);
        cPaciente.setVisible(true);
    }//GEN-LAST:event_jbtPacienteActionPerformed

    private void jbtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSairActionPerformed
        this.sair();
    }//GEN-LAST:event_jbtSairActionPerformed

    private void jbtAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAtendimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtAtendimentoActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(FPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtAtendimento;
    private javax.swing.JButton jbtEnfermeiro;
    private javax.swing.JButton jbtMedico;
    private javax.swing.JButton jbtPaciente;
    private javax.swing.JButton jbtPessoa;
    private javax.swing.JButton jbtSair;
    private javax.swing.JButton jbtSecretario;
    private javax.swing.JButton jbtUsuario;
    private javax.swing.JPanel jpPrincipal;
    // End of variables declaration//GEN-END:variables

    public void sair() {
        this.dispose();
    }
}
