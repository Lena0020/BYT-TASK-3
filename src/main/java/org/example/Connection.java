package org.example;

class Connection {
    // assuming some properties and methods related to a connection
    private final String connectionId;

    public Connection(String connectionId) {
        this.connectionId = connectionId;
    }

    public void executeQuery(String query) {
        System.out.println("Executing query '" + query + "' on connection " + connectionId);
    }
}
