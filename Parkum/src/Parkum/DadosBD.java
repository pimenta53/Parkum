/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Parkum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author miguel
 */
public class DadosBD {

    Connection con;

    public DadosBD(){
        con=null;
    }

    public void abreConeccao(){
		 try{
               Class.forName("oracle.jdbc.driver.OracleDriver");
               con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.131.128:1521:xe","dss","dss");
	            System.out.println ("Ligação estabelecida");
			 }catch (Exception e){System.err.println ("Não consegue ligar a base de dados");}
     }

    public void fechaConeccao()throws Exception{
		con.close();
		System.out.println("Liagacao fechada");
    }

    public ResultSet getRecibos() throws Exception{
        String sql = "SELECT * FROM Recibo";

        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet resultSet = stmt.executeQuery();

        return resultSet;
    }

    public ResultSet getBilhetesAnonim() throws Exception{
        String sql = "SELECT * FROM BilheteAnonim";

        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet resultSet = stmt.executeQuery();

        return resultSet;
    }

    public ResultSet getBilhetesDisp() throws Exception{
        String sql = "SELECT * FROM Bilhetedisp";

        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet resultSet = stmt.executeQuery();

        return resultSet;
    }

    public ResultSet getDispAvenca() throws Exception{
        String sql = "SELECT * FROM DispAvenca";

        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet resultSet = stmt.executeQuery();

        return resultSet;
    }

    public ResultSet getDispMatricula() throws Exception{
        String sql = "SELECT * FROM DispMatricula";

        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet resultSet = stmt.executeQuery();

        return resultSet;
    }

    public ResultSet getDispMovel() throws Exception{
        String sql = "SELECT * FROM DispMovel";

        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet resultSet = stmt.executeQuery();

        return resultSet;
    }

    public ResultSet getDispViaVerde() throws Exception{
        String sql = "SELECT * FROM DispViaVerde";

        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet resultSet = stmt.executeQuery();

        return resultSet;
    }

    public ResultSet getParkumCSI() throws Exception{
        String sql = "SELECT * FROM ParkumCSI";

        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet resultSet = stmt.executeQuery();

        return resultSet;
    }

    public ResultSet getFichaCliente() throws Exception{
        String sql = "SELECT * FROM FichaCliente";

        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet resultSet = stmt.executeQuery();

        return resultSet;
    }

    public ResultSet getRegistoManutencao() throws Exception{
        String sql = "SELECT * FROM RegistoManutencao";

        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet resultSet = stmt.executeQuery();

        return resultSet;
    }

    public ResultSet getFuncionario() throws Exception{
        String sql = "SELECT * FROM Funcionario";

        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet resultSet = stmt.executeQuery();

        return resultSet;
    }

    public ResultSet getSensor() throws Exception{
        String sql = "SELECT * FROM Sensor";

        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet resultSet = stmt.executeQuery();

        return resultSet;
    }

    public ResultSet getInfoPiso() throws Exception{
        String sql = "SELECT * FROM InfoPiso";

        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet resultSet = stmt.executeQuery();

        return resultSet;
    }

    public ResultSet getRegMovimento() throws Exception{
        String sql = "SELECT * FROM RegMovimento";

        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet resultSet = stmt.executeQuery();

        return resultSet;
    }

    public ResultSet getRegDiarioPiso() throws Exception{
        String sql = "SELECT * FROM RegDiarioPiso";

        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet resultSet = stmt.executeQuery();

        return resultSet;
    }

    public ResultSet getRegOcupHoraPiso() throws Exception{
        String sql = "SELECT * FROM RegOcupHoraPiso";

        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet resultSet = stmt.executeQuery();

        return resultSet;
    }


    public ResultSet getMaqPagamento() throws Exception{
        String sql = "SELECT * FROM maqpagamento";

        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet resultSet = stmt.executeQuery();

        return resultSet;
    }

    public ResultSet getIdBilhetesCl(String id) throws Exception{
        String sql = "SELECT idBilhete FROM Bilhete where idCliente = '" + id + "'";

        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet resultSet = stmt.executeQuery();

        return resultSet;
    }


}
