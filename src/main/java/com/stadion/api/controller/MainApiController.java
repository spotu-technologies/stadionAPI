package com.stadion.api.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.ActionHistory;
import com.stadion.api.entity.BoxAccountLinkInfo;
import com.stadion.api.entity.BoxInfo;
import com.stadion.api.entity.BoxMatchTemplateInfo;
import com.stadion.api.entity.BoxMatchTemplateLinkInfo;
import com.stadion.api.entity.BwHistory;
import com.stadion.api.entity.CategoryInfo;
import com.stadion.api.entity.CommentData;
import com.stadion.api.entity.EventBoard;
import com.stadion.api.entity.FaqBoard;
import com.stadion.api.entity.FileData;
import com.stadion.api.entity.GuideBoard;
import com.stadion.api.entity.InjuryData;
import com.stadion.api.entity.InjuryInfo;
import com.stadion.api.entity.LevelData;
import com.stadion.api.entity.LikeData;
import com.stadion.api.entity.Member;
import com.stadion.api.entity.MemoData;
import com.stadion.api.entity.MomInfo;
import com.stadion.api.entity.MomMovementLinkInfo;
import com.stadion.api.entity.MomParticipantLinkInfo;
import com.stadion.api.entity.MomRankData;
import com.stadion.api.entity.MovementInfo;
import com.stadion.api.entity.MovementParticipantLinkInfo;
import com.stadion.api.entity.MovementPointData;
import com.stadion.api.entity.MovementRecordData;
import com.stadion.api.entity.NoticeBoard;
import com.stadion.api.entity.PolicyAgreeData;
import com.stadion.api.entity.PolicyBoard;
import com.stadion.api.entity.PolicyHistory;
import com.stadion.api.entity.PushBoard;
import com.stadion.api.entity.QnaBoard;
import com.stadion.api.entity.ReportWodItemRecommend;
import com.stadion.api.entity.ReportWodItems;
import com.stadion.api.entity.RestAccountInfo;
import com.stadion.api.entity.StardionLevelData;
import com.stadion.api.entity.TableLinkInfo;
import com.stadion.api.entity.TicketInfo;
import com.stadion.api.entity.TicketPaymentData;
import com.stadion.api.entity.TokenData;
import com.stadion.api.entity.TokenList;
import com.stadion.api.entity.WithdrawData;
import com.stadion.api.entity.WodBoxLinkInfo;
import com.stadion.api.entity.WodCategoryInfo;
import com.stadion.api.entity.WodInfo;
import com.stadion.api.entity.WodItem3RmData;
import com.stadion.api.entity.WodItem5RmData;
import com.stadion.api.entity.WodItemCategoryInfo;
import com.stadion.api.entity.WodItemInfo;
import com.stadion.api.entity.WodItemOneRmData;
import com.stadion.api.entity.WodItemRankData;
import com.stadion.api.entity.WodItemRecordData;
import com.stadion.api.entity.WodParticipantLinkInfo;
import com.stadion.api.entity.WodRecordInfo;
import com.stadion.api.entity.WodRoundInfo;
import com.stadion.api.entity.WodRoundItemInfo;
import com.stadion.api.entity.WodStepInfo;
import com.stadion.api.entity.WodTemplateInfo;
import com.stadion.api.entity.WodTemplateRecordInfo;
import com.stadion.api.entity.WodTemplateRoundInfo;
import com.stadion.api.entity.WodTemplateRoundItemInfo;
import com.stadion.api.entity.WodTemplateStepInfo;
import com.stadion.api.service.AccountInfoService;
import com.stadion.api.service.ActionHistoryService;
import com.stadion.api.service.BoxAccountLinkInfoService;
import com.stadion.api.service.BoxInfoService;
import com.stadion.api.service.BoxMatchTemplateInfoService;
import com.stadion.api.service.BoxMatchTemplateLinkInfoService;
import com.stadion.api.service.BwHistoryService;
import com.stadion.api.service.CategoryInfoService;
import com.stadion.api.service.CommentDataService;
import com.stadion.api.service.EventBoardService;
import com.stadion.api.service.FaqBoardService;
import com.stadion.api.service.FileDataService;
import com.stadion.api.service.GuideBoardService;
import com.stadion.api.service.InjuryDataService;
import com.stadion.api.service.InjuryInfoService;
import com.stadion.api.service.LevelDataService;
import com.stadion.api.service.LikeDataService;
import com.stadion.api.service.MemberService;
import com.stadion.api.service.MemoDataService;
import com.stadion.api.service.MomInfoService;
import com.stadion.api.service.MomMovementLinkInfoService;
import com.stadion.api.service.MomParticipantLinkInfoService;
import com.stadion.api.service.MomRankDataService;
import com.stadion.api.service.MovementInfoService;
import com.stadion.api.service.MovementParticipantLinkInfoService;
import com.stadion.api.service.MovementPointDataService;
import com.stadion.api.service.MovementRecordDataService;
import com.stadion.api.service.NoticeBoardService;
import com.stadion.api.service.PolicyAgreeDataService;
import com.stadion.api.service.PolicyBoardService;
import com.stadion.api.service.PolicyHistoryService;
import com.stadion.api.service.PushBoardService;
import com.stadion.api.service.QnaBoardService;
import com.stadion.api.service.ReportWodItemRecommendService;
import com.stadion.api.service.ReportWodItemsService;
import com.stadion.api.service.RestAccountInfoService;
import com.stadion.api.service.StardionLevelDataService;
import com.stadion.api.service.TableLinkInfoService;
import com.stadion.api.service.TicketInfoService;
import com.stadion.api.service.TicketPaymentDataService;
import com.stadion.api.service.TokenDataService;
import com.stadion.api.service.TokenListService;
import com.stadion.api.service.WithdrawDataService;
import com.stadion.api.service.WodBoxLinkInfoService;
import com.stadion.api.service.WodCategoryInfoService;
import com.stadion.api.service.WodInfoService;
import com.stadion.api.service.WodItem3RmDataService;
import com.stadion.api.service.WodItem5RmDataService;
import com.stadion.api.service.WodItemCategoryInfoService;
import com.stadion.api.service.WodItemInfoService;
import com.stadion.api.service.WodItemOneRmDataService;
import com.stadion.api.service.WodItemRankDataService;
import com.stadion.api.service.WodItemRecordDataService;
import com.stadion.api.service.WodParticipantLinkInfoService;
import com.stadion.api.service.WodRecordInfoService;
import com.stadion.api.service.WodRoundInfoService;
import com.stadion.api.service.WodRoundItemInfoService;
import com.stadion.api.service.WodStepInfoService;
import com.stadion.api.service.WodTemplateInfoService;
import com.stadion.api.service.WodTemplateRecordInfoService;
import com.stadion.api.service.WodTemplateRoundInfoService;
import com.stadion.api.service.WodTemplateRoundItemInfoService;
import com.stadion.api.service.WodTemplateStepInfoService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Setter;
import lombok.ToString;


