package com.main;

import java.util.List;
import java.util.Map;

import com.formater.FormatadorSaida;
import com.service.ProcessadorFonetico;
import com.validador.ValidadorInput;

public class Main {

	public static void main(String[] args) {

		ValidadorInput validadorInput = new ValidadorInput();

		if (validadorInput.validar(args)) {

			ProcessadorFonetico processador = new ProcessadorFonetico(args);
			FormatadorSaida formatadorSaida = new FormatadorSaida();

			Map<String, List<String>> matchedWords = processador.buscaFonetica();
			String saida = formatadorSaida.formatar(matchedWords);

			System.out.println(saida);

		}

	}

}
