spring-stomp-websocket-test
===========================

A sample project to test issues faced with Spring STOMP WebSocket support using Spring Security and deploying to the cloud.

I have no issues running this app locally. The secured STOMP WebSocket communication works fine. However, when I deploy it to the cloud (CloudFoundry or OpenShift), it fails to initiate a WebSocket connection. DefaultHandshakeHandler : Handshake failed due to invalid Upgrade header: null

However, if you use Chrome's developer tools (or another browser's equivalent) you can see that the Upgrade header is included in the request headers for the WebSocket communication. 