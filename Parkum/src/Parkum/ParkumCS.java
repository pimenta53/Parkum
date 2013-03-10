package Parkum;

/**
 *
 * @author ricardo
 */
import java.util.*;

public class ParkumCS {

    private int capacidade;
    private int nVeiculosDentro;
    private boolean estaCheio;
    private TreeMap<String,InfoPiso> infoPisos;

    public ParkumCS(){
        infoPisos = new TreeMap<String,InfoPiso>();
    }

    public boolean getEstaCheio() {return estaCheio;}
    public int getCapacidade(){return capacidade;}
    public int getNVeiculosDentro(){return nVeiculosDentro;}
    private InfoPiso getInfoPiso(int nPiso) {               //Estacionar
        return infoPisos.get(Integer.toString(nPiso));
    }

    public void setEstaCheio(boolean est){estaCheio=est;}
    public void setCapacidade(int cap){capacidade=cap;}
    public void setNVeiculosDentro(int nVeiculoD){nVeiculosDentro=nVeiculoD;}

    public int getNPisos() {
        return infoPisos.size();
    }

    public HashSet<InfoPiso> getInfoPisos() {
        HashSet<InfoPiso> res = new HashSet<InfoPiso>();
        for (InfoPiso i:infoPisos.values())
            res.add(i.clone());
        return res;
    }

    //PISOS
    public void addInfoPiso(int nPiso, InfoPiso i) {
        infoPisos.put(Integer.toString(nPiso), i.clone());
    }

    //Gestao estacionar
        public void actualizarOcupPiso(int nPiso, int nLugar, boolean estaLivre) {
        InfoPiso piso = getInfoPiso(nPiso);
        int nLugaresLivres;

        if (estaLivre = true)
            piso.incrementarEntradas();
        else
            piso.incrementarSaidas();

        nLugaresLivres = piso.getNLugaresLivres();
    }

    public void registarSubidaPiso(int nPiso){              //Estacionar
        InfoPiso pAct = getInfoPiso(nPiso);
        InfoPiso pSeg = getInfoPiso(nPiso+1);
        pAct.incrementarSaidas();
        pSeg.incrementarEntradas();
    }

    public void registaDescidaPiso(int nPiso) {             //Estacionar
        InfoPiso pAct = getInfoPiso(nPiso);
        InfoPiso pSeg = getInfoPiso(nPiso-1);
        pAct.incrementarSaidas();
        pSeg.incrementarEntradas();
    }

    //Gestao entrar no parque
    public void incrementaNVeiculosDentro(){
        nVeiculosDentro++;
        if(capacidade==nVeiculosDentro) estaCheio=true;
    }

    public void decrementaNVeiculosDentro(){
        nVeiculosDentro--;
        if(estaCheio) estaCheio=false;
    }
    
    public void novaEntradaPiso(int nPiso) {
        InfoPiso info = getInfoPiso(nPiso);
        info.incrementarEntradas();
    }

    public void novaSaidaPiso(int nPiso) {
        InfoPiso info = getInfoPiso(nPiso);
        info.incrementarSaidas();
    }

    //PRINTS
    public String stringInfoPiso() {
        StringBuilder s = new StringBuilder("INFORMAÇÃO DOS PISOS\n\n");
        for (InfoPiso i: infoPisos.values()) {
            s.append(i.toString());
        }
        s.append("\n");
        return s.toString();
    }
}
