import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;



public class RobinhoodSet2 {
	
	public static int goodPatterns(int[]arr) {
		int count =0;
		
		for(int i = 1; i < arr.length-1;i++) {
			if((arr[i-1]== arr[i] && arr[i] != arr[i+1]) ||
				(arr[i-1]== arr[i+1] && arr[i-1] != arr[i]) ||
				(arr[i]== arr[i+1] && arr[i-1] != arr[i]) ) {
				count++;
			}
		}
		
		return count;
	}
	
	public static int[] removePeaks(int[] nums) {
        Queue<Number> minHeap = new PriorityQueue<>((i1, i2) -> {
            if (i1.val == i2.val) {
                return 0;
            }
            return i1.val < i2.val ? -1 : 1;
        });
        Number[] numbers = new Number[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            numbers[i] = new Number(nums[i], i - 1, i + 1);
            if ((i - 1 < 0 || nums[i] > nums[i - 1]) && (i + 1 >= nums.length || nums[i] > nums[i + 1])) {
                minHeap.offer(numbers[i]);
            }
        }
        int[] res = new int[nums.length];
        int i = 0;
        while (i < res.length) {
            Number curMinPeak = minHeap.poll();
            res[i++] = curMinPeak.val;
            int curLeftNeighbor = curMinPeak.leftNeighborIndex;
            int curRightNeighbor = curMinPeak.rightNeighborIndex;
            if (curLeftNeighbor >= 0) {
                numbers[curLeftNeighbor].rightNeighborIndex = curRightNeighbor;
            }
            if (curRightNeighbor < numbers.length) {
                numbers[curRightNeighbor].leftNeighborIndex = curLeftNeighbor;
            }
            if (curLeftNeighbor >= 0 && isPeak(numbers, curLeftNeighbor, numbers[curLeftNeighbor].leftNeighborIndex, numbers[curLeftNeighbor].rightNeighborIndex)) {
                minHeap.offer(numbers[curLeftNeighbor]);
            } else if (curRightNeighbor < numbers.length && isPeak(numbers, curRightNeighbor, numbers[curRightNeighbor].leftNeighborIndex, numbers[curRightNeighbor].rightNeighborIndex)) {
                minHeap.offer(numbers[curRightNeighbor]);
            }
        }
        return res;
    }
 
    private static boolean isPeak(Number[] numbers, int midIdx, int leftIdx, int rightIdx) {
        return (leftIdx < 0 || numbers[midIdx].val > numbers[leftIdx].val) &&
                (rightIdx >= numbers.length || numbers[midIdx].val > numbers[rightIdx].val);
    }
 
    static class Number {
        int val;
        int leftNeighborIndex;
        int rightNeighborIndex;
 
        public Number(int val, int leftNeighborIndex, int rightNeighborIndex) {
            this.val = val;
            this.leftNeighborIndex = leftNeighborIndex;
            this.rightNeighborIndex = rightNeighborIndex;
        }
    }
 
    public static void main(String[] args) {
    	int[] nums = {4,4,6,1,2,2,2,3};
		int count = goodPatterns(nums);
		System.out.println(Arrays.toString(nums));
		System.out.println(count);
		
		 int[] nums1 = {2, 7, 8, 5, 1, 6, 3, 9, 4};
         System.out.println(Arrays.toString(removePeaks(nums1)));
	}
}
