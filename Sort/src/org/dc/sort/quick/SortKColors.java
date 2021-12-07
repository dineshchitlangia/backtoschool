package org.dc.sort.quick;

/**
 * Sort K colors
 */
public class SortKColors {
  int arr[]=new int[10];

  public void swap(int x, int y) {
    int temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
  }

  public void sortKColors(int k) {
    int i = 0;
    int n = arr.length - 1;
    int j = 0;
    int min = 1, max = k;
    while (min < max) {
      while (j <= n) {
        if (arr[j] == min) {
          swap(i, j);
          j++;
          i++;
        } else if (arr[j] == max) {
          swap(n, j);
          n--;
        } else {
          j++;
        }
      }
      j = i;
      min++;
      max--;

    }
  }


  // Function to print an array
  public void printArray()
  {
    for(int i = 0; i < arr.length; i++)
      System.out.print(this.arr[i] + " ");

    System.out.println();
  }

  public static void main(String[] args) {
    SortKColors sc = new SortKColors();
    sc.arr = new int[]{ 5,2,3,4,2,3,1,4,3 };
    sc.sortKColors(5);
    sc.printArray();
  }


}
