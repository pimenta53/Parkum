/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Parkum;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author miguel
 */
public class Buster {

    private int capacidade;
    private int nVeiculosDentro;
    private boolean estado;
    private TreeMap<String,Pagamento> pagamentos;
    private TreeMap<String,FichaCliente> clientes;
    private TreeMap<String,Funcionario> funcionarios;
    private TreeMap<String,RegistoManutencao> manutencao;
    private TreeMap<String,Bilhete> bilhetes;
    private TreeMap<String,DispPreRegisto> dispositivos;
    private TreeMap<String,RegMovimento> registoMov;
    private TreeMap<String,RegOcupHoraPiso> registoOcupHoraPiso;
    private TreeMap<Integer,RegDiarioPiso> regDiaPiso;
    private TreeMap<String,MaqPagamento> regMaqPagamento;
    private TreeMap<String,Recibo> recibos;

    //Gestão

    public void addFichaCliente(FichaCliente cl){
        clientes.put(cl.getIdCliente(), cl.clone());
    }

    public void removeFichaCliente(String idCl){
        clientes.remove(idCl);
    }

    /*public TreeSet<Bilhete> listarPagAtraso(){
        TreeSet<Bilhete> pg = new TreeSet<Bilhete>();

        for(Bilhete bilh : bilhetes.values()){
            if (bilh.getProcessado()==false) pg.add(bilh);
        }

        return pg;
    }*/

/*public TreeSet<Bilhete> listarPagAtraso(){
        TreeSet<Bilhete> pg = new TreeSet<Bilhete>();

        GregorianCalendar data = new GregorianCalendar();

        for(Bilhete bilh : bilhetes.values()){
            if (bilh.getProcessado()==false && bilh.getClass().equals(BilheteDisp.class)) {
                BilheteDisp b = (BilheteDisp) bilh;
                DispViaVerde dispV;
                CartaoAvenca carA;

                PreRegisto reg = preRegisto.get(b.getIdDisp());

                if(reg.getClass().equals(DispViaVerde.class)){
                    dispV = (DispViaVerde) reg;

                    if(data.compareTo(dispV.getDataProxPagamento())>-1) pg.add(bilh);
                }

                if(reg.getClass().equals(CartaoAvenca.class)){
                    carA = (CartaoAvenca) reg;

                    if(data.compareTo(carA.getDataProxPagamento())>-1) pg.add(bilh);
                }

                if(reg.getClass().equals(DispMovel.class) || reg.getClass().equals(Matricula.class)){
                    pg.add(bilh);
                }

            }
        }

        return pg;
    }


    public void pagamentoAvencas(){
        GregorianCalendar data = new GregorianCalendar();

        BilheteDisp bilh;

        for(Bilhete b : bilhetes.values()){
            if(b.getClass().equals(BilheteDisp.class)) {
                bilh = (BilheteDisp) b;

                String idD = bilh.getIdDisp();

                PreRegisto pr = preRegisto.get(idD);

                DispViaVerde disp;

                if(pr.getClass().equals(CartaoAvenca.class)) {
                    disp = (DispViaVerde) pr;
                    if(data.compareTo(disp.getDataProxPagamento())>-1){//comparar datas
                        b.setTotal(0);
                        b.setProcessado(true);
                    }
                }

            }
        }

    }

    public void processarNaoViaVerde(){

        BilheteDisp bilh;

        for(Bilhete b : bilhetes.values()){
            if(b.getClass().equals(BilheteDisp.class)){
                bilh = (BilheteDisp) b;

                PreRegisto pR = preRegisto.get(bilh.getIdDisp());

                if(pR.getClass().equals(Matricula.class) || pR.getClass().equals(DispMovel.class)){
                    b.setTotal(0);
                    b.setProcessado(true);
                }

            }
        }
    }

    public void pagamentoViaVerde(){
        GregorianCalendar data = new GregorianCalendar();

        BilheteDisp bilh;

        for(Bilhete b : bilhetes.values()){
            if(b.getClass().equals(BilheteDisp.class)) {
                bilh = (BilheteDisp) b;

                String idD = bilh.getIdDisp();

                PreRegisto pr = preRegisto.get(idD);

                DispViaVerde disp;

                if(pr.getClass().equals(DispViaVerde.class)) {
                    disp = (DispViaVerde) pr;
                    if(data.compareTo(disp.getDataProxPagamento())>-1){//comparar datas
                        b.setTotal(0);
                        b.setProcessado(true);
                    }
                }

            }
        }

    }


    public String relatorioCliente(String idCl){
        int nEntradas;
        double valorMensal=0;
        int tempoMedio=0;

        nEntradas = clientes.get(idCl).getBilhetes().size();

        for(String idB : clientes.get(idCl).getBilhetes()){
                    Bilhete b = bilhetes.get(idB);
                    valorMensal = valorMensal+b.getTotal();
                    tempoMedio = (int) (((b.getDataSida().getTimeInMillis()-b.getDataEntrada().getTimeInMillis())/1000)/60) + tempoMedio;
        }

        tempoMedio=tempoMedio/nEntradas;

        StringBuilder s = new StringBuilder("-----Relatório de Utilização de "+ clientes.get(idCl).getNome() + "-----\n");
        s.append("Nº entradas: " + nEntradas+"\n");
        s.append("Tempo médio de estacionamento: " + valorMensal + "\n");
        s.append("Valor mensal: " + tempoMedio + " minutos");

        return s.toString();
    }



    public ParkumCSI(){
        capacidade=0;
        nVeiculosDentro=0;
        estado=true;      //true->livre; false->ocupado;
    }

    public ParkumCSI(int cap, int nVeiculoD, boolean est){
        capacidade=cap;
        nVeiculosDentro=nVeiculoD;
        estado=est;
    }

    public ParkumCSI(ParkumCSI park){
        capacidade=park.getCapacidade();
        nVeiculosDentro=park.getNVeiculosDentro();
        estado=park.getEstado();
    }

    public int getCapacidade(){return capacidade;}
    public int getNVeiculosDentro(){return nVeiculosDentro;}
    public boolean getEstado() {return estado;}

    public void setCapacidade(int cap){capacidade=cap;}
    public void setNVeiculosDentro(int nVeiculoD){nVeiculosDentro=nVeiculoD;}
    public void setEstado(boolean est){estado=est;}

    public void encrementaVeiculoDentro(){
        nVeiculosDentro++;
        if(nVeiculosDentro==capacidade) estado=false;
    }

    public void decrementaVeiculoDentro(){
        nVeiculosDentro--;
        if(!estado) estado=true;
    }
 *
 *---------------------/


    /*
     * Métodos necessarios implementacao
     */
   /*public void mudouEstadoLugar(int nPiso, int nLugar, boolean Estado){

   }*/
/* Codigo que pode vir a nao ser preciso
 *
   public void addRegistoMov(RegMovimento registo){
        registoMov.put(registo.getIdMovimento(), registo);
   }


   public void addRegistoOcupHoraPiso(RegOcupHoraPiso registoOcup){
        registoOcupHoraPiso.put(registoOcup.getIdRegOcupHora(), registoOcup);
   }

   public void addRegDiaPiso(RegDiarioPiso registoDiaPiso){
        regDiaPiso.put(registoDiaPiso.getPiso(), registoDiaPiso);
   }

    public RegMovimento getRegistoMov(String idMovimento) {
        RegMovimento reg = registoMov.get(idMovimento);
        if (reg==null)
            return reg;
        return reg.clone();
    }
    public RegOcupHoraPiso getRegistoOcupHoraPiso(String idRegOcupHora) {
        RegOcupHoraPiso reg = registoOcupHoraPiso.get(idRegOcupHora);
        if (reg==null)
            return reg;
        return reg.clone();
    }


    public RegDiarioPiso getRegDiaPiso(Integer piso) {
        RegDiarioPiso reg = regDiaPiso.get(piso);
        if (reg==null)
            return reg;
        return reg.clone();
    }

*/
   /*
    @Override
    public ParkumCSI clone(){return new ParkumCSI(this);}
    * 
    */

}
