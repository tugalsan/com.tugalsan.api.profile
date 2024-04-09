package com.tugalsan.api.profile.server.melody;

import java.sql.*;
import javax.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import net.bull.javamelody.*;
import com.tugalsan.api.profile.client.*;
import com.tugalsan.api.union.client.TGS_Union;

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

    public static TGS_Union<Connection> createProxy(Connection con) {
        try {
            DriverManager.registerDriver(new net.bull.javamelody.JdbcDriver());
            return TGS_Union.of(JdbcWrapper.SINGLETON.createConnectionProxy(con));
        } catch (SQLException ex) {
            return TGS_Union.ofExcuse(ex);
        }
    }

    public static TGS_Union<DataSource> createProxy(DataSource ds) {
        try {
            DriverManager.registerDriver(new net.bull.javamelody.JdbcDriver());
            return TGS_Union.of(JdbcWrapper.SINGLETON.createDataSourceProxy(ds));
        } catch (SQLException ex) {
            return TGS_Union.ofExcuse(ex);
        }
    }
}
