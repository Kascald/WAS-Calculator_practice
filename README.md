## 테스트 방법 ###

***

### 1. Main 클래스 실행

### 2.  http://localhost:8080/calculate?operand1=10&operator=-&operand2=55  와 같은 쿼리 테스트



파라미터 설명 :
- operand1 : 인수 1
- operator : 연산자
- operand2 : 인수 2

GET 메서드만 인식


IntelliJ의 경우 [testHTTP.http](testHTTP.http) 실행

***
###
GET http://localhost:8080/calculate?operand1=10&operator=-&operand2=55

###
GET http://localhost:8080/calculate?operand1=10&operator=+&operand2=55

###
GET http://localhost:8080/calculate?operand1=10&operator=*&operand2=55

###
GET http://localhost:8080/calculate?operand1=10&operator=/&operand2=55
***