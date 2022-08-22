/*
 * Copyright 2017 original authors
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package example;

import io.micronaut.runtime.Micronaut;

/**
 * @author Graeme Rocher
 * @since 1.0
 */
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;
import io.swagger.v3.oas.annotations.tags.*;
import io.swagger.v3.oas.annotations.servers.*;
import io.swagger.v3.oas.annotations.security.*;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;


/**
 * @author graemerocher
 * @since 1.0
 */
@OpenAPIDefinition(
        info = @Info(
                title       = "Hello World",
                version     = "1.0",
                description = "API",
                license     = @License(name = "Apache 2.0", url = "http://foo.bar"),
                contact     = @Contact(url = "http://gigantic-server.com", name = "Fred", email = "Fred@gigagantic-server.com")
        ),
        tags = {
                @Tag(name = "Tag 1", description = "desc 1", externalDocs = @ExternalDocumentation(description = "docs desc")),
                @Tag(name = "Tag 2", description = "desc 2", externalDocs = @ExternalDocumentation(description = "docs desc 2")),
                @Tag(name = "Tag 3")
        },
        externalDocs = @ExternalDocumentation(description = "definition docs desc"),
        security = {
                @SecurityRequirement(name = "req 1", scopes = {"a", "b"}),
                @SecurityRequirement(name = "req 2", scopes = {"b", "c"})
        },
        servers = {
                @Server(
                        description = "server 1",
                        url = "http://foo",
                        variables = {
                                @ServerVariable(name = "var1", description = "var 1", defaultValue = "1", allowableValues = {"1", "2"}),
                                @ServerVariable(name = "var2", description = "var 2", defaultValue = "1", allowableValues = {"1", "2"})
                        })
        }
)
public class Application {
    private static final RuntimeMXBean RUNTIME_MX_BEAN = ManagementFactory.getRuntimeMXBean();
    private static final long          NOW             = System.currentTimeMillis();


    public static void main(String[] args) {
        System.out.println("---------- Example ------------------");
        System.out.println("JVM Vendor : " + RUNTIME_MX_BEAN.getVmVendor());
        System.out.println("JVM Name   : " + RUNTIME_MX_BEAN.getVmName());
        System.out.println("JVM Version: " + RUNTIME_MX_BEAN.getVmVersion());
        System.out.println("Start time : " + (NOW - RUNTIME_MX_BEAN.getStartTime()) + "ms");
        System.out.println("Uptime     : " + RUNTIME_MX_BEAN.getUptime()+ "ms");
        Micronaut.run(Application.class);
        System.out.println("Ready      : " + (System.currentTimeMillis() - NOW) + "ms");
    }
}
