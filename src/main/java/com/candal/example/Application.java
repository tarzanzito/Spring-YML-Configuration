package com.candal.example;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.candal.example.config.YAMLConfig;
import com.candal.example.config.YAMLConfig.IdentityProvider.Attributes.AttributeData;

@SpringBootApplication
public class Application implements CommandLineRunner {

  @Autowired
  private YAMLConfig myConfig;

  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(Application.class);
    app.run();
  }

  public void run(String... args) throws Exception {

    System.out.println("------");

    System.out.println("Service Provider:");
    System.out.println("  SP-privateKeye: " + myConfig.getServiceProvider().getPrivateKeyFullFileName());
    System.out.println("  SP-certificate: " + myConfig.getServiceProvider().getCertificateFullFileName());
    System.out.println("  SP-audience: " + myConfig.getServiceProvider().getAudience());

    System.out.println("------");

    System.out.println("  SP-Login-Request (List):");
    List<YAMLConfig.ServiceProvider.AttributeKey> AttributeList1 =
        myConfig.getServiceProvider().getLoginRequest().getAttributeKeyList();

    for (YAMLConfig.ServiceProvider.AttributeKey item : AttributeList1) {
      System.out.println("    Item:[" + item.getKey() + "],[" + item.getIsRquired() + "]");
    }

    System.out.println("------");

    System.out.println("  SP-New-Acocount-Request (List):");
    List<YAMLConfig.ServiceProvider.AttributeKey> AttributeList2 =
        myConfig.getServiceProvider().getNewAccountRequest().getAttributeKeyList();

    for (YAMLConfig.ServiceProvider.AttributeKey item : AttributeList2) {
      System.out.println("    Item:[" + item.getKey() + "],[" + item.getIsRquired() + "]");
    }

    /////////////////////////////////

    System.out.println("");
    System.out.println("------");

    System.out.println("IDentity Provider:");

    System.out.println("  IDP-certificate: " + myConfig.getIdentityProvider().getCertificateFullFileName());
    System.out.println("  IDP-Issuer: " + myConfig.getIdentityProvider().getIssuer());

    System.out.println("------");

    System.out.println("  IDP-Attributes (Map):");
    Map<String, AttributeData> attributeMap = myConfig.getIdentityProvider().getAttributes().getAttributeDataMap();
    for (Map.Entry<String, AttributeData> item : attributeMap.entrySet()) {
      String key = item.getKey();
      System.out.println("    Item Key:[" + key + "]");
      AttributeData obj = item.getValue();
      System.out.println("      Item Data:[" + obj.getname() + "], [ " + obj.getattr() + "], [" + obj.getgroup() + "]");
    }

    /////////////////////////////////

    System.out.println("");
    System.out.println("------");
    System.out.println("Security:");
    System.out.println("  Oauth2:");
    System.out.println("    Resource:");
    System.out.println("      CheckTokenUri: " + myConfig.getSecurity().getOauth2().getResource().getCheckTokenUri());
    System.out.println("      UnprotectedEndpoints: " + myConfig.getSecurity().getOauth2().getResource().getUnprotectedEndpoints());

  }
}
