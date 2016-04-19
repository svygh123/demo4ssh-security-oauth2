package com.ndh.demo4ssh.util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.password.PasswordEncoder;

public class Md5PasswordEncoder implements PasswordEncoder {
	
	private static String PASSWORD_DIGEST="SHA-512";
	
	@Override
	public String encode(CharSequence rawPassword) {
		String encodedPwd = null;
		try {
			encodedPwd = StringHelper.getDigestFormStr(PASSWORD_DIGEST, rawPassword.toString());
			return encodedPwd;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encodedPwd;
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		String encodedPwd = null;
		try {
			encodedPwd = StringHelper.getDigestFormStr(PASSWORD_DIGEST, rawPassword.toString());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encodedPassword.equals(encodedPwd);
	}

}
