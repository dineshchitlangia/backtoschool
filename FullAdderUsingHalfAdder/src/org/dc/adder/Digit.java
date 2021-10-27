package org.dc.adder;

public enum Digit {
  ZERO('0'),
  ONE('1');

  public char getValue() {
    return value;
  }

  char value;

  Digit(char c) {
    value = c;
  }

  public static Digit getDigit(char c) {
    switch (c) {
      case '0':
        return Digit.ZERO;
      case '1':
        return Digit.ONE;
      default:
        return null;
    }
  }

  @Override
  public String toString() {
    return String.valueOf(this.getValue());
  }
}
