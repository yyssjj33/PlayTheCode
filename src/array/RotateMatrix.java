package array;

public class RotateMatrix {
	public static void rotate(int[][] matrix, int n){
        int layer = matrix.length/2;
        for(int i = 0; i < layer; i++){//layer
            int first = i;
            int last = n - 1 - i;
            for(int j = first; j < last ; j++){//offset
                int temp = matrix[first][j];
                int offset = j - first;
                //move left edge top;
                matrix[first][j] = matrix[last - offset][first];
                //move bot to left
                matrix[last-offset][first] = matrix[last][last - offset];

                //move right to bot
                matrix[last][last - offset] = matrix[j][last];

                matrix[j][last] = temp;
  
            }
        }
    }
	public static int[][] buildMatrix(int l){
		int[][] out = new int[l][l];
		int num = 1;
		for(int i = 0; i< l; i++){
			for(int j = 0; j < l; j++){
				out[i][j] = num++;
			}
		}
		return out;
	}
	
	public static void print(int[][] matrix){
		for(int i = 0; i < matrix.length; i++){
			System.out.print(matrix[i][0]);
			for(int j = 1; j < matrix[i].length; j++){
				System.out.printf("%4d", matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[][] m = buildMatrix(4);
		print(m);
		rotate(m, 4);
		System.out.println();
		print(m);
	}
}
