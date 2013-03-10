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
public class DispAvenca extends DispPreRegisto{

    private String id_Cartao;
    private GregorianCalendar dataProxPagamento;
    private String tipoAvenca;

    public DispAvenca(){
        super();
        id_Cartao="";
        dataProxPagamento=null;
        tipoAvenca="";
    }

    public DispAvenca(String id_P, String id_Cl, String tipoD,String id_c, String tipo, GregorianCalendar dataP){
        super(id_P, id_Cl, tipoD);
        id_Cartao=id_c;
        dataProxPagamento=dataP;
        tipoAvenca=tipo;
    }
    
    public DispAvenca(DispAvenca cartao){
        super(cartao);
        id_Cartao=cartao.getIdCartao();
        dataProxPagamento=cartao.getDataProxPagamento();
        tipoAvenca=cartao.getTipoAvenca();
    }

    public String getIdCartao(){return id_Cartao;}
    public GregorianCalendar getDataProxPagamento(){return dataProxPagamento;}
    public String getTipoAvenca(){return tipoAvenca;}

    public void setIdCartao(String id_c){id_Cartao=id_c;}
    public void setDataProxPagamento(GregorianCalendar dataP){dataProxPagamento=dataP;}
    public void setTipoAvenca(String tipoA){tipoAvenca=tipoA;}

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(super.toString());
        s.append("ID Cartao: " + id_Cartao + "\n");
        s.append("Data Proximo Pag: ");
        if (dataProxPagamento!=null)
            s.append(dataProxPagamento.get(dataProxPagamento.YEAR) + "-" + dataProxPagamento.get(dataProxPagamento.MONTH) + "-" + dataProxPagamento.get(dataProxPagamento.DAY_OF_MONTH) + "\n");
        else
            s.append(dataProxPagamento + "\n");
        s.append("Tipo Avença: " + tipoAvenca + "\n");
        return s.toString();
    }

    @Override
    public DispAvenca clone(){
         return new DispAvenca(this);
    }


}