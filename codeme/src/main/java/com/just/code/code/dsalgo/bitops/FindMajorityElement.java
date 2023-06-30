package dsalgo.bitops;

public class FindMajorityElement {

    public static int majorityElement(int[] nums) {
        int[] bit = new int[32];
        for (int n : nums) {
            for (int i = 31; i >= 0; i--) {
                //count each 1'a bit by right shifting
                //Ex 000000000000000000000000000101 -> bit[0]++, bit[2]++
                //Ex 100000000000000000000000000001 -> bit[31]++, bit[0]++
                if (((n >> i) & 1) == 1) {
                    bit[i]++;
                }
            }
        }
        int maj = 0;
        for (int i = 0; i < 32; i++) {
            //any bit that has count more than half len of array will be majority element
            if (bit[i] > (nums.length / 2)) {
                maj += (1 << i); // convert bit to decimal
            }
        }
        return maj == 0 ? -1 : maj;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1,2,2, 2,2,2,2};
        System.out.println("majority num: " + majorityElement(nums));
    }
}
