package org.dc.sort.heap.pq;

/**
 * Priority Queue using Min Heap.
 * Implemented with first principles.
 */
public class PriorityQueue {
  final int initialCapacity = 10;
  final int MAX_SIZE = 10;
  Element[] elements = new Element[initialCapacity];
  PriorityComparator comparator = new PriorityComparator();
  int curr_size = 0;

  public void insert(Element x) {
    if(curr_size < MAX_SIZE) {
      elements[curr_size] = x;
    }
    bubbleUp();
    curr_size++;
  }

  private int getParent(int child) {
    return (int)Math.floor((child-1)/2);
  }

  public void swap(int x, int y) {
    Element temp = elements[x];
    elements[x] = elements[y];
    elements[y] = temp;
  }

  private void bubbleUp() {
    int currIndex = this.curr_size;
    int parent = getParent(currIndex);
    while(parent >= 0 && 1==comparator.compare(elements[parent],elements[currIndex])) {
      swap(parent, currIndex);
      currIndex = parent;
      parent = getParent(currIndex);
    }
  }

  private void bubbleDown() {
    int root = 0;
    int minChild = getMinChild(root);
    while(root < getParent(curr_size)  && 1==comparator.compare(elements[root], elements[minChild])) {
      swap(root, minChild);
      root++;
      minChild = getMinChild(root);
    }
  }

  public void delete() {
    curr_size--;
    elements[0] = elements[curr_size];
    elements[curr_size] = null;
    if(curr_size > 1) {
      bubbleDown();
    }
  }

  public int getMinChild(int root) {
    if(curr_size == 2) {
      return (1==comparator.compare(elements[0],elements[1])) ? 1 : 0;
    }
    if(root!=0 && (root*2 < curr_size-1)) {
      return (1==comparator.compare(elements[root*2],elements[(root*2) + 1])) ? (root*2) + 1 : root*2;
    } else
      // root=0, curr_size=3
      return (1==comparator.compare(elements[1],elements[2])) ? 2 : 1;
  }

  public void printQueue(){
    System.out.println("Priority Queue < Priority , Data >");
    for (int i = 0; i < curr_size; i++)
      System.out.print(elements[i].priority +"," + elements[i].data +  " | ");
  }

  public static void main(String[] args) {

    PriorityQueue pq = new PriorityQueue();
    pq.insert(new Element(10,1));
    pq.insert(new Element(100,65));
    pq.insert(new Element(30,2));
    pq.insert(new Element(20,9));
    pq.insert(new Element(80,45));
    pq.insert(new Element(50,22));
    pq.insert(new Element(60,11));
    pq.insert(new Element(70,111));
    pq.insert(new Element(90,87));
    pq.insert(new Element(40,112));

    pq.printQueue();

    int i = pq.curr_size;
    while(i-- > 0) {
      System.out.println("\nServing current priority: " + pq.elements[0].priority);
      pq.delete();
      pq.printQueue();
    }
  }
}


