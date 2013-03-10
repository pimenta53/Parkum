/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Parkum;

/**
 *
 * @author Milton
 */
public abstract class Sensor {

    private String id;
    private int nPiso;


public Sensor(){
    id = "";
    nPiso = 0;
}

public Sensor(String id1, int piso){
    id = id1;
    nPiso = piso;
}

public Sensor(Sensor sensor1){
    id = sensor1.getId();
    nPiso = sensor1.getNPiso();
}


public String getId(){return id;}
public int getNPiso(){return nPiso;}

public void setId(String id1){id = id1;}
public void setNPiso(int piso){nPiso = piso;}

public String toString() {
    StringBuilder s = new StringBuilder("-------Sensor-------\n");
    s.append("ID: " + id + "\n");
    s.append("Piso: " + nPiso + "\n");
    return s.toString();
}

@Override
public abstract Sensor clone();

}

