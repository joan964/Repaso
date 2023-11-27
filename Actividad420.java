package main;

import java.util.Scanner;

public class Actividad420 {

    private static final String COLOR_RESET = "\u001B[0m";
    private static final String COLOR_ROIG = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String COLOR_GROC = "\u001B[33m";
    private static final String COLOR_BLAU = "\u001B[36m";

    private static Scanner teclado;

    public static void main(String[] args) {
        teclado = new Scanner(System.in);
        introduccion();
        double InteresAnual =obtenirInteresAnual();
        double capitalInvertida=obtenirCapitalAInvertir();
        double interesMensual=interesMensual(InteresAnual);
        double capitalAFuturo=obtenirValorFuturInversio(capitalInvertida,interesMensual,16);


    }
    //Obté el valor de la inversió @capitalInvertit transcorreguts @numAnys a un interés mensual de @interesMensual

    public static double obtenirValorFuturInversio(double capitalInvertit, double interesMensual, int numAnys) {
        double multAños;
        double mensula2;
        double caclculoMensulal;
        double calculoFinal = 0;

        introduccionCalculos();

        for (int i = 0; i < numAnys; i++) {
             multAños=i*12;
             mensula2=(1+interesMensual);
             caclculoMensulal=Math.pow(mensula2,multAños);
             calculoFinal=capitalInvertit*caclculoMensulal;
            String indicació=obtenirIndicacio(capitalInvertit,calculoFinal);

            System.out.printf("%d\t \t%.2f",i,calculoFinal);
            double ajudaGovern=obtenirAjudaGovern(calculoFinal);
            System.out.printf(" (+%.2f)\t \t"+indicació+"\n",ajudaGovern);
        }
        return calculoFinal;
    }

    // Obté el total aportat pel govern en funció de @capitalInverti

    public static double obtenirAjudaGovern(double capitalInvertit) {

        if (capitalInvertit>10000 && capitalInvertit<50000){
            return 25;
        } else if (capitalInvertit>50000) {
            return 50;
        }else {
            return 0;
        }
    }

    // Demana a l'usuari que inserisca les dades sobre el interés anual (accepta decimals) i el torna.

    public static double obtenirInteresAnual() {
        String mensaje="Interès anual (%): ";
        int interèsAnual=pedirNumero(mensaje);

        return interèsAnual;
    }
    // Demana a l'usuari que inserisca el capital que invertirà (accepta decimals) i el torna.

    public static double obtenirCapitalAInvertir() {
        String mensaje="Capital a invertir (€): ";
        int capitalInvertida=pedirNumero(mensaje);

        return capitalInvertida;
    }

    // Obtenir indicació gràfica sobre el rendiment de la inversió
    public static String obtenirIndicacio(double capitalInvertit, double totalObtingut) {

        double capital1=(capitalInvertit*0.25)+capitalInvertit;
        double capital2=(capitalInvertit*0.50)+capitalInvertit;
        double capital3=(capitalInvertit*0.75)+capitalInvertit;

        if (totalObtingut<capital1){
            return COLOR_ROIG+"\u2193"+COLOR_RESET;
        } else if (totalObtingut>=capital1 && totalObtingut<capital2) {
            return COLOR_GROC+"\u2192"+COLOR_RESET;
        } else if (totalObtingut>=capital2 && totalObtingut<capital3) {
            return COLOR_BLAU+"\u2197"+COLOR_RESET;
        }else {
            return ANSI_GREEN+"\u2191"+COLOR_RESET;
        }
    }

    public static void introduccion() {
        System.out.println("Batoi INVERSIONS 2021");
        System.out.println("=====================");

    }

    public static int pedirNumero(String mensaje) {
        do {
            int numeroIntroducido =pedirNumeroLetra(mensaje);
            if (numeroIntroducido > 0) {
                    return numeroIntroducido;
                }else {
                    System.out.println("Error! Les dades introduïdes no són correctes");
                }
        } while (true);

    }

    public static int pedirNumeroLetra(String mensaje) {

        int numeroIntroducido;
        do {
            System.out.print(mensaje);
            if (teclado.hasNextDouble()) {
                numeroIntroducido = teclado.nextInt();
                return numeroIntroducido;
            }
            else {
                System.out.println("Error! El tipus de dades introduït és incorrecte");
            }
            teclado.next();
        } while (true);
    }
    public static double interesMensual(double interesAnual ){
        double anual1=interesAnual/100;
        double conversión=anual1/12;
        return conversión;
    }
    public static void introduccionCalculos(){
        System.out.println("Any     Valor Futur(+ajuda)         Indicació");
        System.out.println("=====================================");
    }

}
