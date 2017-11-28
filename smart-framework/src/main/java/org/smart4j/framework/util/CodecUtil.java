package org.smart4j.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 解码或者编码工具类
 * Created by wh1te on 2017/11/28.
 */
public final class CodecUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(CodecUtil.class);

    /**
     * 将URL编码
     */
    public static String encodeURL (String source){
        String target = null;
        try {
            target = URLEncoder.encode(source,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            LOGGER.error("encode url is fail",e);
        }
        return target;
    }

    /**
     * 将URL解码
     */
    public static String decodeURL(String source){
        String target = null;
        try {
            target= URLDecoder.decode(source,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            LOGGER.error("decode url is fail",e);
        }
        return target;
    }
}
