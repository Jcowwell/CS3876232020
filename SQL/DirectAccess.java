import java.sql.*;


public class DirectAccess {

  private Statement statement;
  private Connection connection;

  public DirectAccess(Connection connection) throws Exception {
      this.connection = connection;
  }

  protected ResultSet execute(String sql) throws Exception {
     //connection.startConnection();
     statement = connection.createStatement();
     return statement.executeQuery(sql);
  }
  
  
  protected void delete(String sql) throws Exception {
	     //connection.startConnection();
	     statement = connection.createStatement();
	     statement.executeUpdate(sql);
	     System.out.println("Delete Succesfull");
	     //connection.endConnection();
  }
  

}
