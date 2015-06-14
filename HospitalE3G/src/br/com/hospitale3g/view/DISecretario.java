package br.com.hospitale3g.view;

import br.com.hospitale3g.model.Pessoa;
import br.com.hospitale3g.controller.Lib;
import br.com.hospitale3g.controller.PessoaController;
import br.com.hospitale3g.controller.SecretarioController;
import br.com.hospitale3g.model.Secretario;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DISecretario extends javax.swing.JDialog {

    public enum tipoFormulario {

        tfINCLUSAO, tfEDICAO;
    }

    private boolean isInsertPessoa;
    private tipoFormulario tipo;
    private List<Pessoa> pessoas = new ArrayList<Pessoa>();
    private int oldRegistro;

    public DISecretario(java.awt.Frame parent, boolean modal, String title) {
        super(parent, modal);
        this.initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle(title);

        this.setIsInsertPessoa(false);
        this.setTipo(tipoFormulario.tfINCLUSAO);
        this.setPessoas(PessoaController.select());
        this.setOldRegistro(-1);

        Iterator<Pessoa> it = getPessoas().iterator();
        while (it.hasNext()) {
            Pessoa pessoa = (Pessoa) it.next();
            this.jcbPessoa.addItem(pessoa.getCodPessoa() + " - " + pessoa.getNome());
        }
        this.jsRegistro.setValue(SecretarioController.getNextRegistro());
    }

    public DISecretario(java.awt.Frame parent, boolean modal, String title, Secretario secretario) {
        super(parent, modal);
        this.initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle(title);

        this.jcbPessoa.addItem(secretario.getCodPessoa() + " - " + secretario.getNome());
        this.jcbPessoa.setEnabled(false);
        this.jsRegistro.setValue(secretario.getRegistro());

        this.setIsInsertPessoa(false);
        this.setTipo(tipoFormulario.tfEDICAO);
        this.getPessoas().add(PessoaController.getPessoa(secretario.getCodPessoa()));
        this.setOldRegistro(secretario.getRegistro());
    }

    public DISecretario(java.awt.Frame parent, boolean modal, String title, Pessoa pessoa) {
        super(parent, modal);
        this.initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle(title);

        this.jcbPessoa.addItem(pessoa.getCodPessoa() + " - " + pessoa.getNome());
        this.jcbPessoa.setEnabled(false);
        this.jsRegistro.setValue(SecretarioController.getNextRegistro());

        this.setIsInsertPessoa(true);
        this.setTipo(tipoFormulario.tfINCLUSAO);
        this.getPessoas().add(pessoa);
        this.setOldRegistro(-1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPrincipal = new javax.swing.JPanel();
        jlbRegistro = new javax.swing.JLabel();
        jcbPessoa = new javax.swing.JComboBox();
        jlbPessoas = new javax.swing.JLabel();
        jpBotoes = new javax.swing.JPanel();
        btSalvar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        jsRegistro = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Incluir - Médico");
        setName("iMedico"); // NOI18N
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jpPrincipal.setBackground(new java.awt.Color(204, 204, 255));

        jlbRegistro.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jlbRegistro.setText("*Registro:");

        jcbPessoa.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jlbPessoas.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jlbPessoas.setText("*Pessoa");

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
                .addContainerGap()
                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jsRegistro.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jsRegistro.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbPessoas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbRegistro)
                    .addComponent(jsRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jpBotoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbPessoas)
                    .addComponent(jlbRegistro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jsRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        if (this.getIsInsertPessoa()) {
            if (Lib.confirmation("Saindo da Inclusão de Secretários, "
                    + "a inclusão da Pessoa será cancelada!\n"
                    + "Deseja Realmente sair?", "Informação") == 0) {
                Pessoa pessoa = getPessoas().get(this.jcbPessoa.getSelectedIndex());
                PessoaController.delete(pessoa.getCodPessoa());
                this.sair();
            }
        } else {
            this.sair();
        }
    }//GEN-LAST:event_btSairActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        this.salvar();
    }//GEN-LAST:event_btSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(DISecretario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DISecretario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DISecretario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DISecretario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DISecretario dialog = new DISecretario(new javax.swing.JFrame(), true, "Pessoa");
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox jcbPessoa;
    private javax.swing.JLabel jlbPessoas;
    private javax.swing.JLabel jlbRegistro;
    private javax.swing.JPanel jpBotoes;
    private javax.swing.JPanel jpPrincipal;
    private javax.swing.JSpinner jsRegistro;
    // End of variables declaration//GEN-END:variables

    private boolean getIsInsertPessoa() {
        return (this.isInsertPessoa);
    }

    private void setIsInsertPessoa(boolean isInsertPessoa) {
        this.isInsertPessoa = isInsertPessoa;
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

    private int getOldRegistro() {
        return (this.oldRegistro);
    }

    private void setOldRegistro(int oldRegistro) {
        this.oldRegistro = oldRegistro;
    }

    private void salvar() {
        int registro = Integer.parseInt(this.jsRegistro.getValue().toString());
        boolean isValid = true;
        if (this.getTipo() == DISecretario.tipoFormulario.tfINCLUSAO) {
            if (SecretarioController.existsSecretario(registro)) {
                Lib.information("Registro já Cadastrado no Sistema!");
                isValid = false;
                this.jsRegistro.requestFocus();
            }
        } else if (this.getTipo() == DISecretario.tipoFormulario.tfEDICAO) {
            if (SecretarioController.existsSecretario(registro) && (oldRegistro != registro)) {
                Lib.information("Registro já Cadastrado no Sistema!");
                isValid = false;
                this.jsRegistro.requestFocus();
            }
        }

        if (isValid) {
            Pessoa pessoa = getPessoas().get(this.jcbPessoa.getSelectedIndex());
            Secretario secretario = new Secretario(pessoa, registro);

            if (this.getTipo() == DISecretario.tipoFormulario.tfINCLUSAO) {
                SecretarioController.insert(secretario);
            } else if (this.getTipo() == DISecretario.tipoFormulario.tfEDICAO) {
                SecretarioController.update(secretario);
            }
            sair();
        }
    }

    private void sair() {
        this.dispose();
    }

}
