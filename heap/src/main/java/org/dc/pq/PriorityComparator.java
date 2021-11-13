package org.dc.pq;

import java.util.Comparator;


public class PriorityComparator implements Comparator<Element> {
  @Override
  public int compare(Element p1, Element p2) {
    return Integer.valueOf(p1.priority).compareTo(p2.priority);
  }
}
