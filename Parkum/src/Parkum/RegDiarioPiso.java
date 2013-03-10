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
public class RegDiarioPiso {

    private String idRegDiario;
    private int piso;
    private GregorianCalendar data;
    private int nEntradas;
    private int nSaidas;

public RegDiarioPiso(){
    idRegDiario = "";
    piso = 0;
    data = new GregorianCalendar();
    nEntradas = 0;
    nSaidas = 0;
}

public RegDiarioPiso(String idR, int ps, GregorianCalendar date, int entradas, int saidas){
    idRegDiario = idR;
    piso = ps;
    data = date;
    nEntradas = entradas;
    nSaidas = saidas;
}

public RegDiarioPiso(RegDiarioPiso diario){
    idRegDiario = diario.getIdRegDiario();
    piso = diario.getPiso();
    data = diario.getData();
    nEntradas = diario.getNEntradas();
    nSaidas = diario.getNSaidas();
}

public String getIdRegDiario(){return idRegDiario;}
public int getPiso(){return piso;}
public GregorianCalendar getData(){return data;}
public int getNEntradas(){return nEntradas;}
public int getNSaidas(){return nSaidas;}

public void setIdRegDiario(String id){idRegDiario=id;}
public void setPiso(int ps){piso = ps;}
public void setData(GregorianCalendar date){data = date;}
public void setNEntradas(int entradas){nEntradas = entradas;}
public void setNSaidas(int saidas){nSaidas = saidas;}

    @Override
public RegDiarioPiso clone(){
    return new RegDiarioPiso(this);
}

    @Override
public String toString() {
    StringBuilder s = new StringBuilder("---------------Registo Diário Piso------------\n");
    s.append("Id Registo: " + idRegDiario + "\n");
    s.append("Piso: " + piso + "\n");
    s.append("Data Registo: ");
    s.append(data.get(data.YEAR) + "-" + data.get(data.MONTH) + "-" + data.get(data.DAY_OF_MONTH)+"\n");
    s.append("Numero Entradas: " + nEntradas + "\n");
    s.append("Numero Saidas: " + nSaidas + "\n");
    return s.toString();
}









}
