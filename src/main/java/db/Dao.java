package db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Dao {

	public Properties prop = new Properties();
	public ResultSet resultSet;
	public Statement statement;

	public Connection retornarConexaoBaseDados() {

		try {
			prop.load(retornarArquivoPropriedades("conexao"));
		} catch (FileNotFoundException e1) {
			System.out.println("Arquivo de propriedades conex�o n�o encontrado!");
			e1.printStackTrace();
		} catch (IOException e1) {
			System.out.println("Problemas de conex�o com DB");
			e1.printStackTrace();
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
			FileInputStream arquivoConexao = new FileInputStream("./src/main/resources/querys.properties");
			return arquivoConexao;
		} else if (nome_file.equalsIgnoreCase("conexao")) {
			FileInputStream arquivoConexao = new FileInputStream("./src/main/resources/conexoes.properties");
			return arquivoConexao;
		} else
			return null;
	}

	public List<String> retornarDadosDb(String... parametrosConsulta) {

		List<String> dadosDb = new ArrayList<String>();
		try {

			try {
				prop.load(retornarArquivoPropriedades("query"));
			} catch (FileNotFoundException e) {
				System.out.println("Arquivo de propriedades query n�o encontrado!");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Problemas de conex�o com DB");
				e.printStackTrace();
			}
			String query = new String(
					prop.getProperty(parametrosConsulta[0]).replace("CPF_PESSOA", parametrosConsulta[1]));
			statement = retornarConexaoBaseDados().createStatement();
			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
					dadosDb.add(resultSet.getString(resultSet.getMetaData().getColumnName(i).toString()));
				}

			}

		} catch (SQLException e) {
			System.out.println("Ocorreu um erro na execucao do SQL");
			e.printStackTrace();
		}
		return dadosDb;

	}

}
