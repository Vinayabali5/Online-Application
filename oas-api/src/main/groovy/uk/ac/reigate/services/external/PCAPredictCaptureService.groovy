package uk.ac.reigate.services.external

import java.util.logging.Logger

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.logging.LogLevel
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

import uk.ac.reigate.dto.lookup.PostcodeLookupDTO
import uk.ac.reigate.exceptions.PostcodeRetrievalException
import uk.ac.reigate.exceptions.PostcodeSearchException
import uk.ac.reigate.oas.domain.Address

@Service
@Profile('pcapredict')
class PCAPredictCaptureService implements IExternalPostcodeLookupService {
    
    private final static Logger LOGGER = Logger.getLogger(PCAPredictCaptureService.class.getName());
    
    @Value("\${postcode.pcapredict.capture.key:''}")
    private String key = '';
    
    @Value("\${postcode.pcapredict.username:''}")
    private String username = '';
    
    private URLEncoder urlEncoder = new URLEncoder()
    
    private java.util.Hashtable[] Capture_Interactive_Find_v1_00(String Key, String Text, String Container, String Origin, String Countries, Integer Limit, String Language) throws Exception {
        String requestUrl = new String();
        String key = new String();
        String value = new String();
        
        //Build the url
        requestUrl = "http://services.postcodeanywhere.co.uk/Capture/Interactive/Find/v1.00/xmla.ws?";
        requestUrl += "&Key=" + urlEncoder.encode(Key, 'UTF-8');
        requestUrl += "&Text=" + urlEncoder.encode(Text, 'UTF-8');
        requestUrl += "&Container=" + urlEncoder.encode(Container, 'UTF-8');
        requestUrl += "&Origin=" + urlEncoder.encode(Origin, 'UTF-8');
        requestUrl += "&Countries=" + urlEncoder.encode(Countries, 'UTF-8');
        requestUrl += "&Limit=" + urlEncoder.encode(Limit.toString(), 'UTF-8');
        requestUrl += "&Language=" + urlEncoder.encode(Language, 'UTF-8');
        
        //Get the data
        java.net.URL url = new java.net.URL(requestUrl);
        java.io.InputStream stream = url.openStream();
        javax.xml.parsers.DocumentBuilder docBuilder = javax.xml.parsers.DocumentBuilderFactory.newInstance().newDocumentBuilder();
        org.w3c.dom.Document dataDoc = docBuilder.parse(stream);
        
        //Get references to the schema and data
        org.w3c.dom.NodeList schemaNodes = dataDoc.getElementsByTagName("Column");
        org.w3c.dom.NodeList dataNotes = dataDoc.getElementsByTagName("Row");
        
        //Check for an error
        if (schemaNodes.getLength()==4 && schemaNodes.item(0).getAttributes().getNamedItem("Name").getNodeValue().equals("Error")) {
            throw new Exception(dataNotes.item(0).getAttributes().getNamedItem("Description").getNodeValue());
        };
        
        //Work though the items in the response
        java.util.Hashtable[] results = new java.util.Hashtable[dataNotes.getLength()];
        for (int rowCounter=0; rowCounter<dataNotes.getLength(); rowCounter++) {
            java.util.Hashtable rowData = new java.util.Hashtable();
            for (int colCounter=0; colCounter<schemaNodes.getLength(); colCounter++)            {
                key = (String)schemaNodes.item(colCounter).getAttributes().getNamedItem("Name").getNodeValue();
                if(dataNotes.item(rowCounter).getAttributes().getNamedItem(key)==null) {
                    value="";
                } else {
                    value = (String)dataNotes.item(rowCounter).getAttributes().getNamedItem(key).getNodeValue();
                };
                rowData.put (key, value);
            }
            results[rowCounter] = rowData;
        }
        //Return the results
        return results;
    }
    
