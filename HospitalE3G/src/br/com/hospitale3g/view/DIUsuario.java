package br.com.hospitale3g.view;

import br.com.hospitale3g.model.Pessoa;
import br.com.hospitale3g.controller.Lib;
import br.com.hospitale3g.controller.PessoaController;
import br.com.hospitale3g.controller.UsuarioController;
import br.com.hospitale3g.model.Usuario;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DIUsuario extends javax.swing.JDialog {

    public enum tipoFormulario {

        tfINCLUSAO, tfEDICAO;
    }

    private tipoFormulario tipo;
    private List<Pessoa> pessoas = new ArrayList<Pessoa>();

    public DIUsuario(java.awt.Frame parent, boolean modal, String title) {
        super(parent, modal);
        this.initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle(title);

        this.setTipo(tipoFormulario.tfINCLUSAO);

        setPessoas(PessoaController.select());
        Iterator<Pessoa> it = getPessoas().iterator();
        while (it.hasNext()) {
            Pessoa pessoa = (Pessoa) it.next();
            this.jcbPessoa.addItem(pessoa.getCodPessoa() + " - " + pessoa.getNome());
        }
    }

    public DIUsuario(java.awt.Frame parent, boolean modal, String title, Usuario usuario) {
        super(parent, modal);
        this.initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle(title);

        this.setTipo(tipoFormulario.tfEDICAO);
        this.getPessoas().add(new Pessoa(usuario.getCodPessoa(), usuario.getNome(),
                usuario.getSexo(), usuario.getCpf(), usuario.getRg(), usuario.getRua(),
                usuario.getNumero(), usuario.getComplemento(), usuario.getBairro(),
                usuario.getCidade(), usuario.getCep()));

        this.jcbPessoa.addItem(usuario.getCodPessoa() + " - " + usuario.getNome());
        this.jtfUsuario.setText(usuario.getUsuLogin());
        this.jtfSenhaAntiga.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPrincipal = new javax.swing.JPanel();
        jpBotoes = new javax.swing.JPanel();
        btSalvar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        jtfUsuario = new javax.swing.JTextField();
        jlbUsuario = new javax.swing.JLabel();
        jcbPessoa = new javax.swing.JComboBox();
        jlbPessoa = new javax.swing.JLabel();
        jtfSenhaAntiga = new javax.swing.JTextField();
        jlbSenhaAntiga = new javax.swing.JLabel();
        jtfSenha = new javax.swing.JTextField();
        jlbSenha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Incluir - Usuário");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jpPrincipal.setBackground(new java.awt.Color(204, 204, 255));

        jpBotoes.setBackground(new java.awt.Color(204, 204, 255));
        jpBotoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btSalvar.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hospitale3g/icons/salvar.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.setPreferredSize(new java.awt.Dimension(70, 70));
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btSair.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hospitale3g/icons/sair.png"))); // NOI18N
        btSair.setText("Sair");
        btSair.setPreferredSize(new java.awt.Dimension(70, 70));
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpBotoesLayout = new javax.swing.GroupLayout(jpBotoes);
        jpBotoes.setLayout(jpBotoesLayout);
        jpBotoesLayout.setHorizontalGroup(
            jpBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBotoesLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpBotoesLayout.setVerticalGroup(
            jpBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jtfUsuario.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jlbUsuario.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jlbUsuario.setText("*Usuário:");

        jcbPessoa.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jlbPessoa.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jlbPessoa.setText("*Pessoa:");

        jtfSenhaAntiga.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jtfSenhaAntiga.setEnabled(false);

        jlbSenhaAntiga.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jlbSenhaAntiga.setText("*Senha Antiga:");

        jtfSenha.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jlbSenha.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jlbSenha.setText("*Senha:");

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbPessoa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbPessoa)
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbUsuario)
                            .addComponent(jtfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbSenhaAntiga)
                            .addComponent(jtfSenhaAntiga, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbSenha)
                            .addComponent(jtfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jlbPessoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addComponent(jcbPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                .addComponent(jlbUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                                .addComponent(jlbSenha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addComponent(jlbSenhaAntiga)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfSenhaAntiga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        this.sair();
    }//GEN-LAST:event_btSairActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        this.salvar();
    }//GEN-LAST:event_btSalvarActionPerformed

    private void salvar() {
        boolean isValid = true;

        Pessoa pessoa = getPessoas().get(this.jcbPessoa.getSelectedIndex());
        Usuario usuario = new Usuario(pessoa, this.jtfUsuario.getText(), this.jtfSenha.getText());
        Usuario usuarioAux = UsuarioController.getUsuario(pessoa.getCodPessoa());

        if (this.getTipo() == DIUsuario.tipoFormulario.tfINCLUSAO) {
            if (UsuarioController.existsUsuarioCodPessoa(pessoa.getCodPessoa())) {
                Lib.information("Usuário já Cadastrado no Sistema!");
                isValid = false;
                this.jcbPessoa.requestFocus();
            } else if (PessoaController.getPessoa(PessoaController.getPessoa(pessoa.getCodPessoa())) == "Paciente") {
                Lib.information("Não é possível adicionar um Paciente como Usuário!");
                isValid = false;
                this.jcbPessoa.requestFocus();
            }
        }
        if (isValid) {
            if (this.jtfUsuario.getText().isEmpty()) {
                Lib.information("*Usuário.\nPreenchimento Obrigatório!");
                isValid = false;
                this.jtfUsuario.requestFocus();
            } else if (this.jtfSenha.getText().isEmpty()) {
                Lib.information("*Senha.\nPreenchimento Obrigatório!");
                isValid = false;
                this.jtfSenha.requestFocus();
            }
        }
        if (isValid) {
            if (this.jtfSenhaAntiga.isEnabled()) {
                if (this.jtfSenhaAntiga.getText().isEmpty()) {
                    Lib.information("*Senha Antiga.\nPreenchimento Obrigatório!");
                    isValid = false;
                    this.jtfSenhaAntiga.requestFocus();
                }
            }
        }
        if (isValid) {
            if (this.jtfSenhaAntiga.isEnabled()) {
                if (!this.jtfSenhaAntiga.getText().equals(usuarioAux.getUsuSenha())) {
                    Lib.information("Senha Antiga inválida!");
                    isValid = false;
                    this.jtfSenhaAntiga.requestFocus();
                }
            }
        }

        if (isValid) {
            if (this.getTipo() == tipoFormulario.tfINCLUSAO) {
                UsuarioController.insert(usuario);
            } else if (this.getTipo() == tipoFormulario.tfEDICAO) {
                UsuarioController.update(usuario);
            }
            sair();
        }
    }

    private void sair() {
        this.dispose();
    }

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
            java.util.logging.Logger.getLogger(DIUsuario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DIUsuario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DIUsuario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DIUsuario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DIUsuario dialog = new DIUsuario(new javax.swing.JFrame(), true, "Pessoa");
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private tipoFormulario getTipo() {
        return (this.tipo);
    }

    private void setTipo(tipoFormulario tipo) {
        this.tipo = tipo;
    }

    private List<Pessoa> getPessoas() {
        return (this.pessoas);
    }

    private void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox jcbPessoa;
    private javax.swing.JLabel jlbPessoa;
    private javax.swing.JLabel jlbSenha;
    private javax.swing.JLabel jlbSenhaAntiga;
    private javax.swing.JLabel jlbUsuario;
    private javax.swing.JPanel jpBotoes;
    private javax.swing.JPanel jpPrincipal;
    private javax.swing.JTextField jtfSenha;
    private javax.swing.JTextField jtfSenhaAntiga;
    private javax.swing.JTextField jtfUsuario;
    // End of variables declaration//GEN-END:variables
}
