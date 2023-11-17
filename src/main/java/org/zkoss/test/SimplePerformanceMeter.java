package org.zkoss.test;

import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.util.PerformanceMeter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SimplePerformanceMeter implements PerformanceMeter {
    Map<String, Long> timeRecord = new HashMap<>();

    @Override
    public void requestStartAtClient(String requestId, Execution exec, long time) {
        if (containsButtonClick(exec)) {
            System.out.printf("start client %s - %s\n", requestId, time);
            timeRecord.put(requestId, time);
        }
    }

    private boolean containsButtonClick(Execution exec) {
        Collection<String[]> values = exec.getParameterMap().values();
        for (String[] v : values){
            if (v[0].equals("onClick") || v[0].contains("$fill") || v[0].contains("$clear"))
                return true;
        }
        return false;
    }

    @Override
    public void requestReceiveAtClient(String requestId, Execution exec, long time) {

    }

    @Override
    public void requestCompleteAtClient(String requestId, Execution exec, long time) {
//        System.out.printf("complete client %s - %s\n", requestId, time);
        Long starTime = timeRecord.remove(requestId);
        if (starTime != null) {
            System.out.printf("request %s execution time: %s\n", requestId, time - starTime);
            exec.getDesktop().setAttribute("time", time - starTime);
        }
    }

    @Override
    public void requestStartAtServer(String requestId, Execution exec, long time) {

    }

    @Override
    public void requestCompleteAtServer(String requestId, Execution exec, long time) {

    }
}
