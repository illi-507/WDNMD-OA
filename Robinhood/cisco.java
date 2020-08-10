import java.util.*;
public class solution {
	
	public static int[] swap (int []array,int index1, int index2) {
		int temp = array[index1];
		array[index1]=array[index2];
		array[index2] = temp;
		
		return array;
	}
    /**
     * 10 80 30 90 40 50 70 
     *  i   
     *  j
     **/
	public static int partition(int []array, int low, int high) {
    	int i = low -1;
    	int pivot = array[high];
    	
    	for(int j = low; j<high; j++) {
    		if(array[j]<pivot) {
    			i++;    			
    			array=swap(array,i,j);
    		}  
    	}
    	
    	array = swap(array,i+1,high);
    	return i+1;
    	
    }
	
	public static void sort(int []array, int low, int high) {
		if(low<high) {
		  int split = partition(array,low,high);
		  sort(array,low,split-1);  
		  sort(array,split+1,high);		 
		}
		
		
	}
	/**
	 * LC 1282 
	 * */
	  public static List<List<Integer>> groupThePeople(int[] groupSizes) {
	      Map<Integer,List<Integer>> map1 = new HashMap();
	      List<List<Integer>> result = new ArrayList();	      
	      
	      for(int i = 0;i <groupSizes.length; i++) {	    	  
	    	  List<Integer> temp = new ArrayList();
	    	  int current = groupSizes[i];
	    	 
	    	  if(map1.containsKey(current)) {
	    		  map1.get(current).add(i);
	    		  	    		
	    	  }
	    	  else {
	    		  temp.add(i);
	    		  map1.put(current,temp);
	    	  }
	    	  
	    	 if(current == map1.get(current).size()) {
		    		  result.add(map1.get(current));
	            	  map1.remove(current);  
		    }
	      }
		  
	      return result;
	  }
	
