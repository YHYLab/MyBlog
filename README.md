# MyBlog

## 프로젝트 생성
spring boot project  
web/mustache/dev-tools 선택.  
static 폴더아래 html 생성하여 Hello, World 찍어본다.  

## css jquery 추가  
bootstrap 개발  
bootstrap css 추가  
jquery 추가  
회원가입 화면 bootstrap css 메뉴에서 선택  
화면 추가 단축키 : cmd + n  

## controller 생성 
controller 생성  
import package 단축키 cmd + shift + m  


## post로 data 받아서 화면에서 보여주기 
post, get 방식 전송 시 input tag 의 name 속성 설정.  
model 로 받아들이는 경우 toString 메서드가 있어야 한다.  
리다이렉트 시 return "redirect:/list" 방식으로 추가.  


## JPA  
기존 pom spring-boot 설정에서 카피하여 starter-data-jpa 부분만 변경  
줄 전체를 copy 할 때 alt + cmd + 화살표  
H2 의존성 pom 에 추가.
application.properties 에 spring.datasource 관련 설정 추가.
http://localhost:8080/h2-console/login.jsp 로 h2 접근 가능.
JpaRepository interface 추가.
Entity 설정 추가. @Id, @GeneratedValue, @Column 등 설정 추가.
Controller 에 repository 설정. 

##URL 정리 
mustash include 기능 사용.  
mustash include 기능은 templates를 root 폴더로 인식.




