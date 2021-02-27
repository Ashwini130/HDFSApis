import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;

public class SplitFiles {
    public static void main(String args[]) throws IOException {
        Configuration conf = new Configuration();
        String uri = "hdfs://nameservice1";

        FileSystem fs = FileSystem.get(URI.create(uri),conf);
        FSDataInputStream input = fs.open(new Path("/bigdatapgp/common_folder/assignment2/weather_dataset/weather1.csv"));
        BufferedReader b = new BufferedReader(new InputStreamReader(input));
        String line = b.readLine();
        FSDataOutputStream output = fs.create(new Path("india_weather.csv"));
        output.writeBytes(line);
        FSDataOutputStream output2 = fs.create(new Path("row_weather.csv"));
        output2.writeBytes(line);

        while((line=b.readLine())!=null)
        {
          String values[] = line.split(",");
          if(values[4].equals("India"))
              output.writeBytes(line);
          else output2.writeBytes(line);
        }

        output.close();
        output2.close();
        fs.close();
    }

}
