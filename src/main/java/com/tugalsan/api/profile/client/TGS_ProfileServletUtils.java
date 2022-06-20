package com.tugalsan.api.profile.client;

import com.tugalsan.api.url.client.parser.*;

public class TGS_ProfileServletUtils {

    final public static String SERVLET_NAME = "monitoring";//HARD-CODED IN LIB, THIS CANNOT BE CHANGED!

    public static TGS_UrlParser URL_SERVLET(CharSequence url) {
        var urlMonitoring = TGS_UrlParser.of(url);
        urlMonitoring.path.fileOrServletName = TGS_ProfileServletUtils.SERVLET_NAME;
        var appName = urlMonitoring.path.paths.get(0);
        urlMonitoring.path.paths.clear();
        urlMonitoring.path.paths.add(appName);
        urlMonitoring.quary.params.clear();
        urlMonitoring.anchor.value = null;
        return urlMonitoring;
    }
}
