/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Parkum;

/**
 *
 * @author miguel
 */
public class RegistoManutencao {

    private String id_registoManutencao;
    private String id_funcionario;
    private String id_maquina;
    private String operacao;
    private int tempoGasto; //em minutos
    
    public RegistoManutencao(){
        id_registoManutencao="";
        id_funcionario="";
        id_maquina="";
        operacao="";
        tempoGasto=0;
    }
    
    public RegistoManutencao(String id_reg, String id_func, String id_maq, String op, int tempo){
        id_registoManutencao=id_reg;
        id_funcionario=id_func;
        id_maquina=id_maq;
        operacao=op;
        tempoGasto=tempo;
    }
    
    public RegistoManutencao(RegistoManutencao reg){
        id_registoManutencao=reg.getIdRegistoManutencao();
        id_funcionario=reg.getIdFuncionario();
        id_maquina=reg.getIdMaquina();
        operacao=reg.getOperacao();
        tempoGasto=reg.getTempoGasto();
    }
    
    public String getIdRegistoManutencao(){return id_registoManutencao;}
    public String getIdFuncionario(){return id_funcionario;}
    public String getIdMaquina(){return id_maquina;}
    public String getOperacao(){return operacao;}
    public int getTempoGasto(){return tempoGasto;}

    public void setIdRegistoManutencao(String id_regMan){id_registoManutencao=id_regMan;}
    public void setIdFuncionario(String id_regFun){id_funcionario=id_regFun;}
    public void setIdMaquina(String id_maq){id_maquina=id_maq;}
    public void setOperacao(String op){operacao=op;}
    public void setTempoGasto(int tempo){tempoGasto=tempo;}

    @Override
    public RegistoManutencao clone(){return new RegistoManutencao(this);}

    @Override
    public String toString() {
    StringBuilder s = new StringBuilder("---------------Registo Manutenção------------\n");
    s.append("Registo Manutenção: " + id_registoManutencao + "\n");
    s.append("Id Funcionário: " + id_funcionario + "\n");
    s.append("Número Máquina: " + id_maquina + "\n");
    s.append("Operação: " + operacao + "\n");
    s.append("Tempo Gasto: " + tempoGasto + "\n");
    return s.toString();
}

}
