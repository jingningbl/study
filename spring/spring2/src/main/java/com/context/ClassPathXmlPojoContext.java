package com.context;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author bai
 * @version V1.0
 * @Package com.context
 * @date 2022/2/14 9:18
 * @describe 自定义容器
 */
public class ClassPathXmlPojoContext implements PojoContext {
    //    存放初始化dean的Map集合
    private Map container = new ConcurrentHashMap();

    public ClassPathXmlPojoContext() {
//        解析xml文件
        try {
//            获取配置文件路径
            String path = this.getClass().getResource("/application.xml").getPath();
//        通过dom4j解析,创建解析器对象
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(new File(path));
//        从根标签中(<deans/>)中选取标签名叫dean的所有节点
            List<Node> deans = document.getRootElement().selectNodes("dean");
            for (Node node : deans) {
                Element dean = (Element) node;
                String id = dean.attributeValue("id");
                String aClass = dean.attributeValue("class");
                Class<?> aClass1 = Class.forName(aClass);
//                通过反射实例化对象
                Object obj = aClass1.newInstance();
//                遍历子节点(qroperty)
                List<Node> qroperties = dean.selectNodes("qroperty");
                for (Node q : qroperties) {
                    Element qroperty = (Element) q;
                    String name = qroperty.attributeValue("name");
                    String value = qroperty.attributeValue("value");
//                    拼接属性的set方法名
                    String setName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
                    Method method = aClass1.getMethod(setName, String.class);
//                    调用set方法,向对象注入属性值
                    method.invoke(obj, value);
                }
//                将对象装入container Map集合中
                container.put(id, obj);
            }
            System.out.println("容器初始化完毕");
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getDean(String deanName) {
        return container.get(deanName);
    }
}
