import java.sql.*;

public class Connection {

  private String servername = " ";
  private String username = " ";
  private String password = " ";
  private final String DEFAULT_SERVERNAME = " ";
  private final String DEFAULT_USERNAME = " ";
  java.sql.Connection connection;


  /**
    * Connects with a inputed server with user's username and password credentials.
    *
    * @param
    * @return
    *
  */
  public Connection(String servername, String username, String password) {
    this.servername = servername;
    this.username = username;
    this.password = password;
  }

  /**
    * Connects with the DEFAULT server with user's username and password credentials.
    *
    * @param
    * @return
    *
  */
  public Connection(String username, String password) {
    this.servername = DEFAULT_SERVERNAME;
    this.username = username;
    this.password = password;
  }

  /**
    * Connects with the DEFAULT server with the DEFUALT username and user's password credentials.
    *
    * @param
    * @return
    *
  */
  public Connection(String password) {
    this.servername = DEFAULT_SERVERNAME;
    this.username = DEFAULT_USERNAME;
    this.password = password;
  }

  /**
    * Public Method to starts MySQL Connection
    *
    * @param
    * @return
    *
  */
  public void startConnection() throws Exception {
    connect(servername, username, password);
  }

  /**
    * Private Method to start connection to MySQL server
    *
    * @param
    * @return
    *
  */
  private void connect(String servername, String username, String password) throws Exception {
      Class.forName("com.mysql.jdbc.Driver");
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + servername, username, password);
  }

  public Statement createStatement() throws SQLException {
    return connection.createStatement();
  }

  public void commit() throws SQLException {
    connection.commit();
  }

  /**
    * Private Method to close connection to MySQL server
    *
    * @param
    * @return
    *
  */
  public void endConnection() throws SQLException {
      connection.close();
  }
  
  public boolean isClosed() throws SQLException {
	  // TODO Auto-generated method stub
	  return connection.isClosed();
  }
}
