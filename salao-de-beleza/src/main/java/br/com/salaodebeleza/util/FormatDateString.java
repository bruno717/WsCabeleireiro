package br.com.salaodebeleza.util;


public class FormatDateString {

	 /**
     * Converte do formato dd/mm/aaaa para aaaa-mm-dd
     * 
     */
    public static String formataDataBanco(String data) {
    	
    	if (data != null && data.length() >= 8) {
            String dia = data.substring(0, 2);
            String mes = data.substring(2, 4);
            String ano = data.substring(4, 8);

            return ano + "-" + mes + "-" + dia;
        } else {
            return null;
        }
    }

    /**
     * Converte do formato aaaa-mm-dd para dd/mm/aaaa
     *
     * @param data Data do banco aaaa-mm-dd
     * @return data normal
     */
    public static String formataDataPadrao(String data) {
        if (data != null && data.length() >= 10) {
            String ano = data.substring(0, 4);
            String mes = data.substring(5, 7);
            String dia = data.substring(8, 10);

            return dia + "/" + mes + "/" + ano;
        } else {
            return null;
        }
    }
    
    
    public static String RetiraCaracteres(String data) {
        if (data != null) {
            data = data.replaceAll("-", "").replaceAll("/", "");

            return data;
        } else {
            return null;
        }
    }
	
}
