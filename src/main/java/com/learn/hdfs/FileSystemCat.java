package com.learn.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/**
 * Created by Administrator on 2017/6/28.
 */
public class FileSystemCat {

    public static void main(String args[]) throws IOException {
        String uri = "hdfs://47.94.130.91/input/core-site.xml";
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri),conf);
        InputStream in = null;
        in = fs.open(new Path(uri));
        IOUtils.copyBytes(in,System.out,4096,false);
    }
}
