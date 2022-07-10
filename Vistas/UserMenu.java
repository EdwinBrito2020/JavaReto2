package Vistas;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class UserMenu extends javax.swing.JFrame {
    Conexion con = new Conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    DefaultTableModel contenidoTabla;

    public UserMenu() {
        initComponents();
        listarEmpleados();
    }
//Metodo que lista los empleados de la base de datos
    public void listarEmpleados() {
        String nombre = txtBuscarEmp.getText();
        if (nombre.isEmpty()) {
            String queryConsulta = "SELECT * FROM empleados";
            try {
                cn = con.getConnection();
                //Creamos el queryConsulta
                st = cn.createStatement();
                // Ejecutamos el query que contiene la variable queryConsulta
                rs = st.executeQuery(queryConsulta);
                // Creamos un objeto que almacena todos los registros de empleados
                // que existen en la base de datos
                Object[] empleados = new Object[6];
                contenidoTabla = (DefaultTableModel) tblEmpleados.getModel();
                // Mientras el resultado del queryConsulta encuentre registros en la
                // base de datos se ingresa al while
                while (rs.next()) {
                    empleados[0] = rs.getInt("idEmpleado");
                    empleados[1] = rs.getString("nombreEmp");
                    empleados[2] = rs.getString("apellidos");
                    empleados[3] = rs.getString("tipoDocumento");
                    empleados[4] = rs.getString("documento");
                    empleados[5] = rs.getString("correo");
                    contenidoTabla.addRow(empleados);
                    System.out.println(rs.getInt("idEmpleado") + " "
                            + rs.getString("nombreEmp") + " " + rs.getString("apellidos"));
                }
                tblEmpleados.setModel(contenidoTabla);
            } catch (SQLException e) {
                System.out.println("Error");
            }
        } else {
            String queryConsulta = "SELECT * FROM empleados WHERE nombreEmp LIKE '%" + nombre + "%' OR apellidos LIKE '%" + nombre + "%';";
            try {
                cn = con.getConnection();
                //Creamos el queryConsulta
                st = cn.createStatement();
                // Ejecutamos el query que contiene la variable queryConsulta
                rs = st.executeQuery(queryConsulta);
                // Creamos un objeto que almacena todos los registros de empleados
                // que existen en la base de datos
                Object[] empleados = new Object[6];
                contenidoTabla = (DefaultTableModel) tblEmpleados.getModel();
                // Mientras el resultado del queryConsulta encuentre registros en la
                // base de datos se ingresa al while
                while (rs.next()) {
                    empleados[0] = rs.getInt("idEmpleado");
                    empleados[1] = rs.getString("nombreEmp");
                    empleados[2] = rs.getString("apellidos");
                    empleados[3] = rs.getString("tipoDocumento");
                    empleados[4] = rs.getString("documento");
                    empleados[5] = rs.getString("correo");
                    contenidoTabla.addRow(empleados);
                    System.out.println(rs.getInt("idEmpleado") + " "
                            + rs.getString("nombreEmp") + " " + rs.getString("apellidos"));
                }
                tblEmpleados.setModel(contenidoTabla);
            } catch (SQLException e) {
                System.out.println("Error");
            }
        }
    }   
    public void borrarDatosTabla() {
        for (int i = 0; i < tblEmpleados.getRowCount(); i++) {
            //Eliminamos todos los registros de empleados que tiene la tabla
            contenidoTabla.removeRow(i);
            i = i-1;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnAddUser = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtBuscarEmp = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombres", "Apellidos", "Tipo Documento", "Documento", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpleados);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assest/editUser.png"))); // NOI18N
        jButton1.setText("Editar");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assest/showUser.png"))); // NOI18N
        jButton2.setText("Ver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assest/deleteUser.png"))); // NOI18N
        jButton3.setText("Eliminar");

        btnAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assest/avatar.png"))); // NOI18N
        btnAddUser.setText("Nuevo");
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("MS PGothic", 1, 24)); // NOI18N
        jLabel1.setText("EMPLEADOS");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assest/logo.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Mision TIC 2022");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Buscar");

        txtBuscarEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarEmpActionPerformed(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assest/showUser.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(jButton2)
                .addGap(101, 101, 101)
                .addComponent(jButton1)
                .addGap(107, 107, 107)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(309, 309, 309)
                                .addComponent(jLabel1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(327, 327, 327)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(129, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 807, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(32, 32, 32)
                                .addComponent(txtBuscarEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(65, 65, 65))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addGap(46, 46, 46)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))
                            .addComponent(btnAddUser))
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtBuscarEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 497, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Empleados", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        AddUserForm addUserForm = new AddUserForm(this, rootPaneCheckingEnabled);
        addUserForm.setVisible(rootPaneCheckingEnabled);
        borrarDatosTabla();
        listarEmpleados();

    }//GEN-LAST:event_btnAddUserActionPerformed

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
        // Edwin Brito
        int nroFila = tblEmpleados.getSelectedRow();
        System.out.println(nroFila);
        String empleadoBuscar = txtBuscarEmp.getText();
        if(empleadoBuscar.isEmpty()) {
            int IdEmp = Integer.parseInt(tblEmpleados.getValueAt(nroFila, 0).toString());
            String nombreEmp = tblEmpleados.getValueAt(nroFila,1).toString();
            String apellidos = tblEmpleados.getValueAt(nroFila,2).toString();
            String tipoDocumento = tblEmpleados.getValueAt(nroFila,3).toString();
            String documento = tblEmpleados.getValueAt(nroFila,4).toString();
            String correo = tblEmpleados.getValueAt(nroFila,5).toString();
            System.out.println("IdEmp: "+ IdEmp+ " nombre: "+ nombreEmp + " " + apellidos
                + ", documento " + tipoDocumento+ " "+ documento + ", email: "+ correo );
            ShowUserForm showUserForm = new ShowUserForm(this, true);
            showUserForm.recibeDatosUserMenu(IdEmp, nombreEmp, apellidos, tipoDocumento, documento, correo);
            showUserForm.setVisible(true);      
            borrarDatosTabla();
            listarEmpleados();
        }else{
            empleadoBuscar = txtBuscarEmp.getText();
        }
    }//GEN-LAST:event_tblEmpleadosMouseClicked

    private void txtBuscarEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarEmpActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        borrarDatosTabla();
        listarEmpleados();
        
        /*String nombre = txtBuscarEmp.getText();    
        ShowUserForm showUserForm = new ShowUserForm(this, true);
        showUserForm.setVisible(true);
        String query = "SELECT * FROM empleados WHERE nombreEmp = '"+ nombre +"' OR apellidos = '"+ nombre +"';";
        */        
    }//GEN-LAST:event_btnSearchActionPerformed

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
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtBuscarEmp;
    // End of variables declaration//GEN-END:variables
}
