package org.zkoss.test;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.util.Initiator;

import java.util.Map;

/**
 * turn all query string parameters into desktop attributes
 */
public class QueryStringParameterToDesktopAttribute implements Initiator {

    @Override
    public void doInit(Page page, Map<String, Object> args) throws Exception {
        Executions.getCurrent().getParameterMap().keySet().stream().forEach(key ->{
            page.getDesktop().setAttribute(key, Executions.getCurrent().getParameter(key));
        });
    }
}
