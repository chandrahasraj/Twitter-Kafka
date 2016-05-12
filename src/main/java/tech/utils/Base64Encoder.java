package tech.utils;

import org.apache.commons.codec.binary.Base64;

public class Base64Encoder {

	public static String encodeData(String toEncode){
		return new String(Base64.encodeBase64(toEncode.getBytes()));
	}
}
