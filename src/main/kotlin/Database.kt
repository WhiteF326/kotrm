import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet

class Database(driverName: String, url: String, user: String, password: String) {
    private val connection: Connection
    init {
        try {
            Class.forName(driverName)
            connection = DriverManager.getConnection(url, user, password)
        } catch (e: ClassNotFoundException){
            throw RuntimeException(e)
        }
    }

    fun rawSelectQuery(queryString: String): ResultSet {
        val st = connection.createStatement()

        return st.executeQuery(queryString)
    }
}