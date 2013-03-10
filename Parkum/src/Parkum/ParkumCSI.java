 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Parkum;

import java.util.GregorianCalendar;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.HashSet;

/** 
 *
 * @author miguel
 */
public class ParkumCSI {

    private String nipc;
    private String idCliente;
    private String idFuncionario;
    private String idBilhete;
    private String idPreReg;
    private String idRecibo;
    private GregorianCalendar dateAct;

    private TreeMap<String,FichaCliente> clientes;
    private TreeMap<String,Funcionario> funcionarios;
    private TreeMap<String,Bilhete> bilhetes;
    private TreeMap<String,DispPreRegisto> preRegistados;
    private TreeMap<String,Recibo> recibos;
    private TreeMap<String,MaqPagamento> maquinasP;
    
    private ParkumCS pCS; //ParkumCS modulo do SCI
    private Registos reg; //Registos das várias acções

    public ParkumCSI(){
        nipc="";
        idCliente="0";
        idFuncionario="0";
        idBilhete="0";
        idPreReg="0";
        idRecibo="0";
        clientes = new TreeMap<String,FichaCliente>();
        funcionarios=new TreeMap<String,Funcionario>();
        bilhetes = new TreeMap<String,Bilhete>();
        preRegistados = new TreeMap<String,DispPreRegisto>();
        recibos = new TreeMap<String,Recibo>();
        maquinasP = new TreeMap<String,MaqPagamento>();
        pCS = new ParkumCS();
        reg = new Registos();
    }

    //METODOS GET
    public String getNipc() {return nipc; }
    public String getIdCliente() {return idCliente; }
    public String getIdFuncionario() {return idFuncionario; }
    public String getIdBilhete() {return idBilhete; }
    public String getIdPreReg() {return idPreReg; }
    public String getIdRecibo() {return idRecibo; }
    public GregorianCalendar getDate() {return dateAct; }

    public FichaCliente getFichaCliente(String cl){
        return clientes.get(cl);
    }

    public DispPreRegisto getDispPreReg(String id) {
        return preRegistados.get(id);
    }

    //Metodos SET
    public void setNipc(String np) { nipc=np; }
    public void setIdCliente(String idC) { idCliente=idC; }
    public void setIdFuncionario(String idF) { idFuncionario=idF; }
    public void setIdBilhete(String idB) { idBilhete=idB; }
    public void setIdPreReg(String idPR) { idPreReg=idPR; }
    public void setIdRecibo(String idR) { idRecibo=idR; }
    public void setDate(GregorianCalendar g) { dateAct=g; }
    public void setIdRegHora(String id) {reg.setIdRegHora(id);}
    public void setIdMov(String id) {reg.setIdMov(id);}

    
    public static GregorianCalendar copyDate(GregorianCalendar d1) {
        GregorianCalendar g = new GregorianCalendar(d1.get(d1.YEAR),d1.get(d1.MONTH),d1.get(d1.DAY_OF_MONTH),d1.get(d1.HOUR_OF_DAY),d1.get(d1.MINUTE));
        return g;
    }

    //METODOS EXISTS
    public boolean existeCliente(String id) {
        return clientes.containsKey(id);
    }

    //METODOS ADICIONAR
    public void addFichaCliente(FichaCliente cl){
        clientes.put(cl.getIdCliente(), cl.clone());
    }

    public void addFuncionario(Funcionario f){
        funcionarios.put(f.getIdFuncionario(), f.clone());
    }

    public void addBilhete(Bilhete b){
        bilhetes.put(b.getIdBilhete(), b);
    }

    public void addDispPreReg(DispPreRegisto p){
        preRegistados.put(p.getIdPreRegisto(),p);
    }

    public void addMaqPagamento(MaqPagamento maq){
        maquinasP.put(maq.getId(), maq.clone());
    }

    public void addRecibo(Recibo rec){
        recibos.put(rec.getIdReceb(), rec.clone());
    }

    public void addManutencao(RegistoManutencao r){
        reg.addRegMan(r.getIdRegistoManutencao(), r.clone());
    }

    public void addRegMovimento(RegMovimento r){
        reg.addRegMov(r.getIdMovimento(), r.clone());
    }

