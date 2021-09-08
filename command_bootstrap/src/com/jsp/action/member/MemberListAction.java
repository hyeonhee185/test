package com.jsp.action.member;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.MemberVO;
import com.jsp.request.Criteria;
import com.jsp.request.SearchCriteria;
import com.jsp.service.MemberService;

public class MemberListAction implements Action {

	private MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 작성 시 어떻게 데이터를 받을것인가, 받은것을 어떻게 처리할 것인가, 예외가 발생하면 어떻게 할 것인가, 예외발생시 다음 작업은 어떻게되는가 생각
		String url = "member/list"; // view Resolver 사용

		String pageParam = request.getParameter("page");
		String perPageNumParam = request.getParameter("perPageNum");
		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");

		SearchCriteria cri = new SearchCriteria();
		cri.setPage(pageParam);
		cri.setPerPageNum(perPageNumParam);
		cri.setSearchType(searchType);
		cri.setKeyword(keyword);

		Map<String, Object> dataMap = memberService.getMemberList(cri); // JSP forward 시 넘겨줄 데이터(request에 심어서 보내줄 것) // Exception 발생 위험 있음. (에러 페이지 이동은 FrontServlet이 처리함)

		request.setAttribute("memberList", dataMap.get("memberList"));
		request.setAttribute("pageMaker", dataMap.get("pageMaker"));

		return url; // viewresolver에 리턴
	}

}