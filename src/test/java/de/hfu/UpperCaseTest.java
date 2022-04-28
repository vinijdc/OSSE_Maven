package de.hfu;

import org.junit.Test;
import static org.junit.Assert.*;

public class UpperCaseTest{
	@Test
	public void testStringtoUpperCase() {
		final String eingabe = "Das ist ein Testfall.";
		final String sollWert = "DAS IST EIN TESTFALL.";
		assertEquals(sollWert, eingabe.toUpperCase());
	}
}