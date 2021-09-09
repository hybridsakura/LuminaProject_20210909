package com.hybridsakura.project.app.luminabot.helper;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LuminaDetectHelper {

    public boolean checkDetectMainKeyword(@NotNull String rawMessage, @NotNull String masterKeyword, String secondKeyword, boolean requireKeywordMatch) {
        if("".equals(secondKeyword) || secondKeyword == null) {
            if(requireKeywordMatch) {
                return rawMessage.equals(masterKeyword);
            }else {
                return rawMessage.contains(masterKeyword);
            }
        } else {
          return rawMessage.contains(masterKeyword) && rawMessage.contains(secondKeyword);
        }
    }

    public boolean checkDetectOtherKeywordList(@NotNull String rawMessage, @NotNull List<String> otherKeywordList) {
        boolean checkResult = false;                                             //  默认为[真]
        for(String keyword : otherKeywordList) {
            System.out.println("当前检查对象：" + keyword);
            boolean x = rawMessage.contains(keyword);
            System.out.println("当前检查结果：[<" + keyword + ">] 在原始消息中" + (x ? "已找到匹配" : "未找到匹配"));
            checkResult = checkResult || x;
        }
        System.out.println("综合检查结果（所传列表中是否有一项符合）：" + (checkResult ? "是，至少有一项匹配" : "否，没找到"));
        return checkResult;
    }



//    public boolean sequenceMatched(Object... objects) {
//        boolean rtn = false;
//        for(Object temp : objects) {
////            if(temp)
//        }
//    }


}
