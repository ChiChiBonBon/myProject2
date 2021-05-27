package servlet_6;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api_6.GcisApi_6;
import jdbc_6.SqlDAO_6;
import jdbc_6.TableBean_6;

public class Control_6 implements ControlInt_6 {

	@Override
	public void selectDB(HttpServletRequest request, HttpServletResponse response, TableBean_6 bean, Connection conn,
			ServletContext context) {
		// Bean 處理
		bean.setSearch_business_NO(request.getParameter("search_business_NO"));
		System.out.println("select: " + bean.toString());
		
		// CURD處理
		SqlDAO_6 sqldao = new SqlDAO_6();
		TableBean_6 rebean = sqldao.selectDAO(bean, conn, context);
		// if Bean boolean = false
		if (rebean.getIs_DB() == false) {
			// API 處理 > Bean
			GcisApi_6 api = new GcisApi_6();
			api._APIAccounting(rebean, context);
			System.out.println("select API: " + rebean.getIs_ApiSuccess());
			// 將API 資料匯入到DB InsertDB(TableBean6 bean)
			if (rebean.getIs_ApiSuccess()) {
				rebean = sqldao.insertDAO(rebean, conn, context);
				// 資料處理
				request.setAttribute("TableBean_6", rebean);
				request.setAttribute("beanErr", "correctData");
				request.setAttribute("result", "Data From API");
				
			} else if( rebean.getIs_ApiSuccess() == false ) {
				request.setAttribute("checkOption", "select");
				request.setAttribute("result", "該資料不存在");
				try {
					System.out.println("=========false=====");
					request.getRequestDispatcher("./company_6.jsp").forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} else {
			// 資料處理
			request.setAttribute("TableBean_6", rebean);
			request.setAttribute("beanErr", "correctData");
			request.setAttribute("result", "Data From DB");
			if (!rebean.getIs_Success()) {
				request.setAttribute("result", "資料有誤，請重新輸入");
			}
		}
		request.setAttribute("formData", "flex");
		request.setAttribute("checkOption", "select");

		// JSP 處理
		try {
			request.getRequestDispatcher("./company_6.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void insertDB(HttpServletRequest request, HttpServletResponse response, TableBean_6 bean, Connection conn,
			ServletContext context) {
		// Bean 處理
		
		TableBean_6 rebean = bean;
		
		try {
			if (bean.getIs_ApiSuccess()) {

			} else {
				bean.setBusiness_Accounting_NO(request.getParameter("business_Accounting_NO"));
				bean.setCompany_Name(request.getParameter("company_Name"));
				bean.setResponsible_Name(request.getParameter("responsible_Name"));
				bean.setCompany_Location(request.getParameter("company_Location"));
				bean.setCapital_Stock_Amount(Long.valueOf(request.getParameter("capital_Stock_Amount")));
				
				// 測試資料有無錯誤
				int i = Integer.valueOf(request.getParameter("business_Accounting_NO")) +1;
				
				// CURD處理
				SqlDAO_6 sqldao = new SqlDAO_6();
				rebean = sqldao.insertDAO(bean, conn, context);
			}
		} catch (Exception e) {
			context.log("Bean Data Error", e);
		}
		System.out.println("insert: " + bean.toString());
		
		

		// 資料處理
		// 資料一開始有錯誤 - insert
		if (!rebean.getIs_Success()) {
			request.setAttribute("result", "資料有誤，請重新輸入");
			request.setAttribute("beanErr", "error");
			request.setAttribute("TableBean_6", bean);

		} else{ // insert
			request.setAttribute("beanErr", "correct");
			request.setAttribute("result", "輸入成功");
		}
		
		request.setAttribute("checkOption", "insert");
		// JSP 處理
		try {
			request.getRequestDispatcher("./company_6.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateDB(HttpServletRequest request, HttpServletResponse response, TableBean_6 bean, Connection conn,
			ServletContext context) {
		// Bean 處理
		
		TableBean_6 rebean = bean;
		
		try {
			bean.setBusiness_Accounting_NO(request.getParameter("business_Accounting_NO"));
			bean.setCompany_Name(request.getParameter("company_Name"));
			bean.setResponsible_Name(request.getParameter("responsible_Name"));
			bean.setCompany_Location(request.getParameter("company_Location"));
			bean.setCapital_Stock_Amount(Long.valueOf(request.getParameter("capital_Stock_Amount")));
			
			// 測試資料有無錯誤
			int i = Integer.valueOf(request.getParameter("business_Accounting_NO")) +1;
			
			// CURD處理
			SqlDAO_6 sqldao = new SqlDAO_6();
			rebean = sqldao.updateDAO(bean, conn, context);
			
			
		} catch (Exception e) {
			context.log("Bean Data Error", e);
		}
		System.out.println("update: " + bean.toString());
			

		// 資料處理
		if (rebean.getIs_Success()) {
			request.setAttribute("beanErr", "correct");
			request.setAttribute("result", "更新成功");
		} else {
			request.setAttribute("result", "資料有誤，請重新輸入");
			request.setAttribute("beanErr", "error");
			request.setAttribute("TableBean_6", bean);
		}
		request.setAttribute("checkOption", "update");

		// JSP 處理
		try {
			request.getRequestDispatcher("./company_6.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteDB(HttpServletRequest request, HttpServletResponse response, TableBean_6 bean, Connection conn,
			ServletContext context) {
		// Bean 處理
		bean.setSearch_business_NO(request.getParameter("search_business_NO"));
		System.out.println("delete: " + bean.toString());
		
		// CURD處理
		SqlDAO_6 sqldao = new SqlDAO_6();
		TableBean_6 rebean = sqldao.deleteDAO(bean, conn, context);

		// 資料處理
		if (rebean.getIs_Success()) {
			request.setAttribute("beanErr", "correct");
			request.setAttribute("result", "刪除成功");
		} else {
			request.setAttribute("result", "資料有誤，請重新輸入");
		}
		request.setAttribute("checkOption", "delete");

		// JSP 處理
		try {
			request.getRequestDispatcher("./company_6.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
