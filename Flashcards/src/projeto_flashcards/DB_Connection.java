package projeto_flashcards;

public class DB_Connection {
    private static DB_Connection instance;
    
    private DB_Connection() {
        System.out.println("Conexão com o banco de dados estabelecida.");
    }
    
    public static DB_Connection getInstance() {
        if (instance == null) {
            instance = new DB_Connection();
        }
        return instance;
    }
}
