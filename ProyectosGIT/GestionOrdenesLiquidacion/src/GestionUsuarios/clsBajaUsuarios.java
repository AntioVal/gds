/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * clsBajaUsuarios.java
 *
 * Created on 25/03/2011, 11:39:10 AM
 */
package GestionUsuarios;

import javax.swing.*;
import java.util.Vector;
import Common.clsILookAndFeel;

/**
 *
 * @author SISTEMASGP
 */
public class clsBajaUsuarios extends javax.swing.JFrame {

    //Creamos una intancia del modelo para gestionar las consultas a la BD
    clsModelo c = new clsModelo();
    private String clave_contrato = "";

    /** Creates new form clsBajaUsuarios */
    public clsBajaUsuarios() {
        initComponents();
        Limpia();
        this.jComboBox2.setModel(new DefaultComboBoxModel(c.getClientes()));
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
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        mitxtClaveCliente = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        miTextFidei = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Baja de Usuarios en el Sistema");
        getContentPane().setLayout(null);

        jToolBar2.setBackground(new java.awt.Color(202, 227, 127));
        jToolBar2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, null, new java.awt.Color(153, 153, 153), new java.awt.Color(0, 204, 255)));
        jToolBar2.setFloatable(false);
        jToolBar2.setForeground(new java.awt.Color(0, 0, 102));
        jToolBar2.setRollover(true);
        jToolBar2.setMinimumSize(new java.awt.Dimension(200, 47));
        jToolBar2.setPreferredSize(new java.awt.Dimension(500, 47));
        getContentPane().add(jToolBar2);
        jToolBar2.setBounds(0, 0, 540, 40);

        milblTitulo.setBackground(new java.awt.Color(0, 51, 153));
        milblTitulo.setFont(new java.awt.Font("Trebuchet MS", 0, 21));
        milblTitulo.setForeground(new java.awt.Color(47, 113, 148));
        milblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        milblTitulo.setText("BAJA DE USUARIO ");
        getContentPane().add(milblTitulo);
        milblTitulo.setBounds(0, 50, 530, 30);

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 14));
        jLabel12.setText("Usuario:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(20, 180, 120, 30);

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 14));
        jLabel14.setText("Fideicomitente:");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(20, 120, 120, 30);

        mitxtClaveCliente.setFont(new java.awt.Font("Tahoma", 1, 14));
        mitxtClaveCliente.setEnabled(false);
        mitxtClaveCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitxtClaveClienteActionPerformed(evt);
            }
        });
        getContentPane().add(mitxtClaveCliente);
        mitxtClaveCliente.setBounds(140, 150, 200, 30);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(140, 180, 200, 30);

        jButton1.setText("Baja");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(220, 240, 80, 23);

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(140, 90, 200, 30);

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 14));
        jLabel15.setText("Clave Fideicomiso:");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(20, 90, 120, 30);

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 14));
        jLabel16.setText("Clave Cliente:");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(20, 150, 120, 30);

        miTextFidei.setEditable(false);
        getContentPane().add(miTextFidei);
        miTextFidei.setBounds(140, 120, 370, 30);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-548)/2, (screenSize.height-328)/2, 548, 328);
    }// </editor-fold>//GEN-END:initComponents

    public void Limpia() {
        Vector clientes = c.getClientes();
        if (clientes != null) {
            this.jComboBox2.setModel(new DefaultComboBoxModel(clientes));
            mitxtClaveCliente.setText("");
            mitxtClaveCliente.setEnabled(false);
            clientes = new Vector();
            this.jComboBox1.setModel(new DefaultComboBoxModel(clientes));
        } else {
            clientes = new Vector();
            JOptionPane.showMessageDialog(this, " Error al obtener Fideicomitentes, consulte a su Administrador ", "Error", JOptionPane.ERROR_MESSAGE);
            this.jComboBox2.setModel(new DefaultComboBoxModel(clientes));
            mitxtClaveCliente.setText("");
            mitxtClaveCliente.setEnabled(false);
            this.jComboBox1.setModel(new DefaultComboBoxModel(clientes));
        }
    }

    private void mitxtClaveClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitxtClaveClienteActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_mitxtClaveClienteActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed

        clave_contrato = this.jComboBox2.getSelectedItem().toString();
        String nombre_fideicomitente = "";
        try {
            if (!clave_contrato.equals(" -----Seleccione----- ")) {
                nombre_fideicomitente = (String) c.getFideicomitente(clave_contrato);
                if (!clave_contrato.equals("")) {
                    this.miTextFidei.setText(nombre_fideicomitente);
                    this.mitxtClaveCliente.setText(clave_contrato.substring(0, 9));
                    this.jComboBox1.setModel(new DefaultComboBoxModel(c.getUsuarios(clave_contrato)));
                    this.jComboBox1.grabFocus();
                } else {
                    JOptionPane.showMessageDialog(this, " Error al obtener clave de fideicomiso ", "Error", JOptionPane.ERROR_MESSAGE);
                    Limpia();
                    this.jComboBox2.grabFocus();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, " Error, consulte a su administrador ", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            String nombre_cliente = this.jComboBox2.getSelectedItem().toString();
            String usuario = this.jComboBox1.getSelectedItem().toString();
            String clave_cliente = mitxtClaveCliente.getText().toString();

            if (!nombre_cliente.equals("   -------------------------Selecciona Cliente-------------------------   ")
                    && !usuario.equals("   -----Selecciona Usuario-----   ") && !clave_cliente.equals("") && !clave_contrato.equals("")) {

                boolean seGuardo = clsModelo.BajaUsuario(clave_contrato, clave_cliente, usuario);
                if (seGuardo) {
                    JOptionPane.showMessageDialog(this, " Operación realizada satisfactoriamente ", "Información", JOptionPane.INFORMATION_MESSAGE);
                    Limpia();
                    this.jComboBox2.grabFocus();
                } else {
                    JOptionPane.showMessageDialog(this, "Error actualizando información", "Error", JOptionPane.ERROR_MESSAGE);
                    Limpia();
                    this.jComboBox2.grabFocus();
                }
            } else {
                JOptionPane.showMessageDialog(this, " Información incompleta, favor de Verificar ", "Alerta", JOptionPane.WARNING_MESSAGE);
                this.jComboBox2.grabFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, " Información incompleta ", "Alerta", JOptionPane.WARNING_MESSAGE);
            this.jComboBox2.grabFocus();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        this.jButton1.grabFocus();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        String nombre_cliente = this.jComboBox2.getSelectedItem().toString();
        String usuario = this.jComboBox1.getSelectedItem().toString();
        String clave_cliente = mitxtClaveCliente.getText().toString().trim();

        if (!nombre_cliente.equals("   -------------------------Selecciona Cliente-------------------------   ")
                && !usuario.equals("   -----Selecciona Usuario-----   ") && !clave_cliente.equals("") && !clave_contrato.equals("")) {

            boolean seGuardo = clsModelo.BajaUsuario(clave_contrato, clave_cliente, usuario);
            if (seGuardo) {
                JOptionPane.showMessageDialog(this, " Operación realizada satisfactoriamente ", "Información", JOptionPane.INFORMATION_MESSAGE);
                Limpia();
                this.jComboBox2.grabFocus();
            } else {
                JOptionPane.showMessageDialog(this, "Error actualizando información", "Error", JOptionPane.ERROR_MESSAGE);
                Limpia();
                this.jComboBox2.grabFocus();
            }
        } else {
            JOptionPane.showMessageDialog(this, " Información incompleta, favor de Verificar ", "Alerta", JOptionPane.WARNING_MESSAGE);
            this.jComboBox2.grabFocus();

        }
    }//GEN-LAST:event_jButton1KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                clsILookAndFeel.setSystemLookAndFell();
                new clsBajaUsuarios().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JTextField miTextFidei;
    private javax.swing.JLabel milblTitulo;
    private javax.swing.JTextField mitxtClaveCliente;
    // End of variables declaration//GEN-END:variables
}
