/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import javax.swing.JOptionPane;
import DAO.*;
import GUI.Menu;
import controller.ControllerFuncionario;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import model.ModelFuncionario;

import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author Carlos
 */
public class Login extends javax.swing.JFrame {

    ControllerFuncionario controllerFuncionario = new ControllerFuncionario();
    ModelFuncionario modelFuncionario = new ModelFuncionario();

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    private static final Logger LOGGER = Logger.getLogger(Login.class.getName());

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entrar = new javax.swing.JButton();
        sair = new javax.swing.JButton();
        usuario = new javax.swing.JTextField();
        senha = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        entrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        entrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/door_in.png"))); // NOI18N
        entrar.setText("Entrar");
        entrar.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(51, 255, 51), null));
        entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarActionPerformed(evt);
            }
        });

        sair.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/door_out.png"))); // NOI18N
        sair.setText("Sair");
        sair.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 0, 51), null));
        sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sairMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 188, 210));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, null));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/enter.png"))); // NOI18N
        jLabel2.setText("LOGIN");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel2.setFocusable(false);
        jLabel2.setIconTextGap(5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(127, 127, 127))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Usuário:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Senha:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(entrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void sairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseClicked
        System.exit(0);
    }//GEN-LAST:event_sairMouseClicked

    private void entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarActionPerformed
        String nome = usuario.getText();
        String senh = senha.getText();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            try ( Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/bdteste", "root", "");  Statement stmt = (Statement) con.createStatement()) {

                String query = "select * from tbl_funcionario where func_User = '" + nome + "' and func_Senha = '" + senh + "'";
                try ( ResultSet rs = stmt.executeQuery(query)) {
                    if (rs.next()) {
                        String situacao = rs.getString("func_Situacao");
                        if (situacao.equals("Ativo")) {
                            JOptionPane.showMessageDialog(null, "Conectado com sucesso");
                            Menu s = new Menu();
                            s.setVisible(true);

                            String cargo = rs.getString("func_Cargo");
                            if (cargo.equals("Gerente")) {
                                Menu.lblusuario.setText(rs.getString(2));
                                this.dispose();
                            } else if (cargo.equals("Caixa")) {
                                Menu.Estoque.setVisible(false);
                                Menu.Funcionario.setVisible(false);
                                Menu.Produto.setVisible(false);
                                Menu.lblusuario.setText(rs.getString(2));
                                this.dispose();
                            } else if (cargo.equals("Estoquista")) {
                                Menu.cli.setVisible(false);
                                Menu.Produto.setVisible(false);
                                Menu.Funcionario.setVisible(false);
                                Menu.venda.setVisible(false);
                                Menu.lblusuario.setText(rs.getString(2));
                                this.dispose();
                            }
                        } else if (situacao.equals("Demitido")) {
                            JOptionPane.showMessageDialog(this, "O Funcionário não tem mais acesso ao sistema.", "Atenção", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_entrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton entrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton sair;
    private javax.swing.JPasswordField senha;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
/*String nome = usuario.getText();
        String senh = senha.getText();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            try ( Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/bdteste", "root", "");  Statement stmt = (Statement) con.createStatement()) {

                String query = "select * from tbl_funcionario where func_User = '" + nome + "' and func_Senha = '" + senh + "'";
                try ( ResultSet rs = stmt.executeQuery(query)) {
                    if (rs.next()) {
                        String situacao = rs.getString("func_Situacao");
                        if (situacao.equals("Ativo")) {
                            JOptionPane.showMessageDialog(null, "Conectado com sucesso");
                            Menu s = new Menu();
                            s.setVisible(true);

                            String cargo = rs.getString("func_Cargo");
                            if (cargo.equals("Gerente")) {

                                Menu.lblusuario.setText(rs.getString(18));
                                this.dispose();
                            } else if (cargo.equals("Caixa")) {
                                Menu.Estoque.setVisible(false);
                                Menu.Funcionario.setVisible(false);
                                Menu.Produto.setVisible(false);
                                Menu.lblusuario.setText(rs.getString(18));
                                this.dispose();

                            } else if (cargo.equals("Estoquista")) {
                                Menu.cli.setVisible(false);
                                Menu.Produto.setVisible(false);
                                Menu.Funcionario.setVisible(false);
                                Menu.Venda.setVisible(false);
                                Menu.lblusuario.setText(rs.getString(18));
                                this.dispose();
                            }

                        } else if (situacao.equals("Demitido")) {
                            JOptionPane.showMessageDialog(this, "O Funcionário não tem mais acesso ao sistema.", "Atenção", JOptionPane.WARNING_MESSAGE);
                        }

                    }
                } catch (Exception ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }*/

 /*modelFuncionario.setFuncUser(usuario.getText());
        modelFuncionario.setFuncSenha(senha.getText());

        if (controllerFuncionario.getValidarFuncionarioController(modelFuncionario)) {
            // Validação bem-sucedida

            String situacao = modelFuncionario.getFuncSituacao();

            if ("Ativo".equals(situacao)) {
                // Funcionário está ativo, continue
                JOptionPane.showMessageDialog(this, "Conectado com sucesso");

                // Obtenha informações adicionais, como cargo, se necessário
                String cargo = modelFuncionario.getFuncCargo();

                // Crie uma instância da classe Menu dentro de um bloco try-catch
                try {
                    Menu s = new Menu();
                    s.setVisible(true);

                    if ("Gerente".equals(cargo)) {
                        // Configure a interface para o cargo de Gerente
                        Menu.lblusuario.setText(modelFuncionario.getFuncNome());
                    } else if ("Caixa".equals(cargo)) {
                        // Configure a interface para o cargo de Caixa
                        Menu.Estoque.setVisible(false);
                        Menu.Funcionario.setVisible(false);
                        Menu.Produto.setVisible(false);
                        Menu.lblusuario.setText(modelFuncionario.getFuncNome());
                    } else if ("Estoquista".equals(cargo)) {
                        // Configure a interface para o cargo de Estoquista
                        Menu.cli.setVisible(false);
                        Menu.Produto.setVisible(false);
                        Menu.Funcionario.setVisible(false);
                        Menu.Venda.setVisible(false);
                        Menu.lblusuario.setText(modelFuncionario.getFuncNome());
                    }

                    this.dispose(); // Feche a janela de login
                } catch (PropertyVetoException ex) {
                    // Lidar com a exceção

                }
            } else if ("Demitido".equals(situacao)) {
                // Funcionário foi demitido, exiba a mensagem
                JOptionPane.showMessageDialog(this, "Funcionário não tem mais acesso ao sistema!");
            }
        } else {
            // Validação malsucedida

            JOptionPane.showMessageDialog(this, "Credenciais inválidas", "Erro", JOptionPane.ERROR_MESSAGE);
        }*/
