package test.com.loader;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Set;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.loader.ArquivoLoader;

public class ArquivoLoaderTest {
	
	private ArquivoLoader arquivoLoader = null;
	
	@Before
	public void init(){
		arquivoLoader = new ArquivoLoader();
	}
	
	@Test(expected = IOException.class)
	@Ignore
	public void getDicionarioArquivoErrado() throws IOException{
		
		String pathFile = "/Users/Vieira/Development/Workspaces/ws6/buscafonetica/resources/word_dict";
		
		arquivoLoader.lerValoresArquivoDicionario(pathFile);
		
	}
	
	@Test()
	@Ignore
	public void getDicionario() throws IOException{
		
		String pathFile = "/Users/Vieira/Development/Workspaces/ws6/buscafonetica/resources/word_dict.txt";
		
		Set<String> valoresDicionario = arquivoLoader.lerValoresArquivoDicionario(pathFile);
		
		assertTrue(valoresDicionario.contains("goal"));
		
	}
}
