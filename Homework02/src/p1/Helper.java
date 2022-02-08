package p1;

public class Helper {
	static String generateRandomString(int letterCount, boolean capitalizeFirst) {
		StringBuilder sb = new StringBuilder();
		
		if (capitalizeFirst) {
			sb.append(((char) (Math.random() * 26 + 'A')));
		} else {
			sb.append(((char) (Math.random() * 26 + 'a')));
		}
		for (int i = 0; i < letterCount - 1; i++) {
			char ch = (char) ((Math.random() * 26) + 'a');
			sb.append(ch);
		}
		
		return sb.toString();
	}
}
