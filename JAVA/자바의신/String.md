## new String("") vs String literal 

---

### String literal

* String pool(힙 메모리 내의 특별한 영역)이라는곳에 저장이 된다.
* 같은 값의 literal들은 하나의 객체를 공유한다.

#### String literal이 더 효율적인 이유
* 동일한 문자열을 재사용하여 메모리 절약
* 객체 생성 오버헤드가 적음
* JVM이 최적화를 더 잘 수행

### new String("문자열")

* 힙 메모리에 새로운 객체를 매번 생성
* String Pool과는 별개의 공간

#### new String() 의 단점

* 매번 새 객체 생성으로 메모리 낭비
* 가비지 컬렉션 부담 증가

### String pool

---
String Pool은 자바에서 문자열을 효율적으로 관리하기 위한 특별한 메모리 영역

#### String Pool의 기본 개념

동일한 문자열 literal들을 하나의 객체로 관리하는 힙 메모리 내의 특별한 캐시 영역

*목적*
* 메모리 사용량 최적화
* 문자열 생성 성능 향상
* 중복 문자열 제거