/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Parkum;

/**
 *
 * @author Milton
 */
public class SensorPiso extends Sensor{

    private boolean descida;

public SensorPiso(){
    super();
    descida = false;
}

public SensorPiso(String id1, int piso, boolean desce){
    super(id1, piso);
    descida = desce;
}

public SensorPiso(SensorPiso sp){
    super(sp);
    descida = sp.getDescida();
}

public boolean getDescida(){return descida;}
public void setDescida(boolean desce){descida = desce;}

/*
 * Métodos usados nos diagramas
 */

public SensorPiso clone(){
    return new SensorPiso(this);
}
}

