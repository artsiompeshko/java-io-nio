package com.apeshko.fastfilemover;

import com.apeshko.fastfilemover.model.PerfTestArgs;
import com.apeshko.fastfilemover.services.FastFileMover;
import com.apeshko.fastfilemover.services.FastFileMoverPerfTest;
import com.apeshko.fastfilemover.services.impl.*;

import java.io.IOException;

public class FastFileMoverApp {
    public static void main(String[] args) throws IOException {
        FastFileMover fileStreamsFastFileMover = new FileStreamsFastFileMover();
        FastFileMover bufferedFileStreamsFastFileMover = new BufferedFileStreamsFastFileMover();
        FastFileMover fileChannelFastFileMover = new FileChannelFastFileMover();
        FastFileMover nio2FileApiFastMover = new NioFileApiFastFileMover();

        // TODO: validate args
        String filePath = args[0];
        String nextFilePath = args[1];

        fileStreamsFastFileMover.move(filePath, nextFilePath);
        bufferedFileStreamsFastFileMover.move(filePath, nextFilePath);
        fileChannelFastFileMover.move(filePath, nextFilePath);
        nio2FileApiFastMover.move(filePath, nextFilePath);

//        PerfTestArgs perfTestArgs = new PerfTestArgs("C:\\test-from\\sm", "C:\\test-from\\md", "C:\\test-from\\lg", "C:\\test-from\\xl");
//        FastFileMoverPerfTest fastFileMoverPerfTest = new FastFileMoverPerfTestImpl();

//        System.out.println("FileStreams " + fastFileMoverPerfTest.measure(fileStreamsFastFileMover, perfTestArgs) / 1000 + "s");
//        System.out.println("FileStreams with buffer 100 kb " + fastFileMoverPerfTest.measure(bufferedFileStreamsFastFileMover, perfTestArgs) / 1000 + "s");
//        System.out.println("FileChannel " + fastFileMoverPerfTest.measure(fileChannelFastFileMover, perfTestArgs) / 1000 + "s");
//        System.out.println("NIO 2 File API " + fastFileMoverPerfTest.measure(nio2FileApiFastMover, perfTestArgs) / 1000 + "s");
    }
}
