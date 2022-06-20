package com.tugalsan.api.profile.server.melody;

import java.sql.*;
import javax.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import net.bull.javamelody.*;
import com.tugalsan.api.profile.client.*;

public class TS_ProfileMelodyUtils {

    @WebFilter(
            filterName = TGS_ProfileServletUtils.SERVLET_NAME,
            dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.ASYNC},
            asyncSupported = true,
            urlPatterns = {"/*"},
            initParams = {
                @WebInitParam(name = "async-supported", value = "true")
            }
    )
    final public static class MelodyFilter extends MonitoringFilter {

    }

    @WebListener
    final public static class MelodyListener extends SessionListener {

    }

    public static Connection createProxy(Connection con) {
        try {
            DriverManager.registerDriver(new net.bull.javamelody.JdbcDriver());
            return JdbcWrapper.SINGLETON.createConnectionProxy(con);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static DataSource createProxy(DataSource ds) {
        try {
            DriverManager.registerDriver(new net.bull.javamelody.JdbcDriver());
            return JdbcWrapper.SINGLETON.createDataSourceProxy(ds);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
