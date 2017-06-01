

package Common;


public  class clsILookAndFeel {
    
    /** Creates a new instance of clsILookAndFell */
    public static void setSystemLookAndFell() {
        try {
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel" );
        }
        catch(Exception e) {
           
        }
    }  
}
