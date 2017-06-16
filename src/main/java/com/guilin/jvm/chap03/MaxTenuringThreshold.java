package com.guilin.jvm.chap03;

/**
 * Created by guilin on 2017/6/15.
 * 长期存活的对象进入老年代
 * ???
 */
public class MaxTenuringThreshold {

    private static final int _1MB = 1024 * 1024;

    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
     *
     * @param args
     */
    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[_1MB / 4];
        //什么时候进入老年代取决于XX:MaxTenuringThreshold设置
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }

    /*
[GC[DefNew
Desired survivor size 524288 bytes, new threshold 1 (max 1)
- age   1:     816528 bytes,     816528 total
: 6031K->797K(9216K), 0.0044045 secs] 6031K->4893K(19456K), 0.0044375 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[GC[DefNew
Desired survivor size 524288 bytes, new threshold 1 (max 1)
- age   1:        336 bytes,        336 total
: 5061K->0K(9216K), 0.0013955 secs] 9157K->4887K(19456K), 0.0014115 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
Heap
 def new generation   total 9216K, used 4234K [0x00000000f9a00000, 0x00000000fa400000, 0x00000000fa400000)
  eden space 8192K,  51% used [0x00000000f9a00000, 0x00000000f9e227d0, 0x00000000fa200000)
  from space 1024K,   0% used [0x00000000fa200000, 0x00000000fa200150, 0x00000000fa300000)
  to   space 1024K,   0% used [0x00000000fa300000, 0x00000000fa300000, 0x00000000fa400000)
 tenured generation   total 10240K, used 4887K [0x00000000fa400000, 0x00000000fae00000, 0x00000000fae00000)
   the space 10240K,  47% used [0x00000000fa400000, 0x00000000fa8c5e50, 0x00000000fa8c6000, 0x00000000fae00000)
 compacting perm gen  total 21248K, used 3016K [0x00000000fae00000, 0x00000000fc2c0000, 0x0000000100000000)
   the space 21248K,  14% used [0x00000000fae00000, 0x00000000fb0f2028, 0x00000000fb0f2200, 0x00000000fc2c0000)
No shared spaces configured.
     */


}
