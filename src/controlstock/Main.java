package controlstock;

import JFrames.Principal;
import javax.swing.UIManager;
import org.hibernate.Session;


public class Main {
    
    static Session session =null;

    public static void main(String[] args) {
        
        
        //com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel
        //UpperEssential.UpperEssentialLookAndFeel
        //com.birosoft.liquid.LiquidLookAndFeel
        
        
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

        }catch(Exception ex){
        }
               
        Principal principal = new Principal();
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);
        principal.mostrarTabs();
        
        
        
    }
 
}
