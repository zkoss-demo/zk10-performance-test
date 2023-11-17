package org.zkoss.test;

import org.zkoss.bind.annotation.*;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventQueue;
import org.zkoss.zk.ui.event.EventQueues;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.ListModelList;

import java.util.*;
import java.util.List;

public class ClearItemsVM {

    private ListModelList<String> model = new ListModelList<>();
    private List dataList = new LinkedList();
    public ClearItemsVM() {
        for (int i = 0; i < 2000; i++) {
            dataList.add("item"+ i);
        }
    }

    private Component root;
    @AfterCompose
    public void findRoot(@ContextParam(ContextType.VIEW) Component component){
        this.root = component;
    }

    @Command
    public void fill() {
        model.addAll(dataList);
        Events.echoEvent("onSentTime", root, null ); //send client complete time back to performance meter
    }
    @Command
    public void clear() {
        model.clear();
        Events.echoEvent("onSentTime", root, null ); //send client complete time back to performance meter
    }

    public ListModelList<String> getModel() {
        return model;
    }

    public void setModel(ListModelList<String> model) {
        this.model = model;
    }

}
