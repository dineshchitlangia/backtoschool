package org.dc.adder;

public class HalfAdder {

  public static Digit and(Digit x, Digit y) {
    if (x==Digit.ONE && x==y){
      return Digit.ONE;
    }
    return Digit.ZERO;
  }

  public static Digit xor(Digit x, Digit y){
    if (x==y){
      return Digit.ZERO;
    }
    return Digit.ONE;
  }

  public static Digit or(Digit x, Digit y) {
    if(x==y && x==Digit.ZERO) {
      return Digit.ZERO;
    }
    return Digit.ONE;
  }

  public static Digit sum(Digit x, Digit y) {
    return xor(x,y);
  }

  public static Digit carry(Digit x, Digit y) {
    return and(x,y);
  }

  public static BitPair add(Digit x, Digit y) {
    return new BitPair(HalfAdder.sum(x,y), HalfAdder.carry(x,y));
  }

}

