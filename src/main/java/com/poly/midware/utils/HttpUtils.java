package com.poly.midware.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.security.cert.CertificateException;
import javax.security.cert.X509Certificate;

/**
 * http请求工具类
 *
 * @author lcs
 */
public class HttpUtils {
    public static HttpClient wrapClient(HttpClient base) {
        try {
            SSLContext ctx = SSLContext.getInstance("TLS");
            X509TrustManager tm = new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                }

                public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                }

                public void checkClientTrusted(
                        java.security.cert.X509Certificate[] chain,
                        String authType)
                        throws java.security.cert.CertificateException {
                    // TODO Auto-generated method stub
                }
                public void checkServerTrusted(
                        java.security.cert.X509Certificate[] chain,
                        String authType)
                        throws java.security.cert.CertificateException {
                    // TODO Auto-generated method stub
                }
            };
            ctx.init(null, new TrustManager[]{tm}, null);
            SSLSocketFactory ssf = new SSLSocketFactory(ctx, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            SchemeRegistry registry = new SchemeRegistry();
            registry.register(new Scheme("https", 443, ssf));
            PoolingClientConnectionManager mgr = new PoolingClientConnectionManager(registry);
            return new DefaultHttpClient(mgr, base.getParams());
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String doPost(String url, JSONObject jsonObject, String charset) {
        HttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        try {
            if(url.startsWith("https")){
                httpClient = wrapClient(new DefaultHttpClient());
            }else{
                httpClient = new DefaultHttpClient();
            }
            httpPost = new HttpPost(url);
            System.out.println(jsonObject.toString());
            StringEntity entity = new StringEntity(jsonObject.toString(), charset);
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");

            httpPost.setEntity(entity);

            HttpResponse response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, charset);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    public static String doPut(String url, JSONObject jsonObject, String charset) {
        HttpClient httpClient = null;
        HttpPut httpPut = null;
        String result = null;
        try {
            if(url.startsWith("https")){
                httpClient = wrapClient(new DefaultHttpClient());
            }else{
                httpClient = new DefaultHttpClient();
            }
            httpPut = new HttpPut(url);
            StringEntity entity = new StringEntity(jsonObject.toString(), charset);
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            httpPut.setEntity(entity);
            HttpResponse response = httpClient.execute(httpPut);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, charset);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    public static String doDelete(String url, String charset) {
        HttpClient httpClient = null;
        HttpDelete httpDelete = null;
        String result = null;
        try {
            if(url.startsWith("https")){
                httpClient = wrapClient(new DefaultHttpClient());
            }else{
                httpClient = new DefaultHttpClient();
            }
            httpDelete = new HttpDelete(url);
            HttpResponse response = httpClient.execute(httpDelete);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, charset);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }


    public static String doPost(String url, String charset) {
        HttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        try {
            if(url.startsWith("https")){
                httpClient = wrapClient(new DefaultHttpClient());
            }else{
                httpClient = new DefaultHttpClient();
            }
            httpPost = new HttpPost(url);
            HttpResponse response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, charset);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static String doGet(String url) {
        HttpClient httpClient = null;
        String result = null;
        HttpGet request = new HttpGet(url);

        if(url.startsWith("https")){
            httpClient = wrapClient(new DefaultHttpClient());
        }else{
            httpClient = new DefaultHttpClient();
        }

        try {
            HttpResponse response = httpClient.execute(request);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                result = EntityUtils.toString(response.getEntity(), "utf-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

