/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Parkum;

import java.util.GregorianCalendar;
import java.util.*;
/**
 *
 * @author Milton
 */
public class Registos {
    private String idRegMan; //registo manutensao
    private String idRegOcupHora; //ID de registo de ocupacao por hora de piso
    private String idRecibo; //ID recibo
    private String idRegDiarioPiso; //ID de registo de ocupacao diaria do piso
    private String idRegMov;

    private TreeMap<String,RegistoManutencao> regManutencao;        //manutencao das maquinas
    private TreeMap<String,RegOcupHoraPiso> registoOcupHoraPiso;
    private TreeMap<String,RegDiarioPiso> regDiaPiso;
    private TreeMap<String,RegMovimento> registoMov;

    public Registos() {
        idRegMan="0";
        idRegOcupHora="0";
        idRecibo="0";
        idRegDiarioPiso="0";
        idRegMov="0";
        regManutencao = new TreeMap<String,RegistoManutencao>();
        registoOcupHoraPiso =new TreeMap<String,RegOcupHoraPiso>();
        regDiaPiso = new TreeMap<String,RegDiarioPiso>();
        registoMov = new TreeMap<String,RegMovimento>();
    }

    public Registos(String idRegMan, String idRegOcupHora, String idRecibo, String idRegDiarioPiso, String idRegMov, TreeMap<String,RegistoManutencao> regMan, TreeMap<String,RegOcupHoraPiso> regOP, TreeMap<String,Recibo> rcb, TreeMap<String,RegDiarioPiso> regDP, TreeMap<String,RegMovimento> regMov) {
        this.idRegMan=idRegMan;
        this.idRegOcupHora=idRegOcupHora;
        this.idRecibo=idRecibo;
        this.idRegDiarioPiso=idRegDiarioPiso;
        this.idRegMov=idRegMov;
        regManutencao = regMan;
        registoOcupHoraPiso = regOP;
        regDiaPiso = regDP;
        registoMov = regMov;
    }

    //GETS
    public Set<RegOcupHoraPiso> getRegsOcupHoraPiso() {
        HashSet<RegOcupHoraPiso> regs = new HashSet<RegOcupHoraPiso>();
        for (RegOcupHoraPiso r : registoOcupHoraPiso.values())
            regs.add(r.clone());
        return regs;
    }

    public Set<RegDiarioPiso> getRegsDiaPiso() {
        HashSet<RegDiarioPiso> regs = new HashSet<RegDiarioPiso>();
        for (RegDiarioPiso r : regDiaPiso.values())
            regs.add(r.clone());
        return regs;
    }

    public Set<RegMovimento> getRegsMov() {
        HashSet<RegMovimento> regs = new HashSet<RegMovimento>();
        for (RegMovimento r : registoMov.values())
            regs.add(r.clone());
        return regs;
    }

    //SETS
    public void setIdRegHora(String id) {idRegOcupHora=id;}
    public void setIdMov(String id) {idRegMov=id;}


    //GERAR IDS
    public String gerarIdRegDia() {
        int id = Integer.parseInt(idRegDiarioPiso);
        id++;
        idRegDiarioPiso = Integer.toString(id);
        return idRegDiarioPiso;
    }

    public String gerarIdOcupHora() {
        int id = Integer.parseInt(idRegOcupHora);
        id++;
        idRegOcupHora = Integer.toString(id);
        return idRegOcupHora;
    }

    public String gerarIdRegMan() {
        int id = Integer.parseInt(idRegMan);
        id++;
        idRegMan = Integer.toString(id);
        return idRegMan;
    }
    
    public String gerarIdRegMovimento() {
        int id = Integer.parseInt(idRegMov);
        id++;
        idRegMov = Integer.toBinaryString(id);
        return idRegMov;
    }


    //FUNCOES ADICIONAR
    public void addRegMan(String id, RegistoManutencao reg) {
        regManutencao.put(id,reg);
    }

    public void addRegMov(String id, RegMovimento reg) {
        registoMov.put(id,reg);
    }

    public void addRegHoraPiso(String id, RegOcupHoraPiso r) {
        registoOcupHoraPiso.put(id,r);
    }

    public void addRegDiaPiso(String id, RegDiarioPiso r) {
        regDiaPiso.put(id,r);
    }

    
    //PRINT REGISTOS
    public String printRegMov() {
        StringBuilder s = new StringBuilder("Registo Movimentos\n\n");
        for (RegMovimento r: registoMov.values()) {
            s.append(r.toString());
        }
        s.append("\n");
        return s.toString();
    }

    public String printRegHoraDia(GregorianCalendar g) {
        GregorianCalendar g1;
        int y,m,d,y1,m1,d1;
        y=g.get(g.YEAR);
        m=g.get(g.MONTH);
        d=g.get(g.DAY_OF_MONTH);

        StringBuilder s = new StringBuilder("Registo Ocupacao hora diaria\n\n");
        for (RegOcupHoraPiso r: registoOcupHoraPiso.values()) {
            g1=r.getData();
            y1=g1.get(g1.YEAR);
            m1=g1.get(g1.MONTH);
            d1=g1.get(g1.DAY_OF_MONTH);
            if (y1==y && m1==m && d1==d)
            s.append(r.toString());
        }
        s.append("\n");
        return s.toString();
    }

