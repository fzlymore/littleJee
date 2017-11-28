package org.smart4j.framework.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回试图对象
 * Created by wh1te on 2017/11/28.
 */
public class View {
    /**
     * 视图路径
     */
    private String path;

    /**
     * 模型路径
     */
    private Map<String,Object> model;

    public View(String path){
        this.path=path;
        model = new HashMap<>();
    }

    public View addModel(String key,Object value){
        model.put(key,value);
        return this;
    }

    public String getPath(){
        return path;
    }

    public Map<String,Object> getModel(){
        return model;
    }
}
