package org.AutomateMobile.Utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.AutomateMobile.constants.FilePaths;
import org.AutomateMobile.dto.AppiumConfig;
import org.AutomateMobile.dto.AndroidDeviceInfo;
import org.AutomateMobile.dto.IOSDeviceInfo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import static org.AutomateMobile.constants.FilePaths.*;

public class JsonUtils {

    public static <T> T loadConfig(String filePath, TypeReference<T> typeRef) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        try(InputStream is = JsonUtils.class.getResourceAsStream(FilePaths.valueOf(filePath).getPath())) {
            if (is == null) {
                throw new FileNotFoundException("File not found: " + filePath);
            }
            return mapper.readValue(is, typeRef);
        }
    }

    public static IOSDeviceInfo getIosDeviceInfo() throws IOException {
        return loadConfig(iOSDeviceDeviceInfo.toString(), new TypeReference<IOSDeviceInfo>() {});
    }

    public static AndroidDeviceInfo getAndroidDeviceInfo() throws IOException {
        return loadConfig(androidDeviceInfo.toString(), new TypeReference<AndroidDeviceInfo>() {});
    }

    public static AppiumConfig getAppiumConfig() throws IOException {
        return loadConfig(appiumConfig.toString(), new TypeReference<AppiumConfig>() {});
    }
}
