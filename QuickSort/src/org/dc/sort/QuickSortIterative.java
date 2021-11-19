package org.dc.sort;

public class QuickSortIterative {

  int arr[]=new int[10];

  public void swap(int x, int y) {
    int temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
  }

  public int partition(int low, int high) {
    //choose last element as pivot
    int pivot = arr[high];
    //track infinity on the other end
    int i = (low-1);

    for (int j = low; j < high; j++) {
      if (arr[j] <= pivot) {//if current element smaller than pivot
        i++;
        swap(i,j);
      }
    }
    swap(i+1, high);
    return i+1;
  }

  public void quickSort(int low, int high)
  {
    // Create an auxiliary stack
    int[] stack = new int[high - low + 1];

    // initialize top of stack
    int top = -1;

    // push initial values of low and high to stack
    stack[++top] = low;
    stack[++top] = high;

    // Keep popping from stack while is not empty
    while (top >= 0) {
      // Pop h and l
      high = stack[top--];
      low = stack[top--];

      // Set pivot element at its correct position
      // in sorted array
      int p = partition(low, high);

      // If there are elements on left side of pivot,
      // then push left side to stack
      if (p - 1 > low) {
        stack[++top] = low;
        stack[++top] = p - 1;
      }

      // If there are elements on right side of pivot,
      // then push right side to stack
      if (p + 1 < high) {
        stack[++top] = p + 1;
        stack[++top] = high;
      }
    }
  }

  // Function to print an array
  static void printArray(int[] arr, int size)
  {
    for(int i = 0; i < size; i++)
      System.out.print(arr[i] + " ");

    System.out.println();
  }

  public static void main(String[] args)
  {
    QuickSortIterative qsr = new QuickSortIterative();
    qsr.arr = new int[]{ 10, 7, 8, 9, 1, 5 };
    int n = qsr.arr.length;

    qsr.quickSort(0, n - 1);
    System.out.println("Sorted array: ");
    printArray(qsr.arr, n);
  }

}
