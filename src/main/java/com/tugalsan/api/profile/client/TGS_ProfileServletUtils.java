package com.tugalsan.api.profile.client;

import com.tugalsan.api.union.client.TGS_UnionExcuse;
import com.tugalsan.api.url.client.TGS_Url;
import com.tugalsan.api.url.client.parser.*;

public class TGS_ProfileServletUtils {

    final public static String SERVLET_NAME = "monitoring";//HARD-CODED IN LIB, THIS CANNOT BE CHANGED!

    public static TGS_UnionExcuse<TGS_UrlParser> URL_SERVLET(TGS_Url url) {
        var u_urlMonitoring = TGS_UrlParser.of(url);
        if (u_urlMonitoring.isExcuse()) {
            return u_urlMonitoring;
        }
        u_urlMonitoring.value().path.fileOrServletName = TGS_ProfileServletUtils.SERVLET_NAME;
        var appName = u_urlMonitoring.value().path.paths.get(0);
        u_urlMonitoring.value().path.paths.clear();
        u_urlMonitoring.value().path.paths.add(appName);
        u_urlMonitoring.value().quary.params.clear();
        u_urlMonitoring.value().anchor.value = null;
        return u_urlMonitoring;
    }
}
