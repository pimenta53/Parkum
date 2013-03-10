/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Parkum;

/**
 *
 * @author ricardo
 */
import java.util.Scanner;
import java.util.GregorianCalendar;

public class InterfaceSimulacao {
public void simul(ParkumCSI pCSI, Scanner input) {
        String menuSimulacao = ("---------Simulação-------------\n\n" +
             //"1 - Inserir registo\n" +
             "1 - Carregar registos entre 2 horas\n" +
             "2 - Ver estado dos compunentes\n" +
             "0 - Sair\n");

        String num ="1";
        while (num.compareTo("0")!=0){
            System.out.println(menuSimulacao);
            num=input.nextLine();
            if (num.compareTo("1")==0) entreHoras(pCSI,input);
            if (num.compareTo("2")==0) verRegs(pCSI,input);
            if (num.compareTo("3")==0) System.out.println("falta\n");
        }
    }

    public void verRegs(ParkumCSI pCSI,Scanner input) {
        String menuRegs = ("---------Ver Registo-------------\n" +
             "1 - Clinetes\n" +
             "2 - Funionarios\n" +
             "3 - Dispositivos Registados\n" +
             "4 - Bilhetes\n" +
             "5 - Informacao Piso\n" +
             "6 - Recibos\n" +
             "7 - Registos de estacionamento e saidas\n" +
             "8 - Ver Registos Hora Piso\n" +
             "9 - Ver Estado Maquinas Pagamento\n" +

             "0 - Sair\n");

        String num ="1";
        while (num.compareTo("0")!=0){
            System.out.println(menuRegs);
            num=input.nextLine();
            if (num.compareTo("1")==0) {System.out.println(pCSI.printClientes());}
            if (num.compareTo("2")==0) {System.out.println(pCSI.printFuncionarios());}
            if (num.compareTo("3")==0) {System.out.println(pCSI.printDispositivos());}
            if (num.compareTo("4")==0) {System.out.println(pCSI.printBilhetes());}
            if (num.compareTo("5")==0) {System.out.println(pCSI.printInfoPiso());}
            if (num.compareTo("6")==0) {System.out.println(pCSI.printRecibos());}
            if (num.compareTo("7")==0) {System.out.println(pCSI.printRegMov());}
            if (num.compareTo("8")==0) {System.out.println(pCSI.printRegHoraDia());}
            if (num.compareTo("9")==0) {
                System.out.println(pCSI.relMaquina("mq1"));
                System.out.println(pCSI.relMaquina("mq2"));
            }
        }
    }

    public void entreHoras(ParkumCSI park, Scanner input) {
        int h1,h2;
        h1=h2=0;
    
        System.out.println("---------Simulação entre horas(0h/15h)-------------\n"
                + "Digite a hora de inicio: ");
        try {
            h1=Integer.parseInt(input.nextLine());
            if (h1>=0 && h1<16) {
                System.out.println("Digite a hora de inicio: ");
                h2=Integer.parseInt(input.nextLine());
            }
            while (h1<=h2) {
            carragaRegistosHoras(park,h1);
            h1++;
            }
        } catch (Exception e) { System.out.println("horas invalidas!"); }
    }


