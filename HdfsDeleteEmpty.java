import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public class HdfsDeleteEmpty {

    public static void main(String args[]) throws IOException
    {
        Configuration conf = new Configuration();
        String uri = "hdfs://nameservice1";

        FileSystem fs = FileSystem.get(URI.create(uri),conf);

        RemoteIterator<LocatedFileStatus> fileStatusListIterator = fs.listFiles(
                new Path("/bigdatapgp/common_folder/assignment2/delete_empty/"), true);
        System.out.println("Empty Files that need to be deleted are:");
        while(fileStatusListIterator.hasNext()) {
            LocatedFileStatus fileStatus = fileStatusListIterator.next();
            //do stuff with the file like ...
            if (fileStatus.getLen() == 0) {
                String filename = fileStatus.getPath().getName();
                String path = "/bigdatapgp/common_folder/assignment2/delete_empty/"+filename;
                System.out.println(filename);
                fs.delete(new Path(path),true);

            }
        }
        FileChecksum checksum = fs.getFileChecksum(new Path("source/file1.txt"));


    }


}
