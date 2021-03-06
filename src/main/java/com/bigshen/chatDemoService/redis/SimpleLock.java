package com.bigshen.chatDemoService.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.UUID;

/**
 * @ClassName SimpleLock
 * @Description: TODO
 * @Author BYJ
 * @Date 2020/9/6
 * @Version V1.0
 **/
public class SimpleLock {
    private final String LOCK_NAME = "lock";
    Jedis conn = new Jedis("127.0.0.1", 6379);

    /**
     * 获取分布式锁
     *
     * @return
     */
    private String accquireLock(int timeout) {
        String uuid = UUID.randomUUID().toString();
        long end = System.currentTimeMillis();
        //设置为可重入锁
        while (System.currentTimeMillis() > end) {
            if (conn.setnx(LOCK_NAME, uuid).intValue() == 1) {
                conn.expire(LOCK_NAME, timeout);
                return uuid;
            }
            if (conn.ttl(LOCK_NAME) == -1) {
                conn.expire(LOCK_NAME, timeout);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 释放分布式锁
     *
     * @param uuid
     *
     * @return
     */
    private Boolean releaseLock(String uuid) {
        while (true) {
            conn.watch(LOCK_NAME);
            if (uuid.equals(conn.get(LOCK_NAME))) {
                Transaction transaction = conn.multi();
                transaction.del(LOCK_NAME);
                if (transaction.exec() == null) {
                    continue;
                }
                return true;
            }
            conn.unwatch();
            break;
        }
        return false;
    }

    public static void main(String[] args) {
        SimpleLock simpleLock = new SimpleLock();
        String uuid = simpleLock.accquireLock(100000);
        if (uuid != null) {
            System.out.println("获取锁成功");
        } else {
            System.out.println("获取锁失败......");
        }

    }
}
