package Test_0;

/**
 * Se realiza la importación de los archivos importantes para el proceso, se
 * está utilizando la librería ipdf que se encuentra importada en el archivo POM
 */
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Juan Diego Alfonso
 */
public class mainCalculadora {

    public static void main(String[] args) {
        while (true) {

            /**
             * Asignación de las variables para capturar los números
             */
            /**
             * Number 1
             */
            Scanner number1 = new Scanner(System.in);
            int newNumber1;

            /**
             * Number 2
             */
            Scanner number2 = new Scanner(System.in);
            int newNumber2;

            Scanner selection = new Scanner(System.in);
            String newSelection;
            /**
             * Captura de la operación
             */
            System.out.print("Operaciones \n");
            System.out.print("1. Suma \n");
            System.out.print("2. Multiplicación \n");
            System.out.print("3. División \n");
            System.out.print("4. Exponencial \n");
            System.out.print("5. Fibbonacci y factorial de un número \n");
            System.out.print("6. Número primo \n");
            System.out.print("7. Salir \n");
            System.out.print("Ingresa una operación: ");
            newSelection = selection.nextLine();

            /**
             * If para validar cada selección
             *
             */
            if ("1".equals(newSelection)) {
                //Suma
                System.out.println("\n");
                System.out.println("Suma");

                System.out.print("Ingresa el primer número: ");
                newNumber1 = selection.nextInt();

                System.out.print("Ingresa el segundo número: ");
                newNumber2 = selection.nextInt();

                int result = newNumber1 + newNumber2;

                System.out.println(newNumber1 + " + " + newNumber2 + " = " + result);
                System.out.println("\n");

            } else if ("2".equals(newSelection)) {
                //Multiplicación
                System.out.println("\n");
                System.out.println("Multiplicación");

                System.out.print("Ingresa el primer número: ");
                newNumber1 = selection.nextInt();

                System.out.print("Ingresa el segundo número: ");
                newNumber2 = selection.nextInt();

                int result = newNumber1 * newNumber2;

                System.out.println(newNumber1 + " * " + newNumber2 + " = " + result);
                System.out.println("\n");

            } else if ("3".equals(newSelection)) {
                //División
                System.out.println("\n");
                System.out.println("División");

                System.out.print("Ingresa el numerador: ");
                newNumber1 = selection.nextInt();

                System.out.print("Ingresa el denominador: ");
                newNumber2 = selection.nextInt();

                int result = newNumber1 / newNumber2;

                System.out.println(newNumber1 + " / " + newNumber2 + " = " + result);
                System.out.println("\n");

            } else if ("4".equals(newSelection)) {
                //Exponente
                System.out.println("\n");
                System.out.println("Exponenciación");

                System.out.print("Ingresa la base: ");
                newNumber1 = selection.nextInt();

                System.out.print("Ingresa el exponente: ");
                newNumber2 = selection.nextInt();

                int result = (int) Math.pow(newNumber1, newNumber2);

                System.out.println(newNumber1 + " / " + newNumber2 + " = " + result);
                System.out.println("\n");

            } else if ("5".equals(newSelection)) {
                /**
                 * Esta opción generará no solo el número de Fibbonacci sino
                 * tambien la exponencial del número e^n Si el número pertenece
                 * a la serie de fibbonacci cual es la serie de ese número y la
                 * cantidad de series realizadas.
                 */
                Scanner number = new Scanner(System.in);
                int newNumber;
                System.out.print("Ingresa un numero: ");
                newNumber = number.nextInt();

                System.out.println("exp(e^" + newNumber + ") es " + Math.exp(newNumber));

                int pastNumber = 0;
                int lastNumber = 1;
                int number3;
                int number4 = 0;
                int[] arrayFibbo = new int[newNumber];
                for (int i = 0; i < newNumber; i++) {

                    number3 = lastNumber + pastNumber;
                    number4 = number4 + lastNumber;
                    arrayFibbo[i] = lastNumber;
                    pastNumber = lastNumber;
                    lastNumber = number3;

                    if (lastNumber == newNumber) {
                        System.out.println("El número " + newNumber + " hace parte de la serie de Fibbonacci");
                    }

                }

                System.out.println("Total de series de fibbonacci: " + number4);
                System.out.println("Series Fibbonacci " + Arrays.toString(arrayFibbo));
                System.out.println("\n");

            } else if ("6".equals(newSelection)) {

                /**
                 * La última opción indica si un número es o no un número primo
                 */
                Scanner number = new Scanner(System.in);
                int newNumber;
                System.out.print("Ingresa un numero: ");
                newNumber = number.nextInt();

                int val = 0;

                for (int i = 1; i < (newNumber + 1); i++) {
                    if (newNumber % i == 0) {
                        val++;
                    }
                }
                if (val != 2) {
                    System.out.println("No es Primo");
                } else {
                    System.out.println("Si es Primo");
                }
                System.out.println("\n");
            } else if ("7".equals(newSelection)) {
                /**
                 * El número 7 cierra el ciclo y finaliza el programa
                 */
                break;

            } else {

                /**
                 * Caso de no indicar un valor valido no dejará continuar
                 */
                System.err.println("Por favor ingrese un valor valido ");

            }

        }

    }

}
