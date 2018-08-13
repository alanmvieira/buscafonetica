package test.com.validador;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.validador.ValidadorInput;

public class ValidadorInputTest {

	ValidadorInput validadorInput = null;

	@Before
	public void init() {
		validadorInput = new ValidadorInput();
	}

	@Test(expected = IllegalArgumentException.class)
	public void validarTestArgsNull() {

		String[] args = null;

		try {
			validadorInput.validar(args);
		} catch (RuntimeException re) {
			String message = "Args null";
			assertEquals(message, re.getMessage());
			throw re;
		}

	}

	@Test(expected = IllegalArgumentException.class)
	public void validarTestArgsQuantidade() {

		String[] args = new String[2];
		args[0] = "arg1";
		args[1] = "arg2";

		try {
			validadorInput.validar(args);
		} catch (RuntimeException re) {
			String message = "quantidade de argumentos invalidos";
			assertEquals(message, re.getMessage());
			throw re;
		}

	}

	@Test(expected = IllegalArgumentException.class)
	public void validarTestArgsVazios() {

		String[] args = new String[3];
		args[0] = "arg1";
		args[1] = "arg2";
		args[2] = "";

		try {
			validadorInput.validar(args);
		} catch (RuntimeException re) {
			String message = "definição de argumentos invalidos";
			assertEquals(message, re.getMessage());
			throw re;
		}

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void validarTestArgsSeparacao() {

		String[] args = new String[3];
		args[0] = "arg1";
		args[1] = ">";
		args[2] = "args";

		try {
			validadorInput.validar(args);
		} catch (RuntimeException re) {
			String message = "definição de argumentos de separacao invalido";
			assertEquals(message, re.getMessage());
			throw re;
		}

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void validarTestArgsFile() {

		String[] args = new String[3];
		args[0] = "arg1";
		args[1] = "<";
		args[2] = "text.txtt";

		try {
			validadorInput.validar(args);
		} catch (RuntimeException re) {
			String message = "extensao do arquivo de dicionario errado";
			assertEquals(message, re.getMessage());
			throw re;
		}

	}

}
