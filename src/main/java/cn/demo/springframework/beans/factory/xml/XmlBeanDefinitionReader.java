package cn.demo.springframework.beans.factory.xml;

import cn.demo.springframework.beans.BeansException;
import cn.demo.springframework.beans.PropertyValue;
import cn.demo.springframework.beans.factory.BeanDefinitonReader;
import cn.demo.springframework.beans.factory.config.BeanDefinition;
import cn.demo.springframework.beans.factory.config.BeanReference;
import cn.demo.springframework.beans.factory.support.AbstractBeanDefinitonReader;
import cn.demo.springframework.beans.factory.support.BeanDefinitionRegistry;
import cn.demo.springframework.core.io.Resource;
import cn.demo.springframework.core.io.ResourceLoader;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author BaiJY
 * @date 2023/06/20
 **/
public class XmlBeanDefinitionReader extends AbstractBeanDefinitonReader {
    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitons(Resource resource) throws BeansException {
        try (InputStream inputStream = resource.getInputStream()) {
            doLoadBeanDefinitons(inputStream);
        } catch (IOException | ClassNotFoundException e) {
            throw new BeansException("IOException parsing XML document from " + resource, e);
        }
    }

    @Override
    public void loadBeanDefinitons(Resource... resources) throws BeansException {
        for (Resource resource : resources) {
            loadBeanDefinitons(resource);
        }
    }

    @Override
    public void loadBeanDefinitons(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitons(resource);
    }

    protected void doLoadBeanDefinitons(InputStream inputStream) throws ClassNotFoundException {

        Document doc = XmlUtil.readXML(inputStream);
        Element root = doc.getDocumentElement();
        NodeList childNodes = root.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {
            //判断元素
            if(!(childNodes.item(i) instanceof Element)) {
                continue;
            }
            //判断对象
            if (!"bean".equals(childNodes.item(i).getNodeName())) {
                continue;
            }
            //解析标签
            Element bean = (Element) childNodes.item(i);
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");

            //获取Class,方便获取类中的名称
            Class<?> clazz = Class.forName(className);
            String beanName = StrUtil.isNotEmpty(id) ? id : name;
            if (StrUtil.isEmpty(beanName)) {
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }

            BeanDefinition beanDefiniton = new BeanDefinition(clazz);

            //读取属性并填充
            for (int j = 0; j < bean.getChildNodes().getLength(); j++) {
                if (!(bean.getChildNodes().item(j) instanceof Element)) {
                    continue;
                }
                if (!"property".equals(bean.getChildNodes().item(j).getNodeName())) {
                    continue;
                }

                Element property = (Element) bean.getChildNodes().item(j);
                String attrName = property.getAttribute("name");
                String attrValue = property.getAttribute("value");
                String attrRef = property.getAttribute("ref");

                //获取属性值 引入对象、值对象
                Object value = StrUtil.isNotEmpty(attrRef) ? new BeanReference(attrRef) : attrValue;
                //创建属性信息
                PropertyValue propertyValue = new PropertyValue(attrName, value);
                beanDefiniton.getPropertyValues().addPropertyValue(propertyValue);
            }

            if (getRegistry().containsBeanDefiniton(beanName)) {
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
            }
            getRegistry().registerBeanDefinition(beanName, beanDefiniton);
        }
    }
}
