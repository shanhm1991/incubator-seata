/*
 *  Copyright 1999-2019 Seata.io Group.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package io.seata.sqlparser.druid.polardbx;

import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLSelectStatement;
import io.seata.common.loader.LoadLevel;
import io.seata.sqlparser.SQLRecognizer;
import io.seata.sqlparser.druid.SQLOperateRecognizerHolder;
import io.seata.sqlparser.util.JdbcConstants;

/**
 * Operate recognizer holder for PolarDB-X
 *
 * @author hsien999
 */
@LoadLevel(name = JdbcConstants.POLARDBX)
public class PolarDBXOperateRecognizerHolder implements SQLOperateRecognizerHolder {
    @Override
    public SQLRecognizer getDeleteRecognizer(String sql, SQLStatement ast) {
        return new PolarDBXDeleteRecognizer(sql, ast);
    }

    @Override
    public SQLRecognizer getInsertRecognizer(String sql, SQLStatement ast) {
        return new PolarDBXInsertRecognizer(sql, ast);
    }

    @Override
    public SQLRecognizer getUpdateRecognizer(String sql, SQLStatement ast) {
        return new PolarDBXUpdateRecognizer(sql, ast);
    }

    @Override
    public SQLRecognizer getSelectForUpdateRecognizer(String sql, SQLStatement ast) {
        if (((SQLSelectStatement) ast).getSelect().getFirstQueryBlock().isForUpdate()) {
            return new PolarDBXSelectForUpdateRecognizer(sql, ast);
        }
        return null;
    }
}
