/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Parkum;

import java.sql.ResultSet;
import java.util.GregorianCalendar;
import java.text.*;
import java.sql.*;

/**
 *
 * @author miguel
 */
public class CarregarBD {

    DadosBD bd;

    public void CarregarBD(ParkumCSI parkum) throws Exception {

        bd = new DadosBD();
        bd.abreConeccao();

        //DADOS CSI
        this.carregarCSI(parkum);
        //CLIENTES
        this.carregarClientes(parkum);
        //FUNCIONARIOS
        this.carregarFuncionarios(parkum);
        //DISPOSITIVOS PRE.REGISTADOS
        carregarDispAvenca(parkum);
        carregarDispViaVerde(parkum);
        carregarDispMatricula(parkum);
        carregarDispMovel(parkum);
        //BILHETES
        this.carregarBilhetesAnonim(parkum);
        this.carregarBilhetesDisp(parkum);
        //REGITO MOVIMENTO
        this.carregarRegMovimentos(parkum);
        //MAQUINA PAGAMENTO
        this.carregarMaqPag(parkum);
        //RECIBOS
        this.carregarRecibos(parkum);
        //INFO PISOS
        this.carregarInfoPiso(parkum);
        //REGISTOS DIRARIOS DE PISO
        this.carregarRegDiarioPiso(parkum);
        //REGISTOS DIRARIOS DE OCUPACAO PISO
        this.carregarRegOcupHoraPiso(parkum);
        //REGISTOS MANUTENCAO
        this.carregarRegistosMan(parkum);

        bd.fechaConeccao();
        
    }

    //Submenu 1
    public void carregarClientes(ParkumCSI park) throws Exception {

        ResultSet cls = bd.getFichaCliente();

        while(cls.next()){
            String id = cls.getString(1);
            String nome = cls.getString(2);
            String morada = cls.getString(3);
            String tel = cls.getString(4);
            String nib = cls.getString(5);
            FichaCliente cliente = new FichaCliente(id, nome, morada, tel, nib);

            park.addFichaCliente(cliente);
        }
    }

    //Submenu 2
    public void carregarFuncionarios(ParkumCSI park) throws Exception{

        ResultSet funcs = bd.getFuncionario();

        while(funcs.next()){
            String id = funcs.getString(1);
            String nome = funcs.getString(2);
            String morada = funcs.getString(3);
            Funcionario func = new Funcionario(id, nome, morada);
            park.addFuncionario(func);
        }

    }

    public GregorianCalendar getLongDate(String dataB) {
        int y,m,d,h,min;

        
        y=Integer.parseInt(dataB.substring(0,4));
        m=Integer.parseInt(dataB.substring(5,7));
        d=Integer.parseInt(dataB.substring(8,10));
        h=Integer.parseInt(dataB.substring(11,13));
        min=Integer.parseInt(dataB.substring(14,16));
       
        return new GregorianCalendar(y,m,d,h,min);
    }


    //Submenu 3
    public GregorianCalendar getShortDate(String dataB) {
        int y,m,d,h,min;

        y=Integer.parseInt(dataB.substring(0,4));
        m=Integer.parseInt(dataB.substring(5,7));
        d=Integer.parseInt(dataB.substring(8,10));

        return new GregorianCalendar(y,m,d);
    }

    public void carregarDispAvenca(ParkumCSI park) throws Exception{

        ResultSet preReg = bd.getDispAvenca();

        while(preReg.next()){
            String idPreReg = preReg.getString(1);
            String idCl = preReg.getString(2);
            String tipoD = preReg.getString(3);
            String idCart = preReg.getString(4);
            String dataProxPag = preReg.getString(5);
            String tipoAven = preReg.getString(6);
            DispAvenca cartao = new DispAvenca(idPreReg, idCl, tipoD, idCart, tipoAven, getShortDate(dataProxPag));
            park.addDispPreReg(cartao);
        }
    }

    public void carregarDispViaVerde(ParkumCSI park) throws Exception{

        ResultSet preReg = bd.getDispViaVerde();

        while(preReg.next()){
            String idPreReg = preReg.getString(1);
            String idCl = preReg.getString(2);
            String tipoD = preReg.getString(3);
            String idViaV = preReg.getString(4);
            String dataProxPag = preReg.getString(5);
            DispViaVerde disp = new DispViaVerde(idPreReg, idCl, tipoD, idViaV, this.getShortDate(dataProxPag));
            park.addDispPreReg(disp);

        }
    }

