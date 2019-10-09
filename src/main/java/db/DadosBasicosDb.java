package db;

import org.testng.annotations.Test;

import java.util.ArrayList;

public class DadosBasicosDb {

	public ArrayList<String> retornarDadosBasicosDb()  {
		Dao dao = new Dao();
		String cpf = "03401711970";
		String nomeConsulta = "query_dados_basicos_pf";
		return  dao.retornarDadosDb(nomeConsulta,cpf);
	}
}
