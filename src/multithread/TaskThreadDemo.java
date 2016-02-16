package multithread;

public class TaskThreadDemo {
	public static void main(String[] args) {
		Runnable printA = new PrintChar('a',20);
		Runnable printB = new PrintChar('b',20);
		Runnable printNum = new PrintNum(20);
		
		Thread t1 = new Thread(printA);		
		Thread t2 = new Thread(printB);		
		Thread t3 = new Thread(printNum);	
		
		t1.run();
		t2.run();
		t3.run();
		
	}
}


class PrintChar implements Runnable{
	private char charToPrint;
	private int times;
	
	public PrintChar(char c, int t){
		this.charToPrint = c;
		this.times = t;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.times; i++){
			System.out.print(this.charToPrint);
		}
		
	}
}

class PrintNum implements Runnable{
	private int num;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrintNum other = (PrintNum) obj;
		if (num != other.num)
			return false;
		return true;
	}

	public PrintNum(int n){
		this.num = n;
	}
	
	public void run(){
		for (int i = 1; i <= this.num; i++){
			System.out.print(i+" ");
		}
	}
}