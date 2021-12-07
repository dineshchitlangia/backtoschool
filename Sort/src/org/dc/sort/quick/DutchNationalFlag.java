package org.dc.sort.quick;

/**
 * Dutch National Flag problem
 * https://en.wikipedia.org/wiki/Dutch_national_flag_problem
 * 3 different colors represented as 1, 2, 3 in sequential order
 */

public class DutchNationalFlag {
  int arr[]=new int[9];

  public void swap(int x, int y) {
    int temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
  }

  public void makeFlag() {
    int i = 0;
    int j = 0;
    int k = arr.length - 1;
    int mid = 2;

    while(j<=k) {
      if(arr[j] < mid) {
        swap(i, j);
        i++;
        j++;
      } else if(arr[j] > mid) {
        swap(j, k);
        k--;
      } else {
        j++;
      }
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
    DutchNationalFlag sc = new DutchNationalFlag();
    sc.arr = new int[]{ 1,2,3,1,2,3,1,2,3 };
    sc.makeFlag();
    sc.printArray();
  }


}
