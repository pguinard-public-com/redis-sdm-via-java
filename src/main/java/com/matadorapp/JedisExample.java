package com.matadorapp;

import redis.clients.jedis.Jedis;

public class JedisExample {
    public static void main(String[] args) {
        try (Jedis jedis = new Jedis("localhost", 10044)) {
            jedis.set("foo", "bar");
            String value = jedis.get("foo");
            long keyslot = jedis.clusterKeySlot("a");
            System.out.println("Value from Redis: " + value);
            System.out.println("Keys slot: " + keyslot);
        } catch (Exception e) {
            System.err.println("Could not connect to Redis: " + e.getMessage());
        }
    }
}
