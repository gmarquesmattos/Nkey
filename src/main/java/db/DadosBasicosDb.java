package db;

public class DadosBasicosDb {

   	
	public String retornarDadosBasicosDb(CamposPessoaFisica camposBanco)  {
		Dao dao = new Dao();
		String cpf = "03401711970";
		return  dao.retornarDadosDb(camposBanco,"query_dados_basicos_pf",cpf);
	}
}
