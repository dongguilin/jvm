package com.guilin.jvm.chap03;

/**
 * Created by guilin on 2017/6/16.
 * 空间分配担保
 * 在JDK 6 Update 24后，HandlePromotionFailure参数废弃，规则变为只要老年代的连续空间大于新生代对象总大小或者历次晋升的
 * 平均大小就会进行Minor GC，否则将进行Full GC
 */
public class HandlePromotion {

    private static final int _1MB = 1024 * 1024;

    /**
     * VM参数：-Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:-HandlePromotionFailure
     *
     * @param args
     */
    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6, allocation7;

        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation1 = null;
        allocation4 = new byte[2 * _1MB];
        allocation5 = new byte[2 * _1MB];
        allocation6 = new byte[2 * _1MB];
        allocation4 = null;
        allocation5 = null;
        allocation6 = null;
        allocation7 = new byte[2 * _1MB];
    }

}
