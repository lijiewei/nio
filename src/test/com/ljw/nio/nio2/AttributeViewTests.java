package com.ljw.nio.nio2;

import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: Administrator
 * @CreateDate: 2019/7/14 21:11
 */
public class AttributeViewTests {

    @Test
    public void AttributeViewTests() throws Exception {
        Path path = Paths.get("J:\\aa\\a.txt");

        BasicFileAttributeView basicFileAttributeView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        BasicFileAttributes basicFileAttributes = basicFileAttributeView.readAttributes();
        System.out.println(new Date(basicFileAttributes.creationTime().toMillis()));
        System.out.println(new Date(basicFileAttributes.lastAccessTime().toMillis()));
        System.out.println(new Date(basicFileAttributes.lastModifiedTime().toMillis()));

        System.out.println(basicFileAttributes.size());

        FileOwnerAttributeView fileOwnerAttributeView = Files.getFileAttributeView(path, FileOwnerAttributeView.class);
        System.out.println(fileOwnerAttributeView.getOwner());
        UserPrincipal guest = FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName("guest");

        UserDefinedFileAttributeView userDefinedFileAttributeView = Files.getFileAttributeView(path, UserDefinedFileAttributeView.class);
        List<String> list = userDefinedFileAttributeView.list();
        list.forEach(name -> {
            ByteBuffer buf = null;
            try {
                buf = ByteBuffer.allocate(userDefinedFileAttributeView.size(name));
                userDefinedFileAttributeView.read(name, buf);
                buf.flip();
                System.out.println("自定义" + Charset.defaultCharset().decode(buf).toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        userDefinedFileAttributeView.write("发行者", Charset.defaultCharset().encode("疯狂的我们"));

        DosFileAttributeView dosView = Files.getFileAttributeView(path, DosFileAttributeView.class);
        dosView.setHidden(true);
        dosView.setReadOnly(true);
    }
}
