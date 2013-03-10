/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Parkum;

/**
 *
 * @author Milton
 */
public class SensorLugar extends Sensor{

    private int nLugar;
    private boolean estaLivre; //true - livre

    public SensorLugar(){
        super();
        nLugar = 0;
        estaLivre = true;
    }

    public SensorLugar (String id1, int piso, int lugar, boolean state){
        super(id1, piso);
        nLugar = lugar;
        estaLivre = state;
    }

    public SensorLugar(SensorLugar sLugar){
        super(sLugar);
        nLugar = sLugar.getNLugar();
        estaLivre = sLugar.getEstaLivre();
    }

    public int getNLugar(){return nLugar;}
    public boolean getEstaLivre(){return estaLivre;}

    public void setNLugar(int lugar){nLugar = lugar;}
    public void setEstaLivre(boolean state){estaLivre = state;}

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(super.toString());
        s.append("Lugar: " + nLugar + "\n");
        s.append("Esta Livre: " + estaLivre + "\n");
        return s.toString();
    }

    public SensorLugar clone(){
        return new SensorLugar(this);
    }
}
