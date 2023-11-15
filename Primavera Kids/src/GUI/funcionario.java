package GUI;

import model.ModelFuncionario;
import controller.ControllerFuncionario;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class funcionario extends javax.swing.JInternalFrame {

    ArrayList<ModelFuncionario> listaModelFuncionario = new ArrayList<>();
    ControllerFuncionario controllerFuncionario = new ControllerFuncionario();
    ModelFuncionario modelFuncionario = new ModelFuncionario();
    String salvarAlterar;
    

    public funcionario() {
        initComponents();
        carregarFuncionario();
        campos(false);
        Color minhaCor = new Color(255, 242, 190);
        getContentPane().setBackground(minhaCor);
    }

    private void carregarFuncionario() {
        listaModelFuncionario = controllerFuncionario.getListaFuncionarioController();
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);

        int cont = listaModelFuncionario.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelFuncionario.get(i).getIdFunc(),
                listaModelFuncionario.get(i).getFuncNome(),
                listaModelFuncionario.get(i).getFuncEmail(),
                listaModelFuncionario.get(i).getFuncCpf(),
                listaModelFuncionario.get(i).getFuncData(),
                listaModelFuncionario.get(i).getFuncTelefone(),
                listaModelFuncionario.get(i).getFuncTelefone2(),
                listaModelFuncionario.get(i).getFuncSexo(),
                listaModelFuncionario.get(i).getFuncEndereco(),
                listaModelFuncionario.get(i).getFuncCidade(),
                listaModelFuncionario.get(i).getFuncEstado(),
                listaModelFuncionario.get(i).getFuncCep(),
                listaModelFuncionario.get(i).getFuncCargo(),
                listaModelFuncionario.get(i).getFuncTurno(),
                listaModelFuncionario.get(i).getFuncSalario(),
                listaModelFuncionario.get(i).getFuncUser(),                
                listaModelFuncionario.get(i).getFuncSituacao()
            });
        }
    }

    private void limpar() {
        nome.setText("");
        CPF.setText("");
        email.setText("");
        data.setDate(null);
        cel.setText("");
        tel.setText("");
        sexo.setSelectedItem(null);
        end.setText("");
        cidade.setText("");
        estado.setSelectedItem(null);
        CEP.setText("");
        car.setSelectedItem(null);
        tur.setSelectedItem(null);
        sala.setText("");
        user.setText("");
        sen.setText("");
    }

    private void campos(boolean condicao) {
        nome.setEnabled(condicao);
        CPF.setEnabled(condicao);
        email.setEnabled(condicao);
        data.setEnabled(condicao);
        cel.setEnabled(condicao);
        tel.setEnabled(condicao);
        sexo.setEnabled(condicao);
        end.setEnabled(condicao);
        cidade.setEnabled(condicao);
        estado.setEnabled(condicao);
        CEP.setEnabled(condicao);
        car.setEnabled(condicao);
        tur.setEnabled(condicao);
        sala.setEnabled(condicao);
        user.setEnabled(condicao);
        sen.setEnabled(condicao);
    }

    public void salvar() {
        modelFuncionario.setFuncNome(this.nome.getText());
        modelFuncionario.setFuncCpf(this.CPF.getText());
        modelFuncionario.setFuncEmail(this.email.getText());
        modelFuncionario.setFuncData(new java.sql.Date(this.data.getDate().getTime()));
        modelFuncionario.setFuncTelefone(this.cel.getText());
        modelFuncionario.setFuncTelefone2(this.tel.getText());
        modelFuncionario.setFuncSexo(this.sexo.getSelectedItem().toString());
        modelFuncionario.setFuncEndereco(this.end.getText());
        modelFuncionario.setFuncCidade(this.cidade.getText());
        modelFuncionario.setFuncEstado(this.estado.getSelectedItem().toString());
        modelFuncionario.setFuncCep(this.CEP.getText());
        modelFuncionario.setFuncCargo(this.car.getSelectedItem().toString());
        modelFuncionario.setFuncTurno(this.tur.getSelectedItem().toString());
        modelFuncionario.setFuncSalario(Double.parseDouble(this.sala.getText().replace(',', '.')));
        modelFuncionario.setFuncUser(this.user.getText());
        modelFuncionario.setFuncSenha(this.sen.getText());
        modelFuncionario.setFuncSituacao("Ativo");
        if (controllerFuncionario.salvarFuncionarioController(modelFuncionario) > 0) {
            JOptionPane.showMessageDialog(this, "Funcionário cadastrado com sucesso!", "Atenção", JOptionPane.WARNING_MESSAGE);
            this.carregarFuncionario();
            limpar();
            campos(false);
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar o funcinário!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }

        /*java.util.Date utilDate = data.getDate(); // Obtém a data do JDateChooser
    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); // Converte para java.sql.Date
    f.setData_nascimento_funcionario(sqlDate);
         */
    }

    public void alterar() {
        modelFuncionario.setFuncNome(this.nome.getText());
        modelFuncionario.setFuncCpf(this.CPF.getText());
        modelFuncionario.setFuncEmail(this.email.getText());
        modelFuncionario.setFuncData(new java.sql.Date(this.data.getDate().getTime()));
        modelFuncionario.setFuncTelefone(this.cel.getText());
        modelFuncionario.setFuncTelefone2(this.tel.getText());
        modelFuncionario.setFuncSexo(this.sexo.getSelectedItem().toString());
        modelFuncionario.setFuncEndereco(this.end.getText());
        modelFuncionario.setFuncCidade(this.cidade.getText());
        modelFuncionario.setFuncEstado(this.estado.getSelectedItem().toString());
        modelFuncionario.setFuncCep(this.CEP.getText());
        modelFuncionario.setFuncCargo(this.car.getSelectedItem().toString());
        modelFuncionario.setFuncTurno(this.tur.getSelectedItem().toString());
        modelFuncionario.setFuncSalario(Double.parseDouble(this.sala.getText().replace(',', '.')));
        modelFuncionario.setFuncUser(this.user.getText());
        modelFuncionario.setFuncSenha(this.sen.getText());       
        if (controllerFuncionario.atualizarFuncionarioController(modelFuncionario)) {
            JOptionPane.showMessageDialog(this, "Alterado com sucesso!", "Atenção", JOptionPane.WARNING_MESSAGE);
            this.carregarFuncionario();
            limpar();
            campos(false);
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao alterar!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        data = new com.toedter.calendar.JDateChooser();
        cel = new javax.swing.JFormattedTextField();
        end = new javax.swing.JTextField();
        CPF = new javax.swing.JFormattedTextField();
        tel = new javax.swing.JFormattedTextField();
        sexo = new javax.swing.JComboBox<>();
        car = new javax.swing.JComboBox<>();
        tur = new javax.swing.JComboBox<>();
        sala = new javax.swing.JFormattedTextField();
        sen = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        sal = new javax.swing.JButton();
        alt = new javax.swing.JButton();
        AtivoDesativo = new javax.swing.JButton();
        lim = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        pesq = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        JLabel9 = new javax.swing.JLabel();
        JLabel18 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cidade = new javax.swing.JTextField();
        CEP = new javax.swing.JFormattedTextField();
        user = new javax.swing.JTextField();
        estado = new javax.swing.JComboBox<>();
        novo = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 242, 190));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Funcionario");
        setToolTipText("");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/user.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(100, 100));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("Nome:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Email:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Data de Nascimento:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Celular:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Endereço:");
        jLabel5.setAutoscrolls(true);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Cargo:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel13.setText("Salário:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setText("CPF:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setText("Telefone:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setText("Sexo:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setText("Turno:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel14.setText("Senha:");

        nome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nome.setPreferredSize(new java.awt.Dimension(200, 27));

        email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        email.setPreferredSize(new java.awt.Dimension(200, 27));
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        data.setDateFormatString("dd/MM/yyyy"); // NOI18N
        data.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        data.setPreferredSize(new java.awt.Dimension(200, 27));

        try {
            cel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cel.setPreferredSize(new java.awt.Dimension(200, 25));

        end.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        end.setPreferredSize(new java.awt.Dimension(200, 25));
        end.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endActionPerformed(evt);
            }
        });

        try {
            CPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        CPF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CPF.setPreferredSize(new java.awt.Dimension(200, 25));

        try {
            tel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tel.setPreferredSize(new java.awt.Dimension(200, 25));

        sexo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feminino", "Masculino", "Outro" }));
        sexo.setSelectedIndex(-1);
        sexo.setPreferredSize(new java.awt.Dimension(200, 25));

        car.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        car.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gerente", "Caixa", "Estoquista", "Vendedor", "Serviços Gerais" }));
        car.setSelectedIndex(-1);
        car.setMinimumSize(new java.awt.Dimension(64, 22));
        car.setPreferredSize(new java.awt.Dimension(200, 25));

        tur.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tur.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manhã", "Tarde" }));
        tur.setSelectedIndex(-1);
        tur.setPreferredSize(new java.awt.Dimension(200, 25));

        sala.setPreferredSize(new java.awt.Dimension(200, 25));

        sen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sen.setPreferredSize(new java.awt.Dimension(200, 25));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Email", "CPF", "Nascimento", "Celular", "Telefone", "Sexo", "Endereço", "Cidade", "Estado", "CEP", "Cargo", "Turno", "Salário", "Usuário", "Situação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(12).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(13).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(14).setPreferredWidth(100);
        }

        sal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sal.setText("Salvar");
        sal.setMaximumSize(new java.awt.Dimension(74, 27));
        sal.setMinimumSize(new java.awt.Dimension(74, 27));
        sal.setPreferredSize(new java.awt.Dimension(74, 27));
        sal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salActionPerformed(evt);
            }
        });

        alt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        alt.setText("Alterar");
        alt.setMaximumSize(new java.awt.Dimension(74, 27));
        alt.setMinimumSize(new java.awt.Dimension(74, 27));
        alt.setPreferredSize(new java.awt.Dimension(74, 27));
        alt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altActionPerformed(evt);
            }
        });

        AtivoDesativo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AtivoDesativo.setText("Desativar/Ativar");
        AtivoDesativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtivoDesativoActionPerformed(evt);
            }
        });

        lim.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lim.setText("Limpar");
        lim.setMaximumSize(new java.awt.Dimension(74, 27));
        lim.setMinimumSize(new java.awt.Dimension(74, 27));
        lim.setPreferredSize(new java.awt.Dimension(74, 27));
        lim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setText("Pesquisa:");

        pesq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pesqKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setText("Cidade:");

        JLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        JLabel9.setText("Estado:");

        JLabel18.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        JLabel18.setText("CEP:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel16.setText("Nome de Usuário:");

        cidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cidade.setPreferredSize(new java.awt.Dimension(200, 25));

        try {
            CEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        CEP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CEP.setPreferredSize(new java.awt.Dimension(200, 25));

        user.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        user.setPreferredSize(new java.awt.Dimension(200, 25));

        estado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acre (AC)", "Alagoas (AL)", "Amapá (AP)", "Amazonas (AM)", "Bahia (BA)", "Ceará (CE)", "Distrito Federal (DF)", "Espírito Santo (ES)", "Goiás (GO)", "Maranhão (MA)", "Mato Grosso (MT)", "Mato Grosso do Sul (MS)", "Minas Gerais (MG)", "Pará (PA)", "Paraíba (PB)", "Paraná (PR)", "Pernambuco (PE)", "Piauí (PI)", "Rio de Janeiro (RJ)", "Rio Grande do Norte (RN)", "Rio Grande do Sul (RS)", "Rondônia (RO)", "Roraima (RR)", "Santa Catarina (SC)", "São Paulo (SP)", "Sergipe (SE)", "Tocantins (TO)" }));
        estado.setSelectedIndex(-1);
        estado.setMinimumSize(new java.awt.Dimension(64, 22));
        estado.setPreferredSize(new java.awt.Dimension(200, 25));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(data, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(23, 23, 23))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(23, 23, 23)))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(end, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(JLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CEP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(car, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tur, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sala, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(32, 32, 32))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(164, 164, 164)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(user, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(40, 40, 40))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pesq)
                        .addGap(6, 6, 6))
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(alt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lim, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(novo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AtivoDesativo)
                        .addGap(18, 18, 18)
                        .addComponent(sal, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CPF, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(car, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sen, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(end, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tur, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sala, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CEP, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(pesq, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AtivoDesativo)
                    .addComponent(lim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(novo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salActionPerformed
        if (salvarAlterar.equals("salvar")) {
            salvar();
        } else if (salvarAlterar.equals("alterar")) {
            alterar();
        }

    }//GEN-LAST:event_salActionPerformed

    private void altActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altActionPerformed
        salvarAlterar = "alterar";
        int linha = jTable1.getSelectedRow();
        try {
            int codigoFunci = (int) jTable1.getValueAt(linha, 0);
            modelFuncionario = controllerFuncionario.getFuncionarioController(codigoFunci);

            nome.setText(modelFuncionario.getFuncNome());
            CPF.setText(modelFuncionario.getFuncCpf());
            email.setText(modelFuncionario.getFuncEmail());
            data.setDate(modelFuncionario.getFuncData());
            cel.setText(modelFuncionario.getFuncTelefone());
            tel.setText(modelFuncionario.getFuncTelefone2());
            sexo.setSelectedItem(modelFuncionario.getFuncSexo());
            end.setText(modelFuncionario.getFuncEndereco());
            cidade.setText(modelFuncionario.getFuncCidade());
            estado.setSelectedItem(modelFuncionario.getFuncEstado());
            CEP.setText(modelFuncionario.getFuncCep());
            car.setSelectedItem(modelFuncionario.getFuncCargo());
            tur.setSelectedItem(modelFuncionario.getFuncTurno());
            sala.setText(String.valueOf(modelFuncionario.getFuncSalario()));
            user.setText(modelFuncionario.getFuncUser());
            sen.setText(modelFuncionario.getFuncSenha());
            campos(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Código inválido ou nenhum registro selecionado!", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_altActionPerformed

    private void AtivoDesativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtivoDesativoActionPerformed
       int linha = jTable1.getSelectedRow();
    if (linha >= 0) {
        int codigoFunci = (int) jTable1.getValueAt(linha, 0);

        // Obtenha o funcionário selecionado no jTable ou da maneira apropriada no seu contexto
        modelFuncionario = controllerFuncionario.getFuncionarioController(codigoFunci);

        // Verifique a situação atual do funcionário e defina a nova situação
        if ("Ativo".equals(modelFuncionario.getFuncSituacao())) {
            modelFuncionario.setFuncSituacao("Demitido");
            JOptionPane.showMessageDialog(this, "Funcionário demitido com sucesso!", "Aviso",JOptionPane.WARNING_MESSAGE);
        } else if ("Demitido".equals(modelFuncionario.getFuncSituacao())) {
            modelFuncionario.setFuncSituacao("Ativo");
            JOptionPane.showMessageDialog(this, "Funcionário recontratado com sucesso!", "Aviso",JOptionPane.WARNING_MESSAGE);
        }

        // Chame o método para atualizar a situação no banco de dados
        boolean sucesso = controllerFuncionario.alternarSituacaoFuncionarioController(modelFuncionario);

        if (sucesso) {
            // Atualize a tabela ou realize ações necessárias após a modificação no banco de dados
            carregarFuncionario();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar a situação do funcionário", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_AtivoDesativoActionPerformed

    private void limActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limActionPerformed
        limpar();
    }//GEN-LAST:event_limActionPerformed

    private void pesqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pesqKeyReleased
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> mode1 = new TableRowSorter<>(modelo);
        jTable1.setRowSorter(mode1);
        mode1.setRowFilter(RowFilter.regexFilter(pesq.getText()));

    }//GEN-LAST:event_pesqKeyReleased

    private void novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoActionPerformed
        campos(true);
        salvarAlterar = "salvar";
    }//GEN-LAST:event_novoActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        campos(false);
        limpar();
    }//GEN-LAST:event_cancelarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    }//GEN-LAST:event_jTable1MouseClicked

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void endActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_endActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AtivoDesativo;
    private javax.swing.JFormattedTextField CEP;
    private javax.swing.JFormattedTextField CPF;
    private javax.swing.JLabel JLabel18;
    private javax.swing.JLabel JLabel9;
    private javax.swing.JButton alt;
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox<String> car;
    private javax.swing.JFormattedTextField cel;
    private javax.swing.JTextField cidade;
    private com.toedter.calendar.JDateChooser data;
    private javax.swing.JTextField email;
    private javax.swing.JTextField end;
    private javax.swing.JComboBox<String> estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton lim;
    private javax.swing.JTextField nome;
    private javax.swing.JButton novo;
    private javax.swing.JTextField pesq;
    private javax.swing.JButton sal;
    private javax.swing.JFormattedTextField sala;
    private javax.swing.JTextField sen;
    private javax.swing.JComboBox<String> sexo;
    private javax.swing.JFormattedTextField tel;
    private javax.swing.JComboBox<String> tur;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
