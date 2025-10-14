## RESTful API

---

REST(Representational State Transfer)ful API는 웹 서비스간 통신을 위한 소프트웨어 아키텍처

### 원칙

1. 클라이언트-서버가 독립적으로 분리되어 있어, 각각 독립적으로 발전할 수 있다.
2. Stateless 각 요청은 독립적이며, 서버는 클라이언트 상태를 저장하지 않는다.
3. 응답 데이터는 캐시 가능여부를 명시할 수 있어, 성능을 향상 시킬 수 있다.
4. 클라이언트는 서버에 직접 연결되어 있는지, 미들웨어 서버를 통해 연결되었는지 알 수 없다.
5. URI로 식별하고 HttpMethod로 일관 된 인터페이스를 제공한다.

### RESTful API의 장점

`직관적`: URL만 봐도 어떤 자원을 다루는지 쉽게 이해할 수 있다.
`확장성`: Stateless 덕분에 서버 확장이 용이하다.
`플랫폼 독립적`: HTTP를 사용하므로 어떤 언어, 플랫폼에서도 사용 가능하다.
`표준화`: HTTP 표준을 따르므로 별도 학습 없이도 이해하기 쉽다.

### HATEOAS

API 응답에 다음에 할 수 있는 행동들의 링크를 포함시키는 것

REST의 제약조건 중 하나이지만, 실무에서는 본적이 없다.

```text
GET /users/123
{
  "id": 123,
  "name": "김보근",
  "email": "kbg@naver.com",
  "links": [
    {
      "rel": "self",
      "href": "/users/123"
    },
    {
      "rel": "orders",
      "href": "/users/123/orders"
    },
    {
      "rel": "update",
      "href": "/users/123",
      "method": "PUT"
    },
    {
      "rel": "delete",
      "href": "/users/123",
      "method": "DELETE"
    }
  ]
}
```