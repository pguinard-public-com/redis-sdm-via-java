package com.matadorapp;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

import java.time.Duration;

public class RedisExample {
    public static void main(String[] args) {
        RedisURI uri = RedisURI.Builder
                .redis("localhost", 10044)
                .withTimeout(Duration.ofSeconds(3))
                .build();

        RedisClient client = RedisClient.create(uri);
        StatefulRedisConnection<String, String> connection = client.connect();
        System.out.println("Connected to Redis");
        RedisCommands<String, String> commands = connection.sync();

        commands.set("foo", "bar");
        String result = commands.get("foo");
        System.out.println("Got from Redis: " + result);

        connection.close();
        client.shutdown();
    }
}
