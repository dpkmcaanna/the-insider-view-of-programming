package programming.injava.sorting;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sort(new int[] {5,3,7,1,9,11});
	}

	public static void sort(int[] data) {
		int n = data.length;
		for(int i = 0; i < n-1; i++) {
			for(int j = 0; j < n -1 - i; j++) {
				if(data[j] > data[j+1] ) {
					int t = data[j];
					data[j] = data[j + 1];
					data[j + 1] = t;
				}
			}
		}
		
		for (int v : data) {
			System.out.print(v + ", ");
		}
	}
}
