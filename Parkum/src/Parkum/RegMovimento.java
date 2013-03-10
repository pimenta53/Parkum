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
public class RegMovimento {

    private String idMovimento;
    private int nPiso;
    private int nLugar;
    private boolean ficouLivre; //true - Livre; false - Ocupado
    private GregorianCalendar data;
    
    

    public RegMovimento(){
        idMovimento = "";
        data = new GregorianCalendar();
        ficouLivre = true;
        nLugar = 0;
        nPiso = 0;
    }

    public RegMovimento(String id, int ps, int lugar, boolean state, GregorianCalendar date){
        idMovimento = id;
        nPiso = ps;
        nLugar = lugar;
        ficouLivre = state;
        data = date;
    }

    public RegMovimento(RegMovimento mov){
        idMovimento = mov.getIdMovimento();
        nPiso = mov.getPiso();
        nLugar = mov.getNLugar();
        ficouLivre = mov.getFicouLivre();
        data = mov.getData();
    }

    public String getIdMovimento(){return idMovimento;}
    public GregorianCalendar getData(){return data;}
    public boolean getFicouLivre(){return ficouLivre;}
    public int getNLugar(){return nLugar;}
    public int getPiso(){return nPiso;}

    public void setIdMovimento(String id){idMovimento = id;}
    public void setData(GregorianCalendar date){data = date;}
    public void setFicouLivre(boolean state){ficouLivre = state;}
    public void setNLugar(int lugar){nLugar = lugar;}
    public void setPiso(int ps){nPiso = ps;}


    @Override
    public RegMovimento clone(){
        return new RegMovimento(this);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("--------------Movimento------------\n");
        s.append("ID Movimento: " + idMovimento + "\n");
        s.append("Data: " + data.get(data.YEAR) + "-" + data.get(data.MONTH) + "-" + data.get(data.DAY_OF_MONTH) + " " + data.get(data.HOUR_OF_DAY) + ":" + data.get(data.MINUTE)+"\n");
        s.append("Ficou Livre: " + ficouLivre + "\n");
        s.append("Numero Lugar: " + nLugar + "\n");
        s.append("Piso: " + nPiso + "\n");
        return s.toString();
    }
}
