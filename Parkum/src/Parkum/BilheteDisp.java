/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Parkum;

import java.util.GregorianCalendar;

/**
 *
 * @author pimenta
 */
public class BilheteDisp extends Bilhete {

    private String idDisp;

    public BilheteDisp(){
        super();
        idDisp = "";
    }

    public BilheteDisp(String id, String idDisp){
        super();
        super.setIdBilhete(id);
        this.idDisp = idDisp;
    }

    public BilheteDisp(String id_b, GregorianCalendar dataE, GregorianCalendar dataS, double total, boolean proc, String id_d){
        super(id_b, dataE, dataS, total, proc);
        idDisp = id_d;
    }


    public BilheteDisp(BilheteDisp bt){
        super(bt);
        idDisp = bt.getIdDisp();

    }

    public String getIdDisp(){return idDisp;}
    public void setIdDisp(String id) { idDisp = id; }

    public String toString() {
        StringBuilder s = new StringBuilder("-----Bilhete Cliente Pre-Registado-----\n");
        s.append(super.toString());
        s.append("ID Dispositivo: " + idDisp + "\n\n");
        return s.toString();
    }

    public BilheteDisp clone(){
        return new BilheteDisp(this);
    }

}
