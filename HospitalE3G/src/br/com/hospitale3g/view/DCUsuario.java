package br.com.hospitale3g.view;

import javax.swing.JFrame;
import br.com.hospitale3g.model.Usuario;
import br.com.hospitale3g.controller.Lib;
import br.com.hospitale3g.controller.PessoaController;
import br.com.hospitale3g.controller.UsuarioController;
import br.com.hospitale3g.model.Pessoa;
import javax.swing.JDialog;
import net.sf.jasperreports.view.JasperViewer;

public class DCUsuario extends javax.swing.JDialog {

    public DCUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.initComponents();
        this.atualizarJTable();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPrincipal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuario = new javax.swing.JTable();
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
        jmRelatorio = new javax.swing.JMenu();
        jmiRelatorioUsuario = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta - Usuário");
        setName("cUsuario"); // NOI18N
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jpPrincipal.setBackground(new java.awt.Color(204, 204, 255));
        jpPrincipal.setBorder(null);

        tbUsuario.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tbUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null}
            },
            new String [] {
                ""
            }
        ));
        tbUsuario.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbUsuario.setAutoscrolls(false);
        tbUsuario.setShowHorizontalLines(true);
        tbUsuario.setShowVerticalLines(true);
        jScrollPane1.setViewportView(tbUsuario);
        tbUsuario.getAccessibleContext().setAccessibleParent(this);

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
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addComponent(btNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAtualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSair)))
                .addGap(0, 0, 0))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
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

        jmRelatorio.setText("Relatório");

        jmiRelatorioUsuario.setText("Relatório de Usuários");
        jmiRelatorioUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRelatorioUsuarioActionPerformed(evt);
            }
        });
        jmRelatorio.add(jmiRelatorioUsuario);

        jMenuBar1.add(jmRelatorio);

        setJMenuBar(jMenuBar1);

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

    private void jmiRelatorioUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRelatorioUsuarioActionPerformed
        this.iReport();
    }//GEN-LAST:event_jmiRelatorioUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(DCUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DCUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DCUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DCUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                DCUsuario dialog = new DCUsuario(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSair;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenu jmArquivo;
    private javax.swing.JMenu jmRelatorio;
    private javax.swing.JMenuItem jmiAtualizar;
    private javax.swing.JMenuItem jmiEditar;
    private javax.swing.JMenuItem jmiExcluir;
    private javax.swing.JMenuItem jmiNovo;
    private javax.swing.JMenuItem jmiRelatorioUsuario;
    private javax.swing.JMenuItem jmiSair;
    private javax.swing.JPanel jpPrincipal;
    private javax.swing.JTable tbUsuario;
    // End of variables declaration//GEN-END:variables

    private void sair() {
        this.dispose();
    }

    private Usuario getUsuarioSelected() {
        if (tbUsuario.getRowCount() <= 0) {
            return (null);
        }

        Pessoa pessoa = PessoaController.getPessoa(Integer.parseInt(this.tbUsuario.getValueAt(
                this.tbUsuario.getSelectedRow(), 0).toString()));

        Usuario usuario = new Usuario(pessoa,
                this.tbUsuario.getValueAt(this.tbUsuario.getSelectedRow(), 2).toString());
        return (usuario);
    }

    private void atualizarJTable() {
        this.tbUsuario.setModel(UsuarioController.getTableModel());
        this.tbUsuario.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.tbUsuario.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.tbUsuario.requestFocus();
        if (this.tbUsuario.getModel().getRowCount() > 0) {
            this.tbUsuario.setRowSelectionInterval(0, 0);
        }
    }

    private void novo() {
        DIUsuario iUsuario = new DIUsuario((JFrame) this.getParent(), true,
                "Incluir - Usuario");
        iUsuario.setVisible(true);
        this.atualizarJTable();
    }

    private void editar() {
        if (this.getUsuarioSelected() != null) {
            DIUsuario iUsuario = new DIUsuario((JFrame) this.getParent(), true,
                    "Editar - Usuario", this.getUsuarioSelected());
            iUsuario.setVisible(true);
            this.atualizarJTable();
        } else {
            Lib.information("Nenhum Usuário selecionado!");
        }
    }

    private void excluir() {
        if (this.getUsuarioSelected() != null) {
            UsuarioController.delete(this.getUsuarioSelected().getCodPessoa());
            this.atualizarJTable();
        } else {
            Lib.information("Nenhum Usuário selecionado!");
        }
    }

    private void iReport() {
        JDialog viewer = new JDialog(new javax.swing.JFrame(), "Visualização do Relatório", true);
        viewer.setSize(this.getParent().getWidth(), this.getParent().getHeight());
        viewer.setLocationRelativeTo(null);
        viewer.setAlwaysOnTop(true);

        JasperViewer jv = UsuarioController.getIReport();
        viewer.getContentPane().add(jv.getContentPane());
        viewer.setVisible(true);
    }
}
