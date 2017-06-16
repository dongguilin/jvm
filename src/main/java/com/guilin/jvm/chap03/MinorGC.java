package com.guilin.jvm.chap03;

/**
 * Created by guilin on 2017/6/15.
 * 新生代Minor GC
 */
public class MinorGC {

    private static final int _1MB = 1024 * 1024;

    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];//出现一次Minor GC
    }

    public static void main(String[] args) {
        testAllocation();
    }

    /*
    [GC[DefNew: 7823K->541K(9216K), 0.0042491 secs] 7823K->6685K(19456K), 0.0042844 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
Heap
 def new generation   total 9216K, used 4887K [0x00000000f9a00000, 0x00000000fa400000, 0x00000000fa400000)
  eden space 8192K,  53% used [0x00000000f9a00000, 0x00000000f9e3e5f8, 0x00000000fa200000)
  from space 1024K,  52% used [0x00000000fa300000, 0x00000000fa387760, 0x00000000fa400000)
  to   space 1024K,   0% used [0x00000000fa200000, 0x00000000fa200000, 0x00000000fa300000)
 tenured generation   total 10240K, used 6144K [0x00000000fa400000, 0x00000000fae00000, 0x00000000fae00000)
   the space 10240K,  60% used [0x00000000fa400000, 0x00000000faa00030, 0x00000000faa00200, 0x00000000fae00000)
 compacting perm gen  total 21248K, used 3084K [0x00000000fae00000, 0x00000000fc2c0000, 0x0000000100000000)
   the space 21248K,  14% used [0x00000000fae00000, 0x00000000fb1039e8, 0x00000000fb103a00, 0x00000000fc2c0000)
No shared spaces configured.
     */

}
