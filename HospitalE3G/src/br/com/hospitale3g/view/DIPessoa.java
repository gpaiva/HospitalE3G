package br.com.hospitale3g.view;

import br.com.hospitale3g.model.Pessoa;
import br.com.hospitale3g.controller.Lib;
import br.com.hospitale3g.controller.PessoaController;
import br.com.hospitale3g.controller.UsuarioController;
import br.com.hospitale3g.model.Usuario;
import java.sql.SQLException;
import javax.swing.JFrame;

public class DIPessoa extends javax.swing.JDialog {

    public enum tipoFormulario {

        tfINCLUSAO, tfEDICAO;
    }

    private tipoFormulario tipo;
    private String oldCpf;
    private String oldRg;

    public DIPessoa(java.awt.Frame parent, boolean modal, String title, Usuario usuario) {
        //inclusão
        super(parent, modal);
        this.initComponents();
        //passa a posição do dialog pro meio da tela
        this.setLocationRelativeTo(null);
        //altera o titulo
        this.setTitle(title);

        //inicializa as variaveis
        this.sCodigo.setValue(PessoaController.getNextCodPessoa());
        this.setTipo(tipoFormulario.tfINCLUSAO);
        this.setOldCpf("");
        this.setOldRg("");

        //caso for secretario, altera o combo para ter só o valor paciente
        //lembrando que pela analise, um secretario somente pode inserir pessoa
        //do tipo paciente
        if (UsuarioController.getPrivilegio(usuario) == "Secretário") {
            this.cbTipoPessoa.removeAllItems();
            this.cbTipoPessoa.addItem("Paciente");
        }
    }

