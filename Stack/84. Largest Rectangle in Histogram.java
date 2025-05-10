class Solution {
    private int[] nextSmallerElementToLeft(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] NSEL = new int[n];

        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                NSEL[i] = -1;
            } else {
                NSEL[i] = stack.peek();
            }

            stack.push(i);
        }

        return NSEL;
    }

    private int[] nextSmallerElementToRight(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] NSER = new int[n];    

        for (int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                NSER[i] = arr.length;
            } else {
                NSER[i] = stack.peek();
            }

            stack.push(i);
        }

        return NSER;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n == 0) return 0;

        int[] NSEL = nextSmallerElementToLeft(heights, n);
        int[] NSER = nextSmallerElementToRight(heights, n);

        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int area = heights[i] * (NSER[i] - NSEL[i] - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
