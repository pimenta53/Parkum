/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Parkum;

/**
 *
 * @author miguel
 */
public class Lugar {
    
    private String id;
    private boolean estado;  //true->livre; false->ocupado;
    private int piso;

    public Lugar(){
        id="";
        estado=true;
        piso=0;
    }

    public Lugar(String id, boolean estado, int piso){
        this.id=id;
        this.estado=estado;
        this.piso=piso;
    }

    public Lugar(Lugar l){
        id=l.getId();
        estado=l.getEstado();
        piso=l.getPiso();
    }

    public String getId(){return id;}
    public boolean getEstado(){return estado;}
    public int getPiso(){return piso;}

    public void setId(String id){this.id=id;}
    public void setEstado(boolean estado){this.estado=estado;}
    public void setPiso(int piso){this.piso=piso;}

    @Override
    public Lugar clone(){return new Lugar(this);}

    public void alteraEstado(){
        if(estado) estado=false;
        else estado=true;
    }
}
