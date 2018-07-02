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
public class Yearn {

  public static void main(String[] args) throws IOException {

    FileOutputStream outputStream = new FileOutputStream(
        "/Users/zj/Documents/repo/git/elasticsearch-analysis-ik/config/ext_mgv.dic");
    BufferedWriter bufferedWriter = new BufferedWriter(new
        OutputStreamWriter(outputStream));

    for (int i = 1840; i< 2030; i++) {
      bufferedWriter.write(String.valueOf(i));
      bufferedWriter.newLine();
    }

    for (int u = 01;u<32; u++){
      bufferedWriter.write(String.format("%02d", u));
      bufferedWriter.newLine();
    }


    for (int i = 0; i< 10; i++) {
      bufferedWriter.write(String.valueOf(i));
      bufferedWriter.newLine();
    }

    bufferedWriter.write("X");
    bufferedWriter.newLine();
    bufferedWriter.write("x");
    bufferedWriter.newLine();

    for (int u = 0;u<1000; u++){
      bufferedWriter.write(String.format("%03d", u));
      bufferedWriter.newLine();
    }

    bufferedWriter.close();
    outputStream.close();
  }

}