    public void carragaRegistosHoras(ParkumCSI pCSI,int h1) {
        //BILHETES
        GregorianCalendar data=new GregorianCalendar();

        switch (h1) {
            case 1:
                //RegHora 4
                pCSI.getDate().set(data.HOUR_OF_DAY,1);
                pCSI.registarOcupHoraPiso(4);
                break;
            case 2:
                //IDRecibo      4
                //IDMovimento   14
                //RegHora       5
                //bilhete       b7
                pCSI.getDate().set(data.HOUR_OF_DAY,2);
                pCSI.getDate().set(data.MINUTE,40);
                pCSI.pagarMaquina("mq1","4", false, false, "b7", false, 2);
                pCSI.getDate().set(data.MINUTE,42);
                pCSI.registarMovimento("14",1, 8, true);
                pCSI.getDate().set(data.MINUTE,44);
                pCSI.registarSaidaAnonim("b7");
                pCSI.getDate().set(data.MINUTE,59);
                pCSI.registarOcupHoraPiso(5);
                break;
            case 3:
                //RegHora 7
                pCSI.getDate().set(data.HOUR_OF_DAY,3);
                pCSI.getDate().set(data.MINUTE,00);
                pCSI.registarOcupHoraPiso(7);
                break;
            case 4:
                //RegHora 9
                pCSI.getDate().set(data.HOUR_OF_DAY,4);
                pCSI.getDate().set(data.MINUTE,00);
                pCSI.registarOcupHoraPiso(9);
                pCSI.registarManutencao("func1", "mq1", "Limpeza", 17);
                pCSI.registarManutencao("func2", "mq2", "Limpeza", 20);
                break;
            case 5:
                //RegHora 11
                pCSI.getDate().set(data.HOUR_OF_DAY,5);
                pCSI.getDate().set(data.MINUTE,00);
                pCSI.registarOcupHoraPiso(11);
                break;
            case 6:
                //RegHora 13
                pCSI.getDate().set(data.HOUR_OF_DAY,6);
                pCSI.getDate().set(data.MINUTE,00);
                pCSI.registarOcupHoraPiso(13);
                break;
            case 7:
                //RegHora 15
                pCSI.getDate().set(data.HOUR_OF_DAY,7);
                pCSI.getDate().set(data.MINUTE,00);
                pCSI.registarOcupHoraPiso(15);
                break;
            case 8:
                //RegHora       11
                //bilhete       b8-b9
                //IDMovimento   15-16
                //RegHora 17
                pCSI.getDate().set(data.HOUR_OF_DAY,8);
                pCSI.getDate().set(data.MINUTE,12);
                pCSI.registarEntPreReg("c1",null,null,"b8");
                pCSI.registarEntrada(1);
                pCSI.registarSubidaPiso(1);
                pCSI.getDate().set(data.MINUTE,18);
                pCSI.registarMovimento("15",2,1,false);
                pCSI.getDate().set(data.MINUTE,30);
                pCSI.registarEntPreReg(null,null,"vv1","b9");
                pCSI.registarEntrada(1);
                pCSI.getDate().set(data.MINUTE,33);
                pCSI.registarMovimento("16",1,4,false);
                pCSI.registarOcupHoraPiso(17);
                break;
            case 9:
                //IDMovimento   17
                //RegHora 19
                pCSI.getDate().set(data.HOUR_OF_DAY,9);
                pCSI.getDate().set(data.MINUTE,47);
                pCSI.registarMovimento("17",1,4,true);
                pCSI.getDate().set(data.MINUTE,49);
                pCSI.regSaidaDispSPag("b9");
                pCSI.getDate().set(data.MINUTE,59);
                pCSI.registarOcupHoraPiso(19);
                break;
            case 10:
                //RegHora 21
                //IDMovimento   18
                //bilhete       b10
                //RegHora 21
                pCSI.getDate().set(data.HOUR_OF_DAY,10);
                pCSI.getDate().set(data.MINUTE,02);
                pCSI.registarEntPreReg(null,"11-AC-22",null,"b10");
                pCSI.registarEntrada(1);
                pCSI.getDate().set(data.MINUTE,18);
                pCSI.registarMovimento("18",1,9,false);
                pCSI.registarOcupHoraPiso(21);
                break;
            case 11:
                //RegHora 23
                //IDMovimento   19-20
                //IDRecibo      20
                pCSI.getDate().set(data.HOUR_OF_DAY,11);
                pCSI.getDate().set(data.MINUTE,20);
                pCSI.registarMovimento("19",2,1,true);
                pCSI.registarDescidaPiso(2);
                pCSI.getDate().set(data.MINUTE,25);
                pCSI.regSaidaDispSPag("b8");

                pCSI.getDate().set(data.MINUTE,30);
                pCSI.registarMovimento("20",1,9,true);
                pCSI.getDate().set(data.MINUTE,32);
                pCSI.regSaidaDispCPag("b10","20");

                pCSI.getDate().set(data.MINUTE,59);
                pCSI.registarOcupHoraPiso(23);
                break;
            case 12:
                //RegHora 25
                //IDMovimento   21 22
                //bilhete       b11 12
                pCSI.getDate().set(data.HOUR_OF_DAY,12);
                pCSI.getDate().set(data.MINUTE,25);
                pCSI.registarEntAnonim("b11");
                pCSI.registarEntrada(1);
                pCSI.getDate().set(data.MINUTE,33);
                pCSI.registarMovimento("21",1,10,false);
                pCSI.getDate().set(data.MINUTE,44);
                pCSI.registarEntAnonim("b12");
                pCSI.registarEntrada(1);
                pCSI.getDate().set(data.MINUTE,46);
                pCSI.registarMovimento("22",1,3,false);
                pCSI.registarOcupHoraPiso(25);
                break;
            case 13:
                //RegHora 27
                //IDRecibo      21
                //IDMovimento   23
                pCSI.getDate().set(data.HOUR_OF_DAY,13);
                pCSI.getDate().set(data.MINUTE,40);
                pCSI.pagarMaquina("mq2","21", true, true, "b12", false, 10);
                pCSI.getDate().set(data.MINUTE,43);
                pCSI.registarMovimento("23",1, 10, true);
                pCSI.getDate().set(data.MINUTE,44);
                pCSI.registarSaidaAnonim("b12");
                pCSI.getDate().set(data.MINUTE,46);
                pCSI.registarOcupHoraPiso(27);
                break;
            case 14:
                //RegHora 29
                //IDRecibo      22
                pCSI.getDate().set(data.HOUR_OF_DAY,14);
                pCSI.getDate().set(data.MINUTE,12);
                pCSI.pagarMaquina("mq2","22", true, false, "b11", false, 5);
                pCSI.getDate().set(data.MINUTE,13);
                pCSI.registarMovimento("23",1, 10, true);
                pCSI.getDate().set(data.MINUTE,16);
                pCSI.registarSaidaAnonim("b11");
                pCSI.getDate().set(data.MINUTE,59);
                pCSI.registarOcupHoraPiso(29);
                break;
            case 15:
                //RegHora 31
                pCSI.getDate().set(data.HOUR_OF_DAY,15);
                pCSI.getDate().set(data.MINUTE,00);
                pCSI.registarOcupHoraPiso(31);
                pCSI.registarOcupDiaPisos();
                break;
            default:
                break;
        }
        
    }
}
                /*pCSI.addBilhete(new BilheteAnonim("1", new GregorianCalendar(2010,4,3,9,5), new GregorianCalendar(2010,4,3,9,45), 2, true, new GregorianCalendar(2010,4,3,9,43)));
                pCSI.addBilhete(new BilheteAnonim("2", new GregorianCalendar(2010,4,3,9,10), new GregorianCalendar(2010,4,3,10,20), 2.54, true, new GregorianCalendar(2010,4,3,10,15)));
                pCSI.addBilhete(new BilheteDisp("3", new GregorianCalendar(2010,4,4,12,00), new GregorianCalendar(2010,4,4,15,10), 4, false, "1"));
                pCSI.addBilhete(new BilheteDisp("4", new GregorianCalendar(2010,4,5,13,12), new GregorianCalendar(2010,4,4,13,30), 1.25, true, "2"));
                //INFORMAÇÃO DOS PISOS
                pCSI.addInfoPiso(new InfoPiso(1, 20, 20, 4, 4));
                pCSI.addInfoPiso(new InfoPiso(2, 20, 20, 2, 2));
                //RECIBOS
                pCSI.addRecibo(new Recibo("pc1","mq1","1","1",38, new GregorianCalendar(2010,4,3,9,5),new GregorianCalendar(2010,4,3,9,43),2,"Dinheiro"));
                pCSI.addRecibo(new Recibo("pc1","mq1","2","2",65, new GregorianCalendar(2010,4,3,9,10),new GregorianCalendar(2010,4,3,10,15),2.54,"MB"));
                pCSI.addRecibo(new Recibo("pc1","mqFunc","3","4",38, new GregorianCalendar(2010,4,5,13,12),new GregorianCalendar(2010,4,3,13,30),2,"Debito Directo"));
                //REGISTOS DE MOVIMENTO
                pCSI.addRegMovimento(new RegMovimento("1", 1, 1, false, new GregorianCalendar(2010,4,3,9,7)));
                pCSI.addRegMovimento(new RegMovimento("2", 2, 2, false, new GregorianCalendar(2010,4,3,9,15)));
                pCSI.addRegMovimento(new RegMovimento("3", 1, 1, true, new GregorianCalendar(2010,4,3,9,44)));
                pCSI.addRegMovimento(new RegMovimento("4", 2, 2, true, new GregorianCalendar(2010,4,3,10,16)));
                pCSI.addRegMovimento(new RegMovimento("5", 2, 5, false, new GregorianCalendar(2010,4,4,12,3)));
                pCSI.addRegMovimento(new RegMovimento("6", 2, 2, true, new GregorianCalendar(2010,4,4,15,2)));
                pCSI.addRegMovimento(new RegMovimento("7", 1, 3, false, new GregorianCalendar(2010,4,5,13,14)));
                pCSI.addRegMovimento(new RegMovimento("8", 1, 3, true, new GregorianCalendar(2010,4,5,13,26)));
                
            case 8:
        

        /*
        //CLIENTES
        pCSI.addFichaCliente(new FichaCliente("1", "xapine", "rua x", "123456789", "12345"));
        pCSI.addFichaCliente(new FichaCliente("2", "ricardo", "rua a", "123456780", "12346"));
        pCSI.addFichaCliente(new FichaCliente("3", "miguel", "rua t", "123456781", "12347"));
        //FUNCIONARIOS
        pCSI.addFuncionario(new Funcionario("1", "milton", "rua z"));
        //DISPOSITIVOS
        pCSI.addDispPreReg(new DispAvenca("1", "3", "Cartao Avença","1", "Mensal", new GregorianCalendar(2010,4,2)));
        pCSI.addDispPreReg(new DispMatricula("2", "2", "Matricula","11-22-AA"));
        pCSI.addDispPreReg(new DispMovel("3", "1", "Wireless","12345"));
        pCSI.addDispPreReg(new DispViaVerde("4", "3", "Via Verde","1",new GregorianCalendar(2010,3,10)));
         *
         */