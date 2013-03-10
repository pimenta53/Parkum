/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Parkum;

import java.util.GregorianCalendar;
import java.util.*;
import java.text.*;
/**
 *
 * @author pimenta
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        PARKUM s = new PARKUM();
        CarregarBD d = new CarregarBD();
        Scanner input = new Scanner(System.in);
        String menu = ("---------Parkum-------------\n" +
             "1 - Gestao\n" +
             "2 - Simulação\n" +
             "0 - Sair\n");
        String submenu="1";
        InterfaceGestao i = new InterfaceGestao();
        InterfaceSimulacao is = new InterfaceSimulacao();

        d.CarregarBD(s.getCSI());

        while (submenu.compareTo("0")!=0) {
            System.out.println(menu);
            submenu=input.nextLine();
            if (submenu.compareTo("1")==0) i.gest(s.getCSI(),input);
            if (submenu.compareTo("2")==0) is.simul(s.getCSI(), input);
        }
    }

}
