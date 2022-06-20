module com.tugalsan.api.profile {
    requires java.sql;
    requires javax.servlet.api;
    requires javamelody.core;
    requires com.tugalsan.api.url;
    exports com.tugalsan.api.profile.server.melody;
}
