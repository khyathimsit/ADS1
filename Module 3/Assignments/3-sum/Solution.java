import java.util.Scanner;
import java.util.Arrays;
class Solution {
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] array = new int[size];
		int count = 0;
		for (int i = 0; i < size; i++) {
			array[i] = sc.nextInt();
		}
		Arrays.sort(array);
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				int low = j + 1;
				int high = size - 1;
				while (low <= high) {
					int mid = (low + high) / 2;
					if (-(array[i] + array[j]) == array[mid]) {
                		count = count + 1;
                	}
                	else if (-(array[i] + array[j]) < array[mid]) {
                		high = mid - 1;
            		}
            		else {
                		low = mid + 1;
            		}
            	}
            }
		}
		System.out.println(count);
	}
}
	