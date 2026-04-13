public class TestDataStructures {
    public static void main(String[] args) throws Exception {
        
        System.out.println("TESTING DATA STRUCTURES...");
        
        testMyArrayList();
        testMyLinkedList();   
        testMyStack();
        testMyQueue();
        testMyMinHeap();

        System.out.println("ALL TESTS PASSED!");
    }

    private static void testMyArrayList() {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        assert arrayList.size() == 3 : "Size should be 3";
        assert arrayList.get(0) == 1 : "First element should be 1";
        assert arrayList.get(1) == 2 : "Second element should be 2";
        assert arrayList.get(2) == 3 : "Third element should be 3";
        assert arrayList.contains(2) : "Should contain 2";
        assert !arrayList.contains(4) : "Should not contain 4";
        assert arrayList.indexOf(2) == 1 : "Index of 2 should be 1";
        assert arrayList.lastIndexOf(1) == 0 : "Last index of 1 should be 0";
    }

    private static void testMyLinkedList() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        assert linkedList.size() == 3 : "Size should be 3";
        assert linkedList.get(0) == 1 : "First element should be 1";
        assert linkedList.get(1) == 2 : "Second element should be 2";
        assert linkedList.get(2) == 3 : "Third element should be 3";
        assert linkedList.contains(2) : "Should contain 2";
        assert !linkedList.contains(4) : "Should not contain 4";
        assert linkedList.indexOf(2) == 1 : "Index of 2 should be 1";
        assert linkedList.lastIndexOf(1) == 0 : "Last index of 1 should be 0";
    }

    private static void testMyStack() {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assert stack.size() == 3 : "Size should be 3";
        assert stack.peek() == 3 : "Top element should be 3";
        assert stack.pop() == 3 : "Popped element should be 3";
        assert stack.size() == 2 : "Size should be 2 after pop";
    }

    private static void testMyQueue() {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assert queue.size() == 3 : "Size should be 3";
        assert queue.peek() == 1 : "Front element should be 1";
        assert queue.dequeue() == 1 : "Dequeued element should be 1";
        assert queue.size() == 2 : "Size should be 2 after dequeue";
    }

    private static void testMyMinHeap() {
        MyMinHeap<Integer> minHeap = new MyMinHeap<>();
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(8);
        minHeap.insert(1);
        assert minHeap.size() == 4 : "Size should be 4";
        assert minHeap.getMin() == 1 : "Minimum element should be 1";
        assert minHeap.removeMin() == 1 : "Removed minimum element should be 1";
        assert minHeap.size() == 3 : "Size should be 3 after removing minimum";
    }
}