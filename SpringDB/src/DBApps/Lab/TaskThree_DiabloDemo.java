package DBApps.Lab;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class TaskThree_DiabloDemo {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username default (root): ");
        String user = sc.nextLine();
        user = user.equals("") ? "root" : user;
        System.out.println();

        System.out.print("Enter password default (empty):");
        String password = sc.nextLine().trim();
        System.out.println();

//        Connection connection = getMySQLConnection();
        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/diablo", props);
//        return connection;
        PreparedStatement stmt =
                connection.prepareStatement(
                        "SELECT user_name, first_name, last_name, count(ug.game_id)\n" +
                                "FROM users as u\n" +
                                "         JOIN users_games as ug on ug.user_id = u.id and user_name = ? \n" +
                                "group by user_name, first_name, last_name;"
                );

        String username = sc.nextLine();
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();
        boolean hasRow = rs.next();
        if (hasRow) {
            System.out.printf(
                    "User: %s\n%s %s has played %d games", username, rs.getString("first_name"),
                    rs.getString("last_name"), rs.getInt(4));
        } else {
            System.out.println("No such user exists");
        }
        connection.close();
    }
    }

//    private static Connection getMySQLConnection() throws SQLException {
//        Properties props = new Properties();
//        props.setProperty("user", "root");
//        props.setProperty("password", "*****");
//
//        Connection connection = DriverManager
//                .getConnection("jdbc:mysql://localhost:3306/diablo", props);
//        return connection;
//    }
//}


