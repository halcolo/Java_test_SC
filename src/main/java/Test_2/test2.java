package Test_2;

/**
 * Se realiza la importación de los archivos importantes para el proceso, se
 * está utilizando la librería ipdf que se encuentra importada en el archivo POM
 */
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Juan Diego Alfonso
 */
public class test2 {

    public static void main(String[] args) {
        /**
         * *
         * Si se tiene otro archivo distinto por favor cambiar el nombre del
         * archivo que se tiene en la raíz
         */
        creaPDF("lectura.txt");
    }

    public static void creaPDF(String archivo) {
        /**
         * Se setea el documento junto con ipdf a utilziar como objeto
         * información extraida de:
         * https://www.adictosaltrabajo.com/tutoriales/manejo-de-documentos-pdf-en-java-con-itext/
         * lectura de archivo extraida de:
         * https://www.lawebdelprogramador.com/codigo/Java/2315-Leer-una-linea-de-un-archivo-y-separar-sus-palabras.html
         */
        Document document = new Document();

        try {
            /**
             * inicialización del archivo plano que se va a cear o a modificar.
             */
            String path = new File(".").getCanonicalPath();
            String FILE_NAME = path + "/itext-test-file.pdf";

            PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));

            document.open();

            Paragraph paragraphHello = new Paragraph();
            paragraphHello.add("Texto de archivo plano:");
            paragraphHello.setAlignment(Element.ALIGN_JUSTIFIED);

            document.add(paragraphHello);
            Paragraph paragraphLorem = new Paragraph();
            String cadena;
            FileReader f = new FileReader(archivo);
            BufferedReader b = new BufferedReader(f);
            while ((cadena = b.readLine()) != null) {

                paragraphLorem.add(cadena);
            }
            b.close();

            java.util.List<Element> paragraphList = new ArrayList<>();

            paragraphList = paragraphLorem.breakUp();

            Font fo;
            fo = new Font();
            fo.setFamily(FontFamily.COURIER.name());
            fo.setStyle(Font.BOLDITALIC);
            fo.setSize(8);

            Paragraph p3 = new Paragraph();
            p3.setFont(fo);
            p3.addAll(paragraphList);
            p3.add("ESTA ES LA INFORMACIÓN QUE TIENE EL ARCHIVO");

            document.add(paragraphLorem);
            document.add(p3);
            document.close();

            System.out.println("Archivo creado correctamente, por favor busque en la carpeta raíz del proyecto");

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static boolean String(String cadena) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
