class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int iM = m - 1;
        int iN = n - 1;
        
        for (int i = m + n - 1; i >= 0; i--) {
            boolean mValid = iM >= 0;
            boolean nValid = iN >= 0;

            if (!nValid || (mValid && nums1[iM] > nums2[iN])) {
                nums1[i] = nums1[iM];
                iM--;
            }

            else {
                nums1[i] = nums2[iN];
                iN--;
            }
        }
    }
}