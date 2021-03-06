/**
 * http://surenpi.com
*/
package org.suren.autotest.test;

import java.awt.AWTException;
import java.io.IOException;

import org.suren.autotest.test.module.HomeModule;
import org.suren.autotest.test.module.ProjectModule;
import org.suren.autotest.web.framework.annotation.AutoApplication;
import org.suren.autotest.web.framework.settings.Phoenix;
import org.suren.autotest.web.framework.util.ThreadUtil;

/**
 * AutoTest框架的一个简单示例</br>
 * @author suren
 * @date 2016年12月13日 下午7:52:06
 */
@AutoApplication(name = "Excel报告demo")
public class Test
{

	/**
	 * 入口函数
	 * @param args
	 * @throws IOException
	 * @throws AWTException 
	 */
	public static void main(String[] args) throws IOException, AWTException
	{
		Phoenix phoenix = new Phoenix(Test.class);
		phoenix.initWithData();
		
		HomeModule homeModule = phoenix.getModule(HomeModule.class);
		homeModule.login();
		
		ProjectModule projectModule = phoenix.getModule(ProjectModule.class);
		projectModule.addProject();
		
		ThreadUtil.silentSleep(3000);
		
		phoenix.close(); //关闭框架
		phoenix.shutdown(); //不调用该方法的话，excel报告文件无法保存
	}

}
