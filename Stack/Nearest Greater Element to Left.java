private static int[] NGEL(int[] arr) {
    Stack<Integer> stack = new Stack<>();
    int n = arr.length;
    int[] NGEL = new int[n];
        
    for (int i = 0; i < n; i++) {
        while(!stack.isEmpty() && stack.peek() <= arr[i]) {
            stack.pop();
        }
        if (stack.isEmpty()) {
            NGEL[i] = -1;
        } else {
            NGEL[i] = stack.peek();
        }
        stack.push(arr[i]);
    }
    
    return NGEL;
}
