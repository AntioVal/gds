
/*
 * mntnModificacionContratos.java
 *
 * Created on 15/04/2011, 02:25:42 PM
 */
package GestionContratos;

import javax.swing.*;
import java.util.Vector;
import Common.clsILookAndFeel;

/**
 *
 * @author SISTEMASGP
 */
public class mntnModificacionContratos extends javax.swing.JFrame {

    clsModelo c = new clsModelo();

    /** Creates new form mntnModificacionContratos */
    public mntnModificacionContratos() {
        initComponents();
        Limpia();
        this.mitxtClaveContrato.grabFocus();
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
        jLabel11 = new javax.swing.JLabel();
        jComboBox = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        mitxtNombreCliente = new javax.swing.JTextField();
        mitxtOficinas = new javax.swing.JTextField();
        mitxtClaveContrato = new javax.swing.JTextField();
        mitxtGrupo = new javax.swing.JTextField();
        mitxtDomicilioFiscal = new javax.swing.JTextField();
        mitxtRFC = new javax.swing.JTextField();
        mitxtTel = new javax.swing.JTextField();
        jButton = new javax.swing.JButton();
        milblTitulo = new javax.swing.JLabel();
        mitxtCuentaOrigen = new javax.swing.JComboBox();
        jLabel25 = new javax.swing.JLabel();
        mitxtCorreo = new javax.swing.JTextField();
        mitxtHonorario = new javax.swing.JComboBox();
        mitxtHonorarioSinIVA = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        mitxtID_codes = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificación de Contratos");
        getContentPane().setLayout(null);

        jToolBar2.setBackground(new java.awt.Color(202, 227, 127));
        jToolBar2.setBorder(new javax.swing.border.SoftBevelBorder(0, java.awt.Color.black, null, new java.awt.Color(153, 153, 153), new java.awt.Color(0, 204, 255)));
        jToolBar2.setFloatable(false);
        jToolBar2.setForeground(new java.awt.Color(0, 0, 102));
        jToolBar2.setRollover(true);
        jToolBar2.setMinimumSize(new java.awt.Dimension(200, 47));
        jToolBar2.setPreferredSize(new java.awt.Dimension(500, 47));
        getContentPane().add(jToolBar2);
        jToolBar2.setBounds(0, 0, 680, 40);

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel11.setText("FIDEICOMITENTE");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(30, 110, 120, 30);

        jComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox);
        jComboBox.setBounds(150, 110, 360, 30);

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel15.setText("CLAVE CONTRATO");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(20, 170, 120, 30);

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel16.setText("NOMBRE CLIENTE");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(20, 200, 120, 30);

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel17.setText("CUENTA ORIGEN");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(20, 230, 120, 30);

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel18.setText("GRUPO");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(20, 260, 120, 30);

        jLabel19.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel19.setText("DOMICILIO FISCAL");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(20, 290, 120, 30);

        jLabel20.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel20.setText("RFC");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(20, 320, 140, 30);

        jLabel21.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel21.setText("TELÉFONO");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(20, 350, 140, 30);

        jLabel22.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel22.setText("TIPO HONORARIO");
        getContentPane().add(jLabel22);
        jLabel22.setBounds(20, 410, 140, 30);

        jLabel23.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel23.setText("HONORARIO SIN IVA");
        getContentPane().add(jLabel23);
        jLabel23.setBounds(20, 440, 140, 30);

        jLabel24.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel24.setText("OFICINAS");
        getContentPane().add(jLabel24);
        jLabel24.setBounds(20, 470, 120, 30);

        mitxtNombreCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mitxtNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitxtNombreClienteActionPerformed(evt);
            }
        });
        getContentPane().add(mitxtNombreCliente);
        mitxtNombreCliente.setBounds(160, 200, 490, 30);

        mitxtOficinas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mitxtOficinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitxtOficinasActionPerformed(evt);
            }
        });
        getContentPane().add(mitxtOficinas);
        mitxtOficinas.setBounds(160, 470, 200, 30);

        mitxtClaveContrato.setEditable(false);
        mitxtClaveContrato.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mitxtClaveContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitxtClaveContratoActionPerformed(evt);
            }
        });
        getContentPane().add(mitxtClaveContrato);
        mitxtClaveContrato.setBounds(160, 170, 200, 30);

        mitxtGrupo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mitxtGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitxtGrupoActionPerformed(evt);
            }
        });
        getContentPane().add(mitxtGrupo);
        mitxtGrupo.setBounds(160, 260, 200, 30);

        mitxtDomicilioFiscal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mitxtDomicilioFiscal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitxtDomicilioFiscalActionPerformed(evt);
            }
        });
        getContentPane().add(mitxtDomicilioFiscal);
        mitxtDomicilioFiscal.setBounds(160, 290, 200, 30);

        mitxtRFC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mitxtRFC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitxtRFCActionPerformed(evt);
            }
        });
        getContentPane().add(mitxtRFC);
        mitxtRFC.setBounds(160, 320, 200, 30);

        mitxtTel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mitxtTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitxtTelActionPerformed(evt);
            }
        });
        getContentPane().add(mitxtTel);
        mitxtTel.setBounds(160, 350, 200, 30);

        jButton.setText("Modificar");
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
        jButton.setBounds(310, 570, 80, 23);

        milblTitulo.setBackground(new java.awt.Color(0, 51, 153));
        milblTitulo.setFont(new java.awt.Font("Trebuchet MS", 0, 21)); // NOI18N
        milblTitulo.setForeground(new java.awt.Color(47, 113, 148));
        milblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        milblTitulo.setText("MODIFICACIÓN DE CONTRATOS");
        getContentPane().add(milblTitulo);
        milblTitulo.setBounds(0, 50, 670, 40);

        mitxtCuentaOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitxtCuentaOrigenActionPerformed(evt);
            }
        });
        getContentPane().add(mitxtCuentaOrigen);
        mitxtCuentaOrigen.setBounds(160, 230, 200, 30);

        jLabel25.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel25.setText("E-MAIL ASESOR");
        getContentPane().add(jLabel25);
        jLabel25.setBounds(20, 380, 140, 30);

        mitxtCorreo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mitxtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitxtCorreoActionPerformed(evt);
            }
        });
        getContentPane().add(mitxtCorreo);
        mitxtCorreo.setBounds(160, 380, 200, 30);

        mitxtHonorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitxtHonorarioActionPerformed(evt);
            }
        });
        getContentPane().add(mitxtHonorario);
        mitxtHonorario.setBounds(160, 410, 200, 30);

        mitxtHonorarioSinIVA.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mitxtHonorarioSinIVA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitxtHonorarioSinIVAActionPerformed(evt);
            }
        });
        getContentPane().add(mitxtHonorarioSinIVA);
        mitxtHonorarioSinIVA.setBounds(160, 440, 200, 30);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setText("ID_CODES");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 500, 90, 30);

        mitxtID_codes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitxtID_codesActionPerformed(evt);
            }
        });
        getContentPane().add(mitxtID_codes);
        mitxtID_codes.setBounds(160, 500, 200, 30);

        setSize(new java.awt.Dimension(683, 648));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void Limpia() {
        Vector tmp = new Vector();
        tmp.add("    ------------ Selecciona ------------  ");
        tmp.add("RIESGOS");
        tmp.add("PATRIMONIO");
        this.jComboBox.setModel(new DefaultComboBoxModel(clsModelo.getClientes()));
        this.mitxtClaveContrato.setText("");
        this.mitxtNombreCliente.setText("");
        this.mitxtCuentaOrigen.setModel(new DefaultComboBoxModel(clsModelo.getCuentaOrigen()));
        this.mitxtGrupo.setText("");
        this.mitxtDomicilioFiscal.setText("");
        this.mitxtRFC.setText("");
        this.mitxtTel.setText("");
        this.mitxtCorreo.setText("");
        this.mitxtHonorario.setModel(new DefaultComboBoxModel(tmp));
        this.mitxtHonorarioSinIVA.setText("");
        this.mitxtOficinas.setText("");
    }
    private void jComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxActionPerformed
        String cliente = jComboBox.getSelectedItem().toString();
        this.Limpia();
        if (cliente.equals("   ---------------------Selecciona Fideicomitente---------------------   ")) {
            JOptionPane.showMessageDialog(this, " Fideicomitente inválido ", "Alerta", JOptionPane.WARNING_MESSAGE);
            this.jComboBox.grabFocus();
        } else {
            this.jComboBox.setSelectedItem(cliente);
            this.mitxtClaveContrato.grabFocus();
        }

}//GEN-LAST:event_jComboBoxActionPerformed

    private void mitxtNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitxtNombreClienteActionPerformed
//        String nombre_cliente = this.mitxtNombreCliente.getText().toString().trim();
//        if (!nombre_cliente.equals("")) {
//            
//        } else {
//           
//        }
        this.mitxtCuentaOrigen.grabFocus();
}//GEN-LAST:event_mitxtNombreClienteActionPerformed

    private void mitxtOficinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitxtOficinasActionPerformed
        this.jButton.grabFocus();
}//GEN-LAST:event_mitxtOficinasActionPerformed

    private void mitxtClaveContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitxtClaveContratoActionPerformed
        String clave_contrato = this.mitxtClaveContrato.getText().toUpperCase().toString().trim();
        if (!clave_contrato.equals("")) {
            boolean existe = c.verificaContrato(clave_contrato);
            boolean clave_valida = false;
            if (existe) {
                JOptionPane.showMessageDialog(this, " Clave de contrato existente ", "Alerta", JOptionPane.WARNING_MESSAGE);
                this.mitxtClaveContrato.setText("");
                this.mitxtClaveContrato.grabFocus();
            } else {
                clave_valida = c.validaClaveContrato(clave_contrato);
                if (clave_valida) {
                    this.mitxtNombreCliente.grabFocus();
                } else {
                    JOptionPane.showMessageDialog(this, " La clave NO CUENTA con el formato establecido, favor de verificar ", "Alerta", JOptionPane.WARNING_MESSAGE);
                    this.mitxtClaveContrato.grabFocus();
                }
            }
        } else {
            this.mitxtNombreCliente.grabFocus();
        }
}//GEN-LAST:event_mitxtClaveContratoActionPerformed

    private void mitxtGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitxtGrupoActionPerformed
        this.mitxtDomicilioFiscal.grabFocus();
}//GEN-LAST:event_mitxtGrupoActionPerformed

    private void mitxtDomicilioFiscalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitxtDomicilioFiscalActionPerformed
        this.mitxtRFC.grabFocus();
}//GEN-LAST:event_mitxtDomicilioFiscalActionPerformed

    private void mitxtRFCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitxtRFCActionPerformed
        this.mitxtTel.grabFocus();
}//GEN-LAST:event_mitxtRFCActionPerformed

    private void mitxtTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitxtTelActionPerformed
        this.mitxtCorreo.grabFocus();
}//GEN-LAST:event_mitxtTelActionPerformed

    private void jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActionPerformed
        String cliente = jComboBox.getSelectedItem().toString();
        String calve_contrato = mitxtClaveContrato.getText().toUpperCase().toString().trim();
        String nombre_cliente = mitxtNombreCliente.getText().toUpperCase().toString().trim();
        String cuenta_origen = mitxtCuentaOrigen.getSelectedItem().toString();
        String grupo = mitxtGrupo.getText().toUpperCase().toString().trim();
        String domicilio_fiscal = mitxtDomicilioFiscal.getText().toUpperCase().toString().trim();
        String RFC = mitxtRFC.getText().toUpperCase().toString().trim();
        String telefono = mitxtTel.getText().toUpperCase().toString().trim();
        String correo = mitxtCorreo.getText().toString().trim();
        String tipo_honorario = mitxtHonorario.getSelectedItem().toString();
        String honorario_sin_iva = mitxtHonorarioSinIVA.getText().toString().trim();
        //honorario_sin_iva = honorario_sin_iva.substring(0, honorario_sin_iva.length() - 1).trim();
        String oficinas = mitxtOficinas.getText().toUpperCase().toString().trim();
        String id_codes = mitxtID_codes.getText().toUpperCase().toString().trim();

        if (cliente.equals("   ---------------------Selecciona Fideicomitente---------------------   ")) {
            JOptionPane.showMessageDialog(this, " Fideicomitente inválido, favor de verificar ", "Alerta", JOptionPane.WARNING_MESSAGE);
            this.mitxtClaveContrato.grabFocus();
        } else {
            boolean actualiza = c.actualizaContrato(cliente, calve_contrato, nombre_cliente, cuenta_origen,
                    grupo, domicilio_fiscal, RFC, telefono, correo, tipo_honorario, honorario_sin_iva, oficinas, id_codes);
            if (actualiza) {
                JOptionPane.showMessageDialog(this, " Operación realizada satisfactoriamente ", "Información", JOptionPane.INFORMATION_MESSAGE);
                Limpia();
                this.mitxtClaveContrato.grabFocus();
            } else {
                JOptionPane.showMessageDialog(this, " Error actualizando información ", "Error", JOptionPane.ERROR_MESSAGE);
                this.mitxtClaveContrato.grabFocus();
            }
        }

    }//GEN-LAST:event_jButtonActionPerformed

    private void mitxtCuentaOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitxtCuentaOrigenActionPerformed
        this.mitxtGrupo.grabFocus();
}//GEN-LAST:event_mitxtCuentaOrigenActionPerformed

    private void mitxtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitxtCorreoActionPerformed
        String correo = this.mitxtCorreo.getText().toString().trim();
        if (!correo.equals("")) {
            if (correo.contains("@")) {
                this.mitxtHonorario.grabFocus();
            } else {
                JOptionPane.showMessageDialog(this, " correo inválido ", "Alerta", JOptionPane.WARNING_MESSAGE);
                this.mitxtCorreo.setText("");
                this.mitxtCorreo.grabFocus();
            }
        } else {
            this.mitxtHonorario.grabFocus();
        }
}//GEN-LAST:event_mitxtCorreoActionPerformed

    private void mitxtHonorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitxtHonorarioActionPerformed
        this.mitxtHonorarioSinIVA.grabFocus();
}//GEN-LAST:event_mitxtHonorarioActionPerformed

    private void mitxtHonorarioSinIVAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitxtHonorarioSinIVAActionPerformed
        Float val = 0F;
        String honorarioSinIVA = this.mitxtHonorarioSinIVA.getText().toString().trim();
        if (!honorarioSinIVA.equals("")) {
            try {
                val = Float.parseFloat(honorarioSinIVA);
                if (val > 0) {
                    mitxtOficinas.grabFocus();
                } else {
                    JOptionPane.showMessageDialog(this, "El porcentaje del honorario SIN IVA debe ser mayor a 0", "Alerta", JOptionPane.WARNING_MESSAGE);
                    mitxtHonorarioSinIVA.setText("");
                    mitxtHonorarioSinIVA.grabFocus();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Formato de honorario SIN IVA inválido", "Alerta", JOptionPane.WARNING_MESSAGE);
                mitxtHonorarioSinIVA.setText("");
                mitxtHonorarioSinIVA.grabFocus();
            }
        } else {
            mitxtOficinas.grabFocus();
        }
}//GEN-LAST:event_mitxtHonorarioSinIVAActionPerformed

    private void jButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonKeyPressed
        String cliente = jComboBox.getSelectedItem().toString();
        String calve_contrato = mitxtClaveContrato.getText().toUpperCase().toString().trim();
        String nombre_cliente = mitxtNombreCliente.getText().toUpperCase().toString().trim();
        String cuenta_origen = mitxtCuentaOrigen.getSelectedItem().toString();
        String grupo = mitxtGrupo.getText().toUpperCase().toString().trim();
        String domicilio_fiscal = mitxtDomicilioFiscal.getText().toUpperCase().toString().trim();
        String RFC = mitxtRFC.getText().toUpperCase().toString().trim();
        String telefono = mitxtTel.getText().toUpperCase().toString().trim();
        String correo = mitxtCorreo.getText().toString().trim();
        String tipo_honorario = mitxtHonorario.getSelectedItem().toString();
        String honorario_sin_iva = mitxtHonorarioSinIVA.getText().toString().trim();
        String oficinas = mitxtOficinas.getText().toUpperCase().toString().trim();
        String ID_codes = mitxtID_codes.getText().toUpperCase().toString().trim();

        if (cliente.equals("   ---------------------Selecciona Fideicomitente---------------------   ")) {
            JOptionPane.showMessageDialog(this, " Favor de seleccionar fideicomitente", "Alerta", JOptionPane.WARNING_MESSAGE);
            this.mitxtClaveContrato.grabFocus();
        } else {
            boolean actualiza = c.actualizaContrato(cliente, calve_contrato, nombre_cliente, cuenta_origen,
                    grupo, domicilio_fiscal, RFC, telefono, correo, tipo_honorario, honorario_sin_iva, oficinas, ID_codes);
            if (actualiza) {
                JOptionPane.showMessageDialog(this, " Operación realizada satisfactoriamente ", "Información", JOptionPane.INFORMATION_MESSAGE);
                Limpia();
                this.mitxtClaveContrato.grabFocus();
            } else {
                JOptionPane.showMessageDialog(this, " Error actualizando información ", "Error", JOptionPane.ERROR_MESSAGE);
                this.mitxtClaveContrato.grabFocus();
            }
        }
    }//GEN-LAST:event_jButtonKeyPressed

    private void mitxtID_codesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitxtID_codesActionPerformed
        // TODO add your handling code here:
        this.mitxtID_codes.grabFocus();
    }//GEN-LAST:event_mitxtID_codesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                clsILookAndFeel.setSystemLookAndFell();
                new mntnModificacionContratos().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton;
    private javax.swing.JComboBox jComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel milblTitulo;
    private javax.swing.JTextField mitxtClaveContrato;
    private javax.swing.JTextField mitxtCorreo;
    private javax.swing.JComboBox mitxtCuentaOrigen;
    private javax.swing.JTextField mitxtDomicilioFiscal;
    private javax.swing.JTextField mitxtGrupo;
    private javax.swing.JComboBox mitxtHonorario;
    private javax.swing.JTextField mitxtHonorarioSinIVA;
    private javax.swing.JTextField mitxtID_codes;
    private javax.swing.JTextField mitxtNombreCliente;
    private javax.swing.JTextField mitxtOficinas;
    private javax.swing.JTextField mitxtRFC;
    private javax.swing.JTextField mitxtTel;
    // End of variables declaration//GEN-END:variables
}
