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
