package org.java.lessons;

import java.time.LocalDate;
import java.util.Scanner;

public class Agenzia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean continua = true;
        while (continua) {
            try {
                System.out.print("Vuoi inserire una nuova vacanza? (Y/n): ");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("n")) {
                    continua = false;
                } else if (input.equalsIgnoreCase("y")) {
                    System.out.print("Inserisci la destinazione: ");
                    String destinazione = scanner.nextLine();

                    System.out.print("Inserisci la data di partenza (yyyy-MM-dd): ");
                    String dataInizioString = scanner.nextLine();
                    LocalDate dataInizio = LocalDate.parse(dataInizioString);

                    System.out.print("Inserisci la data di ritorno (yyyy-MM-dd): ");
                    String dataFineString = scanner.nextLine();
                    LocalDate dataFine = LocalDate.parse(dataFineString);

                    Vacanza vacanza = new Vacanza(destinazione, dataInizio, dataFine);
                    System.out.println("Hai prenotato una vacanza di " + vacanza.calcolaDurata() + " giorni a " +
                            vacanza.getDestinazione() + " dal " + vacanza.getDataInizio() + " al " + vacanza.getDataFine());
                } else {
                    System.out.println("Comando non valido. Riprova.");
                }
            } catch (RuntimeException e) {
                System.out.println("Errore durante la prenotazione: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
