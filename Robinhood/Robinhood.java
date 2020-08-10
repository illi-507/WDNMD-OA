import java.util.*;

public class Robinhood {
	
	/**
	 * concatenate edge letters 
	 * */
	 public static String[] concatEdgeLetters(String[] a) {
	    	int len = a.length;
	    	String []result = new String[len];
	    	for(int i = 0; i<len; i++) {
	    		String temp = "";
	    		if(i!= len-1) {
	    			temp = temp+ a[i].charAt(0) +a[i+1].charAt(a[i+1].length()-1);
	    		}
	    		else{
	    			temp = temp+ a[len-1].charAt(0) +a[0].charAt(a[0].length()-1);
	    			} 
	    		result[i] = new String(temp);
	    	}
	    	return result;
	    }
	 
	
	 
	    /**
		 * W D L   LDWDL 
		 * */
	    public static String equallyRearranging(String str) {
	        String result = "";
	        while(str.length()>0) {
	        	if(str.indexOf('W')!= -1) {
	        	   	        	 
	        	   String temp = str.replaceFirst("W", "");
	        	   str = temp;
	        	   result = result+"W";
	        	}
	        	if(str.indexOf('D')!= -1) {
	         	   	         	
	         	  String temp = str.replaceFirst("D", "");
	         	   str = temp;
	         	  result = result+"D";
	         	}
	        	if(str.indexOf('L')!= -1) {
	         	  String temp = str.replaceFirst("L", "");	         	  
	         	   str = temp;
	         	  result = result+"L";
	         	}
	        }
	        
	    	return result;
	    }

	    static  int minDiffOfArrays(int[] a, int[] b) {
	       int [] diff = new int[a.length];
	       for( int i  =0 ; i < a.length; i++) {
	    	   diff[i] = Math.abs(a[i]-b[i]);
	       }
	       
	       for(int x: diff) {
	    	 //  System.out.println(x);
	       }
	       int biggest = Integer.MIN_VALUE;
	       int index = 0;
	       for( int i  =0 ; i < diff.length; i++) {
	    	   if(biggest<diff[i]) {
	    		  biggest = diff[i];
	    		  index = i;
	    	   }
	       }	       
	    //   System.out.println("index: "+index);	       
	       int closeIndex = findCloset(a,b[index]);	       
	     //  System.out.println("closest index: "+closeIndex);
	       
	       a[index] =a[closeIndex];
	       
	       int sum = 0;
	       for( int i  =0 ; i < a.length; i++) {
	    	 sum+= Math.abs(a[i]-b[i]);
	       }
	       System.out.println("Min sum is :"+sum);
	      return sum;  
	    }
	    
	    static int findCloset(int []array, int number) {
	        int diff = Integer.MAX_VALUE;
	        int index = 0;
	        for( int i  =0 ; i < array.length; i++) {
	     	       if( Math.abs(array[i]- number)<diff) {
	     	    	   diff = Math.abs(array[i]- number);
	     	    			   index = i;
	     	       }
	        }
	    	return index;	
	    }
	    
	    /*
	    1 4 3 2
	    8 4 7 1
	    1 5 2 1
	    
	    1 3 2 
	    4 4 1
	    5 2 7
	    
	    1 1 2
	    2 4 3
	    5 4 7*/
	    
	    static int[][] sortChessSubsquares(int[][] numbers, int[][] queries) {
	         
	    	for(int i = 0 ; i < queries.length;i++) {
	    		changeArray(numbers, queries[i]);
	    	}
	    	  for(int i = 0 ; i < numbers.length;i++) {
	    		   for(int j=0; j< numbers[0].length;j++) {
	    			    System.out.print(numbers[i][j]+" ");
	    		   }
	    		   System.out.println();
	    	   }
	    	return numbers;
	    }
	    
