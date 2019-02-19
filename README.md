spring-stomp-websocket-test
===========================

A sample project to test issues faced with Spring STOMP WebSocket support using Spring Security and deploying to the cloud.

See also: [Stack Overflow question](https://stackoverflow.com/q/26452632/3754710) and Spring Framework issue [SPR-12371](https://jira.spring.io/browse/SPR-12371)

I have no issues running this app locally. The secured STOMP WebSocket communication works fine. However, when I deploy it to the cloud (CloudFoundry or OpenShift), it fails to initiate a WebSocket connection. DefaultHandshakeHandler : Handshake failed due to invalid Upgrade header: null

However, if you use Chrome's developer tools (or another browser's equivalent) you can see that the Upgrade header is included in the request headers for the WebSocket communication.
