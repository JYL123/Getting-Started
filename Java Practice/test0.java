// [
//     "n", "o", "t", "h", "i", "n", "g", " ", "i", "s", " ", "i", "m", "p", "o", "s", "s", "i", "b", "l", "e"
// ]
                                                    

// [
//     "i", "m", "p", "o", "s", "s", "i", "b", "l", "e", " ", "i", "s", " ", "n", "o", "t", "h", "i", "n", "g"
// ]

import java.util.ArrayList;

class test0 {

    public static char[] reverseWords(char[] words) {
        String[] wordsList = (new String(words)).split(" ");

        int index = 0;
        for (int j = list.size() - 1; j >= 0; j--) {   
            for (int i = 0; i < list.get(j).length(); i++) {
                words[index] = list.get(j).charAt(i);
                index++;
            }
            if (j != 0) {
                words[index] = ' ';
                index++;
            }
        }

        return words;
    }

    public static char[] reverseWords2(char[] input) {
        // reverse the whole input array 
        int index1 = 0;
        int index2 = input.length - 1;
        
        while (index2 > index1) {
            swap (index1, index2, input);
            index1++;
            index2--;
        }

        int index3 = 0;
        for (int i = 0; i < input.length; i++) {
            if(input[i] == ' ') {
                index3 = i;
                
                int x = 0; 
                int y = index3 - 1;

                while(x < y) {
                    swap(x, y, input);
                    x++;
                    y--;
                }
            }
        }
        return input;
    }

    public static void swap (int index1, int index2, char[] input) {
        char first = input[index1];
        char second = input[index2];
        char tmp;

        tmp = first;
        first = second;
        second = tmp;
    }

    public static void main(String[] args) {
        char[] words = {'n', 'o', 't', 'h', 'i', 'n', 'g', ' ', 'i', 's', ' ', 'i', 'm', 'p', 'o', 's', 's', 'i', 'b', 'l', 'e'};
        System.out.println(reverseWords(words));
    }
}
