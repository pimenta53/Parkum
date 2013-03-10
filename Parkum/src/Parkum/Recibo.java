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
public class Recibo {

    private String npic;
    private String idMaquina;
    private String idRecibo;
    private String idBilhete;
    private int tempoUtilizacao;
    private GregorianCalendar datEntrada;
    private GregorianCalendar datPagamento;
    private double totalPago;
    private String descricao;
    private String tipoPagamento;


    public Recibo(){
        npic="";
        idMaquina="";
        idRecibo="";
        idBilhete="";
        tempoUtilizacao=0;
        datEntrada= new GregorianCalendar();
        datPagamento=new GregorianCalendar();
        totalPago=0.0;
        descricao="";
        tipoPagamento="";
    }

    public Recibo(String npicn,String nid,String nr,String nb,int tu, GregorianCalendar dE,GregorianCalendar dP,double p, String tp){
        npic=npicn;
        idMaquina=nid;
        idRecibo=nr;
        idBilhete=nb;
        tempoUtilizacao=tu;
        datEntrada= dE;
        datPagamento=dP;
        totalPago=p;
        tipoPagamento=tp;
    }

    public Recibo(Recibo r){
        npic=r.getNpicn();
        idMaquina=r.getIdM();
        idRecibo=r.getIdReceb();
        idBilhete=r.getB();
        tempoUtilizacao=r.getTempo();
        datEntrada= r.getDEntrada();
        datPagamento=r.getDPagamento();
        totalPago=r.getPreco();
        descricao=r.getDes();
        tipoPagamento=r.getTipoPagamento();
    }

    public String getNpicn(){ return npic;}
    public String getIdM(){ return idMaquina;}
    public String getIdReceb(){ return idRecibo;}
    public String getB(){ return idBilhete;}
    public int getTempo(){ return tempoUtilizacao;}
    public GregorianCalendar getDEntrada(){ return datEntrada;}
    public GregorianCalendar getDPagamento(){ return datPagamento;}
    public double getPreco(){ return totalPago;}
    public String getDes(){ return descricao;}
    public String getTipoPagamento(){return tipoPagamento;}
        @Override
    public Recibo clone(){
        return new Recibo(this);
    }

    public String toString() {
        StringBuilder s = new StringBuilder("---------------Recibo------------\n");
        s.append("NPIC: " + npic + "\n");
        s.append("Numero Maquina: " + idMaquina + "\n");
        s.append("Numero recibo: " + idRecibo + "\n");
        s.append("Numero nBilhete: " + idBilhete + "\n");
        s.append("Data de entrada: " + datEntrada.get(datEntrada.YEAR) + "-" + datEntrada.get(datEntrada.MONTH) + "-" + datEntrada.get(datEntrada.DAY_OF_MONTH) + " " + datEntrada.get(datEntrada.HOUR) + ":" + datEntrada.get(datEntrada.MINUTE)+"\n");
        s.append("Tempo: " + tempoUtilizacao + "\n");
        s.append("Data de pagamento: " + datPagamento.get(datPagamento.YEAR) + "-" + datPagamento.get(datPagamento.MONTH) + "-" + datPagamento.get(datPagamento.DAY_OF_MONTH) + " " + datPagamento.get(datPagamento.HOUR_OF_DAY) + ":" + datPagamento.get(datPagamento.MINUTE)+"\n");
        s.append("Total pago: " + totalPago + "\n");
        s.append("Descricao: " + descricao + "\n");
        s.append("Tipo Pagamento: " + tipoPagamento + "\n");
        return s.toString();
    }


}
