package db;



import java.io.IOException;
import java.sql.SQLException;

public class DadosBasicosDb {		
	
    Dao dao = new Dao();
   	
	public String retornarDadosBasicosDb(CamposPessoaFisica camposBanco) throws IOException, SQLException {
		return  dao.retornarDadosDb(camposBanco,"query_dados_basicos_pf","03401711970");
	}
}
