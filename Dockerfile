FROM azul/zulu-openjdk-alpine:17-jre-headless
COPY build/libs/example-*-all.jar example.jar
EXPOSE 8080
CMD java -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -Dcom.sun.management.jmxremote -noverify ${JAVA_OPTS} -jar example.jar