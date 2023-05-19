package com.hanex.starter.common.util.encrypt;

public interface Encryptor {
	byte[] encrypt(String value);

	String decrypt(byte[] encrypted);
}
