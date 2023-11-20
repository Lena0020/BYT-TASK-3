package org.example;

public class Main {
    public static void main(String[] args) {
        // create a connection pool with a maximum size of 3
        ConnectionPool connectionPool = new ConnectionPool(3);

        // borrow and return connections
        Connection connection1 = connectionPool.borrowObject();
        connection1.executeQuery("SELECT * FROM customers");
        connectionPool.returnObject(connection1);

        Connection connection2 = connectionPool.borrowObject();
        connection2.executeQuery("INSERT INTO orders VALUES (1, 'Product A')");
        connectionPool.returnObject(connection2);

        Connection connection3 = connectionPool.borrowObject();
        connection3.executeQuery("UPDATE products SET price = 50");
        connectionPool.returnObject(connection3);

        // borrow more connections than the pool size to demonstrate creating new connections
        Connection connection4 = connectionPool.borrowObject();
        connection4.executeQuery("DELETE FROM customers WHERE id = 5");
        connectionPool.returnObject(connection4);
    }
}