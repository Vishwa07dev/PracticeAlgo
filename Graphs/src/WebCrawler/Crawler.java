package WebCrawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crawler {
	
	private Queue<String> queue ;
	private List<String> visitedUrls ;
	
	public Crawler() {
		queue = new LinkedList<String>();
		visitedUrls = new ArrayList<String>();
		
	}
	
	public void crawl(String url){
		this.queue.add(url);
		while(!queue.isEmpty()){
			String urlX = queue.remove();
			System.out.println(urlX);
			visitedUrls.add(urlX);
			
			String rawHtml = getHtml(urlX);
			String regEx = "http://(\\w+\\.)*(\\w+)*";
			Pattern pattern = Pattern.compile(regEx);
			Matcher matcher = pattern.matcher(rawHtml);
			
			
			while(matcher.find()){
				String actualURL = matcher.group();
				
				if(!visitedUrls.contains(actualURL)){
					visitedUrls.add(actualURL);
					System.out.println("Website has been found with URL : "+actualURL);
					queue.add(actualURL);
				}
			}
			
		
			
		}
	}
	
	private String getHtml(String url){
		String html ="";
		
		System.out.println("Inside get HTML");
		try {
			URL u = new URL(url);
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(u.openStream()));
			
			String inputLines = "" ;
			while((inputLines = bufferedReader.readLine()) != null){
				//System.out.println(inputLines);
				html += inputLines;
			}
			bufferedReader.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return html ;
	}
	

}
