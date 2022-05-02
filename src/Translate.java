package com.amazonaws.gapp;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.translate.AmazonTranslate;
import com.amazonaws.services.translate.AmazonTranslateClient;
import com.amazonaws.services.translate.model.TranslateTextRequest;
import com.amazonaws.services.translate.model.TranslateTextResult;
 
public class Translate extends ExchangeStudent {

	/**
	 * Method to translate the questions array into selected language (German)
	 * @return translated String array, should hold German translations now
	 */
	public String[] translateQuestions() {
		
	// Needed for AWS Translate
    final String REGION = "us-east-1"; {
    	
    	// Array to hold translations
        String[] translatedArrayQuestions = new String[questions.length];
        
        // Loops through questions array, translates and adds translation String to new String array (translatedQuestions[])
        for(int i = 0; i < questions.length; i++)
        {
        	// This sets up the translation
            AWSCredentialsProvider awsCreds = DefaultAWSCredentialsProviderChain.getInstance();
            
            AmazonTranslate translate = AmazonTranslateClient.builder()
                    .withCredentials(new AWSStaticCredentialsProvider(awsCreds.getCredentials()))
                    .withRegion(REGION)
                    .build(); 
            
            // This does the translation and copies the results to the new array
            TranslateTextRequest translateQuestions = new TranslateTextRequest()
                    .withText(questions[i].toString())
                    .withSourceLanguageCode("en")
                    .withTargetLanguageCode("de");
            TranslateTextResult resultQuestions  = translate.translateText(translateQuestions);
             translatedArrayQuestions[i] = resultQuestions.toString();          	
        }
        
        // Return the newly translated array
        return translatedArrayQuestions;
 
    } }
    
	/**
	 * This should do the same as above, but this time it will translate the Options array from ExchangeStudent (the potential answers)
	 * and add the translations to a new String array {translatedArrayOptions[])
	 * @return translatedArrayOptions the new array of the translated Strings of potential answers 
	 */
	public String[] translateOptions() {
		
		// Needed for AWS Translate
	    final String REGION = "us-east-1"; {
	    	
	    	// Array to hold translations
	        String[] translatedArrayOptions = new String[options.length];
	        
	        // Loops through options array, translates each and adds result to new translated options array
	        for(int i = 0; i < options.length; i++)
	        {
	            AWSCredentialsProvider awsCreds = DefaultAWSCredentialsProviderChain.getInstance();
	            
	            AmazonTranslate translate = AmazonTranslateClient.builder()
	                    .withCredentials(new AWSStaticCredentialsProvider(awsCreds.getCredentials()))
	                    .withRegion(REGION)
	                    .build(); 
	            TranslateTextRequest translateQuestions = new TranslateTextRequest()
	                    .withText(options[i].toString())
	                    .withSourceLanguageCode("en")
	                    .withTargetLanguageCode("de");
	            TranslateTextResult resultOptions  = translate.translateText(translateQuestions);
	             translatedArrayOptions[i] = resultOptions.toString();          	
	        }
	        
	        // The translated array of options
	        return translatedArrayOptions;
	    }
}}





