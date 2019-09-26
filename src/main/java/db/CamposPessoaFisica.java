package db;


public enum CamposPessoaFisica {

    NOME_COMPLETO("nomeCompleto"),
    DATA_NASCIMENTO("dataNascimento"),
    ESTADO_CIVIL("estadoCivil"),
    CPF("cpf"),
    RG("rg"),
    ASSOCIADO_DESDE("associadoDesde"),
    GRUPO_ECONOMICO("grupoEconomico"),
    CBO("cbo");

    private String campo;

    CamposPessoaFisica(String campo) {
        this.campo = campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }


    public String getCampo() {
        return campo;
    }
}