    public void addRegOcupHoraPiso(RegOcupHoraPiso r){
        reg.addRegHoraPiso(r.getIdRegOcupHora(),r.clone());
    }

    public void addRedDiarioPiso(RegDiarioPiso r){
        reg.addRegDiaPiso(r.getIdRegDiario(), r.clone());
    }

    public void addInfoPiso(InfoPiso i){
        pCS.addInfoPiso(i.getNPiso(), i.clone());
    }

    //METODOS REMOVE
    public void removeFichaCliente(String idCl){
            clientes.remove(idCl);
    }

    //METODOS CONSULTAS
    public String printClientes() {
        StringBuilder s = new StringBuilder("FICHAS CLIENTES\n\n");
        for (FichaCliente c: clientes.values()) {
            s.append(c.toString());
        }
        s.append("\n");
        return s.toString();
    }


    public String printFuncionarios() {
        StringBuilder s = new StringBuilder("FICHAS FUNCIONARIOS\n\n");
        for (Funcionario f: funcionarios.values()) {
            s.append(f.toString());
        }
        s.append("\n");
        return s.toString();
    }

    public String printDispositivos() {
        StringBuilder s = new StringBuilder("FICHAS DISPOSITIVOS\n\n");
        for (DispPreRegisto d: preRegistados.values()) {
            s.append(d.toString());
        }
        s.append("\n");
        return s.toString();
    }

    public String printBilhetes() {
        StringBuilder s = new StringBuilder("BILHETES\n\n");
        for (Bilhete b: bilhetes.values()) {
            s.append(b.toString());
        }
        s.append("\n");
        return s.toString();
    }

    public String printRecibos() {
        StringBuilder s = new StringBuilder("Recibos\n\n");
        for (Recibo r: recibos.values()) {
            s.append(r.toString());
        }
        s.append("\n");
        return s.toString();
    }

    public String printInfoPiso() {
        return pCS.stringInfoPiso();
    }

    public String printRegMov() {
        return reg.printRegMov();
    }
    
    public String printRegHoraDia() {
        return reg.printRegHoraDia(dateAct);
    }


    //Geracão de IDs
    public String gerarIdBilhete() {
        int id = Integer.parseInt(idBilhete);
        id++;
        idBilhete = Integer.toBinaryString(id);
        return idBilhete;
    }

    public String gerarIdCliente() {
        int id = Integer.parseInt(idCliente);
        id++;
        idCliente = Integer.toString(id);
        return idBilhete;
    }

    public String gerarIdRecibo() {
        int id = Integer.parseInt(idRecibo);
        id++;
        idRecibo = Integer.toString(id);
        return idRecibo;
    }

    public double pagarQuantia(String idB,boolean extra, double preco){ // saber a quantidade --pagar
        
        Bilhete b = bilhetes.get(idB);
        GregorianCalendar e;
        if(extra) e =b.getDataEntrada();else e=b.getDataSida();// ver se extra ou não

        GregorianCalendar pag=new GregorianCalendar();
        
        long tempo=(e.getTimeInMillis()-pag.getTimeInMillis()*60*1000);
        String tipo;
        double total=tempo*preco;
        return total;
    }
    
    public double pagarMaquina(String idM, String idr, boolean dinheiro,boolean rec,String idB,boolean extra, double quantia){// pagar maquina MPA + pagar extra ++ troco
        GregorianCalendar dE,dP;
        MaqPagamento mp = maquinasP.get(idM);
        BilheteAnonim b = (BilheteAnonim) bilhetes.get(idB);
        String tipo;

        if(extra) dE=b.getDataPagamento();else dE=b.getDataEntrada();// ver se extra ou não
        dP=copyDate(dateAct);

        int tempo=(int) ((dP.getTimeInMillis()-dE.getTimeInMillis())/1000/60);
        if (dP.get(dP.MONTH)==dE.get(dE.MONTH)+1) tempo-=1440;
        double total=tempo*0.01;//preco

        b.setDataPagamento(dP);
        b.setTotal(total);

        if(dinheiro){
            mp.incrementaPagamDinheiro();
            mp.incrementaRecDinheiro(total);
            tipo="Dinheiro";
        }
        else{
            mp.incrementaPagamCartao();
            mp.incrementaRecCartao(total);
            tipo="MB";
        }
        if(rec) mp.incrementaRecibos();

        Recibo r = new Recibo(nipc, idM, idr, idB, tempo, dE, dP,total, tipo);
        recibos.put(idr, r.clone());

        return quantia-total;
    }

