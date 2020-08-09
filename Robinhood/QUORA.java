import java.util.*;
public class QUORA {
	/* static void printHashMap(HashMap) {
		 for (Integer name: map1.keySet()){
	         String key = name.toString();
	         String value = map1.get(name).toString();  
	         System.out.println("Key and Value:"+ key + " " + value); 
	       } 
		 	System.out.println();
	 }*/	
	/**
	 * Q1 :12345, 1-2+3-4+5
	 * 
	 * */
	
    static int question1 (int number) {  
    	char [] array1 = Integer.toString(number).toCharArray();    	
    	int sum =0;
    	for(int i = 0; i < array1.length; i++) {
    		int myInt = Integer.parseInt(String.valueOf(array1[i]));
    		
    		//System.out.println(myInt);
    		if(i %2 == 0) {
    			sum += myInt;
    		}
    		else {
    			sum -= myInt;
    		}
    		
    	}
    	return sum;
    }
    /**
     * Q2, "Hello, my dear friend!", ['H,'e','l','o','m']
     * */
 static int question2 (String str1, List<Character>letter) {  
    	HashSet<Character> table1 = new HashSet();
    	str1 = str1.toLowerCase();
    	
   	    String[] splitStr= str1.split(" ");   	    
   	    for(Character x: letter) {
   	    	table1.add(x);
   	    }
   	 int sum = 0;
   	    for(int i = 0; i < splitStr.length;i++) {
   	    	int count = 0; int flag = 0;
   	        for(int j = 0; j< splitStr[i].length(); j++) {
   	        	char ch1 = splitStr[i].charAt(j);   	       
   	        	if(Character.isLetter(ch1)) {
   	        		if(!table1.contains(ch1)) {
   	        			flag = 1;  
   	        		}
   	        	}   	        	
   	        }   	    
   	     if(flag == 0) {
        		sum ++;
           }
   	    }
   	    
    	return sum;
    }
 
  /**
   * 
   * Q3, good tuples, my functions
   *   [1, 1, 2, 1, 5, 3, 2, 3] 
   * */
 static int question3 (int[] number) {
 	Map<Integer, Integer> map1 = new HashMap();
     // 1 2 3
 	  int sum = 0; 
 	  map1.put(1,number[0]);
 	  map1.put(2,number[1]);
 	  if(map1.get(1) == map1.get(2) && !map1.containsValue(number[2])) {
 		  sum++;
 	  }
 	  if(map1.get(1) != map1.get(2) && map1.containsValue(number[2])) {
 		  sum++;
 	  }
 	 map1.put(3,number[2]);
 	   
 	  for(int i = 3; i< number.length ; i++) {
 		  map1.replace(1, map1.get(1), map1.get(2));
 		  map1.replace(2, map1.get(2), map1.get(3));
 		  map1.remove(3);
 		 if(map1.get(1) == map1.get(2) && !map1.containsValue(number[i])) {
 	 		  sum++;
 	 	  }
 	 	  if(map1.get(1) != map1.get(2) && map1.containsValue(number[i])) {
 	 		  sum++;
 	 	  }
 	 	  
 	 	  map1.put(3, number[i]);
 	  }

 	return sum;
 }
 
 /**
  *  Q3, good tuple, function from leetcode  
  * */
 
