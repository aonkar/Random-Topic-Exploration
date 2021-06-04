package com.example.demo5;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrintBooleanExpression {

    public static void main(String[] args) {
        System.out.println(parseBoolExpr("!(f)"));
    }

    public static boolean parseBoolExpr(String expression) {
        Deque<String> stack = new ArrayDeque<>();
        Set<String> operators = new HashSet<>();
        operators.add("&");
        operators.add("|");
        operators.add("!");
        List<String> test = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            if (operators.contains("" + expression.charAt(i))) {
                stack.push("" + expression.charAt(i));
            } else if (expression.charAt(i) == ')') {
                List<String> currentList = new ArrayList<>();
                while ((!stack.isEmpty() && !operators.contains(stack.peek()))) {
                    currentList.add(stack.pop());
                }
                String currentOperator = stack.pop();
                if (currentList.size() == 1 && currentOperator.equals("!")) {
                    if(stack.isEmpty()){
                        return currentList.get(0).equals("t") ? false : true;
                    }
                    stack.push(currentList.get(0).equals("t") ? "f" : "t");
                } else {
                    String firstChar = currentList.get(0);
                    for (int k = 1; k < currentList.size(); k++) {
                        if (currentOperator.equals("&")) {
                            if (firstChar.equals("t") && currentList.get(k).equals("t")) {
                                firstChar = "t";
                            } else {
                                firstChar = "f";
                            }
                        } else {
                            if (firstChar.equals("t") || currentList.get(k).equals("t")) {
                                firstChar = "t";
                            } else {
                                firstChar = "f";
                            }
                        }
                    }
                    if(stack.isEmpty()){
                        return (firstChar).equals("t") ? true : false;
                    }
                    stack.push(firstChar);
                }

            } else if (expression.charAt(i) != ',' && expression.charAt(i) != '(') {
                stack.push("" + expression.charAt(i));
            }
        }
        return false;
    }
}
