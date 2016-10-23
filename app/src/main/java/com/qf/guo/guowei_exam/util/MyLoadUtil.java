package com.qf.guo.guowei_exam.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.SystemClock;

public class MyLoadUtil {
	

	public byte[] loadData(String urlString) {
		try {
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			InputStream inputStream = connection.getInputStream();

			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			
			byte[] buff = new byte[1024];
			
			while (true) {
				int ret = inputStream.read(buff,0,buff.length);
				SystemClock.sleep(1);
				if (ret == -1) {
					break;
				}
				
				
				//把数据存到内存缓冲区
				bos.write(buff, 0, ret);
			}
			//将内存流中的数据转成字节数组
			byte[] byteArray = bos.toByteArray();
			//将字节数组返回
			return byteArray;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
