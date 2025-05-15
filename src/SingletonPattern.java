class DBConnection{
    private static DBConnection connection;
    private DBConnection(){

    }
    static DBConnection getInstance(){
       if(connection==null){
         synchronized (DBConnection.class){
             if (connection==null){
                 return connection=new DBConnection();
             }
         }
       }
       return connection;
    }
    void showmessage(){
        System.out.println("it is singleton class? ");
    }
}
public class SingletonPattern {
    public static void main(String[] args) {
            DBConnection connection=DBConnection.getInstance();
            connection.showmessage();
    }
}
