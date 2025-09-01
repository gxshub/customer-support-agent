# Spring Boot LangChain4j: Customer Support Agent

This project is based on LangChain4j' [example](https://github.com/langchain4j/langchain4j-examples/tree/main/customer-support-agent-example) of a customer support AI agent.

The LLM parameters of this application are specified 
in the configuration file [`application.properties`](./src/main/resources/application.properties).

Key classes implementing the customer support agent include:
- [`CustomerSupportAgent.java`](./src/main/java/csci318/demo/service/CustomerSupportAgent.java)
- [`AgentConfiguration.java`](./src/main/java/csci318/demo/infrastructure/agentic/AgentConfiguration.java)
- [`Tools.java`](./src/main/java/csci318/demo/infrastructure/agentic/Tools.java)

To run this project, you need to create an API key of Google Gemini and 
define the environment variable `GEMINI_API_KEY` referencing to your API key.
Also note the [rate limits](https://ai.google.dev/gemini-api/docs/rate-limits#current-rate-limits) of Gemini models.
Other [LangChain4j-supported LLMs](https://docs.langchain4j.dev/category/language-models) (e.g., ChatGPT's models)
can be used by modifying this project.

An administrator views all bookings services:
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

The user's input message is the content following `userMessage=`.
The agent will remember the recent dialogues per session defined by `sessionId`.
