public class DatabaseConnection {
    private static DatabaseConnection databaseConnection;
    private DatabaseConnection(){};
    public static synchronized  DatabaseConnection getInstance(){
        if(databaseConnection == null){
            databaseConnection = new DatabaseConnection();

        }
        return databaseConnection;
    }

    public static void main(String[] args){
        DatabaseConnection databaseConnection1 = DatabaseConnection.getInstance();

    }
}
