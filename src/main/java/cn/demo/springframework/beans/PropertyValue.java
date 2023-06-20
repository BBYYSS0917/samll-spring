package cn.demo.springframework.beans;

/**
 * @author BaiJY
 * @date 2023/06/20
 **/
public class PropertyValue {
    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }


}
