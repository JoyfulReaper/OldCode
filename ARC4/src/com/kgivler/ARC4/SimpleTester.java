package com.kgivler.ARC4;

import java.security.NoSuchAlgorithmException;

/**
 * Very simple usage example for the ARC4 class using
 * the encrypt() and decrypt() methods
 * 
 * Make sure you read the API/Javadoc for the ARC4 class,
 * it shouldn't be to hard to use then.
 * 
 * @author Kyle Givler
 * 
 * $Id: SimpleTester.java,v 1.3 2010/12/02 21:55:54 kwgivler Exp $
 * $Log: SimpleTester.java,v $
 * Revision 1.3  2010/12/02 21:55:54  kwgivler
 * Minor fixes
 *
 * Revision 1.2  2010/11/20 20:41:30  kwgivler
 * Ready for Initial Release
 *
 * Revision 1.1  2010/11/20 18:38:18  kwgivler
 * Adding SimpleTester
 *
 *
 */

public class SimpleTester {

	public static void main(String[] args) {
		ARC4 rc4 = new ARC4();
		byte key[] = null; // will hold the key generated by the key generator
		String data = "This is the String to encrypt"; // data
		
		System.out.println("Generating key.");
		try {
			key = rc4.generateKey(128); // Generate 128-byte key (must be 5-128 bits)
			rc4.arc4Init(key);          // Initialize State
		} catch (NoSuchAlgorithmException e) {
			// RC4 not supported by javax.crypto.*
			e.printStackTrace();
			System.exit(0);
		} 
		
		System.out.println("Encrypting data:");
		byte encypted[] = rc4.encrypt(data); // encrypt string
		System.out.println(encypted);
		
		rc4.arc4Init(key); // re-initialize state.
		System.out.println("Decrypting data:"); // decrypt string
		String decrypted = rc4.decrypt(encypted);
		System.out.println(decrypted);
		
	}

}
