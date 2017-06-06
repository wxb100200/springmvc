package org.hz.wang.util;

import java.util.Arrays;
import java.util.List;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.text.json.JsonContext;




public class ApiResult {
	private static JsonContext jsonContext = Ebean.createJsonContext();
	private String api;
    private String ret;
    private String v;
    private List<Object> data;
    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }


    public static ApiResult single(String api, Object obj){
        return list(api, Arrays.asList(new Object[]{obj}));
    }
    public static ApiResult list(String api, List list){
        return multiple(true,api,list,list.size(),"200",null);
    }
    public static ApiResult error(String api, String errorCode, String errorMessage){
        return multiple(false,api,null,0,errorCode,errorMessage);
    }
    public static ApiResult error(String api, String errorCode, Throwable exception){
        return multiple(false,api,null,0,errorCode,exception.getMessage()+"��������");
    }
    private static ApiResult multiple(boolean success , String api, List list, int total, String errorCode, String errorMessage){
        ApiResult result=new ApiResult();
        if(success){
            result.api=api;
            result.ret="{\"code\":\"200\",\"msg\":\"\"}";
            result.data=list;
            result.v="";
        }else{
            result.api=api;
            result.ret="{\"code\":"+errorCode+",\"msg\":"+errorMessage+"}";
            result.v="";
        }
        return result;
    }

    public  String toJson() {
        return "{\"api\":\""+api+"\",\"data\":"+jsonContext.toJsonString(data)+",\"ret\":"+ret+",\"v\":\""+v+"\"}";
    }
}
