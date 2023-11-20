package org.example;

import java.util.LinkedList;
import java.util.Queue;

class ConnectionPool implements ObjectPool<Connection> {
    private final Queue<Connection> pool;
    private final int maxSize;

    public ConnectionPool(int maxSize) {
        this.maxSize = maxSize;
        this.pool = new LinkedList<>();

        // initializing the pool with connections
        for (int i = 0; i < maxSize; i++) {
            pool.add(createConnection("Connection-" + (i + 1)));
        }
    }

    @Override
    public Connection borrowObject() {
        if (pool.isEmpty()) {
            System.out.println("No available connections. Creating a new connection.");
            return createConnection("New Connection");
        } else {
            System.out.println("Borrowing a connection from the pool.");
            return pool.poll();
        }
    }

    @Override
    public void returnObject(Connection connection) {
        if (pool.size() < maxSize) {
            System.out.println("Returning a connection to the pool.");
            pool.add(connection);
        } else {
            System.out.println("Pool is full. Discarding the returned connection.");
        }
    }

    private Connection createConnection(String connectionId) {
        // simulating expensive resource creation
        System.out.println("Creating a new connection: " + connectionId);
        return new Connection(connectionId);
    }
}