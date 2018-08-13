package com.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.loader.ArquivoLoader;
import com.model.MatchableString;
import com.utils.transformador.TransformadorLexical;

public class ProcessadorFonetico {

	private ArquivoLoader arquivoLoader = new ArquivoLoader();
	private String[] args = null;
	private Set<String> words = null;
	private String arquivoDicionario = null;

	public ProcessadorFonetico(String[] argumentosInformados) {
		
		args = argumentosInformados[0].split(" ");

		words = capturarPalavrasIniciais(this.args);
		arquivoDicionario = args[args.length - 1];
	}

	public Map<String, List<String>> buscaFonetica() {

		Map<String, List<String>> retorno = null;

		try {

			Set<String> dicionarioEntrada = arquivoLoader.lerValoresArquivoDicionario(arquivoDicionario);

			Map<MatchableString, List<String>> dicionario = normalize(dicionarioEntrada);
			Map<MatchableString, List<String>> argumentWords = normalize(words);

			retorno = processamentoBuscaFonetica(argumentWords, dicionario);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return retorno;
	}

	private Map<String, List<String>> processamentoBuscaFonetica(Map<MatchableString, List<String>> argumentWords,
			Map<MatchableString, List<String>> dictionary) {
		
		Map<String, List<String>> matchedWords = new HashMap<>();

		argumentWords.forEach((matchableArgument, arguments) -> {
			List<String> dictionaryWords = dictionary.get(matchableArgument);

			arguments.stream().forEach((argument) -> {
				matchedWords.put(argument, dictionaryWords);
			});
		});

		return matchedWords;
	}

	private Set<String> capturarPalavrasIniciais(String[] args) {
		Set<String> palavras = new HashSet<String>();

		for (int i = 0; i < args.length - 2; i++) {
			palavras.add(args[i]);
		}

		return palavras;
	}

	private Map<MatchableString, List<String>> normalize(Set<String> wordSet) {

		Map<MatchableString, List<String>> normalizedMap = new HashMap<>();
		TransformadorLexical normalizer = new TransformadorLexical();

		wordSet.stream().forEach((word) -> {
			MatchableString normalizedWord = new MatchableString(normalizer.normalize(word));

			if (normalizedMap.containsKey(normalizedWord)) {
				normalizedMap.get(normalizedWord).add(word);
			} else {
				List<String> words = new ArrayList<>();

				words.add(word);
				normalizedMap.put(normalizedWord, words);
			}
		});
		
		return normalizedMap;
	}

}
