package org.dc.adder;

public class BitPair {
  final Digit sum;
  final Digit carry;

  public Digit getSum() {
    return this.sum;
  }

  public Digit getCarry() {
    return this.carry;
  }

  public BitPair(Digit s, Digit c) {
    sum = s;
    carry = c;
  }

}
