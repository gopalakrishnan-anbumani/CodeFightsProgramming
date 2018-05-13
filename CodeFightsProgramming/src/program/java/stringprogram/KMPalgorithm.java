package program.java.stringprogram;

public class KMPalgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		patternSearching("AAABAAA".toCharArray(),"ggg".toCharArray());
	}

	public static void patternSearching(char[] pat,char[] text){
		
		int patLen = pat.length;
		int[] lps = new int[pat.length];
		// Find proper prefix of suffix
		
		lps[0] = 0;
		int index = 0;
		for(int i=1;i<patLen;i++){
			
			if(pat[index]==pat[i]){
				lps[i]=++index;
			}else{
				int preIndex = (lps[i-1]-1) > 0 ? lps[i-1]-1 : 0;
				
				index = lps[preIndex];
				
				if(pat[index]==pat[i]){
					lps[i]=++index;
				}else{
					index = 0;
					lps[i]=index;
				}
				
			}
			
		}
		
		
		printIntArr(lps);
	}
	
	public static void printIntArr(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	
	
}