    //GESTAO ESTACIONAMENTO
    public void mudarEstadoLugar(int nPiso, int nLugar, boolean estaLivre) {
        String id = reg.gerarIdRegMovimento();
        GregorianCalendar date = getDate();
        RegMovimento regist = new RegMovimento(id,nPiso,nLugar,estaLivre,date);
        registarEstadoLugar(regist.clone());
        pCS.actualizarOcupPiso(nPiso, nLugar, estaLivre);
    }

    public void registarEstadoLugar(RegMovimento regM) {
        reg.addRegMov(regM.getIdMovimento(),regM);
    }


    //GESTAO BILHETES
    public void criarBilheteAnonim() {
        String id = this.gerarIdBilhete();
        GregorianCalendar date = new GregorianCalendar();
        BilheteAnonim b = new BilheteAnonim(id);
    }

    
   //GESTAO CLIENTES
    public TreeSet<Bilhete> listarPagAtraso() {
        TreeSet<Bilhete> pg = new TreeSet<Bilhete>();

        for(Bilhete bilh : bilhetes.values()){
            if (bilh.getProcessado()==false) pg.add(bilh);
        }

        return pg;
    }

    public TreeSet<String> listarClientesPagAtraso(){
        TreeSet<String> pgCl = new TreeSet<String>();
        DispViaVerde dispV;
        DispAvenca carA;
        
        for(Bilhete bilh : bilhetes.values()){
            if (bilh.getProcessado()==false && bilh.getDataSida()!=null && bilh.getClass().getName().equals("Parkum.BilheteDisp")) {

                BilheteDisp b = (BilheteDisp) bilh;
                DispPreRegisto reg = preRegistados.get(b.getIdDisp());

                if(reg.getClass().equals(DispViaVerde.class)){
                    dispV = (DispViaVerde) reg;    
                    if(dateAct.compareTo(dispV.getDataProxPagamento())>0) pgCl.add(dispV.getIdCliente());
                }

                if(reg.getClass().equals(DispAvenca.class)){
                    carA = (DispAvenca) reg;
                    if(dateAct.compareTo(carA.getDataProxPagamento())>0) pgCl.add(carA.getIdCliente());
                }
            }
        }
        return pgCl;
    }


    public String pListaAtraso(){
        TreeSet<String> tree = listarClientesPagAtraso();
        StringBuilder s = new StringBuilder("---------------Lista Clientes com Pagamentos em Atraso------------\n");
        for(String id : tree){ s.append("Id Cliente: " + id + "\n");}
        return s.toString();
    }

    public double calcularTempo(GregorianCalendar d1, GregorianCalendar d2) {
        Long t1 = d1.getTimeInMillis();
        Long t2 = d2.getTimeInMillis();
        
        return ((t2-t1)/1000)/60;
    }

    public void actDatasDisp(String idDisp) {
        GregorianCalendar g;
        DispAvenca av;
        String tipoAv;
        int m;

        av =(DispAvenca) preRegistados.get(idDisp);
        g = av.getDataProxPagamento();
        m = g.get(g.MONTH);
        tipoAv = av.getTipoAvenca();

        if (tipoAv.equals("Mensal")) {
            m++;
            g.set(g.MONTH, m);
        } else {
            if (tipoAv.equals("Trimestral")) {
                m+=3;
                g.set(g.MONTH, m);
            } else {
                m+=6;
                g.set(g.MONTH, m);
            }
        }
    }

    public void pagamentoAvencas(String idDisp,String tipoPag) {
        
        BilheteDisp bilh;
        DispAvenca disp;

        for(Bilhete b : bilhetes.values()){
            if(b.getProcessado()==false && b.getDataSida()!=null && b.getClass().equals(BilheteDisp.class)) {
                bilh = (BilheteDisp) b;

                String idD = bilh.getIdDisp();
                DispPreRegisto pr = preRegistados.get(idD);

                if(idDisp.equals(idD)) {
                    disp = (DispAvenca) pr;
                    if(dateAct.compareTo(disp.getDataProxPagamento())>0){//comparar datas
                        b.setProcessado(true);
                        
                        Recibo rcb = new Recibo(nipc,null,gerarIdRecibo(),bilh.getIdBilhete(),(int) calcularTempo(bilh.getDataEntrada(),bilh.getDataSida()),bilh.getDataEntrada(),dateAct,bilh.getTotal(),tipoPag);
                        recibos.put(rcb.getIdReceb(),rcb.clone());
                        
                        System.out.println("Processado: " + bilh.getIdBilhete());
                    }
                }

            }
        }
        actDatasDisp(idDisp);
    }

