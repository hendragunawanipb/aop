package com.example.springbootaspect.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Custom annotation used for logging execution time of any method
 * 
 * @See com.example.springbootaspect.interceptor.LogExecutionAspect
 *
 */
@Retention(RUNTIME)
@Target(METHOD)
public @interface LogExecutionTime {

}
