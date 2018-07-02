import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

/**
 * Created by ZJ on 02/07/2018.
 */
public class Address {

  public static void main(String[] args) throws IOException {
    FileInputStream inputStream = new FileInputStream(
        "/Users/zj/Documents/office/v5/CodeAddress.txt");

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

    FileOutputStream outputStream = new FileOutputStream(
        "/Users/zj/Documents/repo/git/elasticsearch-analysis-ik/config/ext_mgv1.dic");
    BufferedWriter bufferedWriter = new BufferedWriter(new
        OutputStreamWriter(outputStream));

    HashSet<String> set = new HashSet<>();

    String str = null;
    while ((str = bufferedReader.readLine()) != null) {

      bufferedWriter.write(str.split(" ")[0]);
      bufferedWriter.newLine();

    }

    //close
    inputStream.close();
    bufferedReader.close();
    bufferedWriter.close();
    outputStream.close();
  }

}