    public void processarNaoViaVerde(){

        BilheteDisp bilh;

        for(Bilhete b : bilhetes.values()){
            if(b.getClass().equals(BilheteDisp.class)){
                bilh = (BilheteDisp) b;

                DispPreRegisto pR = preRegistados.get(bilh.getIdDisp());

                if(pR.getClass().equals(DispMatricula.class) || pR.getClass().equals(DispMovel.class)){
                    b.setTotal(0);
                    b.setProcessado(true);
                }

            }
        }
    }

    public void pagamentoViaVerde(){

        BilheteDisp bilh;
        GregorianCalendar g;
        DispAvenca av;
        int m;

        if(dateAct.get(dateAct.DAY_OF_MONTH)==1) {
            
            for(Bilhete b : bilhetes.values()){
                if(b.getProcessado()==false && b.getClass().equals(BilheteDisp.class)) {
                    bilh = (BilheteDisp) b;
                    String idD = bilh.getIdDisp();
                    DispPreRegisto pr = preRegistados.get(idD);

                    DispViaVerde disp;
                    if(pr.getClass().equals(DispViaVerde.class)) {
                        disp = (DispViaVerde) pr;
                        b.setProcessado(true);
                        //RECIBO
                        Recibo rcb = new Recibo(nipc,null,gerarIdRecibo(),bilh.getIdBilhete(),(int) calcularTempo(bilh.getDataEntrada(),bilh.getDataSida()),bilh.getDataEntrada(),dateAct,bilh.getTotal(),"Deb Dir");
                        recibos.put(rcb.getIdReceb(),rcb.clone());

                        g = disp.getDataProxPagamento();
                        m = g.get(g.MONTH);
                        m++;
                        g.set(g.MONTH, m);

                        System.out.println("Processado: " + bilh.getIdBilhete());
                    }
                }
            }
        }
    }


    //RELATORIOS
    public String relatorioCliente(String idCl, int ano, int mes){
        int nEntradas=0;
        double valorMensal=0;
        int tempoMedio=0;

        if (clientes.get(idCl).getBilhetes().size()>0) {
            for(String idB : clientes.get(idCl).getBilhetes()){
                BilheteDisp b =(BilheteDisp) bilhetes.get(idB);
                GregorianCalendar g = b.getDataSida();
                if(g!=null && (g.get(g.YEAR)==ano) && (g.get(g.MONTH)==mes)) {
                    System.out.println("id: " + idB);
                    valorMensal = valorMensal+b.getTotal();
                    nEntradas++;
                    tempoMedio = (int) (((b.getDataSida().getTimeInMillis()-b.getDataEntrada().getTimeInMillis())/1000)/60) + tempoMedio;
                }                    
                
            }
            if (nEntradas>0) tempoMedio=tempoMedio/nEntradas;
        }

        StringBuilder s = new StringBuilder("-----Relatório de Utilização de "+ clientes.get(idCl).getNome() + "-----\n");
        s.append("Nº entradas: " + nEntradas+"\n");
        s.append("Tempo médio de estacionamento: " + tempoMedio + "\n");
        s.append("Valor mensal: " + valorMensal + "€");
        
        return s.toString();
    }

