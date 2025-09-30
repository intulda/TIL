# 자바에서 왜 Stack 메모리는 GC가 관리를 안해줄까?

--- 

Stack은 자동으로 관리되고 있지만, GC와는 다른 방식이다.

*GC가 필요없는 이유*
* 수명이 명확
  * 스택의 변수들은 메소드 실행 범위와 정확히 일치 하므로 메서드가 끝나면 해당 스택 프레임 전체가 즉시 제거 되기 때문
* 효율적인 메모리 관리
  * 단순히 스택 포인터를 이동시키는 것만으로 할당/해제가 가능하기 때문에 GC같은 복잡한 알고리즘이 필요 없다.
* 오버헤드 감소
  * GC는 살아있는 객체를 추적하고 마킹하는 등의 작업이 필요한데, 스택은 이런 과정이 불필요하다.

### 그렇다면 왜 Heap 메모리는 객체 수명 예측이 불가능 할까?
```java
class Service {
    private List<User> users = new ArrayList<>();
    
    void addUser(User user) {
        users.add(user);  // 이 User 객체는 언제 사라질까?
    }
}

void someMethod() {
    User user = new User("보근");  // Heap에 객체 생성
    service.addUser(user);
    // someMethod()가 끝나도 user 객체는 여전히 살아있음!
}
```

1. 여러 곳에서 참조 가능
   ```java
    User user = new User("보근");
    list1.add(user);
    list2.add(user);
    map.put("key", user);
    ```
2. 메소드 범위를 넘어서 살아남음
3. 동적으로 참조가 추가/제거된다.
4. 순환 참조 문제
   ```java
    class Node {
    Node next;
    }
    Node a = new Node();
    Node b = new Node();
    a.next = b;
    b.next = a;
    ```

이 모든 것이 실행 시점(Runtime)에 동적으로 결정되기 때문에 GC가 필요한 것 이다.