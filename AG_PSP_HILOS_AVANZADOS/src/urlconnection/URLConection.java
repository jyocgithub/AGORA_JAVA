package urlconnection;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLConection {
    public static void main(String[] args) {
        String dir = "http://www.google.es";
        try {
            URL url = new URL(dir);
            URLConnection con = url.openConnection();
            //con.connect();
            InputStream is = con.getInputStream();
            BufferedReader bf = new BufferedReader(new InputStreamReader(is));
            String s;
            while ((s = bf.readLine()) != null) {
                System.out.println(s);
            }
            bf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
