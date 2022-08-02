///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package sample.servlet;
//
//import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
//import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
//import com.google.api.client.http.javanet.NetHttpTransport;
//import com.google.api.client.json.jackson2.JacksonFactory;
///**
// *
// * @author Vu Dang
// */
//
//public class IdTokenVerifierAndParser {
//    private static final String GOOGLE_CLIENT_ID = "314092332384-u5t3rspm4a6d9spaa1hdpk9eu0ei4koa.apps.googleusercontent.com";
//
//    public static GoogleIdToken.Payload getPayload (String tokenString) throws Exception {
//
//        JacksonFactory jacksonFactory = new JacksonFactory();
//        GoogleIdTokenVerifier googleIdTokenVerifier =
//                            new GoogleIdTokenVerifier(new NetHttpTransport(), jacksonFactory);
//
//        GoogleIdToken token = GoogleIdToken.parse(jacksonFactory, tokenString);
//
//        if (googleIdTokenVerifier.verify(token)) {
//            GoogleIdToken.Payload payload = token.getPayload();
//            if (!GOOGLE_CLIENT_ID.equals(payload.getAudience())) {
//                throw new IllegalArgumentException("Audience mismatch");
//            } else if (!GOOGLE_CLIENT_ID.equals(payload.getAuthorizedParty())) {
//                throw new IllegalArgumentException("Client ID mismatch");
//            }
//            return payload;
//        } else {
//            throw new IllegalArgumentException("id token cannot be verified");
//        }
//    }
//}