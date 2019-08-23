import java.util.LinkedList;

class moderate {
    public static void numberSwapper (int num1, int num2) {
       num1 = num1 ^ num2;
       num2 = num1 ^ num2;
       num1 = num1 ^ num2;

       System.out.println(num1 + " " + num2);
    }

   public static int numberMax (int a, int b) {
        int k = sign(a - b);
        int q = flip(k);

        return a * k + b * q;
   }

   public static int sign (int a) {
        return flip((a >> 31) & 0x1);
   }

   public static int flip(int bit) {
        return 1^bit;
   }

   public static void divingBoard(HashSet<Integer> lengths, int k, int currentLength, int shortLength, int longLength) {
        if (k == 0) {
             lengths.add(currentLength);
             return;
        }

        divingBoard(lengths, k - 1, currentLength + shortLength, shortLength, longLength);
        divingBoard(lengths, k - 1, currentLength + longLength, shortLength, longLength);
   }

   public static int contiguousSequence (int[] input) {
        int max = Integer.MIN_VALUE;
        int current = 0;

        for (int i = 0; i < input.length; i++ ) {
             current += input[i];

             if (current > max) max = current;

             if (current < 0) current = 0;
        }
     
        return max;
   }

   public static int slidingWindow (int[] input, int k) {
        int max = 0;

        Queue<Integer> window = new LinkedList<>();

        if (input.length < k) return -1;
        
        for (int i = 0; i < input.length - k + 1; i++) {
             if (window.size() < k) {
                  window.add(input[i]);
                  max += input[i];
                  continue;
             } else {
                  int current = max;
                  current -= window.poll();
                  current += window.add(input[i]);

                  max  = current > max ? current : max;
             }
        }
        return max;
   }

   public static void findAllSubset1(ArrayList<ArrayList<Integer>> lists, int[] input) {

          for (int i = 0; i < input.length; i++) {
               for (int j = i; j < input.length; j++) {
                    currentList = new ArrayList<ArrayList<Integer>>();
                    currentList.add(input[j]);
               }
          }
   }

   public static boolean isWordExist (String word, String[] input) {
        boolean isExist = false;

        TriesNode root  = buildTree(input);
        isExist = findWord(word, root);

        return isExist;
   }

   public static TriesNode buildTree(String[] input) {
        TriesNode root =  new TriesNode(new HashSet<TriesNode>());

        int maxLengthWord = 0;
        for (int i = 0; i < input.length; i++) {
             if (input[i].length() > maxLengthWord) maxLengthWord = input[i].length();
        }

        for (int i = 0; i < input.length; i++) {
             String current = input[i]; 

             if (current.length() == 0) continue; 
             
             String first = Character.toString(current.charAt(0));
             TriesNode firstNode;

             for (TriesNode node : root.children) {
               if ((node.letter).equals(input[i])) firstNode = node;
             }

             firstNode  = new TriesNode(new HashSet<TriesNode>(), first, false);
             root.children.add(firstNode); 

             for (int j = 1; j <  current.length() - 1; j++) {
                TriesNode child = new TriesNode(new HashSet<TriesNode>(), Character.toString(current.charAt[i]), false);
                firstNode.children.add(child);
                firstNode  = child;
             }

             firstNode.add(new TriesNode(new HashSet<TriesNode>(), Character.toString(current.charAt[current.length() - 1]), true));
        }

        return root;
   }

   public static boolean findWord(String word, TriesNode root) {
        boolean isExist = true;
        TriesNode currentNode = root;

        for (int i = 0; i < word.length(); i++) {
             String current = Character.toString(word.charAt(i));

             for (TriesNode node  : currentNode.children) {
                if(node.letter.equals(current)) isExist = true;
                currentNode = node;
                findWord(word.substring(i+1), node);
             }
             isExist = false;
             return isExist;
        }
        
        return isExist;
   }

   public static void DFS(BTNode node, ArrayList<BTNode> path) {
      path.add(node);
      node.visited = true;
      for (BTNode child : node.adjacent) {
           if (child.visited == false) DFS(child, path);
      }
   }

   public static void BFS(BTNode node, ArrayList<BTNode> path) {
       Queue<BTNode> queue = new LinkedList<>();
       queue.add(node);
       path.add(node);
       

       while(!queue.isEmpty()) {
            BTNode current = queue.dequeue();
            current.visited = true;
            path.add(node);
            for (BTNode child : current.adjacent) {
                 if (child.visited == false) queue.enqueue(child);
            }
       }
   }
    public static void main (String[] args) {
        System.out.println(numberMax(10, 20));
    }
}