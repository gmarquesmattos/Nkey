package utils.servicos;

public class ParametroXML {
    private String nome;
    private Object valor;

    private ParametroXML(String nome, Object valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public Object getValor() {
        return valor;
    }

    public static class ParametroBuilder {

        private ParametroBuilder(){}

        public static ParametroXML intParametro(String nome, int valor){
            return new ParametroXML(nome, valor);
        }

        public static ParametroXML doubleParametro(String nome, double valor){
            return new ParametroXML(nome, valor);
        }

        public static ParametroXML floatParametro(String nome, float valor){
            return new ParametroXML(nome, valor);
        }

        public static ParametroXML booleanParametro(String nome, boolean valor){
            return new ParametroXML(nome, valor);
        }

        public static ParametroXML stringParametro(String nome, String valor){
            return new ParametroXML(nome, valor);
        }
    }
}
