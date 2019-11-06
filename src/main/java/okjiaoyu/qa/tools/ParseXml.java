package okjiaoyu.qa.tools;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/3/30.
 */
public class ParseXml {

    private String filePath;

    public ParseXml(String filePath) {
        this.filePath = filePath;
        this.load(filePath);
    }

    private Document document;

    public void load(String filePath) {
        //String path = ParseXml.class.getResource(filePath).getPath();
        //System.out.println(path);
//        载入xml文件，对这个文件对象进行xml分析处理
        //File file = new File(path);
        //InputStream in = ReadFile.class.getResourceAsStream(filePath);
       /* File file = new File(filePath);
        if(file.exists()){*/
        SAXReader saxReader = new SAXReader();
        try {
            document = saxReader.read(ParseXml.class.getResourceAsStream(filePath));
//                System.out.println(1111111);
            //document = saxReader.read(file);
        } catch (DocumentException e) {
            e.printStackTrace();
            System.out.println("fail to loadfile: " + filePath);
        }
        /*}else {
            System.out.println("文件加载不存在" + filePath);
        }*/
    }

    public Element getElementObject(String elementPath) {
        return ( Element ) document.selectSingleNode(elementPath);
    }

    public String getElementText(String elementPath) {
        Element element = this.getElementObject(elementPath);
        if (element != null) {
            return element.getTextTrim();
        } else {
            return null;
        }
    }

    public boolean isExist(String elementPath) {
        boolean flag = false;
        Element element = this.getElementObject(elementPath);
        if (element != null) {
            flag = true;
        }
        return flag;
    }

    @SuppressWarnings("unchecked")
    public List<Element> getElementObjects(String elementPath) {
        return document.selectNodes(elementPath);
    }

    @SuppressWarnings("unchecked")
    public Map<String, String> getChildrenInfoByElement(Element element) {
        Map<String, String> map = new HashMap<String, String>();
        List<Element> children = element.elements();
        for (Element e : children) {
            map.put(e.getName(), e.getText());
        }
        return map;
    }

    /*public static void main(String[] args) {
     *//*ParseXml parseXml = new ParseXml();
        parseXml.load("config/myconfig.xml");
        String browser = parseXml.getElementText("config/browser");
        System.out.println(browser );*//*
        ParseXml parseXml = new ParseXml("/config/TestBaidu.xml");
        List<Element> elements = parseXml.getElementObjects("/*//*testUI");
        System.out.println(elements.toString());
        Object[][] objects = new Object[elements.size()][];
        for(int i = 0; i < elements.size(); i++){
            Object[] temp = new Object[]{parseXml.getChildrenInfoByElement(elements.get(i))};
            objects[i] = temp;
        }
        Object o = objects[1][0];
        System.out.println(((Map<String, String>)o).get("description"));


    }*/

    //day11


}
