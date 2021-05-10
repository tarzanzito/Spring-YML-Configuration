package com.candal.example.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/*
 * 1 - All nested class must be static 
 * 
 * 2 - For a entry in yaml like key/value:  file-name: "xpto.txt"
 * the java getters and setters must have same name of yaml key
 * yaml: FileName, fileName, file-name, file_name
 * java: getFileName() , setFileName()
 * 
 * 3 - For a entry in yaml like group with fields: "service-provider"
 * the name of var must be equal private XXServiceProvider serviceProvider = new XXServiceProvider();
 * 
 * 
 */

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("saml") //root node 
public class YAMLConfig {

	// root childs
	private ServiceProvider serviceProvider = new ServiceProvider();
	private IdentityProvider identityProvider = new IdentityProvider();
	private Security security = new Security();

	public Security getSecurity() {
		return security;
	}

	public ServiceProvider getServiceProvider() {
		return serviceProvider;
	}

	public IdentityProvider getIdentityProvider() {
		return identityProvider;
	}

	// level one : Security
	public static class Security {

		private Oauth2 oauth2 = new Oauth2();

		public Oauth2 getOauth2() {
			return oauth2;
		}

		public static class Oauth2 {

			private Resource resource = new Resource();

			public Resource getResource() {
				return resource;
			}

			public static class Resource {

				private String checkTokenUri;
				private String unprotectedEndpoints;

				public String getCheckTokenUri() {
					return checkTokenUri;
				}

				public String getUnprotectedEndpoints() {
					return unprotectedEndpoints;
				}

				public void setCheckTokenUri(String checkTokenUri) {
					this.checkTokenUri = checkTokenUri;
				}

				public void setUnprotectedEndpoints(String unprotectedEndpoints) {
					this.unprotectedEndpoints = unprotectedEndpoints;
				}
			}
		}
	}

	// level one : ServiceProvider
	public static class ServiceProvider {

		private String privateKeyFullFileName;
		private String certificateFullFileName;
		private String audience;
		private LoginRequest loginRequest = new LoginRequest();
		private NewAccountRequest newAccountRequest = new NewAccountRequest();

		public String getPrivateKeyFullFileName() {
			return privateKeyFullFileName;
		}

		public String getCertificateFullFileName() {
			return certificateFullFileName;
		}

		public String getAudience() {
			return audience;
		}

		public LoginRequest getLoginRequest() {
			return loginRequest;
		}

		public NewAccountRequest getNewAccountRequest() {
			return newAccountRequest;
		}

		public void setPrivateKeyFullFileName(String privateKeyFullFileName) {
			this.privateKeyFullFileName = privateKeyFullFileName;
		}

		public void setCertificateFullFileName(String certificateFullFileName) {
			this.certificateFullFileName = certificateFullFileName;
		}

		public void setAudience(String audience) {
			this.audience = audience;
		}

		public static class LoginRequest {

			private List<AttributeKey> attributeKeyList = new ArrayList<>();

			public List<AttributeKey> getAttributeKeyList() {
				return attributeKeyList;
			}

			public void setAttributeItems(List<AttributeKey> attributeKeyList) {
				this.attributeKeyList = attributeKeyList;
			}

		}

		public static class NewAccountRequest {

			private List<AttributeKey> attributeKeyList = new ArrayList<>();

			public List<AttributeKey> getAttributeKeyList() {
				return attributeKeyList;
			}

			public void setAttributeKeyList(List<AttributeKey> attributeKeyList) {
				this.attributeKeyList = attributeKeyList;
			}
		}

		public static class AttributeKey {

			private String key;
			private boolean isRequired;

			public String getKey() {
				return key;
			}

			public void setKey(String key) {
				this.key = key;
			}

			public boolean getIsRquired() {
				return isRequired;
			}

			public void setIsRequired(boolean isRequired) {
				this.isRequired = isRequired;
			}

		}
	}

	// level one : IdentityProvider
	public static class IdentityProvider {

		private String certificateFullFileName;
		private String issuer;
		private Attributes attributes = new Attributes();

		public String getCertificateFullFileName() {
			return certificateFullFileName;
		}

		public String getIssuer() {
			return issuer;
		}

		public Attributes getAttributes() {
			return attributes;
		}

		public void setCertificateFullFileName(String certificateFullFileName) {
			this.certificateFullFileName = certificateFullFileName;
		}

		public void setIssuer(String issuer) {
			this.issuer = issuer;
		}

		public static class Attributes {

			private Map<String, AttributeData> attributeDataMap = new HashMap<>();

			public void setAttributeItems(Map<String, AttributeData> attributeDataMap) {
				this.attributeDataMap = attributeDataMap;
			}

			public Map<String, AttributeData> getAttributeDataMap() {
				return attributeDataMap;
			}

			public static class AttributeData {

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
