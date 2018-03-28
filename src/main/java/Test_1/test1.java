package Test_1;

/**
 * Se realiza la importación de los archivos importantes para el proceso, se
 * está utilizando la librería ipdf que se encuentra importada en el archivo POM
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author Juan Diego Alfonso
 */
public class test1 {

    public static void main(String[] args) throws IOException {
        /**
         * En el primer parametro recibe el nombre y ubicación del archivo y el
         * archivo recibe digitos separados por lo que indique le usuario en el
         * segundo parametro
         */

        leerdata("desviacion.txt", "-");

    }

    public static void leerdata(String archivo, String delimit) throws FileNotFoundException, IOException {

        /**
         * Lectura de archivo extraida de:
         * https://www.lawebdelprogramador.com/codigo/Java/2315-Leer-una-linea-de-un-archivo-y-separar-sus-palabras.html
         *
         */
        int sum = 0;
        int media;
        int varianza = 0;
        int desviacion = 0;
        String cadena;

        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            //System.out.println(cadena);
            String[] parts = cadena.split(delimit);
            System.out.println(Arrays.toString(parts));
            for (String part : parts) {
                /**
                 * Sumatoria de todos los valores obtenidos en el arreglo para
                 * hallar media
                 */
                sum = sum + Integer.parseInt(part);
            }
            /**
             * Calculode la media aritmetica con el fin de hallar el rango y
             * posteriormente la varianza
             *
             */
            media = sum / 10;
            for (String part : parts) {
                double rango;
                rango = Math.pow(Integer.parseInt(part) - media, 2);
                varianza = (int) (varianza + rango);
            }
            varianza = (int) (varianza / 10);
            /**
             * Teniendo la media, y varianza se halla la desviación sacando raíz
             * cuadrada de varianza e imprimimos la información
             */

            desviacion = (int) Math.sqrt(varianza);

            System.out.println("Varianza: " + varianza);
            System.out.println("Desvianción Estándar: " + desviacion);
        }

        b.close();

    }
}
