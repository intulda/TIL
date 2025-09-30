# Optional orElse vs orElseGet

---

### orElse

* orElse는 값이 있든 없든 항상 실행이 되는 함수

```java
Optional<User> user = findByUserId(id);
user.orElse(createDefualtUser());

// user 값이 없어도 항상 createDefaultUser()가 실행된다.
```

### orElseGet

* orElseGet은 값이 비어있을 때만 실행 되는 함수

```java
Optional<User> user = findByUserId(id);
user.orElseGet(() -> createDefualtUser());

// Optional이 비어 있을 때 createDefaultUser가 실핸 된다.
```

`orElse`는 이미 생성된 상수나 간단한 값을 사용할 때 사용하고,
`orElseGet`은 기본값 생성에 비용이 들 때(DB 조회, 객체생성 등) 사용한다.

맨날 사용하면서도 물어보면 왜 대답하지 못 할까?? 이번에 제대로 알고 대답하자.
