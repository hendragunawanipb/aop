# AOP with Spring Boot - AspectJ



## AOP Concepts

* **join point** - any identifiable places in the program 
* **pointcut** - defined collection of join points
* **advice** - logic implementation executed before, after or instead of reaching pointcut
* **aspect** - combination of advices and pointcuts; decides what should be executed in which place
* **introduction** - adding to new fields, methods, interfaces implementations to the class
* **target object** - object enriched with new logic
* **AOP proxy** - proxy object which encapsulates target object and adds new logic by the given aspects
* **weaving** - process of adding aspect to target object
    * compile time
    * load time
    * runtime


### Dependency:

**aspectjrt & aspectjweaver**

```xml
        <dependency>
			<groupId>org.aspectj</groupId>
			<artifactId>aspectjrt</artifactId>
			<version>1.9.9.1</version>
		</dependency>
		<dependency>
			<groupId>org.aspectj</groupId>
			<artifactId>aspectjweaver</artifactId>
			<version>1.9.9.1</version>
		</dependency>
```


additional dependency for this project

**javafaker & lombok**

```xml
		<dependency>
			<groupId>com.github.javafaker</groupId>
			<artifactId>javafaker</artifactId>
			<version>1.0.2</version>
		</dependency>

		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<scope>provided</scope>
		</dependency>
```

**logging**

_logback.xml_

### Aspect declare:

```java
@Aspect
@Component
public class LogExecutionAspect {
	...
}
```

### Annotation Class

```java
@Retention(RUNTIME)
@Target(METHOD)
public @interface LogExecutionTime {

}
```

