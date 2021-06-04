package com.example.demo5;

import java.util.ArrayDeque;
import java.util.Deque;

public class UnixPathOptimizer {

    public static void main(String[] args) {
        String input = "/../../foo/bar/baz";
        shortenPath(input);
    }

    public static String shortenPath(String path) {
        boolean rootPath = path.charAt(0) == '/';
        final Deque<String> stack = new ArrayDeque<>();
        String output = "";
        String[] directories = path.split("/");
        for (int i = 0; i < directories.length; i++) {
            if (!directories[i].equals("") && !directories[i].equals(".")) {
                if (!directories[i].equals("..")) {
                    stack.push(directories[i]);
                } else {
                    if (!stack.isEmpty()) {
                        if (stack.peek().equals("..")) {
                            stack.push(directories[i]);
                        } else {
                            stack.pop();
                        }
                    } else {
                        if (!rootPath) {
                            stack.push(directories[i]);
                        }
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            output = "/" + stack.pop() + output;
        }
        if (!rootPath) {
            output = output.replaceFirst("/", "");
        }
        if(rootPath && output.length() == 0){
            output += "/";
        }
        return output;
    }
}
