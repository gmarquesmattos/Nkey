package db;



import java.util.List;

public class DadosBasicosDb {		
	
    Dao dao = new Dao();
   	
	public List<String> retornarDadosBasicosDb()  {
		
		
		return dao.retornarDadosDb("query_dados_basicos_pf","03401711970");
	}
	
}
