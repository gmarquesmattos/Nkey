package database;

import java.util.ArrayList;

public class DadosBasicosDb {

	public ArrayList<String> retornarDadosBasicosDb(String cpf) {
		Dao dao = new Dao();
		String nomeConsulta = "query_dados_basicos_pf";
		return  dao.retornarDadosDb(nomeConsulta,cpf);
	}
}
