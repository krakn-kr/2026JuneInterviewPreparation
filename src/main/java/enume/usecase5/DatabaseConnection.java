package enume.usecase5;

public enum DatabaseConnection {
    INSTANCE; // The one and only instance

    public void connect() {
        System.out.println("Connected to the database!");
    }
}

class Main{
    public static void main(String[] args) {
        // Usage
        DatabaseConnection.INSTANCE.connect();
    }
}