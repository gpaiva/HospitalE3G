package br.com.hospitale3g.view;

import br.com.hospitale3g.controller.EnfermeiroController;
import br.com.hospitale3g.controller.Lib;
import br.com.hospitale3g.controller.MedicoController;
import br.com.hospitale3g.controller.PacienteController;
import javax.swing.JFrame;
import br.com.hospitale3g.model.Pessoa;
import br.com.hospitale3g.controller.PessoaController;
import br.com.hospitale3g.controller.SecretarioController;
import br.com.hospitale3g.model.Usuario;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import net.sf.jasperreports.view.JasperViewer;

public class DCPessoa extends javax.swing.JDialog {

    Usuario usuario;

    public DCPessoa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.initComponents();

        //atualiza o grid
        this.atualizarJTable();
        //passa a posição inicial do dialog pro meio da tela
        this.setLocationRelativeTo(null);

        this.setUsuario(null);
    }

    public DCPessoa(java.awt.Frame parent, boolean modal, Usuario usuario) {
        super(parent, modal);
        this.initComponents();

        //atualiza o grid
        this.atualizarJTable();
        //passa a posição inicial do dialog pro meio da tela
        this.setLocationRelativeTo(null);

        this.setUsuario(usuario);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPrincipal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPessoa = new javax.swing.JTable();
        btNovo = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmArquivo = new javax.swing.JMenu();
        jmiNovo = new javax.swing.JMenuItem();
        jmiEditar = new javax.swing.JMenuItem();
        jmiExcluir = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmiAtualizar = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jmiSair = new javax.swing.JMenuItem();
        jmiRelatorioPessoa = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta - Pessoa");
        setName("cPessoa"); // NOI18N
        setPreferredSize(new java.awt.Dimension(700, 500));
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jpPrincipal.setBackground(new java.awt.Color(204, 204, 255));
        jpPrincipal.setBorder(null);

        tbPessoa.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tbPessoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null}
            },
            new String [] {
                ""
            }
        ));
        tbPessoa.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbPessoa.setAutoscrolls(false);
        tbPessoa.setShowHorizontalLines(true);
        tbPessoa.setShowVerticalLines(true);
        jScrollPane1.setViewportView(tbPessoa);
        tbPessoa.getAccessibleContext().setAccessibleParent(this);

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
        btExcluir.setText("Excluir");
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

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addComponent(btNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAtualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSair))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE))
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

        jmiRelatorioPessoa.setText("Relatório");

        jMenuItem1.setText("Relatório de Pessoas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmiRelatorioPessoa.add(jMenuItem1);

        jMenuBar1.add(jmiRelatorioPessoa);

        setJMenuBar(jMenuBar1);

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

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        this.novo();
    }//GEN-LAST:event_btNovoActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        this.excluir();
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        this.editar();
    }//GEN-LAST:event_btEditarActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        this.atualizarJTable();
    }//GEN-LAST:event_btAtualizarActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        this.sair();
    }//GEN-LAST:event_btSairActionPerformed

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

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.iReport();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DCPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                DCPessoa dialog = new DCPessoa(new javax.swing.JFrame(), true);
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

    //função que retorna a pessoa que está focada no grid
    private Pessoa getPessoaSelecionada() {
        //se o grid tiver vazio, retorna nulo pois nenhuma pessoa está selecionada
        if (this.tbPessoa.getRowCount() <= 0) {
            return (null);
        }

        //instancia uma Pessoa de acordo com os valores da linha selecionada no grid
        Pessoa pessoa = new Pessoa(
                Integer.parseInt(this.tbPessoa.getValueAt(
                                this.tbPessoa.getSelectedRow(), 0).toString()),
                this.tbPessoa.getValueAt(this.tbPessoa.getSelectedRow(), 1).toString(),
                this.tbPessoa.getValueAt(this.tbPessoa.getSelectedRow(), 2).toString().charAt(0),
                this.tbPessoa.getValueAt(this.tbPessoa.getSelectedRow(), 3).toString(),
                this.tbPessoa.getValueAt(this.tbPessoa.getSelectedRow(), 4).toString(),
                this.tbPessoa.getValueAt(this.tbPessoa.getSelectedRow(), 5).toString(),
                this.tbPessoa.getValueAt(this.tbPessoa.getSelectedRow(), 6).toString(),
                this.tbPessoa.getValueAt(this.tbPessoa.getSelectedRow(), 7).toString(),
                this.tbPessoa.getValueAt(this.tbPessoa.getSelectedRow(), 8).toString(),
                this.tbPessoa.getValueAt(this.tbPessoa.getSelectedRow(), 9).toString(),
                this.tbPessoa.getValueAt(this.tbPessoa.getSelectedRow(), 10).toString());
        //retorna essa pessoa
        return (pessoa);
    }

    private void sair() {
        //fecha a tela
        this.dispose();
    }

    //atualiza o grid
    private void atualizarJTable() {
        //modelo do grid é atualizado
        this.tbPessoa.setModel(PessoaController.getTableModel());
        //é passado todas as colunas para o tamanho 120
        for (int i = 0; i <= this.tbPessoa.getColumnCount() - 1; i++) {
            this.tbPessoa.getColumnModel().getColumn(i).setPreferredWidth(120);
        }
        //foca o grid
        this.tbPessoa.requestFocus();
        //se existir algum registro no grid
        if (this.tbPessoa.getModel().getRowCount() > 0) {
            //é focado o primeiro registro
            this.tbPessoa.setRowSelectionInterval(0, 0);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSair;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenu jmArquivo;
    private javax.swing.JMenuItem jmiAtualizar;
    private javax.swing.JMenuItem jmiEditar;
    private javax.swing.JMenuItem jmiExcluir;
    private javax.swing.JMenuItem jmiNovo;
    private javax.swing.JMenu jmiRelatorioPessoa;
    private javax.swing.JMenuItem jmiSair;
    private javax.swing.JPanel jpPrincipal;
    private javax.swing.JTable tbPessoa;
    // End of variables declaration//GEN-END:variables

    //gets e sets
    private Usuario getUsuario() {
        return (this.usuario);
    }

    private void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    //função para abrir a tela de novo
    private void novo() {
        DIPessoa iPessoa = new DIPessoa((JFrame) this.getParent(), true,
                "Incluir - Pessoa", this.getUsuario());
        iPessoa.setVisible(true);
        this.atualizarJTable();
    }

    //função para abrir a tela de edição
    private void editar() {
        if (this.getPessoaSelecionada() != null) {
            DIPessoa iPessoa = new DIPessoa((JFrame) this.getParent(), true,
                    "Editar - Pessoa", this.getPessoaSelecionada());
            iPessoa.setVisible(true);
            this.atualizarJTable();
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma Pessoa selecionada!");
        }
    }

    //função para excluir uma pessoa
    private void excluir() {
        //variavel para controle
        boolean isValid = true;

        //se tiver alguma pessoa selecionada
        if (this.getPessoaSelecionada() != null) {
            //variavel para receber o codigo da pessoa
            int codPessoa = this.getPessoaSelecionada().getCodPessoa();

            if (codPessoa == 1) {
                Lib.information("Não é possível excluir o Administrador!");
                isValid = false;
            } else if (PessoaController.hasDependenceAtendimento(codPessoa)) {
                Lib.information("Não é possível excluir a Pessoa, pois ela tem um Atendimento!");
                isValid = false;
            } else if (PessoaController.hasDependenceUsuario(codPessoa)) {
                Lib.information("Não é possível excluir a Pessoa, pois é um Usuário!");
                isValid = false;
            }

            //se ainda for valido para inserir uma pessoa
            if (isValid) {
                //variavel para retornar o tipo da pessoa
                String tipoPessoa = PessoaController.getPessoa(PessoaController.getPessoa(codPessoa));
                //verifica qual o tipo da pessoa
                if (tipoPessoa.equals("Enfermeiro")) {
                    if (Lib.confirmation("Essa Pessoa tem vínculo com Enfermeiro.\n"
                            + "Deseja realmente Excluír?", "Excluir Pessoa") == 0) {
                        EnfermeiroController.delete(codPessoa);
                    } else {
                        isValid = false;
                    }
                } else if (tipoPessoa.equals("Médico")) {
                    if (Lib.confirmation("Essa Pessoa tem vínculo com Médico.\n"
                            + "Deseja realmente Excluir?", "Excluir Pessoa") == 0) {
                        MedicoController.delete(codPessoa);
                    } else {
                        isValid = false;
                    }
                } else if (tipoPessoa.equals("Paciente")) {
                    if (Lib.confirmation("Essa Pessoa tem vínculo com Paciente.\n"
                            + "Deseja realmente Excluir?", "Excluir Pessoa") == 0) {
                        PacienteController.delete(codPessoa);
                    } else {
                        isValid = false;
                    }
                } else if (tipoPessoa.equals("Secretário")) {
                    if (Lib.confirmation("Essa Pessoa tem vínculo com Secretário.\n"
                            + "Deseja realmente Excluir?", "Excluir Pessoa") == 0) {
                        SecretarioController.delete(codPessoa);
                    } else {
                        isValid = false;
                    }
                }
            }

            //caso ainda for valido
            if (isValid) {
                //exclui a pessoa seleciona
                PessoaController.delete(this.getPessoaSelecionada().getCodPessoa());
                //atualiza a grid(tabela)
                this.atualizarJTable();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nenhuma Pessoa selecionada!");
        }
    }

    //função para exibir o relatorio na tela
    private void iReport() {
        //é criado um dialog padrão
        JDialog dialog = new JDialog(new javax.swing.JFrame(), "Visualização do Relatório", true);
        //passa o tamanho do dialog
        dialog.setSize(this.getParent().getWidth(), this.getParent().getHeight());
        //passa a posição do grid para o meio da tela
        dialog.setLocationRelativeTo(null);
        //obriga o relatorio sempre ficar por cima do sistema
        dialog.setAlwaysOnTop(true);

        //variavel que recebe o relatorio
        JasperViewer jv = PessoaController.getIReport();
        //adiciona o relatorio dentro do dialog
        dialog.getContentPane().add(jv.getContentPane());
        //mostra o dialog
        dialog.setVisible(true);
    }
}
