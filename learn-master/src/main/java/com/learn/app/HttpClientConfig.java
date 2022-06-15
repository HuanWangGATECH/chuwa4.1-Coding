package com.learn.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class HttpClientConfig {

    // Determines the timeout in milliseconds until a connection is established.
    private static final int CONNECT_TIMEOUT = 500;

    // The timeout when requesting a connection from the connection manager.
    private static final int REQUEST_TIMEOUT = 3000;

    // The timeout for waiting for data
    private static final int SOCKET_TIMEOUT = 300;

    //max number of connections
    private static final int MAX_TOTAL_CONNECTIONS = 10;


}
