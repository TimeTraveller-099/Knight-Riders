private static int[] NSEL(int[] arr) {
    Stack<Integer> stack = new Stack<>();
    int n = arr.length;
    int[] NSEL = new int[n];

    for (int i = 0; i < n; i++) {
        while(!stack.isEmpty() && stack.peek() >= arr[i]) {
            stack.pop();
        }
        if (stack.isEmpty()) {
            NSEL[i] = -1;
        } else {
            NSEL[i] = stack.peek();
        }
        stack.push(arr[i]);
    }
    return NSEL;
}
