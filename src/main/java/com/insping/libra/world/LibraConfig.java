package com.insping.libra.world;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.Properties;

import com.insping.Const;
import com.insping.log.LibraLog;

public class LibraConfig {
	public static long SYSTEM_TRANFOEM_ID = 1;// 服务器列表传输数据的用户编号说
	public static int SERVER_ID = 10002;// 服务器列表实例号
	public static String SOCKET_IP = "192.168.0.104";
	public static int SOCKET_PORT = 9051;

	public static String REDIS_TOKEN_PREFIX = "ACCOUNT_TOKEN_"; // token redis缓存前缀

	public static void load() {
		Properties properties = new Properties();
		try {
			properties.load(new InputStreamReader(new BufferedInputStream(new FileInputStream(Const.CONF_PATH + "config.properties")), "UTF-8"));
			Field[] fields = LibraConfig.class.getDeclaredFields();
			for (Field field : fields) {
				String str = properties.getProperty(field.getName());
				if (str == null) {
					continue;
				}
				loadOneProperty(field, str, null);
			}
			LibraLog.info("LibraConfig-load :config Properties loaded!");
		} catch (Exception e) {
			LibraLog.error("LibraConfig-load :libraConfig is exception ,e :" + e.getMessage());
		}
	}

	public static void loadOneProperty(Field f, String val, Object obj) throws Exception {
		if (f.getType() == byte.class) {
			f.set(obj, Byte.parseByte(val));
		} else if (f.getType() == int.class) {
			f.set(obj, Integer.parseInt(val));
		} else if (f.getType() == short.class) {
			f.set(obj, Short.parseShort(val));
		} else if (f.getType() == long.class) {
			f.set(obj, Long.parseLong(val));
		} else if (f.getType() == float.class) {
			f.set(obj, Float.parseFloat(val));
		} else if (f.getType() == boolean.class) {
			f.set(obj, Boolean.parseBoolean(val));
		} else if (f.getType() == String.class) {
			f.set(obj, val);
		} else if (f.getType() == Timestamp.class) {
			f.set(obj, Timestamp.valueOf(val));
		}
	}
}
