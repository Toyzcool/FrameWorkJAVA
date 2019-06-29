package bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;

//复杂类型的属性注入
public class MultipleBean {
    private String[] strings;
    private List<String> list;
    private Map<String,String> map;
    private Properties properties;

    public void setStrings(String[] strings) {
        this.strings = strings;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void test(){
        System.out.println("strings:"+strings);
        System.out.println("list:"+list);
        System.out.println("map:"+map);
        System.out.println("properties:"+properties);
    }
}
