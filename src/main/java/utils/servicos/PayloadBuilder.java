package utils.servicos;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class PayloadBuilder {

    private String xml;
    private List<ParametroXML> parametros;

    private PayloadBuilder(){
        parametros = Lists.newArrayList();
    }

    public static PayloadBuilder builder(){
        return new PayloadBuilder();
    }

    public PayloadBuilder xml(String xml){
        this.xml = xml;
        return this;
    }

    public PayloadBuilder parametros(ParametroXML... parametros){
        this.parametros.addAll(Arrays.asList(parametros));
        return this;
    }

    public String build(){
        return format();
    }

    private String format(){
        AtomicReference<String> contentRef = new AtomicReference<>(xml);

        parametros.forEach(parametro ->
                contentRef.set(contentRef.get().replace("#(" + parametro.getNome() + ")", parametro.getValor().toString()))
        );

        return contentRef.get();
    }
}