	  /**
	   * LC 807 
	   * */
	  public static int maxIncreaseKeepingSkyline(int[][] grid) {
	        int n = grid.length;
	        int[] col = new int[n], row = new int[n];
	        System.out.println(col[0]+" "+col[1]);
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                row[i] = Math.max(row[i], grid[i][j]);
	                col[j] = Math.max(col[j], grid[i][j]);
	            }
	        }
	        
	        int res = 0;
	        for (int i = 0; i < n; i++)
	            for (int j = 0; j < n; j++)
	                res += Math.min(row[i], col[j]) - grid[i][j];
	        
	        System.out.println("LC 807: "+res);
	        return res;
	    }
	/**
	 * LC 301
	 * */
	  static char [][] patterns =  {{'(',')'},{')','('}};
	  
      public static void dfs(char[]pattern, String s, int start, int lastRemove, List<String>ans) {
		  int cnt = 0, n = s.length();
    	  for(int i = start;i <n;i++){
			  if(s.charAt(i) == pattern[0]) {cnt ++;}
			  if(s.charAt(i) == pattern[1]) {cnt --;}
			  if(cnt >= 0) continue;
			  
			  else {
				  System.out.println("Cut------------");
			    for(int j = lastRemove;j <= i; j++) {
				    char c = s.charAt(j);
				    if(c == pattern[1] &&(j == lastRemove || c!=s.charAt(j-1))) {
				    	String temp = s.substring(0,j)+s.substring(j+1);
				    	System.out.println(temp+" "+i+" "+j);
				    	dfs(pattern, s.substring(0,j)+s.substring(j+1),i,j,ans);
				    }
			    }
			    return;
			  }			  
		  }    	
    	 s= new StringBuilder(s).reverse().toString();
    	 System.out.println(pattern+" + "+patterns[0]);
    	 if(pattern == patterns[0]) {
    		 dfs(patterns[1],s,0,0,ans);
    		 System.out.println("into");
    	 }
    	 else {
    		 ans.add(s);
    	 }
    	  
	  }
      
	  public static List<String> removeInvalidParentheses(String s){
		 List<String> ans = new ArrayList<>();
		 dfs(patterns[0],s,0,0,ans);
		  return ans;
	  }
	  
	  /**
	   * LC 680
	   * */
	  
	  public static boolean validPalindrome(String s) {
		  char []array = s.toCharArray();
		  for(int i =0, j = array.length-1; i<j; i++, j--) {
			  if(array[i] != array[j]) {
				  return helper(array, i+1, j) || helper(array, i,  j-1);
			  }
		  }		  
		  return true;		  
	  
	  }
	  
	  public static boolean helper(char []array, int i , int j) {
		  
		  while(i<j) {
		    if(array[i]!=array[j]) {
		    	return false;
		    }
		    i++;
		    j--;
		  }
		  
		  return true;
	  }
	  
	 /**
	  * Leetcode 418
	  * rows = 3, cols = 6, sentence = ["a", "bcd", "e"]
	  * */ 
	  
	  public static int wordsTyping(String[] sentence, int rows, int cols) {
	        String sen = String.join(" ", sentence) + " ";
	        int len = sen.length();
	        int total = 0;
	        
	        for (int i = 0; i < rows; i++) {
	            total += cols;
	            if (sen.charAt(total % len) == ' ') {
	                total++;
	            } else {
	                while (total > 0 && sen.charAt((total - 1) % len) != ' ') {
	                    total--;
	                }
	            }
	        }
	        return total / len;
	    }
	 
	  public List < Integer > spiralOrder(int[][] matrix) {
	        List ans = new ArrayList();
	        if (matrix.length == 0)
	            return ans;
	        int r1 = 0, r2 = matrix.length - 1;
	        int c1 = 0, c2 = matrix[0].length - 1;
	        while (r1 <= r2 && c1 <= c2) {
	            for (int c = c1; c <= c2; c++) ans.add(matrix[r1][c]);
	            for (int r = r1 + 1; r <= r2; r++) ans.add(matrix[r][c2]);
	            if (r1 < r2 && c1 < c2) {
	                for (int c = c2 - 1; c > c1; c--) ans.add(matrix[r2][c]);
	                for (int r = r2; r > r1; r--) ans.add(matrix[r][c1]);
	            }
	            r1++;
	            r2--;
	            c1++;
	            c2--;
	        }
	        return ans;
	    }
	  /**
	   * LC 54
	   * 
	   * */
	  public static List < Integer > mySpiral(int[][] matrix) {
		  List<Integer> result = new ArrayList<>();
		  int width = matrix[0].length;
		  int height = matrix.length;
		  
		  int w1 = 0, h1 = 0;
		  int w2 = width -1, h2 = height-1;
		  
		  while(w1<=w2 && h1<=h2) {
			  System.out.println(w1+" "+h1+" "+" "+w2+" "+h2);
			  /*ÉÏ*/
			  for(int i = w1; i <=w2;i++) {
				  result.add(matrix[h1][i]); 
			  }
			  /*ÓÒ*/
			  for(int i = h1+1; i <h2;i++) {
				  result.add(matrix[i][w2]); 
			  }
			  /*ÏÂ*/
			  if(h1!=h2 ) {
			  for(int i = w2; i>=w1;i--) {
				  result.add(matrix[h2][i]);
			  }
			  }
			  /*×ó*/
			  if(w1!=w2) {
			  for(int i = h2-1; i>h1; i--) {
				  result.add(matrix[i][w1]);
			  }
			  }
			  
			  w1++;
			  h1++;
			  w2--;
			  h2--;
			// 
		  }
		  
		  return result;
	  }
	  /**
	   * LC 59
	   * */
	  
	  public static int[][] generateMatrix(int n) {
		  int w1= 0; //[0][0]
	      int w2 = n-1;
	      //int h = n-1;
	      int[][]result = new int[n][n];
	      boolean even = true;
	      if(n%2==1) {
	    	  even =false;
	    	  
	      }
	  
	      int number =1 ;
	      while(w1<=w2) {
	    	  /*ÉÏ*/
	    	  for(int i =w1; i<=w2;i ++) {
	    		  result[w1][i]= number;
	    		  number++;
	    	  }
	    	
	    	/*ÓÒ*/
	    	  for(int i = w1+1 ; i<w2;i ++) {
	    		  result[i][w2]= number;
	    		  number++;
	    	  }
	    	  
	    	 /*ÏÂ*/
	    	if(w1!=w2) {
	    	  for(int i = w2; i >=w1; i--) {
	    		  result[w2][i]= number;
	    		  number++;
	    	  }
	    	}
	    	  
	    	  
	    	  /*×ó*/
	    	  for(int i = w2-1; i >w1; i--) {
	    		  result[i][w1]= number;
	    		  number++;
	    	  }
	    	 
	    	
	    	  
	    	  w1++;
	    	  w2--;
	      }
	      
	   
		  return result;
	    }
	  
	  /**
	   * LC 91*/
	  public static int numDecodings(String s) {
	        if (s == null || s.length() == 0) {
	            return 0;
	        }
	        int n = s.length();
	        int[] dp = new int[n + 1];
	        dp[0] = 1;
	        dp[1] = s.charAt(0) != '0' ? 1 : 0;
	        for (int i = 2; i <= n; i++) {
	            int first = Integer.valueOf(s.substring(i - 1, i));
	            int second = Integer.valueOf(s.substring(i - 2, i));
	            if (first >= 1 && first <= 9) {
	               dp[i] += dp[i-1];  
	            }
	            if (second >= 10 && second <= 26) {
	                dp[i] += dp[i-2];
	            }
	        }
	        
	        for(int x:dp) {
	        	System.out.print(x+" ");
	        }
	        System.out.println();
	        return dp[n];
	    }
	  
	  public static int ciscoQ3(String s) {
		  if (s == null || s.length() == 0) {
	            return 0;
	        }
		 int length = s.length();
		 int []dp = new int[length+1];
		 dp[0] = 1;
		 dp[1] = s.charAt(0) == '0' ? 0:1;
		 //System.out.println(s.charAt(0));
		//	System.out.println(dp[0]+" "+dp[1]);	 
		 for( int i = 2; i < length+1; i++) {
			 int first = Integer.valueOf(s.substring(i-1,i));
			 int second = Integer.valueOf(s.substring(i-2,i));
			 
			 if(first >=1 && first <=9) {
				 dp[i] += dp[i-1];
			 }
			 if(second >=10 && second <=26) {
				 dp[i] += dp[i-2];
			 }
		 }
		 //System.out.println("cisco3: " +dp[length]);
		  return dp[length];
	  }
	  
	  public static void ciscoQ1 (int x1, int y1, int x2, int y2) {
		  if(x1 ==x2 ||y1 ==y2 ||((y1-y2)==(x1-x2))) {
			  System.out.println("Yes");
		  }
		  else {System.out.println("No");}
	  }
	  
	  public static void ciscoQ2(int n, char[][]grid, int w, String[]array1){
		  List<String> gridString = new ArrayList();
		  for(int i = 0; i <n;i ++) {
			  String temp = new String(grid[i]);
			  gridString.add(new String(temp));
			  gridString.add(new StringBuilder(temp).reverse().toString());
		  }
		  
		  for(int i = 0 ; i <n ; i++) {
			  char [] tempArr = new char[n];
			  for(int j = 0; j <n; j++) {
				  tempArr[j] = grid[j][i];				  
			  }
			  gridString.add(new String(tempArr));
			  gridString.add(new StringBuilder(new String(tempArr)).reverse().toString());
		  }
		  
		  for(String x:array1) {
			  if(inArray(x,gridString)) {
				  System.out.print("Yes ");
			  }
			  else {
				  System.out.print("No ");
			  }
			  
		  }
		  System.out.println();
		
	  }
	  
	  public static boolean inArray(String str, List<String> gridString) {
		  for(String x:gridString) {
			  if(x.indexOf(str)!=-1) {
				  return true;
			  }
		  }
		  return false;
	  }
	  
	  public static int maxSubArray(int[] A) {
	        int n = A.length;
	        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
	        dp[0] = A[0];
	        int max = dp[0];
	        
	        for(int i = 1; i < n; i++){
	            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
	            max = Math.max(max, dp[i]);
	        }
	        
	        return max;
	}
	  
	  public static int macsum(int[] nums) {
		  if(nums.length==0){
		  return 0;
		  }
		  int curr =0;
		  int curr1 = nums[0];
		  int curr2=0;
		  for(int i=1;i<nums.length;i++){
		  curr = Math.max(curr1,curr2);
		  curr1 = curr2+nums[i];
		  curr2 = curr;
		  }
		  return Math.max(curr1,curr2);
		  }
	public static void main(String[] args) {
		 int []array = {10 ,80 ,30 ,90 ,40 ,50, 70};
		 for(int x:array) {
			 System.out.print(x+" ");
		 }
		 System.out.println();
		 
		 sort(array,0,array.length-1);
		 for(int x:array) {
			 System.out.print(x+" ");
		 }
		 System.out.println();
		 int[]array1 = {3,3,3,3,3,1,3};
		 int[]array2 = {2,1,3,3,3,2};
		 
		 List<List<Integer>> list1 = new ArrayList();
		 list1 = groupThePeople(array1);
		 for(List<Integer> X:list1) {
			 for(Integer x:X) {
				 System.out.print(x+" ");
			 }
			 System.out.println();
		 }
		 
		 
		 //LC 807
		 int[][]grid = 
			 { {3, 0, 8, 4}, 
		   {2, 4, 5, 7},
		   {9, 2, 6, 3},
		   {0, 3, 1, 0}};
		 
		 maxIncreaseKeepingSkyline(grid);
		 String s= "()())()";
		 removeInvalidParentheses(s);
		 
		 String str1 = "aba";
		 System.out.println("validPalindrome: "+validPalindrome(str1));
		 
		 
		 //
		 String[] sentence = {"a", "bcd", "e"};
		 String sen = String.join(",",sentence) + " ";
		 System.out.println(sen);
		 System.out.println(sen.length());


		 int[][]matrix1 = 
			 { {0, 1, 2, 3}, 
		   {4, 5, 6, 7},
		   {8, 9,10 , 11},
		   {12, 13, 14, 15}};
		 int[][]matrix2 = 
			 { {0, 1, 2}, 
		   {3,4, 5},
		   {6, 7,8 } };
		 
		 int [][]matrix3 = {
				 {3},
				 {2}
		 };
		 int[][] matrix4 = {
		 {1,2,3,4},
		 {5,6,7,8},
		 {9,10,11,12}
		 };
		 
		 List<Integer> list2 = new ArrayList();
		 list2 = mySpiral(matrix3);
		 
		 for(Integer x: list2) {
			 System.out.print(x+" ");
		 }
		 System.out.println();
		 
		 
		 generateMatrix(4);
		 
		 
		 numDecodings("213324");
		 numDecodings("2133");
		 numDecodings("2123");
		 ciscoQ3("0");
		 
		 ciscoQ1(4,5,10,11);
		 
		 char [][]grid2 = {
				 {'C','A','T'},
				 {'I','D','O'},
				 {'M','O','M'},};
		 String [] array3 = {"CAT","TOM","MOM","CIM","CDM","TO","AT"};
		 
		 ciscoQ2(3, grid2, 5, array3);
		 
		 System.out.println(maxSubArray(new int[] {2,-8,3,-2,4,-10}));
		 System.out.println(maxSubArray(new int[] {1,4,2,8,7,9}));
		 
		System.out.println( macsum(new int[] {12,45,0,87,0,46,90}));
		
		
		double d1 = 5.0/9.0;
		Double d = d1;
		
		System.out.println(d);
        String[] splitter = d.toString().split("\\.");
        System.out.println(splitter[0].length());   // Before Decimal Count
        System.out.println(splitter[1].length());   // After  Decimal Count
        
	}
}


