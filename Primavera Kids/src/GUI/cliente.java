/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package GUI;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import controller.ControllerCliente;
import DAO.DAOCliente;
import model.ModelCliente;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;

/**
 *
 * @author Carlos
 */
public class cliente extends javax.swing.JInternalFrame {

    ArrayList<ModelCliente> listaModelCliente = new ArrayList<>();
    ControllerCliente controllerCliente = new ControllerCliente();
    ModelCliente modelCliente = new ModelCliente();
    String salvarAlterar;

    /**
     * Creates new form cliente
     */
    public cliente() {
        initComponents();
        Color minhaCor = new Color(255, 242, 190);
        getContentPane().setBackground(minhaCor);

        carregarcliente();
        campos(false);
    }

    private void limpar() {
        nome.setText("");
        CPF.setText("");
        email.setText("");
        cel.setText("");
        sexo.setSelectedItem(null);
        end.setText("");
        cidade.setText("");
        estado.setSelectedItem(null);
        cep.setText("");
    }

    private void pegarCampos() {
        int linha = jTable1.getSelectedRow();
        try {
            int codigoClien = (int) jTable1.getValueAt(linha, 0);
            modelCliente = controllerCliente.getClienteController(codigoClien);
            nome.setText(modelCliente.getClienNome());
            CPF.setText(modelCliente.getClienCpf());
            email.setText(modelCliente.getClienEmail());
            cel.setText(modelCliente.getClienTelefone());
            sexo.setSelectedItem(modelCliente.getClienSexo());
            end.setText(modelCliente.getClienEndereco());
            cidade.setText(modelCliente.getClienCidade());
            estado.setSelectedItem(modelCliente.getClienEstado());
            cep.setText(modelCliente.getClienCep());
        } catch (Exception e) {
        }

    }

    private void campos(boolean condicao) {
        nome.setEnabled(condicao);
        CPF.setEnabled(condicao);
        email.setEnabled(condicao);
        cel.setEnabled(condicao);
        sexo.setEnabled(condicao);
        end.setEnabled(condicao);
        cidade.setEnabled(condicao);
        estado.setEnabled(condicao);
        cep.setEnabled(condicao);

    }

    private void salvar() {
        modelCliente.setClienNome(nome.getText());
        modelCliente.setClienCpf(CPF.getText());
        modelCliente.setClienEmail(email.getText());
        modelCliente.setClienTelefone(cel.getText());
        modelCliente.setClienSexo(sexo.getSelectedItem().toString());
        modelCliente.setClienEndereco(end.getText());
        modelCliente.setClienCidade(cidade.getText());
        modelCliente.setClienEstado(estado.getSelectedItem().toString());
        modelCliente.setClienCep(cep.getText());
        if (controllerCliente.salvarClienteController(modelCliente) > 0) {
            JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            this.carregarcliente();
            campos(false);
            limpar();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar o cliente!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void alterar() {
        modelCliente.setClienNome(nome.getText());
        modelCliente.setClienCpf(CPF.getText());
        modelCliente.setClienEmail(email.getText());
        modelCliente.setClienTelefone(cel.getText());
        modelCliente.setClienSexo(sexo.getSelectedItem().toString());
        modelCliente.setClienEndereco(end.getText());
        modelCliente.setClienCidade(cidade.getText());
        modelCliente.setClienEstado(estado.getSelectedItem().toString());
        modelCliente.setClienCep(cep.getText());
        if (controllerCliente.atualizarClienteController(modelCliente)) {
            JOptionPane.showMessageDialog(this, "Alterado com sucesso!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            this.carregarcliente();
            campos(false);
            limpar();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao alterar!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void carregarcliente() {
        listaModelCliente = controllerCliente.getListaClienteController();
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);

        int cont = listaModelCliente.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelCliente.get(i).getIdClien(),
                listaModelCliente.get(i).getClienNome(),
                listaModelCliente.get(i).getClienCpf(),
                listaModelCliente.get(i).getClienEmail(),
                listaModelCliente.get(i).getClienTelefone(),
                listaModelCliente.get(i).getClienSexo(), //listaModelCliente.get(i).getClienEndereco(),
            // listaModelCliente.get(i).getClienCidade(),
            // listaModelCliente.get(i).getClienEstado(),
            // listaModelCliente.get(i).getClienCep()
            });
        }
    }

    private boolean camposVazios() {
        if (nome.getText().isEmpty() || CPF.getText().isEmpty() || email.getText().isEmpty()
                || cel.getText().isEmpty() || sexo.getSelectedItem().toString().isEmpty()
                || end.getText().isEmpty() || cidade.getText().isEmpty() || estado.getSelectedItem().toString().isEmpty()
                || cep.getText().isEmpty()) {
            // Um ou mais campos estão vazios, não salve
            return true;
        } else {
            // Todos os campos estão preenchidos, pode salvar
            return false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sexo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cel = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        end = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cep = new javax.swing.JFormattedTextField();
        cidade = new javax.swing.JTextField();
        CPF = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        sal = new javax.swing.JButton();
        edi = new javax.swing.JButton();
        exc = new javax.swing.JButton();
        lim = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        pesq = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        estado = new javax.swing.JComboBox<>();
        cancelar = new javax.swing.JButton();
        novo = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cliente");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/group.png"))); // NOI18N

