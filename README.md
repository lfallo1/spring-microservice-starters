# Spring Microservice

## Server includes: oauth2.0 (custom token services / enhancers and optional LDAP), email with velocity templating, secure rest controller, postgresql configuration, multiple db routing, flyway for db migrations, custom filter / interceptor / scheduling configurations, Messaging (JMS), Spring Actuator for monitoring app health / info / git / etc., Spring Events, Log4j, global exception handling, and 404 routing

## Additionally includes docker plugin for building images, and docker-compose file for spinning up docker containers with runnable jar and postgres db

### Includes admin client registration. Admin Server can be downloaded @ https://github.com/lfallo1/spring-boot-admin-server. Admin server by default runs on port 8888

### Remote shell access defaults to localhost:2000 (i.e., ssh user@localhost -p 2000). Uses same security as configured in webapp (in this case OAuth / Ldap)
#### Set log levels through spring remote shell:
		repl groovy
		logger = org.slf4j.LoggerFactory.getLogger('path.to.class.ClassName')
		logger.setLevel(fully.qualified.ERRORLEVEL)