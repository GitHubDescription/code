<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:typ="http://cxf.apache.org/hello_world_soap_http/types">
   <soapenv:Header/>
   <soapenv:Body>
      <typ:greetMe>
         <typ:requestType>${me}</typ:requestType>
      </typ:greetMe>
   </soapenv:Body>
</soapenv:Envelope>