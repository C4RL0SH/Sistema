/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package GUI;

import model.ModelProduto;
import controller.ControllerProduto;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class produto extends javax.swing.JInternalFrame {

    ArrayList<ModelProduto> listaModelProduto = new ArrayList<>();
    ControllerProduto controllerProduto = new ControllerProduto();
    ModelProduto modelProduto = new ModelProduto();
    String SalvarAlterar;

    /**
     * Creates new form produto
     */
    public produto() {
        initComponents();
        carregarProduto();
        campos(false);
        Color minhaCor = new Color(255, 242, 190);
        getContentPane().setBackground(minhaCor);

    }

    private void limpar() {
        cod.setText("");
        nome.setText("");
        fornecedor.setText("");
        cate.setSelectedItem(null);
        quant.setText("");
        tama.setText("");
        pp.setText("");
        desc.setText("");
    }

    private void campos(boolean condicao) {
        nome.setEnabled(condicao);
        fornecedor.setEnabled(condicao);
        cate.setEnabled(condicao);
        quant.setEnabled(condicao);
        tama.setEnabled(condicao);
        pp.setEnabled(condicao);
        desc.setEnabled(condicao);
    }

    private void pegarCampos() {
        int linha = jTable1.getSelectedRow();
        try {
            int codigoProd = (int) jTable1.getValueAt(linha, 0);
            modelProduto = controllerProduto.getProdutoController(codigoProd);
            cod.setText(String.valueOf(modelProduto.getIdProduto()));
            nome.setText(modelProduto.getProdNome());
            fornecedor.setText(modelProduto.getProdNomeFornec());
            cate.setSelectedItem(modelProduto.getProdCategoria());
            quant.setText(String.valueOf(modelProduto.getProdQuantidade()));
            tama.setText(modelProduto.getProdTamanho());
            pp.setText(String.valueOf(modelProduto.getProdPreco()));
            desc.setText(String.valueOf(modelProduto.getProd_Desconto()));
        } catch (Exception e) {

        }
    }

    private void carregarProduto() {
        listaModelProduto = controllerProduto.getListaProdutoController();
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);

        int cont = listaModelProduto.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelProduto.get(i).getIdProduto(),
                listaModelProduto.get(i).getProdNome(),
                listaModelProduto.get(i).getProdNomeFornec(),
                listaModelProduto.get(i).getProdCategoria(),
                listaModelProduto.get(i).getProdTamanho(),
                listaModelProduto.get(i).getProdDataRegistro(),
                listaModelProduto.get(i).getProdPreco(),
                listaModelProduto.get(i).getProd_Desconto(),
                listaModelProduto.get(i).getProdQuantidade()

            });
        }
    }

    private void salvar() {
        modelProduto.setProdNome(nome.getText());
        modelProduto.setProdNomeFornec(fornecedor.getText());

        // Obtendo a data e hora atuais
        Date dataHoraAtual = new Date();

        // Formatando a data para o formato desejado (dd/MM/yyyy)
        String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);

        // Convertendo a data formatada para um objeto java.sql.Date
        java.sql.Date dataSql = java.sql.Date.valueOf(LocalDate.parse(dataFormatada, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        modelProduto.setProdDataRegistro(dataSql);
        modelProduto.setProdCategoria(cate.getSelectedItem().toString());
        modelProduto.setProdQuantidade(Integer.parseInt(quant.getText()));
        modelProduto.setProdTamanho(tama.getText());
        modelProduto.setProdPreco(Double.parseDouble(pp.getText().replace(',', '.')));
        modelProduto.setProd_Desconto(Integer.parseInt(desc.getText()));
        if (controllerProduto.salvarProdutoController(modelProduto) > 0) {
            JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            this.carregarProduto();
            campos(false);
            limpar();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar o produto!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void alterar() {
        modelProduto.setProdNome(nome.getText());
        modelProduto.setProdNomeFornec(fornecedor.getText());
        modelProduto.setProdCategoria(cate.getSelectedItem().toString());
        modelProduto.setProdQuantidade(Integer.parseInt(quant.getText()));
        modelProduto.setProdTamanho(tama.getText());
        modelProduto.setProdPreco(Double.parseDouble(pp.getText().replace(',', '.')));
        modelProduto.setProd_Desconto(Integer.parseInt(desc.getText()));
        if (controllerProduto.atualizarProdutoController(modelProduto)) {
            JOptionPane.showMessageDialog(this, "Alterado com sucesso!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            this.carregarProduto();
            campos(false);
            limpar();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao alterar!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean camposVazios() {
        if (cod.getText().isEmpty() || nome.getText().isEmpty() || fornecedor.getText().isEmpty() || cate.getSelectedItem().toString().isEmpty()
                || quant.getText().isEmpty() || tama.getText().isEmpty() || pp.getText().isEmpty()
                || desc.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nome = new javax.swing.JTextField();
        fornecedor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        desc = new javax.swing.JTextField();
        quant = new javax.swing.JTextField();
        cate = new javax.swing.JComboBox<>();
        tama = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cod = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        pesq = new javax.swing.JTextField();
        pp = new javax.swing.JFormattedTextField();
        sal = new javax.swing.JButton();
        edi = new javax.swing.JButton();
        exc = new javax.swing.JButton();
        lim = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        novo = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 242, 190));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Produto");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/cart.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(100, 100));

        nome.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        nome.setPreferredSize(new java.awt.Dimension(150, 25));

        fornecedor.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("Nome:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Fornecedor:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Categoria:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Tamanho:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setText("Preço:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setText("Desconto:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setText("Quantidade:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Fornecedor", "Categoria", "Tamanho", "Registro", "Preço", "Desconto", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(70);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(200);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(200);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(120);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(70);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(200);
        }

        desc.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        quant.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        cate.setEditable(true);
        cate.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bolsa", "Camisa", "Camiseta", "Calça", "Jaqueta", "Macacão", "Meia", "Moletom", "Saia", "Sapatinho", "Sandália", "Short", "Vestido" }));
        cate.setSelectedIndex(-1);

        tama.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tama.setPreferredSize(new java.awt.Dimension(150, 25));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Código:");

        cod.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cod.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Pesquisa:");

        pesq.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        pesq.setPreferredSize(new java.awt.Dimension(150, 25));
        pesq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pesqKeyReleased(evt);
            }
        });

        pp.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        pp.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        sal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sal.setText("Salvar");
        sal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salActionPerformed(evt);
            }
        });

        edi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        edi.setText("Alterar");
        edi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ediActionPerformed(evt);
            }
        });

        exc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        exc.setText("Excluir");
        exc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excActionPerformed(evt);
            }
        });

        lim.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lim.setText("Limpar");
        lim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limActionPerformed(evt);
            }
        });

        cancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.setMaximumSize(new java.awt.Dimension(74, 27));
        cancelar.setMinimumSize(new java.awt.Dimension(74, 27));
        cancelar.setPreferredSize(new java.awt.Dimension(74, 27));
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        novo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        novo.setText("Novo");
        novo.setMaximumSize(new java.awt.Dimension(74, 27));
        novo.setMinimumSize(new java.awt.Dimension(74, 27));
        novo.setPreferredSize(new java.awt.Dimension(74, 27));
        novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pesq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(exc)
                .addGap(18, 18, 18)
                .addComponent(edi)
                .addGap(18, 18, 18)
                .addComponent(lim)
                .addGap(18, 18, 18)
                .addComponent(novo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sal, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cate, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cod, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quant, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pp, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11)
                    .addComponent(tama, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cod, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(tama, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pp, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(cate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quant, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesq, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lim, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(novo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salActionPerformed
        if (this.SalvarAlterar != null) {
            if (SalvarAlterar.equals("salvar")) {
                if (!camposVazios()) {
                    salvar();
                } else {
                    JOptionPane.showMessageDialog(this, "Preencha todos os campos antes de salvar.", "Atenção", JOptionPane.WARNING_MESSAGE);
                }
            } else if (SalvarAlterar.equals("alterar")) {
                alterar();
            } else if (SalvarAlterar.equals("cancelar")) {
                JOptionPane.showMessageDialog(this, "Escolha entre 'Alterar' e 'Novo' para realizar essa ação.", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else if (SalvarAlterar.equals("limpar")) {
                JOptionPane.showMessageDialog(this, "Escolha entre 'Alterar' e 'Novo' para realizar essa ação.", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "É preciso escolher entre 'Alterar' e 'Novo' para salvar os dados.", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_salActionPerformed

    private void ediActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ediActionPerformed
        SalvarAlterar = "alterar";
        campos(true);
        int linha = jTable1.getSelectedRow();
        try {
            int codigoProd = (int) jTable1.getValueAt(linha, 0);
            modelProduto = controllerProduto.getProdutoController(codigoProd);
            cod.setText(String.valueOf(modelProduto.getIdProduto()));
            nome.setText(modelProduto.getProdNome());
            fornecedor.setText(modelProduto.getProdNomeFornec());
            cate.setSelectedItem(modelProduto.getProdCategoria());
            quant.setText(String.valueOf(modelProduto.getProdQuantidade()));
            tama.setText(modelProduto.getProdTamanho());
            pp.setText(String.valueOf(modelProduto.getProdPreco()));
            desc.setText(String.valueOf(modelProduto.getProd_Desconto()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Código inválido ou nenhum registro selecionado!", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ediActionPerformed

    private void excActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excActionPerformed
        int linha = jTable1.getSelectedRow();
        int codigoProd = (int) jTable1.getValueAt(linha, 0);
        if (controllerProduto.excluirProdutoController(codigoProd)) {
            JOptionPane.showMessageDialog(this, "Produto excluido com sucesso!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            this.carregarProduto();
            campos(false);
            limpar();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao excluior o produto!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_excActionPerformed

    private void limActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limActionPerformed
        SalvarAlterar = "limpar";
        limpar();
    }//GEN-LAST:event_limActionPerformed

    private void pesqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pesqKeyReleased
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> mode1 = new TableRowSorter<>(modelo);
        jTable1.setRowSorter(mode1);
        mode1.setRowFilter(RowFilter.regexFilter(pesq.getText()));
    }//GEN-LAST:event_pesqKeyReleased

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        SalvarAlterar = "cancelar";
        campos(false);
        limpar();
    }//GEN-LAST:event_cancelarActionPerformed

    private void novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoActionPerformed
        campos(true);
        SalvarAlterar = "salvar";
    }//GEN-LAST:event_novoActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        pegarCampos();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        pegarCampos();        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox<String> cate;
    private javax.swing.JTextField cod;
    private javax.swing.JTextField desc;
    private javax.swing.JButton edi;
    private javax.swing.JButton exc;
    private javax.swing.JTextField fornecedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton lim;
    private javax.swing.JTextField nome;
    private javax.swing.JButton novo;
    private javax.swing.JTextField pesq;
    private javax.swing.JFormattedTextField pp;
    private javax.swing.JTextField quant;
    private javax.swing.JButton sal;
    private javax.swing.JTextField tama;
    // End of variables declaration//GEN-END:variables
}
