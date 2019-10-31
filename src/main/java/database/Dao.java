package database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.CommonUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class Dao {

    protected static final Logger LOGGER = LogManager.getLogger();
    private Properties prop = new Properties();
    private ResultSet resultSet;
    private Statement statement;
    private final String DRIVER_ORACLE = CommonUtils.retornarValorArquivoConfiguracao("oracle.driver");
    private final String TNS_ORACLE = CommonUtils.retornarValorArquivoConfiguracao("oracle.tns");
    private final String USER_ORACLE = CommonUtils.retornarValorArquivoConfiguracao("oracle.user");
    private final String PASS_ORACLE = CommonUtils.retornarValorArquivoConfiguracao("oracle.pass");


    public ArrayList<String> retornarDadosDb(String... parametrosConsulta) {
        ArrayList<String> resultadoConsulta = new ArrayList<>();
        try {
            prop.load(retornarArquivoPropriedades());
            String query = (
                    prop.getProperty(parametrosConsulta[0]).replace("CPF_PESSOA", parametrosConsulta[1]));
            statement = retornarConexaoBaseDados().createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                    resultadoConsulta.add(resultSet.getString(resultSet.getMetaData().getColumnName(i)));
                }
            }

        } catch (Exception e) {
            LOGGER.error(e);
        }
        return resultadoConsulta;
    }

    private Connection retornarConexaoBaseDados() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER_ORACLE);
        return DriverManager.getConnection(TNS_ORACLE, USER_ORACLE, PASS_ORACLE);
    }

    private static FileInputStream retornarArquivoPropriedades() throws FileNotFoundException {
        return new FileInputStream("./src/test/resources/querys.properties");

    }
}
