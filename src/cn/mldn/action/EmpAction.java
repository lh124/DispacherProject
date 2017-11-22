package cn.mldn.action;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import cn.mldn.util.action.ActionResourceUtil;
import cn.mldn.util.web.ModelAndView;
import cn.mldn.util.web.ServletObjectUtil;
import cn.mldn.vo.Emp;

public class EmpAction {
	public void print() {
		try {
			ServletObjectUtil.getResponse().getWriter().println("<h1>www.mldn.cn</h1>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public ModelAndView editPre() {	// 做一个增加前的页面跳转处理
		// 将跳转的路径信息设置到ModelAndView之中
		ModelAndView mav = new ModelAndView("/pages/back/admin/emp/emp_edit.jsp") ;
		mav.addObject("msg", "www.mldn.cn");	// 设置属性内容，避免了request.setAttribute()
		return mav ;
	}  
	
//	public void add(String mid, long empno, String ename, double sal, Date hiredate, int age) {
//		System.out.println("【增加雇员信息】mid = " + mid + "、empno = " + empno + "、ename = " + ename + "、sal = " + sal
//				+ "、hiredate = " + hiredate + "、age = " + age);
//	}
	public ModelAndView add(String mid,Emp emp,String inst[],long actid[]) {	// 直接接收VO对象
		ModelAndView mav = new ModelAndView(ActionResourceUtil.getPage("forward.page")) ;
		mav.addObject("msg", ActionResourceUtil.getMessage("vo.add.success", "雇员"));
		mav.addObject("url", ActionResourceUtil.getPage("emp.add.action"));
		System.out.println("【雇员增加】mid = " + mid);
		System.out.println("【雇员增加】雇员兴趣 = " + Arrays.toString(inst));
		System.out.println("【雇员增加】雇员权限 = " + Arrays.toString(actid)); 
		System.out.println(emp);
		return mav ;
	} 
	/**
	 * 实现雇员数据追加前的控制方法
	 * @return 设置跳转的处理路径
	 */
	public String addPre() {	// 做一个增加前的页面跳转处理
		return ActionResourceUtil.getPage("emp.add.page") ;
	} 
	
//	public String add(String photo,String attr, Emp vo) {
//		return "hello" ;
//	}
}
