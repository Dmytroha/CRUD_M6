package org.example.migrationservice;
import org.flywaydb.core.Flyway;
public class FlywayDbMigration {
    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:h2:file:./crud_migration_m6", "sa", null)
                .load();

        // Start the migration
        flyway.migrate();

    }
}
