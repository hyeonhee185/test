package com.jsp.request;

public class Criteria {
   
   private int page = 1; // 페이지를 설정하지 않은 경우 자동적으로 1 설정
   private int perPageNum = 10; // 한 페이지 당 10개 보이기 설정
   private int startRowNum; // 시작 글 번호
   private int endRowNum; // 종료 글 번호
    
   public int getPage() {
      return page;
   }
   
   public void setPage(int page) {  // 페이지가 숫자 형식으로 요청이 들어온 경우
      if (page < 1) // 페이지는 최소 1페이지 이상이어야 함.
         page = 1;
      this.page = page;
   }
   
   public void setPage(String page) { // 1.1페이지가 외부 파라미터로 들어온 경우
      if (page != null && !page.isEmpty()) { //1.2 null 이거나 비어있을때
         try {
            setPage(Integer.parseInt(page)); // 1.1 페이지 숫자로 파싱
         }catch(NumberFormatException e) { // 1.2 에러처리
            this.page = 1;
         }
      }else {
         this.page = 1; // 페이지가 없는 경우 1로 설정
       }
   }
   
   public int getPerPageNum() {
      return perPageNum;
   }
   
   public void setPerPageNum(int perPageNum) {
      if(perPageNum < 1) perPageNum =1;
      this.perPageNum=perPageNum;
   }
   
   public void setPerPageNum(String perPageNum) {
      if(perPageNum != null && !perPageNum.isEmpty()) {
         try {
            setPerPageNum(Integer.parseInt(perPageNum));
         }catch(NumberFormatException e) {
            this.perPageNum = 10;
         }
      }else {
         this.perPageNum= 10; // 페이지 글 개수 설정이 없는 경우 10개로 설정
      }
   }

    public int getStartRowNum() {
         this.startRowNum = (this.page - 1) * perPageNum; // page : 1일 때, startRowNum = 0 * 10;
         return startRowNum;
      }
      public int getEndRowNum() {
         this.endRowNum = this.startRowNum + this.perPageNum; // page : 1일 때, endRowNum = 0 + 10; // 끝은 '<' 로.
         return endRowNum;
      }
   
   
   
}