    public DIPessoa(java.awt.Frame parent, boolean modal, String title, Pessoa pessoa) {
        //edição
        super(parent, modal);
        this.initComponents();
        //passa o dialog pro meio da tela
        this.setLocationRelativeTo(null);
        //altera o titulo do dialog
        this.setTitle(title);

        //iniciliza todos os componentes, pois é a edição
        this.sCodigo.setValue(pessoa.getCodPessoa());
        this.tNome.setText(pessoa.getNome());
        this.cbSexo.setSelectedIndex(Lib.iif(pessoa.getSexo() == 'M', 0, 1));
        this.tCPF.setText(pessoa.getCpf());
        this.tRG.setText(pessoa.getRg());
        this.jtfRua.setText(pessoa.getRua());
        this.jtfNumero.setText(pessoa.getNumero());
        this.jtfComplemento.setText(pessoa.getComplemento());
        this.jtfBairro.setText(pessoa.getBairro());
        this.jtfCidade.setText(pessoa.getCidade());
        this.jtfCep.setText(pessoa.getCep());
        this.setTipo(tipoFormulario.tfEDICAO);
        this.setOldCpf(pessoa.getCpf());
        this.setOldRg(pessoa.getRg());

        //remove todos os tipos da pessoa, e passa para o tipo da pessoa que está
        //sendo editada
        this.cbTipoPessoa.removeAllItems();
        this.cbTipoPessoa.addItem(PessoaController.getPessoa(pessoa));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPrincipal = new javax.swing.JPanel();
        lbCodigo = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        sCodigo = new javax.swing.JSpinner();
        tNome = new javax.swing.JTextField();
        lbCPF = new javax.swing.JLabel();
        lbRG = new javax.swing.JLabel();
        cbSexo = new javax.swing.JComboBox();
        lbSexo = new javax.swing.JLabel();
        cbTipoPessoa = new javax.swing.JComboBox();
        lbTipoPessoa = new javax.swing.JLabel();
        jtfRua = new javax.swing.JTextField();
        jlbRua = new javax.swing.JLabel();
        jlbNumero = new javax.swing.JLabel();
        jtfComplemento = new javax.swing.JTextField();
        jlbNumero1 = new javax.swing.JLabel();
        jtfBairro = new javax.swing.JTextField();
        jlbBairro = new javax.swing.JLabel();
        jtfCidade = new javax.swing.JTextField();
        jlbCidade = new javax.swing.JLabel();
        jtfCep = new javax.swing.JTextField();
        jlbCep = new javax.swing.JLabel();
        tCPF = new javax.swing.JFormattedTextField();
        jpBotoes = new javax.swing.JPanel();
        btSalvar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        jtfNumero = new javax.swing.JTextField();
        tRG = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Incluir - Pessoa");
        setName("IPessoa"); // NOI18N
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

        lbCPF.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lbCPF.setText("*CPF");

        lbRG.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lbRG.setText("*RG");

        cbSexo.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cbSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Feminino" }));

        lbSexo.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lbSexo.setText("*Sexo");

        cbTipoPessoa.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cbTipoPessoa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enfermeiro", "Médico", "Paciente", "Secretário" }));

        lbTipoPessoa.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lbTipoPessoa.setText("*Tipo de Pessoa");

        jtfRua.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jlbRua.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jlbRua.setText("*Rua");

        jlbNumero.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jlbNumero.setText("*Número");

        jtfComplemento.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jlbNumero1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jlbNumero1.setText("Complemento");

        jtfBairro.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jlbBairro.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jlbBairro.setText("*Bairro");

        jtfCidade.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jlbCidade.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jlbCidade.setText("*Cidade");

        jtfCep.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jlbCep.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jlbCep.setText("*CEP");

        try {
            tCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

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

        jtfNumero.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        tRG.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpPrincipalLayout.createSequentialGroup()
                                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlbRua)
                                    .addComponent(jtfRua, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                                        .addComponent(jlbNumero)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jtfNumero))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                                        .addComponent(jlbNumero1)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jtfComplemento)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpPrincipalLayout.createSequentialGroup()
                                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpPrincipalLayout.createSequentialGroup()
                                        .addComponent(sCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tNome))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpPrincipalLayout.createSequentialGroup()
                                        .addComponent(lbCodigo)
                                        .addGap(20, 20, 20)
                                        .addComponent(lbNome))
                                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbCPF)
                                            .addComponent(tCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tRG, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbRG))
                                        .addGap(15, 15, 15)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbSexo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbTipoPessoa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbTipoPessoa, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbSexo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpPrincipalLayout.createSequentialGroup()
                                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlbBairro)
                                    .addComponent(jtfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlbCidade)
                                    .addComponent(jtfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlbCep)
                                    .addComponent(jtfCep))))))
                .addContainerGap())
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbCodigo)
                        .addComponent(lbNome))
                    .addComponent(lbSexo, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbCPF)
                                    .addComponent(lbRG))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tRG, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addComponent(lbTipoPessoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTipoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlbNumero1)
                        .addComponent(jlbNumero)
                        .addComponent(jlbRua)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jpPrincipalLayout.createSequentialGroup()
                            .addComponent(jlbBairro)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jpPrincipalLayout.createSequentialGroup()
                            .addComponent(jlbCidade)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addComponent(jlbCep)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        //variavel para controle
        boolean isValid = true;

        //verificações
        if (this.tNome.getText().isEmpty()) {
            Lib.information("*Nome.\nPreenchimento Obrigatório!");
            isValid = false;
            this.tNome.requestFocus();
        } else if (this.tNome.getText().length() > 50) {
            Lib.information("Nome.\nSomente é permitido até 50 caracteres!");
            isValid = false;
            this.tNome.requestFocus();
        } else if (this.tCPF.getText().equals("   .   .   -  ")) {
            Lib.information("*CPF.\nPreenchimento Obrigatório!");
            isValid = false;
            this.tCPF.requestFocus();
        } else if ((PessoaController.existsPessoaCpf(this.tCPF.getText())) && (!this.getOldCpf().equals(this.tCPF.getText()))) {
            Lib.information("CPF já Cadastrado no Sistema!");
            isValid = false;
            this.tCPF.requestFocus();
        } else if (this.tRG.getText().isEmpty()) {
            Lib.information("*RG.\nPreenchimento Obrigatório!");
            isValid = false;
            this.tRG.requestFocus();
        } else if (this.tRG.getText().length() > 15) {
            Lib.information("RG.\nSomente é permitido até 15 caracteres!");
            isValid = false;
            this.tRG.requestFocus();
        } else if ((PessoaController.existsPessoaRg(this.tRG.getText())) && (!this.getOldRg().equals(this.tRG.getText()))) {
            Lib.information("RG já Cadastrado no Sistema!");
            isValid = false;
            this.tRG.requestFocus();
        } else if (this.jtfRua.getText().isEmpty()) {
            Lib.information("*Rua.\nPreenchimento Obrigatório!");
            isValid = false;
            this.jtfRua.requestFocus();
        } else if (this.jtfRua.getText().length() > 30) {
            Lib.information("Rua.\nSomente é permitido até 30 caracteres!");
            isValid = false;
            this.jtfRua.requestFocus();
        } else if (this.jtfNumero.getText().isEmpty()) {
            Lib.information("*Número.\nPreenchimento Obrigatório!");
            isValid = false;
            this.jtfNumero.requestFocus();
        } else if (this.jtfNumero.getText().length() > 10) {
            Lib.information("Número.\nSomente é permitido até 10 caracteres!");
            isValid = false;
            this.jtfNumero.requestFocus();
        } else if (this.jtfBairro.getText().isEmpty()) {
            Lib.information("*Bairro.\nPreenchimento Obrigatório!");
            isValid = false;
            this.jtfBairro.requestFocus();
        } else if (this.jtfBairro.getText().length() > 30) {
            Lib.information("Bairro.\nSomente é permitido até 30 caracteres!");
            isValid = false;
            this.jtfBairro.requestFocus();
        } else if (this.jtfCidade.getText().isEmpty()) {
            Lib.information("*Cidade.\nPreenchimento Obrigatório!");
            isValid = false;
            this.jtfCidade.requestFocus();
        } else if (this.jtfCidade.getText().length() > 30) {
            Lib.information("Cidade.\nSomente é permitido até 30 caracteres!");
            isValid = false;
            this.jtfCidade.requestFocus();
        } else if (this.jtfCep.getText().isEmpty()) {
            Lib.information("*CEP.\nPreenchimento Obrigatório!");
            isValid = false;
            this.jtfCep.requestFocus();
        } else if (this.jtfCep.getText().length() > 15) {
            Lib.information("CEP.\nSomente é permitido até 15 caracteres!");
            isValid = false;
            this.jtfCep.requestFocus();
        }

        //se ainda for valido
        if (isValid) {
            try {
                //salva a pessoa
                this.salvar();
            } catch (SQLException ex) {//tratamento de exceção
                DExcecao excecao = new DExcecao((JFrame) this.getParent(), true, ex.getMessage());
                excecao.setVisible(true);
            }
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void salvar() throws SQLException {
        //variavel para receber o sexo selecionado
        char sexo = Lib.iif(cbSexo.getSelectedIndex() == 0, 'M', 'F');
        //é instanciado uma pessoa de acordo com os valores no componente
        Pessoa pessoa = new Pessoa(Integer.parseInt(this.sCodigo.getValue().toString()),
                this.tNome.getText(), sexo, tCPF.getText(), tRG.getText(),
                this.jtfRua.getText(), this.jtfNumero.getText(), this.jtfComplemento.getText(),
                this.jtfBairro.getText(), this.jtfCidade.getText(), this.jtfCep.getText());

        //se for inclusão
        if (this.getTipo() == tipoFormulario.tfINCLUSAO) {
            //insere uma pessoa no bd
            PessoaController.insert(pessoa);
        } else if (this.getTipo() == tipoFormulario.tfEDICAO) {//se for edição
            //atualiza uma pessoa no bd
            PessoaController.update(pessoa);
        }

        //se for edição, verifica o tipo da pessoa, e abre a tela do tipo
        //correspondente
        if (this.getTipo() == tipoFormulario.tfINCLUSAO) {
            switch (this.cbTipoPessoa.getSelectedItem().toString()) {
                case "Enfermeiro":
                    DIEnfermeiro iEnfermeiro = new DIEnfermeiro((JFrame) this.getParent(),
                            true, "Inclusão - Enfermeiro", pessoa);
                    iEnfermeiro.setVisible(true);
                    break;
                case "Médico":
                    DIMedico iMedico = new DIMedico((JFrame) this.getParent(),
                            true, "Inclusão - Médico", pessoa);
                    iMedico.setVisible(true);
                    break;
                case "Paciente":
                    DIPaciente iPaciente = new DIPaciente((JFrame) this.getParent(),
                            true, "Inclusão - Paciente", pessoa);
                    iPaciente.setVisible(true);
                    break;
                case "Secretário":
                    DISecretario iSecretario = new DISecretario((JFrame) this.getParent(),
                            true, "Inclusão - Secretário", pessoa);
                    iSecretario.setVisible(true);
                    break;
                default:
                    DExcecao excecao = new DExcecao(null, true, "Erro ao inserir Pessoa\n"
                            + "Reinicie o Sistema!");
                    excecao.setVisible(true);
                    break;
            }
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
            @Override
            public void run() {
                DIPessoa dialog = new DIPessoa(new javax.swing.JFrame(), true, "Pessoa", null);
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
    private javax.swing.JComboBox cbSexo;
    private javax.swing.JComboBox cbTipoPessoa;
    private javax.swing.JLabel jlbBairro;
    private javax.swing.JLabel jlbCep;
    private javax.swing.JLabel jlbCidade;
    private javax.swing.JLabel jlbNumero;
    private javax.swing.JLabel jlbNumero1;
    private javax.swing.JLabel jlbRua;
    private javax.swing.JPanel jpBotoes;
    private javax.swing.JPanel jpPrincipal;
    private javax.swing.JTextField jtfBairro;
    private javax.swing.JTextField jtfCep;
    private javax.swing.JTextField jtfCidade;
    private javax.swing.JTextField jtfComplemento;
    private javax.swing.JTextField jtfNumero;
    private javax.swing.JTextField jtfRua;
    private javax.swing.JLabel lbCPF;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbRG;
    private javax.swing.JLabel lbSexo;
    private javax.swing.JLabel lbTipoPessoa;
    private javax.swing.JSpinner sCodigo;
    private javax.swing.JFormattedTextField tCPF;
    private javax.swing.JTextField tNome;
    private javax.swing.JTextField tRG;
    // End of variables declaration//GEN-END:variables

    //gets e sets
    private tipoFormulario getTipo() {
        return (this.tipo);
    }

    private void setTipo(tipoFormulario tipo) {
        this.tipo = tipo;
    }

    private String getOldCpf() {
        return (this.oldCpf);
    }

    private void setOldCpf(String oldCpf) {
        this.oldCpf = oldCpf;
    }

    private String getOldRg() {
        return (this.oldRg);
    }

    private void setOldRg(String oldRg) {
        this.oldRg = oldRg;
    }

}