    public String relEntSaidas(GregorianCalendar date) {
        return reg.relEntSaidas(date,bilhetes);
    }
    //Facturação por tipo de pagamento
    public String relFacturacao(GregorianCalendar date) {

        int nfac = 0;
        double totalDb = 0.0;
        double totalDinh = 0.0;
        double totalMb = 0.0;
        GregorianCalendar d;

        StringBuilder s = new StringBuilder("---------------Facturação Diária de Pagamentos------------\n");
        for(Recibo fac : recibos.values()){
            reg.eDataIgual(fac.getDPagamento(),(date));
            if(reg.eDataIgual(fac.getDPagamento(),(date))){
                if (fac.getTipoPagamento().equals("MB"))
                    totalMb += fac.getPreco();
                else {
                    if (fac.getTipoPagamento().equals("Deb Dir"))
                        totalDb += fac.getPreco();
                    else
                        totalDinh += fac.getPreco();
                }
            }
        }
        s.append("\n" + "----Total Dinheiro: " + totalDinh + "---- \n");
        s.append("\n" + "----Total Multibanco: " + totalMb + "---- \n");
        s.append("\n" + "----Total Débito directo: " + totalDb + "---- \n");
        return s.toString();
    }

    public String relTabelaDist(GregorianCalendar calendar) {
        return reg.tabelaDist(calendar);
    }

    //Relatorio de determinada maquina de pagamento
    public String relMaquina(String id){
        MaqPagamento rel;
        StringBuilder s = new StringBuilder();
        if ((rel=maquinasP.get(id))!=null) {
            s.append("---------------Relatório Máquina------------\n");
            s.append("ID da máquina: " + rel.getId() + "\n");
            s.append("Nº Pagamentos em dinheiro: " + rel.getPagamDinheiro() + "\n");
            s.append("Nº pagamentos com cartão magnético: " + rel.getPagamCartao() + "\n");
            s.append("Valor pago em dinheiro: " + rel.getrecDinheiro() + "\n");
            s.append("Valor pago com cartão: " + rel.getrecCartao() + "\n");
            s.append("Total de recibos emitidos: " + rel.getTotalRecibos() + "\n");
            s.append("Percentagem de recibos emitidos: " + rel.percentagemRecibos() + "\n");
            s.append("Número de Avarias: " + rel.getAvarias() + "\n");
            s.append("Manutenções efectuadas: " + rel.getReparacoes() + "\n");

       } else
           s.append("Não existe maquina com este id!");
        return s.toString();
    }


    //REGISTOS
    public void registarManutencao(String id_func, String id_maq, String op, int tempo){// manutenção da maquina MPA
        String idL = reg.gerarIdRegMan();
        RegistoManutencao r = new RegistoManutencao(idL,id_func,id_maq,op,tempo);
        reg.addRegMan(idL,r);
        maquinasP.get(id_maq).incrementaReparacoes();
    }

    public void registarOcupDiaPisos() {
        for (InfoPiso i: pCS.getInfoPisos()) {
            RegDiarioPiso r = new RegDiarioPiso(reg.gerarIdRegDia(),i.getNPiso(), copyDate(dateAct), (int) i.getNEntradas(), (int) i.getNSaidas());
            reg.addRegDiaPiso(r.getIdRegDiario(), r.clone());
        }   
    }

    /*public void registarOcupHoraPiso() {
        for (InfoPiso i: pCS.getInfoPisos()) {
            RegOcupHoraPiso r = new RegOcupHoraPiso(reg.gerarIdOcupHora(),i.getNPiso(),i.getNLugares()-i.getNLugaresLivres(),dateAct, dateAct.get(dateAct.HOUR_OF_DAY));
            reg.addRegHoraPiso(r.getIdRegOcupHora(), r.clone());
        }
    }*/

    public void registarOcupHoraPiso(int id) {
        RegOcupHoraPiso r;
        int hour=dateAct.get(dateAct.HOUR_OF_DAY);

        for (InfoPiso i: pCS.getInfoPisos()) {
            r = new RegOcupHoraPiso(Integer.toString(id+i.getNPiso()),i.getNPiso(),i.getNLugares()-i.getNLugaresLivres(), copyDate(dateAct), hour);
            reg.addRegHoraPiso(r.getIdRegOcupHora(),r.clone());
        }
    }

    public void registarMovimento(String id, int piso, int lugar, boolean estado){
        RegMovimento r = new RegMovimento(id,piso,lugar, estado,copyDate(dateAct));
        reg.addRegMov(id, r.clone());
    }

