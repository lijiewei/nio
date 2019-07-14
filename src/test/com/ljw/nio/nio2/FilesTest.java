package com.ljw.nio.nio2;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: Administrator
 * @CreateDate: 2019/7/14 18:53
 */
public class FilesTest {

    @Test
    public void FilesTest() throws Exception {
        long copy = Files.copy(Paths.get("J:\\aa\\a.txt"), new FileOutputStream("J:\\aa\\b.txt"));
        System.out.println(copy);
        System.out.println(Files.isHidden(Paths.get("J:\\aa\\a.txt")));
        List<String> allLines = Files.readAllLines(Paths.get("J:\\aa\\a.txt"), Charset.forName("gbk"));
        System.out.println(allLines);

        System.out.println(Files.size(Paths.get("J:\\aa\\a.txt")));
        List<String> poem = List.of("水晶堂弟英语月", "情绪分钟比干粉");
        Files.write(Paths.get("J:\\aa\\c.txt"), poem, Charset.forName("gbk"));

        Files.list(Paths.get("J:\\aa")).forEach(path -> System.out.println(path));
        Files.lines(Paths.get("J:\\aa\\c.txt"), Charset.forName("gbk")).forEach(System.out::println);
        FileStore fileStore = Files.getFileStore(Paths.get("J:"));

        System.out.println(fileStore.getTotalSpace());
        System.out.println(fileStore.getUsableSpace());
    }
}
