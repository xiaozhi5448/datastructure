package sort;


public class SortUtil {
    private int partition(int nums[], int start, int end){
        int pivot = nums[start];
        int left_index = start;
        int right_index = end-1;
        while(left_index < right_index){
            while(nums[right_index]>= pivot && left_index < right_index){
                right_index--;
            }
            if(left_index < right_index){
                nums[left_index] = nums[right_index];
                left_index++;
            }
            while(nums[left_index] <= pivot && left_index < right_index){
                left_index++;
            }
            if(left_index<right_index){
                nums[right_index] = nums[left_index];
                right_index--;
            }
        }
        nums[left_index] = pivot;
        return left_index;

    }
    public void quickSort(int nums[], int start, int end){
        if(nums == null || nums.length <= 1 || start >= end){
            return;
        }
        int mid_index = partition(nums, start, end);
        quickSort(nums, start, mid_index);
        quickSort(nums, mid_index+1, end);
    }

    public void bubbleSort(int[] nums, int begin, int end){
        int tmp;
        for(int i = begin; i < end; i++){
            for(int j = begin+1; j < end - i;j++){
                if(nums[j] < nums[j-1]){
                    // swap num[j] and nums[i]
                    tmp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = tmp;
                }

            }

        }
    }
}
