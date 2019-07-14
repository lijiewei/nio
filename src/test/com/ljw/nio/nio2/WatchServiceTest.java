package com.ljw.nio.nio2;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.*;


/**
 * @Description:
 * @Author: Administrator
 * @CreateDate: 2019/7/14 20:54
 */
public class WatchServiceTest {

    @Test
    public void WatchServiceTest() throws Exception {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        Paths.get("J:\\aa").register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.ENTRY_DELETE);
        while(true){
            WatchKey key = watchService.take();
            key.pollEvents().forEach(event -> {
                System.out.println(event.context() + "文件发生了" + event.kind() + "事件");
            });
            boolean reset = key.reset();
            if(!reset){
                break;
            }
        }


    }
}
