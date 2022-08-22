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
import io.swagger.v3.oas.annotations.OpenAPIDefinition;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;


@OpenAPIDefinition()
public class Application {
    private static final RuntimeMXBean RUNTIME_MX_BEAN = ManagementFactory.getRuntimeMXBean();
    private static final long          NOW             = System.currentTimeMillis();


    /**
     * Build:
     * ./gradlew clean build
     *
     * Start up:
     *  java -jar build/libs/example-1.0-all.jar (Interpreter + Tiered Compiliation (C1 + C2))
     *   java -Xint -jar build/libs/example-1.0-all.jar (Interpreter only)
     *  java -Xverify:none -XX:TieredStopAtLevel=1 -jar build/libs/example-1.0-all.jar (No bytecode verification and only C1 compiler)
     *
     * @param args
     */
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
