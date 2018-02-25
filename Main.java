import java.util.*;

public class Main {
	
	public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        //System.out.println("Enter the size of the matrix: ");

        int size =scan.nextInt();
        int[][] matrix = new int[size][size];

        //System.out.println(size);
        //System.out.println("Enter your lines: ");

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                matrix[i][j] = scan.nextInt();;
            }
        }

        scan.close();

        System.out.println(calculation(matrix, size));

    }

    private static int calculation(int[][] matrix, int size) {
        int max = 0;
        int area = 0;
        for (int i = 1 ; i < size; i++) {

            for (int j = 0; j < size; j++) {
                if (matrix[i][j] != 0) {
                    matrix[i][j] = matrix[i - 1][j] + matrix[i][j];
                }
            }
        }


        for (int i = 0 ; i < size; i++) {
            area = maxAreaInHistogram(matrix[i]);
            max = area > max ? area : max;
         }


        return max;
    }

    private static int maxAreaInHistogram(int[] row) {
	    int index = 0;
	    int area = 0;
	    Stack<Integer> stack = new Stack<>();

	    while (index < row.length) {
	        if(stack.isEmpty() || row[index] >= row[stack.peek()]) {
	            stack.push(index++);
            	} else {
	            int top = stack.pop();
	            area = Math.max(area, row[top] * (stack.isEmpty()? index : (index - stack.peek() -1)));
            	}
           }
	    
	   while (!stack.isEmpty()) {
		   int top = stack.pop();
	           area = Math.max(area, row[top] * (stack.isEmpty()? index : (index - stack.peek() -1)));
	   }
	    
	    return area;
    }
}
