package leetcode;

public class Solution04 {
	public static void main(String args[]){
		Solution04 s = new Solution04();
		int[] a = {1};
		int[] b = {2, 3, 4, 5, 6};
		System.out.println(s.findMedianSortedArrays(a, b));
	}
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int l1 = nums1.length;
		int l2 = nums2.length;
		int find1 = (l1 + l2) / 2;
		if (l1 == 0){
			if (l2 % 2 == 1) return nums2[l2 / 2];
			return (nums2[l2 / 2] + nums2[l2 / 2 - 1] + 0.0) / 2;
		}
		if (l2 == 0){
			if (l1 % 2 == 1) return nums1[l1 / 2];
			return (nums1[l1 / 2] + nums1[l1 / 2 - 1] + 0.0) / 2;
		}
		int head1 = 0, head2 = 0, inc1 = 0, inc2 = 0;
		double r1 = 0, r2 = 0;
		while (head1 + head2 != find1){
			int pnum = find1 - head1 - head2;
			if (pnum == 1){
				if (head1 == l1) head2 ++;
				else if (head2 == l2) head1 ++;
				else if (nums1[head1] < nums2[head2]) head1 ++; else head2 ++;
				break;
			}
			inc1 = pnum / 2;
			inc2 = pnum - inc1;
			if (head1 + inc1 > l1){
				inc1 = l1 - head1;
				inc2 = pnum - inc1;
			}
			if (head2 + inc2 > l2){
				inc2 = l2 - head2;
				inc1 = pnum - inc2;
			}
			if (nums1[head1 + inc1 - 1] > nums2[head2 + inc2 - 1]){
				if (inc2 == 0) head1 = find1 - head2;
				head2 += inc2;
			} else {
				if (inc1 == 0) head2 = find1 - head1;
				head1 += inc1;
			}
		}
		if (head1 == l1) r1 = nums2[head2];
		else if (head2 == l2) r1 = nums1[head1];
		else if (nums1[head1] > nums2[head2]) r1 = nums2[head2]; else r1 = nums1[head1];
		if ((l1 + l2) % 2 == 0){
			head1 = 0;
			head2 = 0;
			find1 --;
			while (head1 + head2 != find1){
				int pnum = find1 - head1 - head2;
				if (pnum == 1){
					if (head1 == l1) head2 ++;
					else if (head2 == l2) head1 ++;
					else if (nums1[head1] < nums2[head2]) head1 ++; else head2 ++;
					break;
				}
				inc1 = pnum / 2;
				inc2 = pnum - inc1;
				if (head1 + inc1 > l1){
					inc1 = l1 - head1;
					inc2 = pnum - inc1;
				}
				if (head2 + inc2 > l2){
					inc2 = l2 - head2;
					inc1 = pnum - inc2;
				}
				if (nums1[head1 + inc1 - 1] > nums2[head2 + inc2 - 1]){
					if (inc2 == 0) head1 = find1 - head2;
					head2 += inc2;
				} else {
					if (inc1 == 0) head2 = find1 - head1;
					head1 += inc1;
				}
			}
			if (head1 == l1) r2 = nums2[head2];
			else if (head2 == l2) r2 = nums1[head1];
			else if (nums1[head1] > nums2[head2]) r2 = nums2[head2]; else r2 = nums1[head1];
			return (r1 + r2) / 2;
		}
		return r1;
    }
}