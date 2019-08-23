class BTNode {
    BTNode left;
    BTNode right;
    BTNode parent;
    int val;
    boolean visited = false;

    public BTNode (BTNode left, BTNode right, int val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }

    public setLeft(BTNode left) {
        this.left = left;
    }

    public setRight(BTNode right) {
        this.left = right;
    }
}