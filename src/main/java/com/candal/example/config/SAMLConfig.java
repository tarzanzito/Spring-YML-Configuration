package com.candal.example.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("saml")
public class SAMLConfig {

  // root
  private ServiceProviderConfig serviceProvider = new ServiceProviderConfig();
  private IdentityProviderConfig identityProvider = new IdentityProviderConfig();

  public ServiceProviderConfig getServiceProvider() {
    return serviceProvider;
  }

  public IdentityProviderConfig getIdentityProvider() {
    return identityProvider;
  }

  // level one
  public static class ServiceProviderConfig {

    private String privateKeyFullFileName;
    private String certificateFullFileName;
    private String hostCertificateFullFileName;
    private String audience;
    private String providerName;
    private String issuerName;
    private String faaaLevel;

    private LoginRequestConfig loginRequest = new LoginRequestConfig();
    private NewAccountRequestConfig newAccountRequest = new NewAccountRequestConfig();

    public String getPrivateKeyFullFileName() {
      return privateKeyFullFileName;
    }

    public String getCertificateFullFileName() {
      return certificateFullFileName;
    }

    public String getHostCertificateFullFileName() {
      return hostCertificateFullFileName;
    }
    
    public String getAudience() {
      return audience;
    }

    public String getProviderName() {
      return providerName;
    }

    public String getIssuerName() {
      return issuerName;
    }

    public String getFAAALevel() {
      return faaaLevel;
    }
    
    public LoginRequestConfig getLoginRequest() {
      return loginRequest;
    }

    public NewAccountRequestConfig getNewAccountRequest() {
      return newAccountRequest;
    }

    public void setPrivateKeyFullFileName(String privateKeyFullFileName) {
      this.privateKeyFullFileName = privateKeyFullFileName;
    }

    public void setHostCertificateFullFileName(String hostCertificateFullFileName) {
      this.hostCertificateFullFileName = hostCertificateFullFileName;
    }

    public void setCertificateFullFileName(String certificateFullFileName) {
      this.certificateFullFileName = certificateFullFileName;
    }
    
    public void setAudience(String audience) {
      this.audience = audience;
    }

    public void setProviderName(String providerName) {
      this.providerName = providerName;
    }

    public void setIssuerName(String issuerName) {
      this.issuerName = issuerName;
    }

    public void setFAAALevel(String faaaLevel) {
      this.faaaLevel = faaaLevel;
    }
    
    public static class LoginRequestConfig {

      private List<AttributeIdConfig> attributeIdList = new ArrayList<>();

      public List<AttributeIdConfig> getAttributeIdList() {
        return attributeIdList;
      }

      public void setAttributeItems(List<AttributeIdConfig> attributeIdList) {
        this.attributeIdList = attributeIdList;
      }
    }

    public static class NewAccountRequestConfig {

      private List<AttributeIdConfig> attributeIdList = new ArrayList<>();

      public List<AttributeIdConfig> getAttributeIdList() {
        return attributeIdList;
      }

      public void setAttributeIdList(List<AttributeIdConfig> attributeIdList) {
        this.attributeIdList = attributeIdList;
      }
    }

    public static class AttributeIdConfig {

      private String id;
      private boolean isRequired;
      private String regExFormat;
      
      public String getId() {
        return id;
      }

      public void setId(String id) {
        this.id = id;
      }

      public boolean getIsRequired() {
        return isRequired;
      }

      public void setIsRequired(boolean isRequired) {
        this.isRequired = isRequired;
      }
      
      public String getRegExFormat() {
        return regExFormat;
      }

      public void setRegExFormat(String regExFormat) {
        this.regExFormat = regExFormat;
      }
      
    }
  }

  // level one
  public static class IdentityProviderConfig {

    private String certificateFullFileName;
    private String issuerName;
    private AttributesConfig attributes = new AttributesConfig();

    public String getCertificateFullFileName() {
      return certificateFullFileName;
    }

    public String getIssuerName() {
      return issuerName;
    }

    public AttributesConfig getAttributes() {
      return attributes;
    }

    public void setCertificateFullFileName(String certificateFullFileName) {
      this.certificateFullFileName = certificateFullFileName;
    }

    public void setIssuerName(String issuerName) {
      this.issuerName = issuerName;
    }

    public static class AttributesConfig {

      private Map<String, AttributeDataConfig> attributeDataMap = new HashMap<>();

      public void setAttributeItems(Map<String, AttributeDataConfig> attributeDataMap) {
        this.attributeDataMap = attributeDataMap;
      }

      public Map<String, AttributeDataConfig> getAttributeDataMap() {
        return attributeDataMap;
      }

      public static class AttributeDataConfig {

        private String name;
        private String attr;
        private String group;

        public String getname() {
          return name;
        }

        public void setname(String name) {
          this.name = name;
        }

        public String getattr() {
          return attr;
        }

        public void setattr(String attr) {
          this.attr = attr;
        }

        public String getgroup() {
          return group;
        }

        public void setgroup(String group) {
          this.group = group;
        }
      }
    }
  }
}
