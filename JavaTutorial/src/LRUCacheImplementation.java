import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUCacheImplementation {
	
	
	private int size ;
	private int currentCount ;
	
	private List<String> keyEntries ;
	
	private Map<String, String> entriesMap ;
	
	public LRUCacheImplementation(int size ){
		this.size= size ;
		currentCount = 0 ;
		keyEntries = new LinkedList<String>();
		entriesMap = new HashMap<String,String>();
	}
	
	//Setting the values
	public void setValue(String key, String value){
		
		if(currentCount == size){
			//Need to evict
			clearCache();
		}
		keyEntries.add(0,key);
		entriesMap.put(key, value);
		
	}

	//Getting the values
	public String getValue(String key , String value){
		if(entriesMap.get(key)!=null){
			keyEntries.remove(key);
			keyEntries.add(0,key);
			return entriesMap.get(key);
		}
		return null;
	}
	


	private void clearCache() {
		String keyToBeRemoved = keyEntries.remove(currentCount-1);
		
		entriesMap.remove(keyToBeRemoved);
		currentCount--;
	}
	

}
