import java.util.Stack;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
// Binary Tree Inorder Traversal


class test1 {

    public static void inOrderTraversal (TreeNode root, ArrayList<TreeNode> path) {
        
        if (root.left != null) inOrderTraversal(root.left, path);
        path.add(root);
        if (root.right != null) inOrderTraversal(root.right, path);
    }


//        A
//     /    \
//    B      C
//   /  \   /
//  D    E  H 
// / \  
// F   G 
//   / \
//  V   Y
//      /\
//     J  K
// stack:  A, B,
// path:  F, D, V, G, J, K
//


    public static void inOrderTraversal2 (TreeNode root, ArrayList<TreeNode> path) {
        
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>(); 
        while(current != null) {
            stack.add(current);
            current = current.left;
        }

        while(!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            path.add(cuurentNode);
            
            if (cuurentNode.right != null) {

                stack.add(currentNode.right);
                TreeNode child = currentNode.right;
                while (child != null) {
                    stack.add(child);
                    child = child.left;
                }
            }
        }
    }

    public static void inOrderTraversal3 (TreeNode root, ArrayList<TreeNode> path) {
        
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while(current != null) {
            stack.push(current);
            current = current.left;
        }

        while(!stack.isEmpty()) {
            current = stack.pop();
            path.add(current);

            if(current.right != null) {
                stack.push(current.right);
                TreeNode subNode = current.right;
                if(subNode.left != null) {
                    stack.push(subNode.left);
                    subNode.left = subNode.left.left;
                }
            }
        }
    
    }


// Input : {[]{()}}        
// Output : Balanced

// Input : [{}{}(]
// Output : Unbalanced

//} [ ] {
// Stack: {  

public static String checkIfBalanced(char[] input) {

    HashMap<Character, Character> dic = new HashMap<Character, Character>();
    dic.add('{', '}');
    dic.add('}', '{');
    dic.add('[', ']');

    Stack<Character> list =  new Stack<>();
    for(int i = 0; i < input.length; i++) {
        char current = input[i];

        if (!dic.contains(current)) return "Unbalanced";
        
        if (list.isEmpty() || list.peek() != current) {
            list.add(dic.get(current));
        } 
        
        if (list.peek() == current) list.pop();
    }

    if(!list.isEmpty()) return "Unbalanced";
    else return "Balanced";
}

// .enqueu
// .dequeue

 class Queue{
     Stack<Integer> s1; 
     Stack<Integer> s2; 

     public Queue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
     } 

     public void enqueue(int i) {
        s1.add(i);
     }

     public int dequeue() {
         while(!s1.isEmpty()) {
             s2.push(s1.pop());
         }

         int tmp = s2.pop();

        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        s2 = new Stack<>();
        return tmp;
     }

     public int peek() {

        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        int tmp = s2.peek();

       while(!s2.isEmpty()) {
           s1.push(s2.pop());
       }

       return tmp;
     }
 }

    public static void main (String[] args) {

    }
}




