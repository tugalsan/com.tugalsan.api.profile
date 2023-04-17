module com.tugalsan.api.profile {
    requires java.sql;
    requires javax.servlet.api;
    requires javamelody.core;
    requires com.tugalsan.api.url;
    requires com.tugalsan.api.unsafe;
    requires com.tugalsan.api.callable;
    exports com.tugalsan.api.profile.server.melody;
}
