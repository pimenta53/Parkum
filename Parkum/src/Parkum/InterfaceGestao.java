/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package Parkum;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author milton
 */
public class InterfaceGestao {

    public void gest(ParkumCSI park, Scanner input) throws Exception {

        String key = "1";
        while(key.compareTo("0")!=0){
            System.out.println("---------Sistema de Gestão-------------\n" +
                "1 - Gerir Fichas de Clientes\n" +
                "2 - Gerar relatórios de utilização de clientes\n" +
                "3 - Lista clientes com pagamentos em atraso\n" +
                "4 - Processar pagamentos\n"+
                "5 - Gerar Relatórios de controlo e gestão\n" +
                "0 - Sair\n");

            key=input.nextLine();
            if(key.compareTo("1")==0) gerirFichas(park,input);
            if(key.compareTo("2")==0) gerarRelatorioCliente(park,input);
            if(key.compareTo("3")==0) gerarListaAtraso(park);
            if(key.compareTo("4")==0) gerirPagam(park,input);
            if(key.compareTo("5")==0) gerarRelatorios(park,input);
        }
    }


    public void gerirFichas(ParkumCSI park,Scanner input){

        String key="1";
        while(key.compareTo("0")!=0){
            System.out.println("---------Gerir Fichas de Cliente-------------\n" +
                "1 - Criar Ficha\n" +
                "2 - Editar Ficha\n" +
                "3 - Eliminar Ficha\n"+
                "0 - Sair\n");

            key=input.nextLine();

            if(key.compareTo("1")==0) CriarFicha(park,input);
            if(key.compareTo("2")==0) EditarFicha(park,input);
            if(key.compareTo("3")==0) RemoverFicha(park,input);
        }
    }

    public void CriarFicha(ParkumCSI park,Scanner input){

        System.out.print("-----Nova Ficha Cliente-----\n"+"Nome: ");
        String nome = input.nextLine();
        System.out.print("Morada: ");
        String morada = input.nextLine();
        System.out.print("Telefone: ");
        String telefone = input.nextLine();
        System.out.print("NIB: ");
        String nib = input.nextLine();

        FichaCliente ficha = new FichaCliente(park.gerarIdCliente(),nome,morada,telefone,nib);
        park.addFichaCliente(ficha);
    }

    public void EditarFicha(ParkumCSI park,Scanner input){

        System.out.print("\n-----Editar Ficha Cliente-----\n"+
                "Introduza id ficha: ");
        String id = input.nextLine();
        FichaCliente ficha = park.getFichaCliente(id);
        if (ficha!=null) {
            boolean cont = true;

            while(cont){

                System.out.print("\nId: " + ficha.getIdCliente() + "\nNome: "+ ficha.getNome()
                    + "\nMorada: " + ficha.getMorada() + "\nTelefone: " + ficha.getTelefone() +
                    "\nNIB: " + ficha.getNib());

                System.out.println("\n\n1-alterar nome\n" +
                        "2-alterar morada\n" + "3-alterar telefone\n" + "4-alterar nib\n" + "0-sair");
                String op = input.nextLine();

                if(op.equals("1")){
                    System.out.print("Nome: ");
                    String nome = input.nextLine();
                    ficha.setNome(nome);
                }

                if(op.equals("2")){
                    System.out.print("Morada: ");
                    String morada = input.nextLine();
                    ficha.setMorada(morada);
                }

                if(op.equals("3")){
                    System.out.print("Telefone: ");
                    String telefone = input.nextLine();
                    ficha.setTelefone(telefone);
                }

                if(op.equals("4")){
                    System.out.print("NIB: ");
                    String nib = input.nextLine();
                    ficha.setNib(nib);
                }

                if(op.equals("0")){
                    cont=false;
                }
            }
       }else 
           System.out.println("Id de cliente invalido!");
    }

    public void RemoverFicha(ParkumCSI park, Scanner input){

        System.out.print("\n-----Remover Ficha Cliente-----\n"+
                "Introduza id ficha: ");
        String id = input.nextLine();

        if (park.existeCliente(id)) {
            park.removeFichaCliente(id);
            System.out.println("Ficha removida com sucesso!\n");
        } else
            System.out.println("Nao existe cliente com o ID introduzido\n");
    }


