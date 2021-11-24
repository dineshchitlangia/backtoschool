package org.dc.sort.heap;

/**
 * Min heap and Heap Sort
 */
public class Heap {

  final int MAX_SIZE = 10;
  int[] heap = new int[10];
  int curr_size = 0;

  public void insert(int x) {
    if(curr_size < MAX_SIZE) {
      heap[curr_size] = x;
    }
    bubbleUp();
    curr_size++;
  }

  private int getParent(int child) {
    return (int)Math.floor((child-1)/2);
  }

  public void swap(int x, int y) {
    int temp = heap[x];
    heap[x] = heap[y];
    heap[y] = temp;
  }

  private void bubbleUp() {
    int currIndex = this.curr_size;
    int parent = getParent(currIndex);
    while(parent >= 0 && heap[parent] > heap[currIndex]) {
      swap(parent, currIndex);
      currIndex = parent;
      parent = getParent(currIndex);
    }
  }

  private void bubbleDown() {
    int root = 0;
    int minChild = getMinChild(root);
    while(root < getParent(curr_size)  && heap[root] > heap[minChild]) {
      swap(root, minChild);
      root++;
      minChild = getMinChild(root);
    }
  }

  public void delete() {
    curr_size--;
    heap[0] = heap[curr_size];
    heap[curr_size] = 0;
    if(curr_size > 1)
      bubbleDown();
  }

  public int getMinChild(int root) {
    if(curr_size == 2) {
      return (heap[0] > heap[1]) ? 1 : 0;
    }
    if(root!=0 && (root*2 < curr_size-1)) {
      return (heap[root*2] > heap[(root*2) + 1]) ? (root*2) + 1 : root*2;
    } else
      return (heap[1] > heap[2]) ? 2 : 1;

  }

  public void printHeap(){
    System.out.println("Heap = ");
    for (int i = 0; i < curr_size; i++)
      System.out.print(heap[i] +" ");
    System.out.println();
  }

  public static void main(String[] args) {
    Heap h = new Heap();

    h.insert(1);
    h.insert(3);
    h.insert(36);
    h.insert(2);
    h.insert(19);
    h.insert(25);
    h.insert(100);
    h.insert(17);
    h.insert(7);
    h.printHeap();

    h.heap = new int[]{1, 3, 36, 2, 19, 25, 100, 17, 7};
    h.heapsort();
    h.printHeap();

    h.heap = new int[]{10,100,30,20,80,50,60,70,90,40};
    h = new Heap();

    h.insert(10);
    h.insert(100);
    h.insert(30);
    h.insert(20);
    h.insert(80);
    h.insert(50);
    h.insert(60);
    h.insert(70);
    h.insert(90);
    h.insert(40);
    h.printHeap();
  }


  public void heapify(int size, int index) {
    int largest = index;
    int left = index * 2 + 1;
    int right = left + 1;
    if (left < size && heap[left] > heap[largest]) {
      largest = left;
    }
    if (right < size && heap[right] > heap[largest]) {
      largest = right;
    }
    if (largest != index) {
      swap(index, largest);
      heapify(size, largest);
    }
  }

  public void heapsort() {
    int index = curr_size / 2 - 1;
    // Build heap (rearrange array)
    while (index >= 0) {
      heapify(curr_size, index--);
    }
    index = curr_size - 1;
    // One by one extract an element from heap
    while(index >= 0){
      // Move current root to end
      swap(0, index);
      //heapify the remaining heap
      heapify(index--, 0);
    }
  }
}

