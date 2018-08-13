package test.com.validador;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.validador.ValidadorInput;

public class ValidadorInputTest {

	ValidadorInput validadorInput = null;

	@Before
	public void init() {
		validadorInput = new ValidadorInput();
	}

	@Test()
	public void validarTestArgsNull() {

		String[] args = new String[1];
		args[0] = "1ton# brief soon < word_dict.txt";

		assertTrue(validadorInput.validar(args));

	}

}
