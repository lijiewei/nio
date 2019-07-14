package com.ljw.nio.nio;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @Description:
 * @Author: Administrator
 * @CreateDate: 2019/7/14 18:05
 */
public class FileLockTest {

    @Test
    public void FileLockTest() throws Exception {
        try(FileOutputStream fileOutputStream = new FileOutputStream("J:/abc.txt");
            FileChannel fileChannel = fileOutputStream.getChannel()){
            FileLock fileLock = fileChannel.tryLock();
            Thread.sleep(10000);
            fileLock.release();
        }
    }
}
