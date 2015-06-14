package br.com.hospitale3g.view;

import br.com.hospitale3g.controller.AtendimentoController;
import br.com.hospitale3g.controller.Lib;
import br.com.hospitale3g.controller.MedicoController;
import br.com.hospitale3g.controller.PacienteController;
import br.com.hospitale3g.model.Pessoa;
import br.com.hospitale3g.controller.PessoaController;
import br.com.hospitale3g.model.Atendimento;
import br.com.hospitale3g.model.Enfermeiro;
import br.com.hospitale3g.model.Medico;
import br.com.hospitale3g.model.Paciente;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DIAtendimento extends javax.swing.JDialog {

    public enum tipoFormulario {

        tfINCLUSAO, tfEDICAO;
    }

    private boolean isInsertPessoa;
    private tipoFormulario tipo;
    private List<Medico> medicos = new ArrayList<Medico>();
    private List<Paciente> pacientes = new ArrayList<Paciente>();

    public DIAtendimento(java.awt.Frame parent, boolean modal, String title) {
        super(parent, modal);
        this.initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle(title);

        this.setIsInsertPessoa(false);
        this.setTipo(tipoFormulario.tfINCLUSAO);
        this.setMedicos(MedicoController.select());
        this.setPacientes(PacienteController.select());

        this.jsCodigo.setValue(AtendimentoController.getNextAtenCodigo());
        Iterator<Medico> itMedico = getMedicos().iterator();
        while (itMedico.hasNext()) {
            Medico medico = (Medico) itMedico.next();
            this.jcbMedico.addItem(medico.getCodPessoa() + " - " + medico.getNome());
        }
        Iterator<Paciente> itPaciente = getPacientes().iterator();
        while (itPaciente.hasNext()) {
            Paciente paciente = (Paciente) itPaciente.next();
            this.jcbPaciente.addItem(paciente.getCodPessoa() + " - " + paciente.getNome());
        }
    }

    public DIAtendimento(java.awt.Frame parent, boolean modal, String title, Atendimento atendimento) {
        super(parent, modal);
        this.initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle(title);

        Medico medico = MedicoController.getMedico(atendimento.getCrm());
        Paciente paciente = PacienteController.getPacienteId(atendimento.getId());

        this.setIsInsertPessoa(false);
        this.setTipo(tipoFormulario.tfEDICAO);
        this.getMedicos().add(medico);
        this.getPacientes().add(paciente);

        this.jsCodigo.setValue(atendimento.getAtenCodigo());
        this.jcbMedico.addItem(medico.getCodPessoa() + " - " + medico.getNome());
        this.jcbMedico.setEnabled(false);
        this.jcbPaciente.addItem(paciente.getCodPessoa() + " - " + paciente.getNome());
        this.jcbPaciente.setEnabled(false);
        this.jtfData.setText(new SimpleDateFormat("dd/mm/yyyy").format(atendimento.getAtenDataHora()));
        this.jtfHora.setText(new SimpleDateFormat("hh:mm:ss").format(atendimento.getAtenDataHora()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPrincipal = new javax.swing.JPanel();
        jlbData = new javax.swing.JLabel();
        jtfData = new javax.swing.JTextField();
        jcbMedico = new javax.swing.JComboBox();
        jlbMedico = new javax.swing.JLabel();
        jcbPaciente = new javax.swing.JComboBox();
        jlbPaciente = new javax.swing.JLabel();
        jsCodigo = new javax.swing.JSpinner();
        lbCodigo = new javax.swing.JLabel();
        jtfHora = new javax.swing.JTextField();
        jlbHora = new javax.swing.JLabel();
        jpBotoes = new javax.swing.JPanel();
        btSalvar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Incluir - Enfermeiro");
        setName("iEnfermeiro"); // NOI18N
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jpPrincipal.setBackground(new java.awt.Color(204, 204, 255));

        jlbData.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jlbData.setText("*Data");

        jtfData.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jtfData.setEnabled(false);

        jcbMedico.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jlbMedico.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jlbMedico.setText("*Médico");

        jcbPaciente.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jlbPaciente.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jlbPaciente.setText("*Paciente");

        jsCodigo.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jsCodigo.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        jsCodigo.setEnabled(false);

        lbCodigo.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lbCodigo.setText("*Código:");

        jtfHora.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jtfHora.setEnabled(false);

        jlbHora.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jlbHora.setText("*Hora");

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

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jsCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCodigo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbMedico)
                            .addComponent(jcbMedico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbPaciente)
                            .addComponent(jcbPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbData)
                            .addComponent(jtfData, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbHora)
                            .addComponent(jtfHora, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jpBotoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addComponent(lbCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jsCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addComponent(jlbMedico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addComponent(jlbPaciente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbHora, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlbData))
                        .addGap(2, 2, 2)
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfData)
                            .addComponent(jtfHora))))
                .addGap(8, 8, 8)
                .addComponent(jpBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(DIAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DIAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DIAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DIAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DIAtendimento dialog = new DIAtendimento(new javax.swing.JFrame(), true, "Pessoa");
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
    private javax.swing.JComboBox jcbMedico;
    private javax.swing.JComboBox jcbPaciente;
    private javax.swing.JLabel jlbData;
    private javax.swing.JLabel jlbHora;
    private javax.swing.JLabel jlbMedico;
    private javax.swing.JLabel jlbPaciente;
    private javax.swing.JPanel jpBotoes;
    private javax.swing.JPanel jpPrincipal;
    private javax.swing.JSpinner jsCodigo;
    private javax.swing.JTextField jtfData;
    private javax.swing.JTextField jtfHora;
    private javax.swing.JLabel lbCodigo;
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

    private List<Medico> getMedicos() {
        return (this.medicos);
    }

    private void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

    private List<Paciente> getPacientes() {
        return (this.pacientes);
    }

    private void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    private void salvar() {
        Medico medico = getMedicos().get(this.jcbMedico.getSelectedIndex());
        Paciente paciente = getPacientes().get(this.jcbPaciente.getSelectedIndex());

        Atendimento atendimento;
        atendimento = new Atendimento(Integer.parseInt(this.jsCodigo.getValue().toString()),
                medico.getCrm(), paciente.getId(), null,
                new Date(),
                null, 0);

        if (this.getTipo() == DIAtendimento.tipoFormulario.tfINCLUSAO) {
            AtendimentoController.insert(atendimento);
        } else if (this.getTipo() == DIAtendimento.tipoFormulario.tfEDICAO) {
            AtendimentoController.update(atendimento);
        }
        sair();
    }

    private void sair() {
        this.dispose();
    }
}
