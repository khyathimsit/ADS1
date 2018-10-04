import java.util.*;
class PairStar {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(star(str));

	}
	public static String star(String s) {
		if (s.length() <=1) {
			return s;
		}

		if (s.charAt(0) == s.charAt(1)) {
			return s.charAt(0) + "*" + star(s.substring(1));
		}
		return s.charAt(0) + star(s.substring(1));
	}
}