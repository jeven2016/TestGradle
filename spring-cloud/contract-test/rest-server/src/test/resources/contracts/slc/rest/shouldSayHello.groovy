package contracts.slc.rest

import org.springframework.cloud.contract.spec.Contract

Contract.make {
  description("""
Represents a scenario in which a user say hello to server

```
given:
	any client
when:
	he say hello
then:
	server will send him back some message
```
""")
  request {
    method 'POST'
    url '/hello/message'
    body(
        who: 'Me',
        message: 'hello server~~'

    )
    headers {
      contentType(applicationJson())
    }
  }
  response {
    status 200
    body(
        client: 'Me',
        status: 'normal'
    )
    headers {
      contentType(applicationJson())
    }
  }
}
