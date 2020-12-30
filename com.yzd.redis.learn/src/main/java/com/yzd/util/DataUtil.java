package com.yzd.util;

import java.util.Arrays;

/**
 * @Author: yaozh
 * @Description:
 */

public class DataUtil {
    private static final String DATA_5K = getMockData(5120);
    private static final String DATA_1K = getMockData(1024);
    private static final String DATA_10K = getMockData(102400);
    private static final String DATA_1MB = getMockData(1048576);

    private DataUtil() {
    }


    /**
     * 获得模拟的请求数据包
     * 4MB=1024*1024*4
     *
     * @param size
     * @return
     */
    public static String getMockData(int size) {
        byte[] b = new byte[size];
        //二进制0
        Arrays.fill(b, (byte) 0);
        return new String(b);
    }

    public static String getCacheMockData(int size) {
        switch (size) {
            case 1024:
                return DATA_1K;
            case 5120:
                return DATA_5K;
            case 102400:
                return DATA_10K;
            case 1048576:
                return DATA_1MB;
            default:
                return getMockData(size);
        }
    }
}
