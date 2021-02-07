package base;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DataUtil {

    public String ObterDataAtual() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataAtual = localDate.format(formatter);

        return dataAtual;

    }

    public String ObterHora() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:m");
        Date hora = Calendar.getInstance().getTime();
        String dataFormatada = sdf.format(hora);
        return dataFormatada + 3;
    }

}