    public void carregarDispMatricula(ParkumCSI park) throws Exception{

        ResultSet preReg = bd.getDispMatricula();

        while(preReg.next()){
            String idPreReg = preReg.getString(1);
            String idCl = preReg.getString(2);
            String tipoD = preReg.getString(3);
            String nMatric = preReg.getString(4);
            DispMatricula mat = new DispMatricula(idPreReg, idCl, tipoD, nMatric);
            park.addDispPreReg(mat);

        }
    }

    public void carregarDispMovel(ParkumCSI park) throws Exception{

        ResultSet preReg = bd.getDispMovel();

        while(preReg.next()){
            String idPreReg = preReg.getString(1);
            String idCl = preReg.getString(2);
            String tipoD = preReg.getString(3);
            String pass = preReg.getString(4);
            DispMovel dispM = new DispMovel(idPreReg, idCl, tipoD, pass);
            park.addDispPreReg(dispM);
            
        }
    }

    //Submenu 4
    public void carregarBilhetesAnonim(ParkumCSI park) throws Exception{
        String dataS,dataP;
        GregorianCalendar dP,dS,dE;

        ResultSet bs = bd.getBilhetesAnonim();

        while(bs.next()){
            dS=dP=dE=null;
            String idB = bs.getString(1);
            dE = getLongDate(bs.getString(2));
            dataS = bs.getString(3);
            if (dataS!=null) dS = getLongDate(dataS);
            double tot = Double.parseDouble(bs.getString(4));
            boolean proc=true;
            if ((bs.getString(5)).equals("0")) proc = false;
            dataP = bs.getString(6);
            if (dataP!=null) dP = getLongDate(dataP);
            
            BilheteAnonim biD = new BilheteAnonim(idB, dE, dS, tot, proc, dP);
            park.addBilhete(biD);
        }
    }


    public void carregarBilhetesDisp(ParkumCSI park) throws Exception{
        String dataS;
        GregorianCalendar dE,dS;
        ResultSet bs = bd.getBilhetesDisp();

        while(bs.next()){
            dE=dS=null;
            String idB = bs.getString(1);
            dE = getLongDate(bs.getString(2));
            dataS = bs.getString(3);
            if (!dataS.equals("")) dS = getLongDate(dataS);
            double tot = Double.parseDouble(bs.getString(4));
            boolean proc=true;
            if ((bs.getString(5)).equals("0")) proc = false;
            String idPreReg = bs.getString(6);

            BilheteDisp biD = new BilheteDisp(idB, dE, dS, tot, proc, idPreReg);
            park.addBilhete(biD);
            park.getFichaCliente(park.getDispPreReg(idPreReg).getIdCliente()).addBilhete(idB);
        }
    }


    //Submenu 5
    private void carregarInfoPiso(ParkumCSI park) throws Exception{
        ResultSet info = bd.getInfoPiso();

        while(info.next()){
            int nPiso = Integer.parseInt(info.getString(1));
            int nLugares = Integer.parseInt(info.getString(2));
            int nLugLivres = Integer.parseInt(info.getString(3));
            int nEntradas = Integer.parseInt(info.getString(4));
            int nSaidas = Integer.parseInt(info.getString(5));

            InfoPiso i = new InfoPiso(nPiso,nLugares,nLugLivres,nEntradas,nSaidas);
            park.addInfoPiso(i);
        }
    }

    //Submenu 6
    private void carregarRecibos(ParkumCSI park) throws Exception{
        ResultSet recib = bd.getRecibos();

        while(recib.next()){
            String idRec = recib.getString(1);
            String idMaq = recib.getString(2);
            String idBi = recib.getString(3);
            int tempo = Integer.parseInt(recib.getString(4));
            GregorianCalendar dataE = this.getLongDate(recib.getString(5));
            GregorianCalendar dataP = this.getLongDate(recib.getString(6));
            String tipoPag = recib.getString(7);
            double totalPag = Double.parseDouble(recib.getString(8));
            String NIPC = recib.getString(9);

            Recibo rec = new Recibo(NIPC,idMaq, idRec, idBi, tempo, dataE, dataP, totalPag, tipoPag);

            park.addRecibo(rec);

        }
    }

