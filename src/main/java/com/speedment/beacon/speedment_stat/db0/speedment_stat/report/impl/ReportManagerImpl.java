package com.speedment.beacon.speedment_stat.db0.speedment_stat.report.impl;

import com.speedment.beacon.speedment_stat.db0.speedment_stat.report.Report;
import com.speedment.beacon.speedment_stat.db0.speedment_stat.report.ReportBuilder;
import com.speedment.beacon.speedment_stat.db0.speedment_stat.report.ReportManager;
import com.speedment.core.exception.SpeedmentException;
import com.speedment.core.manager.sql.AbstractSqlManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.stream.Stream;
import javax.annotation.Generated;

/**
 * A manager implementation representing an entity (for example, a row) in the Table 'speedment_stat.db0.speedment_stat.report'.
 * <p>
 * This Class or Interface has been automatically generated by Speedment.
 * Any changes made to this Class or Interface will be overwritten.
 * 
 * @author Speedment 
 */
@Generated("Speedment")
public class ReportManagerImpl extends AbstractSqlManager<Integer, Report, ReportBuilder> implements ReportManager {
    
    public ReportManagerImpl() {
        setSqlEntityMapper(this::defaultReadEntity);
    }
    
    @Override
    public ReportBuilder builder() {
        return new ReportImpl();
    }
    
    @Override
    public ReportBuilder toBuilder(Report prototype) {
        return new ReportImpl(prototype);
    }
    
    protected Report defaultReadEntity(ResultSet resultSet) {
        final ReportBuilder builder = builder();
        try {
            builder.setId(resultSet.getInt("id"));
            builder.setTitle(resultSet.getString("title"));
            builder.setSql(resultSet.getString("sql"));
            builder.setChartUrl(getString(resultSet, "chartUrl"));
            builder.setListOrder(getInt(resultSet, "listOrder"));
        }
        catch (SQLException sqle) {
            throw new SpeedmentException(sqle);
        }
        return builder;
    }
}