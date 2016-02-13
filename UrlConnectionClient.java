mport java.net.URL;
import java.net.URLConnection;
import java.net.MalformedURLException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class UrlConnectionClient {
    public static void main(String[ ] args) {
        if (args.length == 0) {
            System.err.println("Usage: UrlConnectionClient <url>");
            return;
        }
        try {
            URL url = new URL(args[0].trim());
            URLConnection sock = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            String next = null;
            while ((next = reader.readLine()) != null)
                System.out.println(next);
            reader.close();
        }
        catch(MalformedURLException e) { 
          e.printStackTrace();
          throw new RuntimeException(e); 
        }
        catch(IOException e) { 
          e.printStackTrace();
          throw new RuntimeException(e); 
        }
    }
}
