//package com.flightapp.user.config;
//
//import javax.xml.bind.annotation.XmlAttribute;
//import javax.xml.bind.annotation.XmlElement;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Tag;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@EnableSwagger2
////@Configuration
//public class SwaggerConfigV2 {
//
//   @Bean
//   public Docket api() {
////      return new Docket(DocumentationType.SWAGGER_2)
////         .groupName("Flight App")
////         .ignoredParameterTypes(XmlAttribute.class, XmlElement.class)
////         .select()
////         .apis(RequestHandlerSelectors.basePackage("com.flightapp"))
////         .paths(PathSelectors.any()) //PathSelectors.any()) //PathSelectors.ant("/foos/*"))
////         .build()
////         .apiInfo(apiInfo())
////         .tags(new Tag("Host Collection", "Channel API Collection for Host Integration"));
//      
//      return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).pathMapping("/").select()
//				.paths(PathSelectors.any()).build();
//   }
//
//   private ApiInfo apiInfo() {
//      return new ApiInfoBuilder()
//         .title("Flight App")
//         .description("Flight App")
//         .version("1.0")
//         .build();
//   }
//
//}
