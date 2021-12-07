package org.dc.sort.quick;

/**
 * Given an array of 2 colors, sort them.
 *
 */
public class Sort2Colors {
  int arr[]=new int[10];

  public void swap(int x, int y) {
    int temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
  }

  public void sort() {
    int left = 0;
    int right = arr.length - 1;

    while(left <= right && right < arr.length) {
      while(arr[left]==0) { //stop when encounter 1 on the left
        left++;
      }
      while(arr[right]==1) { //stop when encounter 0 on the right
        right--;
      }
      swap(left, right);
    }
    swap(left,right);
  }

  // Function to print an array
  public void printArray()
  {
    for(int i = 0; i < arr.length; i++)
      System.out.print(this.arr[i] + " ");

    System.out.println();
  }

  public static void main(String[] args) {
    Sort2Colors sc = new Sort2Colors();
    sc.arr = new int[]{ 1,0,0,1,0,1,1,1,0,1 };
    sc.sort();
    sc.printArray();
  }

}
