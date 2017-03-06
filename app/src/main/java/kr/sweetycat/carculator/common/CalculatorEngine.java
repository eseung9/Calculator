package kr.sweetycat.carculator.common;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by SweetyCat on 2017-03-01.
 * 중위표기법 수식을 후위표기법 수식으로의 변환 과정
 * 1 - '('를 만나면 '('과 이후의 연산자를 Stack에 Push하고 피연산자는 출력한다.
 * 2 - 연산자를 만나면 자신보다 우선 순위가 낮은 연산자를 만날 때 까지 Stack에 있는 연산자를 계속해서 Pop하고 자신의 가장 낮은 연산자일경우 Stack에 Push한다.
 * 3 - ')'를 만나면 '('가 Pop 될 때 까지 Stack에 있는 연산자를 모두 Pop하여 출력한다.
 * 4 - 피연산자는 출력한다.
 * 5 - 수식이 없으면 Stack에 남아있는 모든 연산자를 Pop하여 출력 한다.
 *
 * 후위표시법 수식의 연산 과정
 * 1 - 피연산자는 Stack에 Push한다.
 * 2 - 연산자는 Stack에서 Pop를 두번하여 두개의 피연산자와 연산자를 연산 후 Stack에 Push한다.
 *     Stack에서 Pop를 두번 하여 연산자와 연산 할 떄는 첫번째 Pop를 통해 얻은 수치가 연산자의 뒤쪽에 위치하며
 *     두번째 Pop를 통해 언ㄷ은 수치를 연산자의 앞쪽에 위치하도록 하여 연산한다.
 */

public class CalculatorEngine {
    private Map<String,Integer> hashMap = new HashMap<String, Integer>();
    public Stack<Double> stack = new Stack<Double>();

    public CalculatorEngine() {
//        String param = "1+2*3/2+(2*3)-(10/(10-(5-3)))+(20-1)";
//        System.out.println("Infix : " + param);
//        System.out.println("??? : " + resultVal);

    }

    public void calculationsResult(String equation) {
        precedenceOfOperators();
        Queue<String> que = transformPostfix(equation);

        Double resultVal = calculatePostfix(que);
        Define.ins().sResult = String.valueOf(resultVal);



    }

    //!< 연산자 우선순위 지정
    public void precedenceOfOperators() {
        hashMap.put("+", 0);
        hashMap.put("-", 0);
        hashMap.put("*", 1);
        hashMap.put("/", 1);
        hashMap.put("%", 1);
        hashMap.put("(", -1);
        hashMap.put(".", -2);

    }

    /**
     * @param  param
     * @return Queue
     *
     */
    public Queue<String> transformPostfix(String param) {
        if(param == null || param.trim().equals(""))
            return null;

        //!< 스택 선언
        Stack<String> stack  = new Stack<String>();
        //!< 후위 변환 수식 변수선언
        StringBuilder postfixStr = new StringBuilder();
        //!< 후위 변호나 수식 Queue선언
        Queue<String> postfixQue = new LinkedList<String>();

        //!< 수식 패턴 지정
//        Pattern p = Pattern.compile("[0-9]+|\\(|\\)|\\+|\\-|\\*|\\/|\\%");
        Pattern p = Pattern.compile("[0-9]+[0-9]{0,10}|\\(|\\)|\\+|\\-|\\*|\\/|\\%");
        //^[0-9]+(.[0-9]{2})?$
//        Pattern p = Pattern.compile("0|-?[1-9][0-9]|[0-9]+(.[0-9]{2})?|\\(|\\)|\\+|\\-|\\*|\\/|\\%");
        Matcher m = p.matcher(param);

        //!< 수식 분리 및 후위 표기식 변환
        while(m.find()){
            String word = m.group();
            if(word.equals("(")) {
                stack.push(word);

            }
            else if(hashMap.containsKey(word)) {
                while(true) {
                    if(stack.isEmpty() || hashMap.get(stack.peek()) < hashMap.get(word)) {
                        stack.push(word);
                        break;
                    } else {
                        String popStr = stack.pop();
                        postfixStr.append(popStr);
                        postfixQue.add(popStr);
                    }
                    //System.out.println("stack : " + stack);
                }
            }
            else if(word.equals(")")) {
                while(true) {
                    String popStr = stack.pop();
                    if(popStr.equals("(")) {
                        break;
                    } else {
                        postfixStr.append(popStr);
                        postfixQue.add(popStr);
                    }
                }
            }
            else {
                postfixStr.append(word);
                postfixQue.add(word);
            }
        }

        while(stack.isEmpty() == false) {
            String popStr = stack.pop();
            postfixStr.append(popStr);
            postfixQue.add(popStr);
        }

        System.out.println("Postfix : " + postfixStr.toString());
        return postfixQue;
    }

    /**
     *
     * @param param
     * @return
     *
     * 후위 표기식 연산
     */
    public Double calculatePostfix(Queue<String> param) {
//        Stack<Double> stack = new Stack<Double>();

        Double firstVal;
        Double secondVal;

        while(param.isEmpty() == false) {
            String word = param.remove();

            if(hashMap.containsKey(word)) {
                //System.out.println("stack : " + stack);
                secondVal= stack.pop();
                firstVal = stack.pop();

                switch(word.charAt(0)) {
                    case '+' : stack.push(firstVal + secondVal);
                        break;
                    case '-' : stack.push(firstVal - secondVal);
                        break;
                    case '*' : stack.push(firstVal * secondVal);
                        break;
                    case '/' : stack.push(firstVal / secondVal);
                        break;
                    case '%' : stack.push(firstVal / secondVal * 100);
                        break;
                    case '.' : stack.push(firstVal + secondVal * 0.1);
                    default :
                        break;
                }

            } else {
                stack.push(Double.valueOf(word));
            }
        }
        return stack.pop();

    }

}
