package com.jt.display.utils;

import android.annotation.SuppressLint;


import com.jt.display.base.Constants;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

@SuppressLint("TrulyRandom")
public class AesUtil {

	/**
	 * 加密
	 * 
	 * @param content
	 *            需要加密的内容
	 * @return
	 */
	public static byte[] encrypt(String content) {

		try {
			SecretKeySpec key = new SecretKeySpec(Constants.AES_PASSWORD.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");

			byte[] t = content.getBytes("UTF-8");
			int l = t.length % 16;
			if (l > 0) {
				byte[] temp = new byte[t.length + (16 - l)];
				System.arraycopy(t, 0, temp, 0, t.length);
				t = temp;
			}
			cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(t);
			return result; // 加密
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static byte[] decrypt(byte[] content) {
		try {

			SecretKeySpec skeySpec = new SecretKeySpec(Constants.AES_PASSWORD.getBytes(),
					"AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			byte[] result = cipher.doFinal(content);
			return result; // 加密
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
