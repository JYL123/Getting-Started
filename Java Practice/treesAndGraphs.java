import javafx.util.Pair;
import sun.misc.Queue;

import java.util.ArrayList;
import java.util.LinkedList; 

/** in this class, we assume that we are dealing with BST, thus BTNode for tree nodes. */
class treesSndGraphs {

    /** BFS */
    public static boolean rouetBetweenNodes (BTNode n1, BTNode n2) {
        boolean isConnected = false;

        /** Java use linkedlist as a queue */
        Queue<BTNode> queue = new LinkedList<>();
        queue.enqueue(n1);

        while(!queue.isEmpty()) {
            BTNode current = queue.dequeue();
            current.visited = true;

            if(current == n2) isConnected = true;

            /** persudocode */
            for(BTNode neighbor : node.adjacent) {
                if(!neighbor.visited) {
                    queue.enqueue(neighbor);
                }
            }
        }
        return isConnected;
    }

    /** recursive call */
    public static BTNode minimalTree (int[] vals) {
        BTNode root = new BTNode();

        int rootVal;
        if (vals.length == 1) {
            rootVal = vals[0];
            return root;
        } else {
            rootVal = vals[(int) vals.length/2];
        }
        root.val = rootVal;

        int[] leftvals = new int[(int) vals.length/2];
        int[] rightvals = new int[vals.length - ((int) vals.length/2) - 1];

        for (int i = 0; i < vals.length; i++) {
            if (i < (int) vals.length/2) {
                leftvals[i] = vals[i];
            }

            if (i > (int) vals.length/2) {
                rightvals[i] = vals[i];
            }
            
        }
        root.left = minimalTree(leftvals);
        root.right = minimalTree(rightvals);

        return root;
    } 

    public static ArrayList<LinkedList<BTNode>> listOfDepth (BTNode root) {
        ArrayList<LinkedList<BTNode>> result = new ArrayList<LinkedList<BTNode>>();

        LinkedList<BTNode> currentList = new LinkedList<BTNode>();
        currentList.add(root);
        result.add(currentList);

        Queue queue = new LinkedList();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            currentNode = queue.dequeue();

            currentList = new LinkedList<BTNode>();
            for (BTNode child : currentNode.adjacent) {
                currentList.add(child);
                queue.enqueue(child);
            }
            result.add(currentList);
        }
        return result;
    }

    /** check if a binary tree is balanced or not */
    public static boolean checkBalanced (BTNode root) {
        if (root.left == null && root.right == null) return true;
        
        if (Math.abs(calDepth(root.left) - calDepth(root.right)) > 1) return false;
        else return checkBalanced(root.left) && heckBalanced(root.right);
    }
    
    public static int calDepth(BTNode node) {
        int depth = 0;

        while(node != null) {
            dpeth++;
            node = node.parent;
        }
        return depth;
    }

    /** check if the binary tree is a binary search tree or not */
    public static boolean validateBST (BTNode node) {
        if(node.left == null && node.right == null) return true;

        if (node.right == null) {
            if (node.left.val <= node.val) return true;
            else return false;
        } else {
            if(node.left.val <= node.val && node.val <= node.right.val) {
                return validateBST(node.left) && validateBST(node.right);
            } else return false;
        }
    }

    /** based on in-order traversal */
    public static BTNode successor(BTNode node) {
        BTNode next;

        if (node.visited == false) next = node;

        BTNode leftNode = node.left;
        BTNode rightNode = node.right;
        if (leftNode != null) {
            if (leftNode.visited == false) {
                next = leftNode;
            } else {
                if (rightNode.visited == false) {
                    next = rightNode;
                } else return successor(node.parent);
            }
        } else {
            return successor(node.parent);
        }
        return next;
    } 
    
    public static ArrayList<BTNode> buildOrder (ArrayList<BTNode> projects, ArrayList<Pair<BTNode, BTNode>> dependencies) {
        ArrayList<BTNode> order = new ArrayList<>();

        // first add projects that has no dependencies
        for (Pair<BTNode, BTNode> pair : dependencies) {
            if (!projects.contains(pair.getKey())) {
                order.add(pair.getKey());
            }
        }

        Queue<BTNode> queue = new Queue();
        ArrayList<BTNode> secondProj = new ArrayList<>();
        for (Pair<BTNode, BTNode> pair : dependencies) {
           secondProj.add(pair.getValue());
        }

        // get root
        for (Pair<BTNode, BTNode> pair : dependencies) {
            if(!secondProj.contains(pair.getKey())) {
                queue.enqueue(pair.getKey());
            }
         }

         while(!queue.isEmpty()) {
            BTNode current = queue.dequeue();
            current.visited = true;
            order.add(current);

            for (Pair<BTNode, BTNode> pair : dependencies) {
                if(pair.getKey() == current && !pair.getValue().visisted) {
                    queue.enqueue(pair.getValue());
                } 
             } 
         }

        return order;
    }
    public static BTNode firstCommonAncestor(BTNode node1, BTNode node2){
        BTNode common;

        int dep1 = getDepth(node1);
        int dep2 = getDepth(node2);

        BTNode shallowNode = dep1 - dep2 > 0 ? node2 : node1;
        BTNode deepNode = dep1 - dep2 > 0 ? node1 : node2;

        deepNode = moveUp(deepNode, dep1, dep2);

        while(shallowNode != deepNode && shallowNode != null & deepNode != null) {
            shallowNode = shallowNode.parent;
            deepNode = deepNode.parent;
        }

        if (shallowNode != null || deepNode != null) {
            common = shallowNode;
        } else {
            commaon = null;
        }

        return common;
    }

    /** calculate the depth of a tree == the largetest number of node on a path*/
    public static int getDepth(BTNode node) {
        int depth = 0 ;
        while(node != null) {
            depth ++;
            node = node.parent;
        }
        return depth;
    }

    /** traverse up through a path in a tree by a delta */
    public static BTNode moveUp (BTNode node, int dep1, int dep2) {
        int delta = Math.abs(dep1 - dep2);

        while (delta != 0 && node != null) {
            node = node.parent;
            delta --;
        }

        return node;
    }

    /** check the answer, 2 recursive calls are ivolved. */
    public static void BTSSequence(BTNode root, ArrayList<BTNode> lists) {

        if (root.left == null && root.right == null) {
            lists.add(root);
        } else if (root.left != null && root.right == null) {
            lists.add(root);
            BTSSequence(root.left, lists);
        } else {
            lists.add(root);
            BTSSequence(root.left, lists);
            BTSSequence(root.right, lists);
        }

        
    }
    public static void main(String[] args) {

    }
}