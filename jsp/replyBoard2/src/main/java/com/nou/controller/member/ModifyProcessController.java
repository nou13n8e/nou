package com.nou.controller.member;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nou.model.MemberDao;
import com.nou.model.MemberDto;
import com.nou.utils.ScriptWriter;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/member/modifyProcess")
public class ModifyProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ModifyProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String encoding="utf-8";									//업로드할 파일의 형식을 결정		
		
		int fileSize=1024*1024*10;									//업로드할 파일의 크기를 결정
		String savePath="upload";									//업로드할 파일의 경로를 결정(임의의 폴더명 지정 가능)
		ServletContext context=this.getServletContext();			//web project setting-context root/upload에 저장(복잡한 경로)
		String realPath=context.getRealPath(savePath);				

		DefaultFileRenamePolicy fileRenamePolicy=new DefaultFileRenamePolicy();
		
		MultipartRequest multipartRequest=new MultipartRequest(request, realPath, fileSize, encoding, fileRenamePolicy);
		//multipart/form-data를 사용하면 request로 값을 받을 수 없기 때문에 multipartRequest를 사용해서 값을 받아야 한다(매개변수 5개 필요)
		
		String userId=multipartRequest.getParameter("userId");
		String userPw=multipartRequest.getParameter("userPw");
		String userName=multipartRequest.getParameter("userName");
		int userZonecode=Integer.parseInt(multipartRequest.getParameter("zonecode"));
		String userAddress=multipartRequest.getParameter("userAddress");
		String userDetailAddress=multipartRequest.getParameter("detailAddress");
		String userExtraAddress=multipartRequest.getParameter("extraAddress");
		String userEmail=multipartRequest.getParameter("userEmail");
		String userProfile=multipartRequest.getOriginalFileName("profile");
		String userRealProfile=multipartRequest.getFilesystemName("profile");
		
		MemberDao memberDao=new MemberDao();
		MemberDto memberDto=new MemberDto();
		
		memberDto.setId(userId);
		memberDto.setName(userName);
		memberDto.setEmail(userEmail);
		memberDto.setPassword(userPw);
		memberDto.setZonecode(userZonecode);
		memberDto.setAddress(userAddress);
		memberDto.setDetailAddress(userDetailAddress);
		memberDto.setExtraAddress(userExtraAddress);
		memberDto.setProfile(userProfile);
		memberDto.setRealProfile(userRealProfile);
		
		int result=memberDao.modifyMember(memberDto);
		if(result>0) {
			HttpSession session=request.getSession();
			session.invalidate();
			ScriptWriter.alertAndNext(response, "회원 정보가 수정되었습니다.", "../member/login"); 
		} else {
			ScriptWriter.alertAndBack(response, "알 수 없는 오류가 발생했습니다. 다시 시도해주세요.");
		}

	}

}
