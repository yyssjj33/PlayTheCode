package array;

import java.util.Random;

public class RandomFromStream {
	private static int counter = 0;
	private static int res = 0;
	private Random r;
	public int generator(int x){
		counter++;
		if (counter == 1){
			res = x;
		}
		else{
			int i = (int) (r.nextDouble()*counter);
			if (i == counter - 1)
				res = x;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		RandomFromStream rfs = new RandomFromStream();
		
		int[] stream = {1,2,3,4,5,6,7,8,9,10};
		for (int j=0; j < stream.length; j++){
			System.out.print(rfs.generator(stream[j])+" ");
		}
	}
}
