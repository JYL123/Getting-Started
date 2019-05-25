## Bit Manipulation
### Notation
* `~`: NOT
* `&`: AND
* `|`: OR
* `^`: XOR
* `<<`: LEFT SHIFT (* power(2, k))
* `>>`: RIGHT SHIFT (/power(2, k))

`^` | `&` | `|`
--- | --- | --- |  
x ^ 0s = x | x & 0s = 0 | x | 0s = x | 
x ^ 1s = ~x| x & 1s = x | x | 1s = 1s | 
x ^ x = 0| x & x = x | x | x = x | 

### Two's complement
* Positive number: power(2, k)
* Negative number: concat(1, power(2, n) - power(2, k))

Another way to generate a negative number is to flip the bits of its absolute value and add a `1` in front as the sign bit.

### Logical and Arithematic shift
* `>>`: Logical right shift, add `0` to the most significant bit (at left)
* `>>>`: Arithematic right shift, add `1` to the most significant bit (at left)

### Common bit tasks
* Get bit at position i:
```java
//true: bit at position i is 0
//false: bit at position 1 is not 0
boolean getBit(int num, int i)
{
    return (num & (1 << i) != 0)
}
```

* Clear bit
```java
// set the ith bit to 0
int clearBit(int num, int i)
{
    int mask = ~(1 << i);
    return (num & mask);
}
``` 

* Update bit 
```java

int updateBit(int num, int i, boolean bitIs1)
{
    int value = bitIs1 ? 1 : 0;
    int mask = ~(1 << i);

    return (num & mask) | (value << i);
}
```

## Dynamic Programming 

### Approaches 
* Bottom-Up Approach 
Start with knowing how to solve the problem for a simple case, like a list with only one element, then move on with lists with two elements, etc. `Think about how you can build the solution for one case off of the previous case.`

* Top-Down Approach
`Think about how to divide the problem for case N into subproblems.`

* Half-and-Half Approach
`Divide the data set in half.` For example, binary search, merge sort.


