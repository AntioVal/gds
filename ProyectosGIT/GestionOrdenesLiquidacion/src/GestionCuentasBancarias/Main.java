/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionCuentasBancarias;

import Common.clsILookAndFeel;

/**
 *
 * @author SISTEMASGP
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        clsILookAndFeel.setSystemLookAndFell();
        new gestionCuentas().show();
    }
}