 public static int goodTuples(int[] arr) {
     int count = 0;
     for (int i = 1; i < arr.length - 1; i++) {
         if (arr[i - 1] == arr[i] && arr[i] != arr[i+1] ||
            arr[i - 1] != arr[i] && arr[i] == arr[i+1] ||
            arr[i - 1] == arr[i+1] && arr[i-1] != arr[i]) {
             count++;
         }
     }
     return count;
 }
  /**
   * Q4 max length , 	`0 the ribbon
   * */
 public static int greatestLength(int[] arr, int k) {
	    int max = 0;
	    for (int a : arr) {
	      max = Math.max(max, a);
	    }
	    System.out.println("MAx: " + max);
	    int lo = 1, hi = max;
	    while (lo <= hi) {
	      int mid = lo + (hi - lo) / 2;
	      int len = getLen(arr, mid);
	      if (len >= k) { lo = mid + 1;
	      System.out.println("low :" + lo);
	      }
	      else { hi = mid - 1; System.out.println("high :" + hi);}
	    }
	    return hi;
	  }
 private static int getLen(int[] arr, int target) {
	    int res = 0;
	    for (int a : arr) {
	      res += (a / target);
	    }
	    System.out.println("Target + getLen: " +target + " "+ res);
	    return res;
	  }
 
 
 /**
  *  Q5, bestSquare
  *  m = [[1, 2, 4], [6, 5, 5], [3, 2, 1]]

k = 2

Output: 20

Explanation:

[[1, 2], [6, 5]] -> sum = 14

[[2, 4], [5, 5]] -> sum = 16

[[6, 5], [3, 2]] -> sum = 16

[[5, 5], [2, 1]] -> sum = 13

maxSum = 16

uniq([[2, 4], [5, 5]], [[6, 5], [3, 2]]) = [2, 3, 4, 5, 6]

ans = 2 + 3 + 4 + 5 + 6 = 20
  * */
 public static int bestSquare(int[][] matrix, int k) {
	 System.out.println("Q5: BestSquare ~");
	 List<int [][]> Braket = new ArrayList<>();

	 int length = (matrix.length - k+1)*(matrix[0].length - k+1);
	 System.out.println("length = "+length );

     
       for(int i = 0;i<=matrix.length - k; i++ ) {
			for(int j = 0 ; j <= matrix[0].length - k; j++) {
				int [][] newArray = new int[k][k];
				for(int  a = 0; a < k; a++) {  
					for(int b = 0; b < k; b++) {
				
					newArray[a][b] = matrix[i+a][j+b];  
			   } 					
		    }
				Braket.add(newArray);
		 }			
	 }
      
       for(int  i = 0 ; i < Braket.size(); i++) {
    	   for(int[]x:Braket.get(i)) {
    			 for(int X:x) {
    				System.out.print(X+" ");
    			 }
    		 }
    	   System.out.println();
       }
       System.out.println("target Braket: ");
  	 int maxSum = 0;
       List<int[][]>targetBraket = new ArrayList();
       for(int  i = 0 ; i < Braket.size(); i++) {
    	   
    	    if(sumUp(Braket.get(i))==maxSum) {    	    	
    	    	targetBraket.add(Braket.get(i));
    	    }
    	    else if(sumUp(Braket.get(i))>maxSum) {
    	    	maxSum = sumUp(Braket.get(i));
    	    	targetBraket.clear();
    	    	targetBraket.add(Braket.get(i));
    	    }
    	    else if (sumUp(Braket.get(i))<maxSum) {
    	    	
    	    }
       }
       
       for(int  i = 0 ; i < targetBraket.size(); i++) {
    	   for(int[]x:targetBraket.get(i)) {
    			 for(int X:x) {
    				System.out.print(X+" ");
    			 }
    		 }
    	   System.out.println();
       }
		
       HashSet<Integer> set1 = new HashSet();
       
       for(int  i = 0 ; i < targetBraket.size(); i++) {
    	   for(int[]x:targetBraket.get(i)) {
    			 for(int X:x) {
    				 if(!set1.contains(X)) { set1.add(X);}
    			 }
    		 }
    	  
       }
       System.out.println(set1);
       int finalSum = 0;
       Iterator<Integer> i = set1.iterator();
       while(i.hasNext())
          {finalSum += i.next();}
       System.out.println("final Sum :"+ finalSum);
	 return 0;
 }
 
 public static int sumUp(int[][] array) {
	 int sum = 0;
	 for(int[]x:array) {
		 for(int X:x) {
			 sum+= X;
		 }
	 }
	 return sum;
 }
 /**
  *  Q6, String , char frequency
  *  Input: S1 = ¡°babzccc¡±, S3 = ¡°abbzczz¡±, this is same
*/
 
