/*
 *    Creado por:                   Hernández Paredes Denis Alin
 *    Fecha:                        25/03/2011, 10:56:54 AM
 *    Descripción:                  Controlador : "clsAltaUsuario.java" Forma para la alta de un nuevo usuario en el sistema.
 *    Responsable:                  Carlos Altamirano
 */
package GestionUsuarios;

import javax.swing.*;
import java.util.Vector;
import Common.clsILookAndFeel;
import Common.EnvioMail;

public class clsAltaUsuarios extends javax.swing.JFrame {

    //Creamos una intancia del modelo para gestionar las consultas a la BD
    clsModelo c = new clsModelo();
    String clave_contrato = "";
    String verificaUsuario = "";

    /** Creates new form clsAltaUsuarios */
    public clsAltaUsuarios() {
        initComponents();
        Limpia();
        this.jComboBox.grabFocus();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar2 = new javax.swing.JToolBar();
        milblTitulo = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        mitxtClaveCliente = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        mitxtUsuario = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton = new javax.swing.JButton();
        jComboBox = new javax.swing.JComboBox();
        miPassword = new javax.swing.JPasswordField();
        jLabel15 = new javax.swing.JLabel();
        mitxtCorreo = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        mitxtTelefonoContacto = new javax.swing.JTextField();
        mitxtNombreUsuario = new javax.swing.JTextField();
        miTextFidei = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alta de un Nuevo Usuario en el Sistema de Liquidaciones");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        getContentPane().setLayout(null);

        jToolBar2.setBackground(new java.awt.Color(202, 227, 127));
        jToolBar2.setFloatable(false);
        jToolBar2.setForeground(new java.awt.Color(0, 0, 102));
        jToolBar2.setRollover(true);
        jToolBar2.setMinimumSize(new java.awt.Dimension(200, 47));
        jToolBar2.setPreferredSize(new java.awt.Dimension(500, 47));
        getContentPane().add(jToolBar2);
        jToolBar2.setBounds(0, 0, 600, 40);

        milblTitulo.setBackground(new java.awt.Color(0, 51, 153));
        milblTitulo.setFont(new java.awt.Font("Trebuchet MS", 0, 21));
        milblTitulo.setForeground(new java.awt.Color(47, 113, 148));
        milblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        milblTitulo.setText("ALTA DE UN NUEVO USUARIO ");
        getContentPane().add(milblTitulo);
        milblTitulo.setBounds(0, 60, 600, 30);

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 14));
        jLabel11.setText("Clave Fideicomiso:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(40, 110, 140, 30);

        mitxtClaveCliente.setEditable(false);
        mitxtClaveCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitxtClaveClienteActionPerformed(evt);
            }
        });
        getContentPane().add(mitxtClaveCliente);
        mitxtClaveCliente.setBounds(180, 170, 200, 30);

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 14));
        jLabel12.setText("Usuario:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(40, 260, 140, 30);

        mitxtUsuario.setFont(new java.awt.Font("Tahoma", 1, 14));
        mitxtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitxtUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(mitxtUsuario);
        mitxtUsuario.setBounds(180, 260, 200, 30);

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 14));
        jLabel13.setText("Password:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(40, 290, 140, 30);

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 14));
        jLabel14.setText("Teléfono Contacto:");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(40, 230, 140, 30);

        jButton.setText("Crear");
        jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActionPerformed(evt);
            }
        });
        jButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonKeyPressed(evt);
            }
        });
        getContentPane().add(jButton);
        jButton.setBounds(230, 380, 80, 23);

        jComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox);
        jComboBox.setBounds(180, 110, 200, 30);

        miPassword.setEditable(false);
        miPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(miPassword);
        miPassword.setBounds(180, 290, 200, 30);

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 14));
        jLabel15.setText("Correo Electrónico:");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(40, 320, 140, 30);

        mitxtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitxtCorreoActionPerformed(evt);
            }
        });
        getContentPane().add(mitxtCorreo);
        mitxtCorreo.setBounds(180, 320, 280, 30);

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 14));
        jLabel16.setText("Clave de Cliente:");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(40, 170, 140, 30);

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 14));
        jLabel17.setText("Nombre de Usuario:");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(40, 200, 140, 30);

        mitxtTelefonoContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitxtTelefonoContactoActionPerformed(evt);
            }
        });
        getContentPane().add(mitxtTelefonoContacto);
        mitxtTelefonoContacto.setBounds(180, 230, 280, 30);

        mitxtNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitxtNombreUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(mitxtNombreUsuario);
        mitxtNombreUsuario.setBounds(180, 200, 380, 30);

        miTextFidei.setEditable(false);
        miTextFidei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miTextFideiActionPerformed(evt);
            }
        });
        getContentPane().add(miTextFidei);
        miTextFidei.setBounds(180, 140, 380, 30);

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 14));
        jLabel18.setText("Fideicomitente:");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(40, 140, 140, 30);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-610)/2, (screenSize.height-470)/2, 610, 470);
    }// </editor-fold>//GEN-END:initComponents

    public void Limpia() {
        Vector clientes = c.getClientes();
        if (clientes != null) {
            this.jComboBox.setModel(new DefaultComboBoxModel(clientes));
            clave_contrato = "";
            verificaUsuario = "A";
            miTextFidei.setText("");
            mitxtClaveCliente.setText("");
            mitxtClaveCliente.setEnabled(false);
            mitxtUsuario.setText("");
            mitxtNombreUsuario.setText("");
            mitxtTelefonoContacto.setText("");
            miPassword.setText("");
            mitxtCorreo.setText("");
        } else {
            clientes = new Vector();
            JOptionPane.showMessageDialog(this, " Error al obtener Fideicomitentes, consulte a su Administrador ", "Error", JOptionPane.ERROR_MESSAGE);
            this.jComboBox.setModel(new DefaultComboBoxModel(clientes));
            clave_contrato = "";
            verificaUsuario = "A";
            mitxtClaveCliente.setText("");
            mitxtClaveCliente.setEnabled(false);
            mitxtUsuario.setText("");
            mitxtNombreUsuario.setText("");
            mitxtTelefonoContacto.setText("");
            miPassword.setText("");
            mitxtCorreo.setText("");
        }

    }

    private void mitxtClaveClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitxtClaveClienteActionPerformed
}//GEN-LAST:event_mitxtClaveClienteActionPerformed

    private void mitxtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitxtUsuarioActionPerformed
        String usuario = this.mitxtUsuario.getText().toString().trim();
        verificaUsuario = "";
        if (usuario.length() < 8) {
            JOptionPane.showMessageDialog(this, " Favor de introducir un nombre de usuario de al menos 8 caracteres ", "Alerta", JOptionPane.WARNING_MESSAGE);
            this.mitxtUsuario.grabFocus();
        } else {
            verificaUsuario = clsModelo.verificaUsuario(usuario, this.clave_contrato);

            if (verificaUsuario.equals("")) {
                this.miPassword.setText(c.generaPassword());
                this.mitxtCorreo.setText("");
                this.mitxtCorreo.grabFocus();
            } else {
                if (verificaUsuario.equals("Error")) {
                    JOptionPane.showMessageDialog(this, " Error al verificar existencia de usuario, consulte a su administrador ", "Error", JOptionPane.ERROR_MESSAGE);
                    this.mitxtUsuario.setText("");
                    this.miPassword.setText("");
                    this.mitxtCorreo.setText("");
                    this.mitxtUsuario.grabFocus();
                } else {
                    JOptionPane.showMessageDialog(this, " El usuario ya existe para este fideicomitente, favor de verificar", "Alerta", JOptionPane.WARNING_MESSAGE);
                    this.miPassword.setText("");
                    this.mitxtCorreo.setText("");
                    this.mitxtUsuario.grabFocus();
                }
            }
        }
    }//GEN-LAST:event_mitxtUsuarioActionPerformed

    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        this.dispose();
    }//GEN-LAST:event_exitForm

    private void jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActionPerformed
        try {
            clave_contrato = this.jComboBox.getSelectedItem().toString();
            String nombre_cliente = this.miTextFidei.getText().toString().trim();
            String clave_cliente = this.mitxtClaveCliente.getText().toString().trim();
            String nombre_usuario = this.mitxtNombreUsuario.getText().toString().trim();
            String telefono_contacto = this.mitxtTelefonoContacto.getText().toString().trim();
            String usuario = this.mitxtUsuario.getText().toString().trim();
            String password = this.miPassword.getText().toString().trim();
            String correo = this.mitxtCorreo.getText().toString().trim();

            String asunto = "";
            String lstrBody = "";
            boolean seGuardo = false;
            boolean envia = false;

            if (!clave_contrato.equals("") && !clave_contrato.equals(" -----Seleccione----- ") && !nombre_cliente.equals("")
                    && !clave_cliente.equals("") && !nombre_usuario.equals("") && !telefono_contacto.equals("")
                    && !usuario.equals("") && !password.equals("") && !correo.equals("")) {

                if (usuario.length() >= 8) {
                    verificaUsuario = clsModelo.verificaUsuario(usuario, clave_contrato);
                    if (verificaUsuario.equals("")) {
                        if (correo.contains("@")) {
                            seGuardo = c.guardaDatos(clave_contrato, clave_cliente, nombre_usuario, telefono_contacto, usuario, password, correo, verificaUsuario);
                            if (seGuardo) {
                                asunto = "Bienvenido al Sistema de Liquidaciones";

                                lstrBody = c.getBody(clave_contrato, clave_cliente, nombre_cliente, nombre_usuario, telefono_contacto, usuario, password, correo);

                                envia = EnvioMail.enviaCorreo("liquidaciones@fideicomisogds.mx", correo, asunto, lstrBody);
                                if (envia) {
                                    JOptionPane.showMessageDialog(this, " Proceso realizado correctamente ", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    Limpia();
                                    this.jComboBox.grabFocus();

                                } else {
                                    JOptionPane.showMessageDialog(this, " Error enviando correo electrónico ", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    Limpia();
                                    this.jComboBox.grabFocus();
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, " Error almacenando información, favor de consultar a su Administrador ", "Error", JOptionPane.ERROR_MESSAGE);
                                Limpia();
                                this.jComboBox.grabFocus();
                            }

                        } else {
                            this.mitxtCorreo.setText("");
                            this.mitxtCorreo.grabFocus();
                            JOptionPane.showMessageDialog(this, "Correo electrónico inválido, favor de verificar", "Alerta", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        if (verificaUsuario.equals("Error")) {
                            JOptionPane.showMessageDialog(this, " Error verificando usuario, consulte a su administrador", "Error", JOptionPane.WARNING_MESSAGE);
                            this.mitxtUsuario.grabFocus();
                        } else {
                            JOptionPane.showMessageDialog(this, " El usuario existe para este fideicomitente, favor de verificar", "Alerta", JOptionPane.WARNING_MESSAGE);
                            this.mitxtUsuario.grabFocus();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, " Favor de especificar nombre de usuario de al menos 8 caracteres ", "Error", JOptionPane.WARNING_MESSAGE);
                    this.mitxtUsuario.grabFocus();
                }
            } else {
                JOptionPane.showMessageDialog(this, " Favor de capturar información restante ", "Alerta", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, " Favor de capturar información restante ", "Información", JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_jButtonActionPerformed

    private void jComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxActionPerformed

        clave_contrato = this.jComboBox.getSelectedItem().toString();
        String nombre_fideicomitente = "";
        try {
            if (!clave_contrato.equals(" -----Seleccione----- ")) {
                nombre_fideicomitente = (String) c.getFideicomitente(clave_contrato);
                if (!clave_contrato.equals("")) {
                    this.miTextFidei.setText(nombre_fideicomitente);
                    this.mitxtClaveCliente.setText(clave_contrato.substring(0, 9));
                    this.mitxtNombreUsuario.setText("");
                    this.mitxtTelefonoContacto.setText("");
                    this.mitxtUsuario.setText("");
                    this.miPassword.setText("");
                    this.mitxtCorreo.setText("");
                    this.mitxtNombreUsuario.grabFocus();
                } else {
                    JOptionPane.showMessageDialog(this, " Error al obtener clave de fideicomiso ", "Error", JOptionPane.ERROR_MESSAGE);
                    Limpia();
                    this.jComboBox.grabFocus();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, " Error, consulte a su administrador ", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jComboBoxActionPerformed

    private void jButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonKeyPressed
        try {
            clave_contrato = this.jComboBox.getSelectedItem().toString();
            String nombre_cliente = this.miTextFidei.getText().toString().trim();
            String clave_cliente = this.mitxtClaveCliente.getText().toString().trim();
            String nombre_usuario = this.mitxtNombreUsuario.getText().toString().trim();
            String telefono_contacto = this.mitxtTelefonoContacto.getText().toString().trim();
            String usuario = this.mitxtUsuario.getText().toString().trim();
            String password = this.miPassword.getText().toString().trim();
            String correo = this.mitxtCorreo.getText().toString().trim();

            String asunto = "";
            String lstrBody = "";
            boolean seGuardo = false;
            boolean envia = false;

            if (!clave_contrato.equals("") && !clave_contrato.equals(" -----Seleccione----- ") && !nombre_cliente.equals("")
                    && !clave_cliente.equals("") && !nombre_usuario.equals("") && !telefono_contacto.equals("")
                    && !usuario.equals("") && !password.equals("") && !correo.equals("")) {

                if (usuario.length() >= 8) {
                    verificaUsuario = clsModelo.verificaUsuario(usuario, clave_contrato);
                    if (verificaUsuario.equals("")) {
                        if (correo.contains("@")) {
                            seGuardo = c.guardaDatos(clave_contrato, clave_cliente, nombre_usuario, telefono_contacto, usuario, password, correo, verificaUsuario);
                            if (seGuardo) {
                                asunto = "Bienvenido al Sistema de Liquidaciones";

                                lstrBody = c.getBody(clave_contrato, clave_cliente, nombre_cliente, nombre_usuario, telefono_contacto, usuario, password, correo);

                                envia = EnvioMail.enviaCorreo("liquidaciones@fideicomisogds.mx", correo, asunto, lstrBody);
                                if (envia) {
                                    JOptionPane.showMessageDialog(this, " Proceso realizado correctamente ", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    Limpia();
                                    this.jComboBox.grabFocus();

                                } else {
                                    JOptionPane.showMessageDialog(this, " Error enviando correo electrónico ", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    Limpia();
                                    this.jComboBox.grabFocus();
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, " Error almacenando información, favor de consultar a su Administrador ", "Error", JOptionPane.ERROR_MESSAGE);
                                Limpia();
                                this.jComboBox.grabFocus();
                            }

                        } else {
                            this.mitxtCorreo.setText("");
                            this.mitxtCorreo.grabFocus();
                            JOptionPane.showMessageDialog(this, "Correo electrónico inválido, favor de verificar", "Alerta", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        if (verificaUsuario.equals("Error")) {
                            JOptionPane.showMessageDialog(this, " Error verificando usuario, consulte a su administrador", "Error", JOptionPane.WARNING_MESSAGE);
                            this.mitxtUsuario.grabFocus();
                        } else {
                            JOptionPane.showMessageDialog(this, " El usuario existe para este fideicomitente, favor de verificar", "Alerta", JOptionPane.WARNING_MESSAGE);
                            this.mitxtUsuario.grabFocus();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, " Favor de especificar nombre de usuario de al menos 8 caracteres ", "Error", JOptionPane.WARNING_MESSAGE);
                    this.mitxtUsuario.grabFocus();
                }
            } else {
                JOptionPane.showMessageDialog(this, " Favor de capturar información restante ", "Alerta", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, " Favor de capturar información restante ", "Información", JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_jButtonKeyPressed

    private void miPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPasswordActionPerformed
    }//GEN-LAST:event_miPasswordActionPerformed

    private void mitxtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitxtCorreoActionPerformed
        try {
            String correo = this.mitxtCorreo.getText().toString().trim();
            if (!correo.equals("")) {
                if (!correo.contains("@")) {
                    this.mitxtCorreo.setText("");
                    this.mitxtCorreo.grabFocus();
                    JOptionPane.showMessageDialog(this, "Correo electrónico inválido, favor de verificar", "Alerta", JOptionPane.WARNING_MESSAGE);
                } else {
                    this.jButton.grabFocus();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Correo electrónico obligatorio, favor de especificar", "Alerta", JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Correo electrónico obligatorio, favor de especificar", "Alerta", JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_mitxtCorreoActionPerformed

    private void mitxtNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitxtNombreUsuarioActionPerformed
        try {
            String nombre_usuario = this.mitxtNombreUsuario.getText().toString().trim();
            if (!nombre_usuario.equals("")) {
                this.mitxtTelefonoContacto.grabFocus();
            } else {
                JOptionPane.showMessageDialog(this, "El nombre completo de usuario es obligatorio", "Alerta", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "El nombre completo de usuario es obligatorio", "Alerta", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_mitxtNombreUsuarioActionPerformed

    private void mitxtTelefonoContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitxtTelefonoContactoActionPerformed
        try {
            String puesto_usuario = this.mitxtTelefonoContacto.getText().toString().trim();
            if (!puesto_usuario.equals("")) {
                this.mitxtUsuario.grabFocus();
            } else {
                JOptionPane.showMessageDialog(this, "El teléfono del contacto es obligatorio", "Alerta", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error estableciendo el teléfono de contacto", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_mitxtTelefonoContactoActionPerformed

    private void miTextFideiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miTextFideiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miTextFideiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                clsILookAndFeel.setSystemLookAndFell();
                new clsAltaUsuarios().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton;
    private javax.swing.JComboBox jComboBox;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JPasswordField miPassword;
    private javax.swing.JTextField miTextFidei;
    private javax.swing.JLabel milblTitulo;
    private javax.swing.JTextField mitxtClaveCliente;
    private javax.swing.JTextField mitxtCorreo;
    private javax.swing.JTextField mitxtNombreUsuario;
    private javax.swing.JTextField mitxtTelefonoContacto;
    private javax.swing.JTextField mitxtUsuario;
    // End of variables declaration//GEN-END:variables
}
