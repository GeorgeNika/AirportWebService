package ua.george_nika.database.lookupimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class GlassFishConnection {

    public Connection getConnection() {

        Connection connection = null;
        Context context = null;
        Context initialContext = null;
        Properties properties = new Properties();
        properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
        properties.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
        properties.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");

        try {
            //try {
            context = new InitialContext();

            initialContext = new InitialContext(properties);
            DataSource dataSource = (DataSource) context.lookup("jdbc/glassfishrandomdata3");
            connection = dataSource.getConnection();
        } catch (NamingException ex) {
            Logger.getLogger(GlassFishConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GlassFishConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
}
