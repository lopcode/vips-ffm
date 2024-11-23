FROM debian:12.1-slim
ENV JAVA_HOME=/opt/java/openjdk
COPY --from=eclipse-temurin:22 $JAVA_HOME $JAVA_HOME
ENV PATH="${JAVA_HOME}/bin:${PATH}"

COPY sample /opt/sample
COPY run_samples.sh /opt/run_samples.sh

RUN apt update && apt install libvips-dev -y

WORKDIR /opt
CMD ./run_samples.sh