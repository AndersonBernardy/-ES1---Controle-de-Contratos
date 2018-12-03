import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;
 
public class Json2Java {
    public static void main(String[] args) {

        Gson gson = new Gson();
 
        try {
 
            BufferedReader br = new BufferedReader(new FileReader("c:\\file.json"));
 

        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
}