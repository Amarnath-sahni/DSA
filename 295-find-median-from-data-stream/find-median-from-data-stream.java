class MedianFinder {
    private PriorityQueue<Integer>left;
      private PriorityQueue<Integer>right;

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();

    }
    
    public void addNum(int num) {
        left.add(num); //maxHeap

        //balance the heap
        right.add(left.poll());

        //check right heap < left heap
        if(left.size() < right.size()){
            left.add(right.poll());
        }
    }
    
    public double findMedian() {
        if(left.size() > right.size()){
            return left.peek();
        }else{
            return (left.peek()+right.peek())/2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */