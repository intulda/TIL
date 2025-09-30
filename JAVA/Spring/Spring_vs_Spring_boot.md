# Spring vs Spring Boot

---

`Spring Framework`는 자바 개발을 위한 포괄적인 프레임 워크
`DI`, `AOP`, `트랜젝션 관리` 등의 핵심 기능을 제공하지만, 개발자가 많은 설정을 해야된다.
XML 설정 파일이나 자바 기반 설정을 통해 `빈 등록`, `데이터베이스 연결`, `웹 MVC` 설정 **수동**으로 구성해야하고, 필요한 라이브러리들도 일일히 
추가해야된다.

`Spring Boot`는 `Spring Framework` 위에 구축 된 도구
- 자동 설정 (Auto-Configuration): 클래스 패스에 있는 라이브러리를 감지해서 자동으로 설정
- 스타터 의존성: spring-boot-starter-web 같은 패키지로 관련 라이브러리들을 한 번에 가져올 수 있음
- 내장 서버: Tomcat, Jetty 같은 서버가 내장되어 있어 별도 WAS를 설치할 필요 없이 jar 파일로 바로 실행 가능
- 운영 준비 기능: 헬스 체크, 메트릭 같은 운영에 필요한 기능들이 기본 제공 된다.

#### 결론
`Spring Boot`는 `Spring Framework`를 쉽고 빠르게 사용할 수 있게 해주는 도구