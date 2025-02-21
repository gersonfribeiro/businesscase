package com.businesscase.software_engineering.adapter.crud_operations;

import com.businesscase.software_engineering.domain.Status_tasks;
import com.businesscase.software_engineering.domain.Tasks;
import com.businesscase.software_engineering.domain.TasksRepository;
import com.businesscase.software_engineering.headerPaginator.HeaderPaginator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.businesscase.software_engineering.adapter.crud_operations.TasksSQLExpressions.*;

@Repository
public class TasksJDBCRepository implements TasksRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public TasksJDBCRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Tasks> mapeamentoTasks() {
        return ((rs, rowNum) -> {
            int id_task = rs.getInt("id_task");
            String title_task = rs.getString("title_task");
            String description_task = rs.getString("description_task");
            Status_tasks status_task = Status_tasks.valueOf(rs.getString("status_task"));
            Date data_task = rs.getDate("data_task");
            Date data_modificacao_task = rs.getDate("data_modificacao_task");


            return new Tasks(id_task, title_task, description_task, status_task, data_task, data_modificacao_task);
        });
    }

    private ResultSetExtractor<List<Tasks>> tasksExtractor() {
        return rs -> {
            List<Tasks> tasks = new ArrayList<>();
            while (rs.next()) {
                int id_task = rs.getInt("id_task");
                String title_task = rs.getString("title_task");
                String description_task = rs.getString("description_task");
                Status_tasks status_task = Status_tasks.valueOf(rs.getString("status_task"));
                Date data_task = rs.getDate("data_task");
                Date data_modificacao_task = rs.getDate("data_modificacao_task");

                tasks.add(new Tasks(id_task, title_task, description_task, status_task, data_task, data_modificacao_task));
            }
            return tasks;
        };
    }

    private MapSqlParameterSource sourceParams(Tasks task) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id_task", task.getId_task());
        params.addValue("title_task", task.getTitle_task());
        params.addValue("description_task", task.getDescription_task());
        params.addValue("status_task", task.getStatus_task().name());
        params.addValue("data_task", task.getData_task());
        params.addValue("data_modificacao_task", task.getData_modificacao_task());
        return params;
    }

    @Override
    public HeaderPaginator<Tasks> tasksPaginadas(int limite, int paginaAtual, String ordenacao) {
        // calculando as informações necessárias para o cabeçalho da paginação
        int offset = Math.max((paginaAtual - 1) * limite, 0);
        limite = Math.min(Math.max(limite, 1), 100);
        int totalRegistros = Math.max(jdbcTemplate.queryForObject(sqlCountTasks(), new MapSqlParameterSource(), Integer.class), 0);
        int totalpaginas = (int) Math.ceil((double) totalRegistros / limite);

        // Parametros para consultar os registros
        MapSqlParameterSource params = new MapSqlParameterSource("limite", limite)
                .addValue("paginaAtual", offset);

        // Consulta dos registros
        List<Tasks> registros = jdbcTemplate.query(sqlFindAll(ordenacao), params, tasksExtractor());

        return new HeaderPaginator<>(limite, paginaAtual, totalRegistros, totalpaginas, registros);
    }

    @Override
    public List<Tasks> buscarTasks(String parametro) {
        return jdbcTemplate.query(
                sqlFindByAllArgs(parametro),
                new MapSqlParameterSource("parametro", parametro),
                mapeamentoTasks()
        );
    }

    @Override
    public Tasks findTaskById(int id_task) {
        List<Tasks> registros = jdbcTemplate.query(
                sqlFindById(),
                new MapSqlParameterSource("id_task", id_task),
                mapeamentoTasks()
        );
        return registros.isEmpty() ? null : registros.get(0);
    }

    @Override
    public Boolean inserirTask(Tasks task) {
        MapSqlParameterSource parameterSource = sourceParams(task);
        return jdbcTemplate.update(sqlInsertTask(), parameterSource) > 0;
    }

    @Override
    public Boolean modificarTask(Tasks task, int id_task) {
        MapSqlParameterSource parameterSource = sourceParams(task).addValue("id_task", id_task);
        return jdbcTemplate.update(sqlUpdateTask(), parameterSource) > 0;
    }

    @Override
    public Boolean deletarTask(int id_task) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource("id_task", id_task);
        return jdbcTemplate.update(sqlDeleteTask(), parameterSource) > 0;
    }
}
