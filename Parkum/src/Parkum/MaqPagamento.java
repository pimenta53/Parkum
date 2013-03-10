/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Parkum;

/**
 *
 * @author pimenta
 */
public class MaqPagamento {

    private String id;
    private int totalpagamDinheiro;
    private int totalpagamCartao;
    private double totalrecDinheiro;
    private double totalrecCartao;
    private int totalrecibos;
    private int nAvarias;
    private int nReparacoes;

    public MaqPagamento(){
        id="0";
        totalpagamDinheiro=totalpagamCartao=totalrecibos=nAvarias=nReparacoes=0;
        totalrecDinheiro=totalrecCartao=0.0;
    }

    public MaqPagamento(String id,int tpagd, int tpagc, double trecd, double trecc,int trec,int nA,int nR){
        this.id=id;
        totalpagamDinheiro=tpagd;
        totalpagamCartao = tpagc;
        totalrecCartao = trecc;
        totalrecDinheiro= trecd;
        totalrecibos=trec;
        nAvarias=nA;
        nReparacoes=nR;
    }

    public MaqPagamento(MaqPagamento mq){
        id=mq.getId();
        totalpagamDinheiro=mq.getPagamDinheiro();
        totalpagamCartao=mq.getPagamCartao();
        totalrecCartao=mq.getrecCartao();
        totalrecDinheiro=mq.getrecDinheiro();
        totalrecibos=mq.getTotalRecibos();
        nAvarias=mq.getAvarias();
        nReparacoes=mq.getReparacoes();

    }

    public String getId(){
        return id;
    }
    public int getPagamDinheiro(){
        return totalpagamDinheiro;
    }

    public int getPagamCartao(){
        return totalpagamCartao;
    }

    public double getrecDinheiro(){
        return totalrecDinheiro;
    }

    public double getrecCartao(){
        return totalrecCartao;
    }

    public int getTotalRecibos(){
        return totalrecibos;
    }

    public int getAvarias(){
        return nAvarias;
    }

    public int getReparacoes(){
        return nReparacoes;
    }

    public void setId(String nid){
        id=nid;
    }
    public void setPagamDinheiro(int tpd){
        totalpagamDinheiro = tpd;
    }
    public void setPagamCartao(int tpc){
        totalpagamCartao = tpc;
    }
    public void setRecDinheiro(double tcd){
        totalrecDinheiro = tcd;
    }

    public void setRecCartao(double tcc){
        totalrecCartao = tcc;
    }

    public void setTotalRecibos(int tr){
        totalrecibos=tr;
    }

    public void setAvarias(int na){
        nAvarias=na;
    }

    public void setReparacoes(int nr){
        nReparacoes=nr;
    }

    public void incrementaReparacoes(){//maquina pagamentos
        nReparacoes++;
    }

    public void incrementaAvarias(){//maquina pagamentos
        nAvarias++;
    }

    public void incrementaRecibos(){//maquina pagamentos
        totalrecibos++;
    }

    public void incrementaPagamDinheiro(){//maquina pagamentos
        totalpagamDinheiro++;
    }

    public void incrementaPagamCartao(){//maquina pagamentos
        totalpagamCartao++;
    }

    public void incrementaRecDinheiro(double valor){//maquina pagamentos
        totalrecDinheiro+=valor;
    }

    public void incrementaRecCartao(double valor){//maquina pagamentos
        totalrecCartao+=valor;
    }


    public double percentagemRecibos(){
        if (totalpagamCartao>0 || totalpagamDinheiro>0) {
            return totalrecibos/(totalpagamCartao+totalpagamDinheiro);
        }    
        return 0;
    }

        @Override
    public MaqPagamento clone(){
        return new MaqPagamento(this);
    }

    public String toString() {
        StringBuilder s  = new StringBuilder("--------MaqPagamento-------\n");
        s.append("ID maquina: " + id + "\n");
        s.append("Total Pagamentos Dinheiro: " + totalpagamDinheiro + "\n");
        s.append("Total Pagamentos MB: " + totalpagamCartao + "\n");
        s.append("Total Recebido Dinheiro: " + totalrecDinheiro + "\n");
        s.append("Total Recebido MB: " + totalrecCartao + "\n");
        s.append("Numero recibos emitidos: " + totalrecibos + "\n");
        s.append("Numero avarias: " + nAvarias + "\n");
        s.append("Numero reparações: " + nReparacoes + "\n");
        return s.toString();
    }

    public boolean equals(MaqPagamento mp){
        if (mp.getId().equals(this.id)) return true;
        else return false;
    }

}