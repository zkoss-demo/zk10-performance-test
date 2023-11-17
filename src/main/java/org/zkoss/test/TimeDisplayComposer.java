package org.zkoss.test;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Label;

import java.util.List;
import java.util.Optional;

public class TimeDisplayComposer extends SelectorComposer {

    @Listen("onSentTime = groupbox")
    public void displayTime(Event event){
        List<Component> components = Selectors.find(event.getTarget(), ".time-value");
        Label timeLabel = (Label) components.get(0);
        timeLabel.setValue(Optional.ofNullable(getPage().getDesktop().getAttribute("time")).map(Object::toString).orElse("x"));
    }
}
