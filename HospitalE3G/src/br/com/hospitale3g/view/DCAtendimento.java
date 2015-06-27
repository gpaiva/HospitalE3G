package br.com.hospitale3g.view;

import br.com.hospitale3g.controller.AtendimentoController;
import br.com.hospitale3g.dao.PessoaDao;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import br.com.hospitale3g.dao.EnfermeiroDao;
import br.com.hospitale3g.model.Atendimento;
import br.com.hospitale3g.controller.Lib;
import br.com.hospitale3g.controller.SecretarioController;
import br.com.hospitale3g.dao.AtendimentoDao;
import br.com.hospitale3g.dao.MedicoDao;
import br.com.hospitale3g.dao.PacienteDao;
import br.com.hospitale3g.model.Medico;
import br.com.hospitale3g.model.Paciente;
import br.com.hospitale3g.model.Enfermeiro;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import net.sf.jasperreports.view.JasperViewer;

public class DCAtendimento extends javax.swing.JDialog {

    public DCAtendimento(java.awt.Frame parent, boolean modal, String privilegio) {
        super(parent, modal);
        this.initComponents();
        this.atualizarJTable();
        this.setLocationRelativeTo(null);

        if (privilegio == "Secretário") {
            this.btEnfermeiro.setEnabled(false);
            this.btFinalizar.setEnabled(false);
        } else if (privilegio == "Enfermeiro") {
            this.btNovo.setEnabled(false);
            this.btEditar.setEnabled(false);
            this.btExcluir.setEnabled(false);
            this.btEnfermeiro.setEnabled(false);
            this.btFinalizar.setEnabled(false);
        } else if (privilegio == "Médico") {
            this.btNovo.setEnabled(false);
            this.btEditar.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPrincipal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbAtendimento = new javax.swing.JTable();
        btNovo = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        btEnfermeiro = new javax.swing.JButton();
        btFinalizar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmArquivo = new javax.swing.JMenu();
        jmiNovo = new javax.swing.JMenuItem();
        jmiEditar = new javax.swing.JMenuItem();
        jmiExcluir = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmiAtualizar = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jmiSair = new javax.swing.JMenuItem();
        jmDados = new javax.swing.JMenu();
        jmiEnfermeiro = new javax.swing.JMenuItem();
        jmiFinalizar = new javax.swing.JMenuItem();
        jmRelatorio = new javax.swing.JMenu();
        jmiRelatorioAtendimento = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta - Atendimentos");
        setName("cEnfermeiro"); // NOI18N
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jpPrincipal.setBackground(new java.awt.Color(204, 204, 255));
        jpPrincipal.setBorder(null);

        jtbAtendimento.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jtbAtendimento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null}
            },
            new String [] {
                ""
            }
        ));
        jtbAtendimento.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtbAtendimento.setAutoscrolls(false);
        jtbAtendimento.setShowHorizontalLines(true);
        jtbAtendimento.setShowVerticalLines(true);
        jScrollPane1.setViewportView(jtbAtendimento);
        jtbAtendimento.getAccessibleContext().setAccessibleParent(this);

        btNovo.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hospitale3g/icons/novo.png"))); // NOI18N
        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btExcluir.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hospitale3g/icons/excluir.png"))); // NOI18N
        btExcluir.setText("Cancelar");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btEditar.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hospitale3g/icons/editar.png"))); // NOI18N
        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btAtualizar.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hospitale3g/icons/atualizar.png"))); // NOI18N
        btAtualizar.setText("Atualizar");
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        btSair.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hospitale3g/icons/sair.png"))); // NOI18N
        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        btEnfermeiro.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btEnfermeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hospitale3g/icons/enfermeiro.png"))); // NOI18N
        btEnfermeiro.setText("Enfermeiro");
        btEnfermeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEnfermeiroActionPerformed(evt);
            }
        });

        btFinalizar.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hospitale3g/icons/finalizar.png"))); // NOI18N
        btFinalizar.setText("Finalizar");
        btFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEnfermeiro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btFinalizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAtualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSair)
                .addContainerGap())
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEnfermeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jmArquivo.setText("Arquivo");

        jmiNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hospitale3g/icons/novo.png"))); // NOI18N
        jmiNovo.setText("Novo");
        jmiNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNovoActionPerformed(evt);
            }
        });
        jmArquivo.add(jmiNovo);

        jmiEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hospitale3g/icons/editar.png"))); // NOI18N
        jmiEditar.setText("Editar");
        jmiEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEditarActionPerformed(evt);
            }
        });
        jmArquivo.add(jmiEditar);

        jmiExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hospitale3g/icons/excluir.png"))); // NOI18N
        jmiExcluir.setText("Excluir");
        jmiExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiExcluirActionPerformed(evt);
            }
        });
        jmArquivo.add(jmiExcluir);
        jmArquivo.add(jSeparator1);

        jmiAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hospitale3g/icons/atualizar.png"))); // NOI18N
        jmiAtualizar.setText("Atualizar");
        jmiAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAtualizarActionPerformed(evt);
            }
        });
        jmArquivo.add(jmiAtualizar);
        jmArquivo.add(jSeparator2);

        jmiSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hospitale3g/icons/sair.png"))); // NOI18N
        jmiSair.setText("Sair");
        jmiSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSairActionPerformed(evt);
            }
        });
        jmArquivo.add(jmiSair);

        jMenuBar1.add(jmArquivo);

        jmDados.setText("Dados");

        jmiEnfermeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hospitale3g/icons/enfermeiro.png"))); // NOI18N
        jmiEnfermeiro.setText("Enfermeiro");
        jmiEnfermeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEnfermeiroActionPerformed(evt);
            }
        });
        jmDados.add(jmiEnfermeiro);

        jmiFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/hospitale3g/icons/finalizar.png"))); // NOI18N
        jmiFinalizar.setText("Finalizar");
        jmiFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiFinalizarActionPerformed(evt);
            }
        });
        jmDados.add(jmiFinalizar);

        jMenuBar1.add(jmDados);

        jmRelatorio.setText("Relatório");

        jmiRelatorioAtendimento.setText("Relatório de Atendimentos");
        jmiRelatorioAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRelatorioAtendimentoActionPerformed(evt);
            }
        });
        jmRelatorio.add(jmiRelatorioAtendimento);

        jMenuBar1.add(jmRelatorio);

        setJMenuBar(jMenuBar1);

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

    private void jmiNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNovoActionPerformed
        this.novo();
    }//GEN-LAST:event_jmiNovoActionPerformed

    private void jmiEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEditarActionPerformed
        this.editar();
    }//GEN-LAST:event_jmiEditarActionPerformed

    private void jmiExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiExcluirActionPerformed
        this.excluir();
    }//GEN-LAST:event_jmiExcluirActionPerformed

    private void jmiAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAtualizarActionPerformed
        this.atualizarJTable();
    }//GEN-LAST:event_jmiAtualizarActionPerformed

    private void jmiSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSairActionPerformed
        this.sair();
    }//GEN-LAST:event_jmiSairActionPerformed

    private void btFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFinalizarActionPerformed
        this.finalizar();
    }//GEN-LAST:event_btFinalizarActionPerformed

    private void btEnfermeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEnfermeiroActionPerformed
        this.enfermeiro();
    }//GEN-LAST:event_btEnfermeiroActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        this.sair();
    }//GEN-LAST:event_btSairActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        this.atualizarJTable();
    }//GEN-LAST:event_btAtualizarActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        this.editar();
    }//GEN-LAST:event_btEditarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        this.excluir();
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        this.novo();
    }//GEN-LAST:event_btNovoActionPerformed

    private void jmiEnfermeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEnfermeiroActionPerformed
        this.enfermeiro();
    }//GEN-LAST:event_jmiEnfermeiroActionPerformed

    private void jmiFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiFinalizarActionPerformed
        this.finalizar();
    }//GEN-LAST:event_jmiFinalizarActionPerformed

    private void jmiRelatorioAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRelatorioAtendimentoActionPerformed
        this.iReport();
    }//GEN-LAST:event_jmiRelatorioAtendimentoActionPerformed

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
            java.util.logging.Logger.getLogger(DCAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DCAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DCAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DCAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DCAtendimento dialog = new DCAtendimento(new javax.swing.JFrame(), true, "");
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

    private Atendimento getAtendimentoSelected() {
        if (jtbAtendimento.getRowCount() == 0) {
            return (null);
        }

        MedicoDao medicoDao = new MedicoDao();
        Medico medico = medicoDao.getMedico(Integer.parseInt(this.getTbAtendimento().getValueAt(
                this.getTbAtendimento().getSelectedRow(), 2).toString()));
        PacienteDao pacienteDao = new PacienteDao();
        Paciente paciente = pacienteDao.getPaciente(Integer.parseInt(this.getTbAtendimento().getValueAt(
                this.getTbAtendimento().getSelectedRow(), 4).toString()));

        int situacao = -1;
        if (this.getTbAtendimento().getValueAt(this.getTbAtendimento().getSelectedRow(), 5).toString().equals("Aberto")) {
            situacao = 0;
        } else if (this.getTbAtendimento().getValueAt(this.getTbAtendimento().getSelectedRow(), 5).toString().equals("Cancelado")) {
            situacao = 1;
        } else if (this.getTbAtendimento().getValueAt(this.getTbAtendimento().getSelectedRow(), 5).toString().equals("Finalizado")) {
            situacao = 2;
        }

        String observacao = "";
        if (this.getTbAtendimento().getValueAt(this.getTbAtendimento().getSelectedRow(), 12) != null) {
            observacao = this.getTbAtendimento().getValueAt(this.getTbAtendimento().getSelectedRow(), 10).toString();
        }

        Atendimento atendimento;
        atendimento = new Atendimento(Integer.parseInt(this.getTbAtendimento().getValueAt(this.getTbAtendimento().getSelectedRow(), 0).toString()),
                medico.getCrm(),
                paciente.getId(),
                "", "", "", "",
                situacao,
                observacao);
        return (atendimento);
    }

    private void sair() {
        this.dispose();
    }

    private void atualizarJTable() {
        this.getTbAtendimento().setModel(AtendimentoController.getTableModel());
        for (int i = 0; i <= this.jtbAtendimento.getColumnCount() - 1; i++) {
            this.jtbAtendimento.getColumnModel().getColumn(i).setPreferredWidth(120);
        }
        this.getTbAtendimento().requestFocus();
        if (this.getTbAtendimento().getModel().getRowCount() > 0) {
            this.getTbAtendimento().setRowSelectionInterval(0, 0);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btEnfermeiro;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btFinalizar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSair;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenu jmArquivo;
    private javax.swing.JMenu jmDados;
    private javax.swing.JMenu jmRelatorio;
    private javax.swing.JMenuItem jmiAtualizar;
    private javax.swing.JMenuItem jmiEditar;
    private javax.swing.JMenuItem jmiEnfermeiro;
    private javax.swing.JMenuItem jmiExcluir;
    private javax.swing.JMenuItem jmiFinalizar;
    private javax.swing.JMenuItem jmiNovo;
    private javax.swing.JMenuItem jmiRelatorioAtendimento;
    private javax.swing.JMenuItem jmiSair;
    private javax.swing.JPanel jpPrincipal;
    private javax.swing.JTable jtbAtendimento;
    // End of variables declaration//GEN-END:variables

    private JTable getTbAtendimento() {
        return (this.jtbAtendimento);
    }

    private void novo() {
        DIAtendimento iAtendimento = new DIAtendimento((JFrame) this.getParent(), true,
                "Incluir - Atendimento");
        iAtendimento.setVisible(true);
        this.atualizarJTable();
    }

    private void editar() {
        if (this.getAtendimentoSelected() != null) {
            Atendimento atendimento = this.getAtendimentoSelected();
            if (atendimento.getAtenSituacao() == 1) {
                Lib.information("Não é possível editar Atendimentos cancelados!");
            } else if (atendimento.getAtenSituacao() == 2) {
                Lib.information("Não é possível editar Atendimentos finalizados!");
            } else {
                DIAtendimento iAtendimento = new DIAtendimento((JFrame) this.getParent(), true,
                        "Editar - Atendimento", atendimento);
                iAtendimento.setVisible(true);
                this.atualizarJTable();
            }
        } else {
            Lib.information("Nenhum Atendimento selecionado!");
        }
    }

    private void excluir() {
        if (this.getAtendimentoSelected() != null) {
            Atendimento atendimento = this.getAtendimentoSelected();
            if (atendimento.getAtenSituacao() == 1) {
                Lib.information("Não é possível cancelar Atendimentos cancelados!");
            } else if (atendimento.getAtenSituacao() == 2) {
                Lib.information("Não é possível cancelar Atendimentos finalizados!");
            } else {
                AtendimentoDao atendimentoDao = new AtendimentoDao();
                atendimentoDao.delete(atendimento.getAtenCodigo());
                this.atualizarJTable();
            }
        } else {
            Lib.information("Nenhum Atendimento selecionado!");
        }
    }

    private void enfermeiro() {
        if (this.getAtendimentoSelected() == null) {
            Lib.information("Nenhum Atendimento foi selecionado!");
        } else {
            Atendimento atendimento = this.getAtendimentoSelected();
            if (atendimento.getAtenSituacao() == 1) {
                Lib.information("Não é possível adicionar Enfermeiros em Atendimentos cancelados!");
            } else if (atendimento.getAtenSituacao() == 2) {
                Lib.information("Não é possível adicionar Enfermeiros em Atendimentos finalizados!");
            } else {
                DIEnfermeiro iEnfermeiro = new DIEnfermeiro((JFrame) this.getParent(),
                        true, "Atendimento - Inclusão - Enfermeiro", atendimento);
                iEnfermeiro.setVisible(true);
                this.atualizarJTable();
            }
        }
    }

    private void finalizar() {
        if (this.getAtendimentoSelected() == null) {
            Lib.information("Nenhum Atendimento foi selecionado!");
        } else {
            Atendimento atendimento = this.getAtendimentoSelected();
            if (atendimento.getAtenSituacao() == 1) {
                Lib.information("Não é possível finalizar Atendimentos cancelados!");
            } else if (atendimento.getAtenSituacao() == 2) {
                Lib.information("Não é possível finalizar Atendimentos finalizados!");
            } else {
                atendimento.setAtenSituacao(2);
                AtendimentoController.update(atendimento);
                this.atualizarJTable();
            }
        }
    }

    private void iReport() {
        JDialog viewer = new JDialog(new javax.swing.JFrame(), "Visualização do Relatório", true);
        viewer.setSize(this.getParent().getWidth(), this.getParent().getHeight());
        viewer.setLocationRelativeTo(null);
        viewer.setAlwaysOnTop(true);

        JasperViewer jv = AtendimentoController.getIReport();
        viewer.getContentPane().add(jv.getContentPane());
        viewer.setVisible(true);
    }
}
