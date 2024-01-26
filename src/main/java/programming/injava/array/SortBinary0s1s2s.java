package programming.injava.array;

public class SortBinary0s1s2s {
	
	/**
	 * It's a Dutch National Flag problem, to solve this problem
	 * User three pointer 
	 * left pointing to 0s
	 * mid pointing to 1s
	 * right pointing to 2s
	 * 
	 * if mid == 0 then swap with left and increment both by one
	 * if mid == 1 then only move mid by one
	 * if mid == 2 then swap with right and then only decrement right by one
	 * **/
	
	
	public static void sort(int[] a) {
		
		int l = 0, h = a.length - 1, n = h;
		
		for(int i = 0; i < n && i <= h;) { // mid ~ i
			if(a[i] == 0) {
				swap(a, l, i);
				l++;
				i++;
			} else if(a[i] == 1) {
				i++;
			} else {
				swap(a, i, h);
				h--;
			}
		}
		
		for(int e : a)
		System.out.print(e + ", ");
	}
	
	public static void swap(int[] a, int l, int r) {
		int t = a[l];
		a[l] = a[r];
		a[r] = t;
	}
	
	public static void main(String[] args) {
		
		int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1, 0, 2 };
		sort(arr);
	}

}
