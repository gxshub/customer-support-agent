# Spring Boot LangChain4j

The LLM model name, API key and parameters of this application are specified in [`application.properties`](./src/main/resources/application.properties).

The main classes implementing the agent are:
- [`CustomerSupportAgent.java`](./src/main/java/csci318/demo/service/CustomerSupportAgent.java)
- [`AgentConfiguration.java`](./src/main/java/csci318/demo/infrastructure/agentic/AgentConfiguration.java)
- [`Tools.java`](./src/main/java/csci318/demo/infrastructure/agentic/Tools.java)

To see all bookings services (admin):
```shell
curl -G "http://localhost:8080/admin/bookings"
```

A customer checks a booking with the AI agent:
```shell
curl -G "http://localhost:8080/customerSupportAgent" \
--data-urlencode "sessionId=1" \
--data-urlencode "userMessage=Hi, when does my booking begin?"
```

```shell
curl -G "http://localhost:8080/customerSupportAgent" \
--data-urlencode "sessionId=1" \
--data-urlencode "userMessage=John Doe. The booking number is MS-777."
```

A customer cancels a booking with the AI agent:
```shell
curl -G "http://localhost:8080/customerSupportAgent" \
--data-urlencode "sessionId=2" \
--data-urlencode "userMessage=Please cancel my booking."
```

```shell
curl -G "http://localhost:8080/customerSupportAgent" \
--data-urlencode "sessionId=2" \
--data-urlencode "userMessage=John Doe. MS-777."
```