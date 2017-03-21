package com.looty.property;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public abstract class PropertyConfig {
    private static Logger logger = Logger.getLogger(PropertyConfig.class);
    protected String configFileName;
    private Properties p = null;

    public String getConfigFileName() {
        return configFileName;
    }

    protected PropertyConfig(String configFileName) {
        p = new Properties();
        InputStream is = null;
        try {
            ClassLoader cl = PropertyConfig.class.getClassLoader();
            if (cl != null) {
                is = cl.getResourceAsStream(configFileName);
            } else {
                is = ClassLoader.getSystemResourceAsStream(configFileName);
            }

            if (is != null) {
                p.load(is);
            }
        } catch (Exception e) {
            logger.error("file " + configFileName + " not found!\n" + e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                }
            }
        }
    }

    /**
     * 根据配置文件中的键，返回其字符串类型的值
     *
     * @param key the key
     * @return the value
     */
    public String getValue(String key) {
        String value = p.getProperty(key);
        return value;
    }

    /**
     * 根据配置文件中的键，返回其整数类型的值，如果不能转化为整数，返回0.
     *
     * @param key the key
     * @return the int
     */
    public int getInt(String key) {
        String str = getValue(key);
        int valueInt = 0;
        if (str != null) {
            try {
                valueInt = Integer.parseInt(str);
            } catch (Exception e) {
                logger.debug(e);
            }
        }
        logger.debug(key + "->" + valueInt);
        return valueInt;
    }

    public void traceInfo(String key) {
        logger.info(key + "->" + p.getProperty(key));
    }

    public Properties getProperties() {
        return p;
    }


}

