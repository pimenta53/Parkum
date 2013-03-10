/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Parkum;

/**
 *
 * @author miguel
 */
public abstract class DispPreRegisto {

    private String id_PreRegisto;
    private String id_Cliente;
    private String tipoDispositivo;


    public DispPreRegisto(){
        id_PreRegisto="";
        id_Cliente="";
        tipoDispositivo="";
    }

    public DispPreRegisto(String id_P, String id_Cl, String tipoD){
        id_PreRegisto=id_P;
        id_Cliente=id_Cl;
        tipoDispositivo=tipoD;
    }

    public DispPreRegisto(DispPreRegisto disp){
        id_PreRegisto=disp.getIdPreRegisto();
        id_Cliente=disp.getIdCliente();
        tipoDispositivo=disp.getTipoDispositivo();
    }

    public String getIdPreRegisto(){return id_PreRegisto;}
    public String getIdCliente(){return id_Cliente;}
    public String getTipoDispositivo(){return tipoDispositivo;}

    public void setIdPreRegisto(String id_p){id_PreRegisto=id_p;}
    public void setIdCliente(String id_c){id_Cliente=id_c;}
    public void setTipoDispositivo(String tipoD){tipoDispositivo=tipoD;}

    public String toString() {
        StringBuilder s = new StringBuilder("------------Dispositivo---------\n");
        s.append("ID Disp: " + id_PreRegisto + "\n");
        s.append("ID Cliente: " + id_Cliente + "\n");
        s.append("Tipo Dispositivo: " + tipoDispositivo + "\n");
        return s.toString();
    }

}
