/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Parkum;

/**
 *
 * @author ricardo
 */
    public class InfoPiso {
        private int nPiso;
        private int nLugares;
        private int nLugaresLivres;
        private long nEntradas;
        private long nSaidas;


    public InfoPiso(){
        nPiso = 0;
        nLugares = 0;
        nLugaresLivres = 0;
        nEntradas = 0;
        nSaidas = 0;
    }

    public InfoPiso(int piso, int lugares, int lugaresLivres, long entradas, long saidas){
        nPiso = piso;
        nLugares = lugares;
        nLugaresLivres = lugaresLivres;
        nEntradas = entradas;
        nSaidas = saidas;
    }

    public InfoPiso(InfoPiso ip){
        nPiso = ip.getNPiso();
        nLugares = ip.getNLugares();
        nLugaresLivres = ip.getNLugaresLivres();
        nEntradas = ip.getNEntradas();
        nSaidas = ip.getNSaidas();
    }


    public int getNPiso(){return nPiso;}
    public int getNLugares(){return nLugares;}
    public int getNLugaresLivres(){return nLugaresLivres;}
    public long getNEntradas() {return nEntradas;}
    public long getNSaidas(){return nSaidas;}

    public void setNPiso(int piso){nPiso = piso;}
    public void setNLugares(int lugares){nLugares = lugares;}
    public void setNLugaresLivres(int lugaresLivres){nLugaresLivres = lugaresLivres;}
    public void setNEntradas(long entradas){nEntradas = entradas;}
    public void setNSaidas(long saidas){nSaidas = saidas;}


    /*
     * Métodos necessários para implementacao
     */

    public void incrementarSaidas() {
        nSaidas++;
        nLugaresLivres++;
    }

    public void incrementarEntradas() {
        nEntradas++;
        nLugaresLivres--;
    }

    public InfoPiso clone(){
        return new InfoPiso(this);
    }


    public String toString() {
        StringBuilder s = new StringBuilder("--------------Informações do Piso------------\n");
        s.append("Numero do Piso: " + nPiso + "\n");
        s.append("Numero de Lugares: " + nLugares + "\n");
        s.append("Numero de Lugares Livres: " + nLugaresLivres + "\n");
        s.append("Numero de Entradas: " + nEntradas + "\n");
        s.append("Numero de Saidas: " + nSaidas + "\n\n");
        return s.toString();
    }
}
