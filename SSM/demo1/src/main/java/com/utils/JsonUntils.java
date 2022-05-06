package com.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * @date 2021/10/25 -16:20
 */
public class JsonUntils {
    // 定义jackson对象
  private static final ObjectMapper MAPPER = new ObjectMapper();
    /**
     * 将对象转换成json字符串。
     * <p>Title: pojoToJson</p>
     * <p>Description: </p>
     *
     * @param data
     * @return
     */
     public static String objectToJson(Object data) {
         try {
                 String string = MAPPER.writeValueAsString(data);
                 return string;
              } catch (JsonProcessingException e) {
                 e.printStackTrace();
              }
        return null;
       }

 /**
  * 将json结果集转化为对象
   *
 * @param jsonData json数据
  * @param beanType 对象中的object类型
   * @return
    */
   public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
      try {
          T t = MAPPER.readValue(jsonData, beanType);
            return t;
       } catch (Exception e) {
            e.printStackTrace();
      }
          return null;
   }
  /**
   * 将json数据转换成pojo对象list
  * <p>Title: jsonToList</p>
   * <p>Description: </p>
  65      *
  66      * @param jsonData
  67      * @param beanType
  68      * @return
  69      */
        public static <T> List<T> jsonToList(String jsonData, Class<T> beanType) {
     JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
    try {
            List<T> list = MAPPER.readValue(jsonData, javaType);
           return list;
     } catch (Exception e) {
             e.printStackTrace();
      }
         return null;
       }
}
