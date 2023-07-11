# post-office-api-consuming

Postal PIN Code API

Postal PIN Code API allows developers to get details of Post Office by searching Postal PIN Code or Post Office Branch Name of India.



It has following format:


1. Get Post Office(s) details search by Postal PIN Code


GET https://api.postalpincode.in/pincode/{PINCODE}

2.Get Post Office(s) details search by Post Office branch name


GET https://api.postalpincode.in/postoffice/{POSTOFFICEBRANCHNAME}


Postal PIN Code API returns the response in JSON format. "Status" field in response is set to SUCCESS or ERROR, "Message" field will return message against the request and "PostOffice" field will return data.
