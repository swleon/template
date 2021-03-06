package com.haibao.sftp.utils;

import com.haibao.sftp.pool.exception.SftpClientException;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/*
 * @Author ml.c
 * @Description //
 * @Date 5:51 PM 1/14/21
 **/
public class ByteUtil {

    /**
     * 输入流转字节数组
     * @param in 输入流
     * @return 字节数组
     */
    public static byte[] inputStreamToByteArray(InputStream in) {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024*4];
            int n;
            while ((n = in.read(buffer))>0) {
                out.write(buffer, 0, n);
            }
            return out.toByteArray();
        } catch (Exception e) {
            throw new SftpClientException("输入流转字节数组出错", e);
        }
    }
}
