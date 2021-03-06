import com.speedment.config.parameters.*

name = "speedment_stat";
packageLocation = "src/main/java";
packageName = "com.speedment.beacon";
enabled = true;
dbms {
    ipAddress = "127.0.0.1";
    name = "db0";
    port = 3306;
    username = "beacon";
    typeName = "MySQL";
    enabled = true;
    schema {
        columnCompressionType = ColumnCompressionType.NONE;
        fieldStorageType = FieldStorageType.WRAPPER;
        name = "speedment_stat";
        schemaName = "speedment_stat";
        storageEngineType = StorageEngineType.ON_HEAP;
        defaultSchema = false;
        enabled = true;
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "TRIGGERLOG";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "TRIGGERLOG";
            enabled = false;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.LongIdentityMapper.class;
                name = "ID";
                autoincrement = true;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.TimestampIdentityMapper.class;
                name = "CTIME";
                autoincrement = false;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.ByteIdentityMapper.class;
                name = "TYPE_CODE";
                autoincrement = false;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "SCHEMA_NAME";
                autoincrement = false;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "TABLE_NAME";
                autoincrement = false;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "PRIMARYKEY0";
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "PRIMARYKEY1";
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "PRIMARYKEY2";
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "PRIMARYKEY3";
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "PRIMARYKEY4";
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "PRIMARYKEY5";
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "CLIENT_NAME";
                autoincrement = false;
                enabled = true;
                nullable = false;
            }
            primaryKeyColumn {
                name = "ID";
                enabled = true;
            }
            index {
                name = "PRIMARY";
                enabled = true;
                unique = true;
                indexColumn {
                    name = "ID";
                    orderType = OrderType.ASC;
                    enabled = true;
                }
            }
            index {
                name = "index_schema";
                enabled = true;
                unique = false;
                indexColumn {
                    name = "SCHEMA_NAME";
                    orderType = OrderType.ASC;
                    enabled = true;
                }
            }
            index {
                name = "index_table";
                enabled = true;
                unique = false;
                indexColumn {
                    name = "TABLE_NAME";
                    orderType = OrderType.ASC;
                    enabled = true;
                }
            }
        }
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "beacon";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "beacon";
            enabled = true;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.LongIdentityMapper.class;
                name = "id";
                autoincrement = true;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.TimestampIdentityMapper.class;
                name = "created";
                autoincrement = false;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "ipAddress";
                autoincrement = false;
                enabled = true;
                nullable = false;
            }
            primaryKeyColumn {
                name = "id";
                enabled = true;
            }
            index {
                name = "PRIMARY";
                enabled = true;
                unique = true;
                indexColumn {
                    name = "id";
                    orderType = OrderType.ASC;
                    enabled = true;
                }
            }
            index {
                name = "created";
                enabled = true;
                unique = false;
                indexColumn {
                    name = "created";
                    orderType = OrderType.ASC;
                    enabled = true;
                }
            }
        }
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "beacon_property";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "beacon_property";
            enabled = true;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.LongIdentityMapper.class;
                name = "beacon";
                autoincrement = false;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                name = "key";
                autoincrement = false;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "value";
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            primaryKeyColumn {
                name = "beacon";
                enabled = true;
            }
            primaryKeyColumn {
                name = "key";
                enabled = true;
            }
            index {
                name = "PRIMARY";
                enabled = true;
                unique = true;
                indexColumn {
                    name = "beacon";
                    orderType = OrderType.ASC;
                    enabled = true;
                }
                indexColumn {
                    name = "key";
                    orderType = OrderType.ASC;
                    enabled = true;
                }
            }
            index {
                name = "beacon";
                enabled = true;
                unique = false;
                indexColumn {
                    name = "beacon";
                    orderType = OrderType.ASC;
                    enabled = true;
                }
            }
            index {
                name = "key";
                enabled = true;
                unique = false;
                indexColumn {
                    name = "key";
                    orderType = OrderType.ASC;
                    enabled = true;
                }
            }
            foreignKey {
                name = "FK_beacon";
                enabled = true;
                foreignKeyColumn {
                    foreignColumnName = "id";
                    foreignTableName = "beacon";
                    name = "beacon";
                    enabled = true;
                }
            }
            foreignKey {
                name = "FK_beacon_property_key";
                enabled = true;
                foreignKeyColumn {
                    foreignColumnName = "id";
                    foreignTableName = "beacon_property_key";
                    name = "key";
                    enabled = true;
                }
            }
        }
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "beacon_property_key";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "beacon_property_key";
            enabled = true;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                name = "id";
                autoincrement = true;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "key";
                autoincrement = false;
                enabled = true;
                nullable = false;
            }
            primaryKeyColumn {
                name = "id";
                enabled = true;
            }
            index {
                name = "PRIMARY";
                enabled = true;
                unique = true;
                indexColumn {
                    name = "id";
                    orderType = OrderType.ASC;
                    enabled = true;
                }
            }
            index {
                name = "key";
                enabled = true;
                unique = true;
                indexColumn {
                    name = "key";
                    orderType = OrderType.ASC;
                    enabled = true;
                }
            }
        }
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "frontend";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "frontend";
            enabled = true;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.LongIdentityMapper.class;
                name = "id";
                autoincrement = true;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "regId";
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "first_name";
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "last_name";
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "email";
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "organization";
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "country";
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "phone";
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "version";
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "coreFullVersion";
                autoincrement = false;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.TimestampIdentityMapper.class;
                name = "created";
                autoincrement = false;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "ipAddress";
                autoincrement = false;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "ipAddressName";
                autoincrement = false;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                name = "remotePort";
                autoincrement = false;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "comment";
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            primaryKeyColumn {
                name = "id";
                enabled = true;
            }
            index {
                name = "Index_created";
                enabled = true;
                unique = false;
                indexColumn {
                    name = "created";
                    orderType = OrderType.ASC;
                    enabled = true;
                }
            }
            index {
                name = "Index_random";
                enabled = true;
                unique = false;
                indexColumn {
                    name = "regId";
                    orderType = OrderType.ASC;
                    enabled = true;
                }
            }
            index {
                name = "PRIMARY";
                enabled = true;
                unique = true;
                indexColumn {
                    name = "id";
                    orderType = OrderType.ASC;
                    enabled = true;
                }
            }
        }
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "message";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "message";
            enabled = true;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.LongIdentityMapper.class;
                name = "id";
                autoincrement = true;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.TimestampIdentityMapper.class;
                name = "created";
                autoincrement = false;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "ipAddress";
                autoincrement = false;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "ipAddressName";
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                name = "remotePort";
                autoincrement = false;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "gui";
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "coreFullVersion";
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "sessionId";
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "version";
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "type";
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "regId";
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            primaryKeyColumn {
                name = "id";
                enabled = true;
            }
            index {
                name = "Index_type";
                enabled = true;
                unique = false;
                indexColumn {
                    name = "type";
                    orderType = OrderType.ASC;
                    enabled = true;
                }
            }
            index {
                name = "PRIMARY";
                enabled = true;
                unique = true;
                indexColumn {
                    name = "id";
                    orderType = OrderType.ASC;
                    enabled = true;
                }
            }
        }
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "message_item";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "message_item";
            enabled = true;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.LongIdentityMapper.class;
                name = "id";
                autoincrement = true;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.LongIdentityMapper.class;
                name = "message";
                autoincrement = false;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "key";
                autoincrement = false;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "value";
                autoincrement = false;
                enabled = true;
                nullable = false;
            }
            primaryKeyColumn {
                name = "id";
                enabled = true;
            }
            index {
                name = "FK_message_item_1";
                enabled = true;
                unique = false;
                indexColumn {
                    name = "message";
                    orderType = OrderType.ASC;
                    enabled = true;
                }
            }
            index {
                name = "Index_key";
                enabled = true;
                unique = false;
                indexColumn {
                    name = "key";
                    orderType = OrderType.ASC;
                    enabled = true;
                }
            }
            index {
                name = "PRIMARY";
                enabled = true;
                unique = true;
                indexColumn {
                    name = "id";
                    orderType = OrderType.ASC;
                    enabled = true;
                }
            }
            foreignKey {
                name = "FK_message_item_1";
                enabled = true;
                foreignKeyColumn {
                    foreignColumnName = "id";
                    foreignTableName = "message";
                    name = "message";
                    enabled = true;
                }
            }
        }
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "report";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "report";
            enabled = true;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                name = "id";
                autoincrement = true;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "title";
                autoincrement = false;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "sql";
                autoincrement = false;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "chartUrl";
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                name = "listOrder";
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            primaryKeyColumn {
                name = "id";
                enabled = true;
            }
            index {
                name = "PRIMARY";
                enabled = true;
                unique = true;
                indexColumn {
                    name = "id";
                    orderType = OrderType.ASC;
                    enabled = true;
                }
            }
        }
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "usage";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "usage";
            enabled = true;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                name = "id";
                autoincrement = true;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "site";
                autoincrement = false;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                name = "artifact";
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.TimestampIdentityMapper.class;
                name = "timeStamp";
                autoincrement = false;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                name = "count";
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            primaryKeyColumn {
                name = "id";
                enabled = true;
            }
            index {
                name = "PRIMARY";
                enabled = true;
                unique = true;
                indexColumn {
                    name = "id";
                    orderType = OrderType.ASC;
                    enabled = true;
                }
            }
        }
    }
}