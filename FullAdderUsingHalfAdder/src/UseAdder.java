import org.dc.adder.BitPair;
import org.dc.adder.Digit;
import org.dc.adder.FullAdder;
import org.dc.adder.HalfAdder;

import java.util.Stack;

public class UseAdder {
  public static void main(String[] args){
    validateInput(args);
    add(args);
  }

  public static void validateInput(String[] args){
    if(args.length != 2) {
      System.out.println("Please enter 2 binary numbers to use Full Adder");
      System.exit(-1);
    }

    for(String input: args){
      for(char c : input.toCharArray()){
        if(Digit.getDigit(c)==null){
          System.out.println("Invalid character " + c + " in " + input);
          System.exit(-1);
        }
      }
    }
  }

  public static void add(String args[]){
    Digit carry = Digit.ZERO;
    Digit a = null;
    Digit b = null;
    BitPair temp = null;
    int index = 0;
    int len_a = args[0].length();
    int len_b = args[1].length();
    int max = (len_a > len_b) ? len_a : len_b;
    Stack<Character> sum = new Stack<>();
    while(max>=0) {
      if(len_a>0) {
        a = Digit.getDigit(args[0].charAt(--len_a));
      } else {
        a = null;
      }
      if(len_b >0){
        b = Digit.getDigit(args[1].charAt(--len_b));
      } else {
        b = null;
      }
      if(a==null){
        temp = HalfAdder.add(carry,b);
      } else if(b==null){
        temp = HalfAdder.add(carry,a);
      } else {
        temp = FullAdder.add(carry,a,b);
      }
      carry = temp.getCarry();
      sum.push(temp.getSum().getValue());
      max -- ;
    }
    sum.push(carry.getValue());
    while(!sum.isEmpty()) {
      System.out.print(sum.pop());
    }
  }
}
