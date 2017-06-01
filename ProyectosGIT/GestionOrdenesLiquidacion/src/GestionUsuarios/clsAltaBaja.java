/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * clsAltaBaja.java
 *
 * Created on 1/11/2011, 11:01:38 AM
 */
package GestionUsuarios;

import javax.swing.*;
import java.util.Vector;
import Common.clsILookAndFeel;

/**
 *
 * @author SISTEMASGP
 */
public class clsAltaBaja extends javax.swing.JFrame {

    public String clave_contrato = "";
    clsModelo c = new clsModelo();

    /** Creates new form clsAltaBaja */
    public clsAltaBaja() {
        clave_contrato = "";
        initComponents();
        Limpia();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        milblTitulo = new javax.swing.JLabel();
        jToolBar2 = new javax.swing.JToolBar();
        jLabel11 = new javax.swing.JLabel();
        miComboBoxFidei = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        miComboBoxUsuario = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        miPassword = new javax.swing.JPasswordField();
        jLabel14 = new javax.swing.JLabel();
        miPasswordRe = new javax.swing.JPasswordField();
        miButtonAlta = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        fechaBloqueo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alta de Cuenta Bloqueda en Sistema");
        getContentPane().setLayout(null);

        milblTitulo.setBackground(new java.awt.Color(0, 51, 153));
        milblTitulo.setFont(new java.awt.Font("Trebuchet MS", 0, 21));
        milblTitulo.setForeground(new java.awt.Color(47, 113, 148));
        milblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        milblTitulo.setText(" ALTA DE CUENTA BLOQUEADA");
        getContentPane().add(milblTitulo);
        milblTitulo.setBounds(0, 70, 540, 30);

        jToolBar2.setBackground(new java.awt.Color(202, 227, 127));
        jToolBar2.setFloatable(false);
        jToolBar2.setForeground(new java.awt.Color(0, 0, 102));
        jToolBar2.setRollover(true);
        jToolBar2.setMinimumSize(new java.awt.Dimension(200, 47));
        jToolBar2.setPreferredSize(new java.awt.Dimension(500, 47));
        getContentPane().add(jToolBar2);
        jToolBar2.setBounds(0, 0, 540, 40);

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 14));
        jLabel11.setText("Fideicomitente");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(20, 120, 110, 30);

        miComboBoxFidei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miComboBoxFideiActionPerformed(evt);
            }
        });
        getContentPane().add(miComboBoxFidei);
        miComboBoxFidei.setBounds(130, 120, 380, 30);

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 14));
        jLabel12.setText("Usuario:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(20, 150, 110, 30);

        miComboBoxUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miComboBoxUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(miComboBoxUsuario);
        miComboBoxUsuario.setBounds(130, 150, 200, 30);

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 14));
        jLabel13.setText("Bloqueo:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(20, 180, 110, 30);

        miPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(miPassword);
        miPassword.setBounds(130, 210, 200, 30);

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 14));
        jLabel14.setText("Re-Password:");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(20, 240, 110, 30);

        miPasswordRe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPasswordReActionPerformed(evt);
            }
        });
        getContentPane().add(miPasswordRe);
        miPasswordRe.setBounds(130, 240, 200, 30);

        miButtonAlta.setText("Alta");
        miButtonAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miButtonAltaActionPerformed(evt);
            }
        });
        miButtonAlta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                miButtonAltaKeyPressed(evt);
            }
        });
        getContentPane().add(miButtonAlta);
        miButtonAlta.setBounds(230, 300, 80, 23);

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 14));
        jLabel15.setText("Password:");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(20, 210, 110, 30);

        fechaBloqueo.setEditable(false);
        getContentPane().add(fechaBloqueo);
        fechaBloqueo.setBounds(130, 180, 200, 30);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-556)/2, (screenSize.height-395)/2, 556, 395);
    }// </editor-fold>//GEN-END:initComponents

    public void Limpia() {
        Vector clientes = c.getClientesBaja();
        if (clientes != null) {
            this.miComboBoxFidei.setModel(new DefaultComboBoxModel(clientes));
            clientes = new Vector();
            this.miComboBoxUsuario.setModel(new DefaultComboBoxModel(clientes));
            this.fechaBloqueo.setText("");
            miPassword.setText("");
            miPasswordRe.setText("");
            this.miComboBoxFidei.grabFocus();
        } else {
            clientes = new Vector();
            JOptionPane.showMessageDialog(this, " Error al obtener Fideicomitentes, consulte a su Administrador ", "Error", JOptionPane.ERROR_MESSAGE);
            this.miComboBoxFidei.setModel(new DefaultComboBoxModel(clientes));
            this.miComboBoxUsuario.setModel(new DefaultComboBoxModel(clientes));
            this.fechaBloqueo.setText("");
            miPassword.setText("");
            miPasswordRe.setText("");
            this.miComboBoxFidei.grabFocus();
        }
    }

    private void miComboBoxFideiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miComboBoxFideiActionPerformed

        String nombre_cliente = this.miComboBoxFidei.getSelectedItem().toString();
        Vector usuarios = new Vector();
        String idx_fiso = "";
        int idx = 0;

        if (nombre_cliente.equals("   -------------------------Selecciona Fideicomitente-------------------------   ")) {
            JOptionPane.showMessageDialog(this, " Fideicomitente inválido, favor de verificar ", "Alerta", JOptionPane.WARNING_MESSAGE);
            Limpia();
            this.miComboBoxFidei.grabFocus();
        } else {
            try {
                // Obtenemos la clave del Fideicomiso.
                idx = nombre_cliente.indexOf(".-");
                idx_fiso = nombre_cliente.substring(0, idx).toString().trim();
                idx = Integer.parseInt(idx_fiso);
                clave_contrato = (String) c.bajaClaveFiso.get(idx - 1);
                // Obtenemos los usuarios dados de baja en el sistema de liquidaciones.
                usuarios = c.getUsuariosBloqueados(clave_contrato);
                //Verificamos si ocurrio algún error.
                if (usuarios != null) {
                    this.miComboBoxUsuario.setModel(new DefaultComboBoxModel(usuarios));
                    this.fechaBloqueo.setText("");
                    this.miPassword.setText("");
                    this.miPasswordRe.setText("");
                    this.miComboBoxUsuario.grabFocus();
                } else {
                    JOptionPane.showMessageDialog(this, " Error al obtener usuarios dados de Baja ", "Error", JOptionPane.ERROR_MESSAGE);
                    Limpia();
                    this.miComboBoxFidei.grabFocus();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, " Error, consulte a su Administrador ", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
}//GEN-LAST:event_miComboBoxFideiActionPerformed

    private void miComboBoxUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miComboBoxUsuarioActionPerformed
        String usuario = this.miComboBoxUsuario.getSelectedItem().toString();
        String fecha_bloqueo = "";


        if (usuario.equals("   -------Selecciona Usuario--------   ")) {
            JOptionPane.showMessageDialog(this, " Usuario inválido, favor de verificar ", "Alerta", JOptionPane.WARNING_MESSAGE);
            this.fechaBloqueo.setText(fecha_bloqueo);
            this.miPassword.setText("");
            this.miPasswordRe.setText("");
            this.miComboBoxUsuario.grabFocus();
        } else {
            fecha_bloqueo = c.getFechaBloqueo(clave_contrato, usuario);

            this.fechaBloqueo.setText(fecha_bloqueo);
            this.miPassword.setText("");
            this.miPasswordRe.setText("");
            this.miPassword.grabFocus();

        }
    }//GEN-LAST:event_miComboBoxUsuarioActionPerformed

    private void miButtonAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miButtonAltaActionPerformed
        try {
            String fideicomitente = this.miComboBoxFidei.getSelectedItem().toString();
            String usuario = this.miComboBoxUsuario.getSelectedItem().toString();
            String password = this.miPassword.getText().toString().trim();
            String passwordRe = this.miPasswordRe.getText().toString().trim();
            String clave_cliente = "";
            boolean seGuardo = false;

            if (!fideicomitente.equals("   -------------------------Selecciona Fideicomitente-------------------------   ")
                    && !usuario.equals("   -------Selecciona Usuario--------   ") && !clave_contrato.equals("")
                    && !password.equals("") && !passwordRe.equals("")) {

                if (password.equals(passwordRe)) {
                    if (password.length() > 7) {
                        clave_cliente = this.clave_contrato.substring(0, 9);
//                        seGuardo = c.guardaDatos(clave_contrato, clave_cliente, usuario, password, "I");
                        if (seGuardo) {
                            JOptionPane.showMessageDialog(this, " Operación realizada satisfactoriamente ", "Información", JOptionPane.INFORMATION_MESSAGE);
                            Limpia();
                            this.miComboBoxFidei.grabFocus();
                        } else {
                            JOptionPane.showMessageDialog(this, " Error almacenando información ", "Error", JOptionPane.ERROR_MESSAGE);
                            Limpia();
                            this.miComboBoxFidei.grabFocus();
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, " El password debe contar con almenos 8 caracteres alfanuméricos ", "Alerta", JOptionPane.WARNING_MESSAGE);
                        this.miPassword.setText("");
                        this.miPasswordRe.setText("");
                        this.miPassword.grabFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "El password NO coincide con la verificación", "Alerta", JOptionPane.WARNING_MESSAGE);
                    this.miPassword.setText("");
                    this.miPasswordRe.setText("");
                    this.miPassword.grabFocus();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Información incompleta, favor de verificar", "Alerta", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, " Error realizando transacción ", "Error", JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_miButtonAltaActionPerformed

    private void miButtonAltaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_miButtonAltaKeyPressed

        try {
            String fideicomitente = this.miComboBoxFidei.getSelectedItem().toString();
            String usuario = this.miComboBoxUsuario.getSelectedItem().toString();
            String password = this.miPassword.getText().toString().trim();
            String passwordRe = this.miPasswordRe.getText().toString().trim();
            String clave_cliente = "";
            boolean seGuardo = false;

            if (!fideicomitente.equals("   -------------------------Selecciona Fideicomitente-------------------------   ")
                    && !usuario.equals("   -------Selecciona Usuario--------   ") && !clave_contrato.equals("")
                    && !password.equals("") && !passwordRe.equals("")) {

                if (password.equals(passwordRe)) {
                    if (password.length() > 7) {
                        clave_cliente = this.clave_contrato.substring(0, 9);
//                        seGuardo = c.guardaDatos(clave_contrato, clave_cliente, usuario, password, "I");
                        if (seGuardo) {
                            JOptionPane.showMessageDialog(this, " Operación realizada satisfactoriamente ", "Información", JOptionPane.INFORMATION_MESSAGE);
                            Limpia();
                            this.miComboBoxFidei.grabFocus();
                        } else {
                            JOptionPane.showMessageDialog(this, " Error almacenando información ", "Error", JOptionPane.ERROR_MESSAGE);
                            Limpia();
                            this.miComboBoxFidei.grabFocus();
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, " El password debe contar con almenos 8 caracteres alfanuméricos ", "Alerta", JOptionPane.WARNING_MESSAGE);
                        this.miPassword.setText("");
                        this.miPasswordRe.setText("");
                        this.miPassword.grabFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "El password debe coincidir con la verificación", "Alerta", JOptionPane.WARNING_MESSAGE);
                    this.miPassword.setText("");
                    this.miPasswordRe.setText("");
                    this.miPassword.grabFocus();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Información incompleta, favor de verificar", "Alerta", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, " Error realizando transacción, consulte a su Administrador ", "Error", JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_miButtonAltaKeyPressed

    private void miPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPasswordActionPerformed
        String password = this.miPassword.getText().toString().trim();
        if (password.length() < 7) {
            JOptionPane.showMessageDialog(this, " El password debe contar con almenos 8 caracteres alfanuméricos ", "Alerta", JOptionPane.WARNING_MESSAGE);
            this.miPassword.setText("");
            this.miPasswordRe.setText("");
            this.miPassword.grabFocus();
        } else {
            this.miPasswordRe.setText("");
            this.miPasswordRe.grabFocus();
        }

    }//GEN-LAST:event_miPasswordActionPerformed

    private void miPasswordReActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPasswordReActionPerformed
        String password = this.miPassword.getText().toString().trim();
        String passwordRe = this.miPasswordRe.getText().toString().trim();

        if (password.equals(passwordRe)) {
            this.miButtonAlta.grabFocus();
        } else {
            JOptionPane.showMessageDialog(this, "El password debe coincidir con la verificación", "Alerta", JOptionPane.WARNING_MESSAGE);
            this.miPassword.setText("");
            this.miPasswordRe.setText("");
            this.miPassword.grabFocus();
        }
    }//GEN-LAST:event_miPasswordReActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                clsILookAndFeel.setSystemLookAndFell();
                new clsAltaBaja().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fechaBloqueo;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JButton miButtonAlta;
    private javax.swing.JComboBox miComboBoxFidei;
    private javax.swing.JComboBox miComboBoxUsuario;
    private javax.swing.JPasswordField miPassword;
    private javax.swing.JPasswordField miPasswordRe;
    private javax.swing.JLabel milblTitulo;
    // End of variables declaration//GEN-END:variables
}