    private java.util.Hashtable[] Capture_Interactive_Retrieve_v1_00(String Key, String Id, String Field1Format, String Field2Format, String Field3Format, String Field4Format, String Field5Format, String Field6Format, String Field7Format, String Field8Format, String Field9Format, String Field10Format, String Field11Format, String Field12Format, String Field13Format, String Field14Format, String Field15Format, String Field16Format, String Field17Format, String Field18Format, String Field19Format, String Field20Format) throws Exception {
        String requestUrl = new String();
        String key = new String();
        String value = new String();
        
        //Build the url
        requestUrl = "http://services.postcodeanywhere.co.uk/Capture/Interactive/Retrieve/v1.00/xmla.ws?";
        requestUrl += "&Key=" + urlEncoder.encode(Key, 'UTF-8');
        requestUrl += "&Id=" + urlEncoder.encode(Id, 'UTF-8');
        requestUrl += "&Field1Format=" + urlEncoder.encode(Field1Format, 'UTF-8');
        requestUrl += "&Field2Format=" + urlEncoder.encode(Field2Format, 'UTF-8');
        requestUrl += "&Field3Format=" + urlEncoder.encode(Field3Format, 'UTF-8');
        requestUrl += "&Field4Format=" + urlEncoder.encode(Field4Format, 'UTF-8');
        requestUrl += "&Field5Format=" + urlEncoder.encode(Field5Format, 'UTF-8');
        requestUrl += "&Field6Format=" + urlEncoder.encode(Field6Format, 'UTF-8');
        requestUrl += "&Field7Format=" + urlEncoder.encode(Field7Format, 'UTF-8');
        requestUrl += "&Field8Format=" + urlEncoder.encode(Field8Format, 'UTF-8');
        requestUrl += "&Field9Format=" + urlEncoder.encode(Field9Format, 'UTF-8');
        requestUrl += "&Field10Format=" + urlEncoder.encode(Field10Format, 'UTF-8');
        requestUrl += "&Field11Format=" + urlEncoder.encode(Field11Format, 'UTF-8');
        requestUrl += "&Field12Format=" + urlEncoder.encode(Field12Format, 'UTF-8');
        requestUrl += "&Field13Format=" + urlEncoder.encode(Field13Format, 'UTF-8');
        requestUrl += "&Field14Format=" + urlEncoder.encode(Field14Format, 'UTF-8');
        requestUrl += "&Field15Format=" + urlEncoder.encode(Field15Format, 'UTF-8');
        requestUrl += "&Field16Format=" + urlEncoder.encode(Field16Format, 'UTF-8');
        requestUrl += "&Field17Format=" + urlEncoder.encode(Field17Format, 'UTF-8');
        requestUrl += "&Field18Format=" + urlEncoder.encode(Field18Format, 'UTF-8');
        requestUrl += "&Field19Format=" + urlEncoder.encode(Field19Format, 'UTF-8');
        requestUrl += "&Field20Format=" + urlEncoder.encode(Field20Format, 'UTF-8');
        
        //Get the data
        java.net.URL url = new java.net.URL(requestUrl);
        java.io.InputStream stream = url.openStream();
        javax.xml.parsers.DocumentBuilder docBuilder = javax.xml.parsers.DocumentBuilderFactory.newInstance().newDocumentBuilder();
        org.w3c.dom.Document dataDoc = docBuilder.parse(stream);
        
        //Get references to the schema and data
        org.w3c.dom.NodeList schemaNodes = dataDoc.getElementsByTagName("Column");
        org.w3c.dom.NodeList dataNotes = dataDoc.getElementsByTagName("Row");
        
        //Check for an error
        if (schemaNodes.getLength()==4 && schemaNodes.item(0).getAttributes().getNamedItem("Name").getNodeValue().equals("Error")) {
            throw new Exception(dataNotes.item(0).getAttributes().getNamedItem("Description").getNodeValue());
        };
        
        //Work though the items in the response
        java.util.Hashtable[] results = new java.util.Hashtable[dataNotes.getLength()];
        for (int rowCounter=0; rowCounter<dataNotes.getLength(); rowCounter++) {
            java.util.Hashtable rowData = new java.util.Hashtable();
            for (int colCounter=0; colCounter<schemaNodes.getLength(); colCounter++) {
                key = (String)schemaNodes.item(colCounter).getAttributes().getNamedItem("Name").getNodeValue();
                if(dataNotes.item(rowCounter).getAttributes().getNamedItem(key)==null) {
                    value="";
                } else {
                    value = (String)dataNotes.item(rowCounter).getAttributes().getNamedItem(key).getNodeValue();
                };
                rowData.put (key, value);
            }
            results[rowCounter] = rowData;
        }
        //Return the results
        return results;
    }
    
    @Override
    public List<PostcodeLookupDTO> search(String postcode) throws PostcodeSearchException {
        LOGGER.info("II PCAPredictCaptureService.search - " + postcode);
        List<PostcodeLookupDTO> output = new ArrayList<PostcodeLookupDTO>();
        Hashtable[] results = null;
        try {
            results = this.Capture_Interactive_Find_v1_00(this.key, postcode, '', '', 'GB', 100, 'en-gb')
            if (results[0].get("Type") == "Postcode") {
                results = this.Capture_Interactive_Find_v1_00(this.key, postcode, results[0].get("Id"), '', 'GB', 100, 'en-gb')
            }
            results.each { it ->
                PostcodeLookupDTO item = new PostcodeLookupDTO(it.get("Id"), it.get("Text"), it.get("Description"))
                output.add(item)
            }
        } catch (UnknownHostException e) {
            throw new PostcodeSearchException(e.detailMessage);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.log(LogLevel.ERROR, e.toString())
            throw new PostcodeSearchException(e.message);
        }
        // TODO: Add better exception processing
        return output;
    }
    
    @Override
    public Address retrieve(String id) throws PostcodeRetrievalException {
        LOGGER.info("II PCAPredictCaptureService.retrieve - " + id);
        Address output = null
        try {
            Hashtable[] results = this.Capture_Interactive_Retrieve_v1_00(this.key, id, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '')
            output = new Address()
            output.line1 = results[0].get("Line1")
            output.line2 = results[0].get("Line2")
            output.line3 = results[0].get("Line3")
            output.line4 = results[0].get("Line4")
            output.line5 = results[0].get("Line5")
            output.town = results[0].get("City")
            output.county = results[0].get("Province")
            output.postcode = results[0].get("PostalCode")
            output.label = results[0].get("Label")
        } catch (Exception e) {
            e.printStackTrace();
            String test = e.getStackTrace().toString()
            throw new PostcodeRetrievalException(e.detailMessage)
        }
        // TODO: Add better exception processing
        return output;
    }
}
