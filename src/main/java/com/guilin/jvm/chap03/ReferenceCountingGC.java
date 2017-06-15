package com.guilin.jvm.chap03;

/**
 * Created by guilin on 2017/6/14.
 * 引用计数算法的缺陷
 */
public class ReferenceCountingGC {

    private static final int _1MB = 1024 * 1024;
    public Object instance = null;
    /**
     * 这个成员属性的意义是占点内存，以便在GC日志中看清楚是否被回收过
     */
    private byte[] bigSize = new byte[3 * _1MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        //假设在这行发生GC，objA和objB是否能被回收？
        System.gc();
    }

    public static void main(String[] args) {
        //VM option
        //-XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms12m -Xmx12m
        testGC();
    }
}
/*
运行结果：
2017-06-14T16:36:53.257+0800: [GC [PSYoungGen: 1327K->488K(3584K)] 7471K->6736K(11776K), 0.0107447 secs] [Times: user=0.05 sys=0.00, real=0.01 secs]
2017-06-14T16:36:53.268+0800: [Full GC [PSYoungGen: 488K->0K(3584K)] [ParOldGen: 6248K->534K(8192K)] 6736K->534K(11776K) [PSPermGen: 2935K->2934K(21504K)], 0.0115199 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
Heap
 PSYoungGen      total 3584K, used 153K [0x00000000ffc00000, 0x0000000100000000, 0x0000000100000000)
  eden space 3072K, 5% used [0x00000000ffc00000,0x00000000ffc26738,0x00000000fff00000)
  from space 512K, 0% used [0x00000000fff00000,0x00000000fff00000,0x00000000fff80000)
  to   space 512K, 0% used [0x00000000fff80000,0x00000000fff80000,0x0000000100000000)
 ParOldGen       total 8192K, used 534K [0x00000000ff400000, 0x00000000ffc00000, 0x00000000ffc00000)
  object space 8192K, 6% used [0x00000000ff400000,0x00000000ff485970,0x00000000ffc00000)
 PSPermGen       total 21504K, used 2941K [0x00000000fa200000, 0x00000000fb700000, 0x00000000ff400000)
  object space 21504K, 13% used [0x00000000fa200000,0x00000000fa4df550,0x00000000fb700000)

  GC日志中包含Full GC，意味着虚拟机并没有因为这两个对象相引用就不回收它们，这也从侧面说明虚拟机并不是通过引用计数算法来判断对象是否存活的。
 */
