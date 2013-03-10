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
public abstract class Pagamento {

    private String idPagamento;
    private String idBilhete;
    private GregorianCalendar dataPagamento;
    private double total;
    private GregorianCalendar dataProcessamento;
    private boolean processado; //para ver se tá em atraso ou não
    private String formaPagamento;


    public Pagamento(String idP,String idB,double t,boolean prc,String fp){
    idPagamento=idP;
    idBilhete=idB;
    dataPagamento= new GregorianCalendar();
    total=t;
    dataProcessamento=null;
    processado=prc; //para ver se tá em atraso ou não
    formaPagamento=fp;
    }

    public Pagamento(Pagamento p){
    idPagamento=p.getIdPagamento();
    idBilhete=p.getIdBilhete();
    dataPagamento=p.getDataPg();
    total=p.getTotal();
    dataProcessamento=p.getDataPr();
    processado=p.getProc(); //para ver se tá em atraso ou não
    formaPagamento=p.getForma();
    }

public void setDataP(GregorianCalendar dt){dataPagamento=dt;}

public String getIdPagamento(){ return idPagamento;}
public String getIdBilhete(){ return idBilhete;}
public GregorianCalendar getDataPg(){ return dataPagamento;}
public double getTotal(){ return total;}
public GregorianCalendar getDataPr(){ return dataProcessamento;}
public boolean  getProc(){ return processado;}
public String getForma(){ return formaPagamento;}

public void processa(){
    processado=true;
    dataProcessamento=new GregorianCalendar();
}


    @Override
public abstract Pagamento clone();
}