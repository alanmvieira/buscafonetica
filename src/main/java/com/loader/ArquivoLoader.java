package com.loader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Set;

import com.utils.mensagens.ErroMensagem;

public class ArquivoLoader {

	private ErroMensagem erroMensagens = new ErroMensagem();
	
	public Set<String> lerValoresArquivoDicionario(String pathFile) throws IOException {

		File file = new File(pathFile);
		try {
			return new HashSet<String>(Files.readAllLines(file.toPath()));
		} catch (IOException e) {
			throw new IOException(erroMensagens.ERRO_ARQUIVO_DICIONARIO);
		}

	}

}