@RestController
public class MainApiController {
    @Autowired
    public MemberService memberService;

    @RequestMapping(value = "/member")
    public List<Member> getTest() throws Exception{
    	//List<Member> memberList = memberService.getMember();
    	//model.addAttribute("list", memberList);
        return memberService.getMember();
    }

    // 결과를 JSON으로 변경
    @RequestMapping(value = "/getmember", method = RequestMethod.GET)
	public String getMember() {
    	String result;
    	Gson gson = new Gson();
    	List<Member> list = memberService.getMember();

    	result = gson.toJson(list);
    	
    	
		return result;

	}

    
    @Autowired
    public AccountInfoService accountInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getaccountinfo")
	public String getAccountInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	AccountInfo jsonResult = accountInfoService.getAccountInfo(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getaccountinfobyemail")
	public String getAccountInfoByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	AccountInfo jsonResult = accountInfoService.getAccountInfoByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}

    
    @Autowired
    public ActionHistoryService actionHistoryService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getactionHistory")
	public String getActionHistory(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx  = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	ActionHistory jsonResult = actionHistoryService.getActionHistory(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}

    
    @Autowired
    public BoxAccountLinkInfoService boxAccountLinkInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getboxAccountLinkInfo")
	public String getBoxAccountLinkInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	BoxAccountLinkInfo jsonResult = boxAccountLinkInfoService.getBoxAccountLinkInfo(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}
    
    
    @Autowired
    public BoxInfoService boxInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getboxInfo")
	public String getBoxInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	BoxInfo jsonResult = boxInfoService.getBoxInfo(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}

    
    @Autowired
    public BoxMatchTemplateInfoService boxMatchTemplateInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getboxMatchTemplateInfo")
	public String getBoxMatchTemplateInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	BoxMatchTemplateInfo jsonResult = boxMatchTemplateInfoService.getBoxMatchTemplateInfo(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public BoxMatchTemplateLinkInfoService boxMatchTemplateLinkInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getboxMatchTemplateLinkInfo")
	public String getBoxMatchTemplateLinkInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	BoxMatchTemplateLinkInfo jsonResult = boxMatchTemplateLinkInfoService.getBoxMatchTemplateLinkInfo(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @Autowired
    public BwHistoryService bwHistoryService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getbwHistory")
	public String getBwHistory(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	BwHistory jsonResult = bwHistoryService.getBwHistory(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public CategoryInfoService categoryInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getcategoryInfo")
	public String getCategoryInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	CategoryInfo jsonResult = categoryInfoService.getCategoryInfo(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public CommentDataService commentDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getcommentData")
	public String getCommentData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	CommentData jsonResult = commentDataService.getCommentData(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @Autowired
    public EventBoardService eventBoardService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/geteventBoard")
	public String getEventBoard(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	EventBoard jsonResult = eventBoardService.getEventBoard(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public FaqBoardService faqBoardService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getfaqBoard")
	public String getFaqBoard(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	FaqBoard jsonResult = faqBoardService.getFaqBoard(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @Autowired
    public FileDataService fileDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getfileData")
	public String getFileData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	FileData jsonResult = fileDataService.getFileData(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @Autowired
    public GuideBoardService guideBoardService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getguideBoard")
	public String getGuideBoard(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	GuideBoard jsonResult = guideBoardService.getGuideBoard(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public InjuryDataService injuryDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getinjuryData")
	public String getInjuryData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	InjuryData jsonResult = injuryDataService.getInjuryData(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public InjuryInfoService injuryInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getinjuryInfo")
	public String getInjuryInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	InjuryInfo jsonResult = injuryInfoService.getInjuryInfo(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public LevelDataService levelDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getlevelData")
	public String getLevelData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	LevelData jsonResult = levelDataService.getLevelData(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public LikeDataService likeDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getlikeData")
	public String getLikeData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	LikeData jsonResult = likeDataService.getLikeData(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public MemoDataService memoDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getmemoData")
	public String getMemoData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	MemoData jsonResult = memoDataService.getMemoData(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public MomInfoService momInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getmomInfo")
	public String getMomInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	MomInfo jsonResult = momInfoService.getMomInfo(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public MomMovementLinkInfoService momMovementLinkInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getmomMovementLinkInfo")
	public String getMomMovementLinkInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	MomMovementLinkInfo jsonResult = momMovementLinkInfoService.getMomMovementLinkInfo(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public MomParticipantLinkInfoService momParticipantLinkInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getmomParticipantLinkInfo")
	public String getMomParticipantLinkInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	MomParticipantLinkInfo jsonResult = momParticipantLinkInfoService.getMomParticipantLinkInfo(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public MomRankDataService momRankDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getmomRankData")
	public String getMomRankData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	MomRankData jsonResult = momRankDataService.getMomRankData(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public MovementInfoService movementInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getmovementInfo")
	public String getMovementInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	MovementInfo jsonResult = movementInfoService.getMovementInfo(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public MovementParticipantLinkInfoService movementParticipantLinkInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getmovementParticipantLinkInfo")
	public String getMovementParticipantLinkInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	MovementParticipantLinkInfo jsonResult = movementParticipantLinkInfoService.getMovementParticipantLinkInfo(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public MovementPointDataService movementPointDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getmovementPointData")
	public String getMovementPointData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	MovementPointData jsonResult = movementPointDataService.getMovementPointData(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public MovementRecordDataService movementRecordDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getmovementRecordData")
	public String getMovementRecordData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	MovementRecordData jsonResult = movementRecordDataService.getMovementRecordData(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public NoticeBoardService noticeBoardService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getnoticeBoard")
	public String getNoticeBoard(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	NoticeBoard jsonResult = noticeBoardService.getNoticeBoard(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public PolicyAgreeDataService policyAgreeDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getpolicyAgreeData")
	public String getPolicyAgreeData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	PolicyAgreeData jsonResult = policyAgreeDataService.getPolicyAgreeData(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public PolicyBoardService policyBoardService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getpolicyBoard")
	public String getPolicyBoard(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	PolicyBoard jsonResult = policyBoardService.getPolicyBoard(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public PolicyHistoryService policyHistoryService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getpolicyHistory")
	public String getPolicyHistory(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	PolicyHistory jsonResult = policyHistoryService.getPolicyHistory(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public PushBoardService pushBoardService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getpushBoard")
	public String getPushBoard(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	PushBoard jsonResult = pushBoardService.getPushBoard(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public QnaBoardService qnaBoardService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getqnaBoard")
	public String getQnaBoard(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	QnaBoard jsonResult = qnaBoardService.getQnaBoard(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public ReportWodItemRecommendService reportWodItemRecommendService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getreportWodItemRecommend")
	public String getReportWodItemRecommend(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	ReportWodItemRecommend jsonResult = reportWodItemRecommendService.getReportWodItemRecommend(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public ReportWodItemsService reportWodItemsService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getreportWodItems")
	public String getReportWodItems(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	ReportWodItems jsonResult = reportWodItemsService.getReportWodItems(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public RestAccountInfoService restAccountInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getrestAccountInfo")
	public String getRestAccountInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	RestAccountInfo jsonResult = restAccountInfoService.getRestAccountInfo(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getrestAccountInfobyemail")
	public String getRestAccountInfoByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	RestAccountInfo jsonResult = restAccountInfoService.getRestAccountInfoByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}


    
    @Autowired
    public StardionLevelDataService stardionLevelDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getstardionLevelData")
	public String getStardionLevelData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	StardionLevelData jsonResult = stardionLevelDataService.getStardionLevelData(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public TableLinkInfoService tableLinkInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/gettableLinkInfo")
	public String getTableLinkInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	TableLinkInfo jsonResult = tableLinkInfoService.getTableLinkInfo(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public TicketInfoService ticketInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getticketInfo")
	public String getTicketInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	TicketInfo jsonResult = ticketInfoService.getTicketInfo(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public TicketPaymentDataService ticketPaymentDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getticketPaymentData")
	public String getTicketPaymentData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	TicketPaymentData jsonResult = ticketPaymentDataService.getTicketPaymentData(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public TokenDataService tokenDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/gettokenData")
	public String getTokenData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	TokenData jsonResult = tokenDataService.getTokenData(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public TokenListService tokenListService;
     
 // POST는 @PostMapping 사용
    @PostMapping("/gettokenList")
	public String getTokenList(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	TokenList jsonResult = tokenListService.getTokenList(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}

    
    @Autowired
    public WithdrawDataService withdrawDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwithdrawData")
	public String getWithdrawData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WithdrawData jsonResult = withdrawDataService.getWithdrawData(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public WodBoxLinkInfoService wodBoxLinkInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodBoxLinkInfo")
	public String getWodBoxLinkInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodBoxLinkInfo jsonResult = wodBoxLinkInfoService.getWodBoxLinkInfo(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public WodCategoryInfoService wodCategoryInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodCategoryInfo")
	public String getWodCategoryInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodCategoryInfo jsonResult = wodCategoryInfoService.getWodCategoryInfo(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public WodInfoService wodInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodInfo")
	public String getWodInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodInfo jsonResult = wodInfoService.getWodInfo(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public WodItem3RmDataService wodItem3RmDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodItem3RmData")
	public String getWodItem3RmData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodItem3RmData jsonResult = wodItem3RmDataService.getWodItem3RmData(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public WodItem5RmDataService wodItem5RmDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodItem5RmData")
	public String getWodItem5RmData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodItem5RmData jsonResult = wodItem5RmDataService.getWodItem5RmData(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public WodItemCategoryInfoService wodItemCategoryInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodItemCategoryInfo")
	public String getWodItemCategoryInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodItemCategoryInfo jsonResult = wodItemCategoryInfoService.getWodItemCategoryInfo(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public WodItemInfoService wodItemInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodItemInfo")
	public String getWodItemInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodItemInfo jsonResult = wodItemInfoService.getWodItemInfo(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public WodItemOneRmDataService wodItemOneRmDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodItemOneRmData")
	public String getWodItemOneRmData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodItemOneRmData jsonResult = wodItemOneRmDataService.getWodItemOneRmData(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public WodItemRankDataService wodItemRankDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodItemRankData")
	public String getWodItemRankData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodItemRankData jsonResult = wodItemRankDataService.getWodItemRankData(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public WodItemRecordDataService wodItemRecordDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodItemRecordData")
	public String getWodItemRecordData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodItemRecordData jsonResult = wodItemRecordDataService.getWodItemRecordData(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public WodParticipantLinkInfoService wodParticipantLinkInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodParticipantLinkInfo")
	public String getWodParticipantLinkInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodParticipantLinkInfo jsonResult = wodParticipantLinkInfoService.getWodParticipantLinkInfo(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public WodRecordInfoService wodRecordInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodRecordInfo")
	public String getWodRecordInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodRecordInfo jsonResult = wodRecordInfoService.getWodRecordInfo(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public WodRoundInfoService wodRoundInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodRoundInfo")
	public String getWodRoundInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodRoundInfo jsonResult = wodRoundInfoService.getWodRoundInfo(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public WodRoundItemInfoService wodRoundItemInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodRoundItemInfo")
	public String getWodRoundItemInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodRoundItemInfo jsonResult = wodRoundItemInfoService.getWodRoundItemInfo(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public WodStepInfoService wodStepInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodStepInfo")
	public String getWodStepInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodStepInfo jsonResult = wodStepInfoService.getWodStepInfo(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public WodTemplateInfoService wodTemplateInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodTemplateInfo")
	public String getWodTemplateInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodTemplateInfo jsonResult = wodTemplateInfoService.getWodTemplateInfo(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public WodTemplateRecordInfoService wodTemplateRecordInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodTemplateRecordInfo")
	public String getWodTemplateRecordInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodTemplateRecordInfo jsonResult = wodTemplateRecordInfoService.getWodTemplateRecordInfo(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public WodTemplateRoundInfoService wodTemplateRoundInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodTemplateRoundInfo")
	public String getWodTemplateRoundInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodTemplateRoundInfo jsonResult = wodTemplateRoundInfoService.getWodTemplateRoundInfo(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public WodTemplateRoundItemInfoService wodTemplateRoundItemInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodTemplateRoundItemInfo")
	public String getWodTemplateRoundItemInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodTemplateRoundItemInfo jsonResult = wodTemplateRoundItemInfoService.getWodTemplateRoundItemInfo(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    
    @Autowired
    public WodTemplateStepInfoService wodTemplateStepInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodTemplateStepInfo")
	public String getWodTemplateStepInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodTemplateStepInfo jsonResult = wodTemplateStepInfoService.getWodTemplateStepInfo(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}

}