package com.guilin.jvm.chap03;

/**
 * Created by guilin on 2017/6/15.
 * 大对象直接进入老年代
 * PretenureSizeThreshold参数只对Serial和ParNew两款收集器有效，
 * Parallel Scavenge收集器不认识这个参数，Parallel Scavenge收集器一般并不需要设置。
 * 如果遇到必须使用此参数的场合，可以考虑ParNew+CMS的收集器组合
 */
public class PretenureSizeThreshold {

    private static final int _1MB = 1024 * 1024;

    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
     *
     * @param args
     */
    public static void main(String[] args) {
        byte[] allocation;
        allocation = new byte[4 * _1MB];//直接分配在老年代中
    }
    /*
    Heap
 def new generation   total 9216K, used 1843K [0x00000000f9a00000, 0x00000000fa400000, 0x00000000fa400000)
  eden space 8192K,  22% used [0x00000000f9a00000, 0x00000000f9bcccb0, 0x00000000fa200000)
  from space 1024K,   0% used [0x00000000fa200000, 0x00000000fa200000, 0x00000000fa300000)
  to   space 1024K,   0% used [0x00000000fa300000, 0x00000000fa300000, 0x00000000fa400000)
 tenured generation   total 10240K, used 4096K [0x00000000fa400000, 0x00000000fae00000, 0x00000000fae00000)
   the space 10240K,  40% used [0x00000000fa400000, 0x00000000fa800010, 0x00000000fa800200, 0x00000000fae00000)
 compacting perm gen  total 21248K, used 3011K [0x00000000fae00000, 0x00000000fc2c0000, 0x0000000100000000)
   the space 21248K,  14% used [0x00000000fae00000, 0x00000000fb0f0d78, 0x00000000fb0f0e00, 0x00000000fc2c0000)
No shared spaces configured
     */
}
