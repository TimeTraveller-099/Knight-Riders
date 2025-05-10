/* Given an integer array nums, return the next greater number for every element in nums. 
The next greater number of a number x is the first greater number to its left in the array. 
If it doesn't exist, return -1 for this number. */

static int[] NGEL (int[] arr) {
    Stack<Integer> stack = new Stack<>();
    int n = arr.length;
    int[] ans = new int[n];
        
    for (int i = 0; i < n; i++) {
        while(!stack.isEmpty() && stack.peek() <= arr[i]) {
            stack.pop();
        }
        if (stack.isEmpty()) {
            ans[i] = -1;
        } else {
            ans[i] = stack.peek();
        }
        stack.push(arr[i]);
    }

    return ans;
}