    //RELATORIO
    public boolean eDataIgual(GregorianCalendar g, GregorianCalendar g1) {
        int y1,y2,m1,m2,d1,d2;
        y2=g.get(g.YEAR);
        m2=g.get(g.MONTH);
        d2=g.get(g.DAY_OF_MONTH);
        y1=g1.get(g1.YEAR);
        m1=g1.get(g1.MONTH);
        d1=g1.get(g1.DAY_OF_MONTH);

        return (y1==y2 && m1==m2 && d1==d2);
    }

     //Relatorio de saidas e entradas
    public String relEntSaidas(GregorianCalendar date, TreeMap<String,Bilhete> bilhetes){
        int ent, entIt, totE;
        int sai, saiIt, totS;
 
        GregorianCalendar d,dt1,dt2;

        //calcula total de saidas e entradas
        ent=entIt=totE=sai=saiIt=totS=0;

        StringBuilder s = new StringBuilder("---------------Relatório de Movimentos/Dia no Parque------------\n");
        s.append("----Dia: " + date.get(date.YEAR) + "/" + date.get(date.MONTH) + "/" + date.get(date.DAY_OF_MONTH) + "---- \n \n");
        
        for(RegDiarioPiso reg : regDiaPiso.values()) {
            dt1 = reg.getData();
            if(dt1.equals(date)){
                dt2=new GregorianCalendar(dt1.get(dt1.YEAR),dt1.get(dt1.MONTH),dt1.get(dt1.DAY_OF_MONTH)-1);
                for(RegDiarioPiso reg1 : regDiaPiso.values()) {
                    if(reg.getPiso()==reg1.getPiso() && dt2.equals(reg1.getData())){
                        System.out.println(reg1.getIdRegDiario() + "-" + reg.getIdRegDiario());
                        saiIt = entIt = 0;
                        entIt=reg.getNEntradas()-reg1.getNEntradas();
                        saiIt=reg.getNSaidas()-reg1.getNSaidas();
                        s.append("---Piso: " + reg.getPiso() + "--- \n");
                        s.append("Nº Entradas: " + entIt + "\n");
                        s.append("Nº Saidas: " + saiIt + "\n\n");
                        if (reg.getPiso()==1) {
                            totE+=entIt;
                            totS+=saiIt;
                            //ent+=reg.getNEntradas();
                            //sai+=reg.getNSaidas();
                        }
                    }
                }
            }
        }
        s.append("Total Entradas no parque: " + totE + "\n");
        s.append("Total Saidas do parque: " + totS + " \n");
        s.append("Veiculos que ficaram dentro do parque: " + (totE-totS) + "\n\n");
        s.append(tempoPagSaida(date,bilhetes));
        
        
        return s.toString();
    }

    //Calcula e apresenta tempos entre saida e pagamentos
    public String tempoPagSaida(GregorianCalendar date, TreeMap<String,Bilhete> bilhetes) {
        int y1, m1, d1;
        GregorianCalendar d;

        y1 = date.get(date.YEAR);
        m1 = date.get(date.MONTH);
        d1 = date.get(date.DAY_OF_MONTH);

        StringBuilder s = new StringBuilder();
        s.append("----Tempos entre pagamentos e saidas---- \n");
        for(Bilhete bi : bilhetes.values()){
            long pag = 0;
            long said = 0;
            long temp = 0;
            if(bi instanceof BilheteAnonim){
                d = bi.getDataSida();
                if (d!=null && y1==d.get(d.YEAR) && m1==d.get(d.MONTH) && d1==d.get(d.DAY_OF_MONTH)) {
                    BilheteAnonim bi1 = (BilheteAnonim) bi;
                    s.append("Bilhete: " + bi.getIdBilhete() + "\n");
                    pag = bi1.getDataPagamento().getTimeInMillis();
                    said = bi1.getDataSida().getTimeInMillis();
                    temp = said-pag;
                    s.append(temp/1000/60 + " Minutos\n");
                }
            }
        }
        return s.toString();
    }
    
    //Tabela de distribuições diario
    public String tabelaDist(GregorianCalendar date){
        StringBuilder s = new StringBuilder("---------------Tabela de Distribuição------------\n");
        s.append("----Dia: " + date.get(date.YEAR)+ "/" + date.get(date.MONTH) + "/" + date.get(date.DAY_OF_MONTH) + "---- \n \n");
        s.append("Hora  Piso  Ocupação \n");
        for(RegOcupHoraPiso reg  : registoOcupHoraPiso.values()){
            if (eDataIgual(reg.getData(),date)) {
                s.append(reg.getHora() + "h  ");
                s.append("  " + reg.getPiso() + "   ");
                s.append("  " + reg.getOcupacao() + "\n");
            }
        }
        return s.toString();
    }
}