    //Submenu 7
    public void carregarRegMovimentos(ParkumCSI park) throws Exception{
        ResultSet pag = bd.getRegMovimento();

        while(pag.next()){
            String idM = pag.getString(1);
            int nPiso = Integer.parseInt(pag.getString(2));
            int nLugar = Integer.parseInt(pag.getString(3));
            boolean est = true;
            if(pag.getString(4).equals("0")) est=false;
            GregorianCalendar data = this.getLongDate(pag.getString(5));

            RegMovimento mov = new RegMovimento(idM,nPiso,nLugar,est,data);

            park.addRegMovimento(mov);
        }
    }



    /*
     * Falta carregar
     * sensores
     * maq pagamento
     * portais entrada
     * portais entrada
     * registos
     */
    public void carregarMaqPag(ParkumCSI park) throws Exception{
        ResultSet maq = bd.getMaqPagamento();

        while(maq.next()){
            String idM = maq.getString(1);
            int totalPD = Integer.parseInt(maq.getString(2));
            int totalPC = Integer.parseInt(maq.getString(3));
            int totalRe = Integer.parseInt(maq.getString(4));
            int nAva = Integer.parseInt(maq.getString(5));
            int nRep = Integer.parseInt(maq.getString(6));
            double totalRD = Double.parseDouble(maq.getString(7));
            double totalRC = Double.parseDouble(maq.getString(8));

            MaqPagamento maquina = new MaqPagamento(idM,totalPD,totalPC,totalRD,totalRC,totalRe,nAva, nRep);
            park.addMaqPagamento(maquina);
        }
    }

    public void carregarCSI(ParkumCSI park) throws Exception{
        ResultSet csi = bd.getParkumCSI();
        
        while(csi.next()){
            String nipc = csi.getString(1);
            String idC = csi.getString(2);
            String idF = csi.getString(3);
            String idB = csi.getString(4);
            String idPreR = csi.getString(5);
            String idRecb = csi.getString(6);
            GregorianCalendar g = this.getLongDate(csi.getString(7));
            
            park.setNipc(nipc);
            park.setIdCliente(idC);
            park.setIdFuncionario(idF);
            park.setIdBilhete(idB);
            park.setIdPreReg(idPreR);
            park.setIdRecibo(idRecb);
            park.setDate(g);
        }
    }

    private void carregarRegDiarioPiso(ParkumCSI park) throws Exception{
        ResultSet regs = bd.getRegDiarioPiso();

        while(regs.next()){
            String idR = regs.getString(1);
            int nPiso = Integer.parseInt(regs.getString(2));
            int nEntr = Integer.parseInt(regs.getString(3));
            int nSaid = Integer.parseInt(regs.getString(4));
            GregorianCalendar data = this.getShortDate(regs.getString(5));

            RegDiarioPiso ocup = new RegDiarioPiso(idR, nPiso, data, nEntr, nSaid);

            park.addRedDiarioPiso(ocup);
        }
    }

    public void carregarRegOcupHoraPiso(ParkumCSI park) throws Exception{
        ResultSet regs = bd.getRegOcupHoraPiso();

        while(regs.next()){
            String idReg = regs.getString(1);
            int nP = Integer.parseInt(regs.getString(2));
            int ocup = Integer.parseInt(regs.getString(3));
            GregorianCalendar data = this.getShortDate(regs.getString(4));
            int hora = Integer.parseInt(regs.getString(5));

            RegOcupHoraPiso reg = new RegOcupHoraPiso(idReg, nP, ocup, data, hora);
            park.addRegOcupHoraPiso(reg);
        }
    }
     
    public void carregarRegistosMan(ParkumCSI park) throws Exception{

        ResultSet regs = bd.getRegistoManutencao();

        while(regs.next()){
            String regMan = regs.getString(1);
            String idF = regs.getString(2);
            String idM = regs.getString(3);
            String disc = regs.getString(4);
            int tempo = Integer.parseInt(regs.getString(5));

            RegistoManutencao reg = new RegistoManutencao(regMan, idF, idM, disc, tempo);

            park.addManutencao(reg);
        }

    }
}