    public void registarSaidaAnonim(String idB) {
        BilheteAnonim b = (BilheteAnonim) bilhetes.get(idB);
        GregorianCalendar g=b.getDataPagamento();
        if ((dateAct.getTimeInMillis()-(g.getTimeInMillis()))<(5*60*1000)) {
            b.setProcessado(true);
            b.setDataSaida(copyDate(dateAct));
        }
        pCS.decrementaNVeiculosDentro();
        pCS.novaSaidaPiso(1);
    }

    public void regSaidaDispSPag(String idB) {
        GregorianCalendar dS, dE;
        BilheteDisp b = (BilheteDisp) bilhetes.get(idB);

        dE = b.getDataEntrada();
        dS = copyDate(dateAct);
        b.setDataSaida(dS);

        int tempo=(int) ((dS.getTimeInMillis()-dE.getTimeInMillis())/1000/60);
        if (dS.get(dS.MONTH)==dE.get(dE.MONTH)+1) tempo-=1440;
        double total=tempo*0.01;//preco

        b.setTotal(total);

        pCS.decrementaNVeiculosDentro();
        pCS.novaSaidaPiso(1);
    }

    public void regSaidaDispCPag(String idB, String idr) {
        GregorianCalendar dP, dE;
        BilheteDisp b = (BilheteDisp) bilhetes.get(idB);

        dE = b.getDataEntrada();
        dP = copyDate(dateAct);
        b.setDataSaida(dP);

        int tempo=(int) ((dP.getTimeInMillis()-dE.getTimeInMillis())/1000/60);
        if (dP.get(dP.MONTH)==dE.get(dE.MONTH)+1) tempo-=1440;
        double total=tempo*0.01;//preco

        b.setTotal(total);
        b.setProcessado(true);
        Recibo r = new Recibo(nipc, null,idr, b.getIdBilhete(), tempo, dE, dP,total, "Deb Dir");
        recibos.put(idr,r.clone());

        pCS.decrementaNVeiculosDentro();
        pCS.novaSaidaPiso(1);
    }

    //pre-registados
    public String getViaVerde(String idVV) {
        DispViaVerde vv;
        for (DispPreRegisto d: preRegistados.values()) {
            if (d.getClass().equals(DispViaVerde.class)) {
                vv = (DispViaVerde) d;
                if (vv.getIdViaVerde().equals(idVV)) return vv.getIdPreRegisto();
            }
        }
        return null;
    }

    public String getIdCartao(String idCartao) {
        DispAvenca avenca;
        for (DispPreRegisto d: preRegistados.values()) {
            if (d.getClass().equals(DispAvenca.class)) {
                avenca = (DispAvenca) d;
                if (avenca.getIdCartao().equals(idCartao)) return avenca.getIdPreRegisto();
            }
        }
        return null;
    }

    public String getIdMatricula(String idMat) {
        DispMatricula mat;
        for (DispPreRegisto d: preRegistados.values()) {
            if (d.getClass().equals(DispMatricula.class)) {
                mat = (DispMatricula) d;
                if (mat.getMatricula().equals(idMat)) return mat.getIdPreRegisto();
            }
        }
        return null;
    }

    public void registarEntPreReg(String idA, String idM, String idVV, String idB){
        BilheteDisp b;
        String id=null;

        if (idVV!=null && (id=getViaVerde(idVV))!=null) {
            b = new BilheteDisp(idB,copyDate(dateAct),null,0,false,id);
            addBilhete(b);
        }
        if (idA!=null && (id=getIdCartao(idA))!=null) {
            b = new BilheteDisp(idB,copyDate(dateAct),null,0,false,id);
            addBilhete(b);
        }
        if (idM!=null && (id=getIdMatricula(idM))!=null) {
            b = new BilheteDisp(idB,copyDate(dateAct),null,0,false,id);
            addBilhete(b);
        }
        getFichaCliente(getDispPreReg(id).getIdCliente()).addBilhete(idB);
    }


    public void registarEntAnonim(String idB){
        BilheteAnonim b;
      
        b = new BilheteAnonim(idB,copyDate(dateAct),null,0,false,null);
        addBilhete(b);
    }


    public void registarEntrada(int nPiso){
        pCS.novaEntradaPiso(nPiso);
    }

    public void registarSubidaPiso(int nPiso){
        pCS.registarSubidaPiso(nPiso);
    }

    public void registarDescidaPiso(int nPiso){
        pCS.registaDescidaPiso(nPiso);
    }

}