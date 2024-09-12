package org.example.service;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final RSAKey rsaKey;

  public String createJWT(String customerId) throws JOSEException {
    JWSSigner signer = new RSASSASigner(rsaKey);
    JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
      .subject(customerId)
      .expirationTime(new Date(new Date().getTime() + 20 * 1000))
      .build();
    SignedJWT signedJWT = new SignedJWT(
      new JWSHeader.Builder(JWSAlgorithm.RS256).keyID(rsaKey.getKeyID()).build(),
      claimsSet);
    signedJWT.sign(signer);
    return signedJWT.serialize();
  }


  public boolean validateJWT(String jwtAsString) throws ParseException, JOSEException {
    RSAKey rsaPublicJWK = rsaKey.toPublicJWK();
    SignedJWT parsedJWT = SignedJWT.parse(jwtAsString);
    JWSVerifier verifier = new RSASSAVerifier(rsaPublicJWK);
    if (!parsedJWT.verify(verifier)) {
      return false;
    }
    Date certificateExpiryTime = parsedJWT.getJWTClaimsSet().getExpirationTime();
    Date currentTime = new Date();
    return !currentTime.after(certificateExpiryTime);
  }
}
