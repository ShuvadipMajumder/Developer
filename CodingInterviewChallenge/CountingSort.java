import java.util.Arrays;

public class CountingSort {
	
	public static void countingSortOn(int [] arr) {
		int max = Arrays.stream(arr).max().orElse(0);
		System.out.println("max : "+max);
		int[] count = new int[max+1];
		
		//count occurrences
		for (int num : arr) {
			count[num]++;
		}
		System.out.println("count : "+Arrays.toString(count));
		//Build the sorted result back into original array
		int index =0;
		for (int i=0; i<=max; i++) {
			while(count[i]-- > 0) {
				arr[index++] =i;
				System.out.println(i);
				System.out.println(Arrays.toString(arr));
			}
		}
	}
	
	
	public static void main(String[] args) {
		int[] testArr = {5,8,2,4,9,3,2,1,0,6,7};
		System.out.println("testArr : "+Arrays.toString(testArr));
		countingSortOn(testArr);
	}

}
