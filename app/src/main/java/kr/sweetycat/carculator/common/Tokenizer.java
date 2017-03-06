package kr.sweetycat.carculator.common;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Yi on 2017-03-06.
 */

public class Tokenizer {
    public Tokenizer() {

    }

    /**
     * @since  17-03-06
     * @exception 2번째 인자값에 정규식 넣어줘야함 아니면 프로그램 죽음 ;;
     * @param  strTotal - 전체 문자열
     * @param  strFind  - 찾을 문자열 또는 문자
     * @return - 찾은 문자열 또는 문자의 갯수
     */
    public int TokenizerCount(String strTotal, String strFind) {
        int iTokenCount = 0;
        Pattern pPattern = Pattern.compile(strFind);
        Matcher mMatcher = pPattern.matcher(strTotal);
        while(mMatcher.find())
            iTokenCount++;

        return iTokenCount;
    }

    public int TokenizerCount(ArrayList<String> alsTotal, String strFind) {
        int iTokenCount = 0;
        String sTotal = "";
        for(int i = 0 ; i < alsTotal.size() ; i++) {
            sTotal += alsTotal.get(i);
        }

        if(sTotal.charAt(0) == '-') {
            System.out.println("charAt in()..");
            sTotal = sTotal.replaceFirst("-", "");
            System.out.println("sTotal : " +  sTotal);
        }


        Pattern pPattern = Pattern.compile(strFind);
        Matcher mMatcher = pPattern.matcher(sTotal);
        while(mMatcher.find())
            iTokenCount++;

        return iTokenCount;
    }

    public ArrayList<Integer> TokenizerPosition(String strTotal, String strFind) {
        ArrayList<Integer> alTokenPosition = new ArrayList<Integer>();

        //int iTokenPosition = 0;
        Pattern pPattern = Pattern.compile(strFind);
        Matcher mMatcher = pPattern.matcher(strTotal);

        while(mMatcher.find()) {
            alTokenPosition.add(mMatcher.start());
        }

        return alTokenPosition;
    }

//    public int TokenizerPercedencePosition(ArrayList<String> alsTotal, String strFind) {
//        String strTotal = "";
//        for(int i = 0 ; i < alsTotal.size() ; i++) {
//            strTotal += alsTotal.get(i);
//        }
//
//        Pattern pPattern = Pattern.compile(strFind);
//        Matcher mMatcher = pPattern.matcher(strTotal);
//
//        return 0;
//    }

//    public int TokenizerFirstPosition(ArrayList<String> strTotal, String strFind) {
//        int iTokenPosition = 0;
//
//        //int iTokenPosition = 0;
//        Pattern pPattern = Pattern.compile(strFind);
//        Matcher mMatcher = pPattern.matcher(strTotal);
//
//        while(mMatcher.find()) {
//            iTokenPosition = mMatcher.start();
//            break;
//        }
//
//        return iTokenPosition;
//    }
}
