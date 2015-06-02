package trees_graphs;

public class SegmentTrees {

    private static class SegmentTreeNode {
        int start, end, value;
        SegmentTreeNode left, right;

        public SegmentTreeNode(int start, int end, int value, SegmentTreeNode left, SegmentTreeNode right) {
            this.start = start;
            this.end = end;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static SegmentTreeNode createSegmentTree(int[] arr, int start, int end) {
        if (start >= end) {
            return new SegmentTreeNode(start, end, arr[start], null, null);
        } else {
            int mid = start + (end - start) / 2;
            SegmentTreeNode left = createSegmentTree(arr, start, mid);
            SegmentTreeNode right = createSegmentTree(arr, mid + 1, end);
            return new SegmentTreeNode(start, end, Math.min(left.value, right.value), left, right);
        }
    }

    private static int searchSegment(SegmentTreeNode root, int start, int end) {
        if (isTotalOverlap(root, start, end)) {
            return root.value;
        } else if (isNoOverlap(root, start, end)) {
            return Integer.MAX_VALUE;
        } else {
            int left = searchSegment(root.left, start, end);
            int right = searchSegment(root.right, start, end);
            return Math.min(left, right);
        }
    }

    private static boolean isNoOverlap(SegmentTreeNode root, int start, int end) {
        return (root.end <= start || root.start >= end);
    }

    private static boolean isTotalOverlap(SegmentTreeNode root, int start, int end) {
        return (root.start >= start && root.end <= end);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{-1, 3, 4, 0, 2, 1};
        SegmentTreeNode root = createSegmentTree(arr, 0, arr.length - 1);
        System.out.println(searchSegment(root, 1, 4));
    }

}
