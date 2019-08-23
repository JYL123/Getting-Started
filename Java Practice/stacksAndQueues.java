public class stacksAndQueues {

    public static boolean routeBetweenNodes(Node source, Node dest) {
        boolean isConnected = false;

        while(source != null) {
            if(dest == source) isConnected = true;
            else source = source.next;
        }

        return isConnected;
    }

    /** Balanced binary is so intertesting. check out: https://www.geeksforgeeks.org/sorted-array-to-balanced-bst/ 
     * also check out how to construct a BST from a sorted linked list: https://www.geeksforgeeks.org/sorted-linked-list-to-balanced-bst/
    */
    public static BTNode minimalTree (int[] sortedArray) {
        int middle = (int) sortedArray.length/2;
        int middleValue = sortedArray[middle-1];
        BTNode root = new BTNode(null, null, middleValue);
        
        int[] leftArray = new int[middle];
        for(int i = 0; i < middle; i++) {
            leftArray[i] = sortedArray[i];
        }
        root.setLeft(minimalTree(leftArray));

        int[] rightArray = new int[middle];
        for(int i = middle-1; i < sortedArray.length - 1; i++) {
            rightArray[i- (middle-1)] = sortedArray[i];
        }
        root.setRight(minimalTree(rightArray));
        
        return bbt;
    }

    public static ArrayList<Node> listOfDepths(BTNode root) {
        ArrayList<Node> nodes = new ArrayList<Node>();

        nodes.add(root);

        
    }

    public static void main (String[] args) {

    }
}