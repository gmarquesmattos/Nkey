package db;

public class DadosBasicosDb {

   	
	public String retornarDadosBasicosDb(CamposPessoaFisica camposBanco)  {
		Dao dao = new Dao();
		String cpf = "03401711970";
		String nomeConsulta = "query_dados_basicos_pf";
		return  dao.retornarDadosDb(camposBanco,nomeConsulta,cpf);
	}
}
