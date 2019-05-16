## Hash Table / Hash Map
* [Difference between Hash Table and Hash Map](https://stackoverflow.com/a/40878)

### Implementation
[Details](https://www.geeksforgeeks.org/implementing-our-own-hash-table-with-separate-chaining-in-java/)

### Questions (on using hash map)
[Question 1](http://blog.gainlo.co/index.php/2016/08/14/uber-interview-question-map-implementation/)


## Linked Lists
* Singly linked list
* Doubly linked list

### Implementation
```java
class Node 
{
    Node next = null;
    int data;

    public Node (int d) 
    {
        data = d;
    }
}

class LinkedList 
{
    Node head;

    public LinkedList insert (int d, LinkedList ls) 
    {
        Node newNode = new Node (d);

        if (ls.head = null)
        {
            newNode = ls.head;
        } else {
            Node last = ls.head;
            while (last.next != null)
            {
                last = last.next;
            }

            newNode = last.next;
        }

        return ls;
    }

    public LinkedList delete (int d, LinkedList ls) 
    {
        Node remove = ls.head;

        if (remove.data == d) return null;

        while(remove.next.data != d)
        {
            remove = remove.next;
        }

        remove.next = remove.next.next;

        return ls;
    }
}
```

## Stack 

### Implementation
```java
class Stack 
{
    int top = -1; 
    int max;
    int a[];

    public Stack (int max)
    {
        this.max = max;
        a[] = new int[max];
    } 

    boolean isEmpty()
    {
        return (top < 0) true : false;
    }

    boolean push (int num)
    {
        if (top < max)
        {
            a[++top] = num; 
            return true;
        } else return false;
    }

    int pop()
    {
        if(top >= 0) return a[top--];
        else throw new EmptyStackException();
    }

    int peek()
    {
        if (top >=0 ) return a[top];
        else throw new EmptyStackException();
    }
}
```

## Queue 

### Implementation
```java
Queue<T> queue = new LinkedList<T>();
```