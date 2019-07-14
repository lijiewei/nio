package com.ljw.nio.nio2;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Description:
 * @Author: Administrator
 * @CreateDate: 2019/7/14 18:40
 */
public class PathTest {

    @Test
    public void PathTest() {
        Path path = Paths.get(".");
        System.out.println(path.getNameCount());
        System.out.println(path.getRoot());
        Path absolutePath = path.toAbsolutePath();
        System.out.println(absolutePath);
        System.out.println(absolutePath.getRoot());
        System.out.println(absolutePath.getNameCount());
        System.out.println(absolutePath.getName(2));
        Path path1 = Paths.get("J:", "aa", "bb");
        System.out.println(path1);
    }
}
