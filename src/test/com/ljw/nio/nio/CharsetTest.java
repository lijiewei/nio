package com.ljw.nio.nio;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * @Description:
 * @Author: Administrator
 * @CreateDate: 2019/7/14 17:46
 */
public class CharsetTest {

    @Test
    public void CharsetTest() throws CharacterCodingException {
        Charset gbk = Charset.forName("GBK");
        CharsetEncoder encoder = gbk.newEncoder();
        CharsetDecoder decoder = gbk.newDecoder();
        CharBuffer charBuffer = CharBuffer.allocate(8);
        charBuffer.put("孙").put("五").put("空");
        charBuffer.flip();
        ByteBuffer byteBuffer = encoder.encode(charBuffer);
        for (int i = 0; i < byteBuffer.capacity(); i++) {
            System.out.println(byteBuffer.get(i));
        }
        System.out.println(decoder.decode(byteBuffer));
    }
}
