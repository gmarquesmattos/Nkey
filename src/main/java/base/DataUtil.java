package base;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataUtil {

public String ObterDataAtual(){
    LocalDate localDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String dataAtual = localDate.format(formatter);

    return dataAtual;

}


}
