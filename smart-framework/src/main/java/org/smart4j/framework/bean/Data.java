package org.smart4j.framework.bean;

/**
 * 返回数据对象
 * Created by wh1te on 2017/11/28.
 */
public class Data {
    /**
     * 数据模型
     */
    private Object model;

    public Data(Object model){
        this.model=model;
    }

    public Object getModel(){
        return model;
    }

}
