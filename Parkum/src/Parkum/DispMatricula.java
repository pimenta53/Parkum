/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Parkum;

/**
 *
 * @author ricardo
 */
public class DispMatricula extends DispPreRegisto {

    private String nMatricula;

    public DispMatricula(){
        super();
        nMatricula = "";
    }

    public DispMatricula(String id_P, String id_Cl, String tipoD, String matricula){
        super(id_P, id_Cl, tipoD);
        nMatricula = matricula;
    }

    public DispMatricula(DispMatricula disp){
        super(disp);
        nMatricula = disp.getMatricula();
    }

    public String getMatricula(){return nMatricula;}

    public void setMatricula(String mat){nMatricula = mat;}

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(super.toString());
        s.append("Matricula: " + nMatricula + "\n");
        return s.toString();
    }

    public DispMatricula clone(){
        return new DispMatricula(this);
    }

}
