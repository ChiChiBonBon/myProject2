package tw.back.a07_EventLog.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;


@Aspect
@Component

public class Aop6_Company_PA {
	

	

	@Pointcut(value = "execution(* tw.back.a06_Company.controller.PA_UpdateController.companyPaUpdateMain*(..))")
	public void pointCut1() {
		
	}
	
//	@AfterReturning(pointcut = "pointCut1()")
//	public void printLog() {
//		System.out.println("有人提出更新需求");
//	}
	
	@AfterReturning(pointcut = "pointCut1()", returning = "result")
	public void printLog(JoinPoint point, Object result) {
		System.out.println("after: result=" + result);
		System.out.println("getTarget:  " + point.getTarget());
		System.out.println("getTarget.getClass:   " + point.getTarget().getClass());
		System.out.println("getSignature.getName:   " + point.getSignature().getName());
		System.out.println("getArgs:   " + point.getArgs()[0]);
		System.out.println("getArgs:   " + point.getArgs()[1]);
		Model object = (Model) point.getArgs()[1];
		System.out.println(object.getAttribute("ttt"));
		System.out.println("getKind:   " + point.getKind());
		System.out.println("有人提出更新需求");
	}
	
}
