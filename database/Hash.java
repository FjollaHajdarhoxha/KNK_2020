package database;

import java.security.MessageDigest;
//enkriptimi me SHA1,te dhenat hyrese
public class Hash {
	public static String SHA1(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA1");
			byte[] messageDigest = md.digest(input.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < messageDigest.length; i++) {
				sb.append(Integer.toString((messageDigest[i] & 0xff) + 0x100, 16).substring(1));
			}
			return sb.toString();
		} catch (Exception e) {
			return "";
		}
	}

}
