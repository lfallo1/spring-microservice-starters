# Spring - Angular starter

## Server includes: oauth2.0 (custom token services / enhancers and optional LDAP), email with velocity templating, secure rest controller, postgresql configuration, multiple db routing, flyway for db migrations, custom filter / interceptor / scheduling configurations, Messaging (JMS), Spring Actuator for monitoring app health / info / git / etc., Spring Events, Log4j, global exception handling, and 404 routing

## Front includes: state provider, multiple examples of named / nested views, route resolvers, http interceptor, login / token-storage system, api / db services, constants module, and basic routing

## Additionally includes docker plugin for building images, and docker-compose file for spinning up docker containers with runnable jar and postgres db

### Remote shell access defaults to localhost:2000 (i.e., ssh user@localhost -p 2000). Uses same security as configured in webapp (in this case OAuth / Ldap)
#### Set log levels through spring remote shell:
		repl groovy
		logger = org.slf4j.LoggerFactory.getLogger('path.to.class.ClassName')
		logger.setLevel(fully.qualified.ERRORLEVEL)