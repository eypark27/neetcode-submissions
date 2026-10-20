class Solution {
    private void swap(int[] nums, int a, int b) {
        int buffer = nums[a];
        nums[a] = nums[b];
        nums[b] = buffer;        
    }

    private void sortPair(int[] nums, int a) {
        int b = a + 1;

        if (nums[b] >= nums[a]) {
            return;
        }

        swap(nums, a, b);
    }

    private int pivotSwap(int[] nums, int a, int b, int c) {
        int pivotIndex = c;
        int pivotValue = nums[c];

        while (b > a) {
            int valA = nums[a];
            int valB = nums[b];

            boolean aPivot = (a == pivotIndex);
            boolean bPivot = (b == pivotIndex);

            boolean aSatisfied = (valA >= pivotValue) || aPivot;
            boolean bSatisfied = (valB < pivotValue) || bPivot;

            // swap!
            if (aSatisfied && bSatisfied) {
                swap(nums, a, b);

                if (aPivot) {
                    pivotIndex = b;
                    aPivot = false;
                    bPivot = true;
                }

                else if (bPivot) {
                    pivotIndex = a;
                    aPivot = true;
                    bPivot = false;
                }
            }

            // recalculate values
            valA = nums[a];
            valB = nums[b];

            if (valA < pivotValue && !aPivot) {
                a++;
            }

            if (valB >= pivotValue && !bPivot) {
                b--;
            }
        }
        
        return pivotIndex;
    }

    // o      
    // 1 9 1 t 1 2 3 1
    // n y y y y y y y

    private void sort(int[] nums, int a, int b) {
        // singleton
        if (a == b) {
            return;
        }
        
        // paid
        if (a == b - 1) {
            sortPair(nums, a);
            return;
        }

        int c = (a + b) / 2;
        c = pivotSwap(nums, a, b, c);

        if (c > a) {
            sort(nums, a, c - 1);
        }

        if (c < b - 1) {
            sort(nums, c + 1, b);
        }
    }

    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }
}