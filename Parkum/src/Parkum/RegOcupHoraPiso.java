/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Parkum;

import java.util.GregorianCalendar;



/**
 *
 * @author Milton
 */
public class RegOcupHoraPiso {
    private String idRegOcupHora;
    private int piso;
    private long ocupacao;
    private GregorianCalendar data;
    private int hora;

public RegOcupHoraPiso(){
    idRegOcupHora = "";
    piso = 0;
    ocupacao = 0;
    data = new GregorianCalendar();
    hora = 0;
}

public RegOcupHoraPiso(String id, int ps, long ocupation, GregorianCalendar date, int hour){
    idRegOcupHora = id;
    piso = ps;
    ocupacao = ocupation;
    data = date;
    hora = hour;
}

public RegOcupHoraPiso(RegOcupHoraPiso ocupa){
    idRegOcupHora = ocupa.getIdRegOcupHora();
    piso = ocupa.getPiso();
    ocupacao = ocupa.getOcupacao();
    data = ocupa.getData();
    hora = ocupa.getHora();
}
public String getIdRegOcupHora(){return idRegOcupHora;}
public int getPiso(){return piso;}
public long getOcupacao(){return ocupacao;}
public GregorianCalendar getData(){return data;}
public int getHora(){return hora;}

public void setIdRegOcupHora(String id){idRegOcupHora = id;}
public void setPiso(int ps){piso = ps;}
public void setOcupacao(long ocupation){ocupacao = ocupation;}
public void setData(GregorianCalendar date){data = date;}
public void setHora(int hour){hora = hour;}

public RegOcupHoraPiso clone(){
    return new RegOcupHoraPiso(this);
}


public String toString() {
    StringBuilder s = new StringBuilder("---------------Ocupação por Piso------------\n");
    s.append("ID: " + idRegOcupHora + "\n");
    s.append("Piso: " + piso + "\n");
    s.append("Ocupação: " + ocupacao + "\n");
    s.append("Dia: " + data.get(data.YEAR) + "-" + data.get(data.MONTH) + "-" + data.get(data.DAY_OF_MONTH) + "\n");
    s.append("Hora: " + data.get(data.HOUR_OF_DAY) + "\n");
    return s.toString();
}

}
