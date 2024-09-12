package org.example.config;

import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JWTConfig {

  @SneakyThrows
  @Bean
  public RSAKey createPrivateKey() {
    return new RSAKeyGenerator(2048)
      .keyID("4444")
      .generate();
  }

}
