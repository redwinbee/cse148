package p1;

public class NameHelper {
	static String generateFullName(int letterCount) {
		return Util.generateRandomString(letterCount, true) +  " " + Util.generateRandomString(letterCount, true);
	}
}
