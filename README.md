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


### 각 상황별 문제점
#### 메인스레드에서만 실행 시 :
요청 발생시 작업을 수행하며 block, 다음 클라이언트의 요청은 이전 요청이 끝날 때까지 대기해야함.
<br><br>
#### 별도의 스레드에서 추가 실행 시:
요청 발생마다 새로운 스레드를 생성하여 작업을 수행하며, 이는 새로운 Stack메모리 공간을 할당 받게됨. 따라서 높은 리소스 소비가 요구된다.
<br><br>

### Thread Pool을 적용하거나 비동기 처리를 통해 완화할 수 있다.