/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionUsuarios;

import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis-Valerio
 */
public class clsConsultaUsuarios extends javax.swing.JFrame {

    clsModelo c = new clsModelo();
    private String clave_contrato = "";    
    /**
     * Creates new form clsConsultaUsuarios
     */
    public clsConsultaUsuarios() {
        initComponents();
        Limpia();
        this.jComboBox2.setModel(new DefaultComboBoxModel(c.getClientes()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
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
        jComboBox2 = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        miTextFidei = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        nombreTxt = new javax.swing.JTextField();
        creacionTxt = new javax.swing.JTextField();
        puestoTxt = new javax.swing.JTextField();
        contactoTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        jToolBar2.setBackground(new java.awt.Color(202, 227, 127));
        jToolBar2.setBorder(new javax.swing.border.SoftBevelBorder(0, java.awt.Color.black, null, new java.awt.Color(153, 153, 153), new java.awt.Color(0, 204, 255)));
        jToolBar2.setFloatable(false);
        jToolBar2.setForeground(new java.awt.Color(0, 0, 102));
        jToolBar2.setRollover(true);
        jToolBar2.setMinimumSize(new java.awt.Dimension(200, 47));
        jToolBar2.setPreferredSize(new java.awt.Dimension(500, 47));

        milblTitulo.setBackground(new java.awt.Color(0, 51, 153));
        milblTitulo.setFont(new java.awt.Font("Trebuchet MS", 0, 21)); // NOI18N
        milblTitulo.setForeground(new java.awt.Color(47, 113, 148));
        milblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        milblTitulo.setText("CONSULTA DE USUARIO ");

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel12.setText("Usuario:");

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel14.setText("Fideicomitente:");

        mitxtClaveCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mitxtClaveCliente.setEnabled(false);
        mitxtClaveCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitxtClaveClienteActionPerformed(evt);
            }
        });

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel15.setText("Clave Fideicomiso:");

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel16.setText("Clave Cliente:");

        miTextFidei.setEditable(false);

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel13.setText("Creación:");

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel17.setText("Nombre:");

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel18.setText("Puesto:");

        jLabel19.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel19.setText("Contacto:");

        nombreTxt.setEditable(false);

        creacionTxt.setEditable(false);

        puestoTxt.setEditable(false);

        contactoTxt.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(milblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(1, 1, 1)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(miTextFidei, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mitxtClaveCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(contactoTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                                    .addComponent(puestoTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nombreTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(creacionTxt))))))
                .addGap(40, 40, 40))
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(milblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(miTextFidei, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mitxtClaveCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(puestoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contactoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(creacionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void Limpia() {
        Vector clientes = c.getClientes();
        if (clientes != null) {
            this.jComboBox2.setModel(new DefaultComboBoxModel(clientes));
            mitxtClaveCliente.setText("");
            mitxtClaveCliente.setEnabled(false);
            nombreTxt.setText("");
            nombreTxt.setEnabled(false);
            puestoTxt.setText("");
            puestoTxt.setEnabled(false);
            contactoTxt.setText("");
            contactoTxt.setEnabled(false);
            creacionTxt.setText("");
            creacionTxt.setEnabled(false);
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

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String usuario = this.jComboBox1.getSelectedItem().toString();
        Vector info_usuario = new Vector();
        try {
            if (!usuario.contains(" -----Seleccione----- ")) {
                if (!usuario.equals("")) {
                    info_usuario = c.getInfoUsuario(clave_contrato,usuario);
                    this.nombreTxt.setText(info_usuario.get(0).toString());
                    this.puestoTxt.setText(info_usuario.get(1).toString());
                    this.contactoTxt.setText(info_usuario.get(2).toString());
                    this.creacionTxt.setText(info_usuario.get(3).toString());
                } else {
                    JOptionPane.showMessageDialog(this, " Error al obtener los datos de usuario. ", "Error", JOptionPane.ERROR_MESSAGE);
                    Limpia();
                    this.jComboBox2.grabFocus();
                }
            }
        } catch (Exception e) {
            System.out.println("Exception:consultaInfoUsuario:" + e.getMessage());
            JOptionPane.showMessageDialog(this, " Error, consulte a su administrador ", "Error", JOptionPane.ERROR_MESSAGE);
        }        
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
                    nombreTxt.setText("");
                    nombreTxt.setEnabled(false);
                    puestoTxt.setText("");
                    puestoTxt.setEnabled(false);
                    contactoTxt.setText("");
                    contactoTxt.setEnabled(false);
                    creacionTxt.setText("");
                    creacionTxt.setEnabled(false);                       
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

    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_exitForm

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
            java.util.logging.Logger.getLogger(clsConsultaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(clsConsultaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(clsConsultaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(clsConsultaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new clsConsultaUsuarios().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField contactoTxt;
    private javax.swing.JTextField creacionTxt;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JTextField miTextFidei;
    private javax.swing.JLabel milblTitulo;
    private javax.swing.JTextField mitxtClaveCliente;
    private javax.swing.JTextField nombreTxt;
    private javax.swing.JTextField puestoTxt;
    // End of variables declaration//GEN-END:variables
}