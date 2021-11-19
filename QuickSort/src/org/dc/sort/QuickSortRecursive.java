package org.dc.sort;

public class QuickSortRecursive {

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
      if (arr[j] <= pivot) {
        i++;
        swap(i,j);
      }
    }
    swap(i+1, high);
    return i+1;
  }

  public void quickSort(int low, int high)
  {
    if (low < high)
    {

      // pi is partitioning index, arr[p]
      // is now at right place
      int pi = partition(low, high);

      // Separately sort elements before
      // partition and after partition
      quickSort(low, pi-1);
      quickSort(pi + 1, high);
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
    QuickSortRecursive qsr = new QuickSortRecursive();
    qsr.arr = new int[]{ 10, 7, 8, 9, 1, 5 };
    int n = qsr.arr.length;

    qsr.quickSort(0, n - 1);
    System.out.println("Sorted array: ");
    printArray(qsr.arr, n);
  }

}
