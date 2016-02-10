package array;
import java.math.*;
public class CutChoclate {
	public static void main(String[] args) {
		BigInteger bi1 = new BigInteger("900000");
		BigInteger res =  bi1.multiply(bi1).divide(new BigInteger("4"));
		System.out.println(res);
	}
}

