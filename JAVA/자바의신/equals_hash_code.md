## equals 를 재정의하면 hashcode 도 재정의해야하는 이유

---

`JAVA`의 중요한 규칙 중 하나
- 두 객체가 equals()로 같다면, 반드시 같은 hashCode() 값을 가져야 한다

*왜 이런 규칙이 중요할까?*

1. 먼저 hashCode()로 버킷을 찾음
2. 그 버킷 안에서 equals()로 정확한 객체를 찾음

```java
class Person {
    private String name;
    private int age;
    
    // equals만 재정의하고 hashCode는 재정의하지 않은 경우
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && Objects.equals(name, person.name);
    }
}

// 문제 상황
Person p1 = new Person("김철수", 25);
Person p2 = new Person("김철수", 25);

System.out.println(p1.equals(p2)); // true

HashSet<Person> set = new HashSet<>();
set.add(p1);
System.out.println(set.contains(p2)); // false

```
`equals`는 재정의하여 값 (논리적 동등성)이 같아 `true`지만 메모리 주소가 다르기 때문에,
`hashCode`비교는 `false`로 나오게 된다.

따라서 `equals`와 `hashCode`는 같이 재정의 되어야 한다. 