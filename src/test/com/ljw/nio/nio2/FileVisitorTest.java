package com.ljw.nio.nio2;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @Description:
 * @Author: Administrator
 * @CreateDate: 2019/7/14 20:44
 */
public class FileVisitorTest {

    @Test
    public void FileVisitorTest() throws IOException {
        Files.walkFileTree(Paths.get("J:\\aa"), new SimpleFileVisitor<>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("正在访问：" + file);
                if(file.endsWith("b.txt")){
                    System.out.println("找到b.txt");
                    return FileVisitResult.TERMINATE;
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("正在访问路径：" + dir);
                return FileVisitResult.CONTINUE;
            }
        });

    }
}
