class FreqStack {
   Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> pos;
    int maxfreq;

    public FreqStack() {
        freq = new HashMap<>();
        pos = new HashMap<>();
        maxfreq = 0;
    }

    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);

        maxfreq = Math.max(maxfreq, f);

        pos.computeIfAbsent(f, z -> new Stack<>()).push(val);
    }

    public int pop() {
        Stack<Integer> stack = pos.get(maxfreq);
        int val = stack.pop();

        // decrement frequency count
        freq.put(val, freq.get(val) - 1);

        // if no more elements with current max frequency, decrease maxfreq
        if (stack.isEmpty()) {
            maxfreq--;
        }

        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */