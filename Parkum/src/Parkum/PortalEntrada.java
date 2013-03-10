/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Parkum;

/**
 *
 * @author ricardo
 */
public class PortalEntrada {
    private int nPiso;

    public PortalEntrada() {
        nPiso = 0;
    }

    public PortalEntrada(int num) {
        this.nPiso = num;
    }

    public PortalEntrada(PortalEntrada p) {
        nPiso = p.getNumPiso();
    }

    public int getNumPiso() { return nPiso; }
    public void getNumPiso(int num) { nPiso = num; }

    public String toString() {
        return Integer.toString(nPiso);
    }

    public PortalEntrada clone() {
        return new PortalEntrada(this);
    }
}
