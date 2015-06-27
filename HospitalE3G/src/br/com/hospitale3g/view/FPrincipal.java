package br.com.hospitale3g.view;

import br.com.hospitale3g.controller.UsuarioController;
import br.com.hospitale3g.model.Usuario;
import java.awt.Image;
import javax.swing.ImageIcon;

public class FPrincipal extends javax.swing.JFrame {

    Usuario usuario;

    public FPrincipal() {
        this.initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(FPrincipal.MAXIMIZED_BOTH);
        this.jlbUsuario.setText("");
        this.jlbPrivilegio.setText("");

        this.setUsuario(null);

        ImageIcon icon = (ImageIcon) this.jlbLogo.getIcon();
        Image img = ((Image) icon.getImage());
        this.setIconImage(img);
    }

    public FPrincipal(Usuario usuario) {
        this.initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(FPrincipal.MAXIMIZED_BOTH);
        this.jlbUsuario.setText(this.jlbUsuario.getText() + " " + usuario.getUsuLogin());
        this.jlbPrivilegio.setText(this.jlbPrivilegio.getText() + " "
                + UsuarioController.getPrivilegio(usuario));

        this.setUsuario(usuario);

        ImageIcon icon = (ImageIcon) this.jlbLogo.getIcon();
        Image img = ((Image) icon.getImage());
        this.setIconImage(img);

        String privilegio = UsuarioController.getPrivilegio(usuario);
        if (privilegio == "Médico") {
            this.jbtPessoa.setEnabled(false);
            this.jbtUsuario.setEnabled(false);
            this.jbtSecretario.setEnabled(false);
        } else if (privilegio == "Enfermeiro") {
            this.jbtPessoa.setEnabled(false);
            this.jbtUsuario.setEnabled(false);
            this.jbtMedico.setEnabled(false);
            this.jbtSecretario.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPrincipal = new javax.swing.JPanel();
        jbtSair = new javax.swing.JButton();
        jbtPessoa = new javax.swing.JButton();
        jbtUsuario = new javax.swing.JButton();
        jbtEnfermeiro = new javax.swing.JButton();
        jbtMedico = new javax.swing.JButton();
        jbtPaciente = new javax.swing.JButton();
        jbtSecretario = new javax.swing.JButton();
        jbtAtendimento = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jbtSobre = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jlbUsuario = new javax.swing.JLabel();
        jlbPrivilegio = new javax.swing.JLabel();
        jlbLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hospital E3G");

        jpPrincipal.setBackground(new java.awt.Color(204, 204, 255));

        jbtSair.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jbtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hospitale3g/icons/sair.png"))); // NOI18N
        jbtSair.setText("Sair");
        jbtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSairActionPerformed(evt);
            }
        });

        jbtPessoa.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jbtPessoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hospitale3g/icons/pessoa.png"))); // NOI18N
        jbtPessoa.setText("Pessoas       ");
        jbtPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtPessoaActionPerformed(evt);
            }
        });

        jbtUsuario.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jbtUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hospitale3g/icons/usuario.png"))); // NOI18N
        jbtUsuario.setText("Usuários      ");
        jbtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtUsuarioActionPerformed(evt);
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

        jbtMedico.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jbtMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hospitale3g/icons/medico.png"))); // NOI18N
        jbtMedico.setText("Médicos      ");
        jbtMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtMedicoActionPerformed(evt);
            }
        });

        jbtPaciente.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jbtPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hospitale3g/icons/paciente.png"))); // NOI18N
        jbtPaciente.setText("Pacientes   ");
        jbtPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtPacienteActionPerformed(evt);
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

        jbtAtendimento.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jbtAtendimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hospitale3g/icons/atendimento.png"))); // NOI18N
        jbtAtendimento.setText("Atendimentos");
        jbtAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAtendimentoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setText("      CADASTROS");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setText("          HOSPITAL");

        jbtSobre.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jbtSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hospitale3g/icons/sobre.png"))); // NOI18N
        jbtSobre.setText("Sobre");
        jbtSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSobreActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setText("           SISTEMA");

        jlbUsuario.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jlbUsuario.setText("USUÁRIO:");

        jlbPrivilegio.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jlbPrivilegio.setText("PRIVILÉGIO:");

        jlbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hospitale3g/icons/logo_129x65.png"))); // NOI18N
        jlbLogo.setEnabled(false);
        jlbLogo.setFocusable(false);

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtEnfermeiro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtPessoa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtMedico, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtPaciente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtSecretario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addComponent(jbtAtendimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtSobre, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbPrivilegio, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jlbUsuario))
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jbtPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbtAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbtSobre, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jlbPrivilegio)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtEnfermeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtSecretario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtUsuarioActionPerformed
        DCUsuario cUsuario = new DCUsuario(this, true, this.getUsuario());
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
        DCAtendimento cAtendimento = new DCAtendimento(this, true, UsuarioController.getPrivilegio(usuario));
        cAtendimento.setVisible(true);
    }//GEN-LAST:event_jbtAtendimentoActionPerformed

    private void jbtPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtPessoaActionPerformed
        DCPessoa cPessoa = new DCPessoa(this, true, this.getUsuario());
        cPessoa.setVisible(true);
    }//GEN-LAST:event_jbtPessoaActionPerformed

    private void jbtSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSobreActionPerformed
        DSobre sobre = new DSobre(this, true);
        sobre.setVisible(true);
    }//GEN-LAST:event_jbtSobreActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbtAtendimento;
    private javax.swing.JButton jbtEnfermeiro;
    private javax.swing.JButton jbtMedico;
    private javax.swing.JButton jbtPaciente;
    private javax.swing.JButton jbtPessoa;
    private javax.swing.JButton jbtSair;
    private javax.swing.JButton jbtSecretario;
    private javax.swing.JButton jbtSobre;
    private javax.swing.JButton jbtUsuario;
    private javax.swing.JLabel jlbLogo;
    private javax.swing.JLabel jlbPrivilegio;
    private javax.swing.JLabel jlbUsuario;
    private javax.swing.JPanel jpPrincipal;
    // End of variables declaration//GEN-END:variables

    public Usuario getUsuario() {
        return (this.usuario);
    }

    public final void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void sair() {
        this.dispose();
    }
}
