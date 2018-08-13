package com.formater;

import java.util.List;
import java.util.Map;

public class FormatadorSaida {

	public String formatar(Map<String, List<String>> matchedWords) {

		StringBuilder saida = new StringBuilder("\n");

		matchedWords.forEach((argument, dictionaryWords) -> {
			
			saida.append(argument).append(":");
			dictionaryWords.stream().forEach((dictionaryWord) -> {
				saida.append(" ").append(dictionaryWord).append(",");
			});
			
			saida.deleteCharAt(saida.length() - 1).append("\n");
			
		});

		return saida.toString();
	}
}
