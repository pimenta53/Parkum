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
public abstract class Bilhete {

    private String idBilhete;
    private GregorianCalendar dataEntrada;
    private GregorianCalendar dataSaida;
    private double total;
    private boolean processado;


    public Bilhete(){
        idBilhete="";
        dataEntrada=new GregorianCalendar();
        dataSaida=null;
        total=0;
        processado=false;
    }

    public Bilhete(String id_b, GregorianCalendar dataE, GregorianCalendar dataS, double total, boolean proc){
        idBilhete=id_b;
        dataEntrada= dataE;
        dataSaida=dataS;
        this.total=total;
        processado=proc;
    }

    
    public Bilhete(Bilhete b){
        idBilhete=b.getIdBilhete();
        dataEntrada=b.getDataEntrada();
        dataSaida=b.getDataSida();
        total=b.getTotal();
        processado=b.getProcessado();
    }
    

    public String getIdBilhete(){return idBilhete;}
    public GregorianCalendar getDataEntrada(){return dataEntrada;}
    public GregorianCalendar getDataSida(){return dataSaida;}
    public double getTotal(){return total;}
    public boolean getProcessado(){return processado;}

    public void setIdBilhete(String id_b){idBilhete=id_b;}
    public void setDataEntrada(GregorianCalendar dataE){dataEntrada=dataE;}
    public void setDataSaida(GregorianCalendar dataS){dataSaida=dataS;}
    public void setTotal(double tot){total=tot;}
    public void setProcessado(boolean proc){processado=proc;}

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("ID: " + idBilhete +"\n");
        s.append("Data Entrada: ");
        if (dataEntrada!=null) s.append(dataEntrada.get(dataEntrada.YEAR) + "-" + dataEntrada.get(dataEntrada.MONTH) + "-" + dataEntrada.get(dataEntrada.DAY_OF_MONTH) + " " + dataEntrada.get(dataEntrada.HOUR_OF_DAY) + ":" + dataEntrada.get(dataEntrada.MINUTE)+"\n");
        else s.append(dataEntrada + "\n");
        s.append("Data Saida: ");
        if (dataSaida!=null)  s.append(dataSaida.get(dataSaida.YEAR) + "-" + dataSaida.get(dataSaida.MONTH) + "-" + dataSaida.get(dataSaida.DAY_OF_MONTH) + " " + dataSaida.get(dataSaida.HOUR_OF_DAY) + ":" + dataSaida.get(dataSaida.MINUTE)+"\n");
        else s.append(dataSaida + "\n");
        s.append("Total: " + total +"\n");
        s.append("Processado: " + processado +"\n");
        return s.toString();

    }
    //public Bilhete clone(){return new Bilhete(this);}
}
