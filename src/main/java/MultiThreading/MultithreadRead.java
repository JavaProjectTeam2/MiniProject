package MultiThreading;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class MultithreadRead extends Thread {

    public int max;
    public int min;

    public MultithreadRead(int min, int max) {
        this.max = max;
        this.min = min;
    }

    public void run() {
        try {
            for (int i = min; i <= max; i++) {
                //creating a constructor of file class and parsing an XML file
                //File file = new File("C:\\WisdomCat\\XMLFile.xml");
                File file = new File("C:\\Java_Project\\DataBase\\Product_Data_1 - Copy (" + i + ").xml");
                //File file = new File("C:\\Java_Project\\DataBase\\Product_Data_1 - Copy (1).xml");
                //an instance of factory that gives a document builder
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                //an instance of builder to parse the specified xml file
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.parse(file);
                doc.getDocumentElement().normalize();
                System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
                // NodeList nodeList = doc.getElementsByTagName("student");

                NodeList nodeList = doc.getElementsByTagName("row");

                // nodeList is not iterable, so we are using for loop
                for (int itr = 0; itr < nodeList.getLength(); itr++) {
                    Node node = nodeList.item(itr);
                    //System.out.println("\nNode Name :" + node.getNodeName());
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) node;
                        if (fileValidation(eElement)) {
                            System.out.println("Product Id: " + eElement.getElementsByTagName("Product_Id").item(0).getTextContent());
                            System.out.println("Company Name: " + eElement.getElementsByTagName("Company_Name").item(0).getTextContent());
                            System.out.println("Product Category: " + eElement.getElementsByTagName("Category").item(0).getTextContent());
                            System.out.println("Available Colors: " + eElement.getElementsByTagName("Color").item(0).getTextContent());
                            System.out.println("Manufacturing Date: " + eElement.getElementsByTagName("Mfg_Date").item(0).getTextContent());
                            System.out.println("Product Dimension: " + eElement.getElementsByTagName("Dimension").item(0).getTextContent());
                            System.out.println("Product Image: " + eElement.getElementsByTagName("Image_Source").item(0).getTextContent());
                            System.out.println("Website URL: " + eElement.getElementsByTagName("Website").item(0).getTextContent());
                            System.out.println("Model Name: " + eElement.getElementsByTagName("Model_Name").item(0).getTextContent());
                            System.out.println("Model Id: " + eElement.getElementsByTagName("Model_Id").item(0).getTextContent());
                            System.out.println("Product Description: " + eElement.getElementsByTagName("Description").item(0).getTextContent());
                            System.out.println("Product Department: " + eElement.getElementsByTagName("Department").item(0).getTextContent());
                            System.out.println(" ");
                        } else {
                            System.out.println("CORRUPTED FILE for the Product: " + eElement.getElementsByTagName("Description").item(0).getTextContent());
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean fileValidation(Element eElement) {
        return !eElement.getElementsByTagName("Product_Id").item(0).getTextContent().equals("") &&
                !eElement.getElementsByTagName("Company_Name").item(0).getTextContent().equals("") &&
                !eElement.getElementsByTagName("Category").item(0).getTextContent().equals("") &&
                !eElement.getElementsByTagName("Color").item(0).getTextContent().equals("") &&
                !eElement.getElementsByTagName("Mfg_Date").item(0).getTextContent().equals("") &&
                !eElement.getElementsByTagName("Dimension").item(0).getTextContent().equals("") &&
                !eElement.getElementsByTagName("Image_Source").item(0).getTextContent().equals("") &&
                !eElement.getElementsByTagName("Website").item(0).getTextContent().equals("") &&
                !eElement.getElementsByTagName("Model_Name").item(0).getTextContent().equals("") &&
                !eElement.getElementsByTagName("Model_Id").item(0).getTextContent().equals("") &&
                !eElement.getElementsByTagName("Description").item(0).getTextContent().equals("") &&
                !eElement.getElementsByTagName("Department").item(0).getTextContent().equals("");
    }
}
