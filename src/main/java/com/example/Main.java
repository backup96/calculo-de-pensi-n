package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static long devengo_transporte(Long salario) {
        long X = 0;
        if (salario <= 2600000) {
            X = 162000;
        }
        return X;
    }

    static long descuento_dias(long salario, int dias) {
        int dias_no_trabajados = 30 - dias;
        long valor_dias_trabajados = (salario / 30) * dias_no_trabajados;
        return valor_dias_trabajados;
    }

    static Long descuento_salud_pension(Long long1) {
        Long descuento = ((long1 * 4) / 100);
        return descuento;
    }

    static Long Valor_neto(Long salario, Long transporte, long descuento_dias, long descuento_salud_pension) {
        long valor_neto = (salario + transporte) - (descuento_dias + (descuento_salud_pension * 2));
        return valor_neto;
    }

    public static void main(String[] args) {
        boolean x = true;
        Scanner varScanner = new Scanner(System.in);
        Scanner nombreScanner = new Scanner(System.in);
        Scanner documentoScanner = new Scanner(System.in);
        Scanner diasTrabajadosScanner = new Scanner(System.in);
        Scanner salarioScanner = new Scanner(System.in);
        Scanner SubTransporteScanner = new Scanner(System.in);
        int i = 0;
        ArrayList<String> nombre = new ArrayList<String>();
        ArrayList<Long> documento = new ArrayList<Long>();
        ArrayList<Integer> diasTrabajados = new ArrayList<Integer>();
        ArrayList<Long> salario = new ArrayList<Long>();
        ArrayList<Long> SubTransporte = new ArrayList<Long>();
        while (x != false) {
            try {
                System.out.println(
                        "Para calcular liquidación de nomina escriba true, para terminar operacion escriba false");
                x = varScanner.nextBoolean();
            } catch (Exception e) {
                System.out.println("Por favor ingrese una opcion valida");
                x = false;
            }
            if (x == true) {
                System.out.println("Ingrese datos del empleado");
                System.out.println("Nombre: ");
                nombre.add(nombreScanner.nextLine());
                System.out.println("Documento: ");
                documento.add(documentoScanner.nextLong());
                System.out.println("Dias trabajados: ");
                diasTrabajados.add(diasTrabajadosScanner.nextInt());
                System.out.println("Salario: ");
                salario.add(salarioScanner.nextLong());
                SubTransporte.add(devengo_transporte(salario.get(i)));
                long descuento_dias = descuento_dias(salario.get(i), diasTrabajados.get(i));
                long descuento_salud_pension = descuento_salud_pension(salario.get(i));
                long valor_neto = Valor_neto(salario.get(i), SubTransporte.get(i), descuento_dias,
                        descuento_salud_pension);
                System.out.println(
                        "--------------------------\n Total bruto: " + salario.get(i) + "\n Descuentos\n Salud: "
                                + descuento_salud_pension + "\n Pension: " + descuento_salud_pension +
                                "\n Valor por dias no trabajados: " + descuento_dias + "\n Devengos\n" +
                                "Apoyo de transporte: " + SubTransporte.get(i) + "\n Valor neto a pagar: "
                                + valor_neto);
                ++i;
            }
        }
    }
}