package com.tugalsan.api.profile.server.melody;

import com.tugalsan.api.function.client.maythrowexceptions.checked.TGS_FuncMTCUtils;
import java.sql.*;
import javax.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import net.bull.javamelody.*;
import com.tugalsan.api.profile.client.*;
import com.tugalsan.api.union.client.TGS_UnionExcuse;


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

    public static TGS_UnionExcuse<Connection> createProxy(Connection con) {
        return TGS_FuncMTCUtils.call(() -> {
            DriverManager.registerDriver(new net.bull.javamelody.JdbcDriver());
            return TGS_UnionExcuse.of(JdbcWrapper.SINGLETON.createConnectionProxy(con));
        }, e -> {
            return TGS_UnionExcuse.ofExcuse(e);
        });
    }

    public static TGS_UnionExcuse<DataSource> createProxy(DataSource ds) {
        return TGS_FuncMTCUtils.call(() -> {
            DriverManager.registerDriver(new net.bull.javamelody.JdbcDriver());
            return TGS_UnionExcuse.of(JdbcWrapper.SINGLETON.createDataSourceProxy(ds));
        }, e -> {
            return TGS_UnionExcuse.ofExcuse(e);
        });
    }
}
