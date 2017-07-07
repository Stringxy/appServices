//package com.xy.studyapp.service.impl;
//
//import com.taobao.api.DefaultTaobaoClient;
//import com.taobao.api.TaobaoClient;
//import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
//import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
//import com.xy.studyapp.common.constant.SMSConstant;
//import com.xy.studyapp.service.SMSService;
//import org.springframework.stereotype.Service;
//
///**
// * Created by xy on 2017/6/26.
// */
//@Service("sMSService")
//public class SMSServiceImpl implements SMSService{
//
//
//    @Override
//    public String sendVarifyCode(String phone) throws  Exception{
//        TaobaoClient client = new DefaultTaobaoClient(SMSConstant.URL, SMSConstant.APPKEY, SMSConstant.SECRET);
//        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
//        int varifyCode=(int)(Math.random()*(9999-1000+1))+1000;
//        req.setExtend("\""+varifyCode+"\"");//公共回传参数
//        req.setSmsType(SMSConstant.SMSTYPE);//短信类型，传入值请填写normal
//        req.setSmsFreeSignName(SMSConstant.SMSSIGNNAME);//短信签名，传入的短信签名必须是在阿里大于“管理中心-验证码/短信通知/推广短信-配置短信签名”中的可用签名。
//        req.setSmsParamString("{\"number\":\""+varifyCode+"\"}");//短信模板变量，传参规则{"key":"value"}，
//        req.setRecNum(phone);//短信接收号码。
//        req.setSmsTemplateCode(SMSConstant.TEMPLATECODE);//短信模板ID
//        AlibabaAliqinFcSmsNumSendResponse rsp = null;
//            rsp = client.execute(req);
//        return String.valueOf(varifyCode);
//    }
//}
