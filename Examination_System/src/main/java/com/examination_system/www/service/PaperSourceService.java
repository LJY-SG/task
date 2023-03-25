package com.examination_system.www.service;

import com.examination_system.www.po.PaperSource;
import com.examination_system.www.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaperSourceService {
    public static List<PaperSource> checkPaperSource() throws SQLException {
        ResultSet rs = JDBCUtil.SelectAll("PaperSource");
        List<PaperSource> paperSources = new ArrayList<>();
        while (rs.next()){
            PaperSource paperSource = new PaperSource();

            paperSource.setId(rs.getInt("id"));
            paperSource.setPaperName(rs.getString("PaperName"));

            paperSources.add(paperSource);
        }
        return paperSources;
    }
}
