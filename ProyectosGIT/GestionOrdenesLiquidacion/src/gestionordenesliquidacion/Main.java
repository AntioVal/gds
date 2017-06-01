/*
 * Login.java
 * Autor: Hernández Paredes Denis Alin
 * Created on 5/05/2011, 12:00:59 AM
 */
package gestionordenesliquidacion;

import Common.clsILookAndFeel;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        clsILookAndFeel.setSystemLookAndFell();
        new Login().show();
    }
}
