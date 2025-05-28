package leerweb;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class LeerWeb {

	public static void main(String[] args) {
        String content = null;
        URLConnection connection = null;
        try {
            connection = new URL("https://es.wikipedia.org/wiki/Zara").openConnection();
//            connection =  new URL("http://www.google.com/search?q=jaja").openConnection();
            connection.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
            Scanner scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter("\\Z");
            scanner.useDelimiter("\\A");

            content = scanner.hasNext() ? scanner.next() : "";
            scanner.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(content);
        if (content.contains("Aprox")) {
            System.out.println("120");
        }

	}
}
