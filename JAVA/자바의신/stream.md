## Stream

---

### Stream 이란
data collection을 함수형 스타일로 처리 할 수 있게 해주는 API.
데이터를 선언적이고 간결하게 처리할 수 있도록 도와준다.

### 특징
1. 파이프 라인 처리
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

List<Integer> result = numbers.stream()
        .filter(number -> number % 2)
        .map(number -> number * 2)
        .collect(Collectors.toList());
```
2. 지연 연산
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

Stream<Integer> stream = numbers.stream()
        .filter(number -> number % 2)
        .map(number -> number * 2);
        
List<Integer> result = stream.collect(Collectors.toList());
```

### 왜 사용하는가?
1. 가독성 향상
```java
// 학생들 중에서 수학 점수가 80점 이상인 학생의 이름만 추출
List<String> topMathStudents = students.stream()
    .filter(student -> student.getMathScore() >= 80)
    .map(Student::getName)
    .collect(Collectors.toList()); 
```
2. 함수형 프로그래밍
```java
List<String> upperNames = names.stream()
    .map(String::toUpperCase)
    .collect(Collectors.toList());
```

3. 병렬처리 지원
```java
// 단일 스레드
long count = list.stream()
    .filter(expensive::operation)
    .count();

// 병렬 처리 (멀티 스레드)
long count = list.parallelStream()
    .filter(expensive::operation)
    .count(); 
```

4. 체이닝으로 복잡한 로직을 간단하게 처리
```java
// 주문 목록에서 2023년 주문 중 금액이 1만원 이상인 것의 평균 구하기
double averageAmount = orders.stream()
    .filter(order -> order.getYear() == 2023)
    .filter(order -> order.getAmount() >= 10000)
    .mapToDouble(Order::getAmount)
    .average()
    .orElse(0.0);
```

### 성능 오버헤드가 있다는데?
메모리가 극도로 제한적인 상황이 아니라면 유의미한 차이는 아니기때문에,
사용해도 무관하다.