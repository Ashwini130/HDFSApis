import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public class HdfsSyncUtility {

    public static void main(String args[]) throws IOException
    {
        Configuration conf = new Configuration();
        String uri = "hdfs://nameservice1";

        FileSystem fs = FileSystem.get(URI.create(uri),conf);

        RemoteIterator<LocatedFileStatus> fileStatusListIterator = fs.listFiles(
                new Path("source"), true);
        while(fileStatusListIterator.hasNext()){
            LocatedFileStatus fileStatus = fileStatusListIterator.next();
            //do stuff with the file like ...
            FileChecksum chkSource = fs.getFileChecksum(fileStatus.getPath());
            String filename = fileStatus.getPath().getName();
            FileChecksum chkTarget = fs.getFileChecksum(new Path("target/"+filename));


            if(!chkSource.equals(chkTarget))
                FileUtil.copy(fs,new Path("source/"+filename),fs,new Path("target/"+filename),false,conf);
        }

        FileChecksum checksum = fs.getFileChecksum(new Path("source/file1.txt"));


    }


}
