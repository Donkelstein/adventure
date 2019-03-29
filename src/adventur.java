import java.sql.*;

public class adventur {


        public static final String DEFAULT_DRIVER_CLASS = "com.mysql.jdbc.Driver";
        public static String hostname = "127.0.0.1";
        public static String dbName = "solo-nice";
        //public static int port = 3306;
        public static final String DEFAULT_URL = "jdbc:mysql://"+ hostname +"/"+dbName;
        private static final String DEFAULT_USERNAME = "felix";
        private static final String DEFAULT_PASSWORD = "hejhej123";

        public static void main(String[] args) {
            Connection connection = null;

            try {
                Class.forName(DEFAULT_DRIVER_CLASS);
                connection = DriverManager.getConnection(DEFAULT_URL, DEFAULT_USERNAME, DEFAULT_PASSWORD);

                // SQL queries goes here
                PreparedStatement ps = null;
                ResultSet rs = null;
                ps = connection.prepareStatement("SELECT * FROM story");
                rs = ps.executeQuery();

                while (rs.next()) {
                    String text = rs.getString("text");
                    int id = rs.getInt("id");
                    System.out.println(id + " , " + text);
                }

            } catch (SQLException e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {

            }
        }
    }
