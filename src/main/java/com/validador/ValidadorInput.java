package com.validador;

import com.utils.mensagens.ErroMensagem;

public class ValidadorInput {

	private ErroMensagem erroMensagens = new ErroMensagem();

	public boolean validar(String[] input) {

		if (input == null) {
			throw new IllegalArgumentException(erroMensagens.ARGUMENTOS_NAO_DEFINIDOS);
		}

		String[] args = input[0].split(" ");

		if (args.length < 3) {
			throw new IllegalArgumentException(erroMensagens.QUANTIDADE_ARGUMENTOS_INVALIDOS);
		} else if (args[0] == null || args[1] == null || args[2] == null || args[0].isEmpty() || args[1].isEmpty() || args[2].isEmpty()) {
			throw new IllegalArgumentException(erroMensagens.ARGUMENTOS_NAO_DEFINIDOS);
		}

		String separador = capturarArgumentoPorIndex(args.length - 2, args);

		if (separador.isEmpty() || !separador.equals("<")) {
			throw new IllegalArgumentException(erroMensagens.DEFINICAO_ARGUMENTO_SEPARACAO_INVALIDO);
		}

		String argArquivo = capturarArgumentoPorIndex(args.length - 1, args);

		if (!argArquivo.endsWith(".txt")) {
			throw new IllegalArgumentException(erroMensagens.EXTENSAO_ARQUIVO_INVALIDO);

		}

		return true;
	}

	private String capturarArgumentoPorIndex(int index, String[] input) {
		return input[index];
	}

}
