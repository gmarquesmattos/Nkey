package db;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Dao {
    protected static final Logger LOGGER = LogManager.getLogger();
    private Properties prop = new Properties();
    private ResultSet resultSet;
    private Statement statement;
   // private  final String ORACLE_CONEXAO

	public Connection retornarConexaoBaseDados() {

        try {
            prop.load(retornarArquivoPropriedades("conexao"));
        } catch (FileNotFoundException e1) {
            LOGGER.error("Arquivo de propriedades conexão não encontrado!",e1);
         } catch (IOException e1) {
            LOGGER.error("Problemas de conexão com DB",e1);
        }
        Connection conexao = null;
        try {
            Class.forName(prop.getProperty("driverCRMHML"));
            conexao = DriverManager.getConnection(prop.getProperty("urlCRMHML"), prop.getProperty("userCRHML"),
                    prop.getProperty("pwdCRMHML"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conexao;
    }

    public static FileInputStream retornarArquivoPropriedades(String file) throws FileNotFoundException {

        String nome_file = file;
        if (nome_file.equalsIgnoreCase("query")) {
            FileInputStream arquivoConexao = new FileInputStream("./src/test/resources/querys.properties");
            return arquivoConexao;
        } else if (nome_file.equalsIgnoreCase("conexao")) {
            FileInputStream arquivoConexao = new FileInputStream("./src/test/resources/conexoes.properties");
            return arquivoConexao;
        } else
            return null;
    }

    public String retornarDadosDb(CamposBanco camposBanco, String... parametrosConsulta) {
        String resultadoConsulta = null;
        try {
            prop.load(retornarArquivoPropriedades("query"));
            String query = (
                    prop.getProperty(parametrosConsulta[0]).replace("CPF_PESSOA", parametrosConsulta[1]));
            statement = retornarConexaoBaseDados().createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                     resultadoConsulta = resultSet.getString(String.valueOf(camposBanco));
            }

        }catch (Exception e){
        	LOGGER.error(e);
		}
		return resultadoConsulta;
    }
}
