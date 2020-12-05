package com.funsoft.importer.scheduled;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component @EnableScheduling 
public class VerificadorDeArquivos {
	
	private static final String TIME_ZONE = "America/Sao_Paulo";
	
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	
	/**
	 * 	A: Segundos (0 - 59).
		B: Minutos (0 - 59).
		C: Horas (0 - 23).
		D: Dia (1 - 31).
		E: Mês (1 - 12).
		F: Dia da semana (0 - 6).
	 */
    @Scheduled(cron = "0/10 * * * * *", zone = TIME_ZONE) 
    public void execute() { 
    	System.out.println("--- "+LocalDateTime.now().format(formatter) +" - Início..."); 
    	new ExecutaImportacao().executa();
    	System.out.println("--- "+LocalDateTime.now().format(formatter) +" - Fim! --- "); 
    }


}
