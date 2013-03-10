/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author pimenta
 */
package Parkum;

    public class Funcionario {
        private String idFuncionario;
        private String nome;
        private String morada;


    public Funcionario(){
        idFuncionario = "";
        nome = "";
        morada = "";
    }

    public Funcionario(String id, String name, String adress){
        idFuncionario = id;
        nome = name;
        morada = adress;
    }

    public Funcionario(Funcionario fcn){
        idFuncionario = fcn.getIdFuncionario();
        nome = fcn.getNome();
        morada = fcn.getMorada();
    }

    public String getIdFuncionario(){return idFuncionario;}
    public String getNome(){return nome;}
    public String getMorada(){return morada;}

    public void setIdFuncionario(String id){idFuncionario = id;}
    public void setnome(String name){nome = name;}
    public void setMorada(String adress){morada = adress;}

    public Funcionario clone(){
        return new Funcionario(this);
    }

    public String toString() {
           StringBuilder s = new StringBuilder("---------------Funcionário------------\n");
           s.append("ID: " + idFuncionario + "\n");
           s.append("Nome: " + nome + "\n");
           s.append("Morada: " + morada + "\n");
           return s.toString();
    }

}

