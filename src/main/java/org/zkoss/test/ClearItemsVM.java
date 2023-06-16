package org.zkoss.test;

import org.zkoss.bind.annotation.*;
import org.zkoss.zul.ListModelList;

import java.util.*;

public class ClearItemsVM {
    private ListModelList<List<Map<String,String>>> model = new ListModelList<>();

    @Command
    public void fill() {
        for (int i = 0; i < 2000; i++) {
            List<Map<String,String>> row = new ArrayList<Map<String,String>>();
            for (int j = 0; j < 10; j++) {
                HashMap<String, String> data = new HashMap<String, String>();
                data.put("data", "item-"+i+"-"+j);
                row.add(data);
            }
            model.add(row);
        }
    }
    @Command
    public void clear() {
        model.clear();
    }

    public ListModelList<List<Map<String,String>>> getModel() {
        return model;
    }

    public void setModel(ListModelList<List<Map<String,String>>> model) {
        this.model = model;
    }

}
