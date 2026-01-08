package com.emailclient.service.interpreter;

public class SearchQueryParser {

    /**
     * Перетворює рядок типу "from:ivan subject:hello" у об'єкт Expression
     */
    public static Expression parse(String query) {
        Expression finalExpression = null;
        String[] tokens = query.split(" "); // Розбиваємо запит по пробілах

        for (String token : tokens) {
            Expression currentExpr = null;

            // Розпізнаємо команди
            if (token.toLowerCase().startsWith("from:")) {
                String searchTerm = token.substring(5); // Беремо текст після "from:"
                currentExpr = new FromExpression(searchTerm);
            }
            else if (token.toLowerCase().startsWith("subject:")) {
                String searchTerm = token.substring(8); // Беремо текст після "subject:"
                currentExpr = new SubjectExpression(searchTerm);
            }

            // Будуємо ланцюжок (дерево)
            if (currentExpr != null) {
                if (finalExpression == null) {
                    finalExpression = currentExpr;
                } else {
                    // Якщо вже є умова, додаємо нову через AND
                    finalExpression = new AndExpression(finalExpression, currentExpr);
                }
            }
        }
        return finalExpression;
    }
}