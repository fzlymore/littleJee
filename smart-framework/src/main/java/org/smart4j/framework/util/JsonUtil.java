package org.smart4j.framework.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * json工具类
 * Created by wh1te on 2017/11/28.
 */
public  final class JsonUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);
    private static final ObjectMapper  OBJECT_MAPPER = new ObjectMapper();

    /**
     * 将pojo转化为json
     */
    public static <T>String toJson(T obj){
        String json = null;
        try {
            json = OBJECT_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            LOGGER.error("to json is fail",e);
        }
        return json;
    }

    /**
     * 将json转为pojo
     */
    public static <T>T fromjson(String json,Class<T> type){
            T pojo = null;
        try {
            pojo = OBJECT_MAPPER.readValue(json,type);
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("to pojo is fail",e);
        }
        return pojo;
    }
}
