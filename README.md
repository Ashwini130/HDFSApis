# HDFSApis
HDFS JAVA APIs

**Following is the list of problems for which I have written Java based HDFS APIs** <br>

1) Delete Empty Files in HDFS. 

   Problem Statement : A company  generates data every hour and places them on HDFS in separate partitions. However, for the past few days, no data is getting generated, but    still jobs create empty files in HDFS. This indirectly affects the Namenode memory issues as large number of irrelevant files are present in the namespace. Hence, you need    to list these files and delete them one by one. You have to write the Java Utility to solve the problem.

   Solution : List the files with their sizes in the given hdfs directory and delete them. 

   Code : HdfsDeleteEmpty.java

2) Split Files

   Problem Statement : From the given dataset, you need to separate the weather records of India , the rest of the world and write them into two separate files. Hence write      Java utility using Hadoop JavaAPI that performs the following:
   • Read all records from the dataset
   • Write all the records whose country = "India" into a separate file - india_weather.csv
   • Other records whose country is other than India must be written to row_weather.csv
   
   Solution : Read Data from the csv file and check the country and write to the output stream based on the checked value. 

   Code : SplitFiles.java

3) Sync Utility

   Problem Statement : Given Two Folders in HDFS cluster, Source and Target, write a sync utility which when executed, will sync the files in Target directory according to      the files in Source directory. 

   Solution : List the files of the source director and check the checksum of each file in source and target. If the checksum matches, no files need to be copied, if not,        file will be copied from Source to Target directory.

   Code : HdfsSyncUtility.java

