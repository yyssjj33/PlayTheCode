package string;

public class StringTest {
	public static void main(String[] args) {
		String s = "Hello";
		String s1 = "Hello";
		String s2 = new String("Hello");
		String s3 = new String("Hello");
		System.out.println(Integer.toHexString(s.hashCode()));
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3==s2);
		System.out.println(s.equals(s1));
	}
}
