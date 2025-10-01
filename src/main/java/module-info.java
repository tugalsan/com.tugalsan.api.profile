module com.tugalsan.api.profile {
    requires java.sql;
    requires javax.servlet.api;
    requires javamelody.core;
    requires com.tugalsan.api.url;    
    requires com.tugalsan.api.union;
    requires com.tugalsan.api.function;
    exports com.tugalsan.api.profile.client;
    exports com.tugalsan.api.profile.server.melody;
}
