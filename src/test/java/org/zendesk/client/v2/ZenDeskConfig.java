package org.zendesk.client.v2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author stephenc
 * @since 04/04/2013 13:53
 */
public final class ZenDeskConfig {
    private ZenDeskConfig() {
        throw new IllegalAccessError("utility class");
    }

    public static Properties load() {
        InputStream is = ZenDeskConfig.class.getResourceAsStream("/zendesk.properties");
        if (is == null) {
            return null;
        }
        try {
            Properties result = new Properties();
            result.load(is);
            return result;
        } catch (IOException e) {
            return null;
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                // ignore
            }
        }
    }
}
