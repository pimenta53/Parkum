/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Parkum;

/**
 *
 * @author Milton
 */
public class DispMovel extends DispPreRegisto {
    public String password;

    public DispMovel(){
        super();
        password = "";
    }

    public DispMovel(String id_P, String id_Cl, String tipoD, String pass){
        super(id_P, id_Cl, tipoD);
        password = pass;
    }

    public DispMovel(DispMovel disp){
        super(disp);
        password = disp.getPassword();
    }

    public String getPassword(){return password;}

    public void setPassword(String pass){password = pass;}

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(super.toString());
        s.append("Pass: " + password + "\n");
        return s.toString();        
    }

    public DispMovel clone(){
        return new DispMovel(this);
    }


}

