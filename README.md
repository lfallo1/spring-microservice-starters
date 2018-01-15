# Spring Microservices Starter

## Server includes: oauth2.0 (custom token services / enhancers), secure rest controller, postgresql configuration, flyway for db migrations, custom filter / interceptor, Spring Actuator for monitoring app health / info / git / etc., and Log4J

### Includes admin client registration. Admin Server can be downloaded @ https://github.com/lfallo1/spring-boot-admin-server. Admin server by default runs on port 8888

### Remote shell access defaults to localhost:2000 (i.e., ssh user@localhost -p 2000). Uses same security as configured in webapp (in this case OAuth / Ldap)
#### Set log levels through spring remote shell:
		repl groovy
		logger = org.slf4j.LoggerFactory.getLogger('path.to.class.ClassName')
		logger.setLevel(fully.qualified.ERRORLEVEL)