/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Parkum;


import java.util.GregorianCalendar;
/**
 *
 * @author miguel
 */
public class DispViaVerde extends DispPreRegisto{

    private String idViaVerde;
    private GregorianCalendar dataProxPagamento;

    public DispViaVerde(){
        super();
        idViaVerde = "";
        dataProxPagamento = null;
    }

    public DispViaVerde(String id_P, String id_Cl, String tipoD, String viaVerde, GregorianCalendar dataP){
        super(id_P, id_Cl, tipoD);
        idViaVerde = viaVerde;
        dataProxPagamento = dataP;
    }

    public DispViaVerde(DispViaVerde disp){
        super(disp);
        idViaVerde = disp.getIdViaVerde();
        dataProxPagamento = disp.getDataProxPagamento();
    }

    public String getIdViaVerde(){return idViaVerde;}
    public GregorianCalendar getDataProxPagamento(){return dataProxPagamento;}

    public void setIdViaVerde(String viaVerde){idViaVerde = viaVerde;}
    public void setDataProxPagamento(GregorianCalendar data){dataProxPagamento = data;}

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(super.toString());
        s.append("ViaVerde ID: " + idViaVerde + "\n");
        s.append("Data Proximo Pag: ");
        if (dataProxPagamento!=null)
            s.append(dataProxPagamento.get(dataProxPagamento.YEAR) + "-" + dataProxPagamento.get(dataProxPagamento.MONTH) + "-" + dataProxPagamento.get(dataProxPagamento.DAY_OF_MONTH) + "\n");
        else
            s.append(dataProxPagamento + "\n");
        return s.toString();        
    }

    public DispViaVerde clone(){
        return new DispViaVerde(this);
    }

}
