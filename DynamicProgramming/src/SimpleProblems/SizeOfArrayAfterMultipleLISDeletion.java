package SimpleProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/**
 * Good question, finally I was able to solve this question :)
 * @author vmohan
 *
 */
public class SizeOfArrayAfterMultipleLISDeletion {
	
	private static int getSizeOfArray(List<Integer> list){
		if(list==null || list.isEmpty()){
			return 0;
		}
		
		
		
		
		int size =0;
		while(!list.isEmpty()){
			
			List<Integer> lisList = getLISList(list);
			if(lisList.size()<2){
				//It means it's in decreasing order
				size = list.size();
				break;
			}
			for(int i=0;i<lisList.size();i++){
				list.remove(lisList.get(i));
			}
		}
	   
		
		return size ;
	}

	private static List<Integer> getLISList(List<Integer> list) {
		List<Integer> lisList = new ArrayList<>();
		
		List<Integer> m = new ArrayList<>();
		//m.get(i) will give the length of longest LIS till ith index
		
		
		m.add(0,1);
		for(int i =1;i<list.size();i++){
			int size = 0 ;
			for(int j=0;j<i;j++){
				if(list.get(i)>list.get(j)){
					if(size < m.get(j)){
						size = m.get(j);
					}
				}
			}
			m.add(i,size+1);
		}
		
		int index = 0;
		int maxValue = Integer.MIN_VALUE;
		int count = 0;
		for( int i : m){
			
			if(maxValue <i){
				maxValue = i ;
				index =count ;
			}
			count ++;
		}
		
		for(int i=maxValue ;i>=1;i--){
			lisList.add(0,list.get(m.indexOf(i)));
		}
		
		
		return lisList;
	}
	
	
	public static void main(String args[]){
		int arr[] = {5, 3, 2} ;
		
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		System.out.println(getSizeOfArray(list));
		
		
		//List<String> l  = new ArrayList<String>(null);
		//System.out.println(getLISList(list));
	}

}
