package com.mip.app.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import com.mip.app.constants.ApplicationKeys;
import com.mip.app.model.CustomerDetails;
import com.mip.app.model.CustomerSubscriptions;
import com.mip.app.model.NomineeDetails;
//import com.mip.app.services.CreateJsonService;
import com.mip.framework.logger.LoggerFactory;
import com.mip.framework.logger.MIPLogger;

public class JsonCreatorFromReqParam {
	
	private static MIPLogger logger = LoggerFactory.getInstance().getLogger(JsonCreatorFromReqParam.class);

	public static void main(String[] args) {
		
		try {
		String finalJson="";
		File file = new File(ApplicationKeys.CSV_FILE_NAME);
		String request_param_CreDte;
		String request_param;
		String createdDate;
		int index=1;
		BufferedReader br = new BufferedReader(new FileReader(file));
		System.out.println("=====JSON Parsing Started====");
			while((request_param_CreDte = br.readLine()) != null){
				//System.out.println("Complete line from CSV file: "+request_param_CreDte);
				//logger.info("Complete JSON line- "+index+" from CSV file: "+request_param_CreDte);
				String[] reqParamArray=request_param_CreDte.split("#");
				request_param=reqParamArray[0];
				createdDate=reqParamArray[1];
				//logger.info("request_param: "+request_param);
				//logger.info("createdDate: "+createdDate);
				/*System.out.println("request_param: "+request_param);
				System.out.println("createdDate: "+createdDate);*/
				JsonCreatorFromReqParam jfrq=new JsonCreatorFromReqParam();
			    //finalJson = jfrq.JsonCreationService(request_param,createdDate);
			    jfrq.JsonCreationService(request_param,createdDate);
				index++;
			}
			br.close();
		}catch (FileNotFoundException fe) {
			fe.printStackTrace();
		}catch (IOException ie) {
			ie.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			System.out.println("=====JSON Parsing completed====");
		}

	}
	
