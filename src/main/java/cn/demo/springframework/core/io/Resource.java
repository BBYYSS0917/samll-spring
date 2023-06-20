package cn.demo.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author BaiJY
 * @date 2023/06/20
 **/
public interface Resource {
    InputStream getInputStream() throws IOException;
}
