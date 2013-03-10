/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Parkum;

import java.util.TreeSet;

/**
 *
 * @author Milton
 */
public class FichaCliente {

    private String idCliente;
    private String nome;
    private String morada;
    private String telefone;
    private String nib;
    private TreeSet<String> bilhetes;

    public FichaCliente(){
        idCliente = "";
        nome = "";
        morada = "";
        telefone = "";
        nib = "";
        bilhetes = new TreeSet<String>();
    }

    public FichaCliente(FichaCliente ficha){
        idCliente = ficha.getIdCliente();
        nome = ficha.getNome();
        morada = ficha.getMorada();
        telefone = ficha.getTelefone();
        nib = ficha.getNib();
        bilhetes=ficha.getBilhetes();
    }

    public FichaCliente(String id, String name, String adress, String tlf, String nb) {
        idCliente = id;
        nome = name;
        morada = adress;
        telefone = tlf;
        nib = nb;
        bilhetes = new TreeSet<String>();
    }

    public String getIdCliente(){return idCliente;}
    public String getNome(){return nome;}
    public String getMorada(){return morada;}
    public String getTelefone() {return telefone;}
    public String getNib() {return nib;}
    public TreeSet<String> getBilhetes(){
        TreeSet<String> b = new TreeSet<String>();

        for(String id : bilhetes) b.add(id);

        return b;
    }

    public void addBilhete(String id){bilhetes.add(id);}

    public void setIdCliente(String id){idCliente = id;}
    public void setNome(String name){nome = name;}
    public void setMorada(String adress){morada = adress;}
    public void setTelefone(String tlf){telefone = tlf;}
    public void setNib(String nb){nib = nb;}

    public FichaCliente clone(){
        return new FichaCliente(this);
    }

    public String toString() {
           StringBuilder s = new StringBuilder("---------------Ficha de Utilizador------------\n");
           s.append("ID: " + idCliente + "\n");
           s.append("Nome: " + nome + "\n");
           s.append("Morada: " + morada + "\n");
           s.append("Telefone: " + telefone + "\n");
           s.append("NIB: " + nib + "\n");
           s.append("Bilhetes: \n");
           for(String id: bilhetes) {
               s.append(id + " ");
           }
           s.append("\n");
           return s.toString();
    }
}

