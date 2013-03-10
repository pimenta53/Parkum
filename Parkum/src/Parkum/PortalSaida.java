/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Parkum;

/**
 *
 * @author Cedric
 */
public class PortalSaida {

        private String idPortal;
        private int nPiso;

public PortalSaida(){
    idPortal = "";
    nPiso = 0;
    }

public PortalSaida(String id, int num){
    idPortal = id;
    nPiso = num;
    }

public PortalSaida(PortalSaida ps){
    idPortal = ps.getIdPorta();
    nPiso = ps.getNPiso();
}

public String getIdPorta() {return idPortal;}
public int getNPiso() {return nPiso;}

}