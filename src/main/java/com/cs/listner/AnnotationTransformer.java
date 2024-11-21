package com.cs.listner;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformer implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
	
		IAnnotationTransformer.super.transform(annotation, testClass, testConstructor, testMethod);
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}

}
