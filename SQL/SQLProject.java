
public class SQLProject {
  public static void main(String[] args) {
    try {
    	
      Connection connect = new Connection("test", "pace", "123456");
      DirectAccess DAO = new DirectAccess(connect);
      connect.startConnection();
      // Use This to Show Table State
      //DBTablePrinter.printTable(connect, "Stock");
      
      // 1. SHOW STOCK, DEPOT, AND PRODUCT TABLE
      DBTablePrinter.printTable(connect, "Stock");
      DBTablePrinter.printTable(connect, "Depot");
      // 2. USE DIRECT ACCESS OBJECT'S delete METHOD TO DELETE FROM DEPOT. SINCE STOCK HAS A ON DELETE CASCADE CONSTRAINT, IT SHOULD DELETE FROM DEPOT TOO
      DAO.delete("DELETE FROM Stock WHERE dep_id = 'd1';");
      DAO.delete("DELETE FROM Depot WHERE dep_id = 'd1';");
      	 
      // 3. SHOW STOCK, DEPOT, AND PRODUCT TABLE AFTER DELETION QUERY
      DBTablePrinter.printTable(connect, "Stock");
      DBTablePrinter.printTable(connect, "Depot");
      
      connect.endConnection();

    }
    catch(Exception e) {
      System.out.println("Error: " + e);
    }
  }
}