 public static boolean myCompare(String str1, String str2) {
	 
	 int length1= str1.length();
	 int length2= str2.length();
	 
	 if(length1 != length2) {
		 return false;
	 }
	  
	  HashMap <Character, Integer> map1 = new HashMap();
	  char [] strArray = str1.toCharArray();
	  
	  for(char char1 :strArray) {
		  if(!map1.containsKey(char1)) {
			  map1.put(char1,1);
		  }
		  else {
			  map1.put(char1,map1.get(char1)+1);
		  }
	  }
	  
	  HashMap <Character, Integer> map2 = new HashMap();
	  char [] strArray2 = str2.toCharArray();
	  
	  for(char char1 :strArray2) {
		  if(!map2.containsKey(char1)) {
			  map2.put(char1,1);
		  }
		  else {
			  map2.put(char1,map2.get(char1)+1);
		  }
	  }
	  
	  if(!map1.keySet().equals(map2.keySet())) {
		  return false;
	  }
	  
	  for(Integer int1:map1.values()) {
		  if(!map2.containsValue(int1)) {
			  return false;
		  }
	  }
	 return true;
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
 /**
  *  Q8,divisor Substring
  */
    public static int divisorSubstring(int number, int length) {
    	
    	String s=String.valueOf(number);
    	// 1234, 2 
    /*	0 1, 12,23
    	0123
    	4-2 =2*/
    	int count = 0;
    	int numberStr = Integer.parseInt(s);
    	for(int i =0; i <= s.length()-length;i++) {
    		String sub = s.substring(i, i+length);
    		int myInt = Integer.parseInt(sub);
    		if(numberStr%myInt ==0) {
    			count++;
    			System.out.print(myInt+" ");
    		}    		
    	}
    	System.out.println();
    	return count;
    }
    /**
     *  Q8,divisor Substring
     */
    
    public static boolean prefixString(String[]a,String[]b) {
    	HashSet<String> set1 = new HashSet();
    	String toAdd = "";
    	for(int i =0; i <a.length;i++) {
    		toAdd =toAdd +a[i];
    		set1.add(toAdd);
    	}
    	Iterator it = set1.iterator();
    	{
    	  while(it.hasNext()) {
    		  System.out.print(it.next()+" ");
    	  }	
    	}
    	for(String x: b) {
    		if(!set1.contains(x)) {
    			return false;
    		}
    	}
    	
    	return true;
    }
    
    /**
     * 10, merge intervals
     * */
   static class Interval {
          int start;
         int end;
         Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
      }
     
   static  class Sortbystart implements Comparator<Interval> 
    { 
        
        public int compare(Interval a, Interval b) 
        { 
            return a.start - b.start; 
        } 
    } 

    
        public static List<Interval> merge(List<Interval> intervals) {
            List<Interval>Result = new ArrayList<Interval>();
                if (intervals.size() <= 0)  
             return Result;
           //List<Interval>Result = new ArrayList<Interval>();
            Stack<Interval> stack=new Stack<>();     
           
          Collections.sort(intervals, new Sortbystart()); 
        
         
            stack.push(intervals.get(0));  
        
          
            for (int i = 1 ; i < intervals.size(); i++)  
            {  
               
                Interval top = stack.peek();  
        
               
                if (top.end < intervals.get(i).start)  
                    stack.push(intervals.get(i));  
        
                
                else if (top.end < intervals.get(i).end)  
                {  
                    top.end = intervals.get(i).end;  
                    stack.pop();  
                    stack.push(top);  
                }  
            }  
          
           
            while (!stack.isEmpty())  
            {  
                Result.add(stack.pop());  
            }   
            return Result;
            
        }
        
	 public static void main(String[] args) {
		 System.out.println(question1(12345));	
			String str1= "Hello my dear Friend";
			List<Character>letter = new ArrayList();
			letter.add('h');letter.add('e');
			letter.add('l');letter.add('o');
			letter.add('m');
			letter.add('f');letter.add('n');
			letter.add('r');letter.add('d');
			letter.add('i');
			
			String str2= "Hello, my dear friend!";

			int i = question2(str2,letter);
			System.out.println("Total i: "+i);
			
			int []array1 = {1, 1, 2, 1, 5, 3, 2, 3,1,3};
          Map<Integer, Integer> map1 = new HashMap();
 	
		 	  map1.put(1,array1[0]);
		 	  map1.put(2,array1[1]);
		 	  map1.put(3,array1[2]);
		 	  
		 	 for (Integer name: map1.keySet()){
		            String key = name.toString();
		            String value = map1.get(name).toString();  
		            System.out.println(key + " " + value);  
		     } 
		 	 
		 	 int tuples = goodTuples(array1);
		 	 System.out.println("GOod Tuples: " + tuples);
		 	 
		 	 int tuples2 = question3(new int[]{1, 1, 2, 1, 5, 3, 2, 3,1,3});
		 	 System.out.println("GOod Tuples2: " + tuples2);
		 	 int int1 = 5/2;
		 	 System.out.println(int1);
		 	 
		 	System.out.println(greatestLength(new int[] {1,2,3,4,9},5));
		 	
		 	
		 	int[][]m = {{1, 2, 4,7}, {6, 5, 5,2}, {3, 1, 1,9},{8,8,8,8}};
		 	
		 	bestSquare(m,3);
		 	
		 	/***Q6****/
		 	String S1 = "babzccc", S3 = "abbzczf";		      
		      System.out.println("Q6, compare string");
		      System.out.println(myCompare(S1,S3));
		      
		  	/***Q7****/
		      
		      List<Integer>list1 = new ArrayList();
		      list1 = coolFeature(new int[] {1,2,3},new int[]{3,4},new int[][]{new int[] {1,5},
		    	  new int[] {1,1,1},new int[] {1,5}});
		      
		      for(Integer x:list1) {
		    	  System.out.print(x+" ");
		      }
		      System.out.println();
		      /***Q8****/  
		     System.out.println( "Q8: "+divisorSubstring(120,2));
		     /***Q9****/  
		     String[]a = {"one","two","three","four"};
		     String[]b = {"onetwo","onetwothree","twoone"};
		     System.out.println(prefixString(a,b));
		     
		     /**Q10***/
		     List<Interval> intervals = new ArrayList();
		     List<Interval> result = new ArrayList();
		     
		     intervals.add(new Interval(1,3));
		     intervals.add(new Interval(2,8));
		     intervals.add(new Interval(8,10));
		     intervals.add(new Interval(15,18));
		     // 1 3, 2 6, 8 10, 15 18
		     result = merge(intervals);
		     for(Interval x: result) {
		    	 System.out.print(x.start+" "+x.end+" , ");
		     }
		     System.out.println();
		   //  int[][]interval = {{1,3},{2,6},{8,10},{15,18}};
		     
		     double X = -5;
		     double Y = 25;
		     double f = -2.5*X -Y +2.5;
		     System.out.println("f : "+ f);
		     
	}
}
