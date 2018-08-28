package WebCrawler;

public class App {
	
	public static void main(String args[]){
		Crawler crawler = new Crawler();
		crawler.crawl("https://www.walmart.com");
	}

}
