
public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int arr[]= {3,7,1,9,0,4,8,5};
		quickSort(arr,0, arr.length-1);
		
		System.out.println("After sort");
		for(int num : arr) {
			System.out.print(num + " ");
		}
	}

	private static void quickSort(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		for(int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println("");
		if (low < high) {
			
			int pivot = partition(arr, low, high);
			System.out.println("pivot : "+pivot);
			quickSort(arr,low,pivot-1);
			quickSort(arr,pivot+1,high);
			
		}
	}

	private static int partition(int[] arr, int low, int high) {
		// TODO Auto-generated method stub

		int pivot=arr[high];
		int i=low-1;
		for(int j=low;j<high;j++) {
			if(arr[j]<pivot) {
				i++;
				int tmp=arr[i];
				arr[i]=arr[j];
				arr[j]=tmp;				
			}			
		}
		int tmp=arr[i+1];
		arr[i+1]=arr[high];
		arr[high]=tmp;
		
		return i+1;
	}

}
