package suporte;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Generator {

    public static String gerarDataArquivo(){
       
    	Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        return new SimpleDateFormat("hhmmssddMMyyyy").format(timeStamp);
    }

}
