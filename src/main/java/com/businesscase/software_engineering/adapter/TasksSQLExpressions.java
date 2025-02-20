package com.businesscase.software_engineering.adapter;

public class TasksSQLExpressions {
    public static String sqlFindAll(String ordenacao) {
        if (!ordenacao.matches("(?i)ASC|DESC"))
            ordenacao = "DESC";

        return """
                    SELECT 
                        tasks.id_task, 
                        tasks.title_task, 
                        tasks.description_task, 
                        tasks.status_task, 
                        tasks.data_task, 
                        tasks.data_modificacao_task 
                    FROM tasks
                    ORDER BY tasks.id_task """ + ' ' + ordenacao + ' ' + """
                    LIMIT :limite OFFSET :paginaAtual;
                """;
    }
    public static String sqlFindAll() {
        return "select * from tasks";
    }
    public static String sqlFindAll() {
        return "select * from tasks";
    }
    public static String sqlFindAll() {
        return "select * from tasks";
    }
    public static String sqlFindAll() {
        return "select * from tasks";
    }
    public static String sqlFindAll() {
        return "select * from tasks";
    }
}