	    public static void changeArray(int[][]number,int [] query) {
               int x = query[0];
               int y = query[1];
	    	   int len = query[2];
	    	   
	    	   List<int[]> blackIndex = new ArrayList();
	    	   List<int[]> whiteIndex = new ArrayList();
	    	   List<Integer> blackNumber = new ArrayList();
	    	   List<Integer> whiteNumber = new ArrayList();
	    	   
	    	   for(int i =x; i<x+len;i++) {
	    		   for(int j = y; j<y+len; j++) {
	    			   //System.out.print(number[i][j]+" ");
	    			   
	    			   if((i+j)%2 ==0) {
	    				   blackIndex.add(new int[]{i,j});
	    				   blackNumber.add(number[i][j]);
	    			   }
	    			   else {
	    				   whiteIndex.add(new int[]{i,j});
	    				   whiteNumber.add(number[i][j]);
	    			   }
	    		   }
	    		   //System.out.println();
	    	   }	 
	    	 //  System.out.println(blackNumber);
	    	   Collections.sort(blackNumber);
	    	   Collections.sort(whiteNumber);
	    	   
	    	   for(int i = 0 ; i <blackIndex.size(); i++) {
	    		   int x1 = blackIndex.get(i)[0];
	    		   int y1 = blackIndex.get(i)[1];
	    		   
	    		   number[x1][y1] = blackNumber.get(i);
	    	   }
	    	   
	    	   for(int i = 0 ; i <whiteIndex.size(); i++) {
	    		   int x1 = whiteIndex.get(i)[0];
	    		   int y1 = whiteIndex.get(i)[1];
	    		   
	    		   number[x1][y1] = whiteNumber.get(i);
	    	   }
	    	   
	    	 //  System.out.println(blackNumber);
	    	   
	    	 
	    }	  
       
	    
	    
	    static class Number {
	        int val;
	        int leftNeighborIndex;
	        int rightNeighborIndex;
	 
	        public Number(int val, int leftNeighborIndex, int rightNeighborIndex) {
	            this.val = val;
	            this.leftNeighborIndex = leftNeighborIndex;
	            this.rightNeighborIndex = rightNeighborIndex;
	        }
	    }
	    
	    /**
	     *  Q7,Cool Feature
	    */
	    
	    public static List<Integer> coolFeature(int[]a, int[]b,int[][]query) {
	   	 Map<Integer,Integer> mapA = new HashMap();
	   	 for(int num:a) {
	   		 mapA.put(num,1 + mapA.getOrDefault(num,0));
	   	 }
	   	 
	   	 List<Integer> res = new ArrayList<>();
	   	 for(int[]q:query) {
	   		 if(q.length == 3) {
	   			 b[q[1] -0] = q[2];
	   		 }
	   		 else {
	   			 int sum =q[1],count = 0;
	   			 for(int i =0; i<b.length; i++) {
	   				 int target = sum- b[i];
	   				 if(!mapA.containsKey(target)) {
	   					 continue;
	   				 }
	   				 else {
	   					 count+=mapA.get(target);
	   				 }				 
	   			 }
	   			 res.add(count);
	   		 }
	   	 }
	   	 
	   	 return res;
	    }
	    
   public static void main(String[] args) {
	    String[] array1 = {"cat", "dog", "ferret", "scorpion"};
    	
    	String[] result1 = concatEdgeLetters(array1);
    	
    	for(String x:result1) {
    		System.out.print(x+" ");
    	}
    	System.out.println();
    	
    	String str1 = "LDWDL";
    	
    	System.out.println("equallyRearranging: " +equallyRearranging(str1));
    	
    	int []a = {1,3,5};
    	int []b = {5,3,1};
    	
    	int []c= {1, 5, 2, 4};
    		int[]d= {4, 4, 4, 4};
    	
        System.out.println("mind diff array-----");
    	minDiffOfArrays(a,b);
    	
    	int []array2= {3,4,5};
    	
    	//changeArray(array2);
    	System.out.println(array2[0]+ " "+ array2[1] +" "+array2[2]+ " ");
    	
    	List<Integer> temp1 = new ArrayList();
    	temp1.add(10);
    	temp1.add(-1);
    	temp1.add(9);
    	
    	Collections.sort(temp1);
    	System.out.println(temp1);
    	
    	int [][]number1 = {{1,4,3,2},{8,4,7,1},{1,5,2,1}};
    	int [][]query1 = {{0,1,3},{1,0,2}};
    	sortChessSubsquares(number1,query1);
    	System.out.println();
    	int [][]number2 = {{2,1},{3,3},{5,4}};
    	int [][]query2 = {{0,0,2},{1,0,2},{0,0,2}};
    	sortChessSubsquares(number2,query2);
    	System.out.println();
    	
    	int [][]number3 = {{15,12,4,15},
    			{20,16,20,1},{17,14,19,12},
    			{20,18,14,13},{6,2,4,4},
    			{13,5,4,6},{17,16,5,13}};
    	int [][]query3 = {{2,2,2},{3,1,2},{0,0,4},
    			{3,0,4},{3,0,4},{3,0,4},
    			{0,0,2},{3,0,2},{1,2,2},
    			{1,1,3}};
    	
    	sortChessSubsquares(number3,query3);
    	
    	
        
    }
}