        sexo.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feminino", "Masculino" }));
        sexo.setSelectedIndex(-1);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setText("CEP:");

        try {
            cel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cel.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Endereço:");

        end.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setText("CPF:");

        try {
            cep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cep.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cep.setPreferredSize(new java.awt.Dimension(200, 27));

        cidade.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        try {
            CPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        CPF.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setText("Sexo:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPF", "Email", "Celular", "Sexo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(35);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(110);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(90);
        }

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setText("Cidade:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("Nome:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Email:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Celular:");

        nome.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        nome.setMaximumSize(new java.awt.Dimension(200, 2147483647));

        email.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

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

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Pesquisa:");

        pesq.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        pesq.setPreferredSize(new java.awt.Dimension(150, 25));
        pesq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pesqKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setText("Estado:");

        estado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acre (AC)", "Alagoas (AL)", "Amapá (AP)", "Amazonas (AM)", "Bahia (BA)", "Ceará (CE)", "Distrito Federal (DF)", "Espírito Santo (ES)", "Goiás (GO)", "Maranhão (MA)", "Mato Grosso (MT)", "Mato Grosso do Sul (MS)", "Minas Gerais (MG)", "Pará (PA)", "Paraíba (PB)", "Paraná (PR)", "Pernambuco (PE)", "Piauí (PI)", "Rio de Janeiro (RJ)", "Rio Grande do Norte (RN)", "Rio Grande do Sul (RS)", "Rondônia (RO)", "Roraima (RR)", "Santa Catarina (SC)", "São Paulo (SP)", "Sergipe (SE)", "Tocantins (TO)" }));
        estado.setSelectedIndex(-1);
        estado.setMinimumSize(new java.awt.Dimension(64, 22));
        estado.setPreferredSize(new java.awt.Dimension(200, 27));

        cancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.setMaximumSize(new java.awt.Dimension(100, 100));
        cancelar.setMinimumSize(new java.awt.Dimension(74, 27));
        cancelar.setPreferredSize(new java.awt.Dimension(77, 27));
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        novo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        novo.setText("Novo");
        novo.setMaximumSize(new java.awt.Dimension(74, 27));
        novo.setMinimumSize(new java.awt.Dimension(74, 27));
        novo.setPreferredSize(new java.awt.Dimension(77, 27));
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(email)
                                    .addComponent(CPF, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                    .addComponent(nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(cel)
                                    .addComponent(sexo, 0, 211, Short.MAX_VALUE)
                                    .addComponent(end))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9)
                                    .addComponent(estado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cidade)
                                    .addComponent(cep, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pesq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(exc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(edi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lim, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(novo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 296, Short.MAX_VALUE)
                                .addComponent(sal, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(end, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(4, 4, 4)
                                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(cidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(estado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(8, 8, 8)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(cep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesq, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(novo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(exc)
                            .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edi)
                            .addComponent(lim)))
                    .addComponent(sal, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        cel.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salActionPerformed
        if (this.salvarAlterar != null) {
            if (salvarAlterar.equals("salvar")) {
                if (!camposVazios()) {
                    salvar();
                } else {
                    JOptionPane.showMessageDialog(this, "Preencha todos os campos antes de salvar.", "Atenção", JOptionPane.WARNING_MESSAGE);
                }
            } else if (salvarAlterar.equals("alterar")) {
                alterar();
            } else if (salvarAlterar.equals("cancelar")) {
                JOptionPane.showMessageDialog(this, "Escolha entre 'Alterar' e 'Novo' para realizar essa ação.", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else if (salvarAlterar.equals("limpar")) {
                JOptionPane.showMessageDialog(this, "Escolha entre 'Alterar' e 'Novo' para realizar essa ação.", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "É preciso escolher entre 'Alterar' e 'Novo' para salvar os dados.", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_salActionPerformed

    private void ediActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ediActionPerformed
        salvarAlterar = "alterar";
        campos(true);
        int linha = jTable1.getSelectedRow();
        try {
            int codigoClien = (int) jTable1.getValueAt(linha, 0);
            modelCliente = controllerCliente.getClienteController(codigoClien);
            nome.setText(modelCliente.getClienNome());
            CPF.setText(modelCliente.getClienCpf());
            email.setText(modelCliente.getClienEmail());
            cel.setText(modelCliente.getClienTelefone());
            sexo.setSelectedItem(modelCliente.getClienSexo());
            end.setText(modelCliente.getClienEndereco());
            cidade.setText(modelCliente.getClienCidade());
            estado.setSelectedItem(modelCliente.getClienEstado());
            cep.setText(modelCliente.getClienCep());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Código inválido ou nenhum registro selecionado!", "Aviso", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_ediActionPerformed

    private void excActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excActionPerformed
        int linha = jTable1.getSelectedRow();
        int codigoClien = (int) jTable1.getValueAt(linha, 0);
        if (controllerCliente.excluirClienteController(codigoClien)) {
            JOptionPane.showMessageDialog(this, "Cliente excluido com sucesso!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            this.carregarcliente();
            campos(false);
            limpar();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao excluior o cliente!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_excActionPerformed

    private void limActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limActionPerformed
        salvarAlterar = "limpar";
        limpar();
    }//GEN-LAST:event_limActionPerformed

    private void pesqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pesqKeyReleased
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> mode1 = new TableRowSorter<>(modelo);
        jTable1.setRowSorter(mode1);
        mode1.setRowFilter(RowFilter.regexFilter(pesq.getText()));
    }//GEN-LAST:event_pesqKeyReleased

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        salvarAlterar = "cancelar";
        campos(false);
        limpar();
    }//GEN-LAST:event_cancelarActionPerformed

    private void novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoActionPerformed
        campos(true);
        salvarAlterar = "salvar";
    }//GEN-LAST:event_novoActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        pegarCampos();
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField CPF;
    private javax.swing.JButton cancelar;
    private javax.swing.JFormattedTextField cel;
    private javax.swing.JFormattedTextField cep;
    private javax.swing.JTextField cidade;
    private javax.swing.JButton edi;
    private javax.swing.JTextField email;
    private javax.swing.JTextField end;
    private javax.swing.JComboBox<String> estado;
    private javax.swing.JButton exc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton lim;
    private javax.swing.JTextField nome;
    private javax.swing.JButton novo;
    private javax.swing.JTextField pesq;
    private javax.swing.JButton sal;
    private javax.swing.JComboBox<String> sexo;
    // End of variables declaration//GEN-END:variables
}
