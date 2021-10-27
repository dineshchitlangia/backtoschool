**Problem Statement**  

Given two binary numbers, compute and display their sum in binary.  

Constraints:
 - Do not use any in-built bitwise operators like &, ^, ~ etc
 - Do not use any in-built library functions that allow you to convert a binary number to integer and vice versa.
 - Perform the sum as a true binary operation

Solution Approach  
As we cannot use any built-in features or bitwise operators, we have to perform the sum like a low level operation.  

So we need to think about implementing Adders.  

What is an Adder?  
An adder is a digital logic circuit in electronics that is extensively used for the addition of numbers.   
In many computers and other types of processors, adders are even used to calculate addresses and related activities and calculate table indices in the ALU and even utilized in other parts of the processors.  
There are two types of Adders:  
- Half Adder (Adds only 2 bits, produces a sum and carry bit)  
- Full Adder (Adds more than 2 bits to produce a final sum and carry bit)  

Half Adder  
Let's say we want to add 1100 (A) and 1010 (B).  
Truth table for this operation is:  

| A | B | C  S | 
|-|-|---|
|0|0|0 0|
|0|1|0 1|
|1|0|0 1|
|1|1|1 0|

where C=Carry, S=Sum
so the total sum is 1110  (carry + sum)

Let's go one step back to see truth table for AND and XOR operations.  

AND produces value true if both inputs are true.  


| p |	q |	p ∧ q | 
|---|---|-------|
| 1	| 1	| 1     |
| 1	| 0	| 0     |  
| 0	| 1	| 0     | 
| 0	| 0	| 0     | 

XOR produces value true only if one of the input is true. 


| p |	q |	p ⊕ q | 
|---|---|-------|
| 1 |	1 |	0     |
| 1 |	0 |	1     |
| 0 |	1 |	1     | 
| 0 |	0 |	0     | 

So looking at truth table for A + B , we can deduce the following formula for SUM & CARRY for a Half Adder.  
SUM = A XOR B  
CARRY = A AND B  

Now, a Full Adder can add 3 bits. So essentially, we could use two half adders to build a full adder.  
A + B + Carry_IN can be broken down as:  
A + B => Carry_1 , Sum_1  
Carry_IN + Sum_1 => Carry_2 , Sum_2  
Carry_2 or Carry_1 => Carry_final  
  
A + B + Carry_IN  => Carry_final, Sum_2  

