package com.learn.hdfs;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.io.IOUtils;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by Administrator on 2017/6/28.
 */
public class URLCat {
    static {
        URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
    }

    public static void main(String args[]) {
        InputStream in = null;
        try {
            in = new URL("hdfs://47.94.130.91/input/core-site.xml").openStream();
            IOUtils.copyBytes(in, System.out, 4096, false);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeStream(in);
        }

    }
}
