package DBApps.Exercise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class T7_PrintMinionsNames {
    private static final String GET_ALL_MINIONS = "select name from minions_db.minions";

    public static void main(String[] args) throws SQLException {
        final Connection sqlConnection = Utils.getSqlConnection();

        final PreparedStatement statement = sqlConnection.prepareStatement(GET_ALL_MINIONS,
                // WE WANT THE RESULTS TO BE RETURNED IN THE SAME WAY AS THEY APPEAR IN THE DATABASE
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                // WE WILL ONLY READ THE INFORMATION FROM THE DATABASE
                ResultSet.CONCUR_READ_ONLY);

        final ResultSet minionsResultSet = statement.executeQuery();

        int minionsCount = 0;

        while (minionsResultSet.next()) minionsCount++;

        // WE MOVE THE CURSOR BACK TO BEFORE THE FIRST ENTRY IN THE RESULT SET AFTER THE COUNT
        minionsResultSet.beforeFirst();

        int firstIndex = 1;
        int lastIndex = minionsCount;

        for (int i = 1; i <= minionsCount ; i++) {
            if (i % 2 == 0) {
                minionsResultSet.absolute(firstIndex);
                firstIndex++;
            } else {
                minionsResultSet.absolute(lastIndex);
                lastIndex--;
            }

            System.out.println(minionsResultSet.getString("name"));

            minionsResultSet.next();
        }
    }
}
