package com.businesscase.software_engineering.adapter.crud_operations;

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
                ORDER BY tasks.id_task""" + ' ' + ordenacao + ' ' + """
                    LIMIT :limite OFFSET :paginaAtual;
                """;
    }

    public static String sqlCountTasks() {
        return """
                    SELECT COUNT(*) FROM tasks;
                """;
    }

    public static String sqlFindByAllArgs(String parametro) {

        return """
                SELECT
                	tasks.id_task,
                	tasks.title_task,
                	tasks.description_task,
                	tasks.status_task,
                	tasks.data_task,
                	tasks.data_modificacao_task
                FROM tasks
                WHERE tasks.id_task LIKE""" + " '%" + parametro + "%'" + """
                OR tasks.title_task LIKE""" + " '%" + parametro + "%'" + """
                OR tasks.description_task LIKE""" + " '%" + parametro + "%'" + """
                OR tasks.status_task LIKE""" + " '%" + parametro + "%'" + """
                OR tasks.data_task LIKE""" + " '%" + parametro + "%'" + """
                OR tasks.data_modificacao_task LIKE""" + " '%" + parametro + "%';" + """
                """;
    }

    public static String sqlFindById() {
        return """
                    SELECT
                        tasks.id_task,
                        tasks.title_task,
                        tasks.description_task,
                        tasks.status_task,
                        tasks.data_task,
                        tasks.data_modificacao_task
                    FROM tasks
                    WHERE tasks.id_task = :id_task
                """;
    }

    public static String sqlInsertTask() {

        return """
                INSERT INTO tasks (
                    tasks.id_task,
                    tasks.title_task,
                    tasks.description_task,
                    tasks.status_task,
                    tasks.data_task
                ) VALUES(
                    :id_task,
                    :title_task,
                    :description_task,
                    :status_task,
                    :data_task
                );
                """;
    }

    public static String sqlUpdateTask() {

        return """
                UPDATE tasks
                SET
                    tasks.title_task = :title_task,
                    tasks.description_task = :description_task,
                    tasks.status_task = :status_task,
                    tasks.data_task = :data_task,
                    tasks.data_modificacao_task = :data_modificacao_task
                WHERE tasks.id_task = :id_task;
                """;
    }

    public static String sqlDeleteTask() {

        return """
                INSERT INTO tasks (
                    tasks.id_task,
                    tasks.title_task,
                    tasks.description_task,
                    tasks.status_task,
                    tasks.data_task
                WHERE tasks.id_task = :id_task
                """;
    }
}
