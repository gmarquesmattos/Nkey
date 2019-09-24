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

import static utils.CommonUtils.retornarValorArquivoConfiguracao;

public class Dao {

    protected static final Logger LOGGER = LogManager.getLogger();
    private Properties prop = new Properties();
    private ResultSet resultSet;
    private Statement statement;
    private final String ORACLE_DRIVER = retornarValorArquivoConfiguracao("oracle.driver");
    private final String ORACLE_TNS = retornarValorArquivoConfiguracao("oracle.tns");
    private final String ORACLE_USER = retornarValorArquivoConfiguracao("oracle.user");
    private final String ORACLE_PASS = retornarValorArquivoConfiguracao("oracle.pass");

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


        } catch (Exception e) {
            LOGGER.error(e);
        }
        return resultadoConsulta;
    }

    private Connection retornarConexaoBaseDados() throws SQLException, ClassNotFoundException, IOException {

        try {
            prop.load(retornarArquivoPropriedades("conexao"));
        } catch (FileNotFoundException e1) {
            LOGGER.error("Arquivo de propriedades conexão não encontrado!", e1);
        }
     //   Class.forName(ORACLE_DRIVER);
        return DriverManager.getConnection(ORACLE_TNS, ORACLE_USER, ORACLE_PASS);

    }

    private static FileInputStream retornarArquivoPropriedades(String file) throws FileNotFoundException {

        String nome_file = file;
        if (nome_file.equalsIgnoreCase("query")) {
            FileInputStream arquivoConexao = new FileInputStream("./src/test/resources/querys.properties");
            return arquivoConexao;
        } else
            return null;
    }


}
