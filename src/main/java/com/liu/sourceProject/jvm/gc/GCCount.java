package com.liu.sourceProject.jvm.gc;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * @author liu
 * @Date 2020/8/21 11:36
 */
public class GCCount {
    public static void main(String[] args) {
        GCCount count = new GCCount();
        GCCount.reportGc();

    }
    public static void reportGc(){
        List<GarbageCollectorMXBean> gcs = ManagementFactory.getGarbageCollectorMXBeans();
        System.out.println(gcs.size());
    }
}
