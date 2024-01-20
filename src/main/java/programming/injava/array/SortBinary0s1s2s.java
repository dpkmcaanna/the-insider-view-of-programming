package programming.injava.array;

public class SortBinary0s1s2s {
	
	public static void sort(int[] a) {
		
		int l = 0, h = a.length - 1, n = h;
		
		for(int i = 0; i < n && i <= h;) {
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
