package p1;

public class NameHelper {

	/**
	 * generates a full name (first and last) with the given
	 * amount of characters each part should have.
	 *
	 * @param letterCount the number of letters the first and last name should be
	 * @return
	 */
	static String generateFullName(int letterCount) {
		return Helper.generateRandomString(letterCount, true) +  " " + Helper.generateRandomString(letterCount, true);
	}


}
