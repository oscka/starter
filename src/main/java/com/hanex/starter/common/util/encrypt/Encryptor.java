package com.hanex.starter.common.util.encrypt;

public interface Encryptor {
	EncryptedField encrypt(String text);

	String decrypt(byte[] cipherText, byte[] nonce);

}
