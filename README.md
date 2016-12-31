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

## URL 정리 
mustache include 기능 사용.  
mustache include 기능은 templates를 root 폴더로 인식.  
include 폴더내의 파일을 접근하기 어려울 때 ./mvnw spring-boot:run & 명령어로 시작.  

## Update 기능 추가
restful Api를 이용하는 경우 method 파라미터러 @PathVariable type 으로 지정.  
이때 변수는 mapping에 사용되는 {} 안의 변수명이 같아야 한다.  
화면 바인딩은 {{#user}}, {{/user}} 사이에 form을 넣고 value에 바인딩 한다.   
put 이나 delete 로 수정하는 경우 input type을 hidden, name을 _method, value를 put이나 delete로 설정하고  
@PutMapping 이나 @DeletMapping으로 설정한다.  

## 간단한 login 기능 추가
JPA조회 시 기존 필드 참조 시 findBy + 필드 형식으로 추가.  
세션에 정보 추가 하고 싶으면 컨트롤러에서 HttpSession 을 받아 정보 입력.  
type으로 클래스 찾을 때 cmd + shift + t.  
리소스 찾을 때 cmd + shift + r.  


## Data 자동 import 추가
JPA에서 기본으로 루트 디렉토리에서 import.sql 문이 있으면 자동으로 실행한다.


## 로그아웃 기능 추가.
spring.mustache.expose-session-attributes=false 설정으로  
세션의 정보를 mustache에서 사용할 수 있다.  

## 리팩토링 
변수 명명 리팩토링 단축키 : alt + cmd + r  
객체의 속성 비교시에 속성 값을 꺼내오는것 보다는 객체 내부에 비교 로직을 만들어서  
객체에 위임하는 습관이 더 좋다.  
spring.jpa.show-sql=true 로 sql 문 보여지도록 설정 가능.  
spring.jpa.properties.hibernate.format-sql=true 로 좀더 보는데 편하게 볼수 있다.  

## 질문 쓰기 기능 추가
JPA에서 생성자를 사용하는 경우 기본 생성자가 반드시 있어야 한다.  
getter/setter 의 단축키는 alt + cmd + s 로 선택.  

## 객체관계 설정
객체는 서로가 관계를 설정할 수 있다.  
Question객체에서 User객체와의 관계를 선언하였는데 User객체에 관련 객체가 많을 수록  
꼭 필요로 하지 않는다면 Question에서 관계 선언하는게 좋다.  

## 보안기능 추가, LocalDateTime 과 TimeStamp 호환 설정
수정자가 글쓴이인지 확인 로직을 유저클래스에 설정.  
두 객체가 같은지는 hash코드에 의한 equals 메서드에 의해 결정된다.  
필요한 속성만 hash코드에 넣어 equals 메서드를 재정의 한다.  
JPA 와 Java 객체사이의 LocalDateTime 과 TimeStamp 객체 호환을  
위해서 LocalDateTimeAttributeConverter 를 정의 한다.  
데이터 입력시에는 TimeStamp로 변환하여 저장하고 데이터를 객체에 담을 때에는  
LocalDateTime으로 변환한다.  

## 답글 기능 추가.
답글 리스트도 질문 리스트의 객체 처럼 정의하고 사용.  
OnToMany 관계 설정.  

## 답글 달기 AJAX로 변경 
JSON 데이터 전송을 위한 Controller 의 Requetst 를 RestRquest로 변경  
e.preventDefault() 를 이용.  
ajax 이용 시 화면의 html 속성에 append 하는 방식.  

## 댓글 개수 추가
question에 count 관련 컬럼 추가  
answer이 추가되거나 삭제 될 때 count 수량 적용.  

