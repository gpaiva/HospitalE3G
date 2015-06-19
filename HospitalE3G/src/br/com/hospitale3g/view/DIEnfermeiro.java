package br.com.hospitale3g.view;

import br.com.hospitale3g.controller.AtendimentoController;
import br.com.hospitale3g.controller.EnfermeiroController;
import br.com.hospitale3g.controller.Lib;
import br.com.hospitale3g.model.Pessoa;
import br.com.hospitale3g.controller.PessoaController;
import br.com.hospitale3g.model.Atendimento;
import br.com.hospitale3g.model.Enfermeiro;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DIEnfermeiro extends javax.swing.JDialog {

    public enum tipoFormulario {

        tfINCLUSAO, tfEDICAO, tfATENDIMENTO;
    }

    private boolean isInsertPessoa;
    private tipoFormulario tipo;
    private List<Pessoa> pessoas = new ArrayList<Pessoa>();
    private List<Enfermeiro> enfermeiros = new ArrayList<Enfermeiro>();
    private Atendimento atendimento = null;
    private String oldCoren;

    public DIEnfermeiro(java.awt.Frame parent, boolean modal, String title) {
        super(parent, modal);
        this.initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle(title);

        this.setIsInsertPessoa(false);
        this.setTipo(tipoFormulario.tfINCLUSAO);
        this.setPessoas(PessoaController.select());
        this.setOldCoren("");

        Iterator<Pessoa> it = getPessoas().iterator();
        while (it.hasNext()) {
            Pessoa pessoa = (Pessoa) it.next();
            this.jcbPessoa.addItem(pessoa.getCodPessoa() + " - " + pessoa.getNome());
        }
    }

    public DIEnfermeiro(java.awt.Frame parent, boolean modal, String title, Enfermeiro enfermeiro) {
        super(parent, modal);
        this.initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle(title);

        this.setIsInsertPessoa(false);
        this.setTipo(tipoFormulario.tfEDICAO);
        this.getPessoas().add(PessoaController.getPessoa(enfermeiro.getCodPessoa()));
        this.setOldCoren(enfermeiro.getCoren());

        this.jcbPessoa.addItem(enfermeiro.getCodPessoa() + " - " + enfermeiro.getNome());
        this.jtfCOREN.setText(enfermeiro.getCoren());
    }

    public DIEnfermeiro(java.awt.Frame parent, boolean modal, String title, Pessoa pessoa) {
        super(parent, modal);
        this.initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle(title);

        this.setIsInsertPessoa(true);
        this.setTipo(tipoFormulario.tfINCLUSAO);
        this.getPessoas().add(pessoa);
        this.setOldCoren("");

        this.jcbPessoa.addItem(pessoa.getCodPessoa() + " - " + pessoa.getNome());
    }

    public DIEnfermeiro(java.awt.Frame parent, boolean modal, String title, Atendimento atendimento) {
        super(parent, modal);
        this.initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle(title);

        this.setIsInsertPessoa(false);
        this.setTipo(tipoFormulario.tfATENDIMENTO);
        this.setEnfermeiros(EnfermeiroController.select());
        this.setAtendimento(atendimento);

        Iterator<Enfermeiro> it = getEnfermeiros().iterator();
        while (it.hasNext()) {
            Enfermeiro enfermeiro = (Enfermeiro) it.next();
            this.jcbPessoa.addItem(enfermeiro.getCodPessoa() + " - " + enfermeiro.getNome());
        }
        this.jtfCOREN.setEnabled(false);
        this.refreshCoren(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPrincipal = new javax.swing.JPanel();
        jlbCRM = new javax.swing.JLabel();
        jtfCOREN = new javax.swing.JTextField();
        jcbPessoa = new javax.swing.JComboBox();
        jlbPessoas = new javax.swing.JLabel();
        jpBotoes = new javax.swing.JPanel();
        btSalvar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Incluir - Enfermeiro");
        setName("iEnfermeiro"); // NOI18N
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jpPrincipal.setBackground(new java.awt.Color(204, 204, 255));

        jlbCRM.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jlbCRM.setText("*COREN");

        jtfCOREN.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jcbPessoa.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jcbPessoa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbPessoaItemStateChanged(evt);
            }
        });

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
                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlbPessoas)
                    .addComponent(jlbCRM)
                    .addComponent(jcbPessoa, 0, 258, Short.MAX_VALUE)
                    .addComponent(jtfCOREN))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jpBotoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbPessoas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbCRM)
                .addGap(2, 2, 2)
                .addComponent(jtfCOREN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        if (this.getIsInsertPessoa()) {
            if (Lib.confirmation("Saindo da Inclusão de Enfermeiros, "
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

    private void jcbPessoaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbPessoaItemStateChanged
        if (this.getTipo() == DIEnfermeiro.tipoFormulario.tfATENDIMENTO) {
            this.refreshCoren(this.jcbPessoa.getSelectedIndex());
        }
    }//GEN-LAST:event_jcbPessoaItemStateChanged

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
            java.util.logging.Logger.getLogger(DIEnfermeiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DIEnfermeiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DIEnfermeiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DIEnfermeiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DIEnfermeiro dialog = new DIEnfermeiro(new javax.swing.JFrame(), true, "Pessoa");
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
    private javax.swing.JLabel jlbCRM;
    private javax.swing.JLabel jlbPessoas;
    private javax.swing.JPanel jpBotoes;
    private javax.swing.JPanel jpPrincipal;
    private javax.swing.JTextField jtfCOREN;
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

    private Atendimento getAtendimento() {
        return (this.atendimento);
    }

    private void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }

    private List<Pessoa> getPessoas() {
        return (this.pessoas);
    }

    private void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    private List<Enfermeiro> getEnfermeiros() {
        return (this.enfermeiros);
    }

    private void setEnfermeiros(List<Enfermeiro> enfermeiros) {
        this.enfermeiros = enfermeiros;
    }

    private String getOldCoren() {
        return (this.oldCoren);
    }

    private void setOldCoren(String oldCoren) {
        this.oldCoren = oldCoren;
    }

    private void refreshCoren(int index) {
        if (this.jcbPessoa.getSelectedIndex() != -1) {
            this.jtfCOREN.setText(this.getEnfermeiros().get(index).getCoren());
        }
    }

    private void salvar() {
        boolean isValid = true;
        if (this.jtfCOREN.getText().isEmpty()) {
            Lib.information("*COREN. Preenchimento Obrigatório!");
            isValid = false;
            this.jtfCOREN.requestFocus();
        }
        if (this.getTipo() == DIEnfermeiro.tipoFormulario.tfINCLUSAO) {
            if (EnfermeiroController.existsEnfermeiro(this.jtfCOREN.getText())) {
                Lib.information("COREN já Cadastrado no Sistema!");
                isValid = false;
                this.jtfCOREN.requestFocus();
            }
        } else if (this.getTipo() == DIEnfermeiro.tipoFormulario.tfEDICAO) {
            if ((EnfermeiroController.existsEnfermeiro(this.jtfCOREN.getText()) && (!this.getOldCoren().equals(this.jtfCOREN.getText())))) {
                Lib.information("COREN já Cadastrado no Sistema!");
                isValid = false;
                this.jtfCOREN.requestFocus();
            }
        }

        if (isValid) {
            if (this.getTipo() == DIEnfermeiro.tipoFormulario.tfINCLUSAO) {
                Pessoa pessoa = getPessoas().get(this.jcbPessoa.getSelectedIndex());
                Enfermeiro enfermeiro = new Enfermeiro(pessoa, this.jtfCOREN.getText());
                EnfermeiroController.insert(enfermeiro);
            } else if (this.getTipo() == DIEnfermeiro.tipoFormulario.tfEDICAO) {
                Pessoa pessoa = getPessoas().get(this.jcbPessoa.getSelectedIndex());
                Enfermeiro enfermeiro = new Enfermeiro(pessoa, this.jtfCOREN.getText());
                EnfermeiroController.update(enfermeiro);
            } else if (this.getTipo() == DIEnfermeiro.tipoFormulario.tfATENDIMENTO) {
                this.getAtendimento().setCoren(this.jtfCOREN.getText());
                AtendimentoController.update(this.getAtendimento());
            }
            sair();
        }
    }

    private void sair() {
        this.dispose();
    }
}
