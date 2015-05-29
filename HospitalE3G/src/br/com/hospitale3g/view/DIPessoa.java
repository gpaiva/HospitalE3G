package br.com.hospitale3g.view;

import br.com.hospitale3g.controller.Lib;
import br.com.hospitale3g.dao.PessoaDao;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import br.com.hospitale3g.model.Pessoa;
import br.com.hospitale3g.controller.Lib;

public class DIPessoa extends javax.swing.JDialog {

    public enum tipoFormulario {
        tfINCLUSAO, tfEDICAO;
    }

    private tipoFormulario tipo;

    public DIPessoa(java.awt.Frame parent, boolean modal, String title) {
        super(parent, modal);
        this.initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle(title);
        
        PessoaDao daoPessoa = new PessoaDao();
        this.getSCodigo().setValue(daoPessoa.getNextCodPessoa());
        this.setTipo(tipoFormulario.tfINCLUSAO);
    }

    public DIPessoa(java.awt.Frame parent, boolean modal, String title, Pessoa pessoa) {
        super(parent, modal);
        this.initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle(title);
        
        this.getSCodigo().setValue(pessoa.getCodPessoa());
        this.getTNome().setText(pessoa.getNome());
        this.getCbSexo().setSelectedIndex(Lib.iif(pessoa.getSexo() == 'M', 0, 1));
        this.getTCPF().setText(pessoa.getCpf());
        this.getTRG().setText(pessoa.getRg());
        this.setTipo(tipoFormulario.tfEDICAO);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPrincipal = new javax.swing.JPanel();
        lbCodigo = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        sCodigo = new javax.swing.JSpinner();
        tNome = new javax.swing.JTextField();
        jpBotoes = new javax.swing.JPanel();
        btSalvar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        tCPF = new javax.swing.JTextField();
        lbCPF = new javax.swing.JLabel();
        tRG = new javax.swing.JTextField();
        lbRG = new javax.swing.JLabel();
        cbSexo = new javax.swing.JComboBox();
        lbSexo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Incluir - Pessoa");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jpPrincipal.setBackground(new java.awt.Color(204, 204, 255));

        lbCodigo.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lbCodigo.setText("*Código:");

        lbNome.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lbNome.setText("*Nome:");

        sCodigo.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        sCodigo.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        sCodigo.setEnabled(false);

        tNome.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

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

        tCPF.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        lbCPF.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lbCPF.setText("*CPF");

        tRG.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        lbRG.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lbRG.setText("*RG");

        cbSexo.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cbSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Feminino" }));

        lbSexo.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lbSexo.setText("*Sexo");

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCPF)
                            .addComponent(tCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbRG)
                            .addComponent(tRG)))
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(sCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tNome, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                .addComponent(lbCodigo)
                                .addGap(20, 20, 20)
                                .addComponent(lbNome)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbSexo)
                            .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(77, 77, 77))
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbCodigo)
                        .addComponent(lbNome))
                    .addComponent(lbSexo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbCPF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbRG)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 380, Short.MAX_VALUE)
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
        char sexo = Lib.iif(cbSexo.getSelectedIndex() == 0, 'M', 'F');
        
        Pessoa pessoa = new Pessoa(Integer.parseInt(this.getSCodigo().getValue().toString()),
                this.getTNome().getText(), sexo, tCPF.getText(), tRG.getText());
        PessoaDao daoPessoa = new PessoaDao();
        if (this.getTipo() == tipoFormulario.tfINCLUSAO) {
            daoPessoa.insert(pessoa);
        } else if (this.getTipo() == tipoFormulario.tfEDICAO) {
            daoPessoa.update(pessoa);
        }
        sair();
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
            java.util.logging.Logger.getLogger(DIPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DIPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DIPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DIPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DIPessoa dialog = new DIPessoa(new javax.swing.JFrame(), true, "Pessoa");
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

    private JSpinner getSCodigo() {
        return (this.sCodigo);
    }

    private JTextField getTNome() {
        return (this.tNome);
    }
    
    private JComboBox getCbSexo(){
        return(this.cbSexo);
    }
    
    private JTextField getTCPF(){
        return(this.tCPF);
    }
    
    private JTextField getTRG(){
        return(this.tRG);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox cbSexo;
    private javax.swing.JPanel jpBotoes;
    private javax.swing.JPanel jpPrincipal;
    private javax.swing.JLabel lbCPF;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbRG;
    private javax.swing.JLabel lbSexo;
    private javax.swing.JSpinner sCodigo;
    private javax.swing.JTextField tCPF;
    private javax.swing.JTextField tNome;
    private javax.swing.JTextField tRG;
    // End of variables declaration//GEN-END:variables
}
