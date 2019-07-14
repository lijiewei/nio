package com.ljw.nio.nio;

import org.junit.Test;

import java.nio.CharBuffer;

/**
 * @Description:
 * @Author: Administrator
 * @CreateDate: 2019/7/14 15:34
 */
public class BufferTest {

    @Test
    public void bufferTest() {
        CharBuffer buffer = CharBuffer.allocate(8);
        System.out.println("capacity：" + buffer.capacity());
        System.out.println("limit：" + buffer.limit());
        System.out.println("position：" + buffer.position());

        buffer.put("a").put("b").put("c");
        System.out.println(buffer.position());
        buffer.flip();
        System.out.println("=========");
        System.out.println(buffer.limit());
        System.out.println(buffer.position());
        System.out.println(buffer.get());
        System.out.println(buffer.position());
        System.out.println(buffer.get());
        System.out.println(buffer.get());
        System.out.println(buffer.position());
        buffer.clear();
        System.out.println(buffer.limit());
        System.out.println(buffer.position());

        System.out.println(buffer.get(2));
        System.out.println(buffer.position());

    }
}
