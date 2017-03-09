package com.hrm.scripts;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrm.base.BaseTest;


public class Demo extends BaseTest
{

	@Test
	public void report()
	{
		Assert.fail("Just Failing");;
	}
}