	public void JsonCreationService(String jsonFileData, String createdDate) throws NullPointerException{
		
		//String request_param = "{\"bkashBeneficiaryName2\":\"\",\"bkashNomineeAge\":\"30\",\"deductionSuccess\":\"1\",\"bkashBeneficiaryName1\":\"\",\"newCustCreation\":\"1\",\"RequestUrl\":\"http://localhost:8070/mip-services/RegisterCustomer;age=${age};autoRenewal=${autoRenewal};bkashBeneficiaryAge1=${bkashBeneficiaryAge1};bkashBeneficiaryAge2=${bkashBeneficiaryAge2};bkashBeneficiaryAge3=${bkashBeneficiaryAge3};bkashBeneficiaryMsisdn1=${bkashBeneficiaryMsisdn1};bkashBeneficiaryMsisdn2=${bkashBeneficiaryMsisdn2};bkashBeneficiaryMsisdn3=${bkashBeneficiaryMsisdn3};bkashBeneficiaryName1=${bkashBeneficiaryName1};bkashBeneficiaryName2=${bkashBeneficiaryName2};bkashBeneficiaryName3=${bkashBeneficiaryName3};bkashBeneficiaryRelation1=${bkashBeneficiaryRelation1};bkashBeneficiaryRelation2=${bkashBeneficiaryRelation2};bkashBeneficiaryRelation3=${bkashBeneficiaryRelation3};bkashNomineeAge=${bkashNomineeAge};bkashNomineeMsisdn=${bkashNomineeMsisdn};bkashNomineeName=${bkashNomineeName};bkashNomineeRelation=${bkashNomineeRelation};custName=${custName};deductionSuccess=${deductionSuccess};firstMemberAge=${firstMemberAge};firstMemberMsisdn=${firstMemberMsisdn};firstMemberName=${firstMemberName};firstMemberRelationShip=${firstMemberRelationShip};gender=${gender};healthSMSFrequency=${healthSMSFrequency};hospCoverId=${hospCoverId};hospitalPaymentFrequency=${hospitalPaymentFrequency};isConfirmed=${isConfirmed};isPrepaid=${isPrepaid};isRobi=${isRobi};lifeCoverId=${lifeCoverId};lifePaymentFrequency=${lifePaymentFrequency};msisdn=${msisdn};newCustCreation=${newCustCreation};nomineeMsisdn=${nomineeMsisdn};nomineeName=${nomineeName};nomineeRelation=${nomineeRelation};offerCoverId=${offerCoverId};offerId=${offerId};paymentType=${paymentType};reactivated=${reactivated};reconcilied=${reconcilied};regBy=${regBy};registrationChannelId=${registrationChannelId};secondMemberAge=${secondMemberAge};secondMemberName=${secondMemberName};secondMemberRelationShip=${secondMemberRelationShip};secondMemeberMsisdn=${secondMemeberMsisdn};transactionId=${transactionId}\",\"bkashBeneficiaryMsisdn3\":\"\",\"isPrepaid\":\"1\",\"bkashBeneficiaryMsisdn2\":\"\",\"firstMemberAge\":\"\",\"lifeCoverId\":\"12\",\"lifePaymentFrequency\":\"1\",\"bkashNomineeRelation\":\"WIFE\",\"isConfirmed\":\"1\",\"firstMemberName\":\"\",\"bkashBeneficiaryName3\":\"\",\"RequestTimeout\":\"20000\",\"isRobi\":\"1\",\"bkashBeneficiaryMsisdn1\":\"\",\"transactionId\":\"9915492848592885602\",\"healthSMSFrequency\":\"6\",\"bkashNomineeName\":\"Nasrin%20%20Akter\",\"hospCoverId\":\"\",\"reconcilied\":\"0\",\"hospitalPaymentFrequency\":\"1\",\"bkashBeneficiaryRelation2\":\"\",\"bkashBeneficiaryRelation3\":\"\",\"offerId\":\"5\",\"bkashBeneficiaryRelation1\":\"\",\"offerCoverId\":\"12\",\"HttpMethod\":\"GET\",\"registrationChannelId\":\"1\",\"secondMemeberMsisdn\":\"\",\"gender\":\"M\",\"firstMemberMsisdn\":\"\",\"secondMemberRelationShip\":\"\",\"bkashNomineeMsisdn\":\"01723663830\",\"nomineeRelation\":\"\",\"paymentType\":\"1\",\"bkashBeneficiaryAge3\":\"\",\"nomineeMsisdn\":\"\",\"secondMemberAge\":\"\",\"msisdn\":\"01867163745\",\"bkashBeneficiaryAge2\":\"\",\"bkashBeneficiaryAge1\":\"\",\"nomineeName\":\"\",\"custName\":\"Md%20%20Hannan\",\"secondMemberName\":\"\",\"firstMemberRelationShip\":\"\",\"autoRenewal\":\"0\",\"age\":\"37\",\"reactivated\":\"0\",\"regBy\":\"1188162576209326080\"}";
		//String requestParam="{"bkashBeneficiaryName2":"","bkashNomineeAge":"30","deductionSuccess":"1","bkashBeneficiaryName1":"","newCustCreation":"1","RequestUrl":"http://localhost:8070/mip-services/RegisterCustomer;age=${age};autoRenewal=${autoRenewal};bkashBeneficiaryAge1=${bkashBeneficiaryAge1};bkashBeneficiaryAge2=${bkashBeneficiaryAge2};bkashBeneficiaryAge3=${bkashBeneficiaryAge3};bkashBeneficiaryMsisdn1=${bkashBeneficiaryMsisdn1};bkashBeneficiaryMsisdn2=${bkashBeneficiaryMsisdn2};bkashBeneficiaryMsisdn3=${bkashBeneficiaryMsisdn3};bkashBeneficiaryName1=${bkashBeneficiaryName1};bkashBeneficiaryName2=${bkashBeneficiaryName2};bkashBeneficiaryName3=${bkashBeneficiaryName3};bkashBeneficiaryRelation1=${bkashBeneficiaryRelation1};bkashBeneficiaryRelation2=${bkashBeneficiaryRelation2};bkashBeneficiaryRelation3=${bkashBeneficiaryRelation3};bkashNomineeAge=${bkashNomineeAge};bkashNomineeMsisdn=${bkashNomineeMsisdn};bkashNomineeName=${bkashNomineeName};bkashNomineeRelation=${bkashNomineeRelation};custName=${custName};deductionSuccess=${deductionSuccess};firstMemberAge=${firstMemberAge};firstMemberMsisdn=${firstMemberMsisdn};firstMemberName=${firstMemberName};firstMemberRelationShip=${firstMemberRelationShip};gender=${gender};healthSMSFrequency=${healthSMSFrequency};hospCoverId=${hospCoverId};hospitalPaymentFrequency=${hospitalPaymentFrequency};isConfirmed=${isConfirmed};isPrepaid=${isPrepaid};isRobi=${isRobi};lifeCoverId=${lifeCoverId};lifePaymentFrequency=${lifePaymentFrequency};msisdn=${msisdn};newCustCreation=${newCustCreation};nomineeMsisdn=${nomineeMsisdn};nomineeName=${nomineeName};nomineeRelation=${nomineeRelation};offerCoverId=${offerCoverId};offerId=${offerId};paymentType=${paymentType};reactivated=${reactivated};reconcilied=${reconcilied};regBy=${regBy};registrationChannelId=${registrationChannelId};secondMemberAge=${secondMemberAge};secondMemberName=${secondMemberName};secondMemberRelationShip=${secondMemberRelationShip};secondMemeberMsisdn=${secondMemeberMsisdn};transactionId=${transactionId}","bkashBeneficiaryMsisdn3":"","isPrepaid":"1","bkashBeneficiaryMsisdn2":"","firstMemberAge":"","lifeCoverId":"12","lifePaymentFrequency":"1","bkashNomineeRelation":"WIFE","isConfirmed":"1","firstMemberName":"","bkashBeneficiaryName3":"","RequestTimeout":"20000","isRobi":"1","bkashBeneficiaryMsisdn1":"","transactionId":"9915492848592885602","healthSMSFrequency":"6","bkashNomineeName":"Nasrin%20%20Akter","hospCoverId":"","reconcilied":"0","hospitalPaymentFrequency":"1","bkashBeneficiaryRelation2":"","bkashBeneficiaryRelation3":"","offerId":"5","bkashBeneficiaryRelation1":"","offerCoverId":"12","HttpMethod":"GET","registrationChannelId":"1","secondMemeberMsisdn":"","gender":"M","firstMemberMsisdn":"","secondMemberRelationShip":"","bkashNomineeMsisdn":"01723663830","nomineeRelation":"","paymentType":"1","bkashBeneficiaryAge3":"","nomineeMsisdn":"","secondMemberAge":"","msisdn":"01867163745","bkashBeneficiaryAge2":"","bkashBeneficiaryAge1":"","nomineeName":"","custName":"Md%20%20Hannan","secondMemberName":"","firstMemberRelationShip":"","autoRenewal":"0","age":"37","reactivated":"0","regBy":"1188162576209326080"}"";
		//String request_param =args[0];
		String request_param =jsonFileData;
		
		try {
			
			JSONObject obj = new JSONObject(request_param);
			
			
			JsonObjectBuilder finalBuilder = Json.createObjectBuilder();	
			JsonObjectBuilder customerBuilder = Json.createObjectBuilder();
			JsonObjectBuilder custDetailsBuilder = Json.createObjectBuilder();
			JsonArrayBuilder custSubscriptionArray = Json.createArrayBuilder();
			JsonArrayBuilder nomineeDetailsArray = Json.createArrayBuilder();			
			
			//logger.info("CustName"+obj.getString("custName: ").toString());
			//logger.info("JSON Parsing for Customer MSISDN: "+obj.getString("msisdn")+"  And  "+"Customer Name: "+obj.getString("custName"));
			//System.out.println("JSON Parsing for Customer MSISDN: "+obj.getString("msisdn")+"  And  "+"Customer Name: "+obj.getString("custName").replaceAll("%20", " ").trim());
			//logger.info("JSON Parsing for Customer MSISDN: "+obj.getString("msisdn")+"  And  "+"Customer Name: "+obj.getString("custName").replaceAll("%20", " ").trim());
						
			//----All model Objects----//
			CustomerDetails customerDetails=new CustomerDetails();
			customerDetails.setCustomerName(obj.getString("custName").replaceAll("%20", " ").trim());
			//System.out.println("Customer Age: "+obj.getString("age"));
			customerDetails.setCustomerAge(Integer.parseInt(obj.getString("age")));
			customerDetails.setCustomerGender(obj.getString("gender"));
			customerDetails.setCustomerMsisdn(obj.getString("msisdn"));
			
			if(obj.getString("regBy").length()==19 
					|| obj.getString("regBy").length()==18
					|| obj.getString("regBy").length()==17
					|| obj.getString("regBy").length()==0){
				customerDetails.setCreatedBy(99); //please define variable createdBy a int in the pojo class				
			}
			else{
				customerDetails.setCreatedBy(obj.getInt("regBy")); //please define variable createdBy a int in the pojo class
			}
			//customerDetails.setCreatedBy(obj.getLong("regBy"));
			customerDetails.setCreatedDate(createdDate);
			
			custDetailsBuilder.add("customerName",customerDetails.getCustomerName());
			custDetailsBuilder.add("customerAge",customerDetails.getCustomerAge());
			custDetailsBuilder.add("customerGender",customerDetails.getCustomerGender());
			custDetailsBuilder.add("customerMsisdn",customerDetails.getCustomerMsisdn());
			custDetailsBuilder.add("createdBy",customerDetails.getCreatedBy());
			custDetailsBuilder.add("createdDate", customerDetails.getCreatedDate());
			
						
			CustomerSubscriptions customerSubscriptions=new CustomerSubscriptions();
			//System.out.println("Product offerId: "+obj.getString("offerId"));
			if(!obj.getString("offerId").isEmpty()){
				//System.out.println("offerId is Not Empty");
				customerSubscriptions.setOfferId(Integer.parseInt(obj.getString("offerId")));
			}
			else{
				customerSubscriptions.setOfferId(5);
			}
			//customerSubscriptions.setOfferId(Integer.parseInt(obj.getString("offerId")));
			/*if(obj.getInt("offerCoverId")){
				
			}*/
			
			//lifeCoverId
			//hospCoverId
			//System.out.println("offerCoverId: "+obj.getString("offerCoverId"));
			if(!obj.getString("offerCoverId").isEmpty()){
				System.out.println("offerCoverId is Not Empty");
				customerSubscriptions.setOfferCoverId(Integer.parseInt(obj.getString("offerCoverId")));
			}
			else if(!obj.getString("lifeCoverId").isEmpty()){
				System.out.println("lifeCoverId is not empty hence setting OfferCoverId : lifeCoverId");
				customerSubscriptions.setOfferCoverId(Integer.parseInt(obj.getString("lifeCoverId")));
			}else if(!obj.getString("hospCoverId").isEmpty()){
				System.out.println("hospCoverId is not empty hence setting OfferCoverId : hospCoverId");
				customerSubscriptions.setOfferCoverId(Integer.parseInt(obj.getString("hospCoverId")));
			}else{
				System.out.println("offerCoverId, lifeCoverId and hospCoverId, All are Empty in the JSON");
				customerSubscriptions.setOfferCoverId(11);
			}
			//customerSubscriptions.setOfferCoverId(Integer.parseInt(obj.getString("offerCoverId")));
			if(!obj.getString("healthSMSFrequency").isEmpty()){
				System.out.println("healthSMSFrequency is Not Empty");
				customerSubscriptions.setHealthTipsSmsFrequency(obj.getInt("healthSMSFrequency"));
			}
			else{
				System.out.println("healthSMSFrequency is Empty hence setting Zero");
				customerSubscriptions.setHealthTipsSmsFrequency(6);
			}
			if(!obj.getString("registrationChannelId").isEmpty()){
				System.out.println("registrationChannelId is Not Empty");
				customerSubscriptions.setRegisteredChannelId(5);
			}
			else{
				System.out.println("registrationChannelId is Empty hence setting five");
				customerSubscriptions.setRegisteredChannelId(5);
			}
			//customerSubscriptions.setHealthTipsSmsFrequency(obj.getInt("healthSMSFrequency"));
			customerSubscriptions.setHealthTipsSmsLang("B");
			customerSubscriptions.setDocumentValue("NO");
			customerSubscriptions.setDocumentTypeId(0);
			
			//Setting for setPaymentConfigurationId
			//offerId=5 and OfferCoverId=11-to-14
			if(customerSubscriptions.getOfferId()==5 && (customerSubscriptions.getOfferCoverId()==11 || customerSubscriptions.getOfferCoverId()==12)){
				customerSubscriptions.setPaymentConfigurationId(5);
			}
			else if(customerSubscriptions.getOfferId()==5 && (customerSubscriptions.getOfferCoverId()==13 || customerSubscriptions.getOfferCoverId()==14)){
				customerSubscriptions.setPaymentConfigurationId(1);
			}
			//offerId=6 and OfferCoverId=15-to-22
			if(customerSubscriptions.getOfferId()==6 && customerSubscriptions.getOfferCoverId()==15){
				customerSubscriptions.setPaymentConfigurationId(5);
			}
			else if(customerSubscriptions.getOfferId()==6 && (customerSubscriptions.getOfferCoverId()==16 || customerSubscriptions.getOfferCoverId()==17
					|| customerSubscriptions.getOfferCoverId()==18 || customerSubscriptions.getOfferCoverId()==19 || customerSubscriptions.getOfferCoverId()==20
																|| customerSubscriptions.getOfferCoverId()==21
																|| customerSubscriptions.getOfferCoverId()==22)){
				customerSubscriptions.setPaymentConfigurationId(1);
			}
			else if(customerSubscriptions.getOfferId()==6 && customerSubscriptions.getOfferCoverId()==23){
				customerSubscriptions.setPaymentConfigurationId(3);
			}
			
			
			//customerSubscriptions.setPaymentConfigurationId(1);
			customerSubscriptions.setPaymentChannelId(1);
			//customerSubscriptions.setRegisteredChannelId(obj.getInt("registrationChannelId"));
			JsonObjectBuilder custSubsBuilder = Json.createObjectBuilder();
			custSubsBuilder.add("offerId", customerSubscriptions.getOfferId());
			custSubsBuilder.add("offerCoverId",customerSubscriptions.getOfferCoverId());
			custSubsBuilder.add("healthTipsSmsFrequency",customerSubscriptions.getHealthTipsSmsFrequency());
			custSubsBuilder.add("healthTipsSmsLang",customerSubscriptions.getHealthTipsSmsLang());
			//custSubsBuilder.add("documentValue",customerSubscriptions.getDocumentValue());
			//custSubsBuilder.add("documentTypeId",customerSubscriptions.getDocumentTypeId());
			custSubsBuilder.add("paymentConfigurationId",customerSubscriptions.getPaymentConfigurationId());
			custSubsBuilder.add("paymentChannelId",customerSubscriptions.getPaymentChannelId());
			custSubsBuilder.add("registeredChannelId",customerSubscriptions.getRegisteredChannelId());
			
			JsonObject finalJsonObject;
			if(obj.getInt("offerId")==5){
				NomineeDetails nomineeDetails=new NomineeDetails();
				if(request_param.contains("bkashNomineeName") && request_param.contains("bkashNomineeMsisdn")){
					nomineeDetails.setBkashNomineeName(obj.getString("bkashNomineeName").replaceAll("%20", " ").trim());
					if(!obj.getString("bkashNomineeAge").isEmpty()){
						System.out.println("bkashNomineeAge is Not Empty");
						nomineeDetails.setBkashNomineeAge(obj.getInt("bkashNomineeAge"));
					}
					else{
						System.out.println("bkashNomineeAge is Empty hence setting Zero");
						nomineeDetails.setBkashNomineeAge(5);
					}
					
					nomineeDetails.setBkashNomineeMsisdn(obj.getString("bkashNomineeMsisdn"));					
					nomineeDetails.setBkashNomineeRelation(obj.getString("bkashNomineeRelation"));					
					if(obj.getString("bkashNomineeRelation").equalsIgnoreCase("Mother")
							||obj.getString("bkashNomineeRelation").equalsIgnoreCase("Sister")
							||obj.getString("bkashNomineeRelation").equalsIgnoreCase("Daughter")){
						nomineeDetails.setBkashGender("F"); 
					}
					else if(obj.getString("bkashNomineeRelation").equalsIgnoreCase("Father")
							||obj.getString("bkashNomineeRelation").equalsIgnoreCase("Brother")
							||obj.getString("bkashNomineeRelation").equalsIgnoreCase("Son")){
						nomineeDetails.setBkashGender("M"); 
					}
					else{
						nomineeDetails.setBkashGender("F"); //setting as default which later needs to be corrected by agent
					}
				}
				else if(request_param.contains("milvikNomineeName") && request_param.contains("milvikBeneficiaryName1")){
					nomineeDetails.setBkashNomineeName(obj.getString("milvikNomineeName").replaceAll("%20", " ").trim());
					
					if(!obj.getString("milvikNomineeAge").isEmpty()){
						System.out.println("milvikNomineeAge is Not Empty");
						nomineeDetails.setBkashNomineeAge(obj.getInt("milvikNomineeAge"));
					}
					else{
						System.out.println("milvikNomineeAge is Empty hence setting Zero");
						nomineeDetails.setBkashNomineeAge(5);
					}
					//nomineeDetails.setBkashNomineeAge(obj.getInt("milvikNomineeAge"));
					nomineeDetails.setBkashNomineeMsisdn(obj.getString("milvikNomineeMsisdn"));
					nomineeDetails.setBkashNomineeRelation(obj.getString("milvikNomineeRelation"));
					if(obj.getString("milvikNomineeRelation").equalsIgnoreCase("Mother")
							||obj.getString("milvikNomineeRelation").equalsIgnoreCase("Sister")
							||obj.getString("milvikNomineeRelation").equalsIgnoreCase("Daughter")){
						nomineeDetails.setBkashGender("F"); 
					}
					else if(obj.getString("milvikNomineeRelation").equalsIgnoreCase("Father")
							||obj.getString("milvikNomineeRelation").equalsIgnoreCase("Brother")
							||obj.getString("milvikNomineeRelation").equalsIgnoreCase("Son")){
						nomineeDetails.setBkashGender("M"); 
					}
					else{
						nomineeDetails.setBkashGender("F"); //setting as default which later needs to be corrected by agent
					}
					 
										
				}
				
				JsonObjectBuilder nomineeDetailsBuilder = Json.createObjectBuilder();
				nomineeDetailsBuilder.add("name",nomineeDetails.getBkashNomineeName());
				nomineeDetailsBuilder.add("age",nomineeDetails.getBkashNomineeAge());
				nomineeDetailsBuilder.add("gender",nomineeDetails.getBkashGender());
				nomineeDetailsBuilder.add("msisdn",nomineeDetails.getBkashNomineeMsisdn());
				nomineeDetailsBuilder.add("relationship",nomineeDetails.getBkashNomineeRelation());
							
				nomineeDetailsArray.add(nomineeDetailsBuilder);
				custSubsBuilder.add("nomineeDetails", nomineeDetailsArray);
				custSubscriptionArray.add(custSubsBuilder);
				//custDetailsBuilder.add("customerSubscriptions", custSubscriptionArray);
				customerBuilder.add("customerDetails",custDetailsBuilder);
				customerBuilder.add("customerSubscriptions", custSubscriptionArray);
				finalBuilder.add("customer",customerBuilder);
				//finalCustDetailsObg=custDetailsBuilder.build();	
				finalJsonObject=finalBuilder.build();
				logger.info("finalJSON: "+finalJsonObject.toString());
				System.out.println("finalJSON: "+finalJsonObject.toString());
				//return finalCustDetailsObg.toString();
			}
			else if(obj.getInt("offerId")==6){
				NomineeDetails nomineeDetails1=new NomineeDetails();
				NomineeDetails nomineeDetails2=new NomineeDetails();
				NomineeDetails nomineeDetails3=new NomineeDetails();
				NomineeDetails nomineeDetails=new NomineeDetails();
				int bkashBeneficiaryFlag=0;
				int milvikBeneficiaryFlag=0;
				int bkashNomineeFlag=0;
				//for bkashNominee
				if(request_param.contains("bkashNomineeName") && request_param.contains("bkashNomineeMsisdn")){
					bkashNomineeFlag=1;
					nomineeDetails.setBkashNomineeName(obj.getString("bkashNomineeName").replaceAll("%20", " ").trim());
					if(!obj.getString("bkashNomineeAge").isEmpty()){
						System.out.println("bkashNomineeAge is Not Empty");
						nomineeDetails.setBkashNomineeAge(obj.getInt("bkashNomineeAge"));
					}
					else{
						System.out.println("bkashNomineeAge is Empty hence setting Zero");
						nomineeDetails.setBkashNomineeAge(5);
					}
					
					nomineeDetails.setBkashNomineeMsisdn(obj.getString("bkashNomineeMsisdn"));					
					nomineeDetails.setBkashNomineeRelation(obj.getString("bkashNomineeRelation"));					
					if(obj.getString("bkashNomineeRelation").equalsIgnoreCase("Mother")
							||obj.getString("bkashNomineeRelation").equalsIgnoreCase("Sister")
							||obj.getString("bkashNomineeRelation").equalsIgnoreCase("Daughter")){
						nomineeDetails.setBkashGender("F"); 
					}
					else if(obj.getString("bkashNomineeRelation").equalsIgnoreCase("Father")
							||obj.getString("bkashNomineeRelation").equalsIgnoreCase("Brother")
							||obj.getString("bkashNomineeRelation").equalsIgnoreCase("Son")){
						nomineeDetails.setBkashGender("M"); 
					}
					else{
						nomineeDetails.setBkashGender("F"); //setting as default which later needs to be corrected by agent
					}
					
					JsonObjectBuilder nomineeDetailsBuilder = Json.createObjectBuilder();
					nomineeDetailsBuilder.add("name",nomineeDetails.getBkashNomineeName());
					nomineeDetailsBuilder.add("age",nomineeDetails.getBkashNomineeAge());
					nomineeDetailsBuilder.add("gender",nomineeDetails.getBkashGender());
					nomineeDetailsBuilder.add("msisdn",nomineeDetails.getBkashNomineeMsisdn());
					nomineeDetailsBuilder.add("relationship",nomineeDetails.getBkashNomineeRelation());
					//logger.info("nomineeDetailsBuilder: "+nomineeDetailsBuilder.toString());
					if(!obj.getString("bkashNomineeName").isEmpty() && !obj.getString("bkashNomineeMsisdn").isEmpty() ){
						nomineeDetailsArray.add(nomineeDetailsBuilder);
					}					
				}
				//for bkashBeneficiaryName1, bkashBeneficiaryName2, bkashBeneficiaryName3
				if(request_param.contains("bkashBeneficiaryName1") && request_param.contains("bkashBeneficiaryName2")){
					bkashBeneficiaryFlag=1;
					//nomineeDetails1.setBkashNomineeName(obj.getString("bkashBeneficiaryName1"));
					nomineeDetails1.setBkashNomineeName(obj.getString("bkashBeneficiaryName1").replaceAll("%20", " ").trim());
					
					if(!obj.getString("bkashBeneficiaryAge1").isEmpty()){
						System.out.println("bkashBeneficiaryAge1 is Not Empty");
						nomineeDetails1.setBkashNomineeAge(obj.getInt("bkashBeneficiaryAge1"));
					}
					else{
						System.out.println("bkashBeneficiaryAge1 is Empty hence setting Zero");
						nomineeDetails1.setBkashNomineeAge(5);
					}
					//nomineeDetails1.setBkashNomineeAge(obj.getInt("bkashBeneficiaryAge1"));
					nomineeDetails1.setBkashNomineeMsisdn(obj.getString("bkashBeneficiaryMsisdn1"));
					//nomineeDetails1.setBkashGender("F");
					nomineeDetails1.setBkashNomineeRelation(obj.getString("bkashBeneficiaryRelation1"));
					if(obj.getString("bkashBeneficiaryRelation1").equalsIgnoreCase("Mother")
							||obj.getString("bkashBeneficiaryRelation1").equalsIgnoreCase("Wife")
							||obj.getString("bkashBeneficiaryRelation1").equalsIgnoreCase("Daughter")){
						nomineeDetails1.setBkashGender("F"); 
					}
					else if(obj.getString("bkashBeneficiaryRelation1").equalsIgnoreCase("Father")
							||obj.getString("bkashBeneficiaryRelation1").equalsIgnoreCase("Husband")
							||obj.getString("bkashBeneficiaryRelation1").equalsIgnoreCase("Son")){
						nomineeDetails1.setBkashGender("M"); 
					}
					else{
						nomineeDetails1.setBkashGender("F"); //setting as default which later needs to be corrected by agent
					}
					
					nomineeDetails2.setBkashNomineeName(obj.getString("bkashBeneficiaryName2").replaceAll("%20", " ").trim());					
					if(!obj.getString("bkashBeneficiaryAge2").isEmpty()){
						System.out.println("bkashBeneficiaryAge2 is Not Empty");
						nomineeDetails2.setBkashNomineeAge(obj.getInt("bkashBeneficiaryAge2"));
					}
					else{
						System.out.println("bkashBeneficiaryAge2 is Empty hence setting as Zero");
						nomineeDetails2.setBkashNomineeAge(0);
					}
					//nomineeDetails2.setBkashNomineeAge(obj.getInt("bkashBeneficiaryAge2"));
					nomineeDetails2.setBkashNomineeMsisdn(obj.getString("bkashBeneficiaryMsisdn2"));
					//nomineeDetails2.setBkashGender("F");
					nomineeDetails2.setBkashNomineeRelation(obj.getString("bkashBeneficiaryRelation2"));
					if(obj.getString("bkashBeneficiaryRelation2").equalsIgnoreCase("Mother")
							||obj.getString("bkashBeneficiaryRelation2").equalsIgnoreCase("Wife")
							||obj.getString("bkashBeneficiaryRelation2").equalsIgnoreCase("Daughter")){
						nomineeDetails2.setBkashGender("F"); 
					}
					else if(obj.getString("bkashBeneficiaryRelation2").equalsIgnoreCase("Father")
							||obj.getString("bkashBeneficiaryRelation2").equalsIgnoreCase("Husband")
							||obj.getString("bkashBeneficiaryRelation2").equalsIgnoreCase("Son")){
						nomineeDetails2.setBkashGender("M"); 
					}
					else{
						nomineeDetails2.setBkashGender("F"); //setting as default which later needs to be corrected by agent
					}
					
					nomineeDetails3.setBkashNomineeName(obj.getString("bkashBeneficiaryName3").replaceAll("%20", " ").trim());					
					if(!obj.getString("bkashBeneficiaryAge3").isEmpty()){
						System.out.println("bkashBeneficiaryAge3 is Not Empty");
						nomineeDetails3.setBkashNomineeAge(obj.getInt("bkashBeneficiaryAge3"));
					}
					else{
						System.out.println("bkashBeneficiaryAge3 is Empty hence setting as Zero");
						nomineeDetails3.setBkashNomineeAge(0);
					}
					//nomineeDetails3.setBkashNomineeAge(obj.getInt("bkashBeneficiaryAge3"));
					nomineeDetails3.setBkashNomineeMsisdn(obj.getString("bkashBeneficiaryMsisdn3"));
					//nomineeDetails3.setBkashGender("F");
					nomineeDetails3.setBkashNomineeRelation(obj.getString("bkashBeneficiaryRelation3"));
					if(obj.getString("bkashBeneficiaryRelation3").equalsIgnoreCase("Mother")
							||obj.getString("bkashBeneficiaryRelation3").equalsIgnoreCase("Wife")
							||obj.getString("bkashBeneficiaryRelation3").equalsIgnoreCase("Daughter")){
						nomineeDetails3.setBkashGender("F"); 
					}
					else if(obj.getString("bkashBeneficiaryRelation3").equalsIgnoreCase("Father")
							||obj.getString("bkashBeneficiaryRelation3").equalsIgnoreCase("Husband")
							||obj.getString("bkashBeneficiaryRelation3").equalsIgnoreCase("Son")){
						nomineeDetails3.setBkashGender("M"); 
					}
					else{
						nomineeDetails3.setBkashGender("F"); //setting as default which later needs to be corrected by agent
					}
					
					JsonObjectBuilder nomineeDetailsBuilder1 = Json.createObjectBuilder();
					nomineeDetailsBuilder1.add("name",nomineeDetails1.getBkashNomineeName());
					nomineeDetailsBuilder1.add("age",nomineeDetails1.getBkashNomineeAge());
					nomineeDetailsBuilder1.add("gender",nomineeDetails1.getBkashGender());
					nomineeDetailsBuilder1.add("msisdn",nomineeDetails1.getBkashNomineeMsisdn());
					nomineeDetailsBuilder1.add("relationship",nomineeDetails1.getBkashNomineeRelation());
					//logger.info("nomineeDetailsBuilder1: "+nomineeDetailsBuilder1.toString());
					
					JsonObjectBuilder nomineeDetailsBuilder2 = Json.createObjectBuilder();
					nomineeDetailsBuilder2.add("name",nomineeDetails2.getBkashNomineeName());
					nomineeDetailsBuilder2.add("age",nomineeDetails2.getBkashNomineeAge());
					nomineeDetailsBuilder2.add("gender",nomineeDetails2.getBkashGender());
					nomineeDetailsBuilder2.add("msisdn",nomineeDetails2.getBkashNomineeMsisdn());
					nomineeDetailsBuilder2.add("relationship",nomineeDetails2.getBkashNomineeRelation());
					//logger.info("nomineeDetailsBuilder2: "+nomineeDetailsBuilder2.toString());
					
					JsonObjectBuilder nomineeDetailsBuilder3 = Json.createObjectBuilder();
					nomineeDetailsBuilder3.add("name",nomineeDetails3.getBkashNomineeName());
					nomineeDetailsBuilder3.add("age",nomineeDetails3.getBkashNomineeAge());
					nomineeDetailsBuilder3.add("gender",nomineeDetails3.getBkashGender());
					nomineeDetailsBuilder3.add("msisdn",nomineeDetails3.getBkashNomineeMsisdn());
					nomineeDetailsBuilder3.add("relationship",nomineeDetails3.getBkashNomineeRelation());
					//logger.info("nomineeDetailsBuilder3: "+nomineeDetailsBuilder3.toString());
					
					if(!obj.getString("bkashBeneficiaryName1").isEmpty() && !obj.getString("bkashBeneficiaryMsisdn1").isEmpty()){
						nomineeDetailsArray.add(nomineeDetailsBuilder1);
					}
					if(!obj.getString("bkashBeneficiaryName2").isEmpty() && !obj.getString("bkashBeneficiaryMsisdn2").isEmpty()){
						nomineeDetailsArray.add(nomineeDetailsBuilder2);
					}
					if(!obj.getString("bkashBeneficiaryName3").isEmpty() && !obj.getString("bkashBeneficiaryMsisdn3").isEmpty()){
						nomineeDetailsArray.add(nomineeDetailsBuilder3);
					}
					
				}
				else if(request_param.contains("milvikBeneficiaryName1") && request_param.contains("milvikBeneficiaryName2")){ //milvikBeneficiary
					milvikBeneficiaryFlag=1;
					nomineeDetails1.setBkashNomineeName(obj.getString("milvikBeneficiaryName1").replaceAll("%20", " ").trim());					
					if(!obj.getString("milvikBeneficiaryAge1").isEmpty()){
						System.out.println("milvikBeneficiaryAge1 is Not Empty");
						nomineeDetails1.setBkashNomineeAge(obj.getInt("milvikBeneficiaryAge1"));
					}
					else{
						System.out.println("milvikBeneficiaryAge1 is Empty hence setting as Zero");
						nomineeDetails1.setBkashNomineeAge(1);
					}
					//nomineeDetails1.setBkashNomineeAge(obj.getInt("milvikBeneficiaryAge1"));
					nomineeDetails1.setBkashNomineeMsisdn(obj.getString("milvikBeneficiaryMsisdn1"));
					//nomineeDetails1.setBkashGender("F");
					nomineeDetails1.setBkashNomineeRelation(obj.getString("milvikBeneficiaryRelation1"));
					if(obj.getString("milvikBeneficiaryRelation1").equalsIgnoreCase("Mother")
							||obj.getString("milvikBeneficiaryRelation1").equalsIgnoreCase("Wife")
							||obj.getString("milvikBeneficiaryRelation1").equalsIgnoreCase("Daughter")){
						nomineeDetails1.setBkashGender("F"); 
					}
					else if(obj.getString("milvikBeneficiaryRelation1").equalsIgnoreCase("Father")
							||obj.getString("milvikBeneficiaryRelation1").equalsIgnoreCase("Husband")
							||obj.getString("milvikBeneficiaryRelation1").equalsIgnoreCase("Son")){
						nomineeDetails1.setBkashGender("M"); 
					}
					else{
						nomineeDetails1.setBkashGender("F"); //setting as default which later needs to be corrected by agent
					}
					
					nomineeDetails2.setBkashNomineeName(obj.getString("milvikBeneficiaryName2").replaceAll("%20", " ").trim());					
					if(!obj.getString("milvikBeneficiaryAge2").isEmpty()){
						System.out.println("milvikBeneficiaryAge2 is Not Empty");
						nomineeDetails2.setBkashNomineeAge(obj.getInt("milvikBeneficiaryAge2"));
					}
					else{
						System.out.println("milvikBeneficiaryAge2 is Empty hence setting as Zero");
						nomineeDetails2.setBkashNomineeAge(0);
					}
					//nomineeDetails2.setBkashNomineeAge(obj.getInt("milvikBeneficiaryAge2"));
					nomineeDetails2.setBkashNomineeMsisdn(obj.getString("milvikBeneficiaryMsisdn2"));
					//nomineeDetails2.setBkashGender("F");
					nomineeDetails2.setBkashNomineeRelation(obj.getString("milvikBeneficiaryRelation2"));
					if(obj.getString("milvikBeneficiaryRelation2").equalsIgnoreCase("Mother")
							||obj.getString("milvikBeneficiaryRelation2").equalsIgnoreCase("Wife")
							||obj.getString("milvikBeneficiaryRelation2").equalsIgnoreCase("Daughter")){
						nomineeDetails2.setBkashGender("F"); 
					}
					else if(obj.getString("milvikBeneficiaryRelation2").equalsIgnoreCase("Father")
							||obj.getString("milvikBeneficiaryRelation2").equalsIgnoreCase("Husband")
							||obj.getString("milvikBeneficiaryRelation2").equalsIgnoreCase("Son")){
						nomineeDetails2.setBkashGender("M"); 
					}
					else{
						nomineeDetails2.setBkashGender("F"); //setting as default which later needs to be corrected by agent
					}
					nomineeDetails3.setBkashNomineeName(obj.getString("milvikBeneficiaryName3").replaceAll("%20", " ").trim());
					if(!obj.getString("milvikBeneficiaryAge3").isEmpty()){
						System.out.println("milvikBeneficiaryAge3 is Not Empty");
						nomineeDetails3.setBkashNomineeAge(obj.getInt("milvikBeneficiaryAge3"));
					}
					else{
						System.out.println("milvikBeneficiaryAge3 is Empty hence setting as Zero");
						nomineeDetails3.setBkashNomineeAge(0);
					}
					//nomineeDetails3.setBkashNomineeAge(obj.getInt("milvikBeneficiaryAge3"));
					nomineeDetails3.setBkashNomineeMsisdn(obj.getString("milvikBeneficiaryMsisdn3"));
					//nomineeDetails3.setBkashGender("F");
					nomineeDetails3.setBkashNomineeRelation(obj.getString("milvikBeneficiaryRelation3"));
					if(obj.getString("milvikBeneficiaryRelation3").equalsIgnoreCase("Mother")
							||obj.getString("milvikBeneficiaryRelation3").equalsIgnoreCase("Wife")
							||obj.getString("milvikBeneficiaryRelation3").equalsIgnoreCase("Daughter")){
						nomineeDetails3.setBkashGender("F"); 
					}
					else if(obj.getString("milvikBeneficiaryRelation3").equalsIgnoreCase("Father")
							||obj.getString("milvikBeneficiaryRelation3").equalsIgnoreCase("Husband")
							||obj.getString("milvikBeneficiaryRelation3").equalsIgnoreCase("Son")){
						nomineeDetails3.setBkashGender("M"); 
					}
					else{
						nomineeDetails3.setBkashGender("F"); //setting as default which later needs to be corrected by agent
					}
					
					JsonObjectBuilder nomineeDetailsBuilder1 = Json.createObjectBuilder();
					nomineeDetailsBuilder1.add("name",nomineeDetails1.getBkashNomineeName());
					nomineeDetailsBuilder1.add("age",nomineeDetails1.getBkashNomineeAge());
					nomineeDetailsBuilder1.add("gender",nomineeDetails1.getBkashGender());
					nomineeDetailsBuilder1.add("msisdn",nomineeDetails1.getBkashNomineeMsisdn());
					nomineeDetailsBuilder1.add("relationship",nomineeDetails1.getBkashNomineeRelation());
					//logger.info("nomineeDetailsBuilder1: "+nomineeDetailsBuilder1.toString());
					
					JsonObjectBuilder nomineeDetailsBuilder2 = Json.createObjectBuilder();
					nomineeDetailsBuilder2.add("name",nomineeDetails2.getBkashNomineeName());
					nomineeDetailsBuilder2.add("age",nomineeDetails2.getBkashNomineeAge());
					nomineeDetailsBuilder2.add("gender",nomineeDetails2.getBkashGender());
					nomineeDetailsBuilder2.add("msisdn",nomineeDetails2.getBkashNomineeMsisdn());
					nomineeDetailsBuilder2.add("relationship",nomineeDetails2.getBkashNomineeRelation());
					//logger.info("nomineeDetailsBuilder2: "+nomineeDetailsBuilder2.toString());
					
					JsonObjectBuilder nomineeDetailsBuilder3 = Json.createObjectBuilder();
					nomineeDetailsBuilder3.add("name",nomineeDetails3.getBkashNomineeName());
					nomineeDetailsBuilder3.add("age",nomineeDetails3.getBkashNomineeAge());
					nomineeDetailsBuilder3.add("gender",nomineeDetails3.getBkashGender());
					nomineeDetailsBuilder3.add("msisdn",nomineeDetails3.getBkashNomineeMsisdn());
					nomineeDetailsBuilder3.add("relationship",nomineeDetails3.getBkashNomineeRelation());
					//logger.info("nomineeDetailsBuilder3: "+nomineeDetailsBuilder3.toString());
					
					if(!obj.getString("milvikBeneficiaryName1").isEmpty() && !obj.getString("milvikBeneficiaryMsisdn1").isEmpty()){
						nomineeDetailsArray.add(nomineeDetailsBuilder1);
					}
					if(!obj.getString("milvikBeneficiaryName2").isEmpty() && !obj.getString("milvikBeneficiaryMsisdn2").isEmpty()){
						nomineeDetailsArray.add(nomineeDetailsBuilder2);
					}
					if(!obj.getString("milvikBeneficiaryName3").isEmpty() && !obj.getString("milvikBeneficiaryMsisdn3").isEmpty()){
						nomineeDetailsArray.add(nomineeDetailsBuilder3);
					}
				}
				/*
				if(request_param.contains("bkashNomineeName") && request_param.contains("bkashNomineeMsisdn")){
					bkashNomineeFlag=1;
					nomineeDetails.setBkashNomineeName(obj.getString("bkashNomineeName").replaceAll("%20", "").trim());
					if(!obj.getString("bkashNomineeAge").isEmpty()){
						System.out.println("bkashNomineeAge is Not Empty");
						nomineeDetails.setBkashNomineeAge(obj.getInt("bkashNomineeAge"));
					}
					else{
						System.out.println("bkashNomineeAge is Empty hence setting Zero");
						nomineeDetails.setBkashNomineeAge(5);
					}
					
					nomineeDetails.setBkashNomineeMsisdn(obj.getString("bkashNomineeMsisdn"));					
					nomineeDetails.setBkashNomineeRelation(obj.getString("bkashNomineeRelation"));					
					if(obj.getString("bkashNomineeRelation").equalsIgnoreCase("Mother")
							||obj.getString("bkashNomineeRelation").equalsIgnoreCase("Sister")
							||obj.getString("bkashNomineeRelation").equalsIgnoreCase("Daughter")){
						nomineeDetails.setBkashGender("F"); 
					}
					else if(obj.getString("bkashNomineeRelation").equalsIgnoreCase("Father")
							||obj.getString("bkashNomineeRelation").equalsIgnoreCase("Brother")
							||obj.getString("bkashNomineeRelation").equalsIgnoreCase("Son")){
						nomineeDetails.setBkashGender("M"); 
					}
					else{
						nomineeDetails.setBkashGender("F"); //setting as default which later needs to be corrected by agent
					}
					
					JsonObjectBuilder nomineeDetailsBuilder = Json.createObjectBuilder();
					nomineeDetailsBuilder.add("name",nomineeDetails.getBkashNomineeName());
					nomineeDetailsBuilder.add("age",nomineeDetails.getBkashNomineeAge());
					nomineeDetailsBuilder.add("gender",nomineeDetails.getBkashGender());
					nomineeDetailsBuilder.add("msisdn",nomineeDetails.getBkashNomineeMsisdn());
					nomineeDetailsBuilder.add("relationship",nomineeDetails.getBkashNomineeRelation());
					logger.info("nomineeDetailsBuilder: "+nomineeDetailsBuilder.toString());
					nomineeDetailsArray.add(nomineeDetailsBuilder);
				}	*/		
				
				
				
				
				//nomineeDetailsArray.add(nomineeDetailsBuilder);
				//nomineeDetailsArray.add(nomineeDetailsBuilder1);
				//nomineeDetailsArray.add(nomineeDetailsBuilder2);
				//nomineeDetailsArray.add(nomineeDetailsBuilder3);
				//nomineeDetailsArray.add(nomineeDetailsBuilder);
				/*
				if(bkashNomineeFlag==1 && bkashBeneficiaryFlag==1 && milvikBeneficiaryFlag==0){
					logger.info("+++bkashNomineeFlag==1+++");
					if(!obj.getString("bkashNomineeName").isEmpty() && !obj.getString("bkashNomineeMsisdn").isEmpty() ){
						logger.info("bkashNomineeName & msisdn is not empty");
						nomineeDetailsArray.add(nomineeDetailsBuilder);
					}					
				}
				
				if(bkashNomineeFlag==1 && bkashBeneficiaryFlag==1 && milvikBeneficiaryFlag==0){
					logger.info("+++bkashBeneficiaryFlag==1+++");
					if(!obj.getString("bkashBeneficiaryName1").isEmpty() && !obj.getString("bkashBeneficiaryMsisdn1").isEmpty()){
						logger.info("bkashBeneficiaryName1 & msisdn1 is not empty");
						nomineeDetailsArray.add(nomineeDetailsBuilder1);
					}
					if(!obj.getString("bkashBeneficiaryName2").isEmpty() && !obj.getString("bkashBeneficiaryMsisdn2").isEmpty()){
						logger.info("bkashBeneficiaryName2 & msisdn2 is not empty");
						nomineeDetailsArray.add(nomineeDetailsBuilder2);
					}
					if(!obj.getString("bkashBeneficiaryName3").isEmpty() && !obj.getString("bkashBeneficiaryMsisdn3").isEmpty()){
						logger.info("bkashBeneficiaryName3 & msisdn3 is not empty");
						nomineeDetailsArray.add(nomineeDetailsBuilder3);
					}
				}
				if(milvikBeneficiaryFlag==1 && bkashNomineeFlag==0 && bkashBeneficiaryFlag==0){
					logger.info("+++milvikBeneficiaryFlag==1+++");
					if(!obj.getString("milvikBeneficiaryName1").isEmpty() && !obj.getString("milvikBeneficiaryMsisdn1").isEmpty()){
						logger.info("milvikBeneficiaryName1 & msisdn1 is not empty");
						nomineeDetailsArray.add(nomineeDetailsBuilder1);
					}
					if(!obj.getString("milvikBeneficiaryName2").isEmpty() && !obj.getString("milvikBeneficiaryMsisdn2").isEmpty()){
						logger.info("milvikBeneficiaryName2 & msisdn2 is not empty");
						nomineeDetailsArray.add(nomineeDetailsBuilder2);
					}
					if(!obj.getString("milvikBeneficiaryName3").isEmpty() && !obj.getString("milvikBeneficiaryMsisdn3").isEmpty()){
						logger.info("milvikBeneficiaryName3 & msisdn3 is not empty");
						nomineeDetailsArray.add(nomineeDetailsBuilder3);
					}
				}*/
				
				//logger.info("=====NomineeDetailsArray: "+nomineeDetailsArray.toString());
				/*
				if(bkashNominee){
					logger.info("Inside condition: bkashNominee==true");
					if(!obj.getString("bkashNomineeName").isEmpty() && !obj.getString("bkashNomineeMsisdn").isEmpty() ){
						logger.info("bkashNomineeName & msisdn is not empty");
						nomineeDetailsArray.add(nomineeDetailsBuilder);
					}
					
				}
				if(bkashBeneficiary){
					logger.info("Inside condition: bkashBeneficiary==true");
					if(!obj.getString("bkashBeneficiaryName1").isEmpty() && !obj.getString("bkashBeneficiaryMsisdn1").isEmpty()){
						logger.info("bkashBeneficiaryName1 & msisdn1 is not empty");
						nomineeDetailsArray.add(nomineeDetailsBuilder1);
					}
					if(!obj.getString("bkashBeneficiaryName2").isEmpty() && !obj.getString("bkashBeneficiaryMsisdn2").isEmpty()){
						logger.info("bkashBeneficiaryName2 & msisdn2 is not empty");
						nomineeDetailsArray.add(nomineeDetailsBuilder2);
					}
					if(!obj.getString("bkashBeneficiaryName3").isEmpty() && !obj.getString("bkashBeneficiaryMsisdn3").isEmpty()){
						logger.info("bkashBeneficiaryName3 & msisdn3 is not empty");
						nomineeDetailsArray.add(nomineeDetailsBuilder3);
					}					
				}
							
				if(milvikBeneficiary){
					logger.info("");
					if(!obj.getString("milvikBeneficiaryName1").isEmpty() && !obj.getString("milvikBeneficiaryMsisdn1").isEmpty()){
						logger.info("milvikBeneficiaryName1 & msisdn1 is not empty");
						nomineeDetailsArray.add(nomineeDetailsBuilder1);
					}
					if(!obj.getString("milvikBeneficiaryName2").isEmpty() && !obj.getString("milvikBeneficiaryMsisdn2").isEmpty()){
						logger.info("milvikBeneficiaryName2 & msisdn2 is not empty");
						nomineeDetailsArray.add(nomineeDetailsBuilder2);
					}
					if(!obj.getString("milvikBeneficiaryName3").isEmpty() && !obj.getString("milvikBeneficiaryMsisdn3").isEmpty()){
						logger.info("milvikBeneficiaryName3 & msisdn3 is not empty");
						nomineeDetailsArray.add(nomineeDetailsBuilder3);
					}					
				}	*/			
				
				custSubsBuilder.add("nomineeDetails", nomineeDetailsArray);
				custSubscriptionArray.add(custSubsBuilder);
				//custDetailsBuilder.add("customerSubscriptions", custSubscriptionArray);
				customerBuilder.add("customerDetails",custDetailsBuilder);
				customerBuilder.add("customerSubscriptions", custSubscriptionArray);
				finalBuilder.add("customer",customerBuilder);
				//finalCustDetailsObg=custDetailsBuilder.build();
				finalJsonObject=finalBuilder.build();
				logger.info("finalJSON: "+finalJsonObject.toString());
				//System.out.println("finalCustDetailsJSON: "+finalJsonObject.toString());
				//return finalCustDetailsObg.toString();
			}
			
			
		} catch(NumberFormatException ne){
			//System.out.println("Exception occurred: "+ne);
			ne.printStackTrace();
			logger.error("Exception occurred: "+ne);
		} catch (JSONException jse) {
			jse.printStackTrace();
			logger.error("Exception occurred: "+jse);
			//System.out.println("Exception occurred: "+jse);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occurred: "+e);
			//System.out.println("Exception occurred: "+e);
		}
		
	}
	
	
}
