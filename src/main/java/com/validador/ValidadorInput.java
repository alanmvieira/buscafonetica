package com.validador;

import com.utils.mensagens.ErroMensagem;

public class ValidadorInput {

	private ErroMensagem erroMensagens = new ErroMensagem();
	
	public boolean validar(String[] input) {

		if (input == null) {
			throw new IllegalArgumentException(erroMensagens.ARGUMENTOS_NAO_DEFINIDOS);
		} else if (input.length < 3) {
			throw new IllegalArgumentException(erroMensagens.QUANTIDADE_ARGUMENTOS_INVALIDOS);
		} else if (input[0] == null || input[1] == null || input[2] == null || input[0].isEmpty() || input[1].isEmpty() || input[2].isEmpty()) {
			throw new IllegalArgumentException(erroMensagens.ARGUMENTOS_NAO_DEFINIDOS);
		}

		String separador = capturarArgumentoPorIndex(input.length - 2, input);

		if (separador.isEmpty() || !separador.equals("<")) {
			throw new IllegalArgumentException(erroMensagens.DEFINICAO_ARGUMENTO_SEPARACAO_INVALIDO);
		}

		String argArquivo = capturarArgumentoPorIndex(input.length - 1, input);

		if (!argArquivo.endsWith(".txt")) {
			throw new IllegalArgumentException(erroMensagens.EXTENSAO_ARQUIVO_INVALIDO);

		}

		return true;
	}

	private String capturarArgumentoPorIndex(int index, String[] input) {
		return input[index];
	}

}
