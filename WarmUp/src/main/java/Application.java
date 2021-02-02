import java.util.*;

public class Application {
    public static void main(String[] args) {
//        int[] left = new int[]{1,1,1,1,1,1,1,1,1,1};
//        int[] right = new int[]{1,0,0,0,0,0,0,0,0,0};
//        int[] sum = addBigNum(left,right);


        //given two arrays of size 100
        //each element has a value between 0 - 9
        //return 101 element sum of both numbers
        //
//    public static int[] addBigNum(int[] left, int[] right){
//        int[] sum = new int[101];
//        int element = 0;
//        for(int i = 0; i < left.length; i++){
//            element = left[i] + right[i] + sum[i];
//            if(element >= 10){
//                sum[i+1]++;
//                element = element - 10;
//            }
//            sum[i] = element;
//        }
//        return sum;
//    }
       // System.out.println("Max sequence from 0 to 1,000,000 is: " + maxSequence());

       // System.out.println(digitReversal(123456));
//        System.out.println(isPerfectNumber(496)); //true
//        System.out.println(isPerfectNumber(28)); //true
//        System.out.println(isPerfectNumber(6));  //true
//        System.out.println(isPerfectNumber(12)); //false


//        char[][] board;
//        board = new char[][]{{'5','3','5','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
//        //this one outputs true
//        System.out.println(isValidSudoku(board));
//        char[][] secondBoard = new char[][]{{'8','3','.','.','7','.','.','.','.'}
//                ,{'6','.','.','1','9','5','.','.','.'}
//                ,{'.','9','8','.','.','.','.','6','.'}
//                ,{'8','.','.','.','6','.','.','.','3'}
//                ,{'4','.','.','8','.','3','.','.','1'}
//                ,{'7','.','.','.','2','.','.','.','6'}
//                ,{'.','6','.','.','.','.','2','8','.'}
//                ,{'.','.','.','4','1','9','.','.','5'}
//                ,{'.','.','.','.','8','.','.','7','9'}};
//        System.out.println(isValidSudoku(secondBoard));

        int[] nums = {2,5};
        System.out.println(search(nums,5));

    }

    public static int search(int[] nums, int target) {
        int top = nums.length -1 ;
        int bottom = 0;
        int index = top / 2;
        boolean done = false;
        if(top == 0 && target != nums[index]){
            return -1;
        }
        while(!done){
            if(target == nums[index]){
                done = true;
            }
            else if(bottom == top ){
                index = -1;
                done = true;
            }
            else if(nums[index] < target){
                bottom = index;
                index = ((top - bottom) / 2) + bottom;
            }
            else if(nums[index] > target){
                top = index;
                index = ((top - bottom) / 2) + bottom;
            }
        }
        return index;
    }



//    public int rangeSumBST(TreeNode root, int low, int high) {
//        int sum = 0;
//        if(root.val >= low && root.val <= high){
//            sum = root.val;
//        }
//        if(root.left != null){
//            sum += rangeSumBST(root.left, low, high);
//        }
//        if(root.right != null){
//            sum += rangeSumBST(root.right, low, high);
//        }
//        return sum;
//    }



//
//    public static boolean isValidSudoku(char[][] board) {
//        boolean validSo = true;
//            if(isRowsValid(board)){
//                validSo =  false;
//            }
//            if(isColsValid(board)){
//                validSo =  false;
//            }
//            if(isSquaresValid(board)) {
//                validSo =  false;
//            }
//        return validSo;
//    }
//
//    private static boolean isSquaresValid(char[][] board) {
//        int rStart = 0;
//        int cStart = 0;
//        int rStop = 3;
//        int cStop = 3;
//        for(int i = 0; i < board.length; i++) {
//            for (int row = rStart; row < rStop; row++) {
//                for (int col = cStart; col < cStop; col++) {
//                    if (board[row][col] != '.') {
//                        char selected = board[row][col];
//                        for (int r = rStart; row < rStop; row++) {
//                            for (int c = cStart; col < cStop; col++) {
//                                if (!(r != row && c != col)) {
//                                    if(board[r][c] == selected){
//                                        return false;
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//                if(cStop < board.length){
//                    cStart+= 3;
//                    cStop+=3;
//                }
//                else{
//                    cStart = 0;
//                    cStop = 0;
//                    rStart+=3;
//                    rStop+=3;
//                }
//            }
//        }
//        return true;
//    }
//
//    private static boolean isColsValid(char[][] board) {
//        for(int column = 0; column < board.length; column++){
//            //traverse through each colummn
//            for(int row = 0; row < board.length; row++){
//                //grabs each value and check the entire row with it
//                if(board[row][column] != ('.')){
//                    for(int ros = 0; ros < board.length && row != row; ros++){
//                        if(board[row][column] == board[ros][column] && row != ros){
//                            return false;
//                        }
//                    }
//                }
//
//            }
//
//        }
//        return true;
//    }
//
//    private static boolean isRowsValid(char[][] board) {
//        for(int i = 0; i < board.length; i++){
//            //traverse through each row
//            for(int j = 0; j < board.length; j++){
//                //grabs each value and check the entire row with it
//                if(board[i][j] != ('.')){
//                    for(int cols = 0; cols < board.length && j != j; cols++){
//                        if(board[i][j] == board[i][cols] && cols != j){
//                            return false;
//                        }
//                    }
//                }
//            }
//        }
//        return true;
//    }


//    private static boolean isPerfectNumber(int i) {
//        int sum = 0;
//        for(int x = 1; x < i; x++){
//            if((i%x) == 0){
//                sum = sum + x;
//            }
//        }
//        if(sum == i){
//            return true;
//        }
//        return false;
//    }

//    private static boolean isPerfectNumberVTwo(int i) {
//        int sum = 0;
//        sum = Math.pow(2,) * (Math.pow(2,) -1 );
//        if(sum == i){
//            return true;
//        }
//        return false;
//    }

//    public int lengthOfLongestSubstring(String s) {
//        int count = 0;
//        int start = 0;
//        for(int i = 1; i < s.length(); i++){
//            //check each character to each character in substring
//            for(int x = 0; x <= i; x++){
//                if(s.indexOf(s.charAt(x+1) + "") == -1){
//                    s
//                }
//            }
//        }
//        return count;
//    }
//
//    public static int digitReversal(int toFlip){
//        ArrayList<Integer> arr = new ArrayList<Integer>();
//        int count;
//        int newSum = 0;
//        for(int i = toFlip; i > 0; i = i/10){
//            arr.add(i%10);
//        }
//        count = arr.size() -1;
//        for(int i = 0; i < arr.size(); i++){
//            newSum = newSum + (arr.get(i) * (int)Math.pow(10.0,count));
//            count--;
//        }
//        return newSum;
//    }
//
//
//    public static Long maxSequence(){
//        int maxSequenceLen = 0;
//        Long maxNumber = 0L;
//        int tempLen;
//        for(Long i = 1L; i < 1000000; i++){
//            tempLen = evaluate(i);
//            if(tempLen > maxSequenceLen){
//                maxSequenceLen = tempLen;
//                maxNumber = i;
//            }
//            System.out.println(i);
//        }
//        return maxNumber;
//    }
//
//    public static int evaluate(Long num){
//        boolean done = false;
//        int count = 0;
//        while(!done){
//            if(num == 1) done = true;
//            else if (num%2 == 0){
//                num = num /2;
//                count++;
//            }
//            else {
//                num = (3 * num) +1;
//                count++;
//            }
//        }
//        return count;
//    }

}

