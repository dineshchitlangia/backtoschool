package org.dc.sort.merge;

import java.util.Arrays;

public class MergeSort {

  int[] arr = new int[10];
  int[] result = new int[10];

  public void mergeSort(int low, int high) {
    if(low < high) {
      int mid = (low + high) / 2;
      mergeSort(low, mid);
      mergeSort(mid+1, high);
      merge(low, mid, high);
    }
  }

  public void merge(int low, int mid, int high) {
    int i=low, j=mid+1, k=0;
    // i tracks low to mid
    // j track mid+1 to high
    while(i<=mid && j<=high  && k<10) {
      if(arr[i] <= arr[j]) {
        result[k++] = arr[i++];
      } else {
        result[k++] = arr[j++];
      }
    }
    while(i<=mid && k<10){
      result[k++] = arr[i++];
    }
    while(j<=high  && k<10){
      result[k++] = arr[j++];
    }

    // replace the original array with sorted subset
    for(i = low; i <= high; i += 1) {
      arr[i] = result[i - low];
    }
  }

  public static void main(String[] args) {
    MergeSort ms = new MergeSort();
    ms.arr = new int[]{10,2,5,9,1,50,17,11,8,33};
    ms.mergeSort(0, ms.arr.length-1);

    System.out.println(Arrays.toString(ms.result));

  }
}
