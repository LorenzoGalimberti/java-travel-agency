package org.java.lessons;

import java.time.LocalDate;

public class Vacanza {
    // TRRIBUTI
    private String destinazione;
    private LocalDate dataInizio;
    private LocalDate dataFine;

    // COSTRUTTORI
    public Vacanza(String destinazione, LocalDate dataInizio, LocalDate dataFine) throws RuntimeException {
        // Validazione dei parametri
        if (destinazione == null || dataInizio == null || dataFine == null) {
            throw new RuntimeException("Destinazione, data inizio e data fine non possono essere nulli!");
        }

        if (dataInizio.isBefore(LocalDate.now())) {
            throw new RuntimeException("La data di inizio è già passata!");
        }

        if (dataFine.isBefore(dataInizio)) {
            throw new RuntimeException("La data di fine non può essere prima della data di inizio!");
        }

        this.destinazione = destinazione;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }


// GET AND SET
    public String getDestinazione() {
        return destinazione;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }
    // METODI
    public long calcolaDurata() {
        return dataInizio.until(dataFine, java.time.temporal.ChronoUnit.DAYS);
    }
}
