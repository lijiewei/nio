package com.ljw.nio.nio;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @Description:
 * @Author: Administrator
 * @CreateDate: 2019/7/14 16:31
 */
public class ChannelTest {

    @Test
    public void FileChannelTest() {
        File file = new File("J:/abc.txt");
        try(FileChannel inChannel = new FileInputStream(file).getChannel();
            FileChannel outchannel = new FileOutputStream("J:/a.txt").getChannel()
        ){
            MappedByteBuffer mappedByteBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            System.out.println(mappedByteBuffer.capacity());
            System.out.println(mappedByteBuffer.limit());
            System.out.println(mappedByteBuffer.position());
            outchannel.write(mappedByteBuffer);
            mappedByteBuffer.clear();
            CharBuffer charBuffer = Charset.forName("GBK").newDecoder().decode(mappedByteBuffer);
            System.out.println(charBuffer);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void RandomFileChannelTest() {
        File file = new File("J:/abc.txt");
        try(RandomAccessFile raf = new RandomAccessFile(file, "rw");
                FileChannel fileChannel =raf .getChannel()){
            ByteBuffer byteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            System.out.println(byteBuffer.limit());
            System.out.println(byteBuffer.position());
            fileChannel.position(file.length());
            fileChannel.write(byteBuffer);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @Test
    public void ReadFileTest() {
        try(FileInputStream fis = new FileInputStream("J:/abc.txt");
            FileChannel fileChannel = fis.getChannel()){
            ByteBuffer byteBuffer = ByteBuffer.allocate(256);
            while (fileChannel.read(byteBuffer) != -1){
                byteBuffer.flip();
                CharBuffer charBuffer = Charset.forName("GBK").decode(byteBuffer);
                System.out.println(charBuffer);
                byteBuffer.clear();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
