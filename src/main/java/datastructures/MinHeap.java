package datastructures;

public class MinHeap {

    public static final int FRONT_INDEX = 1;
    private int maxSize;
    private int size;
    private int[] heap;

    public MinHeap(int size) {
        this.maxSize = size;
        this.heap = new int[this.maxSize + 1];
        this.heap[0] = Integer.MIN_VALUE;
    }

    public int size() {
        return this.size;
    }

    public void insert(int element) throws Exception {
        if (this.size >= maxSize)
            throw new Exception("Heap Full");
        this.size++;
        this.heap[size] = element;

        int currentIndex = this.size;
        while (this.heap[currentIndex] < this.heap[parent(currentIndex)]) {
            int parentIndex = parent(currentIndex);
            swap(currentIndex, parentIndex);
            currentIndex = parentIndex;
        }
    }

    private void swap(int index1, int index2) {
        int temp = this.heap[index2];
        this.heap[index2] = this.heap[index1];
        this.heap[index1] = temp;
    }

    private int parent(int position) {
        return position / 2;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= this.size / 2; i++) {
            sb.append("Parent : ");
            sb.append(this.heap[i]);
            if ((2 * i) <= size) {
                sb.append(" Left Child : ");
                sb.append(this.heap[2 * i]);
            }
            if ((2 * i + 1) <= size) {
                sb.append(" Right Child : ");
                sb.append(this.heap[2 * i + 1]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public int remove() {
        return popElement(FRONT_INDEX);
    }

    public int remove(int index) {
        return popElement(index);
    }

    public int delete(int element) throws Exception {
        int index = search(element);
        return remove(index);
    }

    private int search(int element) throws Exception {
        int index = 1;
        while (index <= size) {
            if(this.heap[index] == element)
                return index;
            index++;
        }
        throw new Exception("Element not found");
    }

    private int popElement(int index) {
        int poppedElement = this.heap[index];
        this.heap[index] = this.heap[this.size--];
        minHeapify(index);
        return poppedElement;
    }

    private void minHeapify(int index) {
        if (!isLeaf(index)) {
            if (isCurrentGreaterThan(leftChild(index), index) || isCurrentGreaterThan(rightChild(index), index)) {
                if (this.heap[leftChild(index)] < this.heap[rightChild(index)]) {
                    swap(leftChild(index), index);
                    minHeapify(leftChild(index));

                } else {
                    swap(rightChild(index), index);
                    minHeapify(rightChild(index));
                }
            }

        }
    }

    private boolean isCurrentGreaterThan(int index1, int index2) {
        return this.heap[index2] > this.heap[index1];
    }

    private int rightChild(int index) {
        return 2 * index + 1;
    }

    private int leftChild(int index) {
        return 2 * index;
    }

    private boolean isLeaf(int index) {
        return index > (this.size / 2) && index <= this.maxSize;
    }

}
