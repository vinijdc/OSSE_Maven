package de.hfu;

import org.junit.Test;

public class istErstesHalbjahrTest{
	@Test(expected=IllegalArgumentException.class, timeout=1000)
	public void testIstErstesHalbjahr(){
		Util.istErstesHalbjahr(13);
	}
}