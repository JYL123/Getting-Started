class TriesNode {
    HashSet<TriesNode> children;
    String letter = "";
    boolean isEnd = false; 

    public TriesNode (HashSet<TriesNode> children) {
        this.children = children;
    }

    public TriesNode (HashSet<TriesNode> children, String letter, boolean isEnd) {
        this.children = children;
        this.letter = letter;
        this.isEnd = isEnd;
    }
}