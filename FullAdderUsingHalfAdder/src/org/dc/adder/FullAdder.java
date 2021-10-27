package org.dc.adder;

public class FullAdder {

  private FullAdder() {}

  public static BitPair add(Digit carry, Digit a, Digit b) {
    BitPair first = HalfAdder.add(a,b);
    BitPair second = HalfAdder.add(carry, first.getSum());
    Digit finalCarry = HalfAdder.or(second.getCarry(), first.getCarry());
    return new BitPair(second.getSum(), finalCarry);
  }

}
