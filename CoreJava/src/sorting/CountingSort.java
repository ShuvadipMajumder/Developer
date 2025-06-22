package sorting;

import java.util.Arrays;

public class CountingSort {
	
	public static void countingSort(int[] arr) {
		
		//find max
		int max = Arrays.stream(arr).max().orElse(0);
		
		//create and populate counting array with occurrences
		int[] count = new int[max+1];
		for (int num : arr) {
			count[num]++;
		}
		System.out.println("count : "+Arrays.toString(count));
		//override input array in order
		int arrIndex =0;
		for (int countIndex=0; countIndex <= max; countIndex++) {
			while(count[countIndex]-- > 0) {
				arr[arrIndex++]=countIndex;
			}
		}
	}
	
	public static void main (String[] args) {
		int [] arr = {3,2,5,1,7,4,8,3};
		countingSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
