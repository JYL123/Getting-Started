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
        return (top < 0) ? true : false;
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

PriorityQueue<T> pQueue = new PriorityQueue<T>(); 
```

## Tree
* Binary tree
* Binary search tree
* Complete binary tree
* Full binary tree
* Perfect binary tree
* Binary heaps (min & max heaps)
* Tries/Prefix tree

### Implementation (Tree/Tries)
```java
class Node<T>
{
    List<Node<T>> children = new ArrayList<Node<T>>();
    Node<T> parent;
    T data;

    public Node(T data)
    {
        this.data = data;
    }

    public Node(T data, Node<T> parent)
    {
        this.data = data;
        this.parent = parent;
    }

    public List<Node<T>> getChildren()
    {
        return children;
    }

    public void setParent(Node<T> parent)
    {
        this.parent = parent;
        parent.addChild(this);
    }

    public void addChild(Node<T> child)
    {
        this.children.add(child);
        child.setParent(this);
    }

    public void addChild(T data)
    {
        Node<T> newNode = new Node<T>(data);
        this.children.add(newNode);
        newNode.setParent(this);
    }

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    public boolean isRoot()
    {
        return (this.parent==null);
    }

    public boolean isLeaf()
    {
        return (this.children.size==0);
    }

    public void removeParent()
    {
        this.parent = null;
    }
} 
```

### Binary Tree Traveral

* In-order traversal
```java
void inorderTraversal(TreeNode node)
{
    if (node != null)
    {
        inorderTraversal(node.left);
        print(node);
        inorderTraversal(node.right);
    }
}
```

* Pre-order traversal
```java
void preorderTraversal(TreeNode node)
{
    if(node != null)
    {
        print(node);
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }
}
```

* Post-order traversal
```java
void postorderTraversal(TreeNode node)
{
    if(node != null)
    {
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        print(node);
    }
}
```

## Graphs

### Implementation
* Adjacency list
``` java
class Node 
{
    String data;
    Node[] children;
}

class Graph
{
    Node[] nodes;
}
```

* Adjacency matrix
```java
ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();


int[][] matrix = new int[rows][cols];
```

### Graph Search
* DFS
```java
void DFS (int v)
{
    boolean[] visited = new boolean[V];
    DFSUtil(v, visited);
}

void DFSUtil(int source, boolean[] visited)
{
    visited[source] = true;
    System.out.print(source + " ");

    Iterator<Integer> i = adj[source].listIterator();
    while(i.hasNext())
    {
        int next = i.next();
        if(!visited[next])
        {
            DFSUtil(next, visited);
        }
    }

}

```

* BFS
```java
void BFS (int source)
{
    boolean[] visited = new boolean[V];
    Queue<Integer> queue = new LinkedList<Integer>();

    visited[source] = true;
    queue.add(source);

    while(queue.size() != 0)
    {
        source = queue.poll();
        System.out.print(source + " ");

        Iterator<Integer> i = adj[source].listIterator();
        while(i.hasNext())
        {
            int next = i.next();
            if(!visited[next])
            {
                visited[next] = true;
                queue.add(next);
            }
        }
    }
}

```