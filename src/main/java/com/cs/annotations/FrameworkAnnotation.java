package com.cs.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.cs.enums.AuthorName;
import com.cs.enums.CategoryType;

@Retention(RUNTIME)
@Target(METHOD)
public @interface FrameworkAnnotation {
	
	public AuthorName [] author() default {} ;
	public CategoryType [] category()default {} ;

}
