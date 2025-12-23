package com.loki.expensetracker;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.HashMap;
import java.util.Map;

public class ExpenseHandler implements RequestHandler<Map<String, Object>, Map<String, Object>> {

    @Override
    public Map<String, Object> handleRequest(Map<String, Object> input, Context context) {

        String httpMethod = (String) input.get("httpMethod");

        Map<String, Object> response = new HashMap<>();
        Map<String, String> headers = new HashMap<>();

        // ✅ CORS HEADERS (MANDATORY)
        headers.put("Access-Control-Allow-Origin", "*");
        headers.put("Access-Control-Allow-Methods", "GET,POST,OPTIONS");
        headers.put("Access-Control-Allow-Headers", "Content-Type");

        response.put("headers", headers);

        // ✅ OPTIONS (Preflight)
        if ("OPTIONS".equalsIgnoreCase(httpMethod)) {
            response.put("statusCode", 200);
            response.put("body", "");
            return response;
        }

        // ✅ GET
        if ("GET".equalsIgnoreCase(httpMethod)) {
            response.put("statusCode", 200);
            response.put("body", "[]");
            return response;
        }

        // ✅ POST
        if ("POST".equalsIgnoreCase(httpMethod)) {
            response.put("statusCode", 201);
            response.put("body", "{\"message\":\"Expense added successfully\"}");
            return response;
        }

        response.put("statusCode", 400);
        response.put("body", "Invalid request");
        return response;
    }
}
