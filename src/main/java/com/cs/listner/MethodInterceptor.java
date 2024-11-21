package com.cs.listner;

import java.util.ArrayList;
import java.util.List;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.cs.utils.ExcelUtils;

public final class MethodInterceptor implements IMethodInterceptor{
	
	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		
		List<IMethodInstance> result = new ArrayList<>();
		
		for (int i=0;i<methods.size();i++)
		{
			for(int j=0;j<ExcelUtils.getExcelData().size();j++)
			{
				if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(ExcelUtils.getExcelData().get(j).get("testCaseName")))
				{
					if(ExcelUtils.getExcelData().get(j).get("execute").equalsIgnoreCase("yes"))
					   result.add(methods.get(i));
					
				}
			}
		}
		
		return result;
	   }
	

}