    //PAGAMENTOS
    public void gerirPagam(ParkumCSI park, Scanner input){

        String key="1";
        String idCard="";
        String idDisp="";
        String tipoP="1";

        while(!key.equals("0")) {
            System.out.println("---------Processar Pagamentos-------------\n" +
                     "1 - Processar Pagamentos de Avença\n" +
                     "2 - Processar Pagamentos de Via-Verde\n" +
                     
                     "0 - Sair\n");

            key = input.nextLine();

            if(key.equals("1")){
                System.out.println("Introfuza ID do cartao: ");
                    idCard = input.nextLine();
                if ((idDisp=park.getIdCartao(idCard))!=null) {
                    System.out.println("Efectuar pagamento com:\n" +
                         "1 - Debito Directo\n" +
                         "2 - Dinheiro\n" +
                         "3 - MB \n" +
                         "Qualquer outra para Sair");
                    tipoP=input.nextLine();
                    if (tipoP.equals("1")) park.pagamentoAvencas(idDisp,"Deb Dir");
                    if (tipoP.equals("2")) park.pagamentoAvencas(idDisp,"Dinheiro");
                    if (tipoP.equals("3")) park.pagamentoAvencas(idDisp,"MB");
               } else {
                    System.out.println("ID não pertence a nenhum cartao");
               }
            }

            if(key.equals("2")){
                park.pagamentoViaVerde();
            }
        }
    }
    
    
    //RELATORIOS
    public void gerarRelatorioCliente(ParkumCSI park, Scanner input){
        String idCl;
        int ano,mes;
        System.out.print("\n\n-----Gerar relatórios de Utilização de Cliente-----\n\n"+ "Introduza id cliente: ");
        idCl = input.nextLine();
        if (park.existeCliente(idCl)) {
            System.out.print("Introduza Ano:");
            //try {
                ano = Integer.parseInt(input.nextLine());
                System.out.print("Introduza Mes:");
                mes = Integer.parseInt(input.nextLine());
                System.out.print("\n\n" + park.relatorioCliente(idCl,ano,mes)+"\n\n");
           //} catch (Exception e) {System.out.println("Data invalida");}
        }
        else
            System.out.println("Nao existe cliente com o ID introduzido\n");
    }

    public void gerarListaAtraso(ParkumCSI park){
        System.out.println(park.pListaAtraso());
    }


    public void gerarRelatorios(ParkumCSI park, Scanner input) throws Exception{

        String key="1";

        while(!key.equals("0")) {
        System.out.println("---------Relatórios de Controlo e Gestão-------------\n" +
                 "1 - Gerar relatório diário de entradas e saídas\n" +
                 "2 - Gerar relatório diário de facturação\n" +
                 "3 - Gerar tabelas de distribuições de lugares\n"+
                 "4 - Gerar relatório de máquina automática\n"+
                 "0 - Sair\n");


        
          key = input.nextLine();

          if(key.equals("1")) gerarRelatorioEntSaida(park,input);
          if(key.equals("2")) gerarFacturacao(park,input);
          if(key.equals("3")) gerarTabelaD(park,input);
          if(key.equals("4")) gerarRelatorioMaq(park,input);
        }
    }

    public void gerarRelatorioEntSaida(ParkumCSI park, Scanner input)throws Exception{

        System.out.print("\n\n-----Gerar relatórios de diário de Entradas e Saidas-----\n\n"+
                "Introduza data(dd/mm/aaaa): ");

        String data1 = input.nextLine();

        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date d = format.parse(data1);
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(d);
            int m = calendar.get(calendar.MONTH);
            m++;
            calendar.set(calendar.MONTH,m);

            System.out.print("\n\n" + park.relEntSaidas(calendar)+"\n\n");
        } catch (Exception e) {System.out.println("Data invalida");}
    }

    public void gerarFacturacao(ParkumCSI park, Scanner input)throws Exception{
        GregorianCalendar calendar;

        System.out.print("\n\n-----Gerar Relatório Diário de Facturação-----\n\n"+
                "Introduza data(dd/mm/aaaa): ");
        String data = input.nextLine();

        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date d = format.parse(data);
            calendar = new GregorianCalendar();
            calendar.setTime(d);
            int m = calendar.get(calendar.MONTH);
            m++;
            calendar.set(calendar.MONTH,m);
            System.out.print("\n\n" + park.relFacturacao(calendar)+"\n\n");
        } catch (Exception e) {System.out.println("Data invalida");}
    }

    public void gerarTabelaD(ParkumCSI park,Scanner input) throws Exception{
        GregorianCalendar calendar;

        System.out.print("\n\n-----Tabela Diária de distribuições-----\n\n" +
                "Introduza data(dd/mm/aaaa): ");
        String data = input.nextLine();

        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date d = format.parse(data);
            calendar = new GregorianCalendar();
            calendar.setTime(d);
            int m = calendar.get(calendar.MONTH);
            m++;
            calendar.set(calendar.MONTH,m);
            System.out.print("\n\n" + park.relTabelaDist(calendar) + "\n\n");
        } catch (Exception e) {System.out.println("Data invalida");}
        
   }

   public void gerarRelatorioMaq(ParkumCSI park, Scanner input){
        System.out.print("\n\n-----Gerar relatórios de Máquina de Pagamento-----\n\n"+
                "Introduza ID da maquina: ");

        String id = input.nextLine();
        System.out.print("\n\n" + park.relMaquina(id)+"\n\n");

    }
}
