package com.datastax.devWorkshop.nativeDriver;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;

import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        // Create the CqlSession object:
        try (CqlSession session = CqlSession.builder()
                .withCloudSecureConnectBundle(Paths.get("secure-connect-burberry.zip"))
                .withAuthCredentials("zDSDEtINqTMFYmAgWrmrHwyB","3_R.wcQAf7vKbLZ-Z4yhCdRben-D88mDiXbBLC.zS2TdOGz-hFQjrz8Fs1wW7+k.PwAD2_GMpxFs7y1h660586lZFlGt63LtHza3hqgjqL+14iQQr8GK-Q.UnA0T,jvA")
                .build()) {
            // Select the release_version from the system.local table:
            ResultSet rs = session.execute("select * from test.rockstar");
            Row row = rs.one();
            //Print the results of the CQL query to the console:
            if (row != null) {
                System.out.println(row.getFormattedContents());
            } else {
                System.out.println("An error occurred.");
            }
        }
        System.exit(0);
    }
}