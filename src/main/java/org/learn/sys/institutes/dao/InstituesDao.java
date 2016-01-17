package org.learn.sys.institutes.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.learn.sys.institutes.model.Institute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InstituesDao {

    @Autowired
    DataSource dataSource;

    public String saveInstitute(Institute inst) {
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

        String sql = "insert into institutes values (:name, :type)";

        Map<String, String> namedParms = new HashMap<>();
        namedParms.put("name", inst.getName());
        namedParms.put("type", inst.getType());

        jdbcTemplate.update(sql, namedParms);

        return "SUCCESS";
    }

    public List<Institute> getAllInstitutes() {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        List<Institute> institutes = template.query("select name, type from institutes", new InstitutesRowMapper());
        return institutes;
    }

    public List<Institute> getInstitutesByType(String instType) {
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(dataSource);

        String sql = "select name, type from institutes where type = :type";
        Map<String, String> namedParms = new HashMap<>();
        namedParms.put("type", instType);

        List<Institute> institutes = template.query(sql, namedParms, new InstitutesRowMapper());
        return institutes;
    }

    class InstitutesRowMapper implements RowMapper<Institute> {

        @Override
        public Institute mapRow(ResultSet rs, int rowNumber) throws SQLException {
            Institute ins = new Institute();
            ins.setName(rs.getString(1));
            ins.setType(rs.getString(2));
            return ins;
        }
    }
}
