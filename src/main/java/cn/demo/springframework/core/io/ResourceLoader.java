package cn.demo.springframework.core.io;

/**
 * @author BaiJY
 * @date 2023/06/20
 **/
public interface ResourceLoader {

    